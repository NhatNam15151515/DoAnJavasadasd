package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import database.JDBCUtil;
import model.NguoiDung;
import model.NhanVien;
import view.TaiKhoanView;

public class NguoiDungDAO implements DAOInterface<NguoiDung>{

	public static NguoiDungDAO getintance() {
		return new NguoiDungDAO();
	}
	
	
	
	public boolean KetHopNguoiDungVaNhanVien()
	{
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Chọn vị trí lưu tệp Excel");
		fileChooser.setFileFilter(new FileNameExtensionFilter("Excel files", "xlsx"));

		int userSelection = fileChooser.showSaveDialog(null);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			String filePath = fileChooser.getSelectedFile().getAbsolutePath();
			if (!filePath.toLowerCase().endsWith(".xlsx")) {
				filePath += ".xlsx";
			}

			try (XSSFWorkbook wordbook = new XSSFWorkbook()) 
			{
				try {

						XSSFSheet sheet = wordbook.createSheet("DanhSachThongTinTaiKhoan");
						XSSFRow row = null;
						Cell cell = null;
						row = sheet.createRow(0);
						cell = row.createCell(0,CellType.STRING);
						cell.setCellValue("MaNhanVien");
						cell = row.createCell(1,CellType.STRING);
						cell.setCellValue("HoTen");
						cell = row.createCell(2,CellType.STRING);
						cell.setCellValue("NgaySinh");
						cell = row.createCell(3, CellType.STRING);
						cell.setCellValue("GioiTinh");
						cell = row.createCell(4,CellType.STRING);
						cell.setCellValue("SDT");
						cell = row.createCell(5,CellType.STRING);
						cell.setCellValue("MaTaiKhoan");
						cell = row.createCell(6,CellType.STRING);
						cell.setCellValue("TaiKhoan");
						cell = row.createCell(7,CellType.STRING);
						cell.setCellValue("MatKhau");
						cell = row.createCell(8,CellType.STRING);
						cell.setCellValue("QuyenTruyCap");
						ArrayList<NhanVien> nv = NhanVienDAO.getintance().selectAll();
						ArrayList<NguoiDung> nd = NguoiDungDAO.getintance().selectAll();
						int count = 1;
						for (int i = 0; i < nd.size();i++) {
							if(nd.get(i).getPhamViTruyCap()==1)
							{
								continue;
							}
							row = sheet.createRow(count++);

							cell = row.createCell(0,CellType.STRING);
							cell.setCellValue(nv.get(i).getMaNhanVien());

							cell = row.createCell(1,CellType.STRING);
							cell.setCellValue(nv.get(i).getTenNhanVien());

							cell = row.createCell(2,CellType.STRING);
							cell.setCellValue(nv.get(i).getNgaySinh().toString());

							cell = row.createCell(3,CellType.STRING);
							if(nv.get(i).getGioiTinh()==1)
							{
								cell.setCellValue("nam");
							}
							else if(nv.get(i).getGioiTinh()==0)
							{
								cell.setCellValue("nữ");
							}

							cell = row.createCell(4,CellType.STRING);
							cell.setCellValue(nv.get(i).getSDT());

							cell = row.createCell(5,CellType.STRING);
							cell.setCellValue(nd.get(i).getMaNguoiDung());

							cell = row.createCell(6,CellType.STRING);
							cell.setCellValue(nd.get(i).getTaiKhoan());

							cell = row.createCell(7,CellType.STRING);
							cell.setCellValue(nd.get(i).getMatKhau());

							cell = row.createCell(8,CellType.STRING);
							cell.setCellValue(nd.get(i).getPhamViTruyCap());
						}

					} catch (Exception e) {
						e.printStackTrace();
					}

					try {
						FileOutputStream fos = new FileOutputStream(filePath);
						wordbook.write(fos);
						fos.close();
						return true;
					} catch (Exception e) {
						e.printStackTrace();
						return false;
					}


			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}


	public void UpDateKetHop()
	{
		try (XSSFWorkbook wordbook = new XSSFWorkbook()) 
			{
			try {

				XSSFSheet sheet = wordbook.createSheet("DanhSachThongTinTaiKhoan");
				XSSFRow row = null;
				Cell cell = null;
				row = sheet.createRow(0);
				cell = row.createCell(0,CellType.STRING);
				cell.setCellValue("MaNhanVien");
				cell = row.createCell(1,CellType.STRING);
				cell.setCellValue("HoTen");
				cell = row.createCell(2,CellType.STRING);
				cell.setCellValue("NgaySinh");
				cell = row.createCell(3, CellType.STRING);
				cell.setCellValue("GioiTinh");
				cell = row.createCell(4,CellType.STRING);
				cell.setCellValue("SDT");
				cell = row.createCell(5,CellType.STRING);
				cell.setCellValue("MaTaiKhoan");
				cell = row.createCell(6,CellType.STRING);
				cell.setCellValue("TaiKhoan");
				cell = row.createCell(7,CellType.STRING);
				cell.setCellValue("MatKhau");
				cell = row.createCell(8,CellType.STRING);
				cell.setCellValue("QuyenTruyCap");
				ArrayList<NhanVien> nv = NhanVienDAO.getintance().selectAll();
				ArrayList<NguoiDung> nd = NguoiDungDAO.getintance().selectAll();
				int count = 1;
				for (int i = 0; i < nd.size();i++) {
					if(nd.get(i).getPhamViTruyCap()==1)
					{
						continue;
					}
					row = sheet.createRow(count++);

					cell = row.createCell(0,CellType.STRING);
					cell.setCellValue(nv.get(i).getMaNhanVien());

					cell = row.createCell(1,CellType.STRING);
					cell.setCellValue(nv.get(i).getTenNhanVien());

					cell = row.createCell(2,CellType.STRING);
					cell.setCellValue(nv.get(i).getNgaySinh().toString());

					cell = row.createCell(3,CellType.STRING);
					if(nv.get(i).getGioiTinh()==1)
					{
						cell.setCellValue("nam");
					}
					else if(nv.get(i).getGioiTinh()==0)
					{
						cell.setCellValue("nữ");
					}

					cell = row.createCell(4,CellType.STRING);
					cell.setCellValue(nv.get(i).getSDT());

					cell = row.createCell(5,CellType.STRING);
					cell.setCellValue(nd.get(i).getMaNguoiDung());

					cell = row.createCell(6,CellType.STRING);
					cell.setCellValue(nd.get(i).getTaiKhoan());

					cell = row.createCell(7,CellType.STRING);
					cell.setCellValue(nd.get(i).getMatKhau());

					cell = row.createCell(8,CellType.STRING);
					cell.setCellValue(nd.get(i).getPhamViTruyCap());
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
					try {
						FileOutputStream fos = new FileOutputStream("src/database/DanhSachThongTin.xlsx");
						wordbook.write(fos);
						fos.close();
					} catch (Exception e) {
						e.printStackTrace();
					}

			} catch (IOException e) {
				e.printStackTrace();
			}
	}




	public ArrayList<NguoiDung> ReadExcelKetHop(String filePath)
	{
		ArrayList<NguoiDung> arr = new ArrayList<NguoiDung>();
		if(filePath.endsWith(".xlsx"))
		{
			FileInputStream fis = null;
	        Workbook workbook = null;
	         try {
	             fis = new FileInputStream(filePath);
	             workbook = WorkbookFactory.create(fis);

	             Sheet sheet = workbook.getSheetAt(0);
	             int count = 0;
	             for (Row row : sheet) {
	                 if (count == 0) {
	                     count++;
	                     continue;
	                 }
	                 String ma = row.getCell(5).getStringCellValue();
	                 String tk = row.getCell(6).getStringCellValue();
	                 String mk = row.getCell(7).getStringCellValue();
	                 int phamvi  = (int) row.getCell(8).getNumericCellValue();
	                 int isDelete = 0;

	                 NguoiDung nd = new NguoiDung();
	                 nd.setMaNguoiDung(ma);
	                 nd.setTaiKhoan(tk);
	                 nd.setMatKhau(mk);
	                 nd.setPhamViTruyCap(phamvi);
	                 nd.setIsDelete(isDelete);
	                 arr.add(nd);
	             }
	             workbook.close();
	             fis.close();

	         } catch (Exception e) {
	             e.printStackTrace();
	         }
		}
		return arr;
	}





	public ArrayList<NguoiDung> ReadExcel()
	{
		ArrayList<NguoiDung> arr = new ArrayList<NguoiDung>();
		JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            String filePath = selectedFile.getAbsolutePath();
			String fileName = selectedFile.getName();
			if(fileName.endsWith(".xlsx"))
			{
				FileInputStream fis = null;
		        Workbook workbook = null;
		         try {
		             fis = new FileInputStream(new File(filePath));
		             workbook = WorkbookFactory.create(fis);

		             Sheet sheet = workbook.getSheetAt(0);
		             int count = 0;
		             for (Row row : sheet) {
		                 if (count == 0) {
		                     count++;
		                     continue;
		                 }
		                 String ma = row.getCell(0).getStringCellValue();
		                 String tk = row.getCell(1).getStringCellValue();
		                 String mk = row.getCell(2).getStringCellValue();
		                 int phamvi  = (int) row.getCell(3).getNumericCellValue();
		                 int isDelete = (int) row.getCell(4).getNumericCellValue();

		                 NguoiDung nd = new NguoiDung();
		                 nd.setMaNguoiDung(ma);
		                 nd.setTaiKhoan(tk);
		                 nd.setMatKhau(mk);
		                 nd.setPhamViTruyCap(phamvi);
		                 nd.setIsDelete(isDelete);
		                 arr.add(nd);
		             }
		             workbook.close();
		             fis.close();
		         } catch (Exception e) {
		             e.printStackTrace();
		         }
			}
        }
        return arr;
	}



	public boolean WriteExcel()
	{
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Chọn vị trí lưu tệp Excel");
		fileChooser.setFileFilter(new FileNameExtensionFilter("Excel files", "xlsx"));

		int userSelection = fileChooser.showSaveDialog(null);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			String filePath = fileChooser.getSelectedFile().getAbsolutePath();
			if (!filePath.toLowerCase().endsWith(".xlsx")) {
				filePath += ".xlsx";
			}

			try (XSSFWorkbook wordbook = new XSSFWorkbook()) 
			{
				try {

						XSSFSheet sheet = wordbook.createSheet("DanhSachNguoiDung");
						XSSFRow row = null;
						Cell cell = null;
						row = sheet.createRow(0);
						cell = row.createCell(0,CellType.STRING);
						cell.setCellValue("MaNguoiDung");
						cell = row.createCell(1,CellType.STRING);
						cell.setCellValue("TaiKhoan");
						cell = row.createCell(2,CellType.STRING);
						cell.setCellValue("MatKhau");
						cell = row.createCell(3, CellType.NUMERIC);
						cell.setCellValue("PhamViTruyCap");
						cell = row.createCell(4,CellType.NUMERIC);
						cell.setCellValue("isDelete");


						ArrayList<NguoiDung> nd = NguoiDungDAO.getintance().selectAll();
						for (int i = 0; i < nd.size();i++) {
							row = sheet.createRow(i+1);

							cell = row.createCell(0,CellType.STRING);
							cell.setCellValue(nd.get(i).getMaNguoiDung());

							cell = row.createCell(1,CellType.STRING);
							cell.setCellValue(nd.get(i).getTaiKhoan());

							cell = row.createCell(2,CellType.STRING);
							cell.setCellValue(nd.get(i).getMatKhau());

							cell = row.createCell(3,CellType.STRING);
							cell.setCellValue(nd.get(i).getPhamViTruyCap());

							cell = row.createCell(4,CellType.STRING);
							cell.setCellValue(nd.get(i).getIsDelete());
						}

					} catch (Exception e) {
						e.printStackTrace();
					}

					try {
						FileOutputStream fos = new FileOutputStream(filePath);
						wordbook.write(fos);
						fos.close();
						return true;
					} catch (Exception e) {
						e.printStackTrace();
						return false;
					}


			} catch (IOException e) {
				e.printStackTrace();
				return false;
			}
		}
		return false;
	}


	public void WriteUpDateExcel()
	{
		try (XSSFWorkbook wordbook = new XSSFWorkbook()) 
			{
				try {
					XSSFSheet sheet = wordbook.createSheet("DanhSachNguoiDung");
					XSSFRow row = null;
					Cell cell = null;
					row = sheet.createRow(0);
					cell = row.createCell(0,CellType.STRING);
					cell.setCellValue("MaNguoiDung");
					cell = row.createCell(1,CellType.STRING);
					cell.setCellValue("TaiKhoan");
					cell = row.createCell(2,CellType.STRING);
					cell.setCellValue("MatKhau");
					cell = row.createCell(3, CellType.NUMERIC);
					cell.setCellValue("PhamViTruyCap");
					cell = row.createCell(4,CellType.NUMERIC);
					cell.setCellValue("isDelete");


					ArrayList<NguoiDung> nd = NguoiDungDAO.getintance().selectAll();
					for (int i = 0; i < nd.size();i++) {
						row = sheet.createRow(i+1);

						cell = row.createCell(0,CellType.STRING);
						cell.setCellValue(nd.get(i).getMaNguoiDung());

						cell = row.createCell(1,CellType.STRING);
						cell.setCellValue(nd.get(i).getTaiKhoan());

						cell = row.createCell(2,CellType.STRING);
						cell.setCellValue(nd.get(i).getMatKhau());

						cell = row.createCell(3,CellType.STRING);
						cell.setCellValue(nd.get(i).getPhamViTruyCap());

						cell = row.createCell(4,CellType.STRING);
						cell.setCellValue(nd.get(i).getIsDelete());
					}


					} catch (Exception e) {
						e.printStackTrace();
					}

					try {
						FileOutputStream fos = new FileOutputStream("src/database/DanhSachNguoiDung.xlsx");
						wordbook.write(fos);
						fos.close();
					} catch (Exception e) {
						e.printStackTrace();
					}

			} catch (IOException e) {
				e.printStackTrace();
			}
	}



	@Override
	public int insert(NguoiDung t) {
		int ketqua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "INSERT INTO nguoidung (MaNguoiDung,TaiKhoan,MatKhau,PhamViTruyCap) "+
						" VALUES (?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getMaNguoiDung());
			pst.setString(2, t.getTaiKhoan());
			pst.setString(3, t.getMatKhau());
			pst.setInt(4, t.getPhamViTruyCap());
			ketqua = pst.executeUpdate();
			JDBCUtil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public int update(NguoiDung t) {
		int ketqua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "UPDATE nguoidung "+
						"SET "+
						"MaNguoiDung=?"+
						",TaiKhoan=? "+
						",MatKhau=? "+
						",PhamViTruyCap=? "+
						",isDelete=? "+
						"WHERE MaNguoiDung = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getMaNguoiDung());
			pst.setString(2, t.getTaiKhoan());
			pst.setString(3, t.getMatKhau());
			pst.setInt(4,t.getPhamViTruyCap());
			pst.setInt(5, t.getIsDelete());
			pst.setString(6, t.getMaNguoiDung());
			ketqua = pst.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketqua;
	}

	public int updateByCondition(String MaND, String pass, String newPass) {
		int ketqua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "UPDATE nguoidung "+
						"SET "+
						"MatKhau=? "+
						"WHERE MaNguoiDung = ? and MatKhau= ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, newPass);
			pst.setString(2, MaND);
			pst.setString(3, pass);
			ketqua = pst.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketqua;
	}
	@Override
	public int delete(NguoiDung t) {
		int ketqua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "UPDATE nguoidung "+
						"SET "+
						"isDelete=1 "+
						"WHERE MaNguoiDung= ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1,t.getMaNguoiDung());
			ketqua = pst.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketqua;
	}




	@Override
	public int delete(String t) {
		int ketqua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "UPDATE nguoidung "+
						"SET "+
						"isDelete=1 "+
						"WHERE MaNguoiDung= ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1,t);
			ketqua = pst.executeUpdate();
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public ArrayList<NguoiDung> selectAll() {
		ArrayList<NguoiDung> kq = new ArrayList<NguoiDung>();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select * from nguoidung where isDelete = 0 ";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				String ma = rs.getString("MaNguoiDung");
				String tk = rs.getString("TaiKhoan");
				String mk = rs.getString("MatKhau");
				int phamvi = rs.getInt("PhamViTruyCap");
				int isdelete = rs.getInt("isDelete");
				NguoiDung nd = new NguoiDung();
				nd.setMaNguoiDung(ma);
				nd.setTaiKhoan(tk);
				nd.setMatKhau(mk);
				nd.setPhamViTruyCap(phamvi);
				nd.setIsDelete(isdelete);
				kq.add(nd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public NguoiDung selectById(NguoiDung t) {

		return null;
	}

	@Override
	public NguoiDung selectById(String T) {

		return null;
	}

	@Override
	public ArrayList<NguoiDung> selectByCondition(String condition) {
		return null;
	}
	
	
	public NguoiDung selectByCondition(String nameColumn, String condition) {
		NguoiDung nd = new NguoiDung();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = " select* from nguoidung where "+nameColumn+" like ? and isDelete=0 and PhamViTruyCap=0";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, condition);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				String ma = rs.getString("MaNguoiDung");
				String tk = rs.getString("TaiKhoan");
				String mk = rs.getString("MatKhau");
				int phamvi = rs.getInt("PhamViTruyCap");
				int isdelete = rs.getInt("isDelete");
				nd.setMaNguoiDung(ma);
				nd.setTaiKhoan(tk);
				nd.setMatKhau(mk);
				nd.setPhamViTruyCap(phamvi);
				nd.setIsDelete(isdelete);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nd;
	}
	

	public ArrayList<NguoiDung> selectByCondition() {
		ArrayList<NguoiDung> kq = new ArrayList<NguoiDung>();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select* from nguoidung where isDelete = 0 and PhamViTruyCap = 0";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				String ma = rs.getString("MaNguoiDung");
				String tk = rs.getString("TaiKhoan");
				String mk = rs.getString("MatKhau");
				int phamvi = rs.getInt("PhamViTruyCap");
				int isdelete = rs.getInt("isDelete");
				NguoiDung nd = new NguoiDung();
				nd.setMaNguoiDung(ma);
				nd.setTaiKhoan(tk);
				nd.setMatKhau(mk);
				nd.setPhamViTruyCap(phamvi);
				nd.setIsDelete(isdelete);
				kq.add(nd);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}


	public ArrayList<String> getColumn(String ColumnName)
	{
		ArrayList<String> column = new ArrayList<String>();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select distinct "+ColumnName+" from nguoidung";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				column.add(rs.getString(ColumnName));
			}

			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return column; 
	}

	
	public ArrayList<NguoiDung>select_search(String tmp )
	{
		ArrayList<NguoiDung> kq = new ArrayList<NguoiDung>();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select* from nguoidung where MaNguoiDung like ? and isDelete=0 and PhamViTruyCap=0  or TaiKhoan like ? and isDelete=0 and PhamViTruyCap=0";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, "%"+tmp+"%");
			pst.setString(2, "%"+tmp+"%");
			ResultSet rs = pst.executeQuery();
			while(rs.next())
			{
				String ma = rs.getString("MaNguoiDung");
				String tk = rs.getString("TaiKhoan");
				String mk = rs.getString("MatKhau");
				int phamvi = rs.getInt("PhamViTruyCap");
				int isdelete = rs.getInt("isDelete");
				NguoiDung nd = new NguoiDung();
				nd.setMaNguoiDung(ma);
				nd.setTaiKhoan(tk);
				nd.setMatKhau(mk);
				nd.setPhamViTruyCap(phamvi);
				nd.setIsDelete(isdelete);
				kq.add(nd);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}	
	
	public static void main(String[] args) {
		ArrayList<NguoiDung> nd = NguoiDungDAO.getintance().select_search("");
		for (NguoiDung nguoiDung : nd) {
			System.out.println(nguoiDung.toString());
		}
	}
}