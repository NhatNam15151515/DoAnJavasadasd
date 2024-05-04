package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import dao.NguoiDungDAO;
import dao.NhanVienDAO;
import model.NguoiDung;
import model.NhanVien;
import view.login;
import view.mainView;

public class LoginActionlistener implements ActionListener {

	private login loginview;

	public LoginActionlistener(login loginview) {
		this.loginview = loginview;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
		if (src.equals("Đăng nhập")) {
			boolean check = false;
			String tk = loginview.textField_username.getText();
			String mk = loginview.passwordField.getText();
			ArrayList<NguoiDung> arr = NguoiDungDAO.getintance().selectAll();
			for (NguoiDung nguoiDung : arr) {
				if (nguoiDung.getTaiKhoan().equals(tk) && nguoiDung.getMatKhau().equals(mk)) {
					if (nguoiDung.getPhamViTruyCap() == 0) {
						mainView mv = new mainView();
						mv.nguoidung = nguoiDung;
						mv.lblNewLabel.setText("Hi!" + mv.nguoidung.getTaiKhoan());
						NhanVien nv = NhanVienDAO.getintance().selectByCondition("MaNguoiDung",
								mv.nguoidung.getMaNguoiDung());
						mv.nhanvien = nv;
						loginview.dispose();
						check = true;
						break;
					} else if (nguoiDung.getPhamViTruyCap() == 1) {
						/*
						 * admin_view ad = new admin_view(); ad.nguoidung = nguoiDung;
						 * ad.lblNewLabel.setText("Hi!"+ad.nguoidung.getTaiKhoan()); NhanVien nv =
						 * NhanVienDAO.getintance().selectByCondition("MaNguoiDung",
						 * ad.nguoidung.getMaNguoiDung()); ad.nhanvien = nv; loginview.dispose(); check
						 * = true; break;
						 */

						mainView mv = new mainView();
						mv.nguoidung = nguoiDung;
						mv.lblNewLabel.setText("Hi!" + mv.nguoidung.getTaiKhoan());
						NhanVien nv = NhanVienDAO.getintance().selectByCondition("MaNguoiDung",
								mv.nguoidung.getMaNguoiDung());
						mv.nhanvien = nv;
						mv.addLabel();
						loginview.dispose();
						check = true;
						break;

					}
				}
			}
			if (check == false) {
				JOptionPane.showMessageDialog(loginview, "Tài khoản hoặc mật khẩu không đúng\nVui lòng nhập lại", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
			}

		}
	}

}