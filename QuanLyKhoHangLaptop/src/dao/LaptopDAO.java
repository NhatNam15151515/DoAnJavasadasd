package dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
import model.Laptop;

public class LaptopDAO implements DAOInterface<Laptop> {

	public static LaptopDAO getintance() {
		return new LaptopDAO();
	}

	// tìm kiếm nâng cao - Nam fixed
	public ArrayList<Laptop> advancedSearch(String condition1, String condition2, String condition3, String condition4,
			String condition5, int giaMin, int giaMax) {
		ArrayList<Laptop> Result = new ArrayList<Laptop>();
		if (condition1.equals("Tất cả"))
			condition1 = "";
		if (condition2.equals("Tất cả"))
			condition2 = "";
		if (condition3.equals("Tất cả"))
			condition3 = "";
		if (condition4.equals("Tất cả"))
			condition4 = "";
		if (condition5.equals("Tất cả"))
			condition5 = "";
		try {
			Connection c = JDBCUtil.getConnection();
			String sql = "SELECT * FROM laptop WHERE HeDieuHanh LIKE ? AND Hang LIKE ? AND CPU LIKE ? AND Ram LIKE ? AND Rom LIKE ? AND Gia BETWEEN ? AND ?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setString(1, "%" + condition1 + "%");
			pst.setString(2, "%" + condition2 + "%");
			pst.setString(3, "%" + condition3 + "%");
			pst.setString(4, "%" + condition4 + "%");
			pst.setString(5, "%" + condition5 + "%");
			pst.setInt(6, +giaMin);
			pst.setInt(7, +giaMax);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String ma = rs.getString("MaLaptop");
				String ten = rs.getString("TenLaptop");
				String cpu = rs.getString("CPU");
				String gpu = rs.getString("GPU");
				String ram = rs.getString("Ram");
				String rom = rs.getString("Rom");
				String hdh = rs.getString("HeDieuHanh");
				String man = rs.getString("ManHinh");
				String hang = rs.getString("Hang");
				int namsx = rs.getInt("NamSanXuat");
				int soluong = rs.getInt("SoLuong");
				double gia = rs.getDouble("Gia");
				String maNCC = rs.getString("MaNhaCungCap");
				int isDelete = rs.getInt("isDelete");
				Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC,
						isDelete);
				Result.add(lt);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return Result;
	}

	// tìm kiếm nâng cao - Nam fixed
	public ArrayList<Laptop> ReadExcel() {
		ArrayList<Laptop> arr = new ArrayList<Laptop>();
		JFileChooser fileChooser = new JFileChooser();
		int result = fileChooser.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			File selectedFile = fileChooser.getSelectedFile();
			String filePath = selectedFile.getAbsolutePath();
			String fileName = selectedFile.getName();
			if (fileName.endsWith(".xlsx")) {
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
						String ten = row.getCell(1).getStringCellValue();
						String CPU = row.getCell(2).getStringCellValue();
						String GPU = row.getCell(3).getStringCellValue();
						String Ram = row.getCell(4).getStringCellValue();
						String Rom = row.getCell(5).getStringCellValue();
						String HeDieuHanh = row.getCell(6).getStringCellValue();
						String ManHinh = row.getCell(7).getStringCellValue();
						String Hang = row.getCell(8).getStringCellValue();
						int NamSX = (int) row.getCell(9).getNumericCellValue();
						Double gia = (Double) row.getCell(10).getNumericCellValue();
						int SoLuong = (int) row.getCell(11).getNumericCellValue();
						String MaNCC = row.getCell(12).getStringCellValue();
						int isDelete = (int) row.getCell(13).getNumericCellValue();
						Laptop lt = new Laptop();
						lt.setMaLaptop(ma);
						lt.setTenLaptop(ten);
						lt.setCPU(CPU);
						lt.setGPU(GPU);
						lt.setRam(Ram);
						lt.setRom(Rom);
						lt.setHeDieuHanh(HeDieuHanh);
						lt.setManHinh(ManHinh);
						lt.setHang(Hang);
						lt.setNamSanXuat(NamSX);
						lt.setGia(gia);
						lt.setSoLuong(SoLuong);
						lt.setMaNhaCungCap(MaNCC);
						lt.setIsDelete(isDelete);
						arr.add(lt);
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

	public boolean WriteExcel() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Chọn vị trí lưu tệp Excel");
		fileChooser.setFileFilter(new FileNameExtensionFilter("Excel files", "xlsx"));

		int userSelection = fileChooser.showSaveDialog(null);
		if (userSelection == JFileChooser.APPROVE_OPTION) {
			String filePath = fileChooser.getSelectedFile().getAbsolutePath();
			if (!filePath.toLowerCase().endsWith(".xlsx")) {
				filePath += ".xlsx";
			}

			try (XSSFWorkbook wordbook = new XSSFWorkbook()) {
				try {

					XSSFSheet sheet = wordbook.createSheet("DanhSachLaptop");
					XSSFRow row = null;
					Cell cell = null;
					row = sheet.createRow(0);
					cell = row.createCell(0, CellType.STRING);
					cell.setCellValue("MaLaptop");
					cell = row.createCell(1, CellType.STRING);
					cell.setCellValue("TenLaptop");
					cell = row.createCell(2, CellType.STRING);
					cell.setCellValue("CPU");
					cell = row.createCell(3, CellType.STRING);
					cell.setCellValue("GPU");
					cell = row.createCell(4, CellType.STRING);
					cell.setCellValue("Ram");
					cell = row.createCell(5, CellType.STRING);
					cell.setCellValue("Rom");
					cell = row.createCell(6, CellType.STRING);
					cell.setCellValue("HeDieuHanh");
					cell = row.createCell(7, CellType.STRING);
					cell.setCellValue("ManHinh");
					cell = row.createCell(8, CellType.STRING);
					cell.setCellValue("Hang");
					cell = row.createCell(9, CellType.NUMERIC);
					cell.setCellValue("NamSanXuat");
					cell = row.createCell(10, CellType.NUMERIC);
					cell.setCellValue("Gia");
					cell = row.createCell(11, CellType.NUMERIC);
					cell.setCellValue("SoLuong");
					cell = row.createCell(12, CellType.STRING);
					cell.setCellValue("MaNhaCungCap");
					cell = row.createCell(13, CellType.STRING);
					cell.setCellValue("isDelete");

					ArrayList<Laptop> lt = LaptopDAO.getintance().selectAll();
					for (int i = 0; i < lt.size(); i++) {
						row = sheet.createRow(i + 1);

						cell = row.createCell(0, CellType.STRING);
						cell.setCellValue(lt.get(i).getMaLaptop());

						cell = row.createCell(1, CellType.STRING);
						cell.setCellValue(lt.get(i).getTenLaptop());

						cell = row.createCell(2, CellType.STRING);
						cell.setCellValue(lt.get(i).getCPU());

						cell = row.createCell(3, CellType.STRING);
						cell.setCellValue(lt.get(i).getCPU());

						cell = row.createCell(4, CellType.STRING);
						cell.setCellValue(lt.get(i).getRam());

						cell = row.createCell(5, CellType.STRING);
						cell.setCellValue(lt.get(i).getRom());

						cell = row.createCell(6, CellType.STRING);
						cell.setCellValue(lt.get(i).getHeDieuHanh());

						cell = row.createCell(7, CellType.STRING);
						cell.setCellValue(lt.get(i).getManHinh());

						cell = row.createCell(8, CellType.STRING);
						cell.setCellValue(lt.get(i).getHang());

						cell = row.createCell(9, CellType.NUMERIC);
						cell.setCellValue(lt.get(i).getNamSanXuat());

						cell = row.createCell(10, CellType.NUMERIC);
						cell.setCellValue(lt.get(i).getGia());

						cell = row.createCell(11, CellType.NUMERIC);
						cell.setCellValue(lt.get(i).getSoLuong());

						cell = row.createCell(12, CellType.STRING);
						cell.setCellValue(lt.get(i).getMaNhaCungCap());

						cell = row.createCell(13, CellType.NUMERIC);
						cell.setCellValue(lt.get(i).getIsDelete());

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

	public void WriteUpDateExcel() {
		try (XSSFWorkbook wordbook = new XSSFWorkbook()) {
			try {

				XSSFSheet sheet = wordbook.createSheet("DanhSachLaptop");
				XSSFRow row = null;
				Cell cell = null;
				row = sheet.createRow(0);
				cell = row.createCell(0, CellType.STRING);
				cell.setCellValue("MaLaptop");
				cell = row.createCell(1, CellType.STRING);
				cell.setCellValue("TenLaptop");
				cell = row.createCell(2, CellType.STRING);
				cell.setCellValue("CPU");
				cell = row.createCell(3, CellType.STRING);
				cell.setCellValue("GPU");
				cell = row.createCell(4, CellType.STRING);
				cell.setCellValue("Ram");
				cell = row.createCell(5, CellType.STRING);
				cell.setCellValue("Rom");
				cell = row.createCell(6, CellType.STRING);
				cell.setCellValue("HeDieuHanh");
				cell = row.createCell(7, CellType.STRING);
				cell.setCellValue("ManHinh");
				cell = row.createCell(8, CellType.STRING);
				cell.setCellValue("Hang");
				cell = row.createCell(9, CellType.NUMERIC);
				cell.setCellValue("NamSanXuat");
				cell = row.createCell(10, CellType.NUMERIC);
				cell.setCellValue("Gia");
				cell = row.createCell(11, CellType.NUMERIC);
				cell.setCellValue("SoLuong");
				cell = row.createCell(12, CellType.STRING);
				cell.setCellValue("MaNhaCungCap");
				cell = row.createCell(13, CellType.STRING);
				cell.setCellValue("isDelete");

				ArrayList<Laptop> lt = LaptopDAO.getintance().selectAll();
				for (int i = 0; i < lt.size(); i++) {
					row = sheet.createRow(i + 1);

					cell = row.createCell(0, CellType.STRING);
					cell.setCellValue(lt.get(i).getMaLaptop());

					cell = row.createCell(1, CellType.STRING);
					cell.setCellValue(lt.get(i).getTenLaptop());

					cell = row.createCell(2, CellType.STRING);
					cell.setCellValue(lt.get(i).getCPU());

					cell = row.createCell(3, CellType.STRING);
					cell.setCellValue(lt.get(i).getCPU());

					cell = row.createCell(4, CellType.STRING);
					cell.setCellValue(lt.get(i).getRam());

					cell = row.createCell(5, CellType.STRING);
					cell.setCellValue(lt.get(i).getRom());

					cell = row.createCell(6, CellType.STRING);
					cell.setCellValue(lt.get(i).getHeDieuHanh());

					cell = row.createCell(7, CellType.STRING);
					cell.setCellValue(lt.get(i).getManHinh());

					cell = row.createCell(8, CellType.STRING);
					cell.setCellValue(lt.get(i).getHang());

					cell = row.createCell(9, CellType.NUMERIC);
					cell.setCellValue(lt.get(i).getNamSanXuat());

					cell = row.createCell(10, CellType.NUMERIC);
					cell.setCellValue(lt.get(i).getGia());

					cell = row.createCell(11, CellType.NUMERIC);
					cell.setCellValue(lt.get(i).getSoLuong());

					cell = row.createCell(12, CellType.STRING);
					cell.setCellValue(lt.get(i).getMaNhaCungCap());

					cell = row.createCell(13, CellType.NUMERIC);
					cell.setCellValue(lt.get(i).getIsDelete());

				}

			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				FileOutputStream fos = new FileOutputStream("src/database/DanhSachLaptop.xlsx");
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
	public int insert(Laptop t) {
		int ketqua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "INSERT INTO laptop (MaLaptop, TenLaptop, CPU, GPU, Ram, Rom, HeDieuHanh, ManHinh, Hang, NamSanXuat, SoLuong, Gia, MaNhaCungCap) "
					+ " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getMaLaptop());
			pst.setString(2, t.getTenLaptop());
			pst.setString(3, t.getCPU());
			pst.setString(4, t.getGPU());
			pst.setString(5, t.getRam());
			pst.setString(6, t.getRom());
			pst.setString(7, t.getHeDieuHanh());
			pst.setString(8, t.getManHinh());
			pst.setString(9, t.getHang());
			pst.setInt(10, t.getNamSanXuat());
			pst.setInt(11, t.getSoLuong());
			pst.setDouble(12, t.getGia());
			pst.setString(13, t.getMaNhaCungCap());
			ketqua = pst.executeUpdate();

			JDBCUtil.closeConnection(con);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public int update(Laptop t) {
		int ketqua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "UPDATE laptop " + "SET " + "MaLaptop=? " + ",TenLaptop=? " + ",CPU=? " + ",GPU=? " + ",Ram=? "
					+ ",Rom=? " + ",HeDieuHanh=? " + ",ManHinh=? " + ",Hang=? " + ",NamSanXuat=? " + ",SoLuong=? "
					+ ",Gia=? " + ",MaNhaCungCap=?" + "WHERE MaLaptop = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getMaLaptop());
			pst.setString(2, t.getTenLaptop());
			pst.setString(3, t.getCPU());
			pst.setString(4, t.getGPU());
			pst.setString(5, t.getRam());
			pst.setString(6, t.getRom());
			pst.setString(7, t.getHeDieuHanh());
			pst.setString(8, t.getManHinh());
			pst.setString(9, t.getHang());
			pst.setInt(10, t.getNamSanXuat());
			pst.setInt(11, t.getSoLuong());
			pst.setDouble(12, t.getGia());
			pst.setString(13, t.getMaNhaCungCap());
			pst.setString(14, t.getMaLaptop());
			ketqua = pst.executeUpdate();

			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketqua;
	}

	public int update1dulieu(String mm, int sl) {
		// TODO Auto-generated method stub
		int ketqua = 0;
		try {
			// TODO Auto-generated method stub
//				BƯỚC 1: TẠO KẾT NỐI ĐẾN CSDL
			Connection con = JDBCUtil.getConnection();

//				BƯỚC 2: TẠO RA ĐỐI TƯỢNG STATEMENT
			Statement st = con.createStatement();
			// String sql1 = "SELECT soluong FROM laptop WHERE id='" + mm + "'";
			String sql = "UPDATE laptop " + " SET SoLuong = soluong + " + sl + " WHERE MaLaptop = '" + mm + "'";

//				BƯỚC 3: THỰC THI CÂU LỆNH SQL
			ketqua = st.executeUpdate(sql);
			// BƯỚC 4 XỬ LÝ KẾT QUẢ
			System.out.println("BẠN ĐÃ THỰC THI : " + sql);
			System.out.println("Số dòng thay đổi: " + ketqua);
			if (ketqua > 0)
				System.out.println("Thêm dữ liệu thành công");
			else
				System.out.println("Thêm dữ liệu thất bại");

//				BƯỚC 5: NGẮT KẾT NỐI
			JDBCUtil.closeConnection(con);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public int delete(Laptop t) {
		int kq = 0;
		try {
			Connection c = JDBCUtil.getConnection();

			String sql = "DELETE FROM Laptop " + "WHERE MaLapTop = ?";
			PreparedStatement pts = c.prepareStatement(sql);
			pts.setString(1, t.getMaLaptop());
			kq = pts.executeUpdate();

			JDBCUtil.closeConnection(c);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public ArrayList<Laptop> selectAll() {
		ArrayList<Laptop> kq = new ArrayList<Laptop>();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select * from laptop where isDelete = 0";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String ma = rs.getString("MaLaptop");
				String ten = rs.getString("TenLaptop");
				String cpu = rs.getString("CPU");
				String gpu = rs.getString("GPU");
				String ram = rs.getString("Ram");
				String rom = rs.getString("Rom");
				String hdh = rs.getString("HeDieuHanh");
				String man = rs.getString("ManHinh");
				String hang = rs.getString("Hang");
				int namsx = rs.getInt("NamSanXuat");
				int soluong = rs.getInt("SoLuong");
				double gia = rs.getDouble("Gia");
				String maNCC = rs.getString("MaNhaCungCap");
				int isDelete = rs.getInt("isDelete");
				Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC,
						isDelete);
				kq.add(lt);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public Laptop selectById(Laptop t) {

		Laptop kq = new Laptop();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select * from laptop where MaLaptop = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getMaLaptop());
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String ma = rs.getString("MaLaptop");
				String ten = rs.getString("TenLaptop");
				String cpu = rs.getString("CPU");
				String gpu = rs.getString("GPU");
				String ram = rs.getString("Ram");
				String rom = rs.getString("Rom");
				String hdh = rs.getString("HeDieuHanh");
				String man = rs.getString("ManHinh");
				String hang = rs.getString("Hang");
				int namsx = rs.getInt("NamSanXuat");
				int soluong = rs.getInt("SoLuong");
				double gia = rs.getDouble("Gia");
				String maNCC = rs.getString("MaNhaCungCap");
				int isDelete = rs.getInt("isDelete");
				kq = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC, isDelete);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}

	@Override
	public ArrayList<Laptop> selectByCondition(String condition) {

		return null;
	}

	public ArrayList<String> getColumn(String ColumnName) {
		ArrayList<String> column = new ArrayList<String>();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select distinct " + ColumnName + " from laptop";
			PreparedStatement pst = con.prepareStatement(sql);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				column.add(rs.getString(ColumnName));
			}

			JDBCUtil.closeConnection(con);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return column;
	}

	public int updateALL(Laptop t, String maOld) {
		int ketqua = 0;
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "UPDATE laptop " + "SET " + "MaLaptop=? " + ",TenLaptop=? " + ",CPU=? " + ",GPU=? " + ",Ram=? "
					+ ",Rom=? " + ",HeDieuHanh=? " + ",ManHinh=? " + ",Hang=? " + ",NamSanXuat=? " + ",SoLuong=? "
					+ ",Gia=? " + ",MaNhaCungCap=?" + "WHERE MaLaptop = ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, t.getMaLaptop());
			pst.setString(2, t.getTenLaptop());
			pst.setString(3, t.getCPU());
			pst.setString(4, t.getGPU());
			pst.setString(5, t.getRam());
			pst.setString(6, t.getRom());
			pst.setString(7, t.getHeDieuHanh());
			pst.setString(8, t.getManHinh());
			pst.setString(9, t.getHang());
			pst.setInt(10, t.getNamSanXuat());
			pst.setInt(11, t.getSoLuong());
			pst.setDouble(12, t.getGia());
			pst.setString(13, t.getMaNhaCungCap());
			pst.setString(14, maOld);

			ketqua = pst.executeUpdate();

			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ketqua;
	}

	@Override
	public Laptop selectById(String T) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int delete(String t) {
		int kq = 0;
		try {
			Connection c = JDBCUtil.getConnection();
			String sql = "update laptop set isDelete = ? where MaLaptop = ?";
			PreparedStatement pst = c.prepareStatement(sql);
			pst.setInt(1, 1);
			pst.setString(2, t);
			kq = pst.executeUpdate();
			c.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return kq;
	}

	public ArrayList<Laptop> Select_search(String NameColumn, String conditon) {
		ArrayList<Laptop> kq = new ArrayList<Laptop>();
		try {
			Connection con = JDBCUtil.getConnection();
			PreparedStatement pst;
			String sql;
			if (NameColumn.equals("Tất cả")) {
				sql = "SELECT * FROM laptop WHERE MaLaptop LIKE ? OR Tenlaptop LIKE ? OR  HeDieuHanh LIKE ? OR Hang LIKE ?"
						+ " OR CPU LIKE ? OR GPU LIKE ? OR Rom LIKE ? OR Ram LIKE ? OR Gia LIKE ? OR ManHinh LIKE ? OR NamSanXuat LIKE ? OR SoLuong LIKE ? OR MaNhaCungCap LIKE ?";
				pst = con.prepareStatement(sql);
				for (int i = 1; i <= 13; i++)
					pst.setString(i, "%"+conditon+"%");
			}
			else {
				sql = "select * from laptop where " + NameColumn + " like ?";
				pst = con.prepareStatement(sql);
				pst.setString(1, "%"+conditon+"%");
			}
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String ma = rs.getString("MaLaptop");
				String ten = rs.getString("TenLaptop");
				String cpu = rs.getString("CPU");
				String gpu = rs.getString("GPU");
				String ram = rs.getString("Ram");
				String rom = rs.getString("Rom");
				String hdh = rs.getString("HeDieuHanh");
				String man = rs.getString("ManHinh");
				String hang = rs.getString("Hang");
				int namsx = rs.getInt("NamSanXuat");
				int soluong = rs.getInt("SoLuong");
				double gia = rs.getDouble("Gia");
				String maNCC = rs.getString("MaNhaCungCap");
				int isDelete = rs.getInt("isDelete");
				Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC,
						isDelete);
				kq.add(lt);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}

	public ArrayList<Laptop> Select_search_HDH(String conditon) {
		ArrayList<Laptop> kq = new ArrayList<Laptop>();
		try {
			Connection con = JDBCUtil.getConnection();
			String sql = "select * from laptop where HeDieuHanh like ?";
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setString(1, "%" + conditon + "%");
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String ma = rs.getString("MaLaptop");
				String ten = rs.getString("TenLaptop");
				String cpu = rs.getString("CPU");
				String gpu = rs.getString("GPU");
				String ram = rs.getString("Ram");
				String rom = rs.getString("Rom");
				String hdh = rs.getString("HeDieuHanh");
				String man = rs.getString("ManHinh");
				String hang = rs.getString("Hang");
				int namsx = rs.getInt("NamSanXuat");
				int soluong = rs.getInt("SoLuong");
				double gia = rs.getDouble("Gia");
				String maNCC = rs.getString("MaNhaCungCap");
				int isDelete = rs.getInt("isDelete");
				Laptop lt = new Laptop(ma, ten, cpu, gpu, ram, rom, hdh, man, hang, namsx, soluong, gia, maNCC,
						isDelete);
				kq.add(lt);
			}
			JDBCUtil.closeConnection(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return kq;
	}

}