package com.upsidedown.dao;
import java.util.*;
import com.upsidedown.model.ProductForAuction;
import com.upsidedown.model.Product;
import com.upsidedown.model.Category;
import com.upsidedown.model.Bid;

public interface ProductDao {
	public boolean addProducts(Product product);
	public boolean placeBid(Bid bid);
	public void scheduleTask();
	public List<ProductForAuction> getBidProducts();
	public List<ProductForAuction> getProductHistory(int user_id);
	public List<ProductForAuction> getSellerProducts(int user_id);
	public List<Category> getCategoryList();
}
