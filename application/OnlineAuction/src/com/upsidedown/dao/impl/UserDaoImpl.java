package com.upsidedown.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import com.upsidedown.dao.UserDao;
import com.upsidedown.model.User;
import com.upsidedown.model.exception.UserAlreadyExistsException;
import com.upsidedown.model.exception.UserNotFoundException;

public class UserDaoImpl implements UserDao {
	
	Connection connection ;
	
	private String insertSQL="INSERT INTO auctionuser (name,dateOfBirth,email,phoneNumber,username,pass,address,userType,walletAmt) values(?,?,?,?,?,?,?,?,?)";
	private String findUserByUsernameSQL="SELECT * FROM auctionuser WHERE username=?";
	private String findUserSQL="SELECT * FROM auctionuser WHERE username=? AND pass=?";
	
	
	
	public UserDaoImpl(){
		System.out.println("in userdao");
		try {
			System.out.println("loading driver");
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		 try {
			 System.out.println("entering connection");
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/auctiondb?useSSL=false", "root", "utkarsh12345@");
		} catch (SQLException e) {
			e.printStackTrace();
		}

		            
		
	}

	@Override
	public boolean saveUser(User user) throws UserAlreadyExistsException {
		boolean flag=userExists(user.getUsername());
		if(!flag) {
			try(PreparedStatement ps = connection.prepareStatement(insertSQL)){
				ps.setString(1, user.getName());
				ps.setDate(2,  java.sql.Date.valueOf(user.getDateOfBirth()));
				ps.setString(3, user.getEmail());
				System.out.println(user.getPhoneNumber());
				ps.setString(4, user.getPhoneNumber());
				ps.setString(5, user.getUsername());
				ps.setString(6, user.getPassword());
				ps.setString(7, user.getAddress());
				ps.setInt(8, user.getUserType());
				ps.setDouble(9, user.getWalletAmt());
				int numOfRowsUpdated=ps.executeUpdate();
				if(numOfRowsUpdated==1) return true;
				else return false;
			}catch(SQLException e) {
				e.printStackTrace();
				return false;
			}
		}else {
			throw new UserAlreadyExistsException();
		}
		
	}

	@Override
	public User getUser(String username, String pass)  {
		ResultSet rs=null;
		User u=new User();
		try(PreparedStatement ps = connection.prepareStatement(findUserSQL)){
			System.out.println(findUserSQL);
			ps.setString(1, username);
			ps.setString(2, pass);
			rs=ps.executeQuery();
			while(rs.next()) {
				System.out.println("enter");
				u.setUserId(rs.getInt("userId"));
				u.setName(rs.getString("name"));
				u.setDateOfBirth(rs.getDate("dateOfBirth").toLocalDate());
				u.setEmail(rs.getString("email"));
				u.setPhoneNumber(rs.getString("phoneNumber"));
				u.setUsername(rs.getString("username"));
				u.setPassword(rs.getString("pass"));
				u.setAddress(rs.getString("address"));
				u.setUserType(rs.getInt("userType"));
				u.setWalletAmt(rs.getDouble("walletAmt"));
				System.out.println(u);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public boolean userExists(String username) {
		ResultSet rs = null;
		User u = new User();
		try(PreparedStatement ps = connection.prepareStatement(findUserByUsernameSQL)){
			ps.setString(1, username);
			rs=ps.executeQuery();
			while(rs.next()) {
				u.setUserId(rs.getInt("userId"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		if(u.getUserId()!=0) {
			return true;
		}
		return false;
	}

}
