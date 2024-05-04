package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import database.JDBCUtil;
import model.ChiTietPhieuNhap;
import model.PhieuNhap;

public class PhieuNhapDao implements DAOInterface<PhieuNhap> {
	public static PhieuNhapDao getInstance() {
		return new PhieuNhapDao();
	}

	public int getTotalSoLuong(String ngayNhap) {
	    int total = 0;
	    try {
	        Connection con = JDBCUtil.getConnection();
	        String sql = "SELECT SUM(TongSoLuong) AS Total FROM phieunhap WHERE NgayNhap LIKE ?";
	        PreparedStatement pst = con.prepareStatement(sql);
	        
	        // Chuyển đổi ngày nhập thành ngày SQL
	        String day = convertToDate(ngayNhap);
	        pst.setString(1,"%"+day+"%");
	        ResultSet rs = pst.executeQuery();
	        if (rs.next()) {
	            total = rs.getInt("Total");
	        }
	        con.close();
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	    return total;
	}

	public double getTotalTongTien(String ngayNhap) {
	    double total = 0.0;
	    try {
	        Connection con = JDBCUtil.getConnection();
	        String sql = "SELECT SUM(TongTien) AS Total FROM phieunhap WHERE NgayNhap LIKE ?";
	        PreparedStatement pst = con.prepareStatement(sql);
	        
	        // Chuyển đổi ngày nhập thành ngày SQL
	        String day = convertToDate(ngayNhap);
	        pst.setString(1,"%"+day+"%");
	        ResultSet rs = pst.executeQuery();
	        if (rs.next()) {
	            total = rs.getDouble("Total");

	        }
	        con.close();
	    } catch (Exception e) {
	        System.out.println(e);
	    }
	    return total;
	}

	// Phương thức chuyển đổi chuỗi ngày thành java.sql.Date
	private String convertToDate(String ngayXuat) {
		String[] day = ngayXuat.split("/");
		StringBuilder newDay = new StringBuilder();
		for (int i = day.length - 1; i >= 0; i--) {
			newDay.append(day[i]);
			if (i != 0) {
				newDay.append("-");
			}
		}
		return newDay.toString();
	}





	public void inchitietphieu(ChiTietPhieuNhap t) {
		try {
			Connection con = JDBCUtil.getConnection();
//			System.out.println(t.toString());
			String sql = "INSERT INTO chitietphieunhap(MaPhieuNhap,MaLapTop,SoLuong,ThanhTien,isDelete)\r\n"
					+ "VALUES (?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getMaPhieuNhap());
			pst.setString(2, t.getMaLaptop());
			pst.setInt(3, t.getSoLuong());
			pst.setDouble(4, t.getThanhTien());
			pst.setLong(5, t.getIsDelete());
			pst.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int delete(String t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<ChiTietPhieuNhap> laydulieutuphieu(String masp) {
		ArrayList<ChiTietPhieuNhap> ketqua = new ArrayList<ChiTietPhieuNhap>();
//		ChiTietPhieuNhap ct=null;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "SELECT * FROM chitietphieunhap WHERE  MaPhieuNhap = '" + masp + "'";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery(sql);
			while (rs.next()) {
				String mpn = rs.getString("MaPhieuNhap");
				String masanp = rs.getString("MaLaptop");
				Integer sl = rs.getInt("SoLuong");
				Double thanhtien = Double.parseDouble(rs.getString("ThanhTien"));
				ChiTietPhieuNhap cto = new ChiTietPhieuNhap(mpn, masanp, sl, thanhtien, 0);
				ketqua.add(cto);
			}
//		BƯỚC 5: NGẮT KẾT NỐI
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketqua;
	}

	public void deletetheoma(String masp) {
		try {
			Connection con = JDBCUtil.getConnection();
			Statement st = con.createStatement();
			Statement st1 = con.createStatement();
			String sql = "UPDATE phieunhap" + " SET " + " isDelete='" + 1 + "" + "'" + " WHERE MaPhieuNhap='" + masp
					+ "'";
			String sql1 = "UPDATE chitietphieunhap" + " SET " + " isDelete='" + 1 + "" + "'" + " WHERE MaPhieuNhap='"
					+ masp + "'";
			st.executeUpdate(sql);
			st1.execute(sql1);
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<PhieuNhap> selectAll() {
		ArrayList<PhieuNhap> ketqua = new ArrayList<PhieuNhap>();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "SELECT * FROM phieunhap WHERE  isDelete = 0";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery(sql);
			while (rs.next()) {
				String mpn = rs.getString("MaPhieuNhap");
				String mncc = rs.getString("MaNhaCungCap");
				String tt = rs.getString("TongTien");
				int tongsl = rs.getInt("TongSoLuong");
				Date nn = rs.getDate("NgayNhap");
				String mnv = rs.getString("MaNhanVien");
				String xoa = rs.getString("isDelete");
				DecimalFormat df2 = new DecimalFormat("#");
				String formattedNumber2 = df2.format(Double.parseDouble(tt));
				PhieuNhap sp = new PhieuNhap(mpn, mncc, mnv, Double.parseDouble(formattedNumber2),tongsl, nn,
						Integer.parseInt(xoa));
				ketqua.add(sp);
			}
//		BƯỚC 5: NGẮT KẾT NỐI
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketqua;
	}

	public String laytennhacungcap(String manhacc) {
		String s = null;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "SELECT * FROM nhacungcap WHERE  MaNhaCungCap='" + manhacc + "'";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery(sql);
			while (rs.next()) {
				s = rs.getString("TenNhaCungCap");
			}
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

	public String laymanhacungcap(String manhacc) {
		String s = null;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "SELECT * FROM nhacungcap WHERE  TenNhaCungCap='" + manhacc + "'";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery(sql);
			while (rs.next()) {
				s = rs.getString("MaNhaCungCap");
			}
			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}

//	public String laytennhanvien(String manhanv) {
//		String s=null;
//		try {
//			Connection con=JDBCUtil.getConnection();
//			String sql="SELECT * FROM nhanvien WHERE  MaNhanVien='" + manhanv + "'";
//			PreparedStatement pst=con.prepareStatement(sql);
//			ResultSet rs=pst.executeQuery(sql);
//			while(rs.next()) {
//				s=rs.getString("TenNhanVien");
//			}
//			JDBCUtil.closeConnection(con);
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return s;
//	}
//	
//	public String laymanhanvien(String manhanv) {
//		String s=null;
//		try {
//			Connection con=JDBCUtil.getConnection();
//			String sql="SELECT * FROM nhanvien WHERE  TenNhanVien='" + manhanv + "'";
//			PreparedStatement pst=con.prepareStatement(sql);
//			ResultSet rs=pst.executeQuery(sql);
//			while(rs.next()) {
//				s=rs.getString("MaNhanVien");
//			}
//			JDBCUtil.closeConnection(con);
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return s;
//	}

//	public ArrayList<String> Layalltennv() {
//		ArrayList<String> ketqua=new ArrayList<String>();
//		try {
//			Connection con=JDBCUtil.getConnection();
//			String sql="SELECT TenNhanVien FROM nhanvien";
//			PreparedStatement pst=con.prepareStatement(sql);
//		ResultSet rs=pst.executeQuery(sql);
//		while(rs.next()) {
//			String tnv=rs.getString("TenNhanVien");
//			ketqua.add(tnv);
//		}
////		BƯỚC 5: NGẮT KẾT NỐI
//		JDBCUtil.closeConnection(con);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return ketqua;
//	}

	@Override
	public PhieuNhap selectById(PhieuNhap t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PhieuNhap selectById(String T) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<PhieuNhap> selectByCondition(String condition) {
		return null;
//		ArrayList<NhaCungCap> ketqua=new ArrayList<NhaCungCap>();
//		try {
//			Connection con=JDBCUtil.getConnection();
//			String sql="SELECT * FROM nhacungcap";
//			PreparedStatement pst=con.prepareStatement(sql);
//		ResultSet rs=pst.executeQuery(sql);
//		while(rs.next()) {
//			String mncc=rs.getString("MaNhaCungCap");
//			String tm=rs.getString("TenNhaCungCap");
//			String dc=rs.getString("DiaChi");
//			String sdt=rs.getString("SDT");
//			String em=rs.getString("Email");
//			NhaCungCap sp=new NhaCungCap(mncc,tm,dc,sdt,em);
//			ketqua.add(sp);
//		}
////		BƯỚC 5: NGẮT KẾT NỐI
//		JDBCUtil.closeConnection(con);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return ketqua;
	}

	@Override
	public int insert(PhieuNhap t) {
		int ketqua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "INSERT INTO phieunhap(MaPhieuNhap,MaNhaCungCap,TongTien,NgayNhap,MaNhanVien,isDelete)\r\n"
					+ "VALUES (?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getMaPhieuNhap());
			pst.setString(2, t.getMaNhaCungCap());
			pst.setDouble(3, t.getTongTien());
			pst.setDate(4, t.getNgayNhap());
			pst.setString(5, t.getMaNhanVien());
			pst.setLong(6, t.getIsDelete());
			ketqua = pst.executeUpdate();
			// BƯỚC 4 XỬ LÝ KẾT QUẢ
			System.out.println("BẠN ĐÃ THỰC THI : " + sql);
			System.out.println("Số dòng thay đổi: " + ketqua);
			if (ketqua > 0)
				System.out.println("Thêm dữ liệu thành công");
			else
				System.out.println("Thêm dữ liệu thất bại");
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public int update(PhieuNhap t) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(PhieuNhap t) {
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<String> selectDay() {
		ArrayList<String> firstDay = new ArrayList<String>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		try {
			con = JDBCUtil.getConnection();
			String sql = "SELECT DISTINCT NgayNhap AS Day FROM phieunhap ORDER BY NgayNhap ASC";
			pst = con.prepareStatement(sql);
			rs = pst.executeQuery();

			while (rs.next()) {
				Date Date = rs.getDate("Day");
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				firstDay.add(sdf.format(Date));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return firstDay;
	}

}
