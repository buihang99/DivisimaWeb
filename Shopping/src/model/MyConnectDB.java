package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MyConnectDB {
	
	public static Connection getConnecttion(){
		Connection cons = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String url = "jdbc:sqlserver://localhost:1433;"+
        			"databaseName=Shopping";
	        String user="sa";
	        String pass="1234";
	        cons = DriverManager.getConnection(url,user,pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cons;
	}
	public static void thucThiSQL(String sql) throws Exception{
		Connection connect = getConnecttion();
		Statement stmt = connect.createStatement();
		stmt.executeUpdate(sql);
	}
	public static ResultSet chonDuLieu(String sql) throws Exception{
		Connection connect = getConnecttion();
		Statement stmt = connect.createStatement();
		ResultSet rs=	stmt.executeQuery(sql);
		return rs;
	}
	public static void main(String[] args) {
		System.out.println(getConnecttion());
	}

}
