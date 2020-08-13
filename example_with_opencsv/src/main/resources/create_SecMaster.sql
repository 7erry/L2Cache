CREATE TABLE `BLOOMBERG_TZERO_OUT_V2` (
  `DDATE` varchar(500) DEFAULT NULL,
  `REGION` varchar(500) DEFAULT NULL,
  `LINE_NUM` varchar(500) DEFAULT NULL,
  `ID_BB_PARSEKEY` varchar(500) DEFAULT NULL,
  `FLEX_ID` varchar(500) DEFAULT NULL,
  `UNKNOWN1` varchar(500) DEFAULT NULL,
  `UNKNOWN2` varchar(500) DEFAULT NULL,
  `TICKER` varchar(500) DEFAULT NULL,
  `EXCH_CODE` varchar(500) DEFAULT NULL,
  `NAME` varchar(500) DEFAULT NULL,
  `COUNTRY` varchar(500) DEFAULT NULL,
  `CRNCY` varchar(500) DEFAULT NULL,
  `SECURITY_TYP` varchar(500) DEFAULT NULL,
  `PAR_AMT` varchar(500) DEFAULT NULL,
  `EQY_PRIM_EXCH` varchar(500) DEFAULT NULL,
  `EQY_PRIM_EXCH_SHRT` varchar(500) DEFAULT NULL,
  `EQY_SIC_CODE` varchar(500) DEFAULT NULL,
  `EQY_SIC_NAME` varchar(500) DEFAULT NULL,
  `INDUSTRY_GROUP` varchar(500) DEFAULT NULL,
  `INDUSTRY_SUBGROUP` varchar(500) DEFAULT NULL,
  `INDUSTRY_SECTOR` varchar(500) DEFAULT NULL,
  `ID_SEDOL1` varchar(12) DEFAULT NULL,
  `ID_WERTPAPIER` varchar(500) DEFAULT NULL,
  `ID_ISIN` varchar(30) DEFAULT NULL,
  `ID_DUTCH` varchar(500) DEFAULT NULL,
  `ID_VALOREN` varchar(500) DEFAULT NULL,
  `ID_FRENCH` varchar(500) DEFAULT NULL,
  `ID_BELGIUM` varchar(500) DEFAULT NULL,
  `ID_BB_COMPANY` varchar(500) DEFAULT NULL,
  `ID_BB_SECURITY` varchar(500) DEFAULT NULL,
  `ID_CUSIP` varchar(17) DEFAULT NULL,
  `ID_COMMON` varchar(500) DEFAULT NULL,
  `ADR_UNDL_TICKER` varchar(500) DEFAULT NULL,
  `ADR_SH_PER_ADR` varchar(500) DEFAULT NULL,
  `DVD_CRNCY` varchar(500) DEFAULT NULL,
  `EQY_DVD_SH_12M_NET` varchar(500) DEFAULT NULL,
  `DVD_SH_12M` varchar(500) DEFAULT NULL,
  `DVD_SH_LAST` varchar(500) DEFAULT NULL,
  `LAST_DPS_GROSS` varchar(500) DEFAULT NULL,
  `EQY_DVD_PCT_FRANKED` varchar(500) DEFAULT NULL,
  `DVD_TYP_LAST` varchar(500) DEFAULT NULL,
  `DVD_FREQ` varchar(500) DEFAULT NULL,
  `DVD_PAY_DT` varchar(500) DEFAULT NULL,
  `DVD_RECORD_DT` varchar(500) DEFAULT NULL,
  `DVD_DECLARED_DT` varchar(500) DEFAULT NULL,
  `EQY_SPLIT_DT` varchar(500) DEFAULT NULL,
  `EQY_SPLIT_RATIO` varchar(500) DEFAULT NULL,
  `DVD_EX_DT` varchar(500) DEFAULT NULL,
  `EQY_DVD_EX_FLAG` varchar(500) DEFAULT NULL,
  `INDUSTRY_SUBGROUP_NUM` varchar(500) DEFAULT NULL,
  `CNTRY_ISSUE_ISO` varchar(500) DEFAULT NULL,
  `MARKET_STATUS` varchar(500) DEFAULT NULL,
  `ID_BB_PARENT_CO` varchar(500) DEFAULT NULL,
  `ADR_UNDL_CMPID` varchar(500) DEFAULT NULL,
  `ADR_UNDL_SECID` varchar(500) DEFAULT NULL,
  `REL_INDEX` varchar(500) DEFAULT NULL,
  `PX_TRADE_LOT_SIZE` varchar(500) DEFAULT NULL,
  `PARENT_COMP_TICKER` varchar(500) DEFAULT NULL,
  `PARENT_COMP_NAME` varchar(500) DEFAULT NULL,
  `ID_LOCAL` varchar(500) DEFAULT NULL,
  `LONG_COMP_NAME` varchar(500) DEFAULT NULL,
  `PARENT_INDUSTRY_GROUP` varchar(500) DEFAULT NULL,
  `PARENT_INDUSTRY_SUBGROUP` varchar(500) DEFAULT NULL,
  `PARENT_INDUSTRY_SECTOR` varchar(500) DEFAULT NULL,
  `VOTING_RIGHTS` varchar(500) DEFAULT NULL,
  `ID_BB_PRIM_SECURITY_FLAG` varchar(500) DEFAULT NULL,
  `PAR_VAL_CRNCY` varchar(500) DEFAULT NULL,
  `EQY_SH_OUT` varchar(500) DEFAULT NULL,
  `EQY_SH_OUT_DT` varchar(500) DEFAULT NULL,
  `ID_BB_UNIQUE` varchar(40) DEFAULT NULL,
  `MARKET_SECTOR_DES` varchar(500) DEFAULT NULL,
  `IS_STK_MARGINABLE` varchar(500) DEFAULT NULL,
  `A144_FLAG` varchar(500) DEFAULT NULL,
  `TRANSFER_AGENT` varchar(500) DEFAULT NULL,
  `EQY_PRIM_SECURITY_TICKER` varchar(500) DEFAULT NULL,
  `EQY_PRIM_SECURITY_COMP_EXCH` varchar(500) DEFAULT NULL,
  `IS_SETS` varchar(500) DEFAULT NULL,
  `WHICH_JAPANESE_SECTION` varchar(500) DEFAULT NULL,
  `ADR_ADR_PER_SH` varchar(500) DEFAULT NULL,
  `EQY_PRIM_SECURITY_PRIM_EXCH` varchar(500) DEFAULT NULL,
  `EQY_FUND_CRNCY` varchar(500) DEFAULT NULL,
  `WHEN_ISSUED` varchar(500) DEFAULT NULL,
  `CDR_COUNTRY_CODE` varchar(500) DEFAULT NULL,
  `CDR_EXCH_CODE` varchar(500) DEFAULT NULL,
  `CNTRY_OF_INCORPORATION` varchar(500) DEFAULT NULL,
  `CNTRY_OF_DOMICILE` varchar(500) DEFAULT NULL,
  `SEC_RESTRICT` varchar(500) DEFAULT NULL,
  `EQY_SH_OUT_REAL` varchar(500) DEFAULT NULL,
  `ADR_UNDL_CRNCY` varchar(500) DEFAULT NULL,
  `MULTIPLE_SHARE` varchar(500) DEFAULT NULL,
  `PX_QUOTE_LOT_SIZE` varchar(500) DEFAULT NULL,
  `PX_ROUND_LOT_SIZE` varchar(500) DEFAULT NULL,
  `ID_SEDOL2` varchar(12) DEFAULT NULL,
  `SEDOL1_COUNTRY_ISO` varchar(500) DEFAULT NULL,
  `SEDOL2_COUNTRY_ISO` varchar(500) DEFAULT NULL,
  `ID_MIC_PRIM_EXCH` varchar(500) DEFAULT NULL,
  `ID_MIC_LOCAL_EXCH` varchar(500) DEFAULT NULL,
  `EQY_SH_OUT_TOT_MULT_SH` varchar(500) DEFAULT NULL,
  `SECURITY_TYP2` varchar(500) DEFAULT NULL,
  `ID_BB_PRIM_SECURITY` varchar(500) DEFAULT NULL,
  `EQY_OPT_AVAIL` varchar(500) DEFAULT NULL,
  `EQY_FREE_FLOAT_PCT` varchar(500) DEFAULT NULL,
  `TICKER_AND_EXCH_CODE` varchar(500) DEFAULT NULL,
  `EQY_INIT_PO_DT` varchar(500) DEFAULT NULL,
  `EQY_PO_DT` varchar(500) DEFAULT NULL,
  `EQY_INIT_PO_SH_PX` varchar(500) DEFAULT NULL,
  `EQY_SPLIT_ADJ_INIT_PO_PX` varchar(500) DEFAULT NULL,
  `EQY_FUND_TICKER` varchar(500) DEFAULT NULL,
  `TOTAL_VOTING_SHARES_VALUE` varchar(500) DEFAULT NULL,
  `ID_EXCH_SYMBOL` varchar(500) DEFAULT NULL,
  `ID_BB_CONNECT` varchar(500) DEFAULT NULL,
  `ID_NAICS_CODE` varchar(500) DEFAULT NULL,
  `TOTAL_NON_VOTING_SHARES_VALUE` varchar(500) DEFAULT NULL,
  `CDR_SETTLE_CODE` varchar(500) DEFAULT NULL,
  `CFI_CODE` varchar(500) DEFAULT NULL,
  `ID_BB_GLOBAL` varchar(40) DEFAULT NULL,
  `COMPOSITE_ID_BB_GLOBAL` varchar(40) DEFAULT NULL,
  `INDUSTRY_GROUP_NUM` varchar(500) DEFAULT NULL,
  `INDUSTRY_SECTOR_NUM` varchar(500) DEFAULT NULL,
  `EQY_PRIM_SECURITY_CRNCY` varchar(500) DEFAULT NULL,
  `ID_BB_SEC_NUM_DES` varchar(500) DEFAULT NULL,
  `FEED_SOURCE` varchar(500) DEFAULT NULL,
  `ID_BB_GLOBAL_COMPANY` varchar(500) DEFAULT NULL,
  `ID_BB_GLOBAL_COMPANY_NAME` varchar(500) DEFAULT NULL,
  `UNDERLYING_ID_BB_GLOBAL` varchar(40) DEFAULT NULL,
  `PRIMARY_UNDERLYING_ID_BB_GLOBAL` varchar(40) DEFAULT NULL,
  `ID_BB_GLOBAL_SHARE_CLASS_LEVEL` varchar(500) DEFAULT NULL,
  `PRIM_SECURITY_COMP_ID_BB_GLOBAL` varchar(40) DEFAULT NULL,
  `TRADING_SYSTEM_IDENTIFIER` varchar(500) DEFAULT NULL,
  `TRADING_SYSTEM_IDENTIFIER_DES` varchar(500) DEFAULT NULL,
  `LSE_SEGMENT` varchar(500) DEFAULT NULL,
  `LSE_SECTOR` varchar(500) DEFAULT NULL,
  `DBTIMESTAMP` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;