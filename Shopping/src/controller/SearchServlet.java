package controller;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("SearchServlet");
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String search = request.getParameter("search").toLowerCase();
		
		//System.out.println(search);
		
		if(search !=null) {
			ProductDAOImpl pr = new ProductDAOImpl();
			List<Product> list = new ArrayList<Product>();
			list = pr.searchList(search);
			if(list != null) {
				getServletContext().setAttribute("search", list);
				RequestDispatcher rq = request.getRequestDispatcher("search.jsp");
				rq.forward(request, response);
			}
			if(list == null) {
				response.sendRedirect("EmtySearch.jsp");
			}
		}
	}
	
}
