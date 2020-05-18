package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import DAO.HistoryDAOImpl;
import DAO.OrderDAO;
import DAO.Order_ListDAOImpl;
import DAO.ProductDAOImpl;

import java.util.ArrayList;
import java.util.List;

import model.Product;
import model.User;
import model.Cart;
//import model.History;
import model.Order;
import model.Order_List;
/**
 * Servlet implementation class Cart
 */
@WebServlet("/CartServlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ArrayList<Cart> cart = new ArrayList<Cart>();
       
    public CartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String command = request.getParameter("command");
		String maSP = request.getParameter("maSP");
		if(command.equals("Logout")) {
			if(cart!=null) {
			//for (int i = 0; i < cart.size();i++) {
					cart.clear();
				//}
			}
			HttpSession session = request.getSession(false);
			session.invalidate();
			RequestDispatcher r = request.getRequestDispatcher("/signin.jsp");
			r.forward(request, response);
		}
		if (command.equals("addCart")) {
			Product p = new Product ("",maSP, "", "", 0, "");
			//System.out.println("Nhung yêu Hoàng");
			addToCart(p);
			// sau khi them vao gio hang ta se chuyen toi trang gio hang
			// can tao session de luu tru gia tri
			HttpSession session = request.getSession();
			//System.out.println(cart.size());
			session.setAttribute("cart", cart);
			response.sendRedirect("cart.jsp");
		} else{
			if(command.equals("deleteCart")){
				Product p = new Product ("",maSP, "", "", 0, "");
				deleteFromCart(p);
				//System.out.println("Nhung ăn cứt");
				HttpSession session = request.getSession();
				//System.out.println(cart.size());
				session.setAttribute("cart", cart);
				response.sendRedirect("cart.jsp");
			} else{
				if(command.equals("removeCart")){
					Product p = new Product ("",maSP, "", "", 0, "");
					removeFromCart(p);
					HttpSession session = request.getSession();

					session.setAttribute("cart", cart);
					response.sendRedirect("cart.jsp");
				}else{
					if(command.equals("setCart")){
						Product p = new Product ("",maSP, "", "", 0, "");
						setCart(p,Integer.parseInt((String) request.getParameter("soluong")));
						HttpSession session = request.getSession();

						session.setAttribute("cart", cart);
						response.sendRedirect("cart.jsp");
					}
				}
			}
		}
	}
	
	private String removeFromCart(Product p) {
		
		for (Cart item : cart) {
			if ((item.getP().getMaSP()).equals(p.getMaSP())) {
				cart.remove(item);
				return "cart";
			}
		}
		return "cart";
	}
	
	private String setCart(Product p, int s) {
		for (Cart item : cart) {
			if ((item.getP().getMaSP()).equals(p.getMaSP())) {
				item.setQuantity(s);
				return "cart";
			}
		}
		Cart c = new Cart();
		c.setP(p);
		c.setQuantity(s);
		cart.add(c);
		return "cart";
	}

	// phuongw thuc them san pham moi vao trong gio hang
	public String addToCart(Product p) {
		for (Cart item : cart) {
			if ((item.getP().getMaSP()).equals(p.getMaSP())) {
				item.setQuantity(item.getQuantity() + 1);
				return "cart";
			}
		}
		Cart c = new Cart();
		c.setP(p);
		c.setQuantity(1);
		cart.add(c);
		return "cart";
	}
	
	// phuongw thuc giam bot 1 san pham khoi trong gio hang
		public String deleteFromCart(Product p) {
			for (Cart item : cart) {
				
				if ((item.getP().getMaSP()).equals(p.getMaSP()) && item.getQuantity()>1) {
					
					item.setQuantity(item.getQuantity() - 1);
					return "cart";
				}
				if((item.getP().getMaSP()).equals(p.getMaSP()) &&  item.getQuantity()==1) {
					
					cart.remove(item);
					return "cart";
				}
			}
			return "cart";
		//String maSP = request.getParameter("maSP");
		//System.out.println(maSP);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("Order");
		//String id = request.getParameter("id");
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String user_name = request.getParameter("user_name");
		System.out.println("user_name");
        String user_address = request.getParameter("user_address");
        String user_phone = request.getParameter("user_phone");
        //System.out.println(user_name);
        String err = "";
        if (user_name.equals("") || user_address.equals("") || user_phone.equals("")) {
        	err += "Enter full information!";
		} else {
		}
        
        //System.out.println(err);

		if (err.length() > 0) {
			//System.out.println("có lỗi");
			request.setAttribute("order_err", err);
			String url = "/checkout.jsp";
			RequestDispatcher rd = getServletContext()
					.getRequestDispatcher(url);
			rd.forward(request, response);
		}else {
			//System.out.println("Xử lí");
			HttpSession test = request.getSession();
			System.out.println("userid là");
			User u = (User) test.getAttribute("user");
			System.out.println(u.getUser_id());
			
			Order order = new Order(user_name,user_address,user_phone,u.getUser_id());
			OrderDAO o = new OrderDAO();
			o.addOrder(order);
			int id = o.getOrderId();
			System.out.println(id);
			//System.out.println("add order thành công");
			String totalStr = request.getParameter("total");
			int cart_size = Integer.parseInt(request.getParameter("size"));
			String maSP = "";
			String temp1 = "";
			String temp2 = "";
			ArrayList<Cart> list_cart = new ArrayList<Cart>();
			for(int i=0; i < cart_size; i++) {
				temp1 = "soluong"+ String.valueOf(i);
				temp2 = "maSP"+ String.valueOf(i);
				int quantity = Integer.parseInt(request.getParameter(temp1));
				maSP = request.getParameter(temp2);
				ProductDAOImpl p = new ProductDAOImpl();
				Order_List order_list = new Order_List(id,maSP,quantity,p.getProduct(maSP).getPrice());
				Order_ListDAOImpl or = new Order_ListDAOImpl();
				or.addOrder_List(order_list);
				//System.out.println("add history thành công");
			}
			String command = request.getParameter("command");
			if(command.equals("Order")) {
				if(cart!=null) {
				//for (int i = 0; i < cart.size();i++) {
						cart.clear();
					//}
				}
			}
			RequestDispatcher rq = request.getServletContext().getRequestDispatcher("/test.jsp");
			rq.forward(request, response);
		}
	}
}
