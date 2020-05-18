package DAO;

import java.util.List;

import model.Product;

public interface ProductDAO {
	public void addProduct(Product p);
	
	public void deleteProduct(String maSP);
	
	public void updateProduct(Product p);
	
	public List<Product> getList();
	
	public List<Product> getListbyCategory(String MaTL);
	
	public Product getProduct(String MaSP);
	
	public List<Product> searchList(String TenSP);

	public Product getNameProduct(String TenSP);
	
}
