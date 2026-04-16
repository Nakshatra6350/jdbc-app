package com.jdbc.learning;

import java.sql.*;

public class Launch {
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

            //execute query insert
            String sql = "INSERT INTO studentinfo(id, sname, sage, scity) VALUES(2, 'SK', 23, 'KOTA')";
            int rowAffected = statement.executeUpdate(sql);

            //process the result
            if(rowAffected == 0){
                System.out.println("Unable to insert data");
            }else{
                System.out.println("Data inserted successfully");
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
