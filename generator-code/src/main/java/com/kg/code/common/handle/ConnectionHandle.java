package com.kg.code.common.handle;

import com.kg.code.common.utils.PropertiesUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionHandle {
    /**
     * 数据库连接
     */
    private static Connection connection = null;

    // 连接数据库
    static {
        // 地址
        String localhost = PropertiesUtils.properties("mysql.localhost").toString();
        // 驱动
        String driver = PropertiesUtils.properties("mysql.driver").toString();
        // 用户名
        String username = PropertiesUtils.properties("mysql.username").toString();
        // 密码
        String password = PropertiesUtils.properties("mysql.password").toString();
        try {
            connection = DriverManager.getConnection(localhost, username, password);
            Class.forName(driver);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取连接
     *
     * @return 数据库连接
     */
    public static Connection getConnection() {
        return connection;
    }

    /**
     * 关闭连接
     */
    public static void close() {
        try {
            if (null != connection) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
