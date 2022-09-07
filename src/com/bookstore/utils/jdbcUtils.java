package com.bookstore.utils;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class jdbcUtils {
    private static DruidDataSource dataSource;

    static{
        try {
            Properties properties = new Properties();
            //读取properties配置文件
            InputStream inputStream = jdbcUtils.class.getClassLoader().getResourceAsStream("jdbc.properties");
            //从流中加载数据
            properties.load(inputStream);
            dataSource = (DruidDataSource) DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取连接 如果返回null，则获取失败
    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        try {
        conn = dataSource.getConnection();
        }catch (Exception e){
            e.printStackTrace();
        }
        return conn;
    }
    //关闭连接
    public static void close(Connection conn){
    if (conn != null){
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }
}
