-- Excel Generate SQL Script
-- for Mysql 
-- =========='2018/9/27 星期四 上午 10:28:38'==========
CREATE TABLE CSPA_FUN_M  ( 
      REFCODE  DECIMAL(10) DEFAULT 0 NOT NULL  COMMENT '流水号'  
    ,  SYSTEM_TYPE  VARCHAR(2)  NOT NULL  COMMENT '资源类型[11=运营端/21=企业端/22=机构端/23=合伙人端]'  
    ,  FUNID  VARCHAR(50)  NOT NULL  COMMENT '功能代号'  
    ,  SEQNO  DECIMAL(10) DEFAULT 0   COMMENT '序号'  
    ,  LAYID  DECIMAL(10) DEFAULT 0   COMMENT '当前层'  
    ,  FUN_DESC  VARCHAR(120)    COMMENT '多语言代号-PCOLID'  
    ,  FUN_PATH  VARCHAR(120)    COMMENT '对应页面路径'  
    ,  PARENTID  DECIMAL(10) DEFAULT 0   COMMENT '父功能代号(序号)'  
    ,  LEVEL_CODE  VARCHAR(100)    COMMENT '层级代号（类似**Z**）'  
    ,  SCPID  VARCHAR(30)    COMMENT '适用范围'  
    ,  FUN_TYPE  CHAR(1)    COMMENT '资源类型[0=菜单/1=按钮]'  
    ,  BOT_FLAG  CHAR(1) DEFAULT '1'   COMMENT '是否是底层权限[0=否/1=是(default)]'  
    ,  USE_FLAG  CHAR(1) DEFAULT '1'   COMMENT '是否在使用[0=否/1=是(default)]'  
    ,  ICON_TYPE  CHAR(1)    COMMENT '图标类型[1=font-awesome/2=iconfont/3=icon-svg]'  
    ,  ICON  VARCHAR(20)    COMMENT '图标'  
    ,  POSITION  VARCHAR(120)    COMMENT '资源所在位置'  
    , PRIMARY KEY ( REFCODE ) 
) COMMENT='系统资源表';


CREATE TABLE CSPA_EXC_M  ( 
      REFCODE  DECIMAL(10) DEFAULT 0 NOT NULL  COMMENT '流水号'  
    ,  EXID  CHAR(3)    COMMENT 'Excel文档号'  
    ,  SHEET_ID  CHAR(3)    COMMENT 'Sheet号'  
    ,  EXNAME  VARCHAR(50)    COMMENT '字段名称'  
    ,  EXDESC  VARCHAR(200)    COMMENT '字段描述'  
    ,  MATCH_NAME  VARCHAR(200)    COMMENT '匹配Excel描述'  
    ,  EXTABLE  VARCHAR(30)    COMMENT '表名'  
    ,  DATA_TYPE  VARCHAR(20)    COMMENT '字段类型'  
    ,  DATA_LEN  DECIMAL(10) DEFAULT 0   COMMENT '字段长度'  
    ,  EXROW_ID  DECIMAL(10) DEFAULT 0   COMMENT '行号'  
    ,  EXCOL_ID  DECIMAL(10) DEFAULT 0   COMMENT '列号'  
    ,  IS_INPUT  CHAR(1) DEFAULT '0'   COMMENT '是否必输[0=否/1=是]'  
    ,  IS_CYCLE  CHAR(1) DEFAULT '0'   COMMENT '是否循环[0=否/1=是]'  
    ,  IS_VALID  CHAR(1) DEFAULT '1'   COMMENT '是否有效[0=否/1=是]'  
    ,  IS_PK  CHAR(1) DEFAULT '0'   COMMENT '是否主键[0=否/1=是]'  
    ,  IS_SHOW  CHAR(1) DEFAULT '1'   COMMENT '是否显示[0=否/1=是]'  
    ,  IS_MODIFY  CHAR(1) DEFAULT '1'   COMMENT '是否修改[0=否/1=是]'  
    ,  SHOW_STYLE  CHAR(1) DEFAULT '0'   COMMENT '页面展示样式[0=文本标签/1=文本框/2=大文本框/3=下拉框]'  
    ,  EXDIRECT  CHAR(1)    COMMENT '循环方式[0=横向/1=纵向]'  
    ,  GET_VALUE_STYLE  CHAR(1) DEFAULT '0'   COMMENT '取值方式[0=行加一/1=列加一]'  
    , PRIMARY KEY ( REFCODE ) 
) COMMENT='Excel数据导入配置表';


CREATE TABLE FSPA_EXG_M  ( 
      REFCODE  DECIMAL(10) DEFAULT 0 NOT NULL  COMMENT '流水号'  
    ,  PARM_TYPE  VARCHAR(20)    COMMENT '参数类别[参考SMME_WEB_INITIALIZE.xls说明文件]'  
    ,  PARM_NAME  VARCHAR(20)    COMMENT '参数代号'  
    ,  PARM_VALUE  VARCHAR(120)    COMMENT '参数值'  
    ,  PARM_DESC  VARCHAR(120)    COMMENT '参数说明'  
    ,  PARENT_ID  VARCHAR(20)    COMMENT '父级代号'  
    ,  PARENT_TYPE  VARCHAR(10)    COMMENT '父级的参数类别'  
    ,  PARM_FLAG  CHAR(1) DEFAULT '2'   COMMENT '参数值标记[真实值=1/多语言代号=2]'  
    , PRIMARY KEY ( REFCODE ) 
) COMMENT='参数配置表';


CREATE TABLE FSPA_COL_M  ( 
      REFCODE  DECIMAL(10) DEFAULT 0 NOT NULL  COMMENT '流水号'  
    ,  COL_ID  VARCHAR(50)    COMMENT '多语言ID'  
    ,  LANGUAGE_ID  VARCHAR(10)    COMMENT '语言种类'  
    ,  COL_DESC  VARCHAR(120)    COMMENT '描述'  
    , PRIMARY KEY ( REFCODE ) 
) COMMENT='多语言描述表';


CREATE TABLE FSPA_NTB_M  ( 
      REFCODE  DECIMAL(10) DEFAULT 0 NOT NULL  COMMENT '流水号'  
    ,  FILE_NAME  VARCHAR(150)    COMMENT '文件名称(下载文件名称)'  
    ,  FILE_TYPE  VARCHAR(10)    COMMENT '文件类型/后缀名'  
    ,  FILE_SIM_NAME  VARCHAR(100)    COMMENT '文件简称(实际模板名称)'  
    ,  SUIT_ORG_TYPE  VARCHAR(50)    COMMENT '适用企业类型(多种企业类型用英文符号“,”隔开。)'  
    ,  FILE_PURPOSE  CHAR(1)    COMMENT '文件用途[1-模板文件]'  
    ,  DEL_FLAG  CHAR(1) DEFAULT '0'   COMMENT '删除标记[是=1/否=0(Default)]'  
    , PRIMARY KEY ( REFCODE ) 
) COMMENT='模板信息表';


CREATE TABLE FSPA_SEQ_M  ( 
      NAME  VARCHAR(50)  NOT NULL  COMMENT '序列名'  
    ,  CURRENT_VALUE  DECIMAL(10) DEFAULT 0 NOT NULL  COMMENT '当前值'  
    , PRIMARY KEY ( NAME ) 
) ENGINE=MyISAM COMMENT='数据库序列表';


CREATE TABLE FIPA_SYS_M  ( 
      REFCODE  DECIMAL(10) DEFAULT 0 NOT NULL  COMMENT '流水号'  
    ,  PARAM_NAME  VARCHAR(180)    COMMENT '参数名称'  
    ,  PARAM_VALUE  VARCHAR(180)    COMMENT '参数值'  
    ,  PARAM_TYPE  DECIMAL(10)    COMMENT '参数类型'  
    ,  PARAM_DESC  VARCHAR(180)    COMMENT '参数描述'  
    ,  PARAM_STATUS  CHAR(1) DEFAULT '1'   COMMENT '参数状态[1=页面显示且可修改(default)/2=页面显示且不可修改/3=页面不显示仅能在数据库修改]'  
    ,  DATA_STATUS  VARCHAR(10)    COMMENT '资料状态[01=保存(即先在本地保存，还未提交到审批流中去）/11=流程中/99=生效]'  
    ,  ENTITY_ID  VARCHAR(50)    COMMENT '审批流PK'  
    ,  DEL_FLAG  CHAR(1) DEFAULT '0'   COMMENT '删除标记[是=1/否=0(Default)]'  
    ,  CREATE_USER  VARCHAR(20)    COMMENT '创建者'  
    ,  CREATE_AGENT_USER  VARCHAR(20)    COMMENT '创建者代理人'  
    ,  CREATE_DATE  DATETIME    COMMENT '创建时间'  
    ,  EDTID  VARCHAR(3)    COMMENT '操作类型'  
    ,  LAST_MOD_USER  VARCHAR(20)    COMMENT '操作者'  
    ,  AGENT_USER  VARCHAR(20)    COMMENT '操作代理人'  
    ,  LAST_MOD_DATE  DATETIME    COMMENT '操作时间'  
    , PRIMARY KEY ( REFCODE ) 
) COMMENT='系统参数设定表';


CREATE TABLE FIPA_CCY_M  ( 
      REFCODE  DECIMAL(10) DEFAULT 0 NOT NULL  COMMENT '流水号'  
    ,  CCYID  VARCHAR(3)    COMMENT '币别代号'  
    ,  CCYDESC  VARCHAR(120)    COMMENT '币别描述'  
    ,  DECIMAL_POSI  DECIMAL(10) DEFAULT 0   COMMENT '精确至小数位数'  
    ,  CCY_EDIT_FMT  VARCHAR(25)    COMMENT '编辑格式'  
    ,  CCY_DISP_FMT  VARCHAR(25)    COMMENT '显示格式'  
    ,  BASE_DAY  DECIMAL(10) DEFAULT 0   COMMENT '计息基础日'  
    ,  EXGRATE_01  DECIMAL(16,8) DEFAULT 0   COMMENT '币别利率换算设定1'  
    ,  EXGRATE_02  DECIMAL(16,8) DEFAULT 0   COMMENT '币别利率换算设定2'  
    ,  EXGRATE_03  DECIMAL(16,8) DEFAULT 0   COMMENT '币别利率换算设定3'  
    ,  EXGRATE_04  DECIMAL(16,8) DEFAULT 0   COMMENT '币别利率换算设定4'  
    ,  EXGRATE_05  DECIMAL(16,8) DEFAULT 0   COMMENT '币别利率换算设定5'  
    ,  EXGRATE_06  DECIMAL(16,8) DEFAULT 0   COMMENT '币别利率换算设定6'  
    ,  EXGRATE_07  DECIMAL(16,8) DEFAULT 0   COMMENT '币别利率换算设定7'  
    ,  EXGRATE_08  DECIMAL(16,8) DEFAULT 0   COMMENT '币别利率换算设定8'  
    ,  EXGRATE_09  DECIMAL(16,8) DEFAULT 0   COMMENT '币别利率换算设定9'  
    ,  EXGRATE_10  DECIMAL(16,8) DEFAULT 0   COMMENT '币别利率换算设定10'  
    ,  EXGRATE_11  DECIMAL(16,8) DEFAULT 0   COMMENT '币别利率换算设定11'  
    ,  EXGRATE_12  DECIMAL(16,8) DEFAULT 0   COMMENT '币别利率换算设定12'  
    ,  HOST_CCYID  VARCHAR(4)    COMMENT '当前主机币别'  
    ,  BUSSDATE  DATETIME    COMMENT '当前营业日'  
    ,  BUP_PCNT  DECIMAL(16,8) DEFAULT 0   COMMENT '买入上浮百分比(0～1之间)'  
    ,  SDW_PCNT  DECIMAL(16,8) DEFAULT 0   COMMENT '卖出下浮百分比(0～1之间)'  
    ,  UNIT_PRICE  DECIMAL(10) DEFAULT 0   COMMENT '货币单价'  
    ,  EDI_CCYID  VARCHAR(3)    COMMENT 'EDI币别代号'  
    ,  DATA_STATUS  VARCHAR(10)    COMMENT '资料状态[01=保存(即先在本地保存，还未提交到审批流中去）/11=流程中/99=生效]'  
    ,  ENTITY_ID  VARCHAR(50)    COMMENT '审批流PK'  
    ,  DEL_FLAG  CHAR(1) DEFAULT '0'   COMMENT '删除标记[是=1/否=0(Default)]'  
    ,  CREATE_USER  VARCHAR(20)    COMMENT '创建者'  
    ,  CREATE_AGENT_USER  VARCHAR(20)    COMMENT '创建者代理人'  
    ,  CREATE_DATE  DATETIME    COMMENT '创建时间'  
    ,  EDTID  VARCHAR(3)    COMMENT '操作类型'  
    ,  LAST_MOD_USER  VARCHAR(20)    COMMENT '操作者'  
    ,  AGENT_USER  VARCHAR(20)    COMMENT '操作代理人'  
    ,  LAST_MOD_DATE  DATETIME    COMMENT '操作时间'  
    , PRIMARY KEY ( REFCODE ) 
) COMMENT='货币别信息表';


CREATE TABLE FIPA_CTY_M  ( 
      REFCODE  DECIMAL(10) DEFAULT 0 NOT NULL  COMMENT '流水号'  
    ,  CTYID  VARCHAR(10)    COMMENT '国家别代号'  
    ,  CTY_DESC  VARCHAR(120)    COMMENT '国家名称'  
    ,  EDI_CTYID  VARCHAR(10)    COMMENT 'EDI国家别代号'  
    ,  DATA_STATUS  VARCHAR(10)    COMMENT '资料状态[01=保存(即先在本地保存，还未提交到审批流中去）/11=流程中/99=生效]'  
    ,  ENTITY_ID  VARCHAR(50)    COMMENT '审批流PK'  
    ,  DEL_FLAG  CHAR(1) DEFAULT '0'   COMMENT '删除标记[是=1/否=0(Default)]'  
    ,  CREATE_USER  VARCHAR(20)    COMMENT '创建者'  
    ,  CREATE_AGENT_USER  VARCHAR(20)    COMMENT '创建者代理人'  
    ,  CREATE_DATE  DATETIME    COMMENT '创建时间'  
    ,  EDTID  VARCHAR(3)    COMMENT '操作类型'  
    ,  LAST_MOD_USER  VARCHAR(20)    COMMENT '操作者'  
    ,  AGENT_USER  VARCHAR(20)    COMMENT '操作代理人'  
    ,  LAST_MOD_DATE  DATETIME    COMMENT '操作时间'  
    , PRIMARY KEY ( REFCODE ) 
) COMMENT='国家别信息表';


CREATE TABLE FIPA_ARE_M  ( 
      REFCODE  DECIMAL(10) DEFAULT 0 NOT NULL  COMMENT '流水号'  
    ,  AREA_LEVEL  CHAR(1)  NOT NULL  COMMENT '地区级别[1=省/2=市/3=区]'  
    ,  AREA_TYPE_CODE  VARCHAR(2)  NOT NULL  COMMENT '区域类型代码[1=华北/2=东北/3=华东/4=华中/5=华南/6=西南/7=西北/8=台港澳]'  
    ,  AREA_CODE  VARCHAR(10)  NOT NULL  COMMENT '行政区划代码'  
    ,  PROVINCE_CODE  VARCHAR(2)  NOT NULL  COMMENT '省代码'  
    ,  AREA_DESC  VARCHAR(255)  NOT NULL  COMMENT '行政区域'  
    ,  PROVINCE_NAME  VARCHAR(64)  NOT NULL  COMMENT '省名称'  
    ,  CITY_NAME  VARCHAR(64)    COMMENT '市名称'  
    ,  COUNTY_NAME  VARCHAR(64)    COMMENT '县名称'  
    ,  TOWN_NAME  VARCHAR(64)    COMMENT '乡镇名称'  
    ,  POST_CODE  VARCHAR(10)    COMMENT '邮编'  
    ,  DATA_STATUS  VARCHAR(10)    COMMENT '资料状态[01=保存(即先在本地保存，还未提交到审批流中去）/11=流程中/99=生效]'  
    ,  ENTITY_ID  VARCHAR(50)    COMMENT '审批流PK'  
    ,  DEL_FLAG  CHAR(1) DEFAULT '0'   COMMENT '删除标记[是=1/否=0(Default)]'  
    ,  CREATE_USER  VARCHAR(20)    COMMENT '创建者'  
    ,  CREATE_AGENT_USER  VARCHAR(20)    COMMENT '创建者代理人'  
    ,  CREATE_DATE  DATETIME    COMMENT '创建时间'  
    ,  EDTID  VARCHAR(3)    COMMENT '操作类型'  
    ,  LAST_MOD_USER  VARCHAR(20)    COMMENT '操作者'  
    ,  AGENT_USER  VARCHAR(20)    COMMENT '操作代理人'  
    ,  LAST_MOD_DATE  DATETIME    COMMENT '操作时间'  
    , PRIMARY KEY ( REFCODE ) 
) COMMENT='地区信息表';


CREATE TABLE FIPA_OTP_M  ( 
      REFCODE  DECIMAL(10) DEFAULT 0 NOT NULL  COMMENT '流水号'  
    ,  OTPCODE  VARCHAR(40)  NOT NULL  COMMENT '投向行业编码(系统生成，对树形结构进行编码，子孙编码内记载了父辈编码信息)'  
    ,  OTPID  VARCHAR(20)    COMMENT '行业类别代号(客户设定)'  
    ,  OTPNAME  VARCHAR(50)    COMMENT '行业类别名称'  
    ,  OTPLVL  DECIMAL(10) DEFAULT 1 NOT NULL  COMMENT '行业类别级别(层级编号，1=第一层，以此类推)'  
    ,  LOAN_EXT01  VARCHAR(20)    COMMENT '扩展字段'  
    ,  DATA_STATUS  VARCHAR(10)    COMMENT '资料状态[01=保存(即先在本地保存，还未提交到审批流中去）/11=流程中/99=生效]'  
    ,  ENTITY_ID  VARCHAR(50)    COMMENT '审批流PK'  
    ,  DEL_FLAG  CHAR(1) DEFAULT '0'   COMMENT '删除标记[是=1/否=0(Default)]'  
    ,  CREATE_USER  VARCHAR(20)    COMMENT '创建者'  
    ,  CREATE_AGENT_USER  VARCHAR(20)    COMMENT '创建者代理人'  
    ,  CREATE_DATE  DATETIME    COMMENT '创建时间'  
    ,  EDTID  VARCHAR(3)    COMMENT '操作类型'  
    ,  LAST_MOD_USER  VARCHAR(20)    COMMENT '操作者'  
    ,  AGENT_USER  VARCHAR(20)    COMMENT '操作代理人'  
    ,  LAST_MOD_DATE  DATETIME    COMMENT '操作时间'  
    , PRIMARY KEY ( REFCODE ) 
) COMMENT='行业类别表';


CREATE TABLE FIPA_BCH_M  ( 
      REFCODE  DECIMAL(10) DEFAULT 0 NOT NULL  COMMENT '流水号'  
    ,  BANK_ID  VARCHAR(20)  NOT NULL  COMMENT '银行网点代号'  
    ,  BANK_NAME  VARCHAR(120)    COMMENT '银行网点名称'  
    ,  BANK_LEVEL  CHAR(1)    COMMENT '网点级别[1=总行(行政)/2=总行(营业)/3=分(支)行]'  
    ,  PARENT_BANK_ID  VARCHAR(20)    COMMENT '上级行代号'  
    ,  BELONG_BANK_ID  VARCHAR(20)    COMMENT '所属银行'  
    ,  CNAPS_CODE  VARCHAR(20)    COMMENT '银行大额行号'  
    ,  BANK_ADDR  VARCHAR(180)    COMMENT '网点地址'  
    ,  BANK_AREA_CODE  VARCHAR(10)    COMMENT '网点所在地区'  
    ,  BANK_ICON  VARCHAR(10)    COMMENT '图标名称'  
    ,  DATA_STATUS  VARCHAR(10)    COMMENT '资料状态[01=保存(即先在本地保存，还未提交到审批流中去）/11=流程中/99=生效]'  
    ,  ENTITY_ID  VARCHAR(50)    COMMENT '审批流PK'  
    ,  DEL_FLAG  CHAR(1) DEFAULT '0'   COMMENT '删除标记[是=1/否=0(Default)]'  
    ,  CREATE_USER  VARCHAR(20)    COMMENT '创建者'  
    ,  CREATE_AGENT_USER  VARCHAR(20)    COMMENT '创建者代理人'  
    ,  CREATE_DATE  DATETIME    COMMENT '创建时间'  
    ,  EDTID  VARCHAR(3)    COMMENT '操作类型'  
    ,  LAST_MOD_USER  VARCHAR(20)    COMMENT '操作者'  
    ,  AGENT_USER  VARCHAR(20)    COMMENT '操作代理人'  
    ,  LAST_MOD_DATE  DATETIME    COMMENT '操作时间'  
    , PRIMARY KEY ( REFCODE ) 
) COMMENT='银行信息表';


CREATE TABLE FIPA_NUM_M  ( 
      REFCODE  DECIMAL(10) DEFAULT 0 NOT NULL  COMMENT '流水号'  
    ,  NUM_TYPE  DECIMAL(10) DEFAULT 0   COMMENT '编号类型[见常量定义]'  
    ,  NUM_VALUE  VARCHAR(50)    COMMENT '编号对应值'  
    ,  NUM_DATE  VARCHAR(8)    COMMENT '统计日期'  
    ,  CURR_SEQNUM  DECIMAL(10) DEFAULT 0   COMMENT '目前序号'  
    ,  LAST_MOD_USER  VARCHAR(20)    COMMENT '操作者'  
    ,  LAST_MOD_DATE  DATETIME    COMMENT '操作时间'  
    , PRIMARY KEY ( REFCODE ) 
) COMMENT='系统编号生成表';


CREATE TABLE FCMS_IMG_M  ( 
      REFCODE  DECIMAL(10) DEFAULT 0 NOT NULL  COMMENT '流水号'  
    ,  CATEGORY_CODE  VARCHAR(30)  NOT NULL  COMMENT '栏目代码'  
    ,  IMAGE_NAME  VARCHAR(30)    COMMENT '图片名称'  
    ,  START_DATE  DATETIME    COMMENT '起始有效日期'  
    ,  END_DATE  DATETIME    COMMENT '截止有效日期'  
    ,  IMAGE_RANK  DECIMAL(10)  NOT NULL  COMMENT '图片排序'  
    ,  IMAGE_URL  VARCHAR(100)    COMMENT '图片链接地址'  
    ,  IMAGE_URL_OPEN_TYPE  CHAR(1) DEFAULT '2'   COMMENT '图片链接打开方式[1=_blank/2=_self]'  
    ,  IMAGE_UUID  VARCHAR(50)  NOT NULL  COMMENT '图片UUID'  
    ,  USE_FLAG  CHAR(1) DEFAULT '1'   COMMENT '是否启用[0=禁用/1=启用]'  
    ,  DATA_STATUS  VARCHAR(10)    COMMENT '资料状态[01=保存(即先在本地保存，还未提交到审批流中去）/11=流程中/99=生效]'  
    ,  ENTITY_ID  VARCHAR(50)    COMMENT '审批流PK'  
    ,  DEL_FLAG  CHAR(1) DEFAULT '0'   COMMENT '删除标记[是=1/否=0(Default)]'  
    ,  CREATE_USER  VARCHAR(20)    COMMENT '创建者'  
    ,  CREATE_AGENT_USER  VARCHAR(20)    COMMENT '创建者代理人'  
    ,  CREATE_DATE  DATETIME    COMMENT '创建时间'  
    ,  EDTID  VARCHAR(3)    COMMENT '操作类型'  
    ,  LAST_MOD_USER  VARCHAR(20)    COMMENT '操作者'  
    ,  AGENT_USER  VARCHAR(20)    COMMENT '操作代理人'  
    ,  LAST_MOD_DATE  DATETIME    COMMENT '操作时间'  
    , PRIMARY KEY ( REFCODE ) 
) COMMENT='图片表';


CREATE TABLE FCMS_BRO_CNT_M  ( 
      REFCODE  DECIMAL(10) DEFAULT 0 NOT NULL  COMMENT '流水号'  
    ,  USER_AGENT  VARCHAR(500)    COMMENT '浏览器标识'  
    ,  REFERER  VARCHAR(500)    COMMENT '浏览器来源信息'  
    ,  URL  VARCHAR(500)    COMMENT '浏览器URL信息'  
    ,  OS  VARCHAR(64)    COMMENT '操作系统'  
    ,  HREF  VARCHAR(500)    COMMENT '浏览器HREF信息'  
    ,  BROWSER  VARCHAR(64)    COMMENT '浏览器类型'  
    ,  BROWSER_LANGUAGE  VARCHAR(64)    COMMENT '浏览器语言'  
    ,  FUNC_MODEL  VARCHAR(16)    COMMENT '功能模块'  
    ,  IP  VARCHAR(16)    COMMENT 'IP地址'  
    ,  COUNT  DECIMAL(10)    COMMENT '访问实际值'  
    ,  COUNT_VIRTUAL  DECIMAL(10)    COMMENT '访问模拟值'  
    ,  REFERER_PLATFORM  NVARCHAR(50)    COMMENT '访问来源平台'  
    ,  CREATE_TIME  DATETIME DEFAULT '1901-01-01 00:00:00' NOT NULL  COMMENT ''  
    , PRIMARY KEY ( REFCODE ) 
) COMMENT='页面统计表';


CREATE TABLE FBTX_APX_M  ( 
      REFCODE  DECIMAL(10) DEFAULT 0 NOT NULL  COMMENT '流水号'  
    ,  FILE_UUID  VARCHAR(40)    COMMENT '文件上传对象惟一编号'  
    ,  FILE_SOURCE  CHAR(1)    COMMENT '文件来源[1-本系统/2-信贷系统]'  
    ,  FILE_NAME  VARCHAR(50)    COMMENT '文件名'  
    ,  FILE_TYPE  VARCHAR(10)    COMMENT '文件类型/后缀名'  
    ,  FILE_PATH  VARCHAR(200)    COMMENT '文件路径'  
    ,  STORE_NAME  VARCHAR(100)    COMMENT '文件存储名'  
    ,  MEMO  VARCHAR(100)    COMMENT '说明'  
    ,  DATA_STATUS  VARCHAR(10)    COMMENT '资料状态[01=保存(即先在本地保存，还未提交到审批流中去）/11=流程中/99=生效]'  
    ,  ENTITY_ID  VARCHAR(50)    COMMENT '审批流PK'  
    ,  DEL_FLAG  CHAR(1) DEFAULT '0'   COMMENT '删除标记[是=1/否=0(Default)]'  
    ,  CREATE_USER  VARCHAR(20)    COMMENT '创建者'  
    ,  CREATE_AGENT_USER  VARCHAR(20)    COMMENT '创建者代理人'  
    ,  CREATE_DATE  DATETIME    COMMENT '创建时间'  
    ,  EDTID  VARCHAR(3)    COMMENT '操作类型'  
    ,  LAST_MOD_USER  VARCHAR(20)    COMMENT '操作者'  
    ,  AGENT_USER  VARCHAR(20)    COMMENT '操作代理人'  
    ,  LAST_MOD_DATE  DATETIME    COMMENT '操作时间'  
    , PRIMARY KEY ( REFCODE ) 
) COMMENT='附件存储表';


CREATE TABLE FBTX_APP_M  ( 
      REFCODE  DECIMAL(10) DEFAULT 0 NOT NULL  COMMENT '流水号'  
    ,  INIT_ORG_REFCODE  DECIMAL(10) DEFAULT 0   COMMENT '发起企业(机构)流水号'  
    ,  RATE_ORG_REFCODE  DECIMAL(10) DEFAULT 0   COMMENT '被评价企业(机构)流水号'  
    ,  APP_TYPE  CHAR(1)  NOT NULL  COMMENT '评价类型[1=融资/2=融资企业评价/3=机构评价]'  
    ,  TRADE_REFCODE  DECIMAL(10)    COMMENT '融资交易(报价)流水号'  
    ,  APP_LEVEL  VARCHAR(2)    COMMENT '评价等级(星级)'  
    ,  APP_CONTENT  VARCHAR(200)    COMMENT '评价内容'  
    ,  DATA_STATUS  VARCHAR(10)    COMMENT '资料状态[01=保存(即先在本地保存，还未提交到审批流中去）/11=流程中/99=生效]'  
    ,  ENTITY_ID  VARCHAR(50)    COMMENT '审批流PK'  
    ,  DEL_FLAG  CHAR(1) DEFAULT '0'   COMMENT '删除标记[是=1/否=0(Default)]'  
    ,  CREATE_USER  VARCHAR(20)    COMMENT '创建者'  
    ,  CREATE_AGENT_USER  VARCHAR(20)    COMMENT '创建者代理人'  
    ,  CREATE_DATE  DATETIME    COMMENT '创建时间'  
    ,  EDTID  VARCHAR(3)    COMMENT '操作类型'  
    ,  LAST_MOD_USER  VARCHAR(20)    COMMENT '操作者'  
    ,  AGENT_USER  VARCHAR(20)    COMMENT '操作代理人'  
    ,  LAST_MOD_DATE  DATETIME    COMMENT '操作时间'  
    , PRIMARY KEY ( REFCODE ) 
) COMMENT='平台评价信息表';


CREATE TABLE FBTX_NOT_M  ( 
      REFCODE  DECIMAL(10) DEFAULT 0 NOT NULL  COMMENT '流水号'  
    ,  PUSH_TYPE  CHAR(1)  NOT NULL  COMMENT '消息发起用户类型[1=系统/2=企业/3=用户]'  
    ,  PUSH_ORG_REFCODE  DECIMAL(10) DEFAULT 0   COMMENT '消息发起企业(机构)流水号'  
    ,  RECEIVE_USERID  VARCHAR(50)    COMMENT '消息接收用户id'  
    ,  RECEIVE_ORG_REFCODE  DECIMAL(10) DEFAULT 0   COMMENT '消息接收企业(机构)流水号'  
    ,  NOTICE_CODE  VARCHAR(20)    COMMENT '消息编号'  
    ,  NOTICE_TITLE  VARCHAR(200)    COMMENT '消息标题'  
    ,  NOTICE_CONTENT  VARCHAR(500)    COMMENT '消息内容'  
    ,  NOTICE_CONTENT_HREF  VARCHAR(800)    COMMENT '消息带链接内容'  
    ,  NOTICE_FLAG  CHAR(1) DEFAULT '0'   COMMENT '消息状态(0=未读/1=已读)'  
    ,  READ_TIME  DATETIME    COMMENT '读取时间'  
    ,  SHOW_HOME  CHAR(1) DEFAULT '0'   COMMENT '是否在首页显示(0=否/1=是)'  
    ,  DATA_STATUS  VARCHAR(10)    COMMENT '资料状态[01=保存(即先在本地保存，还未提交到审批流中去）/11=流程中/99=生效]'  
    ,  ENTITY_ID  VARCHAR(50)    COMMENT '审批流PK'  
    ,  DEL_FLAG  CHAR(1) DEFAULT '0'   COMMENT '删除标记[是=1/否=0(Default)]'  
    ,  CREATE_USER  VARCHAR(20)    COMMENT '创建者'  
    ,  CREATE_AGENT_USER  VARCHAR(20)    COMMENT '创建者代理人'  
    ,  CREATE_DATE  DATETIME    COMMENT '创建时间'  
    ,  EDTID  VARCHAR(3)    COMMENT '操作类型'  
    ,  LAST_MOD_USER  VARCHAR(20)    COMMENT '操作者'  
    ,  AGENT_USER  VARCHAR(20)    COMMENT '操作代理人'  
    ,  LAST_MOD_DATE  DATETIME    COMMENT '操作时间'  
    , PRIMARY KEY ( REFCODE ) 
) COMMENT='平台消息提醒表';


CREATE TABLE SIPA_BUR_M  ( 
      REFCODE  DECIMAL(10) DEFAULT 0 NOT NULL  COMMENT '流水号'  
    ,  SYSTEM_TYPE  CHAR(1)  NOT NULL  COMMENT '所属系统类型[1=后台/2=前台]'  
    ,  USERID  VARCHAR(20)  NOT NULL  COMMENT '用户代号(前台自动生成、后台登录账号)'  
    ,  USER_NAME  VARCHAR(50)    COMMENT '用户名'  
    ,  PASSWORD  VARCHAR(50)    COMMENT '密码'  
    ,  CHGPWD_FLAG  CHAR(1) DEFAULT '1'   COMMENT '用户登陆时是否要求修改密码[0=否/1=是(default)]'  
    ,  VALID_DAY  DECIMAL(10)    COMMENT '密码有效天数'  
    ,  WARNING_DAY  DECIMAL(10)    COMMENT '密码到期前警告天数'  
    ,  PWD_EXPIRYDATE  DATETIME    COMMENT '密码到期日(据ValidDay算出)'  
    ,  CHGPWD_DATE  DATETIME    COMMENT '上次更改密码时间'  
    ,  MOBILEPHONE  VARCHAR(30)    COMMENT '手机号码'  
    ,  EMAIL  VARCHAR(120)    COMMENT '电子邮箱'  
    ,  TEL_AREA  VARCHAR(30)    COMMENT '座机号码（区号）'  
    ,  TEL  VARCHAR(30)    COMMENT '座机号码（电话）'  
    ,  EXTNO  VARCHAR(5)    COMMENT '座机号码（分机号）'  
    ,  WEIXIN  VARCHAR(30)    COMMENT '微信号码'  
    ,  AREA_COUNTY  VARCHAR(60)    COMMENT '所在地区'  
    ,  PROVINCE_CODE  VARCHAR(2)    COMMENT '省份代码'  
    ,  ADDRESS  VARCHAR(180)    COMMENT '详细地址'  
    ,  POSTCODE  VARCHAR(20)    COMMENT '邮政编码'  
    ,  ID_NO  VARCHAR(20)    COMMENT '身份证号码'  
    ,  LAST_LOGIN_ADDRESS  VARCHAR(100)    COMMENT '上次登录地址'  
    ,  LAST_LOGIN_DATE  DATETIME    COMMENT '上次登录时间'  
    ,  MOBILE_VAILD_STATUS  CHAR(1) DEFAULT '0'   COMMENT '手机验证状态[0=未验证/1=已验证]'  
    ,  EMAIL_VAILD_STATUS  CHAR(1) DEFAULT '0'   COMMENT '邮箱验证状态[0=未验证/1=已验证]'  
    ,  SOURCE  CHAR(1) DEFAULT '0'   COMMENT '数据来源[0=正常/1=微信]'  
    ,  ADMIN_FLAG  CHAR(1)    COMMENT '是否超级管理员[1=是/0=否]'  
    ,  USE_FLAG  CHAR(1) DEFAULT '1'   COMMENT '是否启用[0=禁用/1=启用]'  
    ,  DATA_STATUS  VARCHAR(10)    COMMENT '资料状态[01=保存(即先在本地保存，还未提交到审批流中去）/11=流程中/99=生效]'  
    ,  ENTITY_ID  VARCHAR(50)    COMMENT '审批流PK'  
    ,  DEL_FLAG  CHAR(1) DEFAULT '0'   COMMENT '删除标记[是=1/否=0(Default)]'  
    ,  CREATE_USER  VARCHAR(20)    COMMENT '创建者'  
    ,  CREATE_AGENT_USER  VARCHAR(20)    COMMENT '创建者代理人'  
    ,  CREATE_DATE  DATETIME DEFAULT '1901-01-01 00:00:00'   COMMENT '创建时间'  
    ,  EDTID  VARCHAR(3)    COMMENT '操作类型'  
    ,  LAST_MOD_USER  VARCHAR(20)    COMMENT '操作者'  
    ,  AGENT_USER  VARCHAR(20)    COMMENT '操作代理人'  
    ,  LAST_MOD_DATE  DATETIME DEFAULT '1901-01-01 00:00:00'   COMMENT '操作时间'  
    , PRIMARY KEY ( REFCODE ) 
) COMMENT='用户信息表';


CREATE TABLE SIPA_BTO_M  ( 
      REFCODE  DECIMAL(10) DEFAULT 0 NOT NULL  COMMENT '流水号'  
    ,  USERID  VARCHAR(20)    COMMENT '用户代号'  
    ,  ORG_REFCODE  DECIMAL(10) DEFAULT 0   COMMENT '企业流水号'  
    ,  ADMIN_FLAG  CHAR(1)    COMMENT '是否管理员[1=是/0=否]'  
    ,  EDTID  VARCHAR(3)    COMMENT '操作类型'  
    ,  LAST_MOD_USER  VARCHAR(20)    COMMENT '操作者'  
    ,  LAST_MOD_DATE  DATETIME    COMMENT '操作时间'  
    , PRIMARY KEY ( REFCODE ) 
) COMMENT='用户与企业关联表';


CREATE TABLE SIPA_ROL_M  ( 
      REFCODE  DECIMAL(10) DEFAULT 0 NOT NULL  COMMENT '流水号'  
    ,  SYSTEM_TYPE  CHAR(1)  NOT NULL  COMMENT '所属系统类型[1=后台/2=前台]'  
    ,  ROLEID  VARCHAR(50)  NOT NULL  COMMENT '角色代号'  
    ,  ROLE_NAME  VARCHAR(120)    COMMENT '角色名称'  
    ,  ROLEDESC  VARCHAR(200)    COMMENT '角色描述'  
    ,  SCPID  VARCHAR(3)    COMMENT '适用范围'  
    ,  PARENT_ROLEID  VARCHAR(40)    COMMENT '父角色代号'  
    ,  ORG_REFCODE  DECIMAL(10) DEFAULT 0   COMMENT '所属企业流水号'  
    ,  USE_FLAG  CHAR(1) DEFAULT '1'   COMMENT '是否启用[0=禁用/1=启用]'  
    ,  DATA_STATUS  VARCHAR(10)    COMMENT '资料状态[01=保存(即先在本地保存，还未提交到审批流中去）/11=流程中/99=生效]'  
    ,  ENTITY_ID  VARCHAR(50)    COMMENT '审批流PK'  
    ,  DEL_FLAG  CHAR(1) DEFAULT '0'   COMMENT '删除标记[是=1/否=0(Default)]'  
    ,  CREATE_USER  VARCHAR(20)    COMMENT '创建者'  
    ,  CREATE_AGENT_USER  VARCHAR(20)    COMMENT '创建者代理人'  
    ,  CREATE_DATE  DATETIME    COMMENT '创建时间'  
    ,  EDTID  VARCHAR(3)    COMMENT '操作类型'  
    ,  LAST_MOD_USER  VARCHAR(20)    COMMENT '操作者'  
    ,  AGENT_USER  VARCHAR(20)    COMMENT '操作代理人'  
    ,  LAST_MOD_DATE  DATETIME    COMMENT '操作时间'  
    , PRIMARY KEY ( REFCODE ) 
) COMMENT='角色基本信息表';


CREATE TABLE SIPA_RTF_M  ( 
      REFCODE  DECIMAL(10) DEFAULT 0 NOT NULL  COMMENT '流水号'  
    ,  ROLEID  VARCHAR(40)    COMMENT '角色代号'  
    ,  FUNID  VARCHAR(50)    COMMENT '功能代号'  
    ,  EDTID  VARCHAR(3)    COMMENT '操作类型'  
    ,  LAST_MOD_USER  VARCHAR(20)    COMMENT '操作者'  
    ,  LAST_MOD_DATE  DATETIME    COMMENT '操作时间'  
    , PRIMARY KEY ( REFCODE ) 
) COMMENT='角色与权限关联表';


CREATE TABLE SIPA_BTR_M  ( 
      REFCODE  DECIMAL(10) DEFAULT 0 NOT NULL  COMMENT '流水号'  
    ,  USERID  VARCHAR(20)    COMMENT '用户代号'  
    ,  ROLEID  VARCHAR(40)    COMMENT '角色代号'  
    ,  ORG_REFCODE  DECIMAL(10) DEFAULT 0   COMMENT '所属企业流水号'  
    ,  EDTID  VARCHAR(3)    COMMENT '操作类型'  
    ,  LAST_MOD_USER  VARCHAR(20)    COMMENT '操作者'  
    ,  LAST_MOD_DATE  DATETIME    COMMENT '操作时间'  
    , PRIMARY KEY ( REFCODE ) 
) COMMENT='用户与角色关联表';


CREATE TABLE SIPA_BTP_M  ( 
      REFCODE  DECIMAL(10) DEFAULT 0 NOT NULL  COMMENT '流水号'  
    ,  USERID  VARCHAR(20)    COMMENT '用户代号'  
    ,  PROVINCE_CODE  VARCHAR(2)    COMMENT '省份代号'  
    ,  EDTID  VARCHAR(3)    COMMENT '操作类型'  
    ,  LAST_MOD_USER  VARCHAR(20)    COMMENT '操作者'  
    ,  LAST_MOD_DATE  DATETIME    COMMENT '操作时间'  
    , PRIMARY KEY ( REFCODE ) 
) COMMENT='后台用户与省份关联表';


CREATE TABLE SIPA_BTB_M  ( 
      REFCODE  DECIMAL(10) DEFAULT 0 NOT NULL  COMMENT '流水号'  
    ,  USERID  VARCHAR(20)    COMMENT '用户代号'  
    ,  BRAND_REFCODE  DECIMAL(10)    COMMENT '品牌流水号'  
    ,  EDTID  VARCHAR(3)    COMMENT '操作类型'  
    ,  LAST_MOD_USER  VARCHAR(20)    COMMENT '操作者'  
    ,  LAST_MOD_DATE  DATETIME    COMMENT '操作时间'  
    , PRIMARY KEY ( REFCODE ) 
) COMMENT='后台用户与品牌关联表';


CREATE TABLE FLOG_OPT_M  ( 
      REFCODE  DECIMAL(10) DEFAULT 0 NOT NULL  COMMENT '流水号'  
    ,  FUN_ID  VARCHAR(30)    COMMENT '功能代号(对应菜单树的代号) (登陆为:login,登出为:logout)'  
    ,  FUN_DESC  VARCHAR(30)    COMMENT '功能描述(对应菜单树的描述)'  
    ,  EDTID  VARCHAR(10)    COMMENT '操作代号[login(登录)、logout(登出)、ENT(进入功能)、SMT(提交)、NEW、MOD、DEL/……]'  
    ,  XML_PATH  VARCHAR(100)    COMMENT '调用XML地址'  
    ,  SERVICE_NAME  VARCHAR(50)    COMMENT '调用后台SERVICE名'  
    ,  FUNCTION_NAME  VARCHAR(50)    COMMENT '调用后台FUNCTION名'  
    ,  PARAMETERS  VARCHAR(1000)    COMMENT '提交后台的数据(截取前1000个字符)'  
    ,  OPERATOR_IP  VARCHAR(30)    COMMENT '操作者IP'  
    ,  OPERATOR_ADDRESS  VARCHAR(180)    COMMENT '操作者地址'  
    ,  OPERATOR  VARCHAR(30)    COMMENT '操作者'  
    ,  OPERATOR_ORG_REFCODE  DECIMAL(10) DEFAULT 0   COMMENT '操作者机构流水号'  
    ,  OPERATE_DATE  DATETIME    COMMENT '操作时间'  
    , PRIMARY KEY ( REFCODE ) 
) COMMENT='操作日志表';


CREATE TABLE FLOG_EXP_M  ( 
      REFCODE  DECIMAL(10) DEFAULT 0 NOT NULL  COMMENT '流水号'  
    ,  EXPORT_DATA_TYPE  CHAR(1)    COMMENT '导出资料类型[机构企业=1/会员=2/项目=3]'  
    ,  EXPORT_DATA_PK  LONGTEXT    COMMENT '导出资料流水号(集合,以,间隔)'  
    ,  EXPORT_DATA_COUNT  DECIMAL(10)    COMMENT '导出资料笔数'  
    ,  EXPORT_USER  VARCHAR(20)    COMMENT '导出用户'  
    ,  ORG_REFCODE  DECIMAL(10) DEFAULT 0   COMMENT '所属企业流水号(前台用户导出时记录)'  
    ,  EXPORT_DATE  DATETIME    COMMENT '导出时间'  
    ,  EXPORT_USER_IP  VARCHAR(16)    COMMENT '用户IP'  
    ,  DATA_STATUS  VARCHAR(10)    COMMENT '资料状态[01=保存(即先在本地保存，还未提交到审批流中去）/11=流程中/99=生效]'  
    ,  ENTITY_ID  VARCHAR(50)    COMMENT '审批流PK'  
    ,  DEL_FLAG  CHAR(1) DEFAULT '0'   COMMENT '删除标记[是=1/否=0(Default)]'  
    ,  CREATE_USER  VARCHAR(20)    COMMENT '创建者'  
    ,  CREATE_AGENT_USER  VARCHAR(20)    COMMENT '创建者代理人'  
    ,  CREATE_DATE  DATETIME    COMMENT '创建时间'  
    ,  EDTID  VARCHAR(3)    COMMENT '操作类型'  
    ,  LAST_MOD_USER  VARCHAR(20)    COMMENT '操作者'  
    ,  AGENT_USER  VARCHAR(20)    COMMENT '操作代理人'  
    ,  LAST_MOD_DATE  DATETIME    COMMENT '操作时间'  
    , PRIMARY KEY ( REFCODE ) 
) COMMENT='导出资料日志表';


CREATE TABLE FWXM_SAT_M  ( 
      REFCODE  DECIMAL(10) DEFAULT 0 NOT NULL  COMMENT '流水号'  
    ,  ACCESS_TOKEN  VARCHAR(512)    COMMENT '微信access_token'  
    ,  CREATE_USER  VARCHAR(20)    COMMENT '创建者(用户userid,系统默认为admin)'  
    ,  CREATE_DATE  DATETIME    COMMENT '创建时间'  
    ,  FAILURE_DATE  DATETIME    COMMENT '失效时间'  
    , PRIMARY KEY ( REFCODE ) 
) COMMENT='微信安全访问令牌存储表';


