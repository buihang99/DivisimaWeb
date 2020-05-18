package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Category;
import model.MyConnectDB;

public class CategoryDAOImpl implements CategoryDAO{

	@Override
	public List<Category> getList() {
		Connection con = MyConnectDB.getConnecttion();
		String sql = "select * from Category";
		List<Category> list = new ArrayList<Category>();
		try {
			ResultSet rs = MyConnectDB.chonDuLieu(sql);
			while (rs.next()) {
				String MaTL = rs.getString("MaTL");
				String TenTL = rs.getNString("TenTL");
				String Mota = rs.getNString("Mota");
				list.add(new Category(MaTL,TenTL,Mota));
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public String getMaTL(String tenTL){
		//Connection con = MyConnectDB.getConnecttion();
		String sql = "select * from Category where TenTL = N'"+tenTL+"'";
		try {
			ResultSet rs = MyConnectDB.chonDuLieu(sql);
			String MaTL = rs.getString("MaTL");
			return MaTL;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
