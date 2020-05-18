package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ProductDAOImpl;
import model.Product;

/**
 * Servlet implementation class ProductAdServlet
 */
@WebServlet("/adProduct")
public class ProductAdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ProductAdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDAOImpl p = new ProductDAOImpl();
		List<Product> list = p.getList();
		getServletContext().setAttribute("list", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ad_productlist.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
