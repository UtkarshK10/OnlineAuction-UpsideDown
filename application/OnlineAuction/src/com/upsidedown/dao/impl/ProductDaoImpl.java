package com.upsidedown.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.upsidedown.dao.ProductDao;
import com.upsidedown.model.Bid;
import com.upsidedown.model.Bid.status;
import com.upsidedown.model.Category;
import com.upsidedown.model.Product;
import com.upsidedown.model.ProductForAuction;

public class ProductDaoImpl implements ProductDao {
	
	Connection connection ;
	String getBidPdts = "Select Product.ProductID,Productbid.MinBidValue,ProductBid.BidStartDate,ProductBid.BidEndDate,Product.ProductName,Product.ProductCategory,Product.ProductDesc,Product.ActualPrice,Product.Quantity,Product.Image,ProductBid.Status From ProductBid inner join Product on ProductBid.ProductID=Product.ProductID";
	String getPdtHistory = "select prod_bid.BidEndDate,prod.ProductName,prod.Image,prod_bid.SoldPrice, prod_bid.Status From ProductBid prod_bid inner join Product prod on prod_bid.ProductID=prod.ProductID where prod_bid.BuyerID=?";
	String getSellerPdts = "select * From ProductBid prod_bid inner join Product prod on prod_bid.ProductID=prod.ProductID where prod_bid.BuyerID=?";
	String insert = "insert into Product (ProductID,ProductName,ProductCategory,ProductDesc,ActualPrice,Quantity,Image,SellerID) values(next value for product_sequence,?,?,?,?,?,?,?)";
	String getCategory="select CategoryID,CategoryName from Category";
	public ProductDaoImpl(){
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
	public List<ProductForAuction> getBidProducts() {
		
		List<ProductForAuction> prodList = new ArrayList<ProductForAuction>();
		ResultSet rs = null;
		Product pa = new Product();
		try {

			
			PreparedStatement ps = connection.prepareStatement(getBidPdts);
			rs = ps.executeQuery();
			while (rs.next()) {
				int pid = rs.getInt("productID");
				int minBid = rs.getInt("minBidValue");
				LocalDate sDate = rs.getTimestamp("bidStartDate").toLocalDateTime().toLocalDate();
				LocalDate eDate = rs.getTimestamp("bidEndDate").toLocalDateTime().toLocalDate();
				String pName = rs.getString("productName");
				String pCat = rs.getString("productCategory");
				String pDesc = rs.getString("productDesc");
				double price = rs.getDouble("actualPrice");
				int pQuan = rs.getInt("quantity");
				String img = rs.getString("image");
				double sPrice = minBid;

				String DEFAULT_FILENAME = "./resources/img/logo.jpg";
				if (img.compareTo(DEFAULT_FILENAME) != 0) {
					img = "/media/" + img;
				}
	

				int stat = rs.getInt("Status");
				status cond = status.valueOf(stat);

			}
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}

		return prodList;
	}

	@Override
	public List<ProductForAuction> getProductHistory(int user_id) {
		
		List<ProductForAuction> prodList = new ArrayList<ProductForAuction>();
		ResultSet rs = null;
		Product pa = new Product();
		try {
		
			PreparedStatement ps = connection.prepareStatement(getPdtHistory);
			ps.setInt(1, user_id);
			rs = ps.executeQuery();
			while (rs.next()) {
				LocalDate eDate = rs.getTimestamp("bidEndDate").toLocalDateTime().toLocalDate();
				LocalDate sDate = rs.getTimestamp("bidStartDate").toLocalDateTime().toLocalDate();
				String pName = rs.getString("productName");
				String img = rs.getString("image");
				double sPrice = rs.getInt("soldPrice");


				int stat = rs.getInt("Status");
				status cond = status.valueOf("stat");


			}
		} catch (SQLException e) {
			 
			e.printStackTrace();
		}

		return prodList;
	}

	

	@Override
	public List<ProductForAuction> getSellerProducts(int user_id) {

		List<ProductForAuction> prodList = new ArrayList<ProductForAuction>();

		ResultSet rs = null;
		Product pa = new Product();

		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(getSellerPdts);
			ps.setInt(1, user_id);
			rs = ps.executeQuery();
			while (rs.next()) {
				LocalDate eDate = rs.getTimestamp("bidEndDate").toLocalDateTime().toLocalDate();
				LocalDate sDate = rs.getTimestamp("bidStartDate").toLocalDateTime().toLocalDate();
				String pName = rs.getString("productName");
				String img = rs.getString("image");
				double sPrice = rs.getInt("soldPrice");


				int stat = rs.getInt("Status");
				status cond = status.valueOf(stat);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return prodList;
	}

	@Override
	public boolean addProducts(Product product) {
	    boolean status = false;
		try {
			PreparedStatement ps = connection.prepareStatement(insert);
			ps.setString(1, product.getProductName());
			ps.setString(2, product.getProductCategory());

			System.out.println(product.getProductDescription());

			ps.setString(3, product.getProductDescription());
			ps.setDouble(4, product.getProductPrice());
			ps.setInt(5, product.getProductQuantity());
			ps.setString(6, product.getProductimage());
			ps.setInt(7, product.getSellerId());

			int rowsUpdated=ps.executeUpdate();
			status=rowsUpdated==0?false:true;
			return status;
		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return status;

	}

	@Override
	public List<Category> getCategoryList() {
		
		List<Category> categoryList = new ArrayList<Category>();

		ResultSet rs = null;
		PreparedStatement ps;
		try {
			ps = connection.prepareStatement(getCategory);
			rs = ps.executeQuery();
			while (rs.next()) {
				int categoryID = rs.getInt(1);
				String categoryName = rs.getString(2);

				Category category = new Category(categoryID, categoryName);

				categoryList.add(category);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return categoryList;
	}

	@Override
	public void scheduleTask() {
		
		
	}

	@Override
	public boolean placeBid(Bid bid) {
		
		return false;
	}

}
