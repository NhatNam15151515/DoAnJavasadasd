package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import view.DoiMatKhau;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import dao.NguoiDungDAO;
import dao.NhanVienDAO;
import model.NguoiDung;
import model.NhanVien;
import view.DoiThongTinUser;
import view.ThemTaiKhoan;
import view.mainView;

public class ThongTinMouseListener implements MouseListener{

	private DoiThongTinUser user;

	public ThongTinMouseListener(DoiThongTinUser user) {
		this.user = user;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JLabel clickedLabel = (JLabel) e.getSource();

        String labelText = clickedLabel.getText();
        if(labelText.equals("Đổi thông tin"))
        {
        	ThemTaiKhoan tk = new ThemTaiKhoan();
        	tk.setTitle("Đổi thông tin");
        	tk.lblNewLabel_6.setText("Đổi thông tin tài khoản");
        	NhanVien nv = mainView.nhanvien;
        	NguoiDung nd = mainView.nguoidung;
        	tk.panel_chinh.remove(tk.textField_MatKhau);
        	tk.panel_chinh.remove(tk.MatKhau);
        	tk.textField_HoTen.setText(nv.getTenNhanVien());
        	tk.textField_MaND.setText(nv.getMaNguoiDung());
        	tk.textField_MaNV.setText(nv.getMaNhanVien());
        	tk.textField_SDT.setText(nv.getSDT());
        	tk.textField_TaiKhoan.setText(nd.getTaiKhoan());
        	if(nv.getGioiTinh()==1)
        	{
        		tk.radioButton1.setSelected(true);
        	}
        	else if(nv.getGioiTinh()==0)
        	{
        		tk.radioButton2.setSelected(true);
        	}
        	
        	int day = nv.getNgaySinh().getDate();
        	int month = nv.getNgaySinh().getMonth()+1;
        	int year = nv.getNgaySinh().getYear()+1900;
        	tk.setYMD(day, month, year);
        	tk.textField_MaNV.setEditable(false);
        	tk.textField_MaND.setEditable(false);
        	tk.textField_TaiKhoan.setEditable(false);
        	
        	tk.button_xacnhan.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getActionCommand().equals("Xác nhận"))
					{

						if(tk.radioButton1.isSelected())
						{
							nv.setGioiTinh(1);
						}
						else if(tk.radioButton2.isSelected())
						{
							nv.setGioiTinh(0);
						}
						int year = (int) tk.yearModel.getValue();
			            int month = (int) tk.monthModel.getValue();
			            int day = (int) tk.dayModel.getValue();
			            if (isValidDate(year, month, day)==false) {
			            	 JOptionPane.showMessageDialog(tk, "Ngày không hợp lệ!");
			            	 tk.setYMD_now();
			            	 year = (int) tk.yearModel.getValue();
					         month = (int) tk.monthModel.getValue();
					         day = (int) tk.dayModel.getValue();
			            } 
						nv.setTenNhanVien(tk.textField_HoTen.getText());
			        	nv.setSDT(tk.textField_SDT.getText());
			        	nv.setNgaySinh(day, month, year);

			        	

			        	int result = JOptionPane.showConfirmDialog(tk, "Bạn có chắc muốn sửa tài khoản ?","Xác nhận",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			        	if(result == JOptionPane.YES_OPTION)
			        	{
							int check1 = NguoiDungDAO.getintance().update(nd);
							int check2 = NhanVienDAO.getintance().update(nv);

							if(check1 == 1 && check2 ==1)
							{
								JOptionPane.showMessageDialog(tk, "Tài khoản đã được sửa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
								NhanVienDAO.getintance().WriteUpDateExcel();
								NguoiDungDAO.getintance().WriteUpDateExcel();
								NguoiDungDAO.getintance().UpDateKetHop();
								user.setJlabel(nv, nd);
							}
							else
							{
								JOptionPane.showMessageDialog(tk, "Tài khoản sửa thất bại", "Thông báo", JOptionPane.ERROR_MESSAGE);
							}
			        	}

					}
				}
			});
        	
        	user.jlabel_sua.setForeground(Color.BLACK);

        }
        else if(labelText.equals("Đổi mật khẩu"))
        {
        	user.jlabel_sua.setForeground(Color.WHITE);
        	
        	DoiMatKhau mk = new DoiMatKhau();
        	mk.btnHuyBo.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getActionCommand().equals("Hủy bỏ"))
					{
						mk.dispose();
						user.jlabel_sua.setForeground(Color.BLACK);
			        	
					}
				}
			});
        	mk.btnXacNhan.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getActionCommand().equals("Xác nhận"))
					{	
						NguoiDung nd = view.mainView.nguoidung;

						if(nd.getMatKhau().equals(mk.passwordField_1.getText()))
						{
							if(mk.passwordField_2.getText().equals(mk.passwordField_3.getText()) && !mk.passwordField_2.getText().equals("") && !mk.passwordField_3.getText().equals(""))
							{
								int result = JOptionPane.showConfirmDialog(mk, "Bạn có chắc chắn đổi mật khẩu","Xác nhận",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
								if(result == JOptionPane.YES_NO_OPTION)
								{
									int kq = NguoiDungDAO.getintance().updateByCondition(nd.getMaNguoiDung(),mk.passwordField_1.getText() , mk.passwordField_2.getText());
									if(kq == 1)
									{
										JOptionPane.showMessageDialog(mk,"Đổi mật khẩu thành công","Thông báo",JOptionPane.INFORMATION_MESSAGE);
										nd.setMatKhau(mk.passwordField_2.getText());
										mk.dispose();
										
							        	user.jlabel_sua.setForeground(Color.BLACK);
									}
									else
									{
										JOptionPane.showMessageDialog(mk,"Đổi mật khẩu thất bại","Thông báo",JOptionPane.ERROR_MESSAGE);
									}
								}

							}
							else
							{
								JOptionPane.showMessageDialog(mk,"Mật khẩu mới không hợp lệ","Thông báo",JOptionPane.ERROR_MESSAGE);
							}

						}
						else
						{
							JOptionPane.showMessageDialog(mk,"Mật khẩu không đúng","Thông báo",JOptionPane.ERROR_MESSAGE);
						}
					}
				}
			});

        	mk.addWindowListener(new WindowAdapter() {
    		    @Override
    		    public void windowClosing(WindowEvent e) {
    		    	
		        	user.jlabel_sua.setForeground(Color.BLACK);
    		    }
    		});
        }

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
	
	
	private static boolean isValidDate(int year, int month, int day) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        sdf.setLenient(false);
        try {
            Date date = sdf.parse(year + "/" + month + "/" + day);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

}