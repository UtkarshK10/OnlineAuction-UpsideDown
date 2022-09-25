package com.upsidedown.service.impl;

import java.util.List;

import com.upsidedown.dao.ProductDao;
import com.upsidedown.factory.BeanFactory;
import com.upsidedown.model.Bid;
import com.upsidedown.model.Category;
import com.upsidedown.model.Product;
import com.upsidedown.model.ProductForAuction;
import com.uspidedown.service.ProductService;

public class ProductServiceImpl implements ProductService {
	
	BeanFactory beanFactory = new BeanFactory();
	ProductDao productDao = beanFactory.createProductDaoImplObj();

	@Override
	public boolean addProducts(Product product) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean placeBid(Bid bid) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void scheduleTask() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProductForAuction> getBidProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductForAuction> getProductHistory(int user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProductForAuction> getSellerProducts(int user_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> getCategoryList() {
		// TODO Auto-generated method stub
		return null;
	}

}
