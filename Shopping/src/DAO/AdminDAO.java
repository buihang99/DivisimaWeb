package DAO;

import java.sql.ResultSet;

import model.Admin;
import model.MyConnectDB;
import model.User;

public class AdminDAO {
	public static Admin SelectInformationAdmin(String username) {
		try {
			ResultSet  rs = new MyConnectDB().chonDuLieu("select * from [Admin] where name='"+username+"'");
			while(rs.next()){
				String user_id = rs.getString(2);
				String user_name = rs.getString(3);
				String password = rs.getString(1);
				return new Admin(user_id, user_name, password);
			 }
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return null;
	}
	public static boolean login(String username, String pass) {
		try {
			ResultSet  rs = new MyConnectDB().chonDuLieu("select * from [Admin] where name='"+username+"'");
			 while(rs.next()){
				 if(rs.getString(2).equals(username) && rs.getString(3).equals(pass)){
					 return true;
				 }
			 }
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return false;
	}
	public static void main(String[] args) {
	Admin a = SelectInformationAdmin("admin");
	System.out.println(a);
	}
	
	public void updatePass(String newpass,String name) {
		String sql = "update [Admin] set pass='"+newpass+"' where name='"+name+"'";
		try {
			new MyConnectDB();
			MyConnectDB.thucThiSQL(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}
