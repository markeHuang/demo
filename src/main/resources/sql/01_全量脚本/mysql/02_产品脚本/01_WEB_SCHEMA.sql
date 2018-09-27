-- Excel Generate SQL Script
-- for Mysql 
-- =========='2018/9/27 ������ ���� 10:28:38'==========
CREATE TABLE CSPA_FUN_M  ( 
      REFCODE  DECIMAL(10) DEFAULT 0 NOT NULL  COMMENT '��ˮ��'  
    ,  SYSTEM_TYPE  VARCHAR(2)  NOT NULL  COMMENT '��Դ����[11=��Ӫ��/21=��ҵ��/22=������/23=�ϻ��˶�]'  
    ,  FUNID  VARCHAR(50)  NOT NULL  COMMENT '���ܴ���'  
    ,  SEQNO  DECIMAL(10) DEFAULT 0   COMMENT '���'  
    ,  LAYID  DECIMAL(10) DEFAULT 0   COMMENT '��ǰ��'  
    ,  FUN_DESC  VARCHAR(120)    COMMENT '�����Դ���-PCOLID'  
    ,  FUN_PATH  VARCHAR(120)    COMMENT '��Ӧҳ��·��'  
    ,  PARENTID  DECIMAL(10) DEFAULT 0   COMMENT '�����ܴ���(���)'  
    ,  LEVEL_CODE  VARCHAR(100)    COMMENT '�㼶���ţ�����**Z**��'  
    ,  SCPID  VARCHAR(30)    COMMENT '���÷�Χ'  
    ,  FUN_TYPE  CHAR(1)    COMMENT '��Դ����[0=�˵�/1=��ť]'  
    ,  BOT_FLAG  CHAR(1) DEFAULT '1'   COMMENT '�Ƿ��ǵײ�Ȩ��[0=��/1=��(default)]'  
    ,  USE_FLAG  CHAR(1) DEFAULT '1'   COMMENT '�Ƿ���ʹ��[0=��/1=��(default)]'  
    ,  ICON_TYPE  CHAR(1)    COMMENT 'ͼ������[1=font-awesome/2=iconfont/3=icon-svg]'  
    ,  ICON  VARCHAR(20)    COMMENT 'ͼ��'  
    ,  POSITION  VARCHAR(120)    COMMENT '��Դ����λ��'  
    , PRIMARY KEY ( REFCODE ) 
) COMMENT='ϵͳ��Դ��';


CREATE TABLE CSPA_EXC_M  ( 
      REFCODE  DECIMAL(10) DEFAULT 0 NOT NULL  COMMENT '��ˮ��'  
    ,  EXID  CHAR(3)    COMMENT 'Excel�ĵ���'  
    ,  SHEET_ID  CHAR(3)    COMMENT 'Sheet��'  
    ,  EXNAME  VARCHAR(50)    COMMENT '�ֶ�����'  
    ,  EXDESC  VARCHAR(200)    COMMENT '�ֶ�����'  
    ,  MATCH_NAME  VARCHAR(200)    COMMENT 'ƥ��Excel����'  
    ,  EXTABLE  VARCHAR(30)    COMMENT '����'  
    ,  DATA_TYPE  VARCHAR(20)    COMMENT '�ֶ�����'  
    ,  DATA_LEN  DECIMAL(10) DEFAULT 0   COMMENT '�ֶγ���'  
    ,  EXROW_ID  DECIMAL(10) DEFAULT 0   COMMENT '�к�'  
    ,  EXCOL_ID  DECIMAL(10) DEFAULT 0   COMMENT '�к�'  
    ,  IS_INPUT  CHAR(1) DEFAULT '0'   COMMENT '�Ƿ����[0=��/1=��]'  
    ,  IS_CYCLE  CHAR(1) DEFAULT '0'   COMMENT '�Ƿ�ѭ��[0=��/1=��]'  
    ,  IS_VALID  CHAR(1) DEFAULT '1'   COMMENT '�Ƿ���Ч[0=��/1=��]'  
    ,  IS_PK  CHAR(1) DEFAULT '0'   COMMENT '�Ƿ�����[0=��/1=��]'  
    ,  IS_SHOW  CHAR(1) DEFAULT '1'   COMMENT '�Ƿ���ʾ[0=��/1=��]'  
    ,  IS_MODIFY  CHAR(1) DEFAULT '1'   COMMENT '�Ƿ��޸�[0=��/1=��]'  
    ,  SHOW_STYLE  CHAR(1) DEFAULT '0'   COMMENT 'ҳ��չʾ��ʽ[0=�ı���ǩ/1=�ı���/2=���ı���/3=������]'  
    ,  EXDIRECT  CHAR(1)    COMMENT 'ѭ����ʽ[0=����/1=����]'  
    ,  GET_VALUE_STYLE  CHAR(1) DEFAULT '0'   COMMENT 'ȡֵ��ʽ[0=�м�һ/1=�м�һ]'  
    , PRIMARY KEY ( REFCODE ) 
) COMMENT='Excel���ݵ������ñ�';


CREATE TABLE FSPA_EXG_M  ( 
      REFCODE  DECIMAL(10) DEFAULT 0 NOT NULL  COMMENT '��ˮ��'  
    ,  PARM_TYPE  VARCHAR(20)    COMMENT '�������[�ο�SMME_WEB_INITIALIZE.xls˵���ļ�]'  
    ,  PARM_NAME  VARCHAR(20)    COMMENT '��������'  
    ,  PARM_VALUE  VARCHAR(120)    COMMENT '����ֵ'  
    ,  PARM_DESC  VARCHAR(120)    COMMENT '����˵��'  
    ,  PARENT_ID  VARCHAR(20)    COMMENT '��������'  
    ,  PARENT_TYPE  VARCHAR(10)    COMMENT '�����Ĳ������'  
    ,  PARM_FLAG  CHAR(1) DEFAULT '2'   COMMENT '����ֵ���[��ʵֵ=1/�����Դ���=2]'  
    , PRIMARY KEY ( REFCODE ) 
) COMMENT='�������ñ�';


CREATE TABLE FSPA_COL_M  ( 
      REFCODE  DECIMAL(10) DEFAULT 0 NOT NULL  COMMENT '��ˮ��'  
    ,  COL_ID  VARCHAR(50)    COMMENT '������ID'  
    ,  LANGUAGE_ID  VARCHAR(10)    COMMENT '��������'  
    ,  COL_DESC  VARCHAR(120)    COMMENT '����'  
    , PRIMARY KEY ( REFCODE ) 
) COMMENT='������������';


CREATE TABLE FSPA_NTB_M  ( 
      REFCODE  DECIMAL(10) DEFAULT 0 NOT NULL  COMMENT '��ˮ��'  
    ,  FILE_NAME  VARCHAR(150)    COMMENT '�ļ�����(�����ļ�����)'  
    ,  FILE_TYPE  VARCHAR(10)    COMMENT '�ļ�����/��׺��'  
    ,  FILE_SIM_NAME  VARCHAR(100)    COMMENT '�ļ����(ʵ��ģ������)'  
    ,  SUIT_ORG_TYPE  VARCHAR(50)    COMMENT '������ҵ����(������ҵ������Ӣ�ķ��š�,��������)'  
    ,  FILE_PURPOSE  CHAR(1)    COMMENT '�ļ���;[1-ģ���ļ�]'  
    ,  DEL_FLAG  CHAR(1) DEFAULT '0'   COMMENT 'ɾ�����[��=1/��=0(Default)]'  
    , PRIMARY KEY ( REFCODE ) 
) COMMENT='ģ����Ϣ��';


CREATE TABLE FSPA_SEQ_M  ( 
      NAME  VARCHAR(50)  NOT NULL  COMMENT '������'  
    ,  CURRENT_VALUE  DECIMAL(10) DEFAULT 0 NOT NULL  COMMENT '��ǰֵ'  
    , PRIMARY KEY ( NAME ) 
) ENGINE=MyISAM COMMENT='���ݿ����б�';


CREATE TABLE FIPA_SYS_M  ( 
      REFCODE  DECIMAL(10) DEFAULT 0 NOT NULL  COMMENT '��ˮ��'  
    ,  PARAM_NAME  VARCHAR(180)    COMMENT '��������'  
    ,  PARAM_VALUE  VARCHAR(180)    COMMENT '����ֵ'  
    ,  PARAM_TYPE  DECIMAL(10)    COMMENT '��������'  
    ,  PARAM_DESC  VARCHAR(180)    COMMENT '��������'  
    ,  PARAM_STATUS  CHAR(1) DEFAULT '1'   COMMENT '����״̬[1=ҳ����ʾ�ҿ��޸�(default)/2=ҳ����ʾ�Ҳ����޸�/3=ҳ�治��ʾ���������ݿ��޸�]'  
    ,  DATA_STATUS  VARCHAR(10)    COMMENT '����״̬[01=����(�����ڱ��ر��棬��δ�ύ����������ȥ��/11=������/99=��Ч]'  
    ,  ENTITY_ID  VARCHAR(50)    COMMENT '������PK'  
    ,  DEL_FLAG  CHAR(1) DEFAULT '0'   COMMENT 'ɾ�����[��=1/��=0(Default)]'  
    ,  CREATE_USER  VARCHAR(20)    COMMENT '������'  
    ,  CREATE_AGENT_USER  VARCHAR(20)    COMMENT '�����ߴ�����'  
    ,  CREATE_DATE  DATETIME    COMMENT '����ʱ��'  
    ,  EDTID  VARCHAR(3)    COMMENT '��������'  
    ,  LAST_MOD_USER  VARCHAR(20)    COMMENT '������'  
    ,  AGENT_USER  VARCHAR(20)    COMMENT '����������'  
    ,  LAST_MOD_DATE  DATETIME    COMMENT '����ʱ��'  
    , PRIMARY KEY ( REFCODE ) 
) COMMENT='ϵͳ�����趨��';


CREATE TABLE FIPA_CCY_M  ( 
      REFCODE  DECIMAL(10) DEFAULT 0 NOT NULL  COMMENT '��ˮ��'  
    ,  CCYID  VARCHAR(3)    COMMENT '�ұ����'  
    ,  CCYDESC  VARCHAR(120)    COMMENT '�ұ�����'  
    ,  DECIMAL_POSI  DECIMAL(10) DEFAULT 0   COMMENT '��ȷ��С��λ��'  
    ,  CCY_EDIT_FMT  VARCHAR(25)    COMMENT '�༭��ʽ'  
    ,  CCY_DISP_FMT  VARCHAR(25)    COMMENT '��ʾ��ʽ'  
    ,  BASE_DAY  DECIMAL(10) DEFAULT 0   COMMENT '��Ϣ������'  
    ,  EXGRATE_01  DECIMAL(16,8) DEFAULT 0   COMMENT '�ұ����ʻ����趨1'  
    ,  EXGRATE_02  DECIMAL(16,8) DEFAULT 0   COMMENT '�ұ����ʻ����趨2'  
    ,  EXGRATE_03  DECIMAL(16,8) DEFAULT 0   COMMENT '�ұ����ʻ����趨3'  
    ,  EXGRATE_04  DECIMAL(16,8) DEFAULT 0   COMMENT '�ұ����ʻ����趨4'  
    ,  EXGRATE_05  DECIMAL(16,8) DEFAULT 0   COMMENT '�ұ����ʻ����趨5'  
    ,  EXGRATE_06  DECIMAL(16,8) DEFAULT 0   COMMENT '�ұ����ʻ����趨6'  
    ,  EXGRATE_07  DECIMAL(16,8) DEFAULT 0   COMMENT '�ұ����ʻ����趨7'  
    ,  EXGRATE_08  DECIMAL(16,8) DEFAULT 0   COMMENT '�ұ����ʻ����趨8'  
    ,  EXGRATE_09  DECIMAL(16,8) DEFAULT 0   COMMENT '�ұ����ʻ����趨9'  
    ,  EXGRATE_10  DECIMAL(16,8) DEFAULT 0   COMMENT '�ұ����ʻ����趨10'  
    ,  EXGRATE_11  DECIMAL(16,8) DEFAULT 0   COMMENT '�ұ����ʻ����趨11'  
    ,  EXGRATE_12  DECIMAL(16,8) DEFAULT 0   COMMENT '�ұ����ʻ����趨12'  
    ,  HOST_CCYID  VARCHAR(4)    COMMENT '��ǰ�����ұ�'  
    ,  BUSSDATE  DATETIME    COMMENT '��ǰӪҵ��'  
    ,  BUP_PCNT  DECIMAL(16,8) DEFAULT 0   COMMENT '�����ϸ��ٷֱ�(0��1֮��)'  
    ,  SDW_PCNT  DECIMAL(16,8) DEFAULT 0   COMMENT '�����¸��ٷֱ�(0��1֮��)'  
    ,  UNIT_PRICE  DECIMAL(10) DEFAULT 0   COMMENT '���ҵ���'  
    ,  EDI_CCYID  VARCHAR(3)    COMMENT 'EDI�ұ����'  
    ,  DATA_STATUS  VARCHAR(10)    COMMENT '����״̬[01=����(�����ڱ��ر��棬��δ�ύ����������ȥ��/11=������/99=��Ч]'  
    ,  ENTITY_ID  VARCHAR(50)    COMMENT '������PK'  
    ,  DEL_FLAG  CHAR(1) DEFAULT '0'   COMMENT 'ɾ�����[��=1/��=0(Default)]'  
    ,  CREATE_USER  VARCHAR(20)    COMMENT '������'  
    ,  CREATE_AGENT_USER  VARCHAR(20)    COMMENT '�����ߴ�����'  
    ,  CREATE_DATE  DATETIME    COMMENT '����ʱ��'  
    ,  EDTID  VARCHAR(3)    COMMENT '��������'  
    ,  LAST_MOD_USER  VARCHAR(20)    COMMENT '������'  
    ,  AGENT_USER  VARCHAR(20)    COMMENT '����������'  
    ,  LAST_MOD_DATE  DATETIME    COMMENT '����ʱ��'  
    , PRIMARY KEY ( REFCODE ) 
) COMMENT='���ұ���Ϣ��';


CREATE TABLE FIPA_CTY_M  ( 
      REFCODE  DECIMAL(10) DEFAULT 0 NOT NULL  COMMENT '��ˮ��'  
    ,  CTYID  VARCHAR(10)    COMMENT '���ұ����'  
    ,  CTY_DESC  VARCHAR(120)    COMMENT '��������'  
    ,  EDI_CTYID  VARCHAR(10)    COMMENT 'EDI���ұ����'  
    ,  DATA_STATUS  VARCHAR(10)    COMMENT '����״̬[01=����(�����ڱ��ر��棬��δ�ύ����������ȥ��/11=������/99=��Ч]'  
    ,  ENTITY_ID  VARCHAR(50)    COMMENT '������PK'  
    ,  DEL_FLAG  CHAR(1) DEFAULT '0'   COMMENT 'ɾ�����[��=1/��=0(Default)]'  
    ,  CREATE_USER  VARCHAR(20)    COMMENT '������'  
    ,  CREATE_AGENT_USER  VARCHAR(20)    COMMENT '�����ߴ�����'  
    ,  CREATE_DATE  DATETIME    COMMENT '����ʱ��'  
    ,  EDTID  VARCHAR(3)    COMMENT '��������'  
    ,  LAST_MOD_USER  VARCHAR(20)    COMMENT '������'  
    ,  AGENT_USER  VARCHAR(20)    COMMENT '����������'  
    ,  LAST_MOD_DATE  DATETIME    COMMENT '����ʱ��'  
    , PRIMARY KEY ( REFCODE ) 
) COMMENT='���ұ���Ϣ��';


CREATE TABLE FIPA_ARE_M  ( 
      REFCODE  DECIMAL(10) DEFAULT 0 NOT NULL  COMMENT '��ˮ��'  
    ,  AREA_LEVEL  CHAR(1)  NOT NULL  COMMENT '��������[1=ʡ/2=��/3=��]'  
    ,  AREA_TYPE_CODE  VARCHAR(2)  NOT NULL  COMMENT '�������ʹ���[1=����/2=����/3=����/4=����/5=����/6=����/7=����/8=̨�۰�]'  
    ,  AREA_CODE  VARCHAR(10)  NOT NULL  COMMENT '������������'  
    ,  PROVINCE_CODE  VARCHAR(2)  NOT NULL  COMMENT 'ʡ����'  
    ,  AREA_DESC  VARCHAR(255)  NOT NULL  COMMENT '��������'  
    ,  PROVINCE_NAME  VARCHAR(64)  NOT NULL  COMMENT 'ʡ����'  
    ,  CITY_NAME  VARCHAR(64)    COMMENT '������'  
    ,  COUNTY_NAME  VARCHAR(64)    COMMENT '������'  
    ,  TOWN_NAME  VARCHAR(64)    COMMENT '��������'  
    ,  POST_CODE  VARCHAR(10)    COMMENT '�ʱ�'  
    ,  DATA_STATUS  VARCHAR(10)    COMMENT '����״̬[01=����(�����ڱ��ر��棬��δ�ύ����������ȥ��/11=������/99=��Ч]'  
    ,  ENTITY_ID  VARCHAR(50)    COMMENT '������PK'  
    ,  DEL_FLAG  CHAR(1) DEFAULT '0'   COMMENT 'ɾ�����[��=1/��=0(Default)]'  
    ,  CREATE_USER  VARCHAR(20)    COMMENT '������'  
    ,  CREATE_AGENT_USER  VARCHAR(20)    COMMENT '�����ߴ�����'  
    ,  CREATE_DATE  DATETIME    COMMENT '����ʱ��'  
    ,  EDTID  VARCHAR(3)    COMMENT '��������'  
    ,  LAST_MOD_USER  VARCHAR(20)    COMMENT '������'  
    ,  AGENT_USER  VARCHAR(20)    COMMENT '����������'  
    ,  LAST_MOD_DATE  DATETIME    COMMENT '����ʱ��'  
    , PRIMARY KEY ( REFCODE ) 
) COMMENT='������Ϣ��';


CREATE TABLE FIPA_OTP_M  ( 
      REFCODE  DECIMAL(10) DEFAULT 0 NOT NULL  COMMENT '��ˮ��'  
    ,  OTPCODE  VARCHAR(40)  NOT NULL  COMMENT 'Ͷ����ҵ����(ϵͳ���ɣ������νṹ���б��룬��������ڼ����˸���������Ϣ)'  
    ,  OTPID  VARCHAR(20)    COMMENT '��ҵ������(�ͻ��趨)'  
    ,  OTPNAME  VARCHAR(50)    COMMENT '��ҵ�������'  
    ,  OTPLVL  DECIMAL(10) DEFAULT 1 NOT NULL  COMMENT '��ҵ��𼶱�(�㼶��ţ�1=��һ�㣬�Դ�����)'  
    ,  LOAN_EXT01  VARCHAR(20)    COMMENT '��չ�ֶ�'  
    ,  DATA_STATUS  VARCHAR(10)    COMMENT '����״̬[01=����(�����ڱ��ر��棬��δ�ύ����������ȥ��/11=������/99=��Ч]'  
    ,  ENTITY_ID  VARCHAR(50)    COMMENT '������PK'  
    ,  DEL_FLAG  CHAR(1) DEFAULT '0'   COMMENT 'ɾ�����[��=1/��=0(Default)]'  
    ,  CREATE_USER  VARCHAR(20)    COMMENT '������'  
    ,  CREATE_AGENT_USER  VARCHAR(20)    COMMENT '�����ߴ�����'  
    ,  CREATE_DATE  DATETIME    COMMENT '����ʱ��'  
    ,  EDTID  VARCHAR(3)    COMMENT '��������'  
    ,  LAST_MOD_USER  VARCHAR(20)    COMMENT '������'  
    ,  AGENT_USER  VARCHAR(20)    COMMENT '����������'  
    ,  LAST_MOD_DATE  DATETIME    COMMENT '����ʱ��'  
    , PRIMARY KEY ( REFCODE ) 
) COMMENT='��ҵ����';


CREATE TABLE FIPA_BCH_M  ( 
      REFCODE  DECIMAL(10) DEFAULT 0 NOT NULL  COMMENT '��ˮ��'  
    ,  BANK_ID  VARCHAR(20)  NOT NULL  COMMENT '�����������'  
    ,  BANK_NAME  VARCHAR(120)    COMMENT '������������'  
    ,  BANK_LEVEL  CHAR(1)    COMMENT '���㼶��[1=����(����)/2=����(Ӫҵ)/3=��(֧)��]'  
    ,  PARENT_BANK_ID  VARCHAR(20)    COMMENT '�ϼ��д���'  
    ,  BELONG_BANK_ID  VARCHAR(20)    COMMENT '��������'  
    ,  CNAPS_CODE  VARCHAR(20)    COMMENT '���д���к�'  
    ,  BANK_ADDR  VARCHAR(180)    COMMENT '�����ַ'  
    ,  BANK_AREA_CODE  VARCHAR(10)    COMMENT '�������ڵ���'  
    ,  BANK_ICON  VARCHAR(10)    COMMENT 'ͼ������'  
    ,  DATA_STATUS  VARCHAR(10)    COMMENT '����״̬[01=����(�����ڱ��ر��棬��δ�ύ����������ȥ��/11=������/99=��Ч]'  
    ,  ENTITY_ID  VARCHAR(50)    COMMENT '������PK'  
    ,  DEL_FLAG  CHAR(1) DEFAULT '0'   COMMENT 'ɾ�����[��=1/��=0(Default)]'  
    ,  CREATE_USER  VARCHAR(20)    COMMENT '������'  
    ,  CREATE_AGENT_USER  VARCHAR(20)    COMMENT '�����ߴ�����'  
    ,  CREATE_DATE  DATETIME    COMMENT '����ʱ��'  
    ,  EDTID  VARCHAR(3)    COMMENT '��������'  
    ,  LAST_MOD_USER  VARCHAR(20)    COMMENT '������'  
    ,  AGENT_USER  VARCHAR(20)    COMMENT '����������'  
    ,  LAST_MOD_DATE  DATETIME    COMMENT '����ʱ��'  
    , PRIMARY KEY ( REFCODE ) 
) COMMENT='������Ϣ��';


CREATE TABLE FIPA_NUM_M  ( 
      REFCODE  DECIMAL(10) DEFAULT 0 NOT NULL  COMMENT '��ˮ��'  
    ,  NUM_TYPE  DECIMAL(10) DEFAULT 0   COMMENT '�������[����������]'  
    ,  NUM_VALUE  VARCHAR(50)    COMMENT '��Ŷ�Ӧֵ'  
    ,  NUM_DATE  VARCHAR(8)    COMMENT 'ͳ������'  
    ,  CURR_SEQNUM  DECIMAL(10) DEFAULT 0   COMMENT 'Ŀǰ���'  
    ,  LAST_MOD_USER  VARCHAR(20)    COMMENT '������'  
    ,  LAST_MOD_DATE  DATETIME    COMMENT '����ʱ��'  
    , PRIMARY KEY ( REFCODE ) 
) COMMENT='ϵͳ������ɱ�';


CREATE TABLE FCMS_IMG_M  ( 
      REFCODE  DECIMAL(10) DEFAULT 0 NOT NULL  COMMENT '��ˮ��'  
    ,  CATEGORY_CODE  VARCHAR(30)  NOT NULL  COMMENT '��Ŀ����'  
    ,  IMAGE_NAME  VARCHAR(30)    COMMENT 'ͼƬ����'  
    ,  START_DATE  DATETIME    COMMENT '��ʼ��Ч����'  
    ,  END_DATE  DATETIME    COMMENT '��ֹ��Ч����'  
    ,  IMAGE_RANK  DECIMAL(10)  NOT NULL  COMMENT 'ͼƬ����'  
    ,  IMAGE_URL  VARCHAR(100)    COMMENT 'ͼƬ���ӵ�ַ'  
    ,  IMAGE_URL_OPEN_TYPE  CHAR(1) DEFAULT '2'   COMMENT 'ͼƬ���Ӵ򿪷�ʽ[1=_blank/2=_self]'  
    ,  IMAGE_UUID  VARCHAR(50)  NOT NULL  COMMENT 'ͼƬUUID'  
    ,  USE_FLAG  CHAR(1) DEFAULT '1'   COMMENT '�Ƿ�����[0=����/1=����]'  
    ,  DATA_STATUS  VARCHAR(10)    COMMENT '����״̬[01=����(�����ڱ��ر��棬��δ�ύ����������ȥ��/11=������/99=��Ч]'  
    ,  ENTITY_ID  VARCHAR(50)    COMMENT '������PK'  
    ,  DEL_FLAG  CHAR(1) DEFAULT '0'   COMMENT 'ɾ�����[��=1/��=0(Default)]'  
    ,  CREATE_USER  VARCHAR(20)    COMMENT '������'  
    ,  CREATE_AGENT_USER  VARCHAR(20)    COMMENT '�����ߴ�����'  
    ,  CREATE_DATE  DATETIME    COMMENT '����ʱ��'  
    ,  EDTID  VARCHAR(3)    COMMENT '��������'  
    ,  LAST_MOD_USER  VARCHAR(20)    COMMENT '������'  
    ,  AGENT_USER  VARCHAR(20)    COMMENT '����������'  
    ,  LAST_MOD_DATE  DATETIME    COMMENT '����ʱ��'  
    , PRIMARY KEY ( REFCODE ) 
) COMMENT='ͼƬ��';


CREATE TABLE FCMS_BRO_CNT_M  ( 
      REFCODE  DECIMAL(10) DEFAULT 0 NOT NULL  COMMENT '��ˮ��'  
    ,  USER_AGENT  VARCHAR(500)    COMMENT '�������ʶ'  
    ,  REFERER  VARCHAR(500)    COMMENT '�������Դ��Ϣ'  
    ,  URL  VARCHAR(500)    COMMENT '�����URL��Ϣ'  
    ,  OS  VARCHAR(64)    COMMENT '����ϵͳ'  
    ,  HREF  VARCHAR(500)    COMMENT '�����HREF��Ϣ'  
    ,  BROWSER  VARCHAR(64)    COMMENT '���������'  
    ,  BROWSER_LANGUAGE  VARCHAR(64)    COMMENT '���������'  
    ,  FUNC_MODEL  VARCHAR(16)    COMMENT '����ģ��'  
    ,  IP  VARCHAR(16)    COMMENT 'IP��ַ'  
    ,  COUNT  DECIMAL(10)    COMMENT '����ʵ��ֵ'  
    ,  COUNT_VIRTUAL  DECIMAL(10)    COMMENT '����ģ��ֵ'  
    ,  REFERER_PLATFORM  NVARCHAR(50)    COMMENT '������Դƽ̨'  
    ,  CREATE_TIME  DATETIME DEFAULT '1901-01-01 00:00:00' NOT NULL  COMMENT ''  
    , PRIMARY KEY ( REFCODE ) 
) COMMENT='ҳ��ͳ�Ʊ�';


CREATE TABLE FBTX_APX_M  ( 
      REFCODE  DECIMAL(10) DEFAULT 0 NOT NULL  COMMENT '��ˮ��'  
    ,  FILE_UUID  VARCHAR(40)    COMMENT '�ļ��ϴ�����Ωһ���'  
    ,  FILE_SOURCE  CHAR(1)    COMMENT '�ļ���Դ[1-��ϵͳ/2-�Ŵ�ϵͳ]'  
    ,  FILE_NAME  VARCHAR(50)    COMMENT '�ļ���'  
    ,  FILE_TYPE  VARCHAR(10)    COMMENT '�ļ�����/��׺��'  
    ,  FILE_PATH  VARCHAR(200)    COMMENT '�ļ�·��'  
    ,  STORE_NAME  VARCHAR(100)    COMMENT '�ļ��洢��'  
    ,  MEMO  VARCHAR(100)    COMMENT '˵��'  
    ,  DATA_STATUS  VARCHAR(10)    COMMENT '����״̬[01=����(�����ڱ��ر��棬��δ�ύ����������ȥ��/11=������/99=��Ч]'  
    ,  ENTITY_ID  VARCHAR(50)    COMMENT '������PK'  
    ,  DEL_FLAG  CHAR(1) DEFAULT '0'   COMMENT 'ɾ�����[��=1/��=0(Default)]'  
    ,  CREATE_USER  VARCHAR(20)    COMMENT '������'  
    ,  CREATE_AGENT_USER  VARCHAR(20)    COMMENT '�����ߴ�����'  
    ,  CREATE_DATE  DATETIME    COMMENT '����ʱ��'  
    ,  EDTID  VARCHAR(3)    COMMENT '��������'  
    ,  LAST_MOD_USER  VARCHAR(20)    COMMENT '������'  
    ,  AGENT_USER  VARCHAR(20)    COMMENT '����������'  
    ,  LAST_MOD_DATE  DATETIME    COMMENT '����ʱ��'  
    , PRIMARY KEY ( REFCODE ) 
) COMMENT='�����洢��';


CREATE TABLE FBTX_APP_M  ( 
      REFCODE  DECIMAL(10) DEFAULT 0 NOT NULL  COMMENT '��ˮ��'  
    ,  INIT_ORG_REFCODE  DECIMAL(10) DEFAULT 0   COMMENT '������ҵ(����)��ˮ��'  
    ,  RATE_ORG_REFCODE  DECIMAL(10) DEFAULT 0   COMMENT '��������ҵ(����)��ˮ��'  
    ,  APP_TYPE  CHAR(1)  NOT NULL  COMMENT '��������[1=����/2=������ҵ����/3=��������]'  
    ,  TRADE_REFCODE  DECIMAL(10)    COMMENT '���ʽ���(����)��ˮ��'  
    ,  APP_LEVEL  VARCHAR(2)    COMMENT '���۵ȼ�(�Ǽ�)'  
    ,  APP_CONTENT  VARCHAR(200)    COMMENT '��������'  
    ,  DATA_STATUS  VARCHAR(10)    COMMENT '����״̬[01=����(�����ڱ��ر��棬��δ�ύ����������ȥ��/11=������/99=��Ч]'  
    ,  ENTITY_ID  VARCHAR(50)    COMMENT '������PK'  
    ,  DEL_FLAG  CHAR(1) DEFAULT '0'   COMMENT 'ɾ�����[��=1/��=0(Default)]'  
    ,  CREATE_USER  VARCHAR(20)    COMMENT '������'  
    ,  CREATE_AGENT_USER  VARCHAR(20)    COMMENT '�����ߴ�����'  
    ,  CREATE_DATE  DATETIME    COMMENT '����ʱ��'  
    ,  EDTID  VARCHAR(3)    COMMENT '��������'  
    ,  LAST_MOD_USER  VARCHAR(20)    COMMENT '������'  
    ,  AGENT_USER  VARCHAR(20)    COMMENT '����������'  
    ,  LAST_MOD_DATE  DATETIME    COMMENT '����ʱ��'  
    , PRIMARY KEY ( REFCODE ) 
) COMMENT='ƽ̨������Ϣ��';


CREATE TABLE FBTX_NOT_M  ( 
      REFCODE  DECIMAL(10) DEFAULT 0 NOT NULL  COMMENT '��ˮ��'  
    ,  PUSH_TYPE  CHAR(1)  NOT NULL  COMMENT '��Ϣ�����û�����[1=ϵͳ/2=��ҵ/3=�û�]'  
    ,  PUSH_ORG_REFCODE  DECIMAL(10) DEFAULT 0   COMMENT '��Ϣ������ҵ(����)��ˮ��'  
    ,  RECEIVE_USERID  VARCHAR(50)    COMMENT '��Ϣ�����û�id'  
    ,  RECEIVE_ORG_REFCODE  DECIMAL(10) DEFAULT 0   COMMENT '��Ϣ������ҵ(����)��ˮ��'  
    ,  NOTICE_CODE  VARCHAR(20)    COMMENT '��Ϣ���'  
    ,  NOTICE_TITLE  VARCHAR(200)    COMMENT '��Ϣ����'  
    ,  NOTICE_CONTENT  VARCHAR(500)    COMMENT '��Ϣ����'  
    ,  NOTICE_CONTENT_HREF  VARCHAR(800)    COMMENT '��Ϣ����������'  
    ,  NOTICE_FLAG  CHAR(1) DEFAULT '0'   COMMENT '��Ϣ״̬(0=δ��/1=�Ѷ�)'  
    ,  READ_TIME  DATETIME    COMMENT '��ȡʱ��'  
    ,  SHOW_HOME  CHAR(1) DEFAULT '0'   COMMENT '�Ƿ�����ҳ��ʾ(0=��/1=��)'  
    ,  DATA_STATUS  VARCHAR(10)    COMMENT '����״̬[01=����(�����ڱ��ر��棬��δ�ύ����������ȥ��/11=������/99=��Ч]'  
    ,  ENTITY_ID  VARCHAR(50)    COMMENT '������PK'  
    ,  DEL_FLAG  CHAR(1) DEFAULT '0'   COMMENT 'ɾ�����[��=1/��=0(Default)]'  
    ,  CREATE_USER  VARCHAR(20)    COMMENT '������'  
    ,  CREATE_AGENT_USER  VARCHAR(20)    COMMENT '�����ߴ�����'  
    ,  CREATE_DATE  DATETIME    COMMENT '����ʱ��'  
    ,  EDTID  VARCHAR(3)    COMMENT '��������'  
    ,  LAST_MOD_USER  VARCHAR(20)    COMMENT '������'  
    ,  AGENT_USER  VARCHAR(20)    COMMENT '����������'  
    ,  LAST_MOD_DATE  DATETIME    COMMENT '����ʱ��'  
    , PRIMARY KEY ( REFCODE ) 
) COMMENT='ƽ̨��Ϣ���ѱ�';


CREATE TABLE SIPA_BUR_M  ( 
      REFCODE  DECIMAL(10) DEFAULT 0 NOT NULL  COMMENT '��ˮ��'  
    ,  SYSTEM_TYPE  CHAR(1)  NOT NULL  COMMENT '����ϵͳ����[1=��̨/2=ǰ̨]'  
    ,  USERID  VARCHAR(20)  NOT NULL  COMMENT '�û�����(ǰ̨�Զ����ɡ���̨��¼�˺�)'  
    ,  USER_NAME  VARCHAR(50)    COMMENT '�û���'  
    ,  PASSWORD  VARCHAR(50)    COMMENT '����'  
    ,  CHGPWD_FLAG  CHAR(1) DEFAULT '1'   COMMENT '�û���½ʱ�Ƿ�Ҫ���޸�����[0=��/1=��(default)]'  
    ,  VALID_DAY  DECIMAL(10)    COMMENT '������Ч����'  
    ,  WARNING_DAY  DECIMAL(10)    COMMENT '���뵽��ǰ��������'  
    ,  PWD_EXPIRYDATE  DATETIME    COMMENT '���뵽����(��ValidDay���)'  
    ,  CHGPWD_DATE  DATETIME    COMMENT '�ϴθ�������ʱ��'  
    ,  MOBILEPHONE  VARCHAR(30)    COMMENT '�ֻ�����'  
    ,  EMAIL  VARCHAR(120)    COMMENT '��������'  
    ,  TEL_AREA  VARCHAR(30)    COMMENT '�������루���ţ�'  
    ,  TEL  VARCHAR(30)    COMMENT '�������루�绰��'  
    ,  EXTNO  VARCHAR(5)    COMMENT '�������루�ֻ��ţ�'  
    ,  WEIXIN  VARCHAR(30)    COMMENT '΢�ź���'  
    ,  AREA_COUNTY  VARCHAR(60)    COMMENT '���ڵ���'  
    ,  PROVINCE_CODE  VARCHAR(2)    COMMENT 'ʡ�ݴ���'  
    ,  ADDRESS  VARCHAR(180)    COMMENT '��ϸ��ַ'  
    ,  POSTCODE  VARCHAR(20)    COMMENT '��������'  
    ,  ID_NO  VARCHAR(20)    COMMENT '���֤����'  
    ,  LAST_LOGIN_ADDRESS  VARCHAR(100)    COMMENT '�ϴε�¼��ַ'  
    ,  LAST_LOGIN_DATE  DATETIME    COMMENT '�ϴε�¼ʱ��'  
    ,  MOBILE_VAILD_STATUS  CHAR(1) DEFAULT '0'   COMMENT '�ֻ���֤״̬[0=δ��֤/1=����֤]'  
    ,  EMAIL_VAILD_STATUS  CHAR(1) DEFAULT '0'   COMMENT '������֤״̬[0=δ��֤/1=����֤]'  
    ,  SOURCE  CHAR(1) DEFAULT '0'   COMMENT '������Դ[0=����/1=΢��]'  
    ,  ADMIN_FLAG  CHAR(1)    COMMENT '�Ƿ񳬼�����Ա[1=��/0=��]'  
    ,  USE_FLAG  CHAR(1) DEFAULT '1'   COMMENT '�Ƿ�����[0=����/1=����]'  
    ,  DATA_STATUS  VARCHAR(10)    COMMENT '����״̬[01=����(�����ڱ��ر��棬��δ�ύ����������ȥ��/11=������/99=��Ч]'  
    ,  ENTITY_ID  VARCHAR(50)    COMMENT '������PK'  
    ,  DEL_FLAG  CHAR(1) DEFAULT '0'   COMMENT 'ɾ�����[��=1/��=0(Default)]'  
    ,  CREATE_USER  VARCHAR(20)    COMMENT '������'  
    ,  CREATE_AGENT_USER  VARCHAR(20)    COMMENT '�����ߴ�����'  
    ,  CREATE_DATE  DATETIME DEFAULT '1901-01-01 00:00:00'   COMMENT '����ʱ��'  
    ,  EDTID  VARCHAR(3)    COMMENT '��������'  
    ,  LAST_MOD_USER  VARCHAR(20)    COMMENT '������'  
    ,  AGENT_USER  VARCHAR(20)    COMMENT '����������'  
    ,  LAST_MOD_DATE  DATETIME DEFAULT '1901-01-01 00:00:00'   COMMENT '����ʱ��'  
    , PRIMARY KEY ( REFCODE ) 
) COMMENT='�û���Ϣ��';


CREATE TABLE SIPA_BTO_M  ( 
      REFCODE  DECIMAL(10) DEFAULT 0 NOT NULL  COMMENT '��ˮ��'  
    ,  USERID  VARCHAR(20)    COMMENT '�û�����'  
    ,  ORG_REFCODE  DECIMAL(10) DEFAULT 0   COMMENT '��ҵ��ˮ��'  
    ,  ADMIN_FLAG  CHAR(1)    COMMENT '�Ƿ����Ա[1=��/0=��]'  
    ,  EDTID  VARCHAR(3)    COMMENT '��������'  
    ,  LAST_MOD_USER  VARCHAR(20)    COMMENT '������'  
    ,  LAST_MOD_DATE  DATETIME    COMMENT '����ʱ��'  
    , PRIMARY KEY ( REFCODE ) 
) COMMENT='�û�����ҵ������';


CREATE TABLE SIPA_ROL_M  ( 
      REFCODE  DECIMAL(10) DEFAULT 0 NOT NULL  COMMENT '��ˮ��'  
    ,  SYSTEM_TYPE  CHAR(1)  NOT NULL  COMMENT '����ϵͳ����[1=��̨/2=ǰ̨]'  
    ,  ROLEID  VARCHAR(50)  NOT NULL  COMMENT '��ɫ����'  
    ,  ROLE_NAME  VARCHAR(120)    COMMENT '��ɫ����'  
    ,  ROLEDESC  VARCHAR(200)    COMMENT '��ɫ����'  
    ,  SCPID  VARCHAR(3)    COMMENT '���÷�Χ'  
    ,  PARENT_ROLEID  VARCHAR(40)    COMMENT '����ɫ����'  
    ,  ORG_REFCODE  DECIMAL(10) DEFAULT 0   COMMENT '������ҵ��ˮ��'  
    ,  USE_FLAG  CHAR(1) DEFAULT '1'   COMMENT '�Ƿ�����[0=����/1=����]'  
    ,  DATA_STATUS  VARCHAR(10)    COMMENT '����״̬[01=����(�����ڱ��ر��棬��δ�ύ����������ȥ��/11=������/99=��Ч]'  
    ,  ENTITY_ID  VARCHAR(50)    COMMENT '������PK'  
    ,  DEL_FLAG  CHAR(1) DEFAULT '0'   COMMENT 'ɾ�����[��=1/��=0(Default)]'  
    ,  CREATE_USER  VARCHAR(20)    COMMENT '������'  
    ,  CREATE_AGENT_USER  VARCHAR(20)    COMMENT '�����ߴ�����'  
    ,  CREATE_DATE  DATETIME    COMMENT '����ʱ��'  
    ,  EDTID  VARCHAR(3)    COMMENT '��������'  
    ,  LAST_MOD_USER  VARCHAR(20)    COMMENT '������'  
    ,  AGENT_USER  VARCHAR(20)    COMMENT '����������'  
    ,  LAST_MOD_DATE  DATETIME    COMMENT '����ʱ��'  
    , PRIMARY KEY ( REFCODE ) 
) COMMENT='��ɫ������Ϣ��';


CREATE TABLE SIPA_RTF_M  ( 
      REFCODE  DECIMAL(10) DEFAULT 0 NOT NULL  COMMENT '��ˮ��'  
    ,  ROLEID  VARCHAR(40)    COMMENT '��ɫ����'  
    ,  FUNID  VARCHAR(50)    COMMENT '���ܴ���'  
    ,  EDTID  VARCHAR(3)    COMMENT '��������'  
    ,  LAST_MOD_USER  VARCHAR(20)    COMMENT '������'  
    ,  LAST_MOD_DATE  DATETIME    COMMENT '����ʱ��'  
    , PRIMARY KEY ( REFCODE ) 
) COMMENT='��ɫ��Ȩ�޹�����';


CREATE TABLE SIPA_BTR_M  ( 
      REFCODE  DECIMAL(10) DEFAULT 0 NOT NULL  COMMENT '��ˮ��'  
    ,  USERID  VARCHAR(20)    COMMENT '�û�����'  
    ,  ROLEID  VARCHAR(40)    COMMENT '��ɫ����'  
    ,  ORG_REFCODE  DECIMAL(10) DEFAULT 0   COMMENT '������ҵ��ˮ��'  
    ,  EDTID  VARCHAR(3)    COMMENT '��������'  
    ,  LAST_MOD_USER  VARCHAR(20)    COMMENT '������'  
    ,  LAST_MOD_DATE  DATETIME    COMMENT '����ʱ��'  
    , PRIMARY KEY ( REFCODE ) 
) COMMENT='�û����ɫ������';


CREATE TABLE SIPA_BTP_M  ( 
      REFCODE  DECIMAL(10) DEFAULT 0 NOT NULL  COMMENT '��ˮ��'  
    ,  USERID  VARCHAR(20)    COMMENT '�û�����'  
    ,  PROVINCE_CODE  VARCHAR(2)    COMMENT 'ʡ�ݴ���'  
    ,  EDTID  VARCHAR(3)    COMMENT '��������'  
    ,  LAST_MOD_USER  VARCHAR(20)    COMMENT '������'  
    ,  LAST_MOD_DATE  DATETIME    COMMENT '����ʱ��'  
    , PRIMARY KEY ( REFCODE ) 
) COMMENT='��̨�û���ʡ�ݹ�����';


CREATE TABLE SIPA_BTB_M  ( 
      REFCODE  DECIMAL(10) DEFAULT 0 NOT NULL  COMMENT '��ˮ��'  
    ,  USERID  VARCHAR(20)    COMMENT '�û�����'  
    ,  BRAND_REFCODE  DECIMAL(10)    COMMENT 'Ʒ����ˮ��'  
    ,  EDTID  VARCHAR(3)    COMMENT '��������'  
    ,  LAST_MOD_USER  VARCHAR(20)    COMMENT '������'  
    ,  LAST_MOD_DATE  DATETIME    COMMENT '����ʱ��'  
    , PRIMARY KEY ( REFCODE ) 
) COMMENT='��̨�û���Ʒ�ƹ�����';


CREATE TABLE FLOG_OPT_M  ( 
      REFCODE  DECIMAL(10) DEFAULT 0 NOT NULL  COMMENT '��ˮ��'  
    ,  FUN_ID  VARCHAR(30)    COMMENT '���ܴ���(��Ӧ�˵����Ĵ���) (��½Ϊ:login,�ǳ�Ϊ:logout)'  
    ,  FUN_DESC  VARCHAR(30)    COMMENT '��������(��Ӧ�˵���������)'  
    ,  EDTID  VARCHAR(10)    COMMENT '��������[login(��¼)��logout(�ǳ�)��ENT(���빦��)��SMT(�ύ)��NEW��MOD��DEL/����]'  
    ,  XML_PATH  VARCHAR(100)    COMMENT '����XML��ַ'  
    ,  SERVICE_NAME  VARCHAR(50)    COMMENT '���ú�̨SERVICE��'  
    ,  FUNCTION_NAME  VARCHAR(50)    COMMENT '���ú�̨FUNCTION��'  
    ,  PARAMETERS  VARCHAR(1000)    COMMENT '�ύ��̨������(��ȡǰ1000���ַ�)'  
    ,  OPERATOR_IP  VARCHAR(30)    COMMENT '������IP'  
    ,  OPERATOR_ADDRESS  VARCHAR(180)    COMMENT '�����ߵ�ַ'  
    ,  OPERATOR  VARCHAR(30)    COMMENT '������'  
    ,  OPERATOR_ORG_REFCODE  DECIMAL(10) DEFAULT 0   COMMENT '�����߻�����ˮ��'  
    ,  OPERATE_DATE  DATETIME    COMMENT '����ʱ��'  
    , PRIMARY KEY ( REFCODE ) 
) COMMENT='������־��';


CREATE TABLE FLOG_EXP_M  ( 
      REFCODE  DECIMAL(10) DEFAULT 0 NOT NULL  COMMENT '��ˮ��'  
    ,  EXPORT_DATA_TYPE  CHAR(1)    COMMENT '������������[������ҵ=1/��Ա=2/��Ŀ=3]'  
    ,  EXPORT_DATA_PK  LONGTEXT    COMMENT '����������ˮ��(����,��,���)'  
    ,  EXPORT_DATA_COUNT  DECIMAL(10)    COMMENT '�������ϱ���'  
    ,  EXPORT_USER  VARCHAR(20)    COMMENT '�����û�'  
    ,  ORG_REFCODE  DECIMAL(10) DEFAULT 0   COMMENT '������ҵ��ˮ��(ǰ̨�û�����ʱ��¼)'  
    ,  EXPORT_DATE  DATETIME    COMMENT '����ʱ��'  
    ,  EXPORT_USER_IP  VARCHAR(16)    COMMENT '�û�IP'  
    ,  DATA_STATUS  VARCHAR(10)    COMMENT '����״̬[01=����(�����ڱ��ر��棬��δ�ύ����������ȥ��/11=������/99=��Ч]'  
    ,  ENTITY_ID  VARCHAR(50)    COMMENT '������PK'  
    ,  DEL_FLAG  CHAR(1) DEFAULT '0'   COMMENT 'ɾ�����[��=1/��=0(Default)]'  
    ,  CREATE_USER  VARCHAR(20)    COMMENT '������'  
    ,  CREATE_AGENT_USER  VARCHAR(20)    COMMENT '�����ߴ�����'  
    ,  CREATE_DATE  DATETIME    COMMENT '����ʱ��'  
    ,  EDTID  VARCHAR(3)    COMMENT '��������'  
    ,  LAST_MOD_USER  VARCHAR(20)    COMMENT '������'  
    ,  AGENT_USER  VARCHAR(20)    COMMENT '����������'  
    ,  LAST_MOD_DATE  DATETIME    COMMENT '����ʱ��'  
    , PRIMARY KEY ( REFCODE ) 
) COMMENT='����������־��';


CREATE TABLE FWXM_SAT_M  ( 
      REFCODE  DECIMAL(10) DEFAULT 0 NOT NULL  COMMENT '��ˮ��'  
    ,  ACCESS_TOKEN  VARCHAR(512)    COMMENT '΢��access_token'  
    ,  CREATE_USER  VARCHAR(20)    COMMENT '������(�û�userid,ϵͳĬ��Ϊadmin)'  
    ,  CREATE_DATE  DATETIME    COMMENT '����ʱ��'  
    ,  FAILURE_DATE  DATETIME    COMMENT 'ʧЧʱ��'  
    , PRIMARY KEY ( REFCODE ) 
) COMMENT='΢�Ű�ȫ�������ƴ洢��';


