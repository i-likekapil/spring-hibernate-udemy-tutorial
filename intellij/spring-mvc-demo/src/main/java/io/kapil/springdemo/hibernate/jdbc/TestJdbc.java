package io.kapil.springdemo.hibernate.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Kapil Kaushik
 * @project spring-mvc-demo
 * @Date 28/07/23
 * @Time 5:43 pm
 */

public class TestJdbc {
    public static void main(String[] args) {


        try {
            String JDBC_URL = "jdbc:mysql://localhost:3306/hb-04-one-to-many-uni?useSSL=false&serverTimezone=UTC";
            String USER_NAME = "cavisson";
            String PASSWORD = "Kapil@1234";

            Connection con = DriverManager.getConnection(JDBC_URL, USER_NAME, PASSWORD);
            System.out.println("connection successful " + con);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
