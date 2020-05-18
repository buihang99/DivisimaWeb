package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.DoanhSo;
//import model.History;
import model.MyConnectDB;
import model.Order;

public class OrderDAO {
	
	public void addOrder(Order kh) {
		try {
			new MyConnectDB();
			MyConnectDB.thucThiSQL("insert into [Order] values(N'"+kh.getName()+"',N'"+kh.getAddress()+"','"+kh.getPhone()+"',N'"+kh.getUser_id()+"')");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public int getOrderId() {
		String sql="select order_id from [Order] where order_id = (select MAX(order_id) from [Order])";
		int order_id = 0;
		try {
			new MyConnectDB();
			ResultSet rs = MyConnectDB.chonDuLieu(sql);
			while (rs.next()) {
				order_id = rs.getInt(1);
			}
			return order_id;
		} catch(Exception e) {
			e.printStackTrace();
		}
		return order_id;
	}
	
	/*public static void main(String[] args) {
		Order order = new Order("Hang"," 433 BM", "01234");
		OrderDAO o = new OrderDAO();
		o.addOrder(order);
	}*/
}
