package com.upsidedown.controller;

import java.io.IOException;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.upsidedown.factory.BeanFactory;
import com.upsidedown.model.ProductForAuction;
import com.upsidedown.model.User;
import com.uspidedown.service.ProductService;


@WebServlet("/home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public HomeController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User userInSession = (User)session.getAttribute("user");
		if(userInSession==null) {
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		else {
			if(userInSession.getUserType() == 0) {
				// in buyers account
				request.getRequestDispatcher("/error/accessdenied.jsp").forward(request, response);
			}
			else if(userInSession.getUserType()==1) {
				// in sellers account
				int uid=userInSession.getUserId();
				BeanFactory beanFactory = new BeanFactory();
				ProductService productService = beanFactory.createProductServiceImplObj();
				List<ProductForAuction> getAllProducts=productService.getSellerProducts(uid);
				for(ProductForAuction t : getAllProducts ) {
					System.out.println(t);
				}
				
				request.setAttribute("products",getAllProducts);
				request.getRequestDispatcher("/seller/sellerHistory.jsp").forward(request, response);
			}
			else {
				System.out.println("something error from loginservlet");
			}
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
