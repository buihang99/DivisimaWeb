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


@WebServlet("/editProduct")
public class EditProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public EditProduct() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maSP = request.getParameter("maSP");
		String err = null;
		Product pr = null;
		try {
		ProductDAOImpl p = new ProductDAOImpl();
		pr = p.getProduct(maSP);
		} catch(Exception e) {
			err = e.getMessage();
			e.printStackTrace();
		}
		if((err!=null)&&(pr==null)) {
			response.sendRedirect(request.getServletPath() + "/adProduct");
			return;
		}
		request.setAttribute("err",err);
		request.setAttribute("product",pr);
		RequestDispatcher rq = request.getServletContext().getRequestDispatcher("/ad_editproduct.jsp");
		rq.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String maSP = request.getParameter("MaSP");
		String maTL = request.getParameter("MaTL");
		System.out.println(maTL);
		String tenSP = request.getParameter("TenSP");
		System.out.println(tenSP);
		String hinhanh = request.getParameter("Hinhanh");
		String priceStr = request.getParameter("Price");
		String thongtin = request.getParameter("Thongtin");
		int price = 0;
		try {
			price = Integer.parseInt(priceStr);
		}catch(Exception e) {
		}
		String error = "";
		if(!((maTL.equals("1")) || (maTL.equals("2"))|| (maTL.equals("3"))|| (maTL.equals("4")))) {
			error = "Nhập mã thể loại là 1 2 3 4 ứng với các thể loại: Woman , Men, Jewelry, Shoes";
		}
		if(maTL.equals("")||tenSP.equals("") ||hinhanh.equals("") || priceStr.equals("")) {
			error = "Enter full information";
			System.out.println(error);
		}
        
        if (error.length()!= 0) {
        	System.out.println("Hello");
        	Product p = new Product(maTL,maSP,tenSP,hinhanh,price,thongtin);
        	String url = request.getContextPath() + "/editProduct?maSP=" + maSP;
        	request.setAttribute("err", error);
        	request.setAttribute("product", p);
        	RequestDispatcher rq = request.getServletContext().getRequestDispatcher("/ad_editproduct.jsp");
    		rq.forward(request, response);
        }else {
        	Product pr = new Product(maTL, maSP, tenSP, hinhanh, price, thongtin);
    		ProductDAOImpl p = new ProductDAOImpl();
    		try {
    			p.updateProduct(pr);
    		}catch (Exception e) {
    			error = e.getMessage();
    			e.printStackTrace();
    		}
            request.setAttribute("product", pr);
            response.sendRedirect(request.getContextPath() + "/adProduct");
        }
	}

}
