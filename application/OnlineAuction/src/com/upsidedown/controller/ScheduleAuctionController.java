package com.upsidedown.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.upsidedown.factory.BeanFactory;
import com.upsidedown.model.User;
import com.uspidedown.service.ProductSchedulerService;
import java.util.*;
import com.upsidedown.model.Product;
import com.upsidedown.model.ProductForAuction;

@WebServlet("/schedule")
public class ScheduleAuctionController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ScheduleAuctionController() {
        super();
     
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		User userInSession = (User)session.getAttribute("user");
		if(userInSession==null)
		{
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		else 
		{
			if(userInSession.getUserType() == 0) 
			{
				// in buyers account
				response.sendRedirect("home");

			}
			else if(userInSession.getUserType()==1) {
				// in sellers account
				int sellerId=userInSession.getUserId();
				
				BeanFactory beanFactory = new BeanFactory();
				ProductSchedulerService productSchedule = beanFactory.createProductSchedulerServiceImplObj(); 
				List<Product> productList=productSchedule.getProductList(sellerId);
				request.setAttribute("productList", productList);
				response.setStatus(200);
			}
			else {
				System.out.println("Error");
				response.setStatus(999);
			}
		}
		request.getRequestDispatcher("/seller/scheduleAuction.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd"); 
		int productId=Integer.parseInt(request.getParameter("products"));
		double minimumBidValue=Double.parseDouble(request.getParameter("minimumBidValue"));
		

		LocalDate sDate = LocalDate.parse(request.getParameter("bidStartDate"));
		LocalDate eDate = LocalDate.parse(request.getParameter("bidEndDate"));
	
		
		BeanFactory beanFactory = new BeanFactory();
		ProductSchedulerService productSchedule = beanFactory.createProductSchedulerServiceImplObj(); 
	
		ProductForAuction productAuction=new ProductForAuction();
		productAuction.setProductId(productId);
		productAuction.setMinBidValue(minimumBidValue);
		productAuction.setBidStartDate(sDate.now());
		productAuction.setBidEndDate(eDate);
		productAuction.setBidStatus(1);
		
		response.setStatus(productSchedule.scheduleAuction(productAuction) == true ? 200 : 999);
	}

}
