package com.upsidedown.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.upsidedown.dao.UserDao;
import com.upsidedown.dao.impl.UserDaoImpl;
import com.upsidedown.model.User;
import com.upsidedown.model.exception.UserNotFoundException;
import com.upsidedown.service.impl.UserServiceImpl;
import com.uspidedown.service.UserService;


@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	UserService userService = new UserServiceImpl(); 
	
	
    public LoginController() {
        super();
        
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		HttpSession session = request.getSession();
		User userInSession = (User)session.getAttribute("user");
		

		if(userInSession==null)
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		else {
			if(userInSession.getUserType() == 0) {
				response.sendRedirect("profile");
				response.setStatus(200);
			}
			else if(userInSession.getUserType() == 1) {

				response.sendRedirect("profile");
				response.setStatus(200);

			}
			else {
				System.out.println("Error! Something went wrong while logging In");
				request.getRequestDispatcher("/login.jsp").forward(request, response);
				response.setStatus(999);
			}
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session=request.getSession();  
		User sessionuser = (User) session.getAttribute("user");
		if(sessionuser==null) {
			User user;
			try {
				user = userService.getUser(username, password);
				if(user!=null){
					session.setAttribute("user", user);
					session.setAttribute("isUserAuthenticated", true);
					session.setAttribute("userType", user.getUserType());
					if(user.getUserType()==0) {
						// in buyer's account
						response.setStatus(200);
						request.getRequestDispatcher("/profile.jsp").forward(request, response);
					}
					else if(user.getUserType() == 1) {
						// in seller's account
						response.setStatus(200);
						request.getRequestDispatcher("/profile.jsp").forward(request, response);
					}
					
					else {
						System.out.println("Error! Something went wrong while logging In");
						request.getRequestDispatcher("/login.jsp").forward(request, response);
						response.setStatus(999);
					}
				}
			} catch (UserNotFoundException e) {
				response.setStatus(999);
				request.getRequestDispatcher("/login.jsp").forward(request, response);
				System.out.println("Exception::"+e.getMessage());
				
			}
			
		}
		
		}
	}
		


