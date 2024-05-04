package controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import view.Nhacungcap;
import view.NhapHang;
import view.TaiKhoanView;
import view.ThongKeView;
import view.XuatHang;
import view.login;
import view.mainView;
import view.DoiThongTinUser;
public class mainMouseListener implements MouseListener {

	public mainView view;
	public static JLabel lastClickedLabel;
	
	public mainMouseListener(mainView view) {
		this.view = view;
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		JLabel clickedLabel = (JLabel) e.getSource();
        // Nếu có JLabel được nhấn trước đó, đặt lại màu sắc bình thường
        if (lastClickedLabel != null) {
            lastClickedLabel.setForeground(Color.BLACK);
            lastClickedLabel.setBackground(null);
        }
        
        // Đặt màu sắc mới cho JLabel vừa được nhấn
        clickedLabel.setForeground(Color.WHITE);
        clickedLabel.setBackground(Color.GRAY);
        
        // Xử lý các thao tác với JLabel dựa trên nội dung của nó
        String labelText = clickedLabel.getText();
        
        if (clickedLabel.getText().equals("Sản phẩm")) {
			view.panel_center.setVisible(false);
			view.panel_center.removeAll();
			view.panel_center.add(view.laptopview);
			view.panel_center.setVisible(true);
		}
        else if(labelText.equals("Nhập hàng")) {
    		view.panel_center.setVisible(false);
    		NhapHang nh=new NhapHang();

    		view.panel_center.removeAll(); // Xóa tất cả các thành phần con hiện có trong panel_center
    		view.panel_center.add(nh.panel_nhaphang); // Thêm panel_nhaphang vào panel_center
    		view.panel_center.setVisible(true); // Hiển thị panel_center
    		view.jlabel_sanpham.setForeground(Color.BLACK);
    		view.jlabel_sanpham.setForeground(Color.BLACK);
    	}
        else if (labelText.equals("Xuất hàng")) {
			view.panel_center.setVisible(false);
			XuatHang nh = new XuatHang();

			view.panel_center.removeAll(); // Xóa tất cả các thành phần con hiện có trong panel_center
			view.panel_center.add(nh.panel_nhaphang); // Thêm panel_nhaphang vào panel_center
			view.panel_center.setVisible(true); // Hiển thị panel_center
			view.jlabel_sanpham.setForeground(Color.BLACK);
		}
        else if (labelText.equals("Nhà cung cấp")) {
			view.panel_center.setVisible(false);
			Nhacungcap nh = new Nhacungcap();
			view.panel_center.removeAll(); // Xóa tất cả các thành phần con hiện có trong panel_center
			view.panel_center.add(nh.panel_cungcap); // Thêm panel_nhaphang vào panel_center
			view.panel_center.setVisible(true); // Hiển thị panel_center
			view.jlabel_sanpham.setForeground(Color.BLACK);
		}
        else if (clickedLabel.getText().equals("Cửa hàng")) {
        	view.panel_center.setVisible(false);
			view.panel_center.removeAll();
			view.panel_center.add(view.cuahangview);
			view.panel_center.setVisible(true);
		}
        else if(clickedLabel.getText().equals("Tài khoản"))
        {
        	view.panel_center.setVisible(false);
			view.panel_center.removeAll();
			view.panel_center.add(new TaiKhoanView());
			view.panel_center.setVisible(true);
			view.jlabel_sanpham.setForeground(Color.BLACK);
        }
        else if(clickedLabel.getText().equals("Thông tin tài khoản"))
        {
        	view.panel_center.setVisible(false);
			view.panel_center.removeAll();
			view.panel_center.add(view.user);
			view.panel_center.setVisible(true);
			view.user.setJlabel(view.nhanvien, view.nguoidung);
			view.jlabel_sanpham.setForeground(Color.BLACK);
        }
        else if(clickedLabel.getText().equals("Đăng xuất"))
        {
        	view.jlabel_sanpham.setForeground(Color.BLACK);
        	int result = JOptionPane.showConfirmDialog(view, "Bạn có chắc muốn đăng xuất","Xác nhận",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
        	if(result == JOptionPane.YES_OPTION)
        	{
        		view.dispose();
        		new login();
        	}
        	else
        	{
        		view.jlabel_sanpham.setForeground(Color.WHITE);
        		view.jlabel_dangxuat.setForeground(Color.BLACK);
        	}
        	
        	
        }
        else if (clickedLabel.getText().equals("Thống kê")) {
        	view.panel_center.setVisible(false);
			view.panel_center.removeAll();
			view.panel_center.add(new ThongKeView());
			view.panel_center.setVisible(true);
			view.jlabel_sanpham.setForeground(Color.BLACK);
		}
        // Cập nhật lastClickedLabel
     	lastClickedLabel = clickedLabel;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
