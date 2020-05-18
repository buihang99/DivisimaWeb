package model;

import java.sql.Date;

public class Order_List {
	//private String history_id;
	private String MaSP;
	private int soluong;
	private int price;
	private int order_id;
	
	public Order_List() {
	}
	
	public Order_List(int order_id,String maSP, int soluong, int price) {
		this.order_id = order_id;
		this.MaSP = maSP;
		this.soluong = soluong;
		this.price = price;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getMaSP() {
		return MaSP;
	}
	public void setMaSP(String maSP) {
		MaSP = maSP;
	}
	public int getSoluong() {
		return soluong;
	}
	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}

}
