package model;

public class Category {
	private String MaTL;
	private String TenTL;
	private String Mota;
	
	public Category() {
	}
	
	public Category(String maTL, String tenTL, String mota) {
		this.MaTL = maTL;
		this.TenTL = tenTL;
		this.Mota = mota;
	}

	public String getMaTL() {
		return MaTL;
	}
	public void setMaTL(String maTL) {
		MaTL = maTL;
	}
	public String getTenTL() {
		return TenTL;
	}
	public void setTenTL(String tenTL) {
		TenTL = tenTL;
	}
	public String getMota() {
		return Mota;
	}
	public void setMota(String mota) {
		Mota = mota;
	}
	
}
