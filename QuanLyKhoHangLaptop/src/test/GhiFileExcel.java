package test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;


import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import dao.LaptopDAO;
import model.Laptop;

public class GhiFileExcel {

	public GhiFileExcel() {
		// TODO Auto-generated constructor stub
	}
	 public static void main(String[] args) {
			try (XSSFWorkbook wordbook = new XSSFWorkbook()) {
				try {

						XSSFSheet sheet = wordbook.createSheet("DanhSach");
						XSSFRow row = null;
						Cell cell = null;
						row = sheet.createRow(0);
						cell = row.createCell(0,CellType.STRING);
						cell.setCellValue("STT");
						cell = row.createCell(1,CellType.STRING);
						cell.setCellValue("MaLaptop");
						cell = row.createCell(2,CellType.STRING);
						cell.setCellValue("TenLaptop");
						cell = row.createCell(3,CellType.STRING);
						cell.setCellValue("MaNCC");
						ArrayList<Laptop> lt = LaptopDAO.getintance().selectAll();
						for (int i = 0; i < lt.size();i++) {
							row = sheet.createRow(i+4);
							cell = row.createCell(0,CellType.NUMERIC);
							cell.setCellValue(i+1);

							cell = row.createCell(1,CellType.STRING);
							cell.setCellValue(lt.get(i).getMaLaptop());

							cell = row.createCell(2,CellType.STRING);
							cell.setCellValue(lt.get(i).getTenLaptop());

							cell = row.createCell(3,CellType.STRING);
							cell.setCellValue(lt.get(i).getMaNhaCungCap());
						}

					} catch (Exception e) {
						e.printStackTrace();
					}
					File f = new File("G:\\My Drive\\DoAnJava\\QuanLyKhoHangLaptop\\src\\FileExcel\\DanhSachLaptop.xlsx");

					try {
						FileOutputStream fos = new FileOutputStream(f);
						wordbook.write(fos);
						fos.close();
					} catch (Exception e) {
						e.printStackTrace();
					}

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

	}
}