package com.jdbc.learning;

import com.jdbc.jdbcutil.JdbcUtil;
import java.sql.*;
import java.util.Scanner;

public class UpdateDataEntry {
    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;

        try{
            connection = JdbcUtil.getConnection();
            String sql = " UPDATE studentinfo set sage = ? where id = ?";
            preparedStatement = connection.prepareStatement(sql);

            System.out.println("Please enter the following details to update in DB");
            Scanner scan = new Scanner(System.in);

            System.out.println("Enter your age");
            Integer age = scan.nextInt();

            System.out.println("Enter your id");
            Integer id = scan.nextInt();

            preparedStatement.setInt(1,age);
            preparedStatement.setInt(2, id);


            int rowAffected = preparedStatement.executeUpdate();

            //process the result
            if(rowAffected == 0){
                System.out.println("Unable to update data");
            }else{
                System.out.println("Data updated successfully");
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
