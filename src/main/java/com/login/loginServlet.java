package com.login;
import com.main.*;

import java.util.ArrayList;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/login")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Login loginBean = new Login();
	private static HttpSession session;
	
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		loginBean.setUsername(username);
		loginBean.setPassword(password);

		try {
			if (LoginDao.validate(username,password)) {
				session = request.getSession();
				session.setAttribute("username",username);
				ArrayList<Product> products = getProduct.get(username);
				session.setAttribute("products",products);
				response.sendRedirect("main.jsp");
			} else {
				response.sendRedirect("login.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getUser() {
		return session.getAttribute("username").toString();
	}

}
