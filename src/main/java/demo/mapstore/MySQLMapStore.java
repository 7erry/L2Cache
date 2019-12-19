package demo.mapstore;
/*
 * Copyright (c) 2008-2018, Hazelcast, Inc. All Rights Reserved.
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


import com.hazelcast.core.MapStore;

import java.sql.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class MySQLMapStore implements MapStore<String, PortableSerializableSample.Navigable_Waterway> {

    private ConcurrentMap<Integer, PortableSerializableSample.Navigable_Waterway> store = new ConcurrentHashMap<>();
    private Connection con;
    private Statement stmt;

    public MySQLMapStore(String driver, String url, String name, String password, String table, Class<PortableSerializableSample.Navigable_Waterway> navigable_waterwayClass) {
        try{
            //Class.forName(driver);
            con = DriverManager.getConnection(url,name,password);
            stmt=con.createStatement();

            // test connection
            ResultSet rs=stmt.executeQuery("select count(*) from Navigable_Waterway_Lines");
            while(rs.next())
                System.out.println("Count of Navigable_Waterway_Lines:\t"+rs.getInt(1));
            //con.close();
        }catch(Exception e){ System.out.println(e);}
    }

    @Override
        public void store(String key, PortableSerializableSample.Navigable_Waterway value) {
            System.out.println("SimpleStore - storing key: " + key);

            /**
             * place insert statement here
             * **/
            //store.put(key, value);
        }

        @Override
        public void storeAll(Map<String, PortableSerializableSample.Navigable_Waterway> map) {
            Set<Map.Entry<String, PortableSerializableSample.Navigable_Waterway>> entrySet = map.entrySet();
            for (Map.Entry<String, PortableSerializableSample.Navigable_Waterway> entry : entrySet) {
                String key = entry.getKey();
                PortableSerializableSample.Navigable_Waterway value = entry.getValue();
                store(key, value);
            }
        }

        @Override
        public void delete(String key) {
            System.out.println("SimpleStore - deleting key: " + key);
            store.remove(key);
        }

        @Override
        public void deleteAll(Collection<String> keys) {
            for (String key : keys) {
                delete(key);
            }
        }

        @Override
        public PortableSerializableSample.Navigable_Waterway load(String key) {
            //System.out.println("SimpleStore - loading value for key: " + key);
            PortableSerializableSample.Navigable_Waterway result = new PortableSerializableSample.Navigable_Waterway();
            try{
                String query = "select * from Navigable_Waterway_Lines where OBJECTID="+key;
                stmt.execute(query);
                ResultSet rs = stmt.getResultSet();
                if (rs.next()){
                    result.OBJECTID = safeGet(rs,1);
                    result.ID = safeGet(rs,2);
                    result.LENGTH = rs.getString(3);
                    result.DIR = rs.getString(4);
                    result.LINKNUM = rs.getString(5);
                    result.ANODE = rs.getString(6);
                    result.BNODE = rs.getString(7);
                    result.LINKNAME = rs.getString(8);
                    result.RIVERNAME = rs.getString(9);
                    result.AMILE = rs.getString(10);
                    result.BMILE = rs.getString(11);
                    result.LENGTH1 = rs.getString(12);
                    result.LENGTH_SRC = rs.getString(13);
                    result.SHAPE_SRC = rs.getString(14);
                    result.LINKTYPE = rs.getString(15);
                    result.CTRL_DEPTH = rs.getString(16);
                    result.WATERWAY = rs.getString(17);
                    result.GEO_CLASS = rs.getString(18);
                    result.FUNC_CLASS = rs.getString(19);
                    result.WTWY_TYPE = rs.getString(20);
                    result.CHART_ID = rs.getString(21);
                    result.NUM_PAIRS = rs.getString(22);
                    result.WHO_MOD = rs.getString(23);
                    result.DATE_MOD = rs.getString(24);
                    result.HEADING = rs.getString(25);
                    result.STATE = rs.getString(26);
                    result.FIPS = rs.getString(27);
                    result.FIPS2 = rs.getString(28);
                    result.NON_US = rs.getString(29);
                    result.Shape_Length = rs.getString(30);
                }
            }catch (SQLException e) {
                //e.printStackTrace();
            }catch (Exception e) {
                //e.printStackTrace();
            }
            return result;
        }

        private String safeGet(ResultSet rs, int column){
            String tmp = "";
            try {
                if(rs != null)
                tmp = rs.getString(column);
            } catch (SQLException e) {
            }
            return tmp;
        }

            @Override
        public Map<String, PortableSerializableSample.Navigable_Waterway> loadAll(Collection<String> keys) {
            Map<String, PortableSerializableSample.Navigable_Waterway> map = new HashMap<String, PortableSerializableSample.Navigable_Waterway>();
            for (String key : keys) {
                PortableSerializableSample.Navigable_Waterway value = load(key);
                map.put(key, value);
            }
            return map;
        }

        @Override
        public Set<String> loadAllKeys() {
            System.out.println("SimpleStore - loading all keys");
            Set<String> keys = new HashSet<>();
            try{
                ResultSet rs=stmt.executeQuery("select OBJECTID from Navigable_Waterway_Lines");
                while(rs.next())
                    keys.add(rs.getString(1));

            }catch (Exception e){
                e.printStackTrace();
            }

            return keys;
        }
    }