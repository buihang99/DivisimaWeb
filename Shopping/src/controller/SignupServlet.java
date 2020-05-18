package controller;

import java.io.IOException;

import DAO.UserDAO;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet(name="SignupServlet", urlPatterns = {"/SignupServlet"})
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UserDAO userDAO = new UserDAO();
	
    public SignupServlet() {
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
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String re_pass = request.getParameter("re_pass");
        String address =  request.getParameter("address");;
		
        String login_err = "";
		String url = "/sign_up.jsp";
		
        if (username.equals("") || password.equals("") || email.equals("") || re_pass.equals("")) {
        	login_err += "Enter full information!";
		} else {
			if(!password.equals(re_pass)) {
				login_err += "The password and repeat password do not match";
	        }else {
				if (userDAO.checkUser(username) == true) {
					login_err += "Account already exists!";
				} 
	        }
		}
        System.out.println(login_err);

		if (login_err.length() > 0) {
			request.setAttribute("login_err", login_err);
		}

		try {
			if (login_err.length() == 0) {
				HttpSession session = request.getSession();
//				session.setAttribute("cart", cart);
				User kh = new User(username, username, password, email, address);
				userDAO.addUser(kh);
				userDAO.login(username, password);
				Cookie loginCookie = new Cookie("username",username);
	            //setting cookie to expiry in 30 mins
	            loginCookie.setMaxAge(30*60);
	            session.setAttribute("user", kh);
				session.setAttribute("username", kh.getUsername());
	            response.addCookie(loginCookie);
	            response.sendRedirect("index.jsp");
				
			} else {
				url = "/sign_up.jsp";
				RequestDispatcher rd = getServletContext()
						.getRequestDispatcher(url);
				rd.forward(request, response);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			response.sendRedirect("/sign_up.jsp");
		}
	}

}