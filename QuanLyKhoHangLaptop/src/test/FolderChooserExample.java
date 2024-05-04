package test;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import model.Laptop;

public class FolderChooserExample {
    public static void main(String[] args) {

    	 FileInputStream fis = null;
         Workbook workbook = null;
         try {
             fis = new FileInputStream(new File("G:\\My Drive\\DoAnJava\\QuanLyKhoHangLaptop\\src\\FileExcel\\DanhSachLaptop.xlsx"));
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
                 int NamSX =(int) row.getCell(9).getNumericCellValue();
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
                 System.out.println(lt.toString());
             }
             workbook.close();
             fis.close();
         } catch (Exception e) {
             e.printStackTrace();
         }
    }
}