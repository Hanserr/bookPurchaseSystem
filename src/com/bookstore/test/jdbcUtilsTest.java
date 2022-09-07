package com.bookstore.test;

import com.bookstore.utils.jdbcUtils;
import java.sql.SQLException;

public class jdbcUtilsTest {
    public static void main(String[] args) throws SQLException {
        System.out.println(jdbcUtils.getConnection());
    }
}
