package com.yuxin.platform.common.util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 获取指定数据库表名
 *
 * @Author: zxq
 * @Date: 2018/4/11 11:13
 */
public class DataBaseUtil {
    private static final String DATE_BASE = "seal";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "root";
    private static final String JDBC_URL = "jdbc:mysql://192.168.0.202:3306/" + DATE_BASE;
    private static final String CLASS_NAME = "com.mysql.jdbc.Driver";

    public static void main(String[] args) {
        DataBaseUtil.getTN();
    }

    public static List getTN() {
        Connection conn = null;
        try {
            Class.forName(CLASS_NAME);
            conn = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
        } catch (SQLException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        List tables = getAllTableNames(conn, DATE_BASE);
        return tables;
    }

    public static List getAllTableNames(Connection conn, String database) {
        List tableNames = new ArrayList();
        if (conn != null) {
            try {
                DatabaseMetaData dbmd = conn.getMetaData();
                // 表名列表
                ResultSet rest = dbmd.getTables(database, null, null, new String[]{"TABLE"});
                // 输出 table_name
                while (rest.next()) {
                    tableNames.add(rest.getString("TABLE_NAME"));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return tableNames;
    }

}
