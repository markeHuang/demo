package com.marke.sql;

import com.marke.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * MyBatis 查询工具类
 *
 * @author marke.huang
 * @date 2018/11/17 14:03
 */
@Service
@Slf4j
public class QueryExecutor {

    @Autowired
    private SqlSessionFactory sessionFactory;

    /**
     * 根据MyBatis Mapper id获得查询结果
     *
     * @param mapperId
     * @return
     */
    public <T> List<T> selectList(String mapperId) {
        SqlSession sqlSession = sessionFactory.openSession();
        try {
            return sqlSession.selectList(mapperId);
        } catch (Exception e) {
            log.error("执行SQL查询时发生错误.MapperId == " + mapperId, e);
        } finally {
            sqlSession.close();
        }
        return null;
    }

    /**
     * 根据MyBatis Mapper id和参数获得查询结果
     *
     * @param mapperId
     * @param params
     * @return
     */
    public <T> List<T> selectList(String mapperId, Object params) {
        SqlSession sqlSession = sessionFactory.openSession();
        try {
            return sqlSession.selectList(mapperId, params);
        } catch (Exception e) {
            log.error("执行SQL查询时发生错误.MapperId == " + mapperId, e);
        } finally {
            sqlSession.close();
        }
        return null;
    }

    /**
     * 根据MyBatis Mapper id获得查询结果
     *
     * @param mapperId
     * @param offset   从第几行开始取数据
     * @param limit    返回的记录数
     * @return
     */
    public List<?> selectList(String mapperId, int offset, int limit) {
        SqlSession sqlSession = sessionFactory.openSession();
        try {
            return sqlSession.selectList(mapperId, new RowBounds(offset, limit));
        } catch (Exception e) {
            log.error("执行SQL查询时发生错误.MapperId == " + mapperId, e);
        } finally {
            sqlSession.close();
        }
        return null;
    }

    /**
     * @param mapperId
     * @param params
     * @param offset
     * @param limit
     * @return
     */
    public List<?> selectList(String mapperId, Object params, int offset, int limit) {
        SqlSession sqlSession = sessionFactory.openSession();
        try {
            return sqlSession.selectList(mapperId, params, new RowBounds(offset, limit));
        } catch (Exception e) {
            log.error("执行SQL查询时发生错误.MapperId == " + mapperId, e);
        } finally {
            sqlSession.close();
        }
        return null;
    }

    /**
     * 执行 Raw SQL
     *
     * @param sql
     * @return
     */
    public List<Map<String, Object>> genericQuery(String sql) {
        if (StringUtils.isEmpty(sql) || !(sql.toLowerCase().trim().startsWith("select") || sql.toLowerCase().trim().startsWith("call"))) {
            return null;
        }
        SqlSession sqlSession = sessionFactory.openSession();
        try {
            GenericQueryMapper query = sqlSession.getMapper(GenericQueryMapper.class);
            return query.query(sql);
        } catch (Exception e) {
            log.error("执行SQL查询时发生错误.sql == " + sql, e);
        } finally {
            sqlSession.close();
        }
        return null;
    }

    /**
     * 执行 SQL， SQL 参数的格式参照 MyBatis, 即用 #{param_name}
     *
     * @param sql
     * @param params
     * @return
     */
    public List<Map<String, Object>> genericQuery(String sql, Object params) {
        if (StringUtils.isEmpty(sql) || !(sql.toLowerCase().trim().startsWith("select") || sql.toLowerCase().trim().startsWith("call"))) {
            return null;
        }
        SqlSession sqlSession = sessionFactory.openSession();
        try {
            GenericQueryMapper query = sqlSession.getMapper(GenericQueryMapper.class);
            return query.queryWithParams(sql, params);
        } catch (Exception e) {
            log.error("执行SQL查询时发生错误.sql == " + sql, e);
        } finally {
            sqlSession.close();
        }
        return null;
    }
}
