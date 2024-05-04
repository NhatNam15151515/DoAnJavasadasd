package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import database.JDBCUtil;
import model.NhaCungCap;
public class nhacungcapDao implements DAOInterface<NhaCungCap>{
	public static nhacungcapDao getInstance() {
		return new nhacungcapDao();
	}

public NhaCungCap chon1nhacc(String tennc) {
		NhaCungCap ketqua=null;
		try {
//		BƯỚC 1: TẠO KẾT NỐI ĐẾN CSDL
			Connection con=JDBCUtil.getConnection();
//		BƯỚC 2: TẠO RA ĐỐI TƯỢNG STATEMENT
			String sql="SELECT * FROM nhacungcap WHERE TenNhaCungCap='"+tennc+"'";
			PreparedStatement pst=con.prepareStatement(sql);
//		BƯỚC 3: THỰC THI CÂU LỆNH SQL
//		System.out.println(sql);
		ResultSet rs=pst.executeQuery(sql);
		// BƯỚC 4 XỬ LÝ KẾT QUẢ
//		String manhacungcap, String tennhacungcap, String diachi, String sdt, String email
		while(rs.next()) {
			String mncc=rs.getString("MaNhaCungCap");
			String tm=rs.getString("TenNhaCungCap");
			String dc=rs.getString("DiaChi");
			String sdt=rs.getString("SDT");
			String em=rs.getString("Email");
			ketqua=new NhaCungCap(mncc,tm,dc,sdt,em);
		}
//		BƯỚC 5: NGẮT KẾT NỐI
		JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketqua;
	}
	
	@Override
	public int insert(NhaCungCap t) {
		int ketqua=0;
		try {
			// TODO Auto-generated method stub
//		BƯỚC 1: TẠO KẾT NỐI ĐẾN CSDL
			Connection con=JDBCUtil.getConnection();
			
//		BƯỚC 2: TẠO RA ĐỐI TƯỢNG STATEMENT
			String sql="INSERT INTO nhacungcap(MaNhaCungCap,TenNhaCungCap,DiaChi,SDT,Email)\r\n"
					+ "VALUES (?,?,?,?,?)";
			PreparedStatement pst=con.prepareStatement(sql);
			pst.setString(1,t.getMaNhaCungCap());
			pst.setString(2,t.getTenNhaCungCap());
			pst.setString(3,t.getDiaChi());
			pst.setString(4,t.getSDT());
			pst.setString(5, t.getEmail());
//		BƯỚC 3: THỰC THI CÂU LỆNH SQL
		ketqua=pst.executeUpdate();
		// BƯỚC 4 XỬ LÝ KẾT QUẢ
		System.out.println("BẠN ĐÃ THỰC THI : "+sql);
		System.out.println("Số dòng thay đổi: "+ketqua);
		if(ketqua>0) System.out.println("Thêm dữ liệu thành công");
		else System.out.println("Thêm dữ liệu thất bại");
		
		
//		BƯỚC 5: NGẮT KẾT NỐI
		JDBCUtil.closeConnection(con);
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public int update(NhaCungCap t) {
		// TODO Auto-generated method stub
		int ketqua=0;
		try {
			// TODO Auto-generated method stub
//		BƯỚC 1: TẠO KẾT NỐI ĐẾN CSDL
			Connection con=JDBCUtil.getConnection();
			
//		BƯỚC 2: TẠO RA ĐỐI TƯỢNG STATEMENT
			Statement st=con.createStatement();
			String sql="UPDATE nhacungcap"+
					" SET " +
					" MaNhaCungCap='"+ t.getMaNhaCungCap()+"'"+
					", TenNhaCungCap='"+ t.getTenNhaCungCap()+"'"+
					", DiaChi='"+ t.getDiaChi()+"'"+
					", SDT='"+ t.getSDT()+"'"+
					", Email='"+ t.getEmail()+"'"+
					" WHERE MaNhaCungCap='"+ t.getMaNhaCungCap()+"'";

//		BƯỚC 3: THỰC THI CÂU LỆNH SQL
		ketqua=st.executeUpdate(sql);
		// BƯỚC 4 XỬ LÝ KẾT QUẢ
		System.out.println("BẠN ĐÃ THỰC THI : "+sql);
		System.out.println("Số dòng thay đổi: "+ketqua);
		if(ketqua>0) System.out.println("Thêm dữ liệu thành công");
		else System.out.println("Thêm dữ liệu thất bại");
		
		
//		BƯỚC 5: NGẮT KẾT NỐI
		JDBCUtil.closeConnection(con);
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketqua;
	}

	public int delete1(NhaCungCap t) {
		// TODO Auto-generated method stub
				int ketqua=0;
				try {
					// TODO Auto-generated method stub
//				BƯỚC 1: TẠO KẾT NỐI ĐẾN CSDL
					Connection con=JDBCUtil.getConnection();
					
//				BƯỚC 2: TẠO RA ĐỐI TƯỢNG STATEMENT
					Statement st=con.createStatement();
					String sql="DELETE from nhacungcap"+
							" WHERE MaNhaCungCap='"+t.getMaNhaCungCap()+"'";
		
//				BƯỚC 3: THỰC THI CÂU LỆNH SQL
				ketqua=st.executeUpdate(sql);
				// BƯỚC 4 XỬ LÝ KẾT QUẢ
				System.out.println("BẠN ĐÃ THỰC THI : "+sql);
				System.out.println("Số dòng thay đổi: "+ketqua);
				if(ketqua>0) System.out.println("Thêm dữ liệu thành công");
				else System.out.println("Thêm dữ liệu thất bại");
				
				
//				BƯỚC 5: NGẮT KẾT NỐI
				JDBCUtil.closeConnection(con);
						
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return ketqua;
	}

	@Override
	public ArrayList<NhaCungCap> selectAll() {
		ArrayList<NhaCungCap> ketqua=new ArrayList<NhaCungCap>();
		try {
//		BƯỚC 1: TẠO KẾT NỐI ĐẾN CSDL
			Connection con=JDBCUtil.getConnection();
//		BƯỚC 2: TẠO RA ĐỐI TƯỢNG STATEMENT
			String sql="SELECT * FROM nhacungcap";
			PreparedStatement pst=con.prepareStatement(sql);
//		BƯỚC 3: THỰC THI CÂU LỆNH SQL
//		System.out.println(sql);
		ResultSet rs=pst.executeQuery(sql);
		// BƯỚC 4 XỬ LÝ KẾT QUẢ
//		String manhacungcap, String tennhacungcap, String diachi, String sdt, String email
		while(rs.next()) {
			String mncc=rs.getString("MaNhaCungCap");
			String tm=rs.getString("TenNhaCungCap");
			String dc=rs.getString("DiaChi");
			String sdt=rs.getString("SDT");
			String em=rs.getString("Email");
			NhaCungCap sp=new NhaCungCap(mncc,tm,dc,sdt,em);
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

	public NhaCungCap selectById1(NhaCungCap t) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<NhaCungCap> selectByCondition(String condition) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int delete(String t) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public NhaCungCap selectById(String T) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(NhaCungCap t) {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public NhaCungCap selectById(NhaCungCap t) {
		// TODO Auto-generated method stub
		return null;
	}


	
	
	
}
