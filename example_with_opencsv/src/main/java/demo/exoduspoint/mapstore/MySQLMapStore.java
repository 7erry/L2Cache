package demo.exoduspoint.mapstore;
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


import com.hazelcast.core.MapStore;
import demo.exoduspoint.Server;
import demo.exoduspoint.beans.SecMasterBean;

import java.sql.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * MySQLMapStore
 * Map Store implementation for the SecMasterBean to integrate with a MySQL Database
 */
public class MySQLMapStore extends Server implements MapStore<String, SecMasterBean> {

    private ConcurrentMap<Integer, SecMasterBean> store = new ConcurrentHashMap<>();
    private Connection con;
    private Statement stmt;

    public MySQLMapStore(String driver, String url, String name, String password, String table, Class<SecMasterBean> secMasterBeanClass) {
        try{
            //Class.forName(driver);
            con = DriverManager.getConnection(url,name,password);
            stmt=con.createStatement();

            // test connection
            ResultSet rs=stmt.executeQuery("select count(*) from BLOOMBERG_TZERO_OUT_V2");
            while(rs.next())
                System.out.println("Count of BLOOMBERG_TZERO_OUT_V2:\t"+rs.getInt(1));
            //con.close();
        }catch(Exception e){ System.out.println(e);}
    }

    @Override
        public void store(String key, SecMasterBean value) {
            //System.out.println("SimpleStore - storing key: " + key);

            String sql = "INSERT INTO BLOOMBERG_TZERO_OUT_V2 " +
                "VALUES ("+
                    "\""+value.getDDATE()+"\","+
                    "\""+value.REGION+"\","+
                    "\""+value.LINE_NUM+"\","+
                    "\""+value.ID_BB_PARSEKEY+"\","+
                    "\""+value.FLEX_ID+"\","+
                    "\""+value.UNKNOWN1+"\","+
                    "\""+value.UNKNOWN2+"\","+
                    "\""+value.TICKER+"\","+
                    "\""+value.EXCH_CODE+"\","+
                    "\""+value.NAME+"\","+
                    "\""+value.COUNTRY+"\","+
                    "\""+value.CRNCY+"\","+
                    "\""+value.SECURITY_TYP+"\","+
                    "\""+value.PAR_AMT+"\","+
                    "\""+value.EQY_PRIM_EXCH+"\","+
                    "\""+value.EQY_PRIM_EXCH_SHRT+"\","+
                    "\""+value.EQY_SIC_CODE+"\","+
                    "\""+value.EQY_SIC_NAME+"\","+
                    "\""+value.INDUSTRY_GROUP+"\","+
                    "\""+value.INDUSTRY_SUBGROUP+"\","+
                    "\""+value.INDUSTRY_SECTOR+"\","+
                    "\""+value.ID_SEDOL1+"\","+
                    "\""+value.ID_WERTPAPIER+"\","+
                    "\""+value.ID_ISIN+"\","+
                    "\""+value.ID_DUTCH+"\","+
                    "\""+value.ID_VALOREN+"\","+
                    "\""+value.ID_FRENCH+"\","+
                    "\""+value.ID_BELGIUM+"\","+
                    "\""+value.ID_BB_COMPANY+"\","+
                    "\""+value.ID_BB_SECURITY+"\","+
                    "\""+value.ID_CUSIP+"\","+
                    "\""+value.ID_COMMON+"\","+
                    "\""+value.ADR_UNDL_TICKER+"\","+
                    "\""+value.ADR_SH_PER_ADR+"\","+
                    "\""+value.DVD_CRNCY+"\","+
                    "\""+value.EQY_DVD_SH_12M_NET+"\","+
                    "\""+value.DVD_SH_12M+"\","+
                    "\""+value.DVD_SH_LAST+"\","+
                    "\""+value.LAST_DPS_GROSS+"\","+
                    "\""+value.EQY_DVD_PCT_FRANKED+"\","+
                    "\""+value.DVD_TYP_LAST+"\","+
                    "\""+value.DVD_FREQ+"\","+
                    "\""+value.DVD_PAY_DT+"\","+
                    "\""+value.DVD_RECORD_DT+"\","+
                    "\""+value.DVD_DECLARED_DT+"\","+
                    "\""+value.EQY_SPLIT_DT+"\","+
                    "\""+value.EQY_SPLIT_RATIO+"\","+
                    "\""+value.DVD_EX_DT+"\","+
                    "\""+value.EQY_DVD_EX_FLAG+"\","+
                    "\""+value.INDUSTRY_SUBGROUP_NUM+"\","+
                    "\""+value.CNTRY_ISSUE_ISO+"\","+
                    "\""+value.MARKET_STATUS+"\","+
                    "\""+value.ID_BB_PARENT_CO+"\","+
                    "\""+value.ADR_UNDL_CMPID+"\","+
                    "\""+value.ADR_UNDL_SECID+"\","+
                    "\""+value.REL_INDEX+"\","+
                    "\""+value.PX_TRADE_LOT_SIZE+"\","+
                    "\""+value.PARENT_COMP_TICKER+"\","+
                    "\""+value.PARENT_COMP_NAME+"\","+
                    "\""+value.ID_LOCAL+"\","+
                    "\""+value.LONG_COMP_NAME+"\","+
                    "\""+value.PARENT_INDUSTRY_GROUP+"\","+
                    "\""+value.PARENT_INDUSTRY_SUBGROUP+"\","+
                    "\""+value.PARENT_INDUSTRY_SECTOR+"\","+
                    "\""+value.VOTING_RIGHTS+"\","+
                    "\""+value.ID_BB_PRIM_SECURITY_FLAG+"\","+
                    "\""+value.PAR_VAL_CRNCY+"\","+
                    "\""+value.EQY_SH_OUT+"\","+
                    "\""+value.EQY_SH_OUT_DT+"\","+
                    "\""+value.ID_BB_UNIQUE+"\","+
                    "\""+value.MARKET_SECTOR_DES+"\","+
                    "\""+value.IS_STK_MARGINABLE+"\","+
                    "\""+value.A144_FLAG+"\","+
                    "\""+value.TRANSFER_AGENT+"\","+
                    "\""+value.EQY_PRIM_SECURITY_TICKER+"\","+
                    "\""+value.EQY_PRIM_SECURITY_COMP_EXCH+"\","+
                    "\""+value.IS_SETS+"\","+
                    "\""+value.WHICH_JAPANESE_SECTION+"\","+
                    "\""+value.ADR_ADR_PER_SH+"\","+
                    "\""+value.EQY_PRIM_SECURITY_PRIM_EXCH+"\","+
                    "\""+value.EQY_FUND_CRNCY+"\","+
                    "\""+value.WHEN_ISSUED+"\","+
                    "\""+value.CDR_COUNTRY_CODE+"\","+
                    "\""+value.CDR_EXCH_CODE+"\","+
                    "\""+value.CNTRY_OF_INCORPORATION+"\","+
                    "\""+value.CNTRY_OF_DOMICILE+"\","+
                    "\""+value.SEC_RESTRICT+"\","+
                    "\""+value.EQY_SH_OUT_REAL+"\","+
                    "\""+value.ADR_UNDL_CRNCY+"\","+
                    "\""+value.MULTIPLE_SHARE+"\","+
                    "\""+value.PX_QUOTE_LOT_SIZE+"\","+
                    "\""+value.PX_ROUND_LOT_SIZE+"\","+
                    "\""+value.ID_SEDOL2+"\","+
                    "\""+value.SEDOL1_COUNTRY_ISO+"\","+
                    "\""+value.SEDOL2_COUNTRY_ISO+"\","+
                    "\""+value.ID_MIC_PRIM_EXCH+"\","+
                    "\""+value.ID_MIC_LOCAL_EXCH+"\","+
                    "\""+value.EQY_SH_OUT_TOT_MULT_SH+"\","+
                    "\""+value.SECURITY_TYP2+"\","+
                    "\""+value.ID_BB_PRIM_SECURITY+"\","+
                    "\""+value.EQY_OPT_AVAIL+"\","+
                    "\""+value.EQY_FREE_FLOAT_PCT+"\","+
                    "\""+value.TICKER_AND_EXCH_CODE+"\","+
                    "\""+value.EQY_INIT_PO_DT+"\","+
                    "\""+value.EQY_PO_DT+"\","+
                    "\""+value.EQY_INIT_PO_SH_PX+"\","+
                    "\""+value.EQY_SPLIT_ADJ_INIT_PO_PX+"\","+
                    "\""+value.EQY_FUND_TICKER+"\","+
                    "\""+value.TOTAL_VOTING_SHARES_VALUE+"\","+
                    "\""+value.ID_EXCH_SYMBOL+"\","+
                    "\""+value.ID_BB_CONNECT+"\","+
                    "\""+value.ID_NAICS_CODE+"\","+
                    "\""+value.TOTAL_NON_VOTING_SHARES_VALUE+"\","+
                    "\""+value.CDR_SETTLE_CODE+"\","+
                    "\""+value.CFI_CODE+"\","+
                    "\""+value.ID_BB_GLOBAL+"\","+
                    "\""+value.COMPOSITE_ID_BB_GLOBAL+"\","+
                    "\""+value.INDUSTRY_GROUP_NUM+"\","+
                    "\""+value.INDUSTRY_SECTOR_NUM+"\","+
                    "\""+value.EQY_PRIM_SECURITY_CRNCY+"\","+
                    "\""+value.ID_BB_SEC_NUM_DES+"\","+
                    "\""+value.FEED_SOURCE+"\","+
                    "\""+value.ID_BB_GLOBAL_COMPANY+"\","+
                    "\""+value.ID_BB_GLOBAL_COMPANY_NAME+"\","+
                    "\""+value.UNDERLYING_ID_BB_GLOBAL+"\","+
                    "\""+value.PRIMARY_UNDERLYING_ID_BB_GLOBAL+"\","+
                    "\""+value.ID_BB_GLOBAL_SHARE_CLASS_LEVEL+"\","+
                    "\""+value.PRIM_SECURITY_COMP_ID_BB_GLOBAL+"\","+
                    "\""+value.TRADING_SYSTEM_IDENTIFIER+"\","+
                    "\""+value.TRADING_SYSTEM_IDENTIFIER_DES+"\","+
                    "\""+value.LSE_SEGMENT+"\","+
                    "\""+value.LSE_SECTOR+"\","+
                    "\""+value.DBTIMESTAMP+"\""+
                    ")";
        //System.out.println(sql);
        try{
            stmt.executeUpdate(sql);
        }catch(Exception e){ System.out.println(e);}
            /**
             * place insert statement here
             * **/
            //store.put(key, value);
        }

        @Override
        public void storeAll(Map<String, SecMasterBean> map) {
            Set<Map.Entry<String, SecMasterBean>> entrySet = map.entrySet();
            for (Map.Entry<String, SecMasterBean> entry : entrySet) {
                String key = entry.getKey();
                SecMasterBean value = entry.getValue();
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
        public SecMasterBean load(String key) {
            //System.out.println("SimpleStore - loading value for key: " + key);
            SecMasterBean result = new SecMasterBean();
            try{
                String query = "select * from BLOOMBERG_TZERO_OUT_V2 where ID_COMMON ="+key;
                stmt.execute(query);
                ResultSet rs = stmt.getResultSet();
                if(rs.isClosed()) return null;

                if (rs.next()){
                    result.setDDATE(safeGet(rs,1));

                    result.setREGION(safeGet(rs,2));
                    result.setLINE_NUM(safeGet(rs,3));
                    result.setID_BB_PARSEKEY(safeGet(rs,4));
                    result.setFLEX_ID(safeGet(rs,5));
                    result.setUNKNOWN1(safeGet(rs,6));
                    result.setUNKNOWN2(safeGet(rs,7));
                    result.setTICKER(safeGet(rs,8));
                    result.setEXCH_CODE(safeGet(rs,9));
                    result.setNAME(safeGet(rs,10));
                    result.setCOUNTRY(safeGet(rs,11));
                    result.setCRNCY(safeGet(rs,12));
                    result.setSECURITY_TYP(safeGet(rs,13));
                    result.setPAR_AMT(safeGet(rs,14));
                    result.setEQY_PRIM_EXCH(safeGet(rs,15));
                    result.setEQY_PRIM_EXCH_SHRT(safeGet(rs,16));
                    result.setEQY_SIC_CODE(safeGet(rs,17));
                    result.setEQY_SIC_NAME(safeGet(rs,18));
                    result.setINDUSTRY_GROUP(safeGet(rs,19));
                    result.setINDUSTRY_SUBGROUP(safeGet(rs,20));
                    result.setINDUSTRY_SECTOR(safeGet(rs,21));
                    result.setID_SEDOL1(safeGet(rs,22));
                    result.setID_WERTPAPIER(safeGet(rs,23));
                    result.setID_ISIN(safeGet(rs,24));
                    result.setID_DUTCH(safeGet(rs,25));
                    result.setID_VALOREN(safeGet(rs,26));
                    result.setID_FRENCH(safeGet(rs,27));
                    result.setID_BELGIUM(safeGet(rs,28));
                    result.setID_BB_COMPANY(safeGet(rs,29));
                    result.setID_BB_SECURITY(safeGet(rs,30));
                    result.setID_CUSIP(safeGet(rs,31));
                    result.setID_COMMON(safeGet(rs,32));
                    result.setADR_UNDL_TICKER(safeGet(rs,33));
                    result.setADR_SH_PER_ADR(safeGet(rs,34));
                    result.setDVD_CRNCY(safeGet(rs,35));
                    result.setEQY_DVD_SH_12M_NET(safeGet(rs,36));
                    result.setDVD_SH_12M(safeGet(rs,37));
                    result.setDVD_SH_LAST(safeGet(rs,38));
                    result.setLAST_DPS_GROSS(safeGet(rs,39));
                    result.setEQY_DVD_PCT_FRANKED(safeGet(rs,40));
                    result.setDVD_TYP_LAST(safeGet(rs,41));
                    result.setDVD_FREQ(safeGet(rs,42));
                    result.setDVD_PAY_DT(safeGet(rs,43));
                    result.setDVD_RECORD_DT(safeGet(rs,44));
                    result.setDVD_DECLARED_DT(safeGet(rs,45));
                    result.setEQY_SPLIT_DT(safeGet(rs,46));
                    result.setEQY_SPLIT_RATIO(safeGet(rs,47));
                    result.setDVD_EX_DT(safeGet(rs,48));
                    result.setEQY_DVD_EX_FLAG(safeGet(rs,49));
                    result.setINDUSTRY_SUBGROUP_NUM(safeGet(rs,50));
                    result.setCNTRY_ISSUE_ISO(safeGet(rs,51));
                    result.setMARKET_STATUS(safeGet(rs,52));
                    result.setID_BB_PARENT_CO(safeGet(rs,53));
                    result.setADR_UNDL_CMPID(safeGet(rs,54));
                    result.setADR_UNDL_SECID(safeGet(rs,55));
                    result.setREL_INDEX(safeGet(rs,56));
                    result.setPX_TRADE_LOT_SIZE(safeGet(rs,57));
                    result.setPARENT_COMP_TICKER(safeGet(rs,58));
                    result.setPARENT_COMP_NAME(safeGet(rs,59));
                    result.setID_LOCAL(safeGet(rs,60));
                    result.setLONG_COMP_NAME(safeGet(rs,61));
                    result.setPARENT_INDUSTRY_GROUP(safeGet(rs,62));
                    result.setPARENT_INDUSTRY_SUBGROUP(safeGet(rs,63));
                    result.setPARENT_INDUSTRY_SECTOR(safeGet(rs,64));
                    result.setVOTING_RIGHTS(safeGet(rs,65));
                    result.setID_BB_PRIM_SECURITY_FLAG(safeGet(rs,66));
                    result.setPAR_VAL_CRNCY(safeGet(rs,67));
                    result.setEQY_SH_OUT(safeGet(rs,68));
                    result.setEQY_SH_OUT_DT(safeGet(rs,69));
                    result.setID_BB_UNIQUE(safeGet(rs,70));
                    result.setMARKET_SECTOR_DES(safeGet(rs,71));
                    result.setIS_STK_MARGINABLE(safeGet(rs,72));
                    result.setA144_FLAG(safeGet(rs,73));
                    result.setTRANSFER_AGENT(safeGet(rs,74));
                    result.setEQY_PRIM_SECURITY_TICKER(safeGet(rs,75));
                    result.setEQY_PRIM_SECURITY_COMP_EXCH(safeGet(rs,76));
                    result.setIS_SETS(safeGet(rs,77));
                    result.setWHICH_JAPANESE_SECTION(safeGet(rs,78));
                    result.setADR_ADR_PER_SH(safeGet(rs,79));
                    result.setEQY_PRIM_SECURITY_PRIM_EXCH(safeGet(rs,80));
                    result.setEQY_FUND_CRNCY(safeGet(rs,81));
                    result.setWHEN_ISSUED(safeGet(rs,82));
                    result.setCDR_COUNTRY_CODE(safeGet(rs,83));
                    result.setCDR_EXCH_CODE(safeGet(rs,84));
                    result.setCNTRY_OF_INCORPORATION(safeGet(rs,85));
                    result.setCNTRY_OF_DOMICILE(safeGet(rs,86));
                    result.setSEC_RESTRICT(safeGet(rs,87));
                    result.setEQY_SH_OUT_REAL(safeGet(rs,88));
                    result.setADR_UNDL_CRNCY(safeGet(rs,89));
                    result.setMULTIPLE_SHARE(safeGet(rs,90));
                    result.setPX_QUOTE_LOT_SIZE(safeGet(rs,91));
                    result.setPX_ROUND_LOT_SIZE(safeGet(rs,92));
                    result.setID_SEDOL2(safeGet(rs,93));
                    result.setSEDOL1_COUNTRY_ISO(safeGet(rs,94));
                    result.setSEDOL2_COUNTRY_ISO(safeGet(rs,95));
                    result.setID_MIC_PRIM_EXCH(safeGet(rs,96));
                    result.setID_MIC_LOCAL_EXCH(safeGet(rs,97));
                    result.setEQY_SH_OUT_TOT_MULT_SH(safeGet(rs,98));
                    result.setSECURITY_TYP2(safeGet(rs,99));
                    result.setID_BB_PRIM_SECURITY(safeGet(rs,100));
                    result.setEQY_OPT_AVAIL(safeGet(rs,101));
                    result.setEQY_FREE_FLOAT_PCT(safeGet(rs,102));
                    result.setTICKER_AND_EXCH_CODE(safeGet(rs,103));
                    result.setEQY_INIT_PO_DT(safeGet(rs,104));
                    result.setEQY_PO_DT(safeGet(rs,105));
                    result.setEQY_INIT_PO_SH_PX(safeGet(rs,106));
                    result.setEQY_SPLIT_ADJ_INIT_PO_PX(safeGet(rs,107));
                    result.setEQY_FUND_TICKER(safeGet(rs,108));
                    result.setTOTAL_VOTING_SHARES_VALUE(safeGet(rs,109));
                    result.setID_EXCH_SYMBOL(safeGet(rs,110));
                    result.setID_BB_CONNECT(safeGet(rs,111));
                    result.setID_NAICS_CODE(safeGet(rs,112));
                    result.setTOTAL_NON_VOTING_SHARES_VALUE(safeGet(rs,113));
                    result.setCDR_SETTLE_CODE(safeGet(rs,114));
                    result.setCFI_CODE(safeGet(rs,115));
                    result.setID_BB_GLOBAL(safeGet(rs,116));
                    result.setCOMPOSITE_ID_BB_GLOBAL(safeGet(rs,117));
                    result.setINDUSTRY_GROUP_NUM(safeGet(rs,118));
                    result.setINDUSTRY_SECTOR_NUM(safeGet(rs,119));
                    result.setEQY_PRIM_SECURITY_CRNCY(safeGet(rs,120));
                    result.setID_BB_SEC_NUM_DES(safeGet(rs,121));
                    result.setFEED_SOURCE(safeGet(rs,122));
                    result.setID_BB_GLOBAL_COMPANY(safeGet(rs,123));
                    result.setID_BB_GLOBAL_COMPANY_NAME(safeGet(rs,124));
                    result.setUNDERLYING_ID_BB_GLOBAL(safeGet(rs,125));
                    result.setPRIMARY_UNDERLYING_ID_BB_GLOBAL(safeGet(rs,126));
                    result.setID_BB_GLOBAL_SHARE_CLASS_LEVEL(safeGet(rs,127));
                    result.setPRIM_SECURITY_COMP_ID_BB_GLOBAL(safeGet(rs,128));
                    result.setTRADING_SYSTEM_IDENTIFIER(safeGet(rs,129));
                    result.setTRADING_SYSTEM_IDENTIFIER_DES(safeGet(rs,130));
                    result.setLSE_SEGMENT(safeGet(rs,131));
                    result.setLSE_SECTOR(safeGet(rs,132));
                    result.setDBTIMESTAMP(safeGet(rs,133));
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
        public Map<String, SecMasterBean> loadAll(Collection<String> keys) {
            Map<String, SecMasterBean> map = new HashMap<String, SecMasterBean>();
            for (String key : keys) {
                SecMasterBean value = load(key);
                map.put(key, value);
            }
            return map;
        }

        @Override
        public Set<String> loadAllKeys() {
            System.out.println("SimpleStore - loading all keys");
            Set<String> keys = new HashSet<>();
            try{
                ResultSet rs=stmt.executeQuery("select ID_COMMON from BLOOMBERG_TZERO_OUT_V2");
                while(rs.next())
                    keys.add(rs.getString(1));

                System.out.println("Loaded database into Hazelcast");

            }catch (Exception e){
                //e.printStackTrace();
                System.out.println("Failed to load database into Hazelcast");
            }

            return keys;
        }

    }