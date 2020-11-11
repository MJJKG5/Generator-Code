package com.kg.code;

import com.kg.code.common.handle.ConnectionHandle;
import org.junit.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TestConnectionHandle {
    @Test
    public void getConnection() {
        String sql = "SELECT * FROM sys_user";
        Connection connection = ConnectionHandle.getConnection();
        try {
            Statement statement = connection.createStatement();
            boolean isSuccess = statement.execute(sql);
            System.out.println(isSuccess);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionHandle.close();
        }
    }
}
