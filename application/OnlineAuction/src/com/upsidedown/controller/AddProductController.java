package com.upsidedown.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import com.upsidedown.factory.BeanFactory;
import com.upsidedown.model.Category;
import com.upsidedown.model.Product;
import com.upsidedown.model.User;
import com.uspidedown.service.ProductService;


@WebServlet("/addproduct")
public class AddProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public AddProductController() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User userInSession = (User) session.getAttribute("user");
		
		if (userInSession == null) {
			request.getRequestDispatcher("/accounts/login.jsp").forward(request, response);
		} else {

			if (userInSession.getUserType() == 1) {
				BeanFactory beanFactory = new BeanFactory();
				ProductService iProductService = beanFactory.createProductServiceImplObj();
				List<Category> catList = iProductService.getCategoryList();
				request.setAttribute("categoryList", catList);
				request.getRequestDispatcher("/addproduct.jsp").forward(request, response);
			} else {
				request.getRequestDispatcher("/error/.jsp").forward(request, response);
			}

		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				HttpSession session = request.getSession();
				User userInSession = (User) session.getAttribute("user");

				if (userInSession == null) {
					request.getRequestDispatcher("/login.jsp").forward(request, response);
				} else {

		
					if (userInSession.getUserType() == 1) {
						String BASE_DIR = "/User/Utkarsh/Documents/uploads/";
						String DEFAULT_FILENAME = "./resources/img/logo.jpg";
						boolean filePresent = false;
						String currentTime = Long.toString((int) (new Date().getTime() / 10000));
						HashMap<String, String> data = new HashMap<String, String>();

						if (ServletFileUpload.isMultipartContent(request)) {
							DiskFileItemFactory factory = new DiskFileItemFactory();
							ServletFileUpload upload = new ServletFileUpload(factory);
							List<FileItem> formItems = null;
							try {
								formItems = upload.parseRequest(new ServletRequestContext(request));
							} catch (FileUploadException e1) {
								e1.printStackTrace();
							}

							if (formItems != null && formItems.size() > 0) {
								for (FileItem item : formItems) {
									if (!item.isFormField()) {
										String fileName = new File(item.getName()).getName();
										fileName = fileName.replaceAll("\\s+", "");
										fileName = currentTime + "-" + fileName;
										String filePath = BASE_DIR + fileName;
										File storeFile = new File(filePath);
										try {
											item.write(storeFile);
											data.put("Image", fileName);

										} catch (Exception e) {
											e.printStackTrace();
										}

										filePresent = true;
									} else {
	
										String fieldName = item.getFieldName();
										String fieldValue = item.getString();
										data.put(fieldName, fieldValue);
									}
								}
							}

							if (!filePresent) {
								data.put("Image", DEFAULT_FILENAME);
							}
						}
						Product product = new Product(data.get("productName"), data.get("category"),
								data.get("productDescription"), Double.parseDouble(data.get("actualPrice")),
								Integer.parseInt(data.get("quantity")), data.get("Image"), userInSession.getUserId());
						BeanFactory beanFactory = new BeanFactory();
						ProductService productService = beanFactory.createProductServiceImplObj();
						boolean status = productService.addProducts(product);
						if (status==true) {
							response.setStatus(200);
						} else {
							System.out.println("Product not added");
							response.setStatus(501);
						}
					} else {
						request.getRequestDispatcher("/error/accessdenied.jsp").forward(request, response);
					}
				}
	}

}
