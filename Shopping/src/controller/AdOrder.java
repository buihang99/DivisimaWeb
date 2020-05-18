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

import DAO.Order_ListDAOImpl;
import model.DonHang;
import model.Order_List;

/**
 * Servlet implementation class AdOrder
 */
@WebServlet("/AdOrder")
public class AdOrder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AdOrder() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<DonHang> list = new ArrayList<DonHang>();
		Order_ListDAOImpl o = new Order_ListDAOImpl();
		list = o.getDonHang();
		request.setAttribute("donhang", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ad_order.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String order_idStr = request.getParameter("orderid");
		int order_id = Integer.parseInt(order_idStr);
		//System.out.println(order_id);
		Order_ListDAOImpl o = new Order_ListDAOImpl();
		o.addtoHistory(order_id);
        response.sendRedirect(request.getContextPath() + "/AdOrder");
	}

}
