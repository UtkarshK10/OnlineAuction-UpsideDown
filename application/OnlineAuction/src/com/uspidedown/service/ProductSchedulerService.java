package com.uspidedown.service;

import java.util.List;

import com.upsidedown.model.Product;
import com.upsidedown.model.ProductForAuction;

public interface ProductSchedulerService {
	public boolean scheduleAuction(ProductForAuction productAuction);
	public List<Product> getProductList(int sellerId);
}
