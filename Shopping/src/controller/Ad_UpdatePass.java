package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.AdminDAO;
import DAO.UserDAO;

/**
 * Servlet implementation class Ad_UpdatePass
 */
@WebServlet("/Ad_UpdatePass")
public class Ad_UpdatePass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ad_UpdatePass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ad_updatePass.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String err = null;
		String ad_name = (String) request.getParameter("ad_name");
		System.out.println(ad_name);
		new AdminDAO();
		String old_pass = AdminDAO.SelectInformationAdmin(ad_name).getPass();
		System.out.println(old_pass);
		String new_pass = request.getParameter("new_pass");
		String re_newpass = request.getParameter("re_newpass");
		if(!old_pass.equals(request.getParameter("old_pass"))) {
			err = "Old password incorrect!!!";
			request.setAttribute("err", err);
			//System.out.println("err1");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ad_updatePass.jsp");
			dispatcher.forward(request, response);
		}
		if(new_pass.equals("")) {
			err = "New Password is Empty!!!";
			request.setAttribute("err", err);
			//System.out.println("err1");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/ad_updatePass.jsp");
			dispatcher.forward(request, response);
		}else {
			if(!new_pass.equals(re_newpass)) {
				err = "The new password and repeat password do not match!!!";
				request.setAttribute("err", err);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/ad_updatePass.jsp");
				dispatcher.forward(request, response);
			}else {
				AdminDAO a = new AdminDAO();
				a.updatePass(new_pass,ad_name);
				//System.out.println("err3");
				RequestDispatcher dispatcher = request.getRequestDispatcher("/ad_noti.jsp");
				dispatcher.forward(request, response);
			}
		}
		
	}

}
