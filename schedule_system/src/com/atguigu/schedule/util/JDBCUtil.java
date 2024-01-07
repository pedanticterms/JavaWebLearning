package com.atguigu.schedule.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

public class JDBCUtil {

    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    private static DataSource dataSource;

    // 初始化连接池
    static {
        // 帮助读取 .properties 配置文件
        Properties properties = new Properties();
        // !!! 切记 jdbc.properties 不能加 resources/
        InputStream resourceAsStream = JDBCUtil.class.getClassLoader()
                .getResourceAsStream("jdbc.properties");
        try {
            properties.load(resourceAsStream);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    // 向外提供连接池的方法
    public static DataSource getDataSource() {
        return dataSource;
    }

    // 向外提供连接的方法
    public static Connection getConnection() {
        Connection connection = threadLocal.get();
        if (null == connection) {
            try {
                connection = dataSource.getConnection();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            threadLocal.set(connection);
        }

        return connection;
    }

    // 定义一个归还连接的方法
    public static void releaseConnection() {
        Connection connection = threadLocal.get();
        if (null != connection) {
            threadLocal.remove();
            // 把连接设置会自动提交的连接
            try {
                connection.setAutoCommit(true);
                // 自动归还到连接池
                connection.close();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
