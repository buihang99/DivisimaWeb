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

import DAO.UserDAO;
import model.User;

/**
 * Servlet implementation class test
 */
@WebServlet(name="test", urlPatterns = {"/test"})
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static UserDAO userDAO = new UserDAO();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public test() {
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
		String username = request.getParameter("your_name");
        String password = request.getParameter("your_pass");
		
        String err = "";
		String url = "/signin.jsp";

		if (username.equals("") || password.equals("")) {
			err += "Enter full infomation!";
		}else {
			if (new UserDAO().login(username, password) == false) {
				//System.out.println("Tai khoan khong ton tai");
				err += "Username or password incorrect!";
			}
		}
		if (err.length() > 1) {
//			request.setAttribute("err", err);
			request.setAttribute("err", err);
			System.out.println(err.length());
		}
		User kh = new UserDAO().SelectInformationUser(username);
		System.out.println(kh);
		if (err.length() == 0) {
				new UserDAO().login(username, password);
				HttpSession session = request.getSession();
				Cookie loginCookie = new Cookie("username",username);
	            //setting cookie to expiry in 30 mins
	            loginCookie.setMaxAge(30*60);
				session.setAttribute("user", kh);
				session.setAttribute("username", kh.getUsername());
				response.sendRedirect("index.jsp");
			
		}else{
			System.out.println("Loi dang nhap");
			url = "/signin.jsp";
			RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
			rd.forward(request, response);
		}
		
	}

}
