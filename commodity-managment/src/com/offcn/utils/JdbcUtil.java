package com.offcn.utils;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author qf_meng
 * @create 2021-03-30 11:14
 */
public class JdbcUtil {
   private static DataSource dataSource;
    static{
        try {
            dataSource = new ComboPooledDataSource();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //获取数据库连接的方法
    public static Connection getConnection() {
        //获取数据库连接
        Connection connection = null;
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    //关闭连接的方法
    public static void closeConnection(Connection connection) {
        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        System.out.println(JdbcUtil.getConnection());
    }


}
