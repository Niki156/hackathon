package com.epam.framework.utils;

import com.epam.framework.exceptions.DataBaseException;

import java.sql.*;
import java.util.Properties;


public class DataBaseUtility {
    Properties credentials = PropertyFileReader.getPropLoader("give your filepath");
    static Statement statement=null;
    public  Connection getDatabaseConnection() {
      Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://EPINHYDW0087:3306/programs", "qa", credentials.getProperty("dbPassword"));
        } catch (Exception e){
            throw new DataBaseException("data base connection error"+ e.getMessage());
        }
        return connection;
    }

    public static ResultSet executeProvidedQuery(String query, String value) {
        ResultSet resultSet = null;
        new DataBaseUtility().setDriver();
        Connection connection = new DataBaseUtility().getDatabaseConnection();
        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(getQuery(query,value));
        } catch (Exception e) {
            throw new DataBaseException("database  query exception : "+e.getMessage());
        }
        return resultSet;
    }


    private static String getQuery(String query,String value){
        return query + "'" + value + "'";
    }
    private  void setDriver(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new DataBaseException("driver not found"+e.getMessage());
        }
    }

}

