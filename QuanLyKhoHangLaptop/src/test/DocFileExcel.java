package test;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DocFileExcel {

    public static void main(String[] args) {
        FileInputStream fis = null;
        Workbook workbook = null;
        try {
            fis = new FileInputStream(new File("G:\\My Drive\\DoAnJava\\QuanLyKhoHangLaptop\\src\\FileExcel\\test.xlsx"));
            workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheetAt(0);
            int count = 0;
            for (Row row : sheet) {
                if (count == 0) {
                    count++;
                    continue;
                }
                String ten = row.getCell(0).getStringCellValue();
                int tuoi = (int)row.getCell(1).getNumericCellValue();
                String diaChi = row.getCell(2).getStringCellValue();

                System.out.println("Tên: " + ten + ", Tuổi: " + tuoi + ", Địa chỉ: " + diaChi);
            }
            workbook.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}