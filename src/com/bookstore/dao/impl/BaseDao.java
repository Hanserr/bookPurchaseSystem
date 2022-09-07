package com.bookstore.dao.impl;

import com.bookstore.utils.jdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public abstract class BaseDao {
    //返回受影响的行数
    //如果返回-1则执行失败
    QueryRunner queryRunner = new QueryRunner();
    public int update(String sql, Object... args) {
            Connection conn = null;
        try {
            conn = jdbcUtils.getConnection();
            return queryRunner.update(conn, sql, args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbcUtils.close(conn);
        }
        return -1;
    }

    //查询返回一个javaBean的sql语句
    public <T> T queryForOne(Class<T> type, String sql, Object... args){
        Connection conn = null;
        try {
            conn = jdbcUtils.getConnection();
            return queryRunner.query(conn, sql, new BeanHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbcUtils.close(conn);
        }
        return null;
    }

    //查询返回多个javaBean的sql语句
    public <T> List <T> queryForList(Class<T> type, String sql, Object... args){
        Connection conn = null;
        try {
            conn = jdbcUtils.getConnection();
            return queryRunner.query(conn, sql, new BeanListHandler<T>(type), args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbcUtils.close(conn);
        }
        return null;
    }

    //查询单行单列的值
    public Object queryForSingleValue(String sql,Object...args){
        Connection conn = null;
        try {
            conn = jdbcUtils.getConnection();
            return queryRunner.query(conn,sql,new ScalarHandler(),args);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            jdbcUtils.close(conn);
        }
        return null;
    }

}



