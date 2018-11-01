package com.marke.sql;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * 类功能描述:MyBatis动态执行sql语句
 *
 * @author oscar.yu
 * @version 1.0.0
 * @className GenericQueryMapper.java
 * @history 2013年11月29日 oscar.yu 创建 GenericQueryMapper.java
 */
public interface GenericQueryMapper {

    /**
     * 带条件查询
     *
     * @param sql
     * @param params
     * @return
     */
    @Select("${sql}")
    List<Map<String, Object>> queryWithParams(@Param("sql") String sql, @Param("params") Object params);

    /**
     * 不带条件查询
     *
     * @param sql
     * @return
     */
    @Select("${sql}")
    List<Map<String, Object>> query(@Param("sql") String sql);
}