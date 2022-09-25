package com.upsidedown.service.impl;

import java.util.List;

import com.upsidedown.dao.ProductDao;
import com.upsidedown.dao.ProductSchedulerDao;
import com.upsidedown.factory.BeanFactory;
import com.upsidedown.model.Product;
import com.upsidedown.model.ProductForAuction;
import com.uspidedown.service.ProductSchedulerService;

public class ProductSchedulerServiceImpl implements ProductSchedulerService {

	BeanFactory beanFactory = new BeanFactory();
	ProductSchedulerDao productSchedulerDao= beanFactory.createProductSchedulerDaoImplObj();
	@Override
	public boolean scheduleAuction(ProductForAuction productAuction) {
		return productSchedulerDao.scheduleAuction(productAuction);
	}

	@Override
	public List<Product> getProductList(int sellerId) {
		return productSchedulerDao.getProductList(sellerId);
	}

}
