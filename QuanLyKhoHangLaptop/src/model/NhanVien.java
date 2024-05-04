package model;

import java.sql.Date;

public class NhanVien {

	private String MaNhanVien;
	private String TenNhanVien;
	private Date NgaySinh;
	private int GioiTinh;
	private String SDT;
	private String MaNguoiDung;
	private int isDelete;
	
	public NhanVien() {
		
	};

	public NhanVien(String maNhanVien, String tenNhanVien, Date ngaySinh, int gioiTinh, String sDT,
			 String maNguoiDung, int isDelete) {
		
		MaNhanVien = maNhanVien;
		TenNhanVien = tenNhanVien;
		NgaySinh = ngaySinh;
		GioiTinh = gioiTinh;
		SDT = sDT;
		MaNguoiDung = maNguoiDung;
		this.isDelete =isDelete;
	}

	public String getMaNhanVien() {
		return MaNhanVien;
	}

	public void setMaNhanVien(String maNhanVien) {
		MaNhanVien = maNhanVien;
	}

	public String getTenNhanVien() {
		return TenNhanVien;
	}

	public void setTenNhanVien(String tenNhanVien) {
		TenNhanVien = tenNhanVien;
	}

	public Date getNgaySinh() {
		return NgaySinh;
	}

	public void setNgaySinh(Date ngaySinh) {
		NgaySinh = ngaySinh;
	}

	public int getGioiTinh() {
		return GioiTinh;
	}

	public void setGioiTinh(int gioiTinh) {
		GioiTinh = gioiTinh;
	}

	

	public String getSDT() {
		return SDT;
	}

	public void setSDT(String sDT) {
		SDT = sDT;
	}

	

	public String getMaNguoiDung() {
		return MaNguoiDung;
	}

	public void setMaNguoiDung(String maNguoiDung) {
		MaNguoiDung = maNguoiDung;
	}

	@Override
	public String toString() {
		return "NhanVien [MaNhanVien=" + MaNhanVien + ", TenNhanVien=" + TenNhanVien + ", NgaySinh=" + NgaySinh
				+ ", GioiTinh=" + GioiTinh + ", SDT=" + SDT + ", MaNguoiDung=" + MaNguoiDung
				+ ", isDelete=" + isDelete + "]";
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	
	public void setNgaySinh(int day, int month, int year)
	{
		long milliseconds = Date.valueOf(year + "-" + (month + 1) + "-" + day).getTime();
        
        // Tạo đối tượng Date từ số mili giây đã tính được
        Date date = new Date(milliseconds);
        NgaySinh = date;
	}

	public void setNgaySinh(String ngaysinh)
	{
		 NgaySinh = Date.valueOf(ngaysinh);
	}

	public static void main(String[] args) {
		NhanVien nv = new NhanVien();
		nv.setNgaySinh(12,2,2004);
		System.out.println(nv.NgaySinh.toString());
	}
}
