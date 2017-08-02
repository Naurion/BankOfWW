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
			addBill(userId);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userId;
	}

	@Override
	public void deleteAccount(String username) {
		DBConnector con = DBConnector.getInstance();
		con.setQuery("DELETE FROM accounts WHERE username ='"+username+"';");
		try {
			con.makeQuery();
		} catch (SQLException e) {
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
			e.printStackTrace();
		}
		return res;
	}
	
	@Override
	public void changePassword(String username) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String addBill(String userId) {
		Bill bill = new Bill(userId);
		String billId = generateBillId();
		bill.setBillId(billId);
		try {
			con.setQuery("INSERT INTO bills (`billId`, `userId`, `cash`) VALUES (?, ?, ?);");
			prepstmt = con.getPrepstmt();
			prepstmt.setString(1, bill.getBillId());
			prepstmt.setString(2, bill.getUserId());
			prepstmt.setDouble(3, bill.getCash());
			prepstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return billId;
	}

	
	
	//Methods for generating user id and bill id
	private String generateUserId() {
		Calendar data = Calendar.getInstance();
		String id = "" + Math.round(Math.random()*1000 + data.getTimeInMillis());
		return id;
	}
	
	private String generateBillId() {
		Calendar data = Calendar.getInstance();
		String id = "" + data.get(Calendar.YEAR)+ "" + data.get(Calendar.MONTH) + "" + data.get(Calendar.DAY_OF_MONTH) + "" +data.getTimeInMillis();
		return id;
		
	}

}
