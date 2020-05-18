package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ProductDAOImpl;
import model.Product;


@WebServlet("/addProduct")
public class AddProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public AddProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String maTL = request.getParameter("MaTL");
		String maSP = request.getParameter("MaSP");
		String tenSP = request.getParameter("TenSP");
		String hinhanh = request.getParameter("Hinhanh");
		String priceStr = request.getParameter("Price");
		String thongtin = request.getParameter("Thongtin");
		int price = 0;
		//System.out.println(maTL);
		try {
			price = Integer.parseInt(priceStr);
		}catch(Exception e) {
		}
		String add_err = null;
		String regex = "\\w+";
		
		
		if(!((maTL.equals("1")) || (maTL.equals("2"))|| (maTL.equals("3"))|| (maTL.equals("4")))) {
			add_err = "Nhập mã thể loại là 1 2 3 4 ứng với các thể loại: Woman , Men, Jewelry, Shoes";
		}else {
		if(maSP==null||tenSP==null ||hinhanh==null ||priceStr==null || !maSP.matches(regex)) {
			add_err = "Enter full information";
		}
		}
		if(add_err==null){
			try {
			Product p = new Product(maTL,maSP,tenSP,hinhanh,price,thongtin);
			ProductDAOImpl pd = new ProductDAOImpl();
			pd.addProduct(p);
			request.setAttribute("product", p);
			response.sendRedirect(request.getContextPath() + "/adProduct");
			//System.out.println(maTL);
			//request.setAttribute("TenTL", maTL);
			} catch(Exception e) {
				add_err = "Product already exists!";
				System.out.println("he");
				request.setAttribute("add_err", add_err);
				RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/ad_addproduct.jsp");
	            dispatcher.forward(request, response);
				e.printStackTrace();
			}
		}else {
			request.setAttribute("add_err", add_err);
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher("/ad_addproduct.jsp");
            dispatcher.forward(request, response);
        }
	}

}
