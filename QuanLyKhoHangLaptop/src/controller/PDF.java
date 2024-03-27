package controller;

import java.io.FileOutputStream;

import com.itextpdf.text.Document;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

public class PDF {

    public static void main(String[] args) throws InterruptedException {
    	FrameToImage.main(args);
    	Thread.sleep(210);
        String imagePath = "D:\\java_setup\\DoAnJava\\QuanLyKhoHangLaptop\\Phieu_Xuat.png"; // Đường dẫn đến tệp ảnh
        String pdfPath = "Phieu_Xuat.pdf"; // Đường dẫn đến tệp PDF đầu ra

        convertImageToPDF(imagePath, pdfPath);
    }

    public static void convertImageToPDF(String imagePath, String pdfPath) {
        try {
        	 
            // Khởi tạo một tài liệu PDF
            Document document = new Document(PageSize.A4);
            
            // Tạo một đối tượng PdfWriter để ghi vào tài liệu PDF
            PdfWriter.getInstance(document, new FileOutputStream(pdfPath));
            
            // Mở tài liệu để bắt đầu ghi
            document.open();
            
            // Đọc tệp ảnh
            Image image = Image.getInstance(imagePath);
            
            // Thiết lập kích thước của ảnh để nó vừa với trang PDF
            image.scaleToFit(PageSize.A4.getWidth(), PageSize.A4.getHeight());
            
            // Đặt vị trí tuyệt đối của ảnh trong tài liệu PDF (ở giữa trang)
            image.setAbsolutePosition(0, (PageSize.A4.getHeight() - image.getScaledHeight()));
            // Thêm ảnh vào tài liệu PDF
            document.add(image);
            
            // Đóng tài liệu
            document.close();
            
            System.out.println("Image converted to PDF successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
