package model;

public class DoanhSo {
	private String MaSP;
	private String TenSP;
	private int soluong;
	private int thanhtien;
	
	public DoanhSo() {
		
	}
	
	public DoanhSo(String maSP, String tenSP, int soluong, int thanhtien) {
		this.MaSP = maSP;
		this.TenSP = tenSP;
		this.soluong = soluong;
		this.thanhtien = thanhtien;
	}

	public String getMaSP() {
		return MaSP;
	}

	public void setMaSP(String maSP) {
		MaSP = maSP;
	}

	public String getTenSP() {
		return TenSP;
	}

	public void setTenSP(String tenSP) {
		TenSP = tenSP;
	}

	public int getSoluong() {
		return soluong;
	}

	public void setSoluong(int soluong) {
		this.soluong = soluong;
	}

	public int getThanhtien() {
		return thanhtien;
	}

	public void setThanhtien(int thanhtien) {
		this.thanhtien = thanhtien;
	}
}
