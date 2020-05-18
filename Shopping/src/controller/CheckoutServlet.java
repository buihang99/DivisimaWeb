package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ProductDAOImpl;
import model.Cart;

@WebServlet("/CheckoutServlet")
public class CheckoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public CheckoutServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String totalStr = request.getParameter("total");
		int cart_size = Integer.parseInt(request.getParameter("size"));
		String maSP = "";
		String temp1 = "";
		String temp2 = "";
		ArrayList<Cart> list_cart = new ArrayList<Cart>();
		String temp = "";
		
		for(int i=0; i < cart_size; i++) {
			temp1 = "soluong"+ String.valueOf(i);
			temp2 = "maSP"+ String.valueOf(i);
			int quantity = Integer.parseInt(request.getParameter(temp1));
			maSP = request.getParameter(temp2);
			ProductDAOImpl pr = new ProductDAOImpl();
			Cart c = new Cart(pr.getProduct(maSP), quantity);
			list_cart.add(c);
		}
		getServletContext().setAttribute("list_cart", list_cart);
		//System.out.println(totalStr);
		getServletContext().setAttribute("total", totalStr);
		
		RequestDispatcher rq = request.getRequestDispatcher("/checkout.jsp");
		rq.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}

}
