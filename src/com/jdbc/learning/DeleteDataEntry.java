package com.jdbc.learning;

import com.jdbc.jdbcutil.JdbcUtil;

import java.sql.*;
import java.util.Scanner;

public class DeleteDataEntry {
    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        PreparedStatement preparedStatement = null;

        try{
            connection = JdbcUtil.getConnection();
            String sql = "DELETE FROM studentinfo WHERE id = ?";
            preparedStatement = connection.prepareStatement(sql);

            System.out.println("Please enter the id whose details you want to delete");
            Scanner scan = new Scanner(System.in);
            Integer id = scan.nextInt();

            preparedStatement.setInt(1, id);


            int rowAffected = preparedStatement.executeUpdate();

            if(rowAffected == 0){
                System.out.println("Unable to delete data");
            }else{
                System.out.println("Data deleted successfully");
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
