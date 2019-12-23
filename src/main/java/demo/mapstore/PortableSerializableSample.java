package demo.mapstore;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MapStoreConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.hazelcast.nio.serialization.Portable;
import com.hazelcast.nio.serialization.PortableFactory;
import com.hazelcast.nio.serialization.PortableReader;
import com.hazelcast.nio.serialization.PortableWriter;
import com.hazelcast.query.Predicate;
import com.hazelcast.query.Predicates;

import java.io.IOException;
import java.util.Collection;

public class PortableSerializableSample {

    public static void main(String[] args) {
        Config config = new Config();

        // enable management centerx
        config.getManagementCenterConfig().setEnabled(true);
        config.getManagementCenterConfig().setUrl("http://localhost:8080/hazelcast-mancenter");

        // custom serializer
        config.getSerializationConfig()
                .addPortableFactory(SamplePortableFactory.FACTORY_ID, new SamplePortableFactory());

        // custom map store
        String mapName = Navigable_Waterway.class.getCanonicalName();
        MySQLMapStore mysqlStore = new MySQLMapStore("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/dev", "dev", "password", "Navigable_Waterway_Lines", Navigable_Waterway.class);
        MapStoreConfig mapStoreConfig = new MapStoreConfig();
        mapStoreConfig.setImplementation(mysqlStore);
        mapStoreConfig.setWriteDelaySeconds(0);
        mapStoreConfig.setInitialLoadMode(MapStoreConfig.InitialLoadMode.LAZY);
        MapConfig mapConfig = config.getMapConfig(mapName);
        //mapConfig.addMapIndexConfig(new MapIndexConfig("STATE", true));
        mapConfig.setMapStoreConfig(mapStoreConfig);

        // Start the Embedded Hazelcast Cluster Member.
        HazelcastInstance hz = Hazelcast.newHazelcastInstance(config);
        HazelcastInstance hz2 = Hazelcast.newHazelcastInstance(config);
        //HazelcastInstance hz3 = Hazelcast.newHazelcastInstance(config);

        //Navigable_Waterway can be used here
        IMap<String, Navigable_Waterway> map = hz.getMap(mapName);

        // query example
        Predicate criteriaQuery = Predicates.equal("STATE","GA");
        Collection<Navigable_Waterway> results = map.values(criteriaQuery);
        for(Navigable_Waterway item : results){
            String search = item.RIVERNAME.replace(" ","+");
            System.out.println(item.OBJECTID+" = "+item.RIVERNAME+" https://www.google.com/maps/place/"+search);
        }

        Navigable_Waterway myNewWaterway = new Navigable_Waterway();
        myNewWaterway.ID="8675301";
        myNewWaterway.LENGTH="123123";
            myNewWaterway.DIR="123123";
            myNewWaterway.LINKNUM="123123";
            myNewWaterway.ANODE="123123";
            myNewWaterway.BNODE="123123";
            myNewWaterway.LINKNAME="123123";
            myNewWaterway.RIVERNAME="Terrys River From Too Much Rain";
            myNewWaterway.AMILE="123123";
            myNewWaterway.BMILE="123123";
            myNewWaterway.LENGTH1="123123";
            myNewWaterway.LENGTH_SRC="123123";
            myNewWaterway.SHAPE_SRC="123123";
            myNewWaterway.LINKTYPE="123123";
            myNewWaterway.CTRL_DEPTH="123123";
            myNewWaterway.WATERWAY="123123";
            myNewWaterway.GEO_CLASS="123123";
            myNewWaterway.FUNC_CLASS="123123";
            myNewWaterway.WTWY_TYPE="123123";
            myNewWaterway.CHART_ID="123123";
            myNewWaterway.NUM_PAIRS="123123";
            myNewWaterway.WHO_MOD="123123";
            myNewWaterway.DATE_MOD="123123";
            myNewWaterway.HEADING="123123";
            myNewWaterway.STATE="GA";
            myNewWaterway.FIPS="123123";
            myNewWaterway.FIPS2="123123";
            myNewWaterway.NON_US="123123";
            myNewWaterway.Shape_Length="123123";

            map.put("8675301",myNewWaterway);

        System.out.println(mapName+": "+map.size()+" map entries");

        // airport stuff
        //IMap<String,String> airports = hz.getMap("airports");
        //String airport = airports.get("1212");
        //System.out.println(airport);

        //hz.shutdown();
        //hz2.shutdown();
        //hz3.shutdown();
    }

    public static class Navigable_Waterway implements Portable {
        public static final int CLASS_ID = 1;

        public String OBJECTID;
        public String ID;
        public String LENGTH;
        public String DIR;
        public String LINKNUM;
        public String ANODE;
        public String BNODE;
        public String LINKNAME;
        public String RIVERNAME;
        public String AMILE;
        public String BMILE;
        public String LENGTH1;
        public String LENGTH_SRC;
        public String SHAPE_SRC;
        public String LINKTYPE;
        public String CTRL_DEPTH;
        public String WATERWAY;
        public String GEO_CLASS;
        public String FUNC_CLASS;
        public String WTWY_TYPE;
        public String CHART_ID;
        public String NUM_PAIRS;
        public String WHO_MOD;
        public String DATE_MOD;
        public String HEADING;
        public String STATE;
        public String FIPS;
        public String FIPS2;
        public String NON_US;
        public String Shape_Length;

        @Override
        public int getFactoryId() {
            return SamplePortableFactory.FACTORY_ID;
        }

        @Override
        public int getClassId() {
            return CLASS_ID;
        }

        @Override
        public void writePortable(PortableWriter writer) throws IOException {
            writer.writeUTF("OBJECTID", OBJECTID);
            writer.writeUTF("ID",ID);
            writer.writeUTF("LENGTH",LENGTH);
            writer.writeUTF("DIR",DIR);
            writer.writeUTF("LINKNUM",LINKNUM);
            writer.writeUTF("ANODE",ANODE);
            writer.writeUTF("BNODE",BNODE);
            writer.writeUTF("LINKNAME",LINKNAME);
            writer.writeUTF("RIVERNAME",RIVERNAME);
            writer.writeUTF("AMILE",AMILE);
            writer.writeUTF("BMILE",BMILE);
            writer.writeUTF("LENGTH1",LENGTH1);
            writer.writeUTF("LENGTH_SRC",LENGTH_SRC);
            writer.writeUTF("SHAPE_SRC",SHAPE_SRC);
            writer.writeUTF("LINKTYPE",LINKTYPE);
            writer.writeUTF("CTRL_DEPTH",CTRL_DEPTH);
            writer.writeUTF("WATERWAY",WATERWAY);
            writer.writeUTF("GEO_CLASS",GEO_CLASS);
            writer.writeUTF("FUNC_CLASS",FUNC_CLASS);
            writer.writeUTF("WTWY_TYPE",WTWY_TYPE);
            writer.writeUTF("CHART_ID",CHART_ID);
            writer.writeUTF("NUM_PAIRS",NUM_PAIRS);
            writer.writeUTF("WHO_MOD",WHO_MOD);
            writer.writeUTF("DATE_MOD",DATE_MOD);
            writer.writeUTF("HEADING",HEADING);
            writer.writeUTF("STATE",STATE);
            writer.writeUTF("FIPS",FIPS);
            writer.writeUTF("FIPS2",FIPS2);
            writer.writeUTF("NON_US",NON_US);
            writer.writeUTF("Shape_Length",Shape_Length);
        }

        @Override
        public void readPortable(PortableReader reader) throws IOException {
            OBJECTID = reader.readUTF("OBJECTID");
            ID = reader.readUTF("ID");
            LENGTH = reader.readUTF("LENGTH");
            DIR = reader.readUTF("DIR");
            LINKNUM = reader.readUTF("LINKNUM");
            ANODE = reader.readUTF("ANODE");
            BNODE = reader.readUTF("BNODE");
            LINKNAME = reader.readUTF("LINKNAME");
            RIVERNAME = reader.readUTF("RIVERNAME");
            AMILE = reader.readUTF("AMILE");
            BMILE = reader.readUTF("BMILE");
            LENGTH1 = reader.readUTF("LENGTH1");
            LENGTH_SRC = reader.readUTF("LENGTH_SRC");
            SHAPE_SRC = reader.readUTF("SHAPE_SRC");
            LINKTYPE = reader.readUTF("LINKTYPE");
            CTRL_DEPTH = reader.readUTF("CTRL_DEPTH");
            WATERWAY = reader.readUTF("WATERWAY");
            GEO_CLASS = reader.readUTF("GEO_CLASS");
            FUNC_CLASS = reader.readUTF("FUNC_CLASS");
            WTWY_TYPE = reader.readUTF("WTWY_TYPE");
            CHART_ID = reader.readUTF("CHART_ID");
            NUM_PAIRS = reader.readUTF("NUM_PAIRS");
            WHO_MOD = reader.readUTF("WHO_MOD");
            DATE_MOD = reader.readUTF("DATE_MOD");
            HEADING = reader.readUTF("HEADING");
            STATE = reader.readUTF("STATE");
            FIPS = reader.readUTF("FIPS");
            FIPS2 = reader.readUTF("FIPS2");
            NON_US = reader.readUTF("NON_US");
            Shape_Length = reader.readUTF("Shape_Length");
        }
    }

    public static class SamplePortableFactory implements PortableFactory {

        public static final int FACTORY_ID = 1;

        @Override
        public Portable create(int classId) {
            if (classId == Navigable_Waterway.CLASS_ID) {
                return new Navigable_Waterway();
            }
            return null;
        }
    }


}