package controller;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import view.PhieuXuat;

public class FrameToImage {

    public static void main(String[] args) {
        PhieuXuat phieuXuat = new PhieuXuat();
        
        // Thêm trình nghe sự kiện để chụp ảnh khi JFrame xuất hiện
        phieuXuat.addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowOpened(java.awt.event.WindowEvent windowEvent) {
                try {
                	Thread.sleep(200);
                    captureFrameAndSaveAsImage(phieuXuat, "Phieu_Xuat.png");
                    System.out.println("Frame captured and saved as image.");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        
        phieuXuat.setVisible(true);
    }

    public static void captureFrameAndSaveAsImage(JFrame frame, String filename) throws AWTException, IOException {
        // Lấy kích thước của JFrame
    	// Lấy kích thước của JFrame
        Rectangle area = frame.getBounds();

        // Điều chỉnh kích thước vùng chụp ảnh
        int inset = 20; // Số lượng pixel bạn muốn bỏ qua ở mỗi cạnh của JFrame
        area.setBounds(area.x + inset, area.y + inset+15, area.width - 2 * inset, area.height - 2 * inset);

        // Tạo một đối tượng Robot để chụp ảnh màn hình
        Robot robot = new Robot();

        // Chụp ảnh màn hình trong phạm vi của JFrame
        BufferedImage screenshot = robot.createScreenCapture(area);

        // Lưu ảnh vào một tệp
        ImageIO.write(screenshot, "png", new File(filename));
    }
}
