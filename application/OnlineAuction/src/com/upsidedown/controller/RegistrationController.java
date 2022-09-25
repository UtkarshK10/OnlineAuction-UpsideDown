package com.upsidedown.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.upsidedown.factory.BeanFactory;
import com.upsidedown.model.User;
import com.upsidedown.model.exception.UserAlreadyExistsException;
import com.uspidedown.service.UserService;


@WebServlet("/register")
public class RegistrationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public RegistrationController() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/login.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String mobile = request.getParameter("phoneNumber");
		LocalDate dob = LocalDate.parse(request.getParameter("dateOfBirth"));
		//LocalDate dob=LocalDate.parse("2012-07-08");
		String password = request.getParameter("pass");
		String address = request.getParameter("address");
		int usertype = Integer.valueOf(request.getParameter("userType"));
		double walletAmount = Double.valueOf(request.getParameter("walletAmt"));

		BeanFactory beanFactory = new BeanFactory();
		UserService userService = beanFactory.createUserServiceImplObj();

		User user = new User();
		user.setName(name);
		user.setUsername(username.toLowerCase());
		user.setEmail(email.toLowerCase());
		user.setPhoneNumber(mobile);
		user.setDateOfBirth(dob);
		user.setPassword(password);
		user.setAddress(address);
		user.setUserType(usertype);
		user.setWalletAmt(walletAmount);
		System.out.println(user);
		try {
			System.out.println("ok");
			response.setStatus(userService.saveUser(user) == true ? 200 : 999);
		} catch (UserAlreadyExistsException e) {
			e.printStackTrace();
		}
		doGet(request, response);
	}

}
