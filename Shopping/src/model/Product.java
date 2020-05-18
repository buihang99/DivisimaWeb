package model;

public class Product {
	private String MaSP;
	private String MaTL;
	private String TenSP;
	private String hinhanh;
	private int price;
	private String thongtin;
	
	public Product() {}
	
	public Product(String maTL, String maSP, String tenSP, String hinhanh, int price, String thongtin) {
		this.MaTL = maTL;
		this.MaSP = maSP;
		this.TenSP = tenSP;
		this.hinhanh = hinhanh;
		this.price = price;
		this.thongtin = thongtin;
	}
	public String getMaSP() {
		return MaSP;
	}
	public void setMaSP(String maSP) {
		MaSP = maSP;
	}
	public String getMaTL() {
		return MaTL;
	}
	public void setMaTL(String maTL) {
		MaTL = maTL;
	}
	public String getTenSP() {
		return TenSP;
	}
	public void setTenSP(String tenSP) {
		TenSP = tenSP;
	}
	public String getHinhanh() {
		return hinhanh;
	}
	public void setHinhanh(String hinhanh) {
		this.hinhanh = hinhanh;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getThongtin() {
		return thongtin;
	}
	public void setThongtin(String thongtin) {
		this.thongtin = thongtin;
	}
	
	
}
