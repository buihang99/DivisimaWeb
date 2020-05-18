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

import DAO.UserDAO;
import model.User;

@WebServlet("/viewUser")
public class Admin_ViewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Admin_ViewUser() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UserDAO u = new UserDAO();
		List<User> list = new ArrayList<User>();
		list = u.listUser();
		//System.out.println(list.get(0).getUsername());
		getServletContext().setAttribute("List", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ad_viewuser.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user_id = request.getParameter("userid");
		UserDAO user = new UserDAO();
		user.deleteUser(user_id);
		response.sendRedirect(request.getContextPath() + "/viewUser");
	}

}
