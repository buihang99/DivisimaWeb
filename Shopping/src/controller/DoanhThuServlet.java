package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import DAO.HistoryDAOImpl;
import DAO.Order_ListDAOImpl;
import model.DoanhSo;


@WebServlet("/doanhThu")
public class DoanhThuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DoanhThuServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Order_ListDAOImpl h = new Order_ListDAOImpl();
		List<DoanhSo> list = h.history();
		getServletContext().setAttribute("doanhthu", list);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/ad_doanhthu.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
