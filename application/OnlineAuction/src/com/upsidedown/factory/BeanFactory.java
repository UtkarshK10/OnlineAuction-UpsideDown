package com.upsidedown.factory;
import java.sql.SQLException;

import com.upsidedown.dao.*;
import com.upsidedown.dao.impl.*;
import com.upsidedown.service.impl.*;
import com.uspidedown.service.ProductSchedulerService;
import com.uspidedown.service.ProductService;
import com.uspidedown.service.UserService;

public class BeanFactory {
	
	public ProductSchedulerDao createProductSchedulerDaoImplObj() {
		return new ProductSchedulerDaoImpl();
	}

	public ProductDao createProductDaoImplObj() {
		return new ProductDaoImpl();
	}

	public UserDao createUserDaoImplObj() throws ClassNotFoundException, SQLException {
		return new UserDaoImpl();
	}

	public ProductSchedulerService createProductSchedulerServiceImplObj() {
		return new ProductSchedulerServiceImpl();
	}

	public ProductService createProductServiceImplObj() {
		return new ProductServiceImpl();
	}

	public UserService createUserServiceImplObj() {
		return new UserServiceImpl();
	}

	
	
}
