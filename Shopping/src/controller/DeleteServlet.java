package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ProductDAOImpl;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/deleteProduct")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProductDAOImpl p = new ProductDAOImpl();
		String maSP = request.getParameter("maSP");
		String error = null;
		
		try {
			p.deleteProduct(maSP);
		} catch(Exception e) {
			error = e.getMessage();
			e.printStackTrace();
		}
		
		if(error != null) {
			request.setAttribute("error", error);
			RequestDispatcher rq = request.getServletContext().getRequestDispatcher("ad_err.jsp");
			rq.forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/adProduct");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
