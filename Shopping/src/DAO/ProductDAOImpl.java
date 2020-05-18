package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.MyConnectDB;
import model.Product;

public class ProductDAOImpl implements ProductDAO {

	@Override
	public void addProduct(Product p) {
		//Connection cnn = MyConnectDB.getConnecttion();
		String sql = "insert into Product values ('"+p.getMaTL()+"','"+p.getMaSP()+"',N'"+p.getTenSP()+"',"
				+ "'"+p.getHinhanh()+"','"+p.getPrice()+"',N'"+p.getThongtin()+"')";
		try {
			MyConnectDB.thucThiSQL(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void deleteProduct(String maSP) {
		String sql = "Delete Product WHERE MaSP = '"+maSP+"'";
		try {
			MyConnectDB.thucThiSQL(sql);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void updateProduct(Product p) {
		String sql = "UPDATE Product set MaTL ='"+p.getMaTL()+"',TenSP= N'"+p.getTenSP()+"',hinhanh='"+p.getHinhanh()+"',"
				+ "price='"+p.getPrice()+"',thongtin=N'"+p.getThongtin()+"'WHERE MaSP='"+p.getMaSP()+"'";
		try {
			MyConnectDB.thucThiSQL(sql);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Product> getList() {
		Connection cnn = MyConnectDB.getConnecttion();
		String sql = "select * from Product";
		List<Product> list = new ArrayList<Product>();
		try {
			ResultSet rst = MyConnectDB.chonDuLieu(sql);
			while(rst.next()) {
				String MaTL = rst.getString(1);
				String MaSP = rst.getString(2);
				String TenSP= rst.getNString(3);
				String hinhanh = rst.getString(4);
				int price = rst.getInt(5);
				String thongtin = rst.getNString(6);
				list.add(new Product(MaTL,MaSP,TenSP,hinhanh,price,thongtin));
			}
			cnn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Product> getListbyCategory(String maTL) {
		Connection cnn = MyConnectDB.getConnecttion();
		String sql = "select * from Product where MaTL ='"+maTL+"'";
		List<Product> list = new ArrayList<Product>();
		try {
			ResultSet rst = MyConnectDB.chonDuLieu(sql);
			while(rst.next()) {
				String MaTL = rst.getString(1);
				String MaSP = rst.getString(2);
				String TenSP = rst.getNString(3);
				String hinhanh = rst.getString(4);
				int price = rst.getInt(5);
				String thongtin = rst.getNString(6);
				list.add(new Product(MaTL, MaSP, TenSP, hinhanh, price, thongtin));
			}
			cnn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	//@SuppressWarnings("null")
	@Override
	public Product getProduct(String MaSP) {
		Connection cnn = MyConnectDB.getConnecttion();
		String sql = "select * from Product where MaSP ='"+MaSP+"'";
		Product p = new Product();
		try {
			ResultSet rst = MyConnectDB.chonDuLieu(sql);
			while(rst.next()) {
				p.setMaTL(rst.getString(1));
				p.setMaSP(rst.getString(2));
				p.setTenSP(rst.getNString(3));
				p.setPrice(rst.getInt(5));
				p.setHinhanh(rst.getString(4));
				p.setThongtin(rst.getNString(6));
			}
			cnn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return p;
	}
	
	@Override
	public Product getNameProduct(String TenSP) {
		Connection cnn = MyConnectDB.getConnecttion();
		String sql = "select * from Product where LOWER(TenSP) ='"+TenSP+"'";
		Product p = new Product();
		try {
			ResultSet rst = MyConnectDB.chonDuLieu(sql);
			while(rst.next()) {
				p.setMaTL(rst.getString(1));
				p.setMaSP(rst.getString(2));
				p.setTenSP(rst.getNString(3));
				p.setPrice(rst.getInt(5));
				p.setHinhanh(rst.getString(4));
				p.setThongtin(rst.getNString(6));
			}
			cnn.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return p;
	}
	
	public static void main(String[] args) {
		ProductDAOImpl p = new ProductDAOImpl();
		List<Product> list = p.searchList("dress");
		//Product p1 = p.getListbyCategory(1);
		//int i = 0;
		//for(i=0; i<list.size();i++) {
		//	System.out.println(list.get(6).getTenSP());
		//}
		//Product pr = p.getNameProduct("bikini");
		System.out.println(list.get(0).getMaSP());
	}

	@Override
	public List<Product> searchList(String TenSP) {
		Connection cnn = MyConnectDB.getConnecttion();
		String sql = "select * from [Product] where TenSP LIKE N'%"+TenSP+"%'";
		List<Product> list = new ArrayList<Product>();
		try {
			ResultSet rst = MyConnectDB.chonDuLieu(sql);;
			while (rst.next()) {
				String MaTL = rst.getString("MaTL");
				String MaSP = rst.getString("MaSP");
				String TenSp = rst.getNString("TenSP");
				String hinhanh = rst.getString("hinhanh");
				int price = rst.getInt("price");
				String thongtin = rst.getNString("thongtin");
				list.add(new Product(MaTL, MaSP, TenSp, hinhanh, price, thongtin));
			}
			cnn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	

}
