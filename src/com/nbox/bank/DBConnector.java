package com.nbox.bank;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnector {
	//Information for connecting to DB
	private String url = "jdbc:mysql://localhost:3306/minibank";
	private String user = "root";
	private String password = "root";
	
	//Variable to create connect and make query
	private Connection con;
    private Statement stmt;
    private ResultSet rs;
    private PreparedStatement prepstmt;
    
    //Variable for make query
    private String query;
    
    //variable for instance
    private static DBConnector dbcon;
    
    private DBConnector()  {
        try {
            // opening database connection to MySQL server
        	Class.forName("com.mysql.jdbc.Driver").newInstance();
            this.con = DriverManager.getConnection(url, user, password); 
            // getting Statement object to execute query
            this.stmt = con.createStatement();
 
 
//            while (rs.next()) {
//                int count = rs.getInt(1);
//                System.out.println("Total number of books in the table : " + count);
//            }
 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    
    public static DBConnector getInstance() {
    	if (dbcon!=null) {
    		return dbcon;
    	}else {
    		dbcon = new DBConnector();
    	}
    	return dbcon;
    }

	public void setQuery(String query) {
		this.query = query;
	}

	public ResultSet getRs() throws SQLException {
        // executing SELECT query
			this.rs = this.stmt.executeQuery(query);
		return this.rs;
	}

	public PreparedStatement getPrepstmt() throws SQLException {
		this.prepstmt = con.prepareStatement(query);
		return this.prepstmt;
	}
	
	public void makeQuery() throws SQLException {
		this.stmt.executeUpdate(query);
	}
	
	
    
}
