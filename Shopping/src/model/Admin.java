package model;

public class Admin {
	private String admin_id;
	private String name;
	private String pass;
	
	public Admin() {
	}
	
	public Admin(String name, String pass, String admin_id) {
		this.admin_id = admin_id;
		this.name = name;
		this.pass = pass;
	}
	
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "Admin [admin_id=" + admin_id + ", name=" + name + ", pass=" + pass + "]";
	}

	

}
