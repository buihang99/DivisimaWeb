package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

//import DAO.HistoryDAOImpl;
import DAO.OrderDAO;
import DAO.ProductDAO;
import DAO.ProductDAOImpl;
import DAO.UserDAO;
import model.Cart;
//import model.History;
import model.Order;
import model.User;


@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUser() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/udPass.jsp");
		dispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		String err = null;
		String username = (String) request.getParameter("username");
		System.out.println(username);
		new UserDAO();
		String old_pass = UserDAO.SelectInformationUser(username).getPassword();
		//System.out.println(old_pass);
		String new_pass = request.getParameter("new_pass");
		String re_newpass = request.getParameter("re_newpass");
		if(!old_pass.equals(request.getParameter("old_pass"))) {
			err = "Old password incorrect!!!";
			request.setAttribute("err", err);
			//System.out.println("err1");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/udPass.jsp");
			dispatcher.forward(request, response);
		}
		if(new_pass.equals("")) {
			err = "New Password is Empty!!!";
			request.setAttribute("err", err);
			//System.out.println("err1");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/udPass.jsp");
			dispatcher.forward(request, response);
		}else {
			if(!new_pass.equals(re_newpass)) {
				err = "The new password and repeat password do not match!!!";
				request.setAttribute("err", err);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/udPass.jsp");
				dispatcher.forward(request, response);
			}else {
				UserDAO u = new UserDAO();
				u.updatePass(new_pass,username);
				//System.out.println("err3");
				request.setAttribute("err", err);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/notification.jsp");
				dispatcher.forward(request, response);
			}
		}
		
	}
}
