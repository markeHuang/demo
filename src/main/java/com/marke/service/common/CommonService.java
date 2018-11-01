package com.marke.service.common;

import com.marke.config.SysConfiguration;
import com.marke.constant.GlobalConstants;
import com.marke.sql.QueryExecutor;
import com.marke.utils.StringUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 公共数据处理service
 *
 * @author jiangming.huang
 * @date 2018/11/1 0001 下午 1:57
 */
@Service
public class CommonService {

    /**
     * 序列的前缀
     */
    public final static String SEQUENCE_PFEFIX = "SEQUENCE_";

    @Resource
    private QueryExecutor queryExecutor;

    @Resource(type = SysConfiguration.class)
    private SysConfiguration sysConfiguration;

    /**
     * 根据SEQUENCE NAME 获取最大的流水号
     *
     * @param sequenceName SEQUENCE NAME
     * @return 当前最大流水号+1
     */
    public int getMaxRefcodeBySequenceName(String sequenceName) {
        StringBuffer sqlBuffer = new StringBuffer();
        // 连接的Mysql数据库 [v1.1]
        if (GlobalConstants.DbType.SYSTEM_DB_MYSQL.equals(sysConfiguration.getDbType())) {
            sqlBuffer.append(" CALL nextval('").append(sequenceName).append("') ");
        } else {// 连接的Oracle数据库
            sqlBuffer.append(" SELECT ").append(sequenceName).append(".NEXTVAL NEXT_VAL ");
            sqlBuffer.append(" FROM DUAL");
        }
        List<Map<String, Object>> list = queryExecutor.genericQuery(sqlBuffer.toString());
        int refcode = 0;
        if (CollectionUtils.isNotEmpty(list)) {
            // 修复根据key可能出现取值错误的问题,直接获取第一个值
            Object refcodeObject = list.get(0).values().iterator().next();
            if (refcodeObject != null) {
                refcode = Integer.parseInt(String.valueOf(refcodeObject));
            }
        }
        return refcode;
    }

    /**
     * 根据表名获取最大的流水号
     *
     * @param tableName 表名
     * @return 当前最大流水号+1
     */
    public int getMaxRefcodeByTableName(String tableName) {
        return getMaxRefcodeBySequenceName(SEQUENCE_PFEFIX + tableName.toUpperCase());
    }

    /**
     * 根据BO CLASS 获取最大的流水号
     *
     * @param boClass Table对应的BO Class
     * @return 当前最大流水号+1
     */
    public int getMaxRefcodeByBeanClass(Class<?> boClass) {
        return getMaxRefcodeByTableName(StringUtils.camelToUnderLine(boClass.getSimpleName()));
    }
}
