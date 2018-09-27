DROP PROCEDURE IF EXISTS currval;
CREATE PROCEDURE currval (in seq_name VARCHAR(50))
         COMMENT '获取指定序列当前取值'
BEGIN
         DECLARE VALUE decimal(10);
         DECLARE tmpname varchar(50);
         SET VALUE = 1;
         SELECT CURRENT_VALUE,name INTO VALUE,tmpname
                   FROM FSPA_SEQ_M
                   WHERE name = seq_name;
         if isnull(tmpname) then
            insert into FSPA_SEQ_M values(seq_name,1);
         end if;
         SELECT VALUE;
END;

DROP PROCEDURE IF EXISTS nextval;
CREATE PROCEDURE nextval (in seq_name varchar(50))
    COMMENT '获取指定序列下一取值'
BEGIN
    DECLARE CUR_VAL decimal(10);
	DECLARE NEXT_VAL decimal(10);
    SELECT CURRENT_VALUE INTO CUR_VAL
    FROM FSPA_SEQ_M
    WHERE NAME = seq_name;

	SET NEXT_VAL = CUR_VAL + 1;
 
    UPDATE FSPA_SEQ_M SET CURRENT_VALUE = NEXT_VAL
    WHERE NAME = seq_name;
    SELECT NEXT_VAL;
END;
