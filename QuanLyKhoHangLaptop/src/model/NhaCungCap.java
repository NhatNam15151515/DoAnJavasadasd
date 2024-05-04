package model;

public class NhaCungCap {

	private String MaNhaCungCap;
	private String TenNhaCungCap;
	private String DiaChi;
	private String SDT;
	private String Email;
	private int isDelete;
	
	public NhaCungCap() {
		
	};

	public NhaCungCap(String maNhaCungCap, String tenNhaCungCap, String diaChi, String sDT, String email, int isDelete) {
		MaNhaCungCap = maNhaCungCap;
		TenNhaCungCap = tenNhaCungCap;
		DiaChi = diaChi;
		SDT = sDT;
		Email = email;
		this.isDelete = isDelete;
	}
	public NhaCungCap(String maNhaCungCap, String tenNhaCungCap, String diaChi, String sDT, String email) {
		MaNhaCungCap = maNhaCungCap;
		TenNhaCungCap = tenNhaCungCap;
		DiaChi = diaChi;
		SDT = sDT;
		Email = email;
	}
	public String getMaNhaCungCap() {
		return MaNhaCungCap;
	}

	public void setMaNhaCungCap(String maNhaCungCap) {
		MaNhaCungCap = maNhaCungCap;
	}

	public String getTenNhaCungCap() {
		return TenNhaCungCap;
	}

	public void setTenNhaCungCap(String tenNhaCungCap) {
		TenNhaCungCap = tenNhaCungCap;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}

	public String getSDT() {
		return SDT;
	}

	public void setSDT(String sDT) {
		SDT = sDT;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	@Override
	public String toString() {
		return "NhaCungCap [MaNhaCungCap=" + MaNhaCungCap + ", TenNhaCungCap=" + TenNhaCungCap + ", DiaChi=" + DiaChi
				+ ", SDT=" + SDT + ", Email=" + Email + ", isDelete=" + isDelete + "]";
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	
}