package model;

public class NguoiDung {
	
	private String MaNguoiDung;
	private String TaiKhoan;
	private String MatKhau;
	private int PhamViTruyCap;
	private int isDelete;
	public NguoiDung() {
		
	};

	public NguoiDung(String maNguoiDung, String taiKhoan, String matKhau, int phamViTruyCap, int isDelete) {
		MaNguoiDung = maNguoiDung;
		TaiKhoan = taiKhoan;
		MatKhau = matKhau;
		PhamViTruyCap = phamViTruyCap;
		this.isDelete = isDelete;
	}

	public String getMaNguoiDung() {
		return MaNguoiDung;
	}

	public void setMaNguoiDung(String maNguoiDung) {
		MaNguoiDung = maNguoiDung;
	}

	public String getTaiKhoan() {
		return TaiKhoan;
	}

	public void setTaiKhoan(String taiKhoan) {
		TaiKhoan = taiKhoan;
	}

	public String getMatKhau() {
		return MatKhau;
	}

	public void setMatKhau(String matKhau) {
		MatKhau = matKhau;
	}

	public int getPhamViTruyCap() {
		return PhamViTruyCap;
	}

	public void setPhamViTruyCap(int phamViTruyCap) {
		PhamViTruyCap = phamViTruyCap;
	}

	@Override
	public String toString() {
		return "NguoiDung [MaNguoiDung=" + MaNguoiDung + ", TaiKhoan=" + TaiKhoan + ", MatKhau=" + MatKhau
				+ ", PhamViTruyCap=" + PhamViTruyCap + ", isDelete=" + isDelete + "]";
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}

	
	
}
