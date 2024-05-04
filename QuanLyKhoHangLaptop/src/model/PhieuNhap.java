package model;

import java.sql.Date;

public class PhieuNhap {

	private String MaPhieuNhap;
	private String MaNhaCungCap;
	private String MaNhanVien;
	private double TongTien;
	private int TongSoLuong;
	private Date NgayNhap;
	private int isDelete;
	
	public PhieuNhap() {
		
	};

	public PhieuNhap(String maPhieuNhap, String maNhaCungCap, String maNhanVien, double tongTien,int TongSoLuong ,Date ngayNhap, int isDelete) {
		MaPhieuNhap = maPhieuNhap;
		MaNhaCungCap = maNhaCungCap;
		MaNhanVien = maNhanVien;
		TongTien = tongTien;
		this.TongSoLuong=TongSoLuong;
		NgayNhap = ngayNhap;
		this.isDelete = isDelete;
	}
	
	public int getTongSoLuong() {
		return TongSoLuong;
	}

	public void setTongSoLuong(int tongSoLuong) {
		TongSoLuong = tongSoLuong;
	}

	public String getMaPhieuNhap() {
		return MaPhieuNhap;
	}

	public void setMaPhieuNhap(String maPhieuNhap) {
		MaPhieuNhap = maPhieuNhap;
	}

	public String getMaNhaCungCap() {
		return MaNhaCungCap;
	}

	public void setMaNhaCungCap(String maNhaCungCap) {
		MaNhaCungCap = maNhaCungCap;
	}

	public String getMaNhanVien() {
		return MaNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		MaNhanVien = maNhanVien;
	}

	public double getTongTien() {
		return TongTien;
	}

	public void setTongTien(double tongTien) {
		TongTien = tongTien;
	}

	public Date getNgayNhap() {
		return NgayNhap;
	}

	public void setNgayNhap(Date ngayNhap) {
		NgayNhap = ngayNhap;
	}

	@Override
	public String toString() {
		return "PhieuNhap [MaPhieuNhap=" + MaPhieuNhap + ", MaNhaCungCap=" + MaNhaCungCap + ", MaNhanVien=" + MaNhanVien
				+ ", TongTien=" + TongTien + ", NgayNhap=" + NgayNhap + ", isDelete=" + isDelete + "]";
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	};
	
	
}
