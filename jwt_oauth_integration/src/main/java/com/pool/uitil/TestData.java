package com.pool.uitil;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestData {
	   

	    public static void getData(String URL,String USERNAME,String PASSWORD ) {
	        try (Connection connection =
	                 DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
	            DatabaseMetaData metadata = connection.getMetaData();
	            ResultSet resultSet = metadata.getColumns(null, null, "users", null);
	            while (resultSet.next()) {
	                String name = resultSet.getString("COLUMN_NAME");
	                System.out.println(name);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	
}
