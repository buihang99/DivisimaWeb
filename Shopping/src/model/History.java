package model;

public class History {
	
	public String order_id;
	public String user_id;
	
	public History(String order_id, String user_id) {
		super();
		this.order_id = order_id;
		this.user_id = user_id;
	}

	public String getOrder_id() {
		return order_id;
	}

	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

}
