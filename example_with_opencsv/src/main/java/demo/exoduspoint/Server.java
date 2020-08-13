package demo.exoduspoint;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import com.hazelcast.config.MapIndexConfig;
import com.hazelcast.config.MapStoreConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import demo.exoduspoint.beans.SecMasterBean;
import demo.exoduspoint.mapstore.MySQLMapStore;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

/**
 * Server
 * Embedded Hazelcast Server demonstrating L2Cache
 */
public class Server {
    static String MAPNAME = SecMasterBean.class.getCanonicalName();

    public static void main(String[] args) throws NoSuchMethodException, IOException, IllegalAccessException, InvocationTargetException {
        // Start the Embedded Hazelcast Cluster Member.
        HazelcastInstance hz = Hazelcast.newHazelcastInstance(getConfig());

//        // Test L2 Cache
        IMap<String, SecMasterBean> map = hz.getMap(MAPNAME);
        System.out.println("Map Name:\t"+MAPNAME);
        System.out.println("Map Size:\t"+map.size());


    }

    /**
     * Server Configuration
     * @return
     */
    public static Config getConfig(){
        // server setup
        Config config = new Config();
        // enable management center
        config.getManagementCenterConfig().setEnabled(true);
        config.getManagementCenterConfig().setUrl("http://localhost:8080/hazelcast-mancenter");

        // enable enterprise
        config.setLicenseKey(System.getProperty("key"));

        // enable tcp discovery
        config.getNetworkConfig().getJoin().getMulticastConfig().setEnabled(false);
        config.getNetworkConfig().getJoin().getTcpIpConfig().setEnabled(true);
        config.getNetworkConfig().getJoin().getTcpIpConfig().addMember("localhost:5701");

        // custom serializer
        config.getSerializationConfig()
                .addPortableFactory(SecMasterBean.SecMasterPortableFactory.FACTORY_ID, new SecMasterBean.SecMasterPortableFactory());

        // custom map store for SecMaster
        String mapName = SecMasterBean.class.getCanonicalName();
        MySQLMapStore mysqlStore = new MySQLMapStore("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/BLOOMBERG", "root", "root", "SecMasterBean", SecMasterBean.class);
        MapStoreConfig mapStoreConfig = new MapStoreConfig();
        mapStoreConfig.setImplementation(mysqlStore);
        mapStoreConfig.setWriteDelaySeconds(0);
        mapStoreConfig.setInitialLoadMode(MapStoreConfig.InitialLoadMode.EAGER);
        MapConfig mapConfig = config.getMapConfig(mapName);
        // how to add a secondary index
        mapConfig.addMapIndexConfig(new MapIndexConfig("ID_COMMON", true));
        mapConfig.setMapStoreConfig(mapStoreConfig);

        return config;
    }



}
