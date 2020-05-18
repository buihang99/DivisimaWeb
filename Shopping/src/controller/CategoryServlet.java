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

@WebServlet(loadOnStartup = 1,
		urlPatterns= {"/productList"})
public class CategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public CategoryServlet() {
    	super();
    }
    
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDAOImpl pr = new ProductDAOImpl();
		String maTL = request.getParameter("maTL");
		List<Product> list = pr.getListbyCategory(maTL);
		getServletContext().setAttribute("List", list);
	 // Forward sang /customer/category.jsp
		RequestDispatcher dispatcher = request.getRequestDispatcher("/category.jsp");
		dispatcher.forward(request, response);
	}
    
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doGet(request, response);
	}

}

