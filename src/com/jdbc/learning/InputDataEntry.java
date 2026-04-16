package com.jdbc.learning;

import com.jdbc.jdbcutil.JdbcUtil;
import java.sql.*;
import java.util.Scanner;

public class InputDataEntry {
    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;

        try{
            connection = JdbcUtil.getConnection();
            String sql = "INSERT INTO studentinfo(id, sname, sage, scity) VALUES(?,?,?,?)";
            preparedStatement = connection.prepareStatement(sql);

            System.out.println("Please enter the following details to be stored in DB");
            Scanner scan = new Scanner(System.in);

            System.out.println("Enter your id");
            Integer id = scan.nextInt();

            scan.nextLine();

            System.out.println("Enter your name");
            String name = scan.nextLine();

            System.out.println("Enter your age");
            Integer age = scan.nextInt();

            scan.nextLine();

            System.out.println("Enter your City");
            String city = scan.nextLine();

            preparedStatement.setInt(1,id);
            preparedStatement.setString(2, name);
            preparedStatement.setInt(3, age);
            preparedStatement.setString(4, city);


            int rowAffected = preparedStatement.executeUpdate();

            //process the result
            if(rowAffected == 0){
                System.out.println("Unable to insert data");
            }else{
                System.out.println("Data inserted successfully");
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
