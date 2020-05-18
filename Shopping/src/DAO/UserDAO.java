package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.User;
import model.MyConnectDB;
public class UserDAO implements ObjectDAO{

	@Override
	public boolean addUser(Object obj) {
		User kh = (User) obj;
		try {
			new MyConnectDB().thucThiSQL("insert into [User] values(N'"+kh.getUser_id()+"',N'"+kh.getUsername()+"','"+kh.getPassword()+"','"+kh.getEmail()+"',N'"+kh.getAddress()+"')");
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public static User SelectInformationUser(String username) {
		try {
			ResultSet  rs=new MyConnectDB().chonDuLieu("select * from [User] where username=N'"+username+"'");
			while(rs.next()){
				String user_id = rs.getNString(1);
				String user_name = rs.getNString(2);
				String password = rs.getString(3);
				String email = rs.getString(4);
				String address = rs.getNString(5);
				return new User(user_id, user_name, password,email, address);
			 }
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	@Override
	public boolean login(String name_user, String pass) {
		try {
			ResultSet  rs = new MyConnectDB().chonDuLieu("select * from [User] where username=N'"+name_user+"'");
			 while(rs.next()){
				 if(rs.getNString(2).equals(name_user) && rs.getString(3).equals(pass)){
					 return true;
				 }
			 }
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return false;
	}
	
	@Override
	public boolean checkUser(String user_name) {
		try {
			
			ResultSet  rs= new MyConnectDB().chonDuLieu("select * from [User] where username=N'"+user_name+"'");
			if(rs.next()) {
				return true;
			 }
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return false;
	}
	
	public void updatePass(String newpass,String userid) {
		String sql = "UPDATE [User] set password='"+newpass+"'where user_id=N'"+userid+"'";
		try {
			MyConnectDB.thucThiSQL(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<User> listUser(){
		String sql = "select * from [User]";
		List<User> list = new ArrayList<User>();
		try {
			new MyConnectDB();
			ResultSet rs = MyConnectDB.chonDuLieu(sql);
			while(rs.next()) {
				String user_id = rs.getNString(1);
				String username = rs.getNString(2);
				String password = rs.getString(3);
				String email = rs.getString(4);
				String address = rs.getNString(5);
				list.add(new User(user_id,username, password, email, address));
			}
			return list;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public void deleteUser(String userid) {
		String sql = "Delete [User] Where user_id = N'"+userid+"'";
		try {
			new MyConnectDB();
			MyConnectDB.thucThiSQL(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
//		System.out.println(new KhachHangDAO().themTaiKhoan(kh));
//		System.out.println(new UserDAO().login("buihang", "123"));
//		User kh = new User("3","ti","13","b.com","bach khoa");
//		System.out.println(new UserDAO().addUser(kh));
//		System.out.println(SelectInformationUser("buihang"));
		System.out.println(new UserDAO().checkUser("hong"));
	}
	
}
