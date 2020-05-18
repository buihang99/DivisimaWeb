package model;

public class Order {
	private String name;
	private String address;
	private String phone;
	private String user_id;
	
	public Order() {
		super();
	}
	
	public Order(String name, String address, String phone,String user_id) {
		super();
		this.user_id = user_id;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}



	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
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
	
	@Override
	public String toString() {
		return "Order [ name=" + name + ", address=" + address + ", phone=" + phone + "]";
	}
}
