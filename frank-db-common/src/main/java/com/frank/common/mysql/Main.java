package com.frank.common.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @Author: zbl
 * @Date: Created in 2022/6/15
 * @Description:
 * @Version: $
 */
public class Main {

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection conn = DriverManager.getConnection("jdbc:mysql://8.136.133.137:3306/capaa", "root", "zbl5337");
        PreparedStatement pstmt = conn.prepareStatement("select distinct `PRIV_NAME`,`PRIV_DESC` from mc$priv_database where DB_TYPE = 13");
        ResultSet resultSet = pstmt.executeQuery();

        System.out.println("INSERT INTO `mc$priv_database` (`PRIV_NAME`, `PRIV_DESC`, `DB_TYPE`) VALUES");
        while (resultSet.next()) {
            String privName = resultSet.getString("PRIV_NAME");
            String privDesc = resultSet.getString("PRIV_DESC");
            System.out.println("('" + privName + "','" + privDesc + "'," + 30 + "),");
        }


        System.out.println("SCHEMA");
        resultSet = pstmt.executeQuery("SHOW DATABASES WHERE `DATABASE` NOT IN ('INFORMATION_SCHEMA','PERFORMANCE_SCHEMA','MYSQL','SYS');");
        while (resultSet.next()) {
            System.out.println(resultSet.getString("DATABASE"));
        }


        conn.close();

    }


}
