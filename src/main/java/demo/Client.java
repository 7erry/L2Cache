package demo;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.query.Predicates;

import java.util.Collection;
import java.util.HashMap;

public class Client {
    public static void main(String[] args) {
        //HazelcastInstance hz = Hazelcast.newHazelcastInstance();
        HazelcastInstance hz = HazelcastClient.newHazelcastClient();
        IMap<String, HashMap> map = hz.getMap("railways");
        HashMap<String, String> values = map.get("1212");
        values.forEach((k,v) ->
                System.out.println("\tkey: "+k+"\t\tvalue:"+v)
        );

        Collection<HashMap> result = map.values(Predicates.regex("values", "x+.*"));
        System.out.println(result);

        hz.shutdown();
    }

}
