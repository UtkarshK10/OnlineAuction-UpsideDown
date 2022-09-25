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
import com.upsidedown.model.User;
import com.uspidedown.service.ProductService;
import com.upsidedown.model.ProductForAuction;


@WebServlet("/BuyerHistoryController")
public class BuyerHistoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BuyerHistoryController() {
        super();
       
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User userInSession = (User)session.getAttribute("user");
		if(userInSession==null)
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		else {
			if(userInSession.getUserType() == 1) {
				// into sellers account
				response.sendRedirect("sellerhistory");
			}
			else if(userInSession.getUserType()==0) {
				System.out.println("In buyer:"+(User)session.getAttribute("user"));
				int uid=userInSession.getUserId();
				BeanFactory beanFactory = new BeanFactory();
				ProductService productService = beanFactory.createProductServiceImplObj();
				List<ProductForAuction> buyerPdts=productService.getProductHistory(uid);
				request.setAttribute("products", buyerPdts);
				request.getRequestDispatcher("/buyer/buyerHistory.jsp").forward(request, response);

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
