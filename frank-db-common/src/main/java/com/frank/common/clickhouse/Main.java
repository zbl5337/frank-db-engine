package com.frank.common.clickhouse;

import com.clickhouse.jdbc.ClickHouseDataSource;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Properties;

/**
 * @Author: zbl
 * @Date: Created in 2022/6/16
 * @Description:
 * @Version: $
 */
public class Main {

    public static void main(String[] args) throws Exception {

        String url = "jdbc:ch://8.136.133.137:8123";
        Properties properties = new Properties();
        // properties.setProperty("ssl", "true");
        // properties.setProperty("sslmode", "NONE"); // NONE to trust all servers; STRICT for trusted only

        ClickHouseDataSource dataSource = new ClickHouseDataSource(url, properties);
        try (Connection connection = dataSource.getConnection("default", null);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("select * from system.tables limit 10")) {
            ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
            int columns = resultSetMetaData.getColumnCount();
            while (resultSet.next()) {
                for (int c = 1; c <= columns; c++) {
                    System.out.print(resultSetMetaData.getColumnName(c) + ":" + resultSet.getString(c) + (c < columns ? ", " : "\n"));
                }
            }
        }
    }

}