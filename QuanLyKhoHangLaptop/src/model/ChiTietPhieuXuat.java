package model;

public class ChiTietPhieuXuat {

	private String MaPhieuXuat;
	private String MaLaptop;
	private int SoLuong;
	private Double ThanhTien;
	private int isDelete;
	public ChiTietPhieuXuat() {
		
	}

	public ChiTietPhieuXuat(String maPhieuXuat, String maLaptop, int soLuong, Double thanhTien, int isDelete) {
		MaPhieuXuat = maPhieuXuat;
		MaLaptop = maLaptop;
		SoLuong = soLuong;
		this.ThanhTien = thanhTien;
		this.isDelete = isDelete;
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	public String getMaPhieuXuat() {
		return MaPhieuXuat;
	}

	public Double getThanhTien() {
		return ThanhTien;
	}

	public void setThanhTien(Double thanhTien) {
		ThanhTien = thanhTien;
	}

	public void setMaPhieuXuat(String maPhieuXuat) {
		MaPhieuXuat = maPhieuXuat;
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
		return "ChiTietPhieuXuat [MaPhieuXuat=" + MaPhieuXuat + ", MaLaptop=" + MaLaptop + ", SoLuong=" + SoLuong
				+ ", ThanhTien=" + ThanhTien + ", isDelete=" + isDelete + "]";
	}
	
	
}
