package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.DoanhSo;
import model.DonHang;
//import model.History;
import model.MyConnectDB;
import model.Order_List;
import model.User;

public class Order_ListDAOImpl implements Order_ListDAO {

	@Override
	public List<DoanhSo> history() {
		List<DoanhSo> doanhso = new ArrayList<DoanhSo>();
		String sql = "SELECT Order_List.MaSP, Product.TenSP, Order_List.price, sum(Order_List.soluong) FROM [Order_List], [Product],[History] WHERE Order_List.MaSP = Product.MaSP and Order_List.order_id = History.order_id  GROUP BY Order_List.MaSP, Product.TenSP, Order_List.price ";
		try {
			ResultSet rs = MyConnectDB.chonDuLieu(sql);
			while(rs.next()) {
				String maSP = rs.getString(1);
				String tenSP = rs.getNString(2);
				int soluong = rs.getInt(4);
				int thanhtien = soluong*rs.getInt(3);
				doanhso.add(new DoanhSo(maSP,tenSP,soluong,thanhtien));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return doanhso;
	}
	
	@Override
	public void addOrder_List(Order_List kh) {
		try {
			new MyConnectDB();
			MyConnectDB.thucThiSQL("insert into [Order_List] values('"+kh.getOrder_id()+"','"+kh.getMaSP()+"','"+kh.getSoluong()+"','"+kh.getPrice()+"')");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<DonHang> getDonHang(){
		String sql = "select order_id, name, address, phone from [Order] where order_id not in (select order_id from [History])";
		List<DonHang> list = new ArrayList<DonHang>();
		try {
			new MyConnectDB();
			ResultSet rs = MyConnectDB.chonDuLieu(sql);
			while(rs.next()) {
				int order_id = rs.getInt(1);
				String name = rs.getNString(2);
				String address = rs.getNString(3);
				String phone = rs.getString(4);
				list.add(new DonHang(order_id, name, address, phone));
			}
			return list;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int getTongSP(int orderid){
		int tong = 0;
		String sql = "select count(MaSP) from [Order_List] where order_id='"+orderid+"'group by order_id";
		try {
			ResultSet rs = new MyConnectDB().chonDuLieu(sql);
			while(rs.next()) {
				tong = rs.getInt(1);
			}
			return tong;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return tong;
	}
	
	/*public int getTongDonhang() {
		int tongdonhang = 0;
		String sql = "select COUNT([Order].order_id) from [Order], [History] where [Order].order_id != [History].order_id";
		try {
			new MyConnectDB();
			ResultSet rs = MyConnectDB.chonDuLieu(sql);
			while(rs.next()) {
			tongdonhang = rs.getInt(1);
			}
			return tongdonhang;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return tongdonhang;
	}*/
	
	public List<Order_List> getOrder_List(int orderid){
		List<Order_List> list = new ArrayList<Order_List>();
		try {
			String sql = "select * from [Order_List] where order_id='"+orderid+"'";
			ResultSet rs = new MyConnectDB().chonDuLieu(sql);
			while(rs.next()) {
				int order_id = rs.getInt(1);
				String MaSP = rs.getString(2);
				int soluong = rs.getInt(3);
				int price = rs.getInt(4);
				list.add(new Order_List(order_id,MaSP,soluong,price));
			}
			return list;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void addtoHistory(int order_id) {
		String sql = "insert into [History] values('"+order_id+"')";
		try {
			new MyConnectDB();
			MyConnectDB.thucThiSQL(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void main(String[] args) {
		Order_ListDAOImpl o = new Order_ListDAOImpl();
		//List<Integer> l = o.getTongSP();
		//System.out.println(l.get(1));
		//System.out.println(o.getTongDonhang());
		System.out.println(o.getDonHang().get(1).getOrder_id());
		//System.out.println(o.getTongDonhang());
	}
	
}
