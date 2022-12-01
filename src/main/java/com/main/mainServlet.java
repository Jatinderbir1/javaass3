package com.main;
import com.login.*;
import java.util.*;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class mainServlet
 */
@WebServlet("/main")
public class mainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public mainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		if(session != null) {
			//int id = Integer.parseInt(request.getParameter("pid"));
			String title = request.getParameter("title");
			String size = request.getParameter("size");
			String quantity = request.getParameter("quantity");
			String image = request.getParameter("image");
			String username = LoginDao.getUser();
			Product model = new Product(title,quantity,size,image,username);
			productDb object = new productDb();
			object.add(model);
			session.removeAttribute("products");
			ArrayList<Product> newpro = getProduct.get(session.getAttribute("username").toString());
			session.setAttribute("products",newpro);
			response.sendRedirect("main.jsp");
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		//doGet(request, response);
//		String title = request.getParameter("title");
//		String size = request.getParameter("size");
//		String quantity = request.getParameter("quantity");
//		String image = request.getParameter("image");
//		String username = LoginDao.getUser();
//		Product model = new Product(title,quantity,size,image,username);
//		productDb object = new productDb();
//		object.add(model);
//		response.sendRedirect("main.jsp");
//		
//		
//	}

}
