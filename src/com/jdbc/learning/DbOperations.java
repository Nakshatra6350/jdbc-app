package com.jdbc.learning;

import java.sql.*;

public class DbOperations {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        try {
            //load and register driver, during this class loading the static block of this class gets executed automatically
            Class.forName("com.mysql.cj.jdbc.Driver"); //this means load the given class
            //DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver()); // another way

            //establish connection
            String url = "jdbc:mysql://127.0.0.1:3306/jdbclearning";
            String user = "root";
            String password = "root";
            Connection connection = DriverManager.getConnection(url, user, password);

            // create statement
            Statement statement = connection.createStatement();

            //execute query update
//            String sql = "UPDATE studentinfo set sname = 'Shubhiksha' where id = 2";
//            int rowAffected = statement.executeUpdate(sql);

            //execute query read
//            String sql = "SELECT * FROM studentinfo";
//            ResultSet resultSet = statement.executeQuery(sql);

            //execute query delete
            String sql = "DELETE FROM studentinfo where id = 1";
            int rowAffected = statement.executeUpdate(sql);


            //process the result
//            if(rowAffected == 0){
//                System.out.println("Unable to update data");
//            }else{
//                System.out.println("Data updated successfully");
//            }

//            while (resultSet.next()){
//                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2));
//            }

            if(rowAffected == 0){
                System.out.println("Unable to delete data");
            }else{
                System.out.println("Data deleted successfully");
            }

            //close the resources/connection
            statement.close();
            connection.close();

        }catch (ClassNotFoundException e) {
            System.out.println("Class not found to load!" + e.getMessage());
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("SQL exception!" + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("Exception occurs!" + e.getMessage());
            e.printStackTrace();
        } finally {
            System.out.println("finally block");
        }


    }
}
