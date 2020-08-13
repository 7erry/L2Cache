/*
 * Copyright (c) 2008-2020, Hazelcast, Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package demo.exoduspoint;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.*;
import com.hazelcast.query.Predicates;
import com.opencsv.CSVReader;
import demo.exoduspoint.beans.SecMasterBean;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Client
 * Demonstrating SecMasterBean using the Portable Serialization with Predicates
 */
public class Client extends SecMasterBean {

    static String MAPNAME = SecMasterBean.class.getCanonicalName();

    public static void main(String[] args) throws IOException, InvocationTargetException, IllegalAccessException, NoSuchMethodException {

        // client instance
        ClientConfig config = new ClientConfig();
        // add our serialization factory
        config.getSerializationConfig().addPortableFactory(SecMasterPortableFactory.FACTORY_ID, new SecMasterPortableFactory());

        // Instantiate Hazelcast
        HazelcastInstance hz = HazelcastClient.newHazelcastClient(config);

        System.out.println(hz.getName());

        // map interface
        IMap<String, SecMasterBean> map = hz.getMap(MAPNAME);

        // check current size and if empty add 2nd index(es)
        System.out.println(MAPNAME+".size:\t"+map.size());
        if(map.size()==0){
            System.out.println("SecMastdr Map is empty:\tAdding Index for NAME");
            // as long as there is NO data in the map we can dynamically add secondary indexes
            map.addIndex("NAME",false);
        }

        // read csv and put it into the map which puts it into the database
        processCSV(hz);

        // simple key based retrieval
        SecMasterBean bean = map.get("009718834");
        if(bean!=null) {
            System.out.println("\t" + bean.getNAME());
            System.out.println("\t" + bean.getID_EXCH_SYMBOL());
        }

        // generate some data based on the APPLE sample
        long start = System.currentTimeMillis();
        fabricateEntries(bean,map);
        System.out.println("\t\tTook:\t"+(System.currentTimeMillis()-start)+" ms");

        // recheck current size
        System.out.println(MAPNAME+".size:\t"+map.size());

        // simple update
        // mutate this bean for our regex example query
        bean.setNAME("BANANA LLC");
        // store mutated bean in map (which will be also store in the database)
        map.put(bean.getID_COMMON(),bean);

        // regular expression retrieval
        System.out.println("Regular Expression Query");
        Collection<SecMasterBean> results = map.values(Predicates.regex("NAME", "B+.*"));
        System.out.println("\tFound:\t"+results.size());
        results.forEach(result -> {
            System.out.println(result.getNAME());
        });

        start = System.currentTimeMillis();
        //performRandomReads(hz,map,1000000);
        performRandomWritess(hz,map,10000);
        System.out.println("\tTook:\t"+(System.currentTimeMillis()-start)+" ms");
        hz.shutdown();

    }



    /**
     * processCSV()
     * purpose is to demonstrate the use of the SecMasterBean to store all the values as proveded from the csv file.
     *
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     * @throws IOException
     */
    public static void processCSV(HazelcastInstance hz) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException, IOException {
        System.out.println("processCSV");
        List<List<String>> records = new ArrayList<List<String>>();
        IMap<String, SecMasterBean> map = hz.getMap(MAPNAME);

        try (CSVReader csvReader = new CSVReader(new FileReader("/Users/twal7ers/Downloads/exasol/sample.csv"));) {
            String[] values = null;
            while ((values = csvReader.readNext()) != null) {
                records.add(Arrays.asList(values));
            }

            // Bean -> L2 Cache
            SecMasterBean bean = new SecMasterBean();

            // call setters dynamically from the header record (bean elements=csv headers)
            for (int r = 1; r < records.size()-1; r++) {
                for (int f = 0; f < records.get(0).size(); f++) {
                    String field = records.get(0).get(f);
                    String value = records.get(r).get(f);
                    //System.out.println(field+" = "+value);
                    Method method = SecMasterBean.class.getMethod("set"+field,String.class);
                    method.invoke(bean, value);
                }
            }


            // sample field output
            System.out.println(bean.getID_EXCH_SYMBOL()+"\t\t"+bean.getTOTAL_VOTING_SHARES_VALUE());

            // store bean in map
            map.put(bean.getID_COMMON(),bean);
        }
    }

    public static void fabricateEntries(SecMasterBean bean, IMap map){
        System.out.println("fabricateEntries");
        // use batch operations to improve performance
        Pipelining<SecMasterBean> pipelining = new Pipelining<>(1000);

        // use this bean to manufacture data
        for (int i = 1; i < 3300; i++) {
            bean.setID_COMMON(String.valueOf(i));
            try {
                pipelining.add((ICompletableFuture<SecMasterBean>) map.putAsync(String.valueOf(i),bean));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Simple random reads based on key
     *
     * @param hz
     * @param map
     * @param reads
     */
    public static void  performRandomReads(HazelcastInstance hz, IMap map, int reads){
        System.out.println("performRandomReads:\t"+reads);
        if(map.size()==0){
            System.out.println("\tNo date");
            return;
        }

        int max = map.size();
        for (int i = 0; i < reads; i++) {
            int random_Key = (int)(Math.random() * (max - 1 + 1) + 1);
            map.get(String.valueOf(random_Key));
        }
    }

    /**
     * Simple random writes based on key
     *
     * @param hz
     * @param map
     * @param writes
     */
    public static void  performRandomWritess(HazelcastInstance hz, IMap map, int writes){
        System.out.println("performRandomWrites:\t"+writes);
        if(map.size()==0){
            System.out.println("\tNo date");
            return;
        }

        int max = map.size();
        for (int i = 0; i < writes; i++) {
            // locate a random bean
            int random_Key = (int)(Math.random() * (max - 1 + 1) + 1);
            SecMasterBean bean = (SecMasterBean) map.get(String.valueOf(random_Key));

            // mutate an element
            bean.setLINE_NUM(String.valueOf(random_Key));

            // store mutated bean
            map.put(String.valueOf(random_Key),bean);
        }
    }
}
