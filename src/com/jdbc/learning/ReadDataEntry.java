package com.jdbc.learning;

import com.jdbc.jdbcutil.JdbcUtil;

import java.sql.*;
import java.util.Scanner;

public class ReadDataEntry {
    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;

        try{
            connection = JdbcUtil.getConnection();
            String sql = "select * from studentinfo where id = ?";
            preparedStatement = connection.prepareStatement(sql);

            System.out.println("Please enter the id whose details you want to show");
            Scanner scan = new Scanner(System.in);
            Integer id = scan.nextInt();

            preparedStatement.setInt(1, id);


            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                System.out.println("Name: " + rs.getString(2));
                System.out.println("Age: " + rs.getInt(3));
                System.out.println("City: " + rs.getString(4));
            }

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                JdbcUtil.closeConnections(connection, statement, preparedStatement);
            } catch (SQLException e) {
                e.printStackTrace();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
