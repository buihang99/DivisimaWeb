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
 * Servlet implementation class ProductServlet
 */
@WebServlet("/product")
public class ProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ProductServlet() {
        super();
    }

	
	@SuppressWarnings("null")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDAOImpl pd = new ProductDAOImpl();
		String maSP = request.getParameter("maSP");
		Product p = pd.getProduct(maSP);
		String maTL = p.getMaTL();
		List<Product> list= pd.getListbyCategory(maTL);
		
		getServletContext().setAttribute("List", list);
		getServletContext().setAttribute("Product", p);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/product.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
