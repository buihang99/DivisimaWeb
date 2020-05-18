package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.HistoryDAOImpl;
import DAO.ProductDAOImpl;
import model.History;
import model.Product;
import model.User;

@WebServlet(loadOnStartup = 1,
urlPatterns= {"/history"})

public class HistoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
    public HistoryServlet() {
    	super();
    }
    
    
    @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		ProductDAOImpl pr = new ProductDAOImpl();
//		String maTL = request.getParameter("maTL");
//		List<Product> list = pr.getListbyCategory(maTL);
//		getServletContext().setAttribute("List", list);
//	 // Forward sang /customer/category.jsp
//		RequestDispatcher dispatcher = request.getRequestDispatcher("/category.jsp");
//		dispatcher.forward(request, response);
    	
    	HistoryDAOImpl ht = new HistoryDAOImpl();
    	HttpSession test = request.getSession();
		User u = (User) test.getAttribute("user");
		System.out.println(u.getEmail());
		
		List<History> list = ht.getHistory(u.getUser_id());
		
		
		HttpSession session = request.getSession();
		session.setAttribute("ttt", list);
		response.sendRedirect("history.jsp");
	}
    
    @Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doGet(request, response);
	}

}
