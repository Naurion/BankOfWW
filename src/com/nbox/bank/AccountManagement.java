package com.nbox.bank;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

public class AccountManagement implements AccountDAO {
	
	//Variable for make query to DB
	private PreparedStatement prepstmt;
	private DBConnector con = DBConnector.getInstance();
	
	@Override
	public String addAccount(Account account) { //Added account in database
		String userId = generateUserId();
		account.setUserId(userId);
		
		try {
			con.setQuery("INSERT INTO accounts (`userId`, `username`, `password`) VALUES (?, ?, ?);");
			prepstmt = con.getPrepstmt();
			prepstmt.setString(1, account.getUserId());
			prepstmt.setString(2, account.getUsername());
			prepstmt.setString(3, account.getPassword());
			prepstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteAccount(String username) {
		DBConnector con = DBConnector.getInstance();
		con.setQuery("DELETE FROM accounts WHERE username ='"+username+"';");
		try {
			con.makeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

	@Override
	public ResultSet getAccount(String username) {
		ResultSet res = null;
		con.setQuery("SELECT * FROM minibank.accounts WHERE username='"+username+"';");
		try {
			res = con.getRs();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	
	//Method for generating user id
	private String generateUserId() {
		Calendar data = Calendar.getInstance();
		String id = "" + Math.round(Math.random()*1000 + data.getTimeInMillis());
		return id;
	}
}
