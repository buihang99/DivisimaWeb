package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Contact;
import model.MyConnectDB;

public class ContactDAO {
	public void addContact(Contact c) {
		String sql = "insert into [Contact] values(N'"+c.getName()+"','"+c.getEmail()+"',N'"+c.getSubject()+"',N'"+c.getMessage()+"')";
		try {
			new MyConnectDB();
			MyConnectDB.thucThiSQL(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Contact> getContact(){
		List<Contact> list = new ArrayList<Contact>();
		String sql = "select * from [Contact]";
		try {
			new MyConnectDB();
			ResultSet rs = MyConnectDB.chonDuLieu(sql);
			while(rs.next()) {
				String name = rs.getNString(1);
				String email = rs.getString(2);
				String subject = rs.getNString(3);
				String message = rs.getNString(4);
				list.add(new Contact(name,email,subject,message));
			}
			return list;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
