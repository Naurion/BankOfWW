package com.nbox.bank;

import java.sql.ResultSet;

public interface AccountDAO {
	
	//Create new account
	public String addAccount(Account account);
	
	//Delete account by user id
	public void deleteAccount(String username);
	
	//Get account by user id
	public ResultSet getAccount(String username);
	
	//Change password
	public void changePassword(String username);
	
	//Create new bill for account
	public String addBill(String userId);
}
