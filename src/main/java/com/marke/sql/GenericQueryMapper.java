package com.marke.sql;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

/**
 * MyBatis动态执行sql语句
 *
 * @author marke.huang
 * @date 2018/11/17 14:03
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