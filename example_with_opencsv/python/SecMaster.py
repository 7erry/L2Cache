import time
import hazelcast

from hazelcast.serialization.api import Portable
from hazelcast.serialization.predicate import sql


class SecMasterBean(Portable):
    FACTORY_ID = 99
    CLASS_ID = 66

    def __init__(self, 
				 DDATE=None,
				 REGION=None,
				 LINE_NUM=None,
				 ID_BB_PARSEKEY=None,
				 FLEX_ID=None,
				 UNKNOWN1=None,
				 UNKNOWN2=None,
				 TICKER=None,
				 EXCH_CODE=None,
				 NAME=None,
				 COUNTRY=None,
				 CRNCY=None,
				 SECURITY_TYP=None,
				 PAR_AMT=None,
				 EQY_PRIM_EXCH=None,
				 EQY_PRIM_EXCH_SHRT=None,
				 EQY_SIC_CODE=None,
				 EQY_SIC_NAME=None,
				 INDUSTRY_GROUP=None,
				 INDUSTRY_SUBGROUP=None,
				 INDUSTRY_SECTOR=None,
				 ID_SEDOL1=None,
				 ID_WERTPAPIER=None,
				 ID_ISIN=None,
				 ID_DUTCH=None,
				 ID_VALOREN=None,
				 ID_FRENCH=None,
				 ID_BELGIUM=None,
				 ID_BB_COMPANY=None,
				 ID_BB_SECURITY=None,
				 ID_CUSIP=None,
				 ID_COMMON=None,
				 ADR_UNDL_TICKER=None,
				 ADR_SH_PER_ADR=None,
				 DVD_CRNCY=None,
				 EQY_DVD_SH_12M_NET=None,
				 DVD_SH_12M=None,
				 DVD_SH_LAST=None,
				 LAST_DPS_GROSS=None,
				 EQY_DVD_PCT_FRANKED=None,
				 DVD_TYP_LAST=None,
				 DVD_FREQ=None,
				 DVD_PAY_DT=None,
				 DVD_RECORD_DT=None,
				 DVD_DECLARED_DT=None,
				 EQY_SPLIT_DT=None,
				 EQY_SPLIT_RATIO=None,
				 DVD_EX_DT=None,
				 EQY_DVD_EX_FLAG=None,
				 INDUSTRY_SUBGROUP_NUM=None,
				 CNTRY_ISSUE_ISO=None,
				 MARKET_STATUS=None,
				 ID_BB_PARENT_CO=None,
				 ADR_UNDL_CMPID=None,
				 ADR_UNDL_SECID=None,
				 REL_INDEX=None,
				 PX_TRADE_LOT_SIZE=None,
				 PARENT_COMP_TICKER=None,
				 PARENT_COMP_NAME=None,
				 ID_LOCAL=None,
				 LONG_COMP_NAME=None,
				 PARENT_INDUSTRY_GROUP=None,
				 PARENT_INDUSTRY_SUBGROUP=None,
				 PARENT_INDUSTRY_SECTOR=None,
				 VOTING_RIGHTS=None,
				 ID_BB_PRIM_SECURITY_FLAG=None,
				 PAR_VAL_CRNCY=None,
				 EQY_SH_OUT=None,
				 EQY_SH_OUT_DT=None,
				 ID_BB_UNIQUE=None,
				 MARKET_SECTOR_DES=None,
				 IS_STK_MARGINABLE=None,
				 A144_FLAG=None,
				 TRANSFER_AGENT=None,
				 EQY_PRIM_SECURITY_TICKER=None,
				 EQY_PRIM_SECURITY_COMP_EXCH=None,
				 IS_SETS=None,
				 WHICH_JAPANESE_SECTION=None,
				 ADR_ADR_PER_SH=None,
				 EQY_PRIM_SECURITY_PRIM_EXCH=None,
				 EQY_FUND_CRNCY=None,
				 WHEN_ISSUED=None,
				 CDR_COUNTRY_CODE=None,
				 CDR_EXCH_CODE=None,
				 CNTRY_OF_INCORPORATION=None,
				 CNTRY_OF_DOMICILE=None,
				 SEC_RESTRICT=None,
				 EQY_SH_OUT_REAL=None,
				 ADR_UNDL_CRNCY=None,
				 MULTIPLE_SHARE=None,
				 PX_QUOTE_LOT_SIZE=None,
				 PX_ROUND_LOT_SIZE=None,
				 ID_SEDOL2=None,
				 SEDOL1_COUNTRY_ISO=None,
				 SEDOL2_COUNTRY_ISO=None,
				 ID_MIC_PRIM_EXCH=None,
				 ID_MIC_LOCAL_EXCH=None,
				 EQY_SH_OUT_TOT_MULT_SH=None,
				 SECURITY_TYP2=None,
				 ID_BB_PRIM_SECURITY=None,
				 EQY_OPT_AVAIL=None,
				 EQY_FREE_FLOAT_PCT=None,
				 TICKER_AND_EXCH_CODE=None,
				 EQY_INIT_PO_DT=None,
				 EQY_PO_DT=None,
				 EQY_INIT_PO_SH_PX=None,
				 EQY_SPLIT_ADJ_INIT_PO_PX=None,
				 EQY_FUND_TICKER=None,
				 TOTAL_VOTING_SHARES_VALUE=None,
				 ID_EXCH_SYMBOL=None,
				 ID_BB_CONNECT=None,
				 ID_NAICS_CODE=None,
				 TOTAL_NON_VOTING_SHARES_VALUE=None,
				 CDR_SETTLE_CODE=None,
				 CFI_CODE=None,
				 ID_BB_GLOBAL=None,
				 COMPOSITE_ID_BB_GLOBAL=None,
				 INDUSTRY_GROUP_NUM=None,
				 INDUSTRY_SECTOR_NUM=None,
				 EQY_PRIM_SECURITY_CRNCY=None,
				 ID_BB_SEC_NUM_DES=None,
				 FEED_SOURCE=None,
				 ID_BB_GLOBAL_COMPANY=None,
				 ID_BB_GLOBAL_COMPANY_NAME=None,
				 UNDERLYING_ID_BB_GLOBAL=None,
				 PRIMARY_UNDERLYING_ID_BB_GLOBAL=None,
				 ID_BB_GLOBAL_SHARE_CLASS_LEVEL=None,
				 PRIM_SECURITY_COMP_ID_BB_GLOBAL=None,
				 TRADING_SYSTEM_IDENTIFIER=None,
				 TRADING_SYSTEM_IDENTIFIER_DES=None,
				 LSE_SEGMENT=None,
				 LSE_SECTOR=None,
				 DBTIMESTAMP=None):
        self.DDATE = DDATE
        self.REGION = REGION
        self.LINE_NUM = LINE_NUM
        self.ID_BB_PARSEKEY = ID_BB_PARSEKEY
        self.FLEX_ID = FLEX_ID
        self.UNKNOWN1 = UNKNOWN1
        self.UNKNOWN2 = UNKNOWN2
        self.TICKER = TICKER
        self.EXCH_CODE = EXCH_CODE
        self.NAME = NAME
        self.COUNTRY = COUNTRY
        self.CRNCY = CRNCY
        self.SECURITY_TYP = SECURITY_TYP
        self.PAR_AMT = PAR_AMT
        self.EQY_PRIM_EXCH = EQY_PRIM_EXCH
        self.EQY_PRIM_EXCH_SHRT = EQY_PRIM_EXCH_SHRT
        self.EQY_SIC_CODE = EQY_SIC_CODE
        self.EQY_SIC_NAME = EQY_SIC_NAME
        self.INDUSTRY_GROUP = INDUSTRY_GROUP
        self.INDUSTRY_SUBGROUP = INDUSTRY_SUBGROUP
        self.INDUSTRY_SECTOR = INDUSTRY_SECTOR
        self.ID_SEDOL1 = ID_SEDOL1
        self.ID_WERTPAPIER = ID_WERTPAPIER
        self.ID_ISIN = ID_ISIN
        self.ID_DUTCH = ID_DUTCH
        self.ID_VALOREN = ID_VALOREN
        self.ID_FRENCH = ID_FRENCH
        self.ID_BELGIUM = ID_BELGIUM
        self.ID_BB_COMPANY = ID_BB_COMPANY
        self.ID_BB_SECURITY = ID_BB_SECURITY
        self.ID_CUSIP = ID_CUSIP
        self.ID_COMMON = ID_COMMON
        self.ADR_UNDL_TICKER = ADR_UNDL_TICKER
        self.ADR_SH_PER_ADR = ADR_SH_PER_ADR
        self.DVD_CRNCY = DVD_CRNCY
        self.EQY_DVD_SH_12M_NET = EQY_DVD_SH_12M_NET
        self.DVD_SH_12M = DVD_SH_12M
        self.DVD_SH_LAST = DVD_SH_LAST
        self.LAST_DPS_GROSS = LAST_DPS_GROSS
        self.EQY_DVD_PCT_FRANKED = EQY_DVD_PCT_FRANKED
        self.DVD_TYP_LAST = DVD_TYP_LAST
        self.DVD_FREQ = DVD_FREQ
        self.DVD_PAY_DT = DVD_PAY_DT
        self.DVD_RECORD_DT = DVD_RECORD_DT
        self.DVD_DECLARED_DT = DVD_DECLARED_DT
        self.EQY_SPLIT_DT = EQY_SPLIT_DT
        self.EQY_SPLIT_RATIO = EQY_SPLIT_RATIO
        self.DVD_EX_DT = DVD_EX_DT
        self.EQY_DVD_EX_FLAG = EQY_DVD_EX_FLAG
        self.INDUSTRY_SUBGROUP_NUM = INDUSTRY_SUBGROUP_NUM
        self.CNTRY_ISSUE_ISO = CNTRY_ISSUE_ISO
        self.MARKET_STATUS = MARKET_STATUS
        self.ID_BB_PARENT_CO = ID_BB_PARENT_CO
        self.ADR_UNDL_CMPID = ADR_UNDL_CMPID
        self.ADR_UNDL_SECID = ADR_UNDL_SECID
        self.REL_INDEX = REL_INDEX
        self.PX_TRADE_LOT_SIZE = PX_TRADE_LOT_SIZE
        self.PARENT_COMP_TICKER = PARENT_COMP_TICKER
        self.PARENT_COMP_NAME = PARENT_COMP_NAME
        self.ID_LOCAL = ID_LOCAL
        self.LONG_COMP_NAME = LONG_COMP_NAME
        self.PARENT_INDUSTRY_GROUP = PARENT_INDUSTRY_GROUP
        self.PARENT_INDUSTRY_SUBGROUP = PARENT_INDUSTRY_SUBGROUP
        self.PARENT_INDUSTRY_SECTOR = PARENT_INDUSTRY_SECTOR
        self.VOTING_RIGHTS = VOTING_RIGHTS
        self.ID_BB_PRIM_SECURITY_FLAG = ID_BB_PRIM_SECURITY_FLAG
        self.PAR_VAL_CRNCY = PAR_VAL_CRNCY
        self.EQY_SH_OUT = EQY_SH_OUT
        self.EQY_SH_OUT_DT = EQY_SH_OUT_DT
        self.ID_BB_UNIQUE = ID_BB_UNIQUE
        self.MARKET_SECTOR_DES = MARKET_SECTOR_DES
        self.IS_STK_MARGINABLE = IS_STK_MARGINABLE
        self.A144_FLAG = A144_FLAG
        self.TRANSFER_AGENT = TRANSFER_AGENT
        self.EQY_PRIM_SECURITY_TICKER = EQY_PRIM_SECURITY_TICKER
        self.EQY_PRIM_SECURITY_COMP_EXCH = EQY_PRIM_SECURITY_COMP_EXCH
        self.IS_SETS = IS_SETS
        self.WHICH_JAPANESE_SECTION = WHICH_JAPANESE_SECTION
        self.ADR_ADR_PER_SH = ADR_ADR_PER_SH
        self.EQY_PRIM_SECURITY_PRIM_EXCH = EQY_PRIM_SECURITY_PRIM_EXCH
        self.EQY_FUND_CRNCY = EQY_FUND_CRNCY
        self.WHEN_ISSUED = WHEN_ISSUED
        self.CDR_COUNTRY_CODE = CDR_COUNTRY_CODE
        self.CDR_EXCH_CODE = CDR_EXCH_CODE
        self.CNTRY_OF_INCORPORATION = CNTRY_OF_INCORPORATION
        self.CNTRY_OF_DOMICILE = CNTRY_OF_DOMICILE
        self.SEC_RESTRICT = SEC_RESTRICT
        self.EQY_SH_OUT_REAL = EQY_SH_OUT_REAL
        self.ADR_UNDL_CRNCY = ADR_UNDL_CRNCY
        self.MULTIPLE_SHARE = MULTIPLE_SHARE
        self.PX_QUOTE_LOT_SIZE = PX_QUOTE_LOT_SIZE
        self.PX_ROUND_LOT_SIZE = PX_ROUND_LOT_SIZE
        self.ID_SEDOL2 = ID_SEDOL2
        self.SEDOL1_COUNTRY_ISO = SEDOL1_COUNTRY_ISO
        self.SEDOL2_COUNTRY_ISO = SEDOL2_COUNTRY_ISO
        self.ID_MIC_PRIM_EXCH = ID_MIC_PRIM_EXCH
        self.ID_MIC_LOCAL_EXCH = ID_MIC_LOCAL_EXCH
        self.EQY_SH_OUT_TOT_MULT_SH = EQY_SH_OUT_TOT_MULT_SH
        self.SECURITY_TYP2 = SECURITY_TYP2
        self.ID_BB_PRIM_SECURITY = ID_BB_PRIM_SECURITY
        self.EQY_OPT_AVAIL = EQY_OPT_AVAIL
        self.EQY_FREE_FLOAT_PCT = EQY_FREE_FLOAT_PCT
        self.TICKER_AND_EXCH_CODE = TICKER_AND_EXCH_CODE
        self.EQY_INIT_PO_DT = EQY_INIT_PO_DT
        self.EQY_PO_DT = EQY_PO_DT
        self.EQY_INIT_PO_SH_PX = EQY_INIT_PO_SH_PX
        self.EQY_SPLIT_ADJ_INIT_PO_PX = EQY_SPLIT_ADJ_INIT_PO_PX
        self.EQY_FUND_TICKER = EQY_FUND_TICKER
        self.TOTAL_VOTING_SHARES_VALUE = TOTAL_VOTING_SHARES_VALUE
        self.ID_EXCH_SYMBOL = ID_EXCH_SYMBOL
        self.ID_BB_CONNECT = ID_BB_CONNECT
        self.ID_NAICS_CODE = ID_NAICS_CODE
        self.TOTAL_NON_VOTING_SHARES_VALUE = TOTAL_NON_VOTING_SHARES_VALUE
        self.CDR_SETTLE_CODE = CDR_SETTLE_CODE
        self.CFI_CODE = CFI_CODE
        self.ID_BB_GLOBAL = ID_BB_GLOBAL
        self.COMPOSITE_ID_BB_GLOBAL = COMPOSITE_ID_BB_GLOBAL
        self.INDUSTRY_GROUP_NUM = INDUSTRY_GROUP_NUM
        self.INDUSTRY_SECTOR_NUM = INDUSTRY_SECTOR_NUM
        self.EQY_PRIM_SECURITY_CRNCY = EQY_PRIM_SECURITY_CRNCY
        self.ID_BB_SEC_NUM_DES = ID_BB_SEC_NUM_DES
        self.FEED_SOURCE = FEED_SOURCE
        self.ID_BB_GLOBAL_COMPANY = ID_BB_GLOBAL_COMPANY
        self.ID_BB_GLOBAL_COMPANY_NAME = ID_BB_GLOBAL_COMPANY_NAME
        self.UNDERLYING_ID_BB_GLOBAL = UNDERLYING_ID_BB_GLOBAL
        self.PRIMARY_UNDERLYING_ID_BB_GLOBAL = PRIMARY_UNDERLYING_ID_BB_GLOBAL
        self.ID_BB_GLOBAL_SHARE_CLASS_LEVEL = ID_BB_GLOBAL_SHARE_CLASS_LEVEL
        self.PRIM_SECURITY_COMP_ID_BB_GLOBAL = PRIM_SECURITY_COMP_ID_BB_GLOBAL
        self.TRADING_SYSTEM_IDENTIFIER = TRADING_SYSTEM_IDENTIFIER
        self.TRADING_SYSTEM_IDENTIFIER_DES = TRADING_SYSTEM_IDENTIFIER_DES
        self.LSE_SEGMENT = LSE_SEGMENT
        self.LSE_SECTOR = LSE_SECTOR
        self.DBTIMESTAMP = DBTIMESTAMP
        
    def write_portable(self, writer):
        writer.write_utf("DDATE", self.DDATE)
        writer.write_utf("REGION", self.REGION)
        writer.write_utf("LINE_NUM", self.LINE_NUM)
        writer.write_utf("ID_BB_PARSEKEY", self.ID_BB_PARSEKEY)
        writer.write_utf("FLEX_ID", self.FLEX_ID)
        writer.write_utf("UNKNOWN1", self.UNKNOWN1)
        writer.write_utf("UNKNOWN2", self.UNKNOWN2)
        writer.write_utf("TICKER", self.TICKER)
        writer.write_utf("EXCH_CODE", self.EXCH_CODE)
        writer.write_utf("NAME", self.NAME)
        writer.write_utf("COUNTRY", self.COUNTRY)
        writer.write_utf("CRNCY", self.CRNCY)
        writer.write_utf("SECURITY_TYP", self.SECURITY_TYP)
        writer.write_utf("PAR_AMT", self.PAR_AMT)
        writer.write_utf("EQY_PRIM_EXCH", self.EQY_PRIM_EXCH)
        writer.write_utf("EQY_PRIM_EXCH_SHRT", self.EQY_PRIM_EXCH_SHRT)
        writer.write_utf("EQY_SIC_CODE", self.EQY_SIC_CODE)
        writer.write_utf("EQY_SIC_NAME", self.EQY_SIC_NAME)
        writer.write_utf("INDUSTRY_GROUP", self.INDUSTRY_GROUP)
        writer.write_utf("INDUSTRY_SUBGROUP", self.INDUSTRY_SUBGROUP)
        writer.write_utf("INDUSTRY_SECTOR", self.INDUSTRY_SECTOR)
        writer.write_utf("ID_SEDOL1", self.ID_SEDOL1)
        writer.write_utf("ID_WERTPAPIER", self.ID_WERTPAPIER)
        writer.write_utf("ID_ISIN", self.ID_ISIN)
        writer.write_utf("ID_DUTCH", self.ID_DUTCH)
        writer.write_utf("ID_VALOREN", self.ID_VALOREN)
        writer.write_utf("ID_FRENCH", self.ID_FRENCH)
        writer.write_utf("ID_BELGIUM", self.ID_BELGIUM)
        writer.write_utf("ID_BB_COMPANY", self.ID_BB_COMPANY)
        writer.write_utf("ID_BB_SECURITY", self.ID_BB_SECURITY)
        writer.write_utf("ID_CUSIP", self.ID_CUSIP)
        writer.write_utf("ID_COMMON", self.ID_COMMON)
        writer.write_utf("ADR_UNDL_TICKER", self.ADR_UNDL_TICKER)
        writer.write_utf("ADR_SH_PER_ADR", self.ADR_SH_PER_ADR)
        writer.write_utf("DVD_CRNCY", self.DVD_CRNCY)
        writer.write_utf("EQY_DVD_SH_12M_NET", self.EQY_DVD_SH_12M_NET)
        writer.write_utf("DVD_SH_12M", self.DVD_SH_12M)
        writer.write_utf("DVD_SH_LAST", self.DVD_SH_LAST)
        writer.write_utf("LAST_DPS_GROSS", self.LAST_DPS_GROSS)
        writer.write_utf("EQY_DVD_PCT_FRANKED", self.EQY_DVD_PCT_FRANKED)
        writer.write_utf("DVD_TYP_LAST", self.DVD_TYP_LAST)
        writer.write_utf("DVD_FREQ", self.DVD_FREQ)
        writer.write_utf("DVD_PAY_DT", self.DVD_PAY_DT)
        writer.write_utf("DVD_RECORD_DT", self.DVD_RECORD_DT)
        writer.write_utf("DVD_DECLARED_DT", self.DVD_DECLARED_DT)
        writer.write_utf("EQY_SPLIT_DT", self.EQY_SPLIT_DT)
        writer.write_utf("EQY_SPLIT_RATIO", self.EQY_SPLIT_RATIO)
        writer.write_utf("DVD_EX_DT", self.DVD_EX_DT)
        writer.write_utf("EQY_DVD_EX_FLAG", self.EQY_DVD_EX_FLAG)
        writer.write_utf("INDUSTRY_SUBGROUP_NUM", self.INDUSTRY_SUBGROUP_NUM)
        writer.write_utf("CNTRY_ISSUE_ISO", self.CNTRY_ISSUE_ISO)
        writer.write_utf("MARKET_STATUS", self.MARKET_STATUS)
        writer.write_utf("ID_BB_PARENT_CO", self.ID_BB_PARENT_CO)
        writer.write_utf("ADR_UNDL_CMPID", self.ADR_UNDL_CMPID)
        writer.write_utf("ADR_UNDL_SECID", self.ADR_UNDL_SECID)
        writer.write_utf("REL_INDEX", self.REL_INDEX)
        writer.write_utf("PX_TRADE_LOT_SIZE", self.PX_TRADE_LOT_SIZE)
        writer.write_utf("PARENT_COMP_TICKER", self.PARENT_COMP_TICKER)
        writer.write_utf("PARENT_COMP_NAME", self.PARENT_COMP_NAME)
        writer.write_utf("ID_LOCAL", self.ID_LOCAL)
        writer.write_utf("LONG_COMP_NAME", self.LONG_COMP_NAME)
        writer.write_utf("PARENT_INDUSTRY_GROUP", self.PARENT_INDUSTRY_GROUP)
        writer.write_utf("PARENT_INDUSTRY_SUBGROUP", self.PARENT_INDUSTRY_SUBGROUP)
        writer.write_utf("PARENT_INDUSTRY_SECTOR", self.PARENT_INDUSTRY_SECTOR)
        writer.write_utf("VOTING_RIGHTS", self.VOTING_RIGHTS)
        writer.write_utf("ID_BB_PRIM_SECURITY_FLAG", self.ID_BB_PRIM_SECURITY_FLAG)
        writer.write_utf("PAR_VAL_CRNCY", self.PAR_VAL_CRNCY)
        writer.write_utf("EQY_SH_OUT", self.EQY_SH_OUT)
        writer.write_utf("EQY_SH_OUT_DT", self.EQY_SH_OUT_DT)
        writer.write_utf("ID_BB_UNIQUE", self.ID_BB_UNIQUE)
        writer.write_utf("MARKET_SECTOR_DES", self.MARKET_SECTOR_DES)
        writer.write_utf("IS_STK_MARGINABLE", self.IS_STK_MARGINABLE)
        writer.write_utf("A144_FLAG", self.A144_FLAG)
        writer.write_utf("TRANSFER_AGENT", self.TRANSFER_AGENT)
        writer.write_utf("EQY_PRIM_SECURITY_TICKER", self.EQY_PRIM_SECURITY_TICKER)
        writer.write_utf("EQY_PRIM_SECURITY_COMP_EXCH", self.EQY_PRIM_SECURITY_COMP_EXCH)
        writer.write_utf("IS_SETS", self.IS_SETS)
        writer.write_utf("WHICH_JAPANESE_SECTION", self.WHICH_JAPANESE_SECTION)
        writer.write_utf("ADR_ADR_PER_SH", self.ADR_ADR_PER_SH)
        writer.write_utf("EQY_PRIM_SECURITY_PRIM_EXCH", self.EQY_PRIM_SECURITY_PRIM_EXCH)
        writer.write_utf("EQY_FUND_CRNCY", self.EQY_FUND_CRNCY)
        writer.write_utf("WHEN_ISSUED", self.WHEN_ISSUED)
        writer.write_utf("CDR_COUNTRY_CODE", self.CDR_COUNTRY_CODE)
        writer.write_utf("CDR_EXCH_CODE", self.CDR_EXCH_CODE)
        writer.write_utf("CNTRY_OF_INCORPORATION", self.CNTRY_OF_INCORPORATION)
        writer.write_utf("CNTRY_OF_DOMICILE", self.CNTRY_OF_DOMICILE)
        writer.write_utf("SEC_RESTRICT", self.SEC_RESTRICT)
        writer.write_utf("EQY_SH_OUT_REAL", self.EQY_SH_OUT_REAL)
        writer.write_utf("ADR_UNDL_CRNCY", self.ADR_UNDL_CRNCY)
        writer.write_utf("MULTIPLE_SHARE", self.MULTIPLE_SHARE)
        writer.write_utf("PX_QUOTE_LOT_SIZE", self.PX_QUOTE_LOT_SIZE)
        writer.write_utf("PX_ROUND_LOT_SIZE", self.PX_ROUND_LOT_SIZE)
        writer.write_utf("ID_SEDOL2", self.ID_SEDOL2)
        writer.write_utf("SEDOL1_COUNTRY_ISO", self.SEDOL1_COUNTRY_ISO)
        writer.write_utf("SEDOL2_COUNTRY_ISO", self.SEDOL2_COUNTRY_ISO)
        writer.write_utf("ID_MIC_PRIM_EXCH", self.ID_MIC_PRIM_EXCH)
        writer.write_utf("ID_MIC_LOCAL_EXCH", self.ID_MIC_LOCAL_EXCH)
        writer.write_utf("EQY_SH_OUT_TOT_MULT_SH", self.EQY_SH_OUT_TOT_MULT_SH)
        writer.write_utf("SECURITY_TYP2", self.SECURITY_TYP2)
        writer.write_utf("ID_BB_PRIM_SECURITY", self.ID_BB_PRIM_SECURITY)
        writer.write_utf("EQY_OPT_AVAIL", self.EQY_OPT_AVAIL)
        writer.write_utf("EQY_FREE_FLOAT_PCT", self.EQY_FREE_FLOAT_PCT)
        writer.write_utf("TICKER_AND_EXCH_CODE", self.TICKER_AND_EXCH_CODE)
        writer.write_utf("EQY_INIT_PO_DT", self.EQY_INIT_PO_DT)
        writer.write_utf("EQY_PO_DT", self.EQY_PO_DT)
        writer.write_utf("EQY_INIT_PO_SH_PX", self.EQY_INIT_PO_SH_PX)
        writer.write_utf("EQY_SPLIT_ADJ_INIT_PO_PX", self.EQY_SPLIT_ADJ_INIT_PO_PX)
        writer.write_utf("EQY_FUND_TICKER", self.EQY_FUND_TICKER)
        writer.write_utf("TOTAL_VOTING_SHARES_VALUE", self.TOTAL_VOTING_SHARES_VALUE)
        writer.write_utf("ID_EXCH_SYMBOL", self.ID_EXCH_SYMBOL)
        writer.write_utf("ID_BB_CONNECT", self.ID_BB_CONNECT)
        writer.write_utf("ID_NAICS_CODE", self.ID_NAICS_CODE)
        writer.write_utf("TOTAL_NON_VOTING_SHARES_VALUE", self.TOTAL_NON_VOTING_SHARES_VALUE)
        writer.write_utf("CDR_SETTLE_CODE", self.CDR_SETTLE_CODE)
        writer.write_utf("CFI_CODE", self.CFI_CODE)
        writer.write_utf("ID_BB_GLOBAL", self.ID_BB_GLOBAL)
        writer.write_utf("COMPOSITE_ID_BB_GLOBAL", self.COMPOSITE_ID_BB_GLOBAL)
        writer.write_utf("INDUSTRY_GROUP_NUM", self.INDUSTRY_GROUP_NUM)
        writer.write_utf("INDUSTRY_SECTOR_NUM", self.INDUSTRY_SECTOR_NUM)
        writer.write_utf("EQY_PRIM_SECURITY_CRNCY", self.EQY_PRIM_SECURITY_CRNCY)
        writer.write_utf("ID_BB_SEC_NUM_DES", self.ID_BB_SEC_NUM_DES)
        writer.write_utf("FEED_SOURCE", self.FEED_SOURCE)
        writer.write_utf("ID_BB_GLOBAL_COMPANY", self.ID_BB_GLOBAL_COMPANY)
        writer.write_utf("ID_BB_GLOBAL_COMPANY_NAME", self.ID_BB_GLOBAL_COMPANY_NAME)
        writer.write_utf("UNDERLYING_ID_BB_GLOBAL", self.UNDERLYING_ID_BB_GLOBAL)
        writer.write_utf("PRIMARY_UNDERLYING_ID_BB_GLOBAL", self.PRIMARY_UNDERLYING_ID_BB_GLOBAL)
        writer.write_utf("ID_BB_GLOBAL_SHARE_CLASS_LEVEL", self.ID_BB_GLOBAL_SHARE_CLASS_LEVEL)
        writer.write_utf("PRIM_SECURITY_COMP_ID_BB_GLOBAL", self.PRIM_SECURITY_COMP_ID_BB_GLOBAL)
        writer.write_utf("TRADING_SYSTEM_IDENTIFIER", self.TRADING_SYSTEM_IDENTIFIER)
        writer.write_utf("TRADING_SYSTEM_IDENTIFIER_DES", self.TRADING_SYSTEM_IDENTIFIER_DES)
        writer.write_utf("LSE_SEGMENT", self.LSE_SEGMENT)
        writer.write_utf("LSE_SECTOR", self.LSE_SECTOR)
        writer.write_utf("DBTIMESTAMP", self.DBTIMESTAMP)
        
    def read_portable(self, reader):
        self.DDATE = reader.read_utf("DDATE")
        self.REGION = reader.read_utf("REGION")
        self.LINE_NUM = reader.read_utf("LINE_NUM")
        self.ID_BB_PARSEKEY = reader.read_utf("ID_BB_PARSEKEY")
        self.FLEX_ID = reader.read_utf("FLEX_ID")
        self.UNKNOWN1 = reader.read_utf("UNKNOWN1")
        self.UNKNOWN2 = reader.read_utf("UNKNOWN2")
        self.TICKER = reader.read_utf("TICKER")
        self.EXCH_CODE = reader.read_utf("EXCH_CODE")
        self.NAME = reader.read_utf("NAME")
        self.COUNTRY = reader.read_utf("COUNTRY")
        self.CRNCY = reader.read_utf("CRNCY")
        self.SECURITY_TYP = reader.read_utf("SECURITY_TYP")
        self.PAR_AMT = reader.read_utf("PAR_AMT")
        self.EQY_PRIM_EXCH = reader.read_utf("EQY_PRIM_EXCH")
        self.EQY_PRIM_EXCH_SHRT = reader.read_utf("EQY_PRIM_EXCH_SHRT")
        self.EQY_SIC_CODE = reader.read_utf("EQY_SIC_CODE")
        self.EQY_SIC_NAME = reader.read_utf("EQY_SIC_NAME")
        self.INDUSTRY_GROUP = reader.read_utf("INDUSTRY_GROUP")
        self.INDUSTRY_SUBGROUP = reader.read_utf("INDUSTRY_SUBGROUP")
        self.INDUSTRY_SECTOR = reader.read_utf("INDUSTRY_SECTOR")
        self.ID_SEDOL1 = reader.read_utf("ID_SEDOL1")
        self.ID_WERTPAPIER = reader.read_utf("ID_WERTPAPIER")
        self.ID_ISIN = reader.read_utf("ID_ISIN")
        self.ID_DUTCH = reader.read_utf("ID_DUTCH")
        self.ID_VALOREN = reader.read_utf("ID_VALOREN")
        self.ID_FRENCH = reader.read_utf("ID_FRENCH")
        self.ID_BELGIUM = reader.read_utf("ID_BELGIUM")
        self.ID_BB_COMPANY = reader.read_utf("ID_BB_COMPANY")
        self.ID_BB_SECURITY = reader.read_utf("ID_BB_SECURITY")
        self.ID_CUSIP = reader.read_utf("ID_CUSIP")
        self.ID_COMMON = reader.read_utf("ID_COMMON")
        self.ADR_UNDL_TICKER = reader.read_utf("ADR_UNDL_TICKER")
        self.ADR_SH_PER_ADR = reader.read_utf("ADR_SH_PER_ADR")
        self.DVD_CRNCY = reader.read_utf("DVD_CRNCY")
        self.EQY_DVD_SH_12M_NET = reader.read_utf("EQY_DVD_SH_12M_NET")
        self.DVD_SH_12M = reader.read_utf("DVD_SH_12M")
        self.DVD_SH_LAST = reader.read_utf("DVD_SH_LAST")
        self.LAST_DPS_GROSS = reader.read_utf("LAST_DPS_GROSS")
        self.EQY_DVD_PCT_FRANKED = reader.read_utf("EQY_DVD_PCT_FRANKED")
        self.DVD_TYP_LAST = reader.read_utf("DVD_TYP_LAST")
        self.DVD_FREQ = reader.read_utf("DVD_FREQ")
        self.DVD_PAY_DT = reader.read_utf("DVD_PAY_DT")
        self.DVD_RECORD_DT = reader.read_utf("DVD_RECORD_DT")
        self.DVD_DECLARED_DT = reader.read_utf("DVD_DECLARED_DT")
        self.EQY_SPLIT_DT = reader.read_utf("EQY_SPLIT_DT")
        self.EQY_SPLIT_RATIO = reader.read_utf("EQY_SPLIT_RATIO")
        self.DVD_EX_DT = reader.read_utf("DVD_EX_DT")
        self.EQY_DVD_EX_FLAG = reader.read_utf("EQY_DVD_EX_FLAG")
        self.INDUSTRY_SUBGROUP_NUM = reader.read_utf("INDUSTRY_SUBGROUP_NUM")
        self.CNTRY_ISSUE_ISO = reader.read_utf("CNTRY_ISSUE_ISO")
        self.MARKET_STATUS = reader.read_utf("MARKET_STATUS")
        self.ID_BB_PARENT_CO = reader.read_utf("ID_BB_PARENT_CO")
        self.ADR_UNDL_CMPID = reader.read_utf("ADR_UNDL_CMPID")
        self.ADR_UNDL_SECID = reader.read_utf("ADR_UNDL_SECID")
        self.REL_INDEX = reader.read_utf("REL_INDEX")
        self.PX_TRADE_LOT_SIZE = reader.read_utf("PX_TRADE_LOT_SIZE")
        self.PARENT_COMP_TICKER = reader.read_utf("PARENT_COMP_TICKER")
        self.PARENT_COMP_NAME = reader.read_utf("PARENT_COMP_NAME")
        self.ID_LOCAL = reader.read_utf("ID_LOCAL")
        self.LONG_COMP_NAME = reader.read_utf("LONG_COMP_NAME")
        self.PARENT_INDUSTRY_GROUP = reader.read_utf("PARENT_INDUSTRY_GROUP")
        self.PARENT_INDUSTRY_SUBGROUP = reader.read_utf("PARENT_INDUSTRY_SUBGROUP")
        self.PARENT_INDUSTRY_SECTOR = reader.read_utf("PARENT_INDUSTRY_SECTOR")
        self.VOTING_RIGHTS = reader.read_utf("VOTING_RIGHTS")
        self.ID_BB_PRIM_SECURITY_FLAG = reader.read_utf("ID_BB_PRIM_SECURITY_FLAG")
        self.PAR_VAL_CRNCY = reader.read_utf("PAR_VAL_CRNCY")
        self.EQY_SH_OUT = reader.read_utf("EQY_SH_OUT")
        self.EQY_SH_OUT_DT = reader.read_utf("EQY_SH_OUT_DT")
        self.ID_BB_UNIQUE = reader.read_utf("ID_BB_UNIQUE")
        self.MARKET_SECTOR_DES = reader.read_utf("MARKET_SECTOR_DES")
        self.IS_STK_MARGINABLE = reader.read_utf("IS_STK_MARGINABLE")
        self.A144_FLAG = reader.read_utf("A144_FLAG")
        self.TRANSFER_AGENT = reader.read_utf("TRANSFER_AGENT")
        self.EQY_PRIM_SECURITY_TICKER = reader.read_utf("EQY_PRIM_SECURITY_TICKER")
        self.EQY_PRIM_SECURITY_COMP_EXCH = reader.read_utf("EQY_PRIM_SECURITY_COMP_EXCH")
        self.IS_SETS = reader.read_utf("IS_SETS")
        self.WHICH_JAPANESE_SECTION = reader.read_utf("WHICH_JAPANESE_SECTION")
        self.ADR_ADR_PER_SH = reader.read_utf("ADR_ADR_PER_SH")
        self.EQY_PRIM_SECURITY_PRIM_EXCH = reader.read_utf("EQY_PRIM_SECURITY_PRIM_EXCH")
        self.EQY_FUND_CRNCY = reader.read_utf("EQY_FUND_CRNCY")
        self.WHEN_ISSUED = reader.read_utf("WHEN_ISSUED")
        self.CDR_COUNTRY_CODE = reader.read_utf("CDR_COUNTRY_CODE")
        self.CDR_EXCH_CODE = reader.read_utf("CDR_EXCH_CODE")
        self.CNTRY_OF_INCORPORATION = reader.read_utf("CNTRY_OF_INCORPORATION")
        self.CNTRY_OF_DOMICILE = reader.read_utf("CNTRY_OF_DOMICILE")
        self.SEC_RESTRICT = reader.read_utf("SEC_RESTRICT")
        self.EQY_SH_OUT_REAL = reader.read_utf("EQY_SH_OUT_REAL")
        self.ADR_UNDL_CRNCY = reader.read_utf("ADR_UNDL_CRNCY")
        self.MULTIPLE_SHARE = reader.read_utf("MULTIPLE_SHARE")
        self.PX_QUOTE_LOT_SIZE = reader.read_utf("PX_QUOTE_LOT_SIZE")
        self.PX_ROUND_LOT_SIZE = reader.read_utf("PX_ROUND_LOT_SIZE")
        self.ID_SEDOL2 = reader.read_utf("ID_SEDOL2")
        self.SEDOL1_COUNTRY_ISO = reader.read_utf("SEDOL1_COUNTRY_ISO")
        self.SEDOL2_COUNTRY_ISO = reader.read_utf("SEDOL2_COUNTRY_ISO")
        self.ID_MIC_PRIM_EXCH = reader.read_utf("ID_MIC_PRIM_EXCH")
        self.ID_MIC_LOCAL_EXCH = reader.read_utf("ID_MIC_LOCAL_EXCH")
        self.EQY_SH_OUT_TOT_MULT_SH = reader.read_utf("EQY_SH_OUT_TOT_MULT_SH")
        self.SECURITY_TYP2 = reader.read_utf("SECURITY_TYP2")
        self.ID_BB_PRIM_SECURITY = reader.read_utf("ID_BB_PRIM_SECURITY")
        self.EQY_OPT_AVAIL = reader.read_utf("EQY_OPT_AVAIL")
        self.EQY_FREE_FLOAT_PCT = reader.read_utf("EQY_FREE_FLOAT_PCT")
        self.TICKER_AND_EXCH_CODE = reader.read_utf("TICKER_AND_EXCH_CODE")
        self.EQY_INIT_PO_DT = reader.read_utf("EQY_INIT_PO_DT")
        self.EQY_PO_DT = reader.read_utf("EQY_PO_DT")
        self.EQY_INIT_PO_SH_PX = reader.read_utf("EQY_INIT_PO_SH_PX")
        self.EQY_SPLIT_ADJ_INIT_PO_PX = reader.read_utf("EQY_SPLIT_ADJ_INIT_PO_PX")
        self.EQY_FUND_TICKER = reader.read_utf("EQY_FUND_TICKER")
        self.TOTAL_VOTING_SHARES_VALUE = reader.read_utf("TOTAL_VOTING_SHARES_VALUE")
        self.ID_EXCH_SYMBOL = reader.read_utf("ID_EXCH_SYMBOL")
        self.ID_BB_CONNECT = reader.read_utf("ID_BB_CONNECT")
        self.ID_NAICS_CODE = reader.read_utf("ID_NAICS_CODE")
        self.TOTAL_NON_VOTING_SHARES_VALUE = reader.read_utf("TOTAL_NON_VOTING_SHARES_VALUE")
        self.CDR_SETTLE_CODE = reader.read_utf("CDR_SETTLE_CODE")
        self.CFI_CODE = reader.read_utf("CFI_CODE")
        self.ID_BB_GLOBAL = reader.read_utf("ID_BB_GLOBAL")
        self.COMPOSITE_ID_BB_GLOBAL = reader.read_utf("COMPOSITE_ID_BB_GLOBAL")
        self.INDUSTRY_GROUP_NUM = reader.read_utf("INDUSTRY_GROUP_NUM")
        self.INDUSTRY_SECTOR_NUM = reader.read_utf("INDUSTRY_SECTOR_NUM")
        self.EQY_PRIM_SECURITY_CRNCY = reader.read_utf("EQY_PRIM_SECURITY_CRNCY")
        self.ID_BB_SEC_NUM_DES = reader.read_utf("ID_BB_SEC_NUM_DES")
        self.FEED_SOURCE = reader.read_utf("FEED_SOURCE")
        self.ID_BB_GLOBAL_COMPANY = reader.read_utf("ID_BB_GLOBAL_COMPANY")
        self.ID_BB_GLOBAL_COMPANY_NAME = reader.read_utf("ID_BB_GLOBAL_COMPANY_NAME")
        self.UNDERLYING_ID_BB_GLOBAL = reader.read_utf("UNDERLYING_ID_BB_GLOBAL")
        self.PRIMARY_UNDERLYING_ID_BB_GLOBAL = reader.read_utf("PRIMARY_UNDERLYING_ID_BB_GLOBAL")
        self.ID_BB_GLOBAL_SHARE_CLASS_LEVEL = reader.read_utf("ID_BB_GLOBAL_SHARE_CLASS_LEVEL")
        self.PRIM_SECURITY_COMP_ID_BB_GLOBAL = reader.read_utf("PRIM_SECURITY_COMP_ID_BB_GLOBAL")
        self.TRADING_SYSTEM_IDENTIFIER = reader.read_utf("TRADING_SYSTEM_IDENTIFIER")
        self.TRADING_SYSTEM_IDENTIFIER_DES = reader.read_utf("TRADING_SYSTEM_IDENTIFIER_DES")
        self.LSE_SEGMENT = reader.read_utf("LSE_SEGMENT")
        self.LSE_SECTOR = reader.read_utf("LSE_SECTOR")
        self.DBTIMESTAMP = reader.read_utf("DBTIMESTAMP")
        
    def get_factory_id(self):
        return self.FACTORY_ID

    def get_class_id(self):
        return self.CLASS_ID

    def __str__(self):
        return "SecMasterBean[ DDATE:{}  ]".format(self.DDATE )

    def __eq__(self, other):
        return type(self) == type(other) and self.ID_COMMON == other.ID_COMMON 


if __name__ == '__main__':
    config = hazelcast.ClientConfig()

    # add serialization for our SecMasterBean using Portable Serialization
    config.serialization_config.portable_factories[SecMasterBean.FACTORY_ID] = \
        {SecMasterBean.CLASS_ID: SecMasterBean}

    client = hazelcast.HazelcastClient(config)

    # Get a local instance to the distributed IMap
    my_map = client.get_map("demo.exoduspoint.beans.SecMasterBean")

    # see the current size
    print("Map Size: {}".format(my_map.size().result()))

    # perform sql search
    predicate = sql("NAME like 'B%' and ID_COMMON='3299'")

    def values_callback(f):
        result_set = f.result()
        print("Query Result Size: {}".format(len(result_set)))
        for value in result_set:
            print("\tvalue: {}".format(value.NAME))
            print("\tvalue: {}".format(value.ID_COMMON))

    my_map.values(predicate).add_done_callback(values_callback)

    # async call needs some time to complete prior to exiting
    time.sleep(2)
    client.shutdown()
