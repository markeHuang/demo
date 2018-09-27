DROP FUNCTION IF EXISTS currval;
CREATE FUNCTION currval (seq_name VARCHAR(50))
	 RETURNS decimal(10)
	 LANGUAGE SQL
	 DETERMINISTIC
	 CONTAINS SQL
	 SQL SECURITY DEFINER
	 COMMENT '获取指定序列当前取值'
BEGIN
	 DECLARE tmpvalue decimal(10);
	 DECLARE tmpname varchar(50);
	 SET tmpvalue = 1;
	 SELECT current_value,name INTO tmpvalue,tmpname 
	 FROM FSPA_SEQ_M 
	 WHERE name = seq_name;
	 if isnull(tmpname) then
		insert into FSPA_SEQ_M values(seq_name,1);
	 end if;
	 RETURN tmpvalue;
END;

DROP FUNCTION IF EXISTS nextval;
CREATE FUNCTION nextval (seq_name varchar(50))
	RETURNS decimal(10) NOT DETERMINISTIC
    COMMENT '获取指定序列下一取值'
BEGIN
    DECLARE cur_val decimal(10);
    SELECT current_value+1 INTO cur_val
    FROM FSPA_SEQ_M
    WHERE NAME = seq_name;
 
    UPDATE FSPA_SEQ_M SET current_value = current_value + 1
    WHERE NAME = seq_name;
    RETURN cur_val;
END;

DROP FUNCTION IF EXISTS to_char;
CREATE FUNCTION to_char(d DATETIME,f VARCHAR(30))
    RETURNS VARCHAR(20) CHARACTER SET utf8
    DETERMINISTIC
    CONTAINS SQL
    SQL SECURITY DEFINER
    COMMENT '将日期类型转换为yyyy-mm-dd格式'
BEGIN
	SET f = UPPER(f);
	IF f='YYYY' THEN -- 年份
	RETURN EXTRACT(YEAR FROM d);
	ELSEIF f='Q' THEN -- 季度
	RETURN QUARTER(d);
	ELSEIF f='MM' THEN -- 月份
	RETURN EXTRACT(MONTH FROM d);
	ELSEIF f='D' THEN -- 周
	RETURN date_format(d,'%w') + 1;
	ELSEIF f='DD' THEN -- 日期
	RETURN EXTRACT(DAY FROM d);
	ELSEIF f='YYYY-MM' THEN -- 年月
	RETURN date_format(d,'%Y-%m');
	ELSEIF f='YYYY-MM-DD' THEN -- 年月日
	RETURN date_format(d,'%Y-%m-%d');
	ELSEIF f='YYYY-MM-DD HH:MI:SS' THEN -- 年月日
	RETURN date_format(d,'%Y-%m-%d %h:%i:%s');
	ELSEIF f='YYYY-MM-DD HH24:MI:SS' THEN -- 年月日
	RETURN date_format(d,'%Y-%m-%d %H:%i:%s');
	END IF;
END;

DROP FUNCTION IF EXISTS NVL;
CREATE FUNCTION NVL(expr1 VARCHAR(100),expr2 VARCHAR(100)) 
RETURNS varchar(100) CHARSET utf8
COMMENT '将NULL值转换为指定字符串'
BEGIN
  RETURN IFNULL(expr1,expr2);
END;

DROP FUNCTION IF EXISTS TO_DATE;
CREATE FUNCTION TO_DATE (d varchar(100), f varchar(100)) 
	RETURNS varchar(100) CHARSET utf8
BEGIN
	SET f = UPPER(f);
	IF f='YYYY-MM-DD' THEN -- 年月日
	RETURN STR_TO_DATE(to_char(d, 'yyyy-MM-dd'),'%Y-%m-%d');
	ELSEIF f='YYYY-MM-DD HH:MI:SS' THEN -- 年月日时分秒(12小时制)
	RETURN STR_TO_DATE(to_char(d, 'yyyy-MM-dd hh:mi:ss'),'%Y-%m-%d %h:%i:%s');
	ELSEIF f='YYYY-MM-DD HH24:MI:SS' THEN -- 年月日时分秒(24小时制)
	RETURN STR_TO_DATE(to_char(d, 'yyyy-MM-dd HH24:mi:ss'),'%Y-%m-%d %H:%i:%s');
	END IF;
END;

DROP FUNCTION IF EXISTS DECIDE;
CREATE FUNCTION DECIDE(s1 VARCHAR(100),s2 VARCHAR(100),s3 VARCHAR(100),s4 VARCHAR(100))
	 RETURNS VARCHAR(100)CHARSET utf8
BEGIN
	DECLARE result VARCHAR(100);
	IF (s1=s2) THEN
		SET result=s3;
	ELSE 
		SET result=s4;
	END IF;
	RETURN(result); 
 END;

DROP FUNCTION IF EXISTS DECIDE2;	 
CREATE FUNCTION DECIDE2 (s1  VARCHAR(100),
     s2      VARCHAR(100),
	 s3      VARCHAR(100),
	 s4      VARCHAR(100),
     s5      VARCHAR(100),
     s6      VARCHAR(100)) 
RETURNS varchar(100) CHARSET utf8
BEGIN
       DECLARE result VARCHAR(100);
       IF (s1=s2) THEN
         SET result=s3;
       ELSEIF(s1=s4) THEN
         SET result=s5;
       ELSE SET result=s6;
       END IF;
       RETURN(result); 
END;

DROP FUNCTION IF EXISTS TRUNC;
CREATE FUNCTION TRUNC(expr1 VARCHAR(100),expr2 VARCHAR(100)) 
RETURNS varchar(100) CHARSET utf8
BEGIN
  RETURN ABS(datediff(expr1,expr2));
END;

DROP FUNCTION IF EXISTS DECIDE8;
CREATE FUNCTION DECIDE8 (s1  VARCHAR(100),
     s2      VARCHAR(100),
	 s3      VARCHAR(100),
	 s4      VARCHAR(100),
     s5      VARCHAR(100),
     s6      VARCHAR(100),
     s7      VARCHAR(100),
     s8      VARCHAR(100))
RETURNS varchar(100) CHARSET utf8
BEGIN
       DECLARE result VARCHAR(100);
       IF (s1=s2) THEN
         SET result=s3;
       ELSEIF(s1=s4) THEN
         SET result=s5;
       ELSEIF(s1=s6) THEN
         SET result=s7;
       ELSE SET result=s8;
       END IF;
       RETURN(result); 
END;

DROP FUNCTION IF EXISTS converIsNeed;
CREATE FUNCTION `converIsNeed`(isneed  VARCHAR(2)) RETURNS varchar(5) CHARSET utf8
BEGIN
  DECLARE need varchar(20);
  IF (isneed = 0) THEN
  set need = '否';
  ELSEIF (isneed = 1) THEN
  SET need = '是';
  END IF;
	RETURN need;
END;

DROP FUNCTION IF EXISTS converLoanRateType;
CREATE FUNCTION `converLoanRateType`(rateType VARCHAR(2)) RETURNS varchar(100) CHARSET utf8
BEGIN
  DECLARE loanRateType varchar(100);
  SELECT PARM_DESC INTO loanRateType from fspa_exg_m where PARM_TYPE = '4' and PARM_NAME = rateType;
  RETURN loanRateType;
END;

DROP FUNCTION IF EXISTS converLoanType;
CREATE FUNCTION `converLoanType`(`loantype` VARCHAR(2)) RETURNS varchar(5) CHARSET utf8
BEGIN
  DECLARE type varchar(20);
  SELECT PARM_DESC INTO type from fspa_exg_m where PARM_TYPE = '3' and PARM_NAME = loantype;
  RETURN type;
END;

DROP FUNCTION IF EXISTS converOrgType;
CREATE FUNCTION `converOrgType`(orgtype VARCHAR(5)) RETURNS varchar(5) CHARSET utf8
BEGIN
  DECLARE type varchar(20);
  SELECT PARM_DESC INTO type from fspa_exg_m where PARM_TYPE IN ('6','60') and PARM_NAME = orgtype;
  RETURN type;
END;

DROP FUNCTION IF EXISTS converProductStatus;
CREATE FUNCTION `converProductStatus`(`loantype` VARCHAR(2)) RETURNS varchar(5) CHARSET utf8
BEGIN
	DECLARE status varchar(20);
	SELECT PARM_DESC INTO status from fspa_exg_m where PARM_TYPE = '10' and PARM_NAME = loantype;
	RETURN status;
END;

DROP FUNCTION IF EXISTS converProductType;
CREATE FUNCTION `converProductType`(`producttype` VARCHAR(30)) RETURNS varchar(30) CHARSET utf8
BEGIN
	DECLARE type varchar(30);
	SELECT PRODUCT_TYPE_DESC INTO type from FIPA_PRD_M WHERE PRODUCT_TYPE_ID = producttype;
	RETURN type;
END;