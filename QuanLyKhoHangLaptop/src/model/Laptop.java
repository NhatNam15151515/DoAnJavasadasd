package model;

public class Laptop {
	private String MaLaptop;
	private String TenLaptop;;
	private String CPU;
	private String GPU;
	private String Ram;
	private String Rom;
	private String HeDieuHanh;
	private String ManHinh;
	private String Hang;
	private int NamSanXuat;
	private int SoLuong;
	private double Gia;
	private String MaNhaCungCap;
	private int isDelete;
	public Laptop() {
		
	};
	
	public Laptop(String maLaptop, String tenLaptop, String cPU, String gPU, String ram, String rom, String heDieuHanh,
			String manHinh, String hang, int namSanXuat, int soLuong, double gia, String maNhaCungCap, int isDelete) {
		
		MaLaptop = maLaptop;
		TenLaptop = tenLaptop;
		CPU = cPU;
		GPU = gPU;
		Ram = ram;
		Rom = rom;
		HeDieuHanh = heDieuHanh;
		ManHinh = manHinh;
		Hang = hang;
		NamSanXuat = namSanXuat;
		SoLuong = soLuong;
		Gia = gia;
		this.MaNhaCungCap = maNhaCungCap;
		this.isDelete = isDelete;
	}

	public String getMaNhaCungCap() {
		return MaNhaCungCap;
	}

	public void setMaNhaCungCap(String maNhaCungCap) {
		MaNhaCungCap = maNhaCungCap;
	}

	public String getMaLaptop() {
		return MaLaptop;
	}

	public void setMaLaptop(String maLaptop) {
		MaLaptop = maLaptop;
	}

	public String getTenLaptop() {
		return TenLaptop;
	}

	public void setTenLaptop(String tenLaptop) {
		TenLaptop = tenLaptop;
	}

	public String getCPU() {
		return CPU;
	}

	public void setCPU(String cPU) {
		CPU = cPU;
	}

	public String getGPU() {
		return GPU;
	}

	public void setGPU(String gPU) {
		GPU = gPU;
	}

	public String getRam() {
		return Ram;
	}

	public void setRam(String ram) {
		Ram = ram;
	}

	public String getRom() {
		return Rom;
	}

	public void setRom(String rom) {
		Rom = rom;
	}

	public String getHeDieuHanh() {
		return HeDieuHanh;
	}

	public void setHeDieuHanh(String heDieuHanh) {
		HeDieuHanh = heDieuHanh;
	}

	public String getManHinh() {
		return ManHinh;
	}

	public void setManHinh(String manHinh) {
		ManHinh = manHinh;
	}

	public String getHang() {
		return Hang;
	}

	public void setHang(String hang) {
		Hang = hang;
	}

	public int getNamSanXuat() {
		return NamSanXuat;
	}

	public void setNamSanXuat(int namSanXuat) {
		NamSanXuat = namSanXuat;
	}

	public int getSoLuong() {
		return SoLuong;
	}

	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}

	public double getGia() {
		return Gia;
	}

	public void setGia(double gia) {
		Gia = gia;
	}

	@Override
	public String toString() {
		return "Laptop [MaLaptop=" + MaLaptop + ", TenLaptop=" + TenLaptop + ", CPU=" + CPU + ", GPU=" + GPU + ", Ram="
				+ Ram + ", Rom=" + Rom + ", HeDieuHanh=" + HeDieuHanh + ", ManHinh=" + ManHinh + ", Hang=" + Hang
				+ ", NamSanXuat=" + NamSanXuat + ", SoLuong=" + SoLuong + ", Gia=" + Gia + ", MaNhaCungCap="
				+ MaNhaCungCap + ", isDelete=" + isDelete + "]";
	}

	public int getIsDelete() {
		return isDelete;
	}

	public void setIsDelete(int isDelete) {
		this.isDelete = isDelete;
	}
	
	
}
