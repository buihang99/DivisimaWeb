package model;

public class DonHang {
	private int order_id;
	private String name;
	private String address;
	private String phone;
	
	public DonHang() {
		
	}
	public DonHang(int order_id, String name, String address, String phone) {
		super();
		this.order_id = order_id;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
}
