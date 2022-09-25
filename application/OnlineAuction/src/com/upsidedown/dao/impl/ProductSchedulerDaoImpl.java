package com.upsidedown.dao.impl;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.upsidedown.dao.ProductSchedulerDao;
import com.upsidedown.model.Product;
import com.upsidedown.model.ProductForAuction;

public class ProductSchedulerDaoImpl implements ProductSchedulerDao {
	
	
	Connection connection;
	String scheduleAuction="insert into ProductBid(MinBidValue,BidStartDate,BidEndDate,ProductID,Status) values(?,?,?,?,?)";
	String getPdts="select ProductID,ProductName from Product where SellerID=?";
	String bidscheduled="select * from ProductBid where ProductID=?";
	public ProductSchedulerDaoImpl(){

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		try {
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/auctiondb?useSSL=false", "root", "utkarsh12345@");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	
	
	@Override
	public boolean scheduleAuction(ProductForAuction productAuction) {
    boolean status=false;
		
		PreparedStatement ps,ps1;
		ResultSet resultset;
		int productId = 0;
		if(checkIfBidScheduled(productAuction.getProductId())) {
			status=false;
			return status;
		}
		else {
			try {
				ps = connection.prepareStatement(scheduleAuction);
	
				LocalDate startDate = productAuction.getBidStartDate();
				LocalDate endDate = productAuction.getBidEndDate();
				LocalDateTime startDateTime = LocalDateTime.of(startDate.getYear(), startDate.getMonth(), startDate.getDayOfMonth(), LocalDateTime.now().getHour(), LocalDateTime.now().getMinute());
				LocalDateTime endDateTime = LocalDateTime.of(endDate.getYear(), endDate.getMonth(), endDate.getDayOfMonth(), 19, 0);
				ps.setDouble(1,productAuction.getMinBidValue());		
				ps.setInt(4,productAuction.getProductId());
				ps.setInt(5,productAuction.getBidStatus());
				int numOfRows = ps.executeUpdate();
				status=numOfRows==1?true:false;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	
		return status;
	}

	@Override
	public boolean checkIfBidScheduled(int productId) {

		PreparedStatement ps = null;
		ResultSet resultset;
		try {
			ps = connection.prepareStatement(bidscheduled);

			ps.setInt(1,productId);
			resultset = ps.executeQuery();
			while (resultset.next())
			{
                String productName = resultset.getString(2);
                return true;
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Product id NOT EXIST:"+productId);
		return false;
	}

	@Override
	public List<Product> getProductList(int sellerId) {
		List<Product> productList = new ArrayList<Product>();
		PreparedStatement ps;
		ResultSet resultset;

		try
		{
			ps = connection.prepareStatement(getPdts);
			ps.setInt(1,sellerId);
			resultset = ps.executeQuery();
			while (resultset.next())
			{
				int productId = resultset.getInt(1);
                String productName = resultset.getString(2);
                Product product = new Product(productId, productName);
  
                productList.add(product);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return productList;
	}

}
