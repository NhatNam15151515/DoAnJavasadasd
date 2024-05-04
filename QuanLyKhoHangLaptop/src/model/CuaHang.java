
package model;

public class CuaHang {
	
	private String MaCH;
	private String TenCH;
	private String DiaChi;
	private String SDT;
	private int isDelete;
	
	public CuaHang() {
		
	}

	public CuaHang(String MaCH, String TenCH, String DiaChi, String SDT, int isDelete) {
		this.MaCH = MaCH;
		this.TenCH = TenCH;
		this.DiaChi = DiaChi;
		this.SDT = SDT;
		this.isDelete = isDelete;
	}

	public String getMaCH() {
		return this.MaCH;
	}

	public void setMaCH(String MaCH) {
		this.MaCH = MaCH;
	}

	public String getTenCH() {
		return this.TenCH;
	}

	public void setTenCH(String TenCH) {
		this.TenCH = TenCH;
	}

	public String getDiaChi() {
		return this.DiaChi;
	}

	public void setDiaChi(String DiaChi) {
		this.DiaChi = DiaChi;
	}

	public String getSDT() {
		return this.SDT;
	}

	public void setSDT(String SDT) {
		this.SDT = SDT;
	}
	public void Update(String MaCH, String TenCH, String DiaChi, String SDT) {
		this.MaCH = MaCH;
		this.TenCH = TenCH;
		this.DiaChi = DiaChi;
		this.SDT = SDT;
	}
	@Override
	public String toString() {
		return "CuaHang [MaCH=" + MaCH + ", TenCH=" + TenCH + ", DiaChi=" + DiaChi + ", SDT=" + SDT + ", isDelete="
				+ isDelete + "]";
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
		
	
}
