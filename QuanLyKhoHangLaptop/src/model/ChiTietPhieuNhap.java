package model;

public class ChiTietPhieuNhap {
	
	private String MaPhieuNhap;
	private String MaLaptop;
	private int SoLuong;
	private Double ThanhTien;
	private int isDelete;
	
	
	public ChiTietPhieuNhap() {
		
	}
	public ChiTietPhieuNhap(String maPhieuNhap, String maLaptop, int soLuong, Double thanhTien, int isDelete) {
		MaPhieuNhap = maPhieuNhap;
		MaLaptop = maLaptop;
		SoLuong = soLuong;
		ThanhTien = thanhTien;
		this.isDelete = isDelete;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	

	

	public Double getThanhTien() {
		return ThanhTien;
	}

	public void setThanhTien(Double thanhTien) {
		ThanhTien = thanhTien;
	}

	public String getMaPhieuNhap() {
		return MaPhieuNhap;
	}

	public void setMaPhieuNhap(String maPhieuNhap) {
		MaPhieuNhap = maPhieuNhap;
	}

	public String getMaLaptop() {
		return MaLaptop;
	}

	public void setMaLaptop(String maLaptop) {
		MaLaptop = maLaptop;
	}

	public int getSoLuong() {
		return SoLuong;
	}

	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}

	@Override
	public String toString() {
		return "ChiTietPhieuNhap [MaPhieuNhap=" + MaPhieuNhap + ", MaLaptop=" + MaLaptop + ", SoLuong=" + SoLuong
				+ ", ThanhTien=" + ThanhTien + ", isDelete=" + isDelete + "]";
	}
	
	
}
