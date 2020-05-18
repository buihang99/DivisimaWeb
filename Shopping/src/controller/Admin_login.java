package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import DAO.AdminDAO;
import model.Admin;

/**
 * Servlet implementation class Admin_login
 */
@WebServlet(name="Admin_login", urlPatterns = {"/Admin_login"})
public class Admin_login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//System.out.println("O O");
		String username = request.getParameter("your_name");
        String password = request.getParameter("your_pass");
		
        String err = "";
		String url = "/ad_login.jsp";

		if (username.equals("") || password.equals("")) {
			err += "Enter full infomation!";
		}else {
			if (new AdminDAO().login(username, password) == false) {
				System.out.println("Tai khoan khong ton tai");
				err += "Username or password incorrect!";
			}
		}
		if (err.length() > 1) {
//			request.setAttribute("err", err);
			request.setAttribute("err", err);
		}
		//System.out.println(username);
		Admin kh = new AdminDAO().SelectInformationAdmin(username);
		//System.out.println(kh);
		if (err.length() == 0) {
				new AdminDAO().login(username, password);
				HttpSession session = request.getSession();
				Cookie loginCookie = new Cookie("username",kh.getName());
	            //setting cookie to expiry in 30 mins
	            loginCookie.setMaxAge(60*60);
				session.setAttribute("admin", kh);
				session.setAttribute("ad_name", username);
				response.sendRedirect("ad_index.jsp");
			
		}else{
			//System.out.println("Loi dang nhap");
			url = "/ad_login.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		}
	}

}
