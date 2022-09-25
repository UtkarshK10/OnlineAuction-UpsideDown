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


@WebServlet("/sold")
public class SellerHistoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public SellerHistoryController() {
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
				response.sendRedirect("home");
				request.getRequestDispatcher("/error/forbiddenAccessError.jsp").forward(request, response);
			}
			else if(userInSession.getUserType()==1) {
				System.out.println("In Seller:"+(User)session.getAttribute("user"));
				int uid=userInSession.getUserId();
				BeanFactory beanFactory = new BeanFactory();
				ProductService productService = beanFactory.createProductServiceImplObj();
				List<ProductForAuction> sellerPdts=productService.getSellerProducts(uid);
				request.setAttribute("products",sellerPdts);
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			}
			else {
				System.out.println("Error!! Something Went Wrong");
			}
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
