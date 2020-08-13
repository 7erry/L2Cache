package demo.exoduspoint.beans;

import com.hazelcast.nio.serialization.Portable;
import com.hazelcast.nio.serialization.PortableFactory;
import com.hazelcast.nio.serialization.PortableReader;
import com.hazelcast.nio.serialization.PortableWriter;
import com.opencsv.bean.CsvBindByName;
import demo.exoduspoint.Server;

import java.io.IOException;

/**
 * SecMasterBean
 * Plain Old Java Object that uses the Portable Serializer
 */
public class SecMasterBean extends Server implements Portable {
    // serialization
    public static class SecMasterPortableFactory implements PortableFactory {

        public static final int FACTORY_ID = 99;

        @Override
        public Portable create(int classId) {
            if (classId == SecMasterBean.CLASS_ID) {
                return new SecMasterBean();
            }
            return null;
        }
    }

    public static final int CLASS_ID = 66;
    @Override
    public int getFactoryId() {
        return SecMasterPortableFactory.FACTORY_ID;
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    @Override
    public void writePortable(PortableWriter writer) throws IOException {
        writer.writeUTF("DDATE", getDDATE());
        writer.writeUTF("REGION", REGION );
        writer.writeUTF("LINE_NUM", LINE_NUM );
        writer.writeUTF("ID_BB_PARSEKEY", ID_BB_PARSEKEY );
        writer.writeUTF("FLEX_ID", FLEX_ID );
        writer.writeUTF("UNKNOWN1", UNKNOWN1 );
        writer.writeUTF("UNKNOWN2", UNKNOWN2 );
        writer.writeUTF("TICKER", TICKER );
        writer.writeUTF("EXCH_CODE", EXCH_CODE );
        writer.writeUTF("NAME", NAME );
        writer.writeUTF("COUNTRY", COUNTRY );
        writer.writeUTF("CRNCY", CRNCY );
        writer.writeUTF("SECURITY_TYP", SECURITY_TYP );
        writer.writeUTF("PAR_AMT", PAR_AMT );
        writer.writeUTF("EQY_PRIM_EXCH", EQY_PRIM_EXCH );
        writer.writeUTF("EQY_PRIM_EXCH_SHRT", EQY_PRIM_EXCH_SHRT );
        writer.writeUTF("EQY_SIC_CODE", EQY_SIC_CODE );
        writer.writeUTF("EQY_SIC_NAME", EQY_SIC_NAME );
        writer.writeUTF("INDUSTRY_GROUP", INDUSTRY_GROUP );
        writer.writeUTF("INDUSTRY_SUBGROUP", INDUSTRY_SUBGROUP );
        writer.writeUTF("INDUSTRY_SECTOR", INDUSTRY_SECTOR );
        writer.writeUTF("ID_SEDOL1", ID_SEDOL1 );
        writer.writeUTF("ID_WERTPAPIER", ID_WERTPAPIER );
        writer.writeUTF("ID_ISIN", ID_ISIN );
        writer.writeUTF("ID_DUTCH", ID_DUTCH );
        writer.writeUTF("ID_VALOREN", ID_VALOREN );
        writer.writeUTF("ID_FRENCH", ID_FRENCH );
        writer.writeUTF("ID_BELGIUM", ID_BELGIUM );
        writer.writeUTF("ID_BB_COMPANY", ID_BB_COMPANY );
        writer.writeUTF("ID_BB_SECURITY", ID_BB_SECURITY );
        writer.writeUTF("ID_CUSIP", ID_CUSIP );
        writer.writeUTF("ID_COMMON", ID_COMMON );
        writer.writeUTF("ADR_UNDL_TICKER", ADR_UNDL_TICKER );
        writer.writeUTF("ADR_SH_PER_ADR", ADR_SH_PER_ADR );
        writer.writeUTF("DVD_CRNCY", DVD_CRNCY );
        writer.writeUTF("EQY_DVD_SH_12M_NET", EQY_DVD_SH_12M_NET );
        writer.writeUTF("DVD_SH_12M", DVD_SH_12M );
        writer.writeUTF("DVD_SH_LAST", DVD_SH_LAST );
        writer.writeUTF("LAST_DPS_GROSS", LAST_DPS_GROSS );
        writer.writeUTF("EQY_DVD_PCT_FRANKED", EQY_DVD_PCT_FRANKED );
        writer.writeUTF("DVD_TYP_LAST", DVD_TYP_LAST );
        writer.writeUTF("DVD_FREQ", DVD_FREQ );
        writer.writeUTF("DVD_PAY_DT", DVD_PAY_DT );
        writer.writeUTF("DVD_RECORD_DT", DVD_RECORD_DT );
        writer.writeUTF("DVD_DECLARED_DT", DVD_DECLARED_DT );
        writer.writeUTF("EQY_SPLIT_DT", EQY_SPLIT_DT );
        writer.writeUTF("EQY_SPLIT_RATIO", EQY_SPLIT_RATIO );
        writer.writeUTF("DVD_EX_DT", DVD_EX_DT );
        writer.writeUTF("EQY_DVD_EX_FLAG", EQY_DVD_EX_FLAG );
        writer.writeUTF("INDUSTRY_SUBGROUP_NUM", INDUSTRY_SUBGROUP_NUM );
        writer.writeUTF("CNTRY_ISSUE_ISO", CNTRY_ISSUE_ISO );
        writer.writeUTF("MARKET_STATUS", MARKET_STATUS );
        writer.writeUTF("ID_BB_PARENT_CO", ID_BB_PARENT_CO );
        writer.writeUTF("ADR_UNDL_CMPID", ADR_UNDL_CMPID );
        writer.writeUTF("ADR_UNDL_SECID", ADR_UNDL_SECID );
        writer.writeUTF("REL_INDEX", REL_INDEX );
        writer.writeUTF("PX_TRADE_LOT_SIZE", PX_TRADE_LOT_SIZE );
        writer.writeUTF("PARENT_COMP_TICKER", PARENT_COMP_TICKER );
        writer.writeUTF("PARENT_COMP_NAME", PARENT_COMP_NAME );
        writer.writeUTF("ID_LOCAL", ID_LOCAL );
        writer.writeUTF("LONG_COMP_NAME", LONG_COMP_NAME );
        writer.writeUTF("PARENT_INDUSTRY_GROUP", PARENT_INDUSTRY_GROUP );
        writer.writeUTF("PARENT_INDUSTRY_SUBGROUP", PARENT_INDUSTRY_SUBGROUP );
        writer.writeUTF("PARENT_INDUSTRY_SECTOR", PARENT_INDUSTRY_SECTOR );
        writer.writeUTF("VOTING_RIGHTS", VOTING_RIGHTS );
        writer.writeUTF("ID_BB_PRIM_SECURITY_FLAG", ID_BB_PRIM_SECURITY_FLAG );
        writer.writeUTF("PAR_VAL_CRNCY", PAR_VAL_CRNCY );
        writer.writeUTF("EQY_SH_OUT", EQY_SH_OUT );
        writer.writeUTF("EQY_SH_OUT_DT", EQY_SH_OUT_DT );
        writer.writeUTF("ID_BB_UNIQUE", ID_BB_UNIQUE );
        writer.writeUTF("MARKET_SECTOR_DES", MARKET_SECTOR_DES );
        writer.writeUTF("IS_STK_MARGINABLE", IS_STK_MARGINABLE );
        writer.writeUTF("A144_FLAG", A144_FLAG );
        writer.writeUTF("TRANSFER_AGENT", TRANSFER_AGENT );
        writer.writeUTF("EQY_PRIM_SECURITY_TICKER", EQY_PRIM_SECURITY_TICKER );
        writer.writeUTF("EQY_PRIM_SECURITY_COMP_EXCH", EQY_PRIM_SECURITY_COMP_EXCH );
        writer.writeUTF("IS_SETS", IS_SETS );
        writer.writeUTF("WHICH_JAPANESE_SECTION", WHICH_JAPANESE_SECTION );
        writer.writeUTF("ADR_ADR_PER_SH", ADR_ADR_PER_SH );
        writer.writeUTF("EQY_PRIM_SECURITY_PRIM_EXCH", EQY_PRIM_SECURITY_PRIM_EXCH );
        writer.writeUTF("EQY_FUND_CRNCY", EQY_FUND_CRNCY );
        writer.writeUTF("WHEN_ISSUED", WHEN_ISSUED );
        writer.writeUTF("CDR_COUNTRY_CODE", CDR_COUNTRY_CODE );
        writer.writeUTF("CDR_EXCH_CODE", CDR_EXCH_CODE );
        writer.writeUTF("CNTRY_OF_INCORPORATION", CNTRY_OF_INCORPORATION );
        writer.writeUTF("CNTRY_OF_DOMICILE", CNTRY_OF_DOMICILE );
        writer.writeUTF("SEC_RESTRICT", SEC_RESTRICT );
        writer.writeUTF("EQY_SH_OUT_REAL", EQY_SH_OUT_REAL );
        writer.writeUTF("ADR_UNDL_CRNCY", ADR_UNDL_CRNCY );
        writer.writeUTF("MULTIPLE_SHARE", MULTIPLE_SHARE );
        writer.writeUTF("PX_QUOTE_LOT_SIZE", PX_QUOTE_LOT_SIZE );
        writer.writeUTF("PX_ROUND_LOT_SIZE", PX_ROUND_LOT_SIZE );
        writer.writeUTF("ID_SEDOL2", ID_SEDOL2 );
        writer.writeUTF("SEDOL1_COUNTRY_ISO", SEDOL1_COUNTRY_ISO );
        writer.writeUTF("SEDOL2_COUNTRY_ISO", SEDOL2_COUNTRY_ISO );
        writer.writeUTF("ID_MIC_PRIM_EXCH", ID_MIC_PRIM_EXCH );
        writer.writeUTF("ID_MIC_LOCAL_EXCH", ID_MIC_LOCAL_EXCH );
        writer.writeUTF("EQY_SH_OUT_TOT_MULT_SH", EQY_SH_OUT_TOT_MULT_SH );
        writer.writeUTF("SECURITY_TYP2", SECURITY_TYP2 );
        writer.writeUTF("ID_BB_PRIM_SECURITY", ID_BB_PRIM_SECURITY );
        writer.writeUTF("EQY_OPT_AVAIL", EQY_OPT_AVAIL );
        writer.writeUTF("EQY_FREE_FLOAT_PCT", EQY_FREE_FLOAT_PCT );
        writer.writeUTF("TICKER_AND_EXCH_CODE", TICKER_AND_EXCH_CODE );
        writer.writeUTF("EQY_INIT_PO_DT", EQY_INIT_PO_DT );
        writer.writeUTF("EQY_PO_DT", EQY_PO_DT );
        writer.writeUTF("EQY_INIT_PO_SH_PX", EQY_INIT_PO_SH_PX );
        writer.writeUTF("EQY_SPLIT_ADJ_INIT_PO_PX", EQY_SPLIT_ADJ_INIT_PO_PX );
        writer.writeUTF("EQY_FUND_TICKER", EQY_FUND_TICKER );
        writer.writeUTF("TOTAL_VOTING_SHARES_VALUE", TOTAL_VOTING_SHARES_VALUE );
        writer.writeUTF("ID_EXCH_SYMBOL", ID_EXCH_SYMBOL );
        writer.writeUTF("ID_BB_CONNECT", ID_BB_CONNECT );
        writer.writeUTF("ID_NAICS_CODE", ID_NAICS_CODE );
        writer.writeUTF("TOTAL_NON_VOTING_SHARES_VALUE", TOTAL_NON_VOTING_SHARES_VALUE );
        writer.writeUTF("CDR_SETTLE_CODE", CDR_SETTLE_CODE );
        writer.writeUTF("CFI_CODE", CFI_CODE );
        writer.writeUTF("ID_BB_GLOBAL", ID_BB_GLOBAL );
        writer.writeUTF("COMPOSITE_ID_BB_GLOBAL", COMPOSITE_ID_BB_GLOBAL );
        writer.writeUTF("INDUSTRY_GROUP_NUM", INDUSTRY_GROUP_NUM );
        writer.writeUTF("INDUSTRY_SECTOR_NUM", INDUSTRY_SECTOR_NUM );
        writer.writeUTF("EQY_PRIM_SECURITY_CRNCY", EQY_PRIM_SECURITY_CRNCY );
        writer.writeUTF("ID_BB_SEC_NUM_DES", ID_BB_SEC_NUM_DES );
        writer.writeUTF("FEED_SOURCE", FEED_SOURCE );
        writer.writeUTF("ID_BB_GLOBAL_COMPANY", ID_BB_GLOBAL_COMPANY );
        writer.writeUTF("ID_BB_GLOBAL_COMPANY_NAME", ID_BB_GLOBAL_COMPANY_NAME );
        writer.writeUTF("UNDERLYING_ID_BB_GLOBAL", UNDERLYING_ID_BB_GLOBAL );
        writer.writeUTF("PRIMARY_UNDERLYING_ID_BB_GLOBAL", PRIMARY_UNDERLYING_ID_BB_GLOBAL );
        writer.writeUTF("ID_BB_GLOBAL_SHARE_CLASS_LEVEL", ID_BB_GLOBAL_SHARE_CLASS_LEVEL );
        writer.writeUTF("PRIM_SECURITY_COMP_ID_BB_GLOBAL", PRIM_SECURITY_COMP_ID_BB_GLOBAL );
        writer.writeUTF("TRADING_SYSTEM_IDENTIFIER", TRADING_SYSTEM_IDENTIFIER );
        writer.writeUTF("TRADING_SYSTEM_IDENTIFIER_DES", TRADING_SYSTEM_IDENTIFIER_DES );
        writer.writeUTF("LSE_SEGMENT", LSE_SEGMENT );
        writer.writeUTF("LSE_SECTOR", LSE_SECTOR );
        if(DBTIMESTAMP!=null)
            writer.writeUTF("DBTIMESTAMP", DBTIMESTAMP.toString() );
        else
            writer.writeUTF("DBTIMESTAMP","");
    }

    public void readPortable(PortableReader reader) throws IOException {
        this.setDDATE( reader.readUTF("DDATE") );
        REGION = reader.readUTF("REGION");
        LINE_NUM = reader.readUTF("LINE_NUM");
        ID_BB_PARSEKEY = reader.readUTF("ID_BB_PARSEKEY");
        FLEX_ID = reader.readUTF("FLEX_ID");
        UNKNOWN1 = reader.readUTF("UNKNOWN1");
        UNKNOWN2 = reader.readUTF("UNKNOWN2");
        TICKER = reader.readUTF("TICKER");
        EXCH_CODE = reader.readUTF("EXCH_CODE");
        NAME = reader.readUTF("NAME");
        COUNTRY = reader.readUTF("COUNTRY");
        CRNCY = reader.readUTF("CRNCY");
        SECURITY_TYP = reader.readUTF("SECURITY_TYP");
        PAR_AMT = reader.readUTF("PAR_AMT");
        EQY_PRIM_EXCH = reader.readUTF("EQY_PRIM_EXCH");
        EQY_PRIM_EXCH_SHRT = reader.readUTF("EQY_PRIM_EXCH_SHRT");
        EQY_SIC_CODE = reader.readUTF("EQY_SIC_CODE");
        EQY_SIC_NAME = reader.readUTF("EQY_SIC_NAME");
        INDUSTRY_GROUP = reader.readUTF("INDUSTRY_GROUP");
        INDUSTRY_SUBGROUP = reader.readUTF("INDUSTRY_SUBGROUP");
        INDUSTRY_SECTOR = reader.readUTF("INDUSTRY_SECTOR");
        ID_SEDOL1 = reader.readUTF("ID_SEDOL1");
        ID_WERTPAPIER = reader.readUTF("ID_WERTPAPIER");
        ID_ISIN = reader.readUTF("ID_ISIN");
        ID_DUTCH = reader.readUTF("ID_DUTCH");
        ID_VALOREN = reader.readUTF("ID_VALOREN");
        ID_FRENCH = reader.readUTF("ID_FRENCH");
        ID_BELGIUM = reader.readUTF("ID_BELGIUM");
        ID_BB_COMPANY = reader.readUTF("ID_BB_COMPANY");
        ID_BB_SECURITY = reader.readUTF("ID_BB_SECURITY");
        ID_CUSIP = reader.readUTF("ID_CUSIP");
        ID_COMMON = reader.readUTF("ID_COMMON");
        ADR_UNDL_TICKER = reader.readUTF("ADR_UNDL_TICKER");
        ADR_SH_PER_ADR = reader.readUTF("ADR_SH_PER_ADR");
        DVD_CRNCY = reader.readUTF("DVD_CRNCY");
        EQY_DVD_SH_12M_NET = reader.readUTF("EQY_DVD_SH_12M_NET");
        DVD_SH_12M = reader.readUTF("DVD_SH_12M");
        DVD_SH_LAST = reader.readUTF("DVD_SH_LAST");
        LAST_DPS_GROSS = reader.readUTF("LAST_DPS_GROSS");
        EQY_DVD_PCT_FRANKED = reader.readUTF("EQY_DVD_PCT_FRANKED");
        DVD_TYP_LAST = reader.readUTF("DVD_TYP_LAST");
        DVD_FREQ = reader.readUTF("DVD_FREQ");
        DVD_PAY_DT = reader.readUTF("DVD_PAY_DT");
        DVD_RECORD_DT = reader.readUTF("DVD_RECORD_DT");
        DVD_DECLARED_DT = reader.readUTF("DVD_DECLARED_DT");
        EQY_SPLIT_DT = reader.readUTF("EQY_SPLIT_DT");
        EQY_SPLIT_RATIO = reader.readUTF("EQY_SPLIT_RATIO");
        DVD_EX_DT = reader.readUTF("DVD_EX_DT");
        EQY_DVD_EX_FLAG = reader.readUTF("EQY_DVD_EX_FLAG");
        INDUSTRY_SUBGROUP_NUM = reader.readUTF("INDUSTRY_SUBGROUP_NUM");
        CNTRY_ISSUE_ISO = reader.readUTF("CNTRY_ISSUE_ISO");
        MARKET_STATUS = reader.readUTF("MARKET_STATUS");
        ID_BB_PARENT_CO = reader.readUTF("ID_BB_PARENT_CO");
        ADR_UNDL_CMPID = reader.readUTF("ADR_UNDL_CMPID");
        ADR_UNDL_SECID = reader.readUTF("ADR_UNDL_SECID");
        REL_INDEX = reader.readUTF("REL_INDEX");
        PX_TRADE_LOT_SIZE = reader.readUTF("PX_TRADE_LOT_SIZE");
        PARENT_COMP_TICKER = reader.readUTF("PARENT_COMP_TICKER");
        PARENT_COMP_NAME = reader.readUTF("PARENT_COMP_NAME");
        ID_LOCAL = reader.readUTF("ID_LOCAL");
        LONG_COMP_NAME = reader.readUTF("LONG_COMP_NAME");
        PARENT_INDUSTRY_GROUP = reader.readUTF("PARENT_INDUSTRY_GROUP");
        PARENT_INDUSTRY_SUBGROUP = reader.readUTF("PARENT_INDUSTRY_SUBGROUP");
        PARENT_INDUSTRY_SECTOR = reader.readUTF("PARENT_INDUSTRY_SECTOR");
        VOTING_RIGHTS = reader.readUTF("VOTING_RIGHTS");
        ID_BB_PRIM_SECURITY_FLAG = reader.readUTF("ID_BB_PRIM_SECURITY_FLAG");
        PAR_VAL_CRNCY = reader.readUTF("PAR_VAL_CRNCY");
        EQY_SH_OUT = reader.readUTF("EQY_SH_OUT");
        EQY_SH_OUT_DT = reader.readUTF("EQY_SH_OUT_DT");
        ID_BB_UNIQUE = reader.readUTF("ID_BB_UNIQUE");
        MARKET_SECTOR_DES = reader.readUTF("MARKET_SECTOR_DES");
        IS_STK_MARGINABLE = reader.readUTF("IS_STK_MARGINABLE");
        A144_FLAG = reader.readUTF("A144_FLAG");
        TRANSFER_AGENT = reader.readUTF("TRANSFER_AGENT");
        EQY_PRIM_SECURITY_TICKER = reader.readUTF("EQY_PRIM_SECURITY_TICKER");
        EQY_PRIM_SECURITY_COMP_EXCH = reader.readUTF("EQY_PRIM_SECURITY_COMP_EXCH");
        IS_SETS = reader.readUTF("IS_SETS");
        WHICH_JAPANESE_SECTION = reader.readUTF("WHICH_JAPANESE_SECTION");
        ADR_ADR_PER_SH = reader.readUTF("ADR_ADR_PER_SH");
        EQY_PRIM_SECURITY_PRIM_EXCH = reader.readUTF("EQY_PRIM_SECURITY_PRIM_EXCH");
        EQY_FUND_CRNCY = reader.readUTF("EQY_FUND_CRNCY");
        WHEN_ISSUED = reader.readUTF("WHEN_ISSUED");
        CDR_COUNTRY_CODE = reader.readUTF("CDR_COUNTRY_CODE");
        CDR_EXCH_CODE = reader.readUTF("CDR_EXCH_CODE");
        CNTRY_OF_INCORPORATION = reader.readUTF("CNTRY_OF_INCORPORATION");
        CNTRY_OF_DOMICILE = reader.readUTF("CNTRY_OF_DOMICILE");
        SEC_RESTRICT = reader.readUTF("SEC_RESTRICT");
        EQY_SH_OUT_REAL = reader.readUTF("EQY_SH_OUT_REAL");
        ADR_UNDL_CRNCY = reader.readUTF("ADR_UNDL_CRNCY");
        MULTIPLE_SHARE = reader.readUTF("MULTIPLE_SHARE");
        PX_QUOTE_LOT_SIZE = reader.readUTF("PX_QUOTE_LOT_SIZE");
        PX_ROUND_LOT_SIZE = reader.readUTF("PX_ROUND_LOT_SIZE");
        ID_SEDOL2 = reader.readUTF("ID_SEDOL2");
        SEDOL1_COUNTRY_ISO = reader.readUTF("SEDOL1_COUNTRY_ISO");
        SEDOL2_COUNTRY_ISO = reader.readUTF("SEDOL2_COUNTRY_ISO");
        ID_MIC_PRIM_EXCH = reader.readUTF("ID_MIC_PRIM_EXCH");
        ID_MIC_LOCAL_EXCH = reader.readUTF("ID_MIC_LOCAL_EXCH");
        EQY_SH_OUT_TOT_MULT_SH = reader.readUTF("EQY_SH_OUT_TOT_MULT_SH");
        SECURITY_TYP2 = reader.readUTF("SECURITY_TYP2");
        ID_BB_PRIM_SECURITY = reader.readUTF("ID_BB_PRIM_SECURITY");
        EQY_OPT_AVAIL = reader.readUTF("EQY_OPT_AVAIL");
        EQY_FREE_FLOAT_PCT = reader.readUTF("EQY_FREE_FLOAT_PCT");
        TICKER_AND_EXCH_CODE = reader.readUTF("TICKER_AND_EXCH_CODE");
        EQY_INIT_PO_DT = reader.readUTF("EQY_INIT_PO_DT");
        EQY_PO_DT = reader.readUTF("EQY_PO_DT");
        EQY_INIT_PO_SH_PX = reader.readUTF("EQY_INIT_PO_SH_PX");
        EQY_SPLIT_ADJ_INIT_PO_PX = reader.readUTF("EQY_SPLIT_ADJ_INIT_PO_PX");
        EQY_FUND_TICKER = reader.readUTF("EQY_FUND_TICKER");
        TOTAL_VOTING_SHARES_VALUE = reader.readUTF("TOTAL_VOTING_SHARES_VALUE");
        ID_EXCH_SYMBOL = reader.readUTF("ID_EXCH_SYMBOL");
        ID_BB_CONNECT = reader.readUTF("ID_BB_CONNECT");
        ID_NAICS_CODE = reader.readUTF("ID_NAICS_CODE");
        TOTAL_NON_VOTING_SHARES_VALUE = reader.readUTF("TOTAL_NON_VOTING_SHARES_VALUE");
        CDR_SETTLE_CODE = reader.readUTF("CDR_SETTLE_CODE");
        CFI_CODE = reader.readUTF("CFI_CODE");
        ID_BB_GLOBAL = reader.readUTF("ID_BB_GLOBAL");
        COMPOSITE_ID_BB_GLOBAL = reader.readUTF("COMPOSITE_ID_BB_GLOBAL");
        INDUSTRY_GROUP_NUM = reader.readUTF("INDUSTRY_GROUP_NUM");
        INDUSTRY_SECTOR_NUM = reader.readUTF("INDUSTRY_SECTOR_NUM");
        EQY_PRIM_SECURITY_CRNCY = reader.readUTF("EQY_PRIM_SECURITY_CRNCY");
        ID_BB_SEC_NUM_DES = reader.readUTF("ID_BB_SEC_NUM_DES");
        FEED_SOURCE = reader.readUTF("FEED_SOURCE");
        ID_BB_GLOBAL_COMPANY = reader.readUTF("ID_BB_GLOBAL_COMPANY");
        ID_BB_GLOBAL_COMPANY_NAME = reader.readUTF("ID_BB_GLOBAL_COMPANY_NAME");
        UNDERLYING_ID_BB_GLOBAL = reader.readUTF("UNDERLYING_ID_BB_GLOBAL");
        PRIMARY_UNDERLYING_ID_BB_GLOBAL = reader.readUTF("PRIMARY_UNDERLYING_ID_BB_GLOBAL");
        ID_BB_GLOBAL_SHARE_CLASS_LEVEL = reader.readUTF("ID_BB_GLOBAL_SHARE_CLASS_LEVEL");
        PRIM_SECURITY_COMP_ID_BB_GLOBAL = reader.readUTF("PRIM_SECURITY_COMP_ID_BB_GLOBAL");
        TRADING_SYSTEM_IDENTIFIER = reader.readUTF("TRADING_SYSTEM_IDENTIFIER");
        TRADING_SYSTEM_IDENTIFIER_DES = reader.readUTF("TRADING_SYSTEM_IDENTIFIER_DES");
        LSE_SEGMENT = reader.readUTF("LSE_SEGMENT");
        LSE_SECTOR = reader.readUTF("LSE_SECTOR");
        this.setDBTIMESTAMP(reader.readUTF("DBTIMESTAMP"));
    }

    // bean members
    @CsvBindByName(column = "DDATE")
    public String DDATE;

    @CsvBindByName(column = "REGION")
    public String REGION;

    @CsvBindByName(column = "LINE_NUM")
    public String LINE_NUM;

    @CsvBindByName(column = "ID_BB_PARSEKEY")
    public String ID_BB_PARSEKEY;

    @CsvBindByName(column = "FLEX_ID")
    public String FLEX_ID;

    @CsvBindByName(column = "UNKNOWN1")
    public String UNKNOWN1;

    @CsvBindByName(column = "UNKNOWN2")
    public String UNKNOWN2;

    @CsvBindByName(column = "TICKER")
    public String TICKER;

    @CsvBindByName(column = "EXCH_CODE")
    public String EXCH_CODE;

    @CsvBindByName(column = "NAME")
    public String NAME;

    @CsvBindByName(column = "COUNTRY")
    public String COUNTRY;

    @CsvBindByName(column = "CRNCY")
    public String CRNCY;

    @CsvBindByName(column = "SECURITY_TYP")
    public String SECURITY_TYP;

    @CsvBindByName(column = "PAR_AMT")
    public String PAR_AMT;

    @CsvBindByName(column = "EQY_PRIM_EXCH")
    public String EQY_PRIM_EXCH;

    @CsvBindByName(column = "EQY_PRIM_EXCH_SHRT")
    public String EQY_PRIM_EXCH_SHRT;

    @CsvBindByName(column = "EQY_SIC_CODE")
    public String EQY_SIC_CODE;

    @CsvBindByName(column = "EQY_SIC_NAME")
    public String EQY_SIC_NAME;

    @CsvBindByName(column = "INDUSTRY_GROUP")
    public String INDUSTRY_GROUP;

    @CsvBindByName(column = "INDUSTRY_SUBGROUP")
    public String INDUSTRY_SUBGROUP;

    @CsvBindByName(column = "INDUSTRY_SECTOR")
    public String INDUSTRY_SECTOR;

    @CsvBindByName(column = "ID_SEDOL1")
    public String ID_SEDOL1;

    @CsvBindByName(column = "ID_WERTPAPIER")
    public String ID_WERTPAPIER;

    @CsvBindByName(column = "ID_ISIN")
    public String ID_ISIN;

    @CsvBindByName(column = "ID_DUTCH")
    public String ID_DUTCH;

    @CsvBindByName(column = "ID_VALOREN")
    public String ID_VALOREN;

    @CsvBindByName(column = "ID_FRENCH")
    public String ID_FRENCH;

    @CsvBindByName(column = "ID_BELGIUM")
    public String ID_BELGIUM;

    @CsvBindByName(column = "ID_BB_COMPANY")
    public String ID_BB_COMPANY;

    @CsvBindByName(column = "ID_BB_SECURITY")
    public String ID_BB_SECURITY;

    @CsvBindByName(column = "ID_CUSIP")
    public String ID_CUSIP;

    @CsvBindByName(column = "ID_COMMON")
    public String ID_COMMON;

    @CsvBindByName(column = "ADR_UNDL_TICKER")
    public String ADR_UNDL_TICKER;

    @CsvBindByName(column = "ADR_SH_PER_ADR")
    public String ADR_SH_PER_ADR;

    @CsvBindByName(column = "DVD_CRNCY")
    public String DVD_CRNCY;

    @CsvBindByName(column = "EQY_DVD_SH_12M_NET")
    public String EQY_DVD_SH_12M_NET;

    @CsvBindByName(column = "DVD_SH_12M")
    public String DVD_SH_12M;

    @CsvBindByName(column = "DVD_SH_LAST")
    public String DVD_SH_LAST;

    @CsvBindByName(column = "LAST_DPS_GROSS")
    public String LAST_DPS_GROSS;

    @CsvBindByName(column = "EQY_DVD_PCT_FRANKED")
    public String EQY_DVD_PCT_FRANKED;

    @CsvBindByName(column = "DVD_TYP_LAST")
    public String DVD_TYP_LAST;

    @CsvBindByName(column = "DVD_FREQ")
    public String DVD_FREQ;

    @CsvBindByName(column = "DVD_PAY_DT")
    public String DVD_PAY_DT;

    @CsvBindByName(column = "DVD_RECORD_DT")
    public String DVD_RECORD_DT;

    @CsvBindByName(column = "DVD_DECLARED_DT")
    public String DVD_DECLARED_DT;

    @CsvBindByName(column = "EQY_SPLIT_DT")
    public String EQY_SPLIT_DT;

    @CsvBindByName(column = "EQY_SPLIT_RATIO")
    public String EQY_SPLIT_RATIO;

    @CsvBindByName(column = "DVD_EX_DT")
    public String DVD_EX_DT;

    @CsvBindByName(column = "EQY_DVD_EX_FLAG")
    public String EQY_DVD_EX_FLAG;

    @CsvBindByName(column = "INDUSTRY_SUBGROUP_NUM")
    public String INDUSTRY_SUBGROUP_NUM;

    @CsvBindByName(column = "CNTRY_ISSUE_ISO")
    public String CNTRY_ISSUE_ISO;

    @CsvBindByName(column = "MARKET_STATUS")
    public String MARKET_STATUS;

    @CsvBindByName(column = "ID_BB_PARENT_CO")
    public String ID_BB_PARENT_CO;

    @CsvBindByName(column = "ADR_UNDL_CMPID")
    public String ADR_UNDL_CMPID;

    @CsvBindByName(column = "ADR_UNDL_SECID")
    public String ADR_UNDL_SECID;

    @CsvBindByName(column = "REL_INDEX")
    public String REL_INDEX;

    @CsvBindByName(column = "PX_TRADE_LOT_SIZE")
    public String PX_TRADE_LOT_SIZE;

    @CsvBindByName(column = "PARENT_COMP_TICKER")
    public String PARENT_COMP_TICKER;

    @CsvBindByName(column = "PARENT_COMP_NAME")
    public String PARENT_COMP_NAME;

    @CsvBindByName(column = "ID_LOCAL")
    public String ID_LOCAL;

    @CsvBindByName(column = "LONG_COMP_NAME")
    public String LONG_COMP_NAME;

    @CsvBindByName(column = "PARENT_INDUSTRY_GROUP")
    public String PARENT_INDUSTRY_GROUP;

    @CsvBindByName(column = "PARENT_INDUSTRY_SUBGROUP")
    public String PARENT_INDUSTRY_SUBGROUP;

    @CsvBindByName(column = "PARENT_INDUSTRY_SECTOR")
    public String PARENT_INDUSTRY_SECTOR;

    @CsvBindByName(column = "VOTING_RIGHTS")
    public String VOTING_RIGHTS;

    @CsvBindByName(column = "ID_BB_PRIM_SECURITY_FLAG")
    public String ID_BB_PRIM_SECURITY_FLAG;

    @CsvBindByName(column = "PAR_VAL_CRNCY")
    public String PAR_VAL_CRNCY;

    @CsvBindByName(column = "EQY_SH_OUT")
    public String EQY_SH_OUT;

    @CsvBindByName(column = "EQY_SH_OUT_DT")
    public String EQY_SH_OUT_DT;

    @CsvBindByName(column = "ID_BB_UNIQUE")
    public String ID_BB_UNIQUE;

    @CsvBindByName(column = "MARKET_SECTOR_DES")
    public String MARKET_SECTOR_DES;

    @CsvBindByName(column = "IS_STK_MARGINABLE")
    public String IS_STK_MARGINABLE;

    @CsvBindByName(column = "A144_FLAG")
    public String A144_FLAG;

    @CsvBindByName(column = "TRANSFER_AGENT")
    public String TRANSFER_AGENT;

    @CsvBindByName(column = "EQY_PRIM_SECURITY_TICKER")
    public String EQY_PRIM_SECURITY_TICKER;

    @CsvBindByName(column = "EQY_PRIM_SECURITY_COMP_EXCH")
    public String EQY_PRIM_SECURITY_COMP_EXCH;

    @CsvBindByName(column = "IS_SETS")
    public String IS_SETS;

    @CsvBindByName(column = "WHICH_JAPANESE_SECTION")
    public String WHICH_JAPANESE_SECTION;

    @CsvBindByName(column = "ADR_ADR_PER_SH")
    public String ADR_ADR_PER_SH;

    @CsvBindByName(column = "EQY_PRIM_SECURITY_PRIM_EXCH")
    public String EQY_PRIM_SECURITY_PRIM_EXCH;

    @CsvBindByName(column = "EQY_FUND_CRNCY")
    public String EQY_FUND_CRNCY;

    @CsvBindByName(column = "WHEN_ISSUED")
    public String WHEN_ISSUED;

    @CsvBindByName(column = "CDR_COUNTRY_CODE")
    public String CDR_COUNTRY_CODE;

    @CsvBindByName(column = "CDR_EXCH_CODE")
    public String CDR_EXCH_CODE;

    @CsvBindByName(column = "CNTRY_OF_INCORPORATION")
    public String CNTRY_OF_INCORPORATION;

    @CsvBindByName(column = "CNTRY_OF_DOMICILE")
    public String CNTRY_OF_DOMICILE;

    @CsvBindByName(column = "SEC_RESTRICT")
    public String SEC_RESTRICT;

    @CsvBindByName(column = "EQY_SH_OUT_REAL")
    public String EQY_SH_OUT_REAL;

    @CsvBindByName(column = "ADR_UNDL_CRNCY")
    public String ADR_UNDL_CRNCY;

    @CsvBindByName(column = "MULTIPLE_SHARE")
    public String MULTIPLE_SHARE;

    @CsvBindByName(column = "PX_QUOTE_LOT_SIZE")
    public String PX_QUOTE_LOT_SIZE;

    @CsvBindByName(column = "PX_ROUND_LOT_SIZE")
    public String PX_ROUND_LOT_SIZE;

    @CsvBindByName(column = "ID_SEDOL2")
    public String ID_SEDOL2;

    @CsvBindByName(column = "SEDOL1_COUNTRY_ISO")
    public String SEDOL1_COUNTRY_ISO;

    @CsvBindByName(column = "SEDOL2_COUNTRY_ISO")
    public String SEDOL2_COUNTRY_ISO;

    @CsvBindByName(column = "ID_MIC_PRIM_EXCH")
    public String ID_MIC_PRIM_EXCH;

    @CsvBindByName(column = "ID_MIC_LOCAL_EXCH")
    public String ID_MIC_LOCAL_EXCH;

    @CsvBindByName(column = "EQY_SH_OUT_TOT_MULT_SH")
    public String EQY_SH_OUT_TOT_MULT_SH;

    @CsvBindByName(column = "SECURITY_TYP2")
    public String SECURITY_TYP2;

    @CsvBindByName(column = "ID_BB_PRIM_SECURITY")
    public String ID_BB_PRIM_SECURITY;

    @CsvBindByName(column = "EQY_OPT_AVAIL")
    public String EQY_OPT_AVAIL;

    @CsvBindByName(column = "EQY_FREE_FLOAT_PCT")
    public String EQY_FREE_FLOAT_PCT;

    @CsvBindByName(column = "TICKER_AND_EXCH_CODE")
    public String TICKER_AND_EXCH_CODE;

    @CsvBindByName(column = "EQY_INIT_PO_DT")
    public String EQY_INIT_PO_DT;

    @CsvBindByName(column = "EQY_PO_DT")
    public String EQY_PO_DT;

    @CsvBindByName(column = "EQY_INIT_PO_SH_PX")
    public String EQY_INIT_PO_SH_PX;

    @CsvBindByName(column = "EQY_SPLIT_ADJ_INIT_PO_PX")
    public String EQY_SPLIT_ADJ_INIT_PO_PX;

    @CsvBindByName(column = "EQY_FUND_TICKER")
    public String EQY_FUND_TICKER;

    @CsvBindByName(column = "TOTAL_VOTING_SHARES_VALUE")
    public String TOTAL_VOTING_SHARES_VALUE;

    @CsvBindByName(column = "ID_EXCH_SYMBOL")
    public String ID_EXCH_SYMBOL;

    @CsvBindByName(column = "ID_BB_CONNECT")
    public String ID_BB_CONNECT;

    @CsvBindByName(column = "ID_NAICS_CODE")
    public String ID_NAICS_CODE;

    @CsvBindByName(column = "TOTAL_NON_VOTING_SHARES_VALUE")
    public String TOTAL_NON_VOTING_SHARES_VALUE;

    @CsvBindByName(column = "CDR_SETTLE_CODE")
    public String CDR_SETTLE_CODE;

    @CsvBindByName(column = "CFI_CODE")
    public String CFI_CODE;

    @CsvBindByName(column = "ID_BB_GLOBAL")
    public String ID_BB_GLOBAL;

    @CsvBindByName(column = "COMPOSITE_ID_BB_GLOBAL")
    public String COMPOSITE_ID_BB_GLOBAL;

    @CsvBindByName(column = "INDUSTRY_GROUP_NUM")
    public String INDUSTRY_GROUP_NUM;

    @CsvBindByName(column = "INDUSTRY_SECTOR_NUM")
    public String INDUSTRY_SECTOR_NUM;

    @CsvBindByName(column = "EQY_PRIM_SECURITY_CRNCY")
    public String EQY_PRIM_SECURITY_CRNCY;

    @CsvBindByName(column = "ID_BB_SEC_NUM_DES")
    public String ID_BB_SEC_NUM_DES;

    @CsvBindByName(column = "FEED_SOURCE")
    public String FEED_SOURCE;

    @CsvBindByName(column = "ID_BB_GLOBAL_COMPANY")
    public String ID_BB_GLOBAL_COMPANY;

    @CsvBindByName(column = "ID_BB_GLOBAL_COMPANY_NAME")
    public String ID_BB_GLOBAL_COMPANY_NAME;

    @CsvBindByName(column = "UNDERLYING_ID_BB_GLOBAL")
    public String UNDERLYING_ID_BB_GLOBAL;

    @CsvBindByName(column = "PRIMARY_UNDERLYING_ID_BB_GLOBAL")
    public String PRIMARY_UNDERLYING_ID_BB_GLOBAL;

    @CsvBindByName(column = "ID_BB_GLOBAL_SHARE_CLASS_LEVEL")
    public String ID_BB_GLOBAL_SHARE_CLASS_LEVEL;

    @CsvBindByName(column = "PRIM_SECURITY_COMP_ID_BB_GLOBAL")
    public String PRIM_SECURITY_COMP_ID_BB_GLOBAL;

    @CsvBindByName(column = "TRADING_SYSTEM_IDENTIFIER")
    public String TRADING_SYSTEM_IDENTIFIER;

    @CsvBindByName(column = "TRADING_SYSTEM_IDENTIFIER_DES")
    public String TRADING_SYSTEM_IDENTIFIER_DES;

    @CsvBindByName(column = "LSE_SEGMENT")
    public String LSE_SEGMENT;

    @CsvBindByName(column = "LSE_SECTOR")
    public String LSE_SECTOR;

    @CsvBindByName(column = "DBTIMESTAMP")
    public String DBTIMESTAMP;

    // intelliJ generated methods
    public String getDDATE() {
        return DDATE;
    }

    public void setDDATE(String DDATE) {
        this.DDATE = DDATE;
    }

    public String getREGION() {
        return REGION;
    }

    public void setREGION(String REGION) {
        this.REGION = REGION;
    }

    public String getLINE_NUM() {
        return LINE_NUM;
    }

    public void setLINE_NUM(String LINE_NUM) {
        this.LINE_NUM = LINE_NUM;
    }

    public String getID_BB_PARSEKEY() {
        return ID_BB_PARSEKEY;
    }

    public void setID_BB_PARSEKEY(String ID_BB_PARSEKEY) {
        this.ID_BB_PARSEKEY = ID_BB_PARSEKEY;
    }

    public String getFLEX_ID() {
        return FLEX_ID;
    }

    public void setFLEX_ID(String FLEX_ID) {
        this.FLEX_ID = FLEX_ID;
    }

    public String getUNKNOWN1() {
        return UNKNOWN1;
    }

    public void setUNKNOWN1(String UNKNOWN1) {
        this.UNKNOWN1 = UNKNOWN1;
    }

    public String getUNKNOWN2() {
        return UNKNOWN2;
    }

    public void setUNKNOWN2(String UNKNOWN2) {
        this.UNKNOWN2 = UNKNOWN2;
    }

    public String getTICKER() {
        return TICKER;
    }

    public void setTICKER(String TICKER) {
        this.TICKER = TICKER;
    }

    public String getEXCH_CODE() {
        return EXCH_CODE;
    }

    public void setEXCH_CODE(String EXCH_CODE) {
        this.EXCH_CODE = EXCH_CODE;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getCOUNTRY() {
        return COUNTRY;
    }

    public void setCOUNTRY(String COUNTRY) {
        this.COUNTRY = COUNTRY;
    }

    public String getCRNCY() {
        return CRNCY;
    }

    public void setCRNCY(String CRNCY) {
        this.CRNCY = CRNCY;
    }

    public String getSECURITY_TYP() {
        return SECURITY_TYP;
    }

    public void setSECURITY_TYP(String SECURITY_TYP) {
        this.SECURITY_TYP = SECURITY_TYP;
    }

    public String getPAR_AMT() {
        return PAR_AMT;
    }

    public void setPAR_AMT(String PAR_AMT) {
        this.PAR_AMT = PAR_AMT;
    }

    public String getEQY_PRIM_EXCH() {
        return EQY_PRIM_EXCH;
    }

    public void setEQY_PRIM_EXCH(String EQY_PRIM_EXCH) {
        this.EQY_PRIM_EXCH = EQY_PRIM_EXCH;
    }

    public String getEQY_PRIM_EXCH_SHRT() {
        return EQY_PRIM_EXCH_SHRT;
    }

    public void setEQY_PRIM_EXCH_SHRT(String EQY_PRIM_EXCH_SHRT) {
        this.EQY_PRIM_EXCH_SHRT = EQY_PRIM_EXCH_SHRT;
    }

    public String getEQY_SIC_CODE() {
        return EQY_SIC_CODE;
    }

    public void setEQY_SIC_CODE(String EQY_SIC_CODE) {
        this.EQY_SIC_CODE = EQY_SIC_CODE;
    }

    public String getEQY_SIC_NAME() {
        return EQY_SIC_NAME;
    }

    public void setEQY_SIC_NAME(String EQY_SIC_NAME) {
        this.EQY_SIC_NAME = EQY_SIC_NAME;
    }

    public String getINDUSTRY_GROUP() {
        return INDUSTRY_GROUP;
    }

    public void setINDUSTRY_GROUP(String INDUSTRY_GROUP) {
        this.INDUSTRY_GROUP = INDUSTRY_GROUP;
    }

    public String getINDUSTRY_SUBGROUP() {
        return INDUSTRY_SUBGROUP;
    }

    public void setINDUSTRY_SUBGROUP(String INDUSTRY_SUBGROUP) {
        this.INDUSTRY_SUBGROUP = INDUSTRY_SUBGROUP;
    }

    public String getINDUSTRY_SECTOR() {
        return INDUSTRY_SECTOR;
    }

    public void setINDUSTRY_SECTOR(String INDUSTRY_SECTOR) {
        this.INDUSTRY_SECTOR = INDUSTRY_SECTOR;
    }

    public String getID_SEDOL1() {
        return ID_SEDOL1;
    }

    public void setID_SEDOL1(String ID_SEDOL1) {
        this.ID_SEDOL1 = ID_SEDOL1;
    }

    public String getID_WERTPAPIER() {
        return ID_WERTPAPIER;
    }

    public void setID_WERTPAPIER(String ID_WERTPAPIER) {
        this.ID_WERTPAPIER = ID_WERTPAPIER;
    }

    public String getID_ISIN() {
        return ID_ISIN;
    }

    public void setID_ISIN(String ID_ISIN) {
        this.ID_ISIN = ID_ISIN;
    }

    public String getID_DUTCH() {
        return ID_DUTCH;
    }

    public void setID_DUTCH(String ID_DUTCH) {
        this.ID_DUTCH = ID_DUTCH;
    }

    public String getID_VALOREN() {
        return ID_VALOREN;
    }

    public void setID_VALOREN(String ID_VALOREN) {
        this.ID_VALOREN = ID_VALOREN;
    }

    public String getID_FRENCH() {
        return ID_FRENCH;
    }

    public void setID_FRENCH(String ID_FRENCH) {
        this.ID_FRENCH = ID_FRENCH;
    }

    public String getID_BELGIUM() {
        return ID_BELGIUM;
    }

    public void setID_BELGIUM(String ID_BELGIUM) {
        this.ID_BELGIUM = ID_BELGIUM;
    }

    public String getID_BB_COMPANY() {
        return ID_BB_COMPANY;
    }

    public void setID_BB_COMPANY(String ID_BB_COMPANY) {
        this.ID_BB_COMPANY = ID_BB_COMPANY;
    }

    public String getID_BB_SECURITY() {
        return ID_BB_SECURITY;
    }

    public void setID_BB_SECURITY(String ID_BB_SECURITY) {
        this.ID_BB_SECURITY = ID_BB_SECURITY;
    }

    public String getID_CUSIP() {
        return ID_CUSIP;
    }

    public void setID_CUSIP(String ID_CUSIP) {
        this.ID_CUSIP = ID_CUSIP;
    }

    public String getID_COMMON() {
        return ID_COMMON;
    }

    public void setID_COMMON(String ID_COMMON) {
        this.ID_COMMON = ID_COMMON;
    }

    public String getADR_UNDL_TICKER() {
        return ADR_UNDL_TICKER;
    }

    public void setADR_UNDL_TICKER(String ADR_UNDL_TICKER) {
        this.ADR_UNDL_TICKER = ADR_UNDL_TICKER;
    }

    public String getADR_SH_PER_ADR() {
        return ADR_SH_PER_ADR;
    }

    public void setADR_SH_PER_ADR(String ADR_SH_PER_ADR) {
        this.ADR_SH_PER_ADR = ADR_SH_PER_ADR;
    }

    public String getDVD_CRNCY() {
        return DVD_CRNCY;
    }

    public void setDVD_CRNCY(String DVD_CRNCY) {
        this.DVD_CRNCY = DVD_CRNCY;
    }

    public String getEQY_DVD_SH_12M_NET() {
        return EQY_DVD_SH_12M_NET;
    }

    public void setEQY_DVD_SH_12M_NET(String EQY_DVD_SH_12M_NET) {
        this.EQY_DVD_SH_12M_NET = EQY_DVD_SH_12M_NET;
    }

    public String getDVD_SH_12M() {
        return DVD_SH_12M;
    }

    public void setDVD_SH_12M(String DVD_SH_12M) {
        this.DVD_SH_12M = DVD_SH_12M;
    }

    public String getDVD_SH_LAST() {
        return DVD_SH_LAST;
    }

    public void setDVD_SH_LAST(String DVD_SH_LAST) {
        this.DVD_SH_LAST = DVD_SH_LAST;
    }

    public String getLAST_DPS_GROSS() {
        return LAST_DPS_GROSS;
    }

    public void setLAST_DPS_GROSS(String LAST_DPS_GROSS) {
        this.LAST_DPS_GROSS = LAST_DPS_GROSS;
    }

    public String getEQY_DVD_PCT_FRANKED() {
        return EQY_DVD_PCT_FRANKED;
    }

    public void setEQY_DVD_PCT_FRANKED(String EQY_DVD_PCT_FRANKED) {
        this.EQY_DVD_PCT_FRANKED = EQY_DVD_PCT_FRANKED;
    }

    public String getDVD_TYP_LAST() {
        return DVD_TYP_LAST;
    }

    public void setDVD_TYP_LAST(String DVD_TYP_LAST) {
        this.DVD_TYP_LAST = DVD_TYP_LAST;
    }

    public String getDVD_FREQ() {
        return DVD_FREQ;
    }

    public void setDVD_FREQ(String DVD_FREQ) {
        this.DVD_FREQ = DVD_FREQ;
    }

    public String getDVD_PAY_DT() {
        return DVD_PAY_DT;
    }

    public void setDVD_PAY_DT(String DVD_PAY_DT) {
        this.DVD_PAY_DT = DVD_PAY_DT;
    }

    public String getDVD_RECORD_DT() {
        return DVD_RECORD_DT;
    }

    public void setDVD_RECORD_DT(String DVD_RECORD_DT) {
        this.DVD_RECORD_DT = DVD_RECORD_DT;
    }

    public String getDVD_DECLARED_DT() {
        return DVD_DECLARED_DT;
    }

    public void setDVD_DECLARED_DT(String DVD_DECLARED_DT) {
        this.DVD_DECLARED_DT = DVD_DECLARED_DT;
    }

    public String getEQY_SPLIT_DT() {
        return EQY_SPLIT_DT;
    }

    public void setEQY_SPLIT_DT(String EQY_SPLIT_DT) {
        this.EQY_SPLIT_DT = EQY_SPLIT_DT;
    }

    public String getEQY_SPLIT_RATIO() {
        return EQY_SPLIT_RATIO;
    }

    public void setEQY_SPLIT_RATIO(String EQY_SPLIT_RATIO) {
        this.EQY_SPLIT_RATIO = EQY_SPLIT_RATIO;
    }

    public String getDVD_EX_DT() {
        return DVD_EX_DT;
    }

    public void setDVD_EX_DT(String DVD_EX_DT) {
        this.DVD_EX_DT = DVD_EX_DT;
    }

    public String getEQY_DVD_EX_FLAG() {
        return EQY_DVD_EX_FLAG;
    }

    public void setEQY_DVD_EX_FLAG(String EQY_DVD_EX_FLAG) {
        this.EQY_DVD_EX_FLAG = EQY_DVD_EX_FLAG;
    }

    public String getINDUSTRY_SUBGROUP_NUM() {
        return INDUSTRY_SUBGROUP_NUM;
    }

    public void setINDUSTRY_SUBGROUP_NUM(String INDUSTRY_SUBGROUP_NUM) {
        this.INDUSTRY_SUBGROUP_NUM = INDUSTRY_SUBGROUP_NUM;
    }

    public String getCNTRY_ISSUE_ISO() {
        return CNTRY_ISSUE_ISO;
    }

    public void setCNTRY_ISSUE_ISO(String CNTRY_ISSUE_ISO) {
        this.CNTRY_ISSUE_ISO = CNTRY_ISSUE_ISO;
    }

    public String getMARKET_STATUS() {
        return MARKET_STATUS;
    }

    public void setMARKET_STATUS(String MARKET_STATUS) {
        this.MARKET_STATUS = MARKET_STATUS;
    }

    public String getID_BB_PARENT_CO() {
        return ID_BB_PARENT_CO;
    }

    public void setID_BB_PARENT_CO(String ID_BB_PARENT_CO) {
        this.ID_BB_PARENT_CO = ID_BB_PARENT_CO;
    }

    public String getADR_UNDL_CMPID() {
        return ADR_UNDL_CMPID;
    }

    public void setADR_UNDL_CMPID(String ADR_UNDL_CMPID) {
        this.ADR_UNDL_CMPID = ADR_UNDL_CMPID;
    }

    public String getADR_UNDL_SECID() {
        return ADR_UNDL_SECID;
    }

    public void setADR_UNDL_SECID(String ADR_UNDL_SECID) {
        this.ADR_UNDL_SECID = ADR_UNDL_SECID;
    }

    public String getREL_INDEX() {
        return REL_INDEX;
    }

    public void setREL_INDEX(String REL_INDEX) {
        this.REL_INDEX = REL_INDEX;
    }

    public String getPX_TRADE_LOT_SIZE() {
        return PX_TRADE_LOT_SIZE;
    }

    public void setPX_TRADE_LOT_SIZE(String PX_TRADE_LOT_SIZE) {
        this.PX_TRADE_LOT_SIZE = PX_TRADE_LOT_SIZE;
    }

    public String getPARENT_COMP_TICKER() {
        return PARENT_COMP_TICKER;
    }

    public void setPARENT_COMP_TICKER(String PARENT_COMP_TICKER) {
        this.PARENT_COMP_TICKER = PARENT_COMP_TICKER;
    }

    public String getPARENT_COMP_NAME() {
        return PARENT_COMP_NAME;
    }

    public void setPARENT_COMP_NAME(String PARENT_COMP_NAME) {
        this.PARENT_COMP_NAME = PARENT_COMP_NAME;
    }

    public String getID_LOCAL() {
        return ID_LOCAL;
    }

    public void setID_LOCAL(String ID_LOCAL) {
        this.ID_LOCAL = ID_LOCAL;
    }

    public String getLONG_COMP_NAME() {
        return LONG_COMP_NAME;
    }

    public void setLONG_COMP_NAME(String LONG_COMP_NAME) {
        this.LONG_COMP_NAME = LONG_COMP_NAME;
    }

    public String getPARENT_INDUSTRY_GROUP() {
        return PARENT_INDUSTRY_GROUP;
    }

    public void setPARENT_INDUSTRY_GROUP(String PARENT_INDUSTRY_GROUP) {
        this.PARENT_INDUSTRY_GROUP = PARENT_INDUSTRY_GROUP;
    }

    public String getPARENT_INDUSTRY_SUBGROUP() {
        return PARENT_INDUSTRY_SUBGROUP;
    }

    public void setPARENT_INDUSTRY_SUBGROUP(String PARENT_INDUSTRY_SUBGROUP) {
        this.PARENT_INDUSTRY_SUBGROUP = PARENT_INDUSTRY_SUBGROUP;
    }

    public String getPARENT_INDUSTRY_SECTOR() {
        return PARENT_INDUSTRY_SECTOR;
    }

    public void setPARENT_INDUSTRY_SECTOR(String PARENT_INDUSTRY_SECTOR) {
        this.PARENT_INDUSTRY_SECTOR = PARENT_INDUSTRY_SECTOR;
    }

    public String getVOTING_RIGHTS() {
        return VOTING_RIGHTS;
    }

    public void setVOTING_RIGHTS(String VOTING_RIGHTS) {
        this.VOTING_RIGHTS = VOTING_RIGHTS;
    }

    public String getID_BB_PRIM_SECURITY_FLAG() {
        return ID_BB_PRIM_SECURITY_FLAG;
    }

    public void setID_BB_PRIM_SECURITY_FLAG(String ID_BB_PRIM_SECURITY_FLAG) {
        this.ID_BB_PRIM_SECURITY_FLAG = ID_BB_PRIM_SECURITY_FLAG;
    }

    public String getPAR_VAL_CRNCY() {
        return PAR_VAL_CRNCY;
    }

    public void setPAR_VAL_CRNCY(String PAR_VAL_CRNCY) {
        this.PAR_VAL_CRNCY = PAR_VAL_CRNCY;
    }

    public String getEQY_SH_OUT() {
        return EQY_SH_OUT;
    }

    public void setEQY_SH_OUT(String EQY_SH_OUT) {
        this.EQY_SH_OUT = EQY_SH_OUT;
    }

    public String getEQY_SH_OUT_DT() {
        return EQY_SH_OUT_DT;
    }

    public void setEQY_SH_OUT_DT(String EQY_SH_OUT_DT) {
        this.EQY_SH_OUT_DT = EQY_SH_OUT_DT;
    }

    public String getID_BB_UNIQUE() {
        return ID_BB_UNIQUE;
    }

    public void setID_BB_UNIQUE(String ID_BB_UNIQUE) {
        this.ID_BB_UNIQUE = ID_BB_UNIQUE;
    }

    public String getMARKET_SECTOR_DES() {
        return MARKET_SECTOR_DES;
    }

    public void setMARKET_SECTOR_DES(String MARKET_SECTOR_DES) {
        this.MARKET_SECTOR_DES = MARKET_SECTOR_DES;
    }

    public String getIS_STK_MARGINABLE() {
        return IS_STK_MARGINABLE;
    }

    public void setIS_STK_MARGINABLE(String IS_STK_MARGINABLE) {
        this.IS_STK_MARGINABLE = IS_STK_MARGINABLE;
    }

    public String getA144_FLAG() {
        return A144_FLAG;
    }

    public void setA144_FLAG(String a144_FLAG) {
        A144_FLAG = a144_FLAG;
    }

    public String getTRANSFER_AGENT() {
        return TRANSFER_AGENT;
    }

    public void setTRANSFER_AGENT(String TRANSFER_AGENT) {
        this.TRANSFER_AGENT = TRANSFER_AGENT;
    }

    public String getEQY_PRIM_SECURITY_TICKER() {
        return EQY_PRIM_SECURITY_TICKER;
    }

    public void setEQY_PRIM_SECURITY_TICKER(String EQY_PRIM_SECURITY_TICKER) {
        this.EQY_PRIM_SECURITY_TICKER = EQY_PRIM_SECURITY_TICKER;
    }

    public String getEQY_PRIM_SECURITY_COMP_EXCH() {
        return EQY_PRIM_SECURITY_COMP_EXCH;
    }

    public void setEQY_PRIM_SECURITY_COMP_EXCH(String EQY_PRIM_SECURITY_COMP_EXCH) {
        this.EQY_PRIM_SECURITY_COMP_EXCH = EQY_PRIM_SECURITY_COMP_EXCH;
    }

    public String getIS_SETS() {
        return IS_SETS;
    }

    public void setIS_SETS(String IS_SETS) {
        this.IS_SETS = IS_SETS;
    }

    public String getWHICH_JAPANESE_SECTION() {
        return WHICH_JAPANESE_SECTION;
    }

    public void setWHICH_JAPANESE_SECTION(String WHICH_JAPANESE_SECTION) {
        this.WHICH_JAPANESE_SECTION = WHICH_JAPANESE_SECTION;
    }

    public String getADR_ADR_PER_SH() {
        return ADR_ADR_PER_SH;
    }

    public void setADR_ADR_PER_SH(String ADR_ADR_PER_SH) {
        this.ADR_ADR_PER_SH = ADR_ADR_PER_SH;
    }

    public String getEQY_PRIM_SECURITY_PRIM_EXCH() {
        return EQY_PRIM_SECURITY_PRIM_EXCH;
    }

    public void setEQY_PRIM_SECURITY_PRIM_EXCH(String EQY_PRIM_SECURITY_PRIM_EXCH) {
        this.EQY_PRIM_SECURITY_PRIM_EXCH = EQY_PRIM_SECURITY_PRIM_EXCH;
    }

    public String getEQY_FUND_CRNCY() {
        return EQY_FUND_CRNCY;
    }

    public void setEQY_FUND_CRNCY(String EQY_FUND_CRNCY) {
        this.EQY_FUND_CRNCY = EQY_FUND_CRNCY;
    }

    public String getWHEN_ISSUED() {
        return WHEN_ISSUED;
    }

    public void setWHEN_ISSUED(String WHEN_ISSUED) {
        this.WHEN_ISSUED = WHEN_ISSUED;
    }

    public String getCDR_COUNTRY_CODE() {
        return CDR_COUNTRY_CODE;
    }

    public void setCDR_COUNTRY_CODE(String CDR_COUNTRY_CODE) {
        this.CDR_COUNTRY_CODE = CDR_COUNTRY_CODE;
    }

    public String getCDR_EXCH_CODE() {
        return CDR_EXCH_CODE;
    }

    public void setCDR_EXCH_CODE(String CDR_EXCH_CODE) {
        this.CDR_EXCH_CODE = CDR_EXCH_CODE;
    }

    public String getCNTRY_OF_INCORPORATION() {
        return CNTRY_OF_INCORPORATION;
    }

    public void setCNTRY_OF_INCORPORATION(String CNTRY_OF_INCORPORATION) {
        this.CNTRY_OF_INCORPORATION = CNTRY_OF_INCORPORATION;
    }

    public String getCNTRY_OF_DOMICILE() {
        return CNTRY_OF_DOMICILE;
    }

    public void setCNTRY_OF_DOMICILE(String CNTRY_OF_DOMICILE) {
        this.CNTRY_OF_DOMICILE = CNTRY_OF_DOMICILE;
    }

    public String getSEC_RESTRICT() {
        return SEC_RESTRICT;
    }

    public void setSEC_RESTRICT(String SEC_RESTRICT) {
        this.SEC_RESTRICT = SEC_RESTRICT;
    }

    public String getEQY_SH_OUT_REAL() {
        return EQY_SH_OUT_REAL;
    }

    public void setEQY_SH_OUT_REAL(String EQY_SH_OUT_REAL) {
        this.EQY_SH_OUT_REAL = EQY_SH_OUT_REAL;
    }

    public String getADR_UNDL_CRNCY() {
        return ADR_UNDL_CRNCY;
    }

    public void setADR_UNDL_CRNCY(String ADR_UNDL_CRNCY) {
        this.ADR_UNDL_CRNCY = ADR_UNDL_CRNCY;
    }

    public String getMULTIPLE_SHARE() {
        return MULTIPLE_SHARE;
    }

    public void setMULTIPLE_SHARE(String MULTIPLE_SHARE) {
        this.MULTIPLE_SHARE = MULTIPLE_SHARE;
    }

    public String getPX_QUOTE_LOT_SIZE() {
        return PX_QUOTE_LOT_SIZE;
    }

    public void setPX_QUOTE_LOT_SIZE(String PX_QUOTE_LOT_SIZE) {
        this.PX_QUOTE_LOT_SIZE = PX_QUOTE_LOT_SIZE;
    }

    public String getPX_ROUND_LOT_SIZE() {
        return PX_ROUND_LOT_SIZE;
    }

    public void setPX_ROUND_LOT_SIZE(String PX_ROUND_LOT_SIZE) {
        this.PX_ROUND_LOT_SIZE = PX_ROUND_LOT_SIZE;
    }

    public String getID_SEDOL2() {
        return ID_SEDOL2;
    }

    public void setID_SEDOL2(String ID_SEDOL2) {
        this.ID_SEDOL2 = ID_SEDOL2;
    }

    public String getSEDOL1_COUNTRY_ISO() {
        return SEDOL1_COUNTRY_ISO;
    }

    public void setSEDOL1_COUNTRY_ISO(String SEDOL1_COUNTRY_ISO) {
        this.SEDOL1_COUNTRY_ISO = SEDOL1_COUNTRY_ISO;
    }

    public String getSEDOL2_COUNTRY_ISO() {
        return SEDOL2_COUNTRY_ISO;
    }

    public void setSEDOL2_COUNTRY_ISO(String SEDOL2_COUNTRY_ISO) {
        this.SEDOL2_COUNTRY_ISO = SEDOL2_COUNTRY_ISO;
    }

    public String getID_MIC_PRIM_EXCH() {
        return ID_MIC_PRIM_EXCH;
    }

    public void setID_MIC_PRIM_EXCH(String ID_MIC_PRIM_EXCH) {
        this.ID_MIC_PRIM_EXCH = ID_MIC_PRIM_EXCH;
    }

    public String getID_MIC_LOCAL_EXCH() {
        return ID_MIC_LOCAL_EXCH;
    }

    public void setID_MIC_LOCAL_EXCH(String ID_MIC_LOCAL_EXCH) {
        this.ID_MIC_LOCAL_EXCH = ID_MIC_LOCAL_EXCH;
    }

    public String getEQY_SH_OUT_TOT_MULT_SH() {
        return EQY_SH_OUT_TOT_MULT_SH;
    }

    public void setEQY_SH_OUT_TOT_MULT_SH(String EQY_SH_OUT_TOT_MULT_SH) {
        this.EQY_SH_OUT_TOT_MULT_SH = EQY_SH_OUT_TOT_MULT_SH;
    }

    public String getSECURITY_TYP2() {
        return SECURITY_TYP2;
    }

    public void setSECURITY_TYP2(String SECURITY_TYP2) {
        this.SECURITY_TYP2 = SECURITY_TYP2;
    }

    public String getID_BB_PRIM_SECURITY() {
        return ID_BB_PRIM_SECURITY;
    }

    public void setID_BB_PRIM_SECURITY(String ID_BB_PRIM_SECURITY) {
        this.ID_BB_PRIM_SECURITY = ID_BB_PRIM_SECURITY;
    }

    public String getEQY_OPT_AVAIL() {
        return EQY_OPT_AVAIL;
    }

    public void setEQY_OPT_AVAIL(String EQY_OPT_AVAIL) {
        this.EQY_OPT_AVAIL = EQY_OPT_AVAIL;
    }

    public String getEQY_FREE_FLOAT_PCT() {
        return EQY_FREE_FLOAT_PCT;
    }

    public void setEQY_FREE_FLOAT_PCT(String EQY_FREE_FLOAT_PCT) {
        this.EQY_FREE_FLOAT_PCT = EQY_FREE_FLOAT_PCT;
    }

    public String getTICKER_AND_EXCH_CODE() {
        return TICKER_AND_EXCH_CODE;
    }

    public void setTICKER_AND_EXCH_CODE(String TICKER_AND_EXCH_CODE) {
        this.TICKER_AND_EXCH_CODE = TICKER_AND_EXCH_CODE;
    }

    public String getEQY_INIT_PO_DT() {
        return EQY_INIT_PO_DT;
    }

    public void setEQY_INIT_PO_DT(String EQY_INIT_PO_DT) {
        this.EQY_INIT_PO_DT = EQY_INIT_PO_DT;
    }

    public String getEQY_PO_DT() {
        return EQY_PO_DT;
    }

    public void setEQY_PO_DT(String EQY_PO_DT) {
        this.EQY_PO_DT = EQY_PO_DT;
    }

    public String getEQY_INIT_PO_SH_PX() {
        return EQY_INIT_PO_SH_PX;
    }

    public void setEQY_INIT_PO_SH_PX(String EQY_INIT_PO_SH_PX) {
        this.EQY_INIT_PO_SH_PX = EQY_INIT_PO_SH_PX;
    }

    public String getEQY_SPLIT_ADJ_INIT_PO_PX() {
        return EQY_SPLIT_ADJ_INIT_PO_PX;
    }

    public void setEQY_SPLIT_ADJ_INIT_PO_PX(String EQY_SPLIT_ADJ_INIT_PO_PX) {
        this.EQY_SPLIT_ADJ_INIT_PO_PX = EQY_SPLIT_ADJ_INIT_PO_PX;
    }

    public String getEQY_FUND_TICKER() {
        return EQY_FUND_TICKER;
    }

    public void setEQY_FUND_TICKER(String EQY_FUND_TICKER) {
        this.EQY_FUND_TICKER = EQY_FUND_TICKER;
    }

    public String getTOTAL_VOTING_SHARES_VALUE() {
        return TOTAL_VOTING_SHARES_VALUE;
    }

    public void setTOTAL_VOTING_SHARES_VALUE(String TOTAL_VOTING_SHARES_VALUE) {
        this.TOTAL_VOTING_SHARES_VALUE = TOTAL_VOTING_SHARES_VALUE;
    }

    public String getID_EXCH_SYMBOL() {
        return ID_EXCH_SYMBOL;
    }

    public void setID_EXCH_SYMBOL(String ID_EXCH_SYMBOL) {
        this.ID_EXCH_SYMBOL = ID_EXCH_SYMBOL;
    }

    public String getID_BB_CONNECT() {
        return ID_BB_CONNECT;
    }

    public void setID_BB_CONNECT(String ID_BB_CONNECT) {
        this.ID_BB_CONNECT = ID_BB_CONNECT;
    }

    public String getID_NAICS_CODE() {
        return ID_NAICS_CODE;
    }

    public void setID_NAICS_CODE(String ID_NAICS_CODE) {
        this.ID_NAICS_CODE = ID_NAICS_CODE;
    }

    public String getTOTAL_NON_VOTING_SHARES_VALUE() {
        return TOTAL_NON_VOTING_SHARES_VALUE;
    }

    public void setTOTAL_NON_VOTING_SHARES_VALUE(String TOTAL_NON_VOTING_SHARES_VALUE) {
        this.TOTAL_NON_VOTING_SHARES_VALUE = TOTAL_NON_VOTING_SHARES_VALUE;
    }

    public String getCDR_SETTLE_CODE() {
        return CDR_SETTLE_CODE;
    }

    public void setCDR_SETTLE_CODE(String CDR_SETTLE_CODE) {
        this.CDR_SETTLE_CODE = CDR_SETTLE_CODE;
    }

    public String getCFI_CODE() {
        return CFI_CODE;
    }

    public void setCFI_CODE(String CFI_CODE) {
        this.CFI_CODE = CFI_CODE;
    }

    public String getID_BB_GLOBAL() {
        return ID_BB_GLOBAL;
    }

    public void setID_BB_GLOBAL(String ID_BB_GLOBAL) {
        this.ID_BB_GLOBAL = ID_BB_GLOBAL;
    }

    public String getCOMPOSITE_ID_BB_GLOBAL() {
        return COMPOSITE_ID_BB_GLOBAL;
    }

    public void setCOMPOSITE_ID_BB_GLOBAL(String COMPOSITE_ID_BB_GLOBAL) {
        this.COMPOSITE_ID_BB_GLOBAL = COMPOSITE_ID_BB_GLOBAL;
    }

    public String getINDUSTRY_GROUP_NUM() {
        return INDUSTRY_GROUP_NUM;
    }

    public void setINDUSTRY_GROUP_NUM(String INDUSTRY_GROUP_NUM) {
        this.INDUSTRY_GROUP_NUM = INDUSTRY_GROUP_NUM;
    }

    public String getINDUSTRY_SECTOR_NUM() {
        return INDUSTRY_SECTOR_NUM;
    }

    public void setINDUSTRY_SECTOR_NUM(String INDUSTRY_SECTOR_NUM) {
        this.INDUSTRY_SECTOR_NUM = INDUSTRY_SECTOR_NUM;
    }

    public String getEQY_PRIM_SECURITY_CRNCY() {
        return EQY_PRIM_SECURITY_CRNCY;
    }

    public void setEQY_PRIM_SECURITY_CRNCY(String EQY_PRIM_SECURITY_CRNCY) {
        this.EQY_PRIM_SECURITY_CRNCY = EQY_PRIM_SECURITY_CRNCY;
    }

    public String getID_BB_SEC_NUM_DES() {
        return ID_BB_SEC_NUM_DES;
    }

    public void setID_BB_SEC_NUM_DES(String ID_BB_SEC_NUM_DES) {
        this.ID_BB_SEC_NUM_DES = ID_BB_SEC_NUM_DES;
    }

    public String getFEED_SOURCE() {
        return FEED_SOURCE;
    }

    public void setFEED_SOURCE(String FEED_SOURCE) {
        this.FEED_SOURCE = FEED_SOURCE;
    }

    public String getID_BB_GLOBAL_COMPANY() {
        return ID_BB_GLOBAL_COMPANY;
    }

    public void setID_BB_GLOBAL_COMPANY(String ID_BB_GLOBAL_COMPANY) {
        this.ID_BB_GLOBAL_COMPANY = ID_BB_GLOBAL_COMPANY;
    }

    public String getID_BB_GLOBAL_COMPANY_NAME() {
        return ID_BB_GLOBAL_COMPANY_NAME;
    }

    public void setID_BB_GLOBAL_COMPANY_NAME(String ID_BB_GLOBAL_COMPANY_NAME) {
        this.ID_BB_GLOBAL_COMPANY_NAME = ID_BB_GLOBAL_COMPANY_NAME;
    }

    public String getUNDERLYING_ID_BB_GLOBAL() {
        return UNDERLYING_ID_BB_GLOBAL;
    }

    public void setUNDERLYING_ID_BB_GLOBAL(String UNDERLYING_ID_BB_GLOBAL) {
        this.UNDERLYING_ID_BB_GLOBAL = UNDERLYING_ID_BB_GLOBAL;
    }

    public String getPRIMARY_UNDERLYING_ID_BB_GLOBAL() {
        return PRIMARY_UNDERLYING_ID_BB_GLOBAL;
    }

    public void setPRIMARY_UNDERLYING_ID_BB_GLOBAL(String PRIMARY_UNDERLYING_ID_BB_GLOBAL) {
        this.PRIMARY_UNDERLYING_ID_BB_GLOBAL = PRIMARY_UNDERLYING_ID_BB_GLOBAL;
    }

    public String getID_BB_GLOBAL_SHARE_CLASS_LEVEL() {
        return ID_BB_GLOBAL_SHARE_CLASS_LEVEL;
    }

    public void setID_BB_GLOBAL_SHARE_CLASS_LEVEL(String ID_BB_GLOBAL_SHARE_CLASS_LEVEL) {
        this.ID_BB_GLOBAL_SHARE_CLASS_LEVEL = ID_BB_GLOBAL_SHARE_CLASS_LEVEL;
    }

    public String getPRIM_SECURITY_COMP_ID_BB_GLOBAL() {
        return PRIM_SECURITY_COMP_ID_BB_GLOBAL;
    }

    public void setPRIM_SECURITY_COMP_ID_BB_GLOBAL(String PRIM_SECURITY_COMP_ID_BB_GLOBAL) {
        this.PRIM_SECURITY_COMP_ID_BB_GLOBAL = PRIM_SECURITY_COMP_ID_BB_GLOBAL;
    }

    public String getTRADING_SYSTEM_IDENTIFIER() {
        return TRADING_SYSTEM_IDENTIFIER;
    }

    public void setTRADING_SYSTEM_IDENTIFIER(String TRADING_SYSTEM_IDENTIFIER) {
        this.TRADING_SYSTEM_IDENTIFIER = TRADING_SYSTEM_IDENTIFIER;
    }

    public String getTRADING_SYSTEM_IDENTIFIER_DES() {
        return TRADING_SYSTEM_IDENTIFIER_DES;
    }

    public void setTRADING_SYSTEM_IDENTIFIER_DES(String TRADING_SYSTEM_IDENTIFIER_DES) {
        this.TRADING_SYSTEM_IDENTIFIER_DES = TRADING_SYSTEM_IDENTIFIER_DES;
    }

    public String getLSE_SEGMENT() {
        return LSE_SEGMENT;
    }

    public void setLSE_SEGMENT(String LSE_SEGMENT) {
        this.LSE_SEGMENT = LSE_SEGMENT;
    }

    public String getLSE_SECTOR() {
        return LSE_SECTOR;
    }

    public void setLSE_SECTOR(String LSE_SECTOR) {
        this.LSE_SECTOR = LSE_SECTOR;
    }

    public String getDBTIMESTAMP() {
        return DBTIMESTAMP;
    }

    public void setDBTIMESTAMP(String DBTIMESTAMP) {
        this.DBTIMESTAMP = DBTIMESTAMP;
    }


}