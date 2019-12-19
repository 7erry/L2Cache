# L2Cache
A simple L2 Cache example using jdbc as the SoR


Source Data:
http://osav-usdot.opendata.arcgis.com/datasets?keyword=Water
http://osav-usdot.opendata.arcgis.com/datasets/c91bc22014744f9389488f8ca203b4d4_0.csv

Schema for :<br />
mysql> describe Navigable_Waterway_Lines;<br />
Connection id:    15172<br />
Current database: dev<br />
<br />
+--------------+--------------+------+-----+---------+-------+<br />
| Field        | Type         | Null | Key | Default | Extra |<br />
+--------------+--------------+------+-----+---------+-------+<br />
| OBJECTID     | varchar(255) | NO   | PRI | NULL    |       |<br />
| ID           | varchar(255) | YES  |     | NULL    |       |<br />
| LENGTH       | varchar(255) | YES  |     | NULL    |       |<br />
| DIR          | varchar(255) | YES  |     | NULL    |       |<br />
| LINKNUM      | varchar(255) | YES  |     | NULL    |       |<br />
| ANODE        | varchar(255) | YES  |     | NULL    |       |<br />
| BNODE        | varchar(255) | YES  |     | NULL    |       |<br />
| LINKNAME     | varchar(255) | YES  |     | NULL    |       |<br />
| RIVERNAME    | varchar(255) | YES  |     | NULL    |       |<br />
| AMILE        | varchar(255) | YES  |     | NULL    |       |<br />
| BMILE        | varchar(255) | YES  |     | NULL    |       |<br />
| LENGTH1      | varchar(255) | YES  |     | NULL    |       |<br />
| LENGTH_SRC   | varchar(255) | YES  |     | NULL    |       |<br />
| SHAPE_SRC    | varchar(255) | YES  |     | NULL    |       |<br />
| LINKTYPE     | varchar(255) | YES  |     | NULL    |       |<br />
| CTRL_DEPTH   | varchar(255) | YES  |     | NULL    |       |<br />
| WATERWAY     | varchar(255) | YES  |     | NULL    |       |<br />
| GEO_CLASS    | varchar(255) | YES  |     | NULL    |       |<br />
| FUNC_CLASS   | varchar(255) | YES  |     | NULL    |       |<br />
| WTWY_TYPE    | varchar(255) | YES  |     | NULL    |       |<br />
| CHART_ID     | varchar(255) | YES  |     | NULL    |       |<br />
| NUM_PAIRS    | varchar(255) | YES  |     | NULL    |       |<br />
| WHO_MOD      | varchar(255) | YES  |     | NULL    |       |<br />
| DATE_MOD     | varchar(255) | YES  |     | NULL    |       |<br />
| HEADING      | varchar(255) | YES  |     | NULL    |       |<br />
| STATE        | varchar(255) | YES  |     | NULL    |       |<br />
| FIPS         | varchar(255) | YES  |     | NULL    |       |<br />
| FIPS2        | varchar(255) | YES  |     | NULL    |       |<br />
| NON_US       | varchar(255) | YES  |     | NULL    |       |<br />
| Shape_Length | varchar(255) | YES  |     | NULL    |       |<br />
+--------------+--------------+------+-----+---------+-------+<br />
30 rows in set (0.27 sec)<br />
<br />
Importing CSV into MySQL:<br />
mysql -u dev -p -h192.168.86.182<br />
<br />
simple way to generate the alter table commands for a list of field names:
for val in BNODE LINKNAME RIVERNAME AMILE BMILE LENGTH1 LENGTH_SRC SHAPE_SRC LINKTYPE CTRL_DEPTH WATERWAY GEO_CLASS FUNC_CLASS WTWY_TYPE CHART_ID NUM_PAIRS WHO_MOD DATE_MOD HEADING STATE FIPS FIPS2 NON_US Shape_Length; do
    echo "ALTER TABLE Navigable_Waterway_Lines ADD COLUMN "$val" VARCHAR(255);"
done

using the mysqlimport tool:
mysqlimport --ignore-lines=1 --fields-terminated-by=, --verbose --local -u dev -p dev -h192.168.86.182 ./Navigable_Waterway_Lines.csv


Now that you should have the Navigable_Waterway_Lines table populated we can use the Map Store interface to connect to it:
public class MySQLMapStore implements MapStore<String, PortableSerializableSample.Navigable_Waterway> 

public class PortableSerializableSample 
I started with the PortableSerializableSample directly from hazelcast.org 
The database connection parameters are located around line 34 and look like the following:
MySQLMapStore mysqlStore = new MySQLMapStore("com.mysql.jdbc.Driver","jdbc:mysql://localhost:3306/dev", "dev", "password", "Navigable_Waterway_Lines", Navigable_Waterway.class);
<br />
I added Navigable_Waterway to represent the database schema in pojo form.
<br />
You can run this via an IDE such as I use IntelliJ Ultimate 2019.2 or from the command line as in the following:
<br />
>mvn clean package<br />
>java -jar target/mapstore-1.0-SNAPSHOT-jar-with-dependencies.jar <br />
<br />
So you'll notice a query example that uses a simple predicate to locate all the rivers for the state of GA.
The output will then attempt to create a google maps link that will allow you to view the location.
That's it.

Your output should look like the following:
...
SimpleStore - loading all keys
3174 = SKIDAWAY RIVER https://www.google.com/maps/place/SKIDAWAY+RIVER
3116 = EAST RIVER https://www.google.com/maps/place/EAST+RIVER
3171 = ALTANTIC DEEP WATER ACCESS https://www.google.com/maps/place/ALTANTIC+DEEP+WATER+ACCESS
3182 = WILMINGTON RIVER https://www.google.com/maps/place/WILMINGTON+RIVER
3115 = BRUNSWICK RIVER https://www.google.com/maps/place/BRUNSWICK+RIVER
2896 = SAVANNAH RIVER https://www.google.com/maps/place/SAVANNAH+RIVER
3170 = WASSAW SOUND https://www.google.com/maps/place/WASSAW+SOUND
demo.mapstore.PortableSerializableSample.Navigable_Waterway: 6873 map entries




