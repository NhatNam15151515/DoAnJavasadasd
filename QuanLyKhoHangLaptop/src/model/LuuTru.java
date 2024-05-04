package model;

public class LuuTru {
	private String IMEI;
	private String MaPhieuNhap;
	private int isDelete;
	public LuuTru() {
		
	}
	
	public LuuTru(String iMEI, String maPhieuNhap, int isDelete) {
		IMEI = iMEI;
		MaPhieuNhap = maPhieuNhap;
		this.isDelete = isDelete;
	}


	public String getIMEI() {
		return IMEI;
	}
	public void setIMEI(String iMEI) {
		IMEI = iMEI;
	}
	
	@Override
	public String toString() {
		return "LuuTru [IMEI=" + IMEI + ", MaPhieuNhap=" + MaPhieuNhap + ", isDelete=" + isDelete + "]";
	}

	public String getMaPhieuNhap() {
		return MaPhieuNhap;
	}
	public void setMaPhieuNhap(String maPhieuNhap) {
		MaPhieuNhap = maPhieuNhap;
	}
	public int getIsDelete() {
		return isDelete;
	}
	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	
}
