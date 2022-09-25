package com.upsidedown.dao;

import java.util.*;
import com.upsidedown.model.ProductForAuction;
import com.upsidedown.model.Product;
public interface ProductSchedulerDao {
	public boolean scheduleAuction(ProductForAuction productAuction);
	boolean checkIfBidScheduled(int productId);
	public List<Product> getProductList(int sellerId);
	
}
