package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import dao.CuaHangDAO;
import model.CuaHang;
import view.CRUDCuaHang;
import view.CuaHangView;
import view.XemChiTietCuaHang;

public class CuaHangMouseListener implements MouseListener {
	private CuaHangView CuaHangView;
	private JLabel clickedLabel;
	private String old_MaCH = "";

	public CuaHangMouseListener(CuaHangView cuaHangView) {
		this.CuaHangView = cuaHangView;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		clickedLabel = (JLabel) e.getSource();
		String LabelText = clickedLabel.getText();
		if (LabelText.equals("Thêm") || LabelText.equals("Sửa")) {
			CRUDCuaHang(LabelText);
			return;
		}
		if (LabelText.indexOf("Excel") != -1) {
			String action[] = LabelText.split(" ");
			Excel(action[0]);
			return;
		}
		String MaCH = getSelectedMaCH();
		if (MaCH != null) {
			switch (LabelText) {
			case "Xóa":
				DeleteCuaHang(MaCH);
				break;
			case "Xem chi tiết":
				ViewDetails(MaCH);
			}
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

	public void CRUDCuaHang(String type) {
		String CRUD_type = type.toLowerCase();
		String MaCH = "";
		CRUDCuaHang CRUDCH = new CRUDCuaHang();
		CRUDCH.Label_ThemCH.setText(type + " Cửa Hàng");
		CRUDCH.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				clickedLabel.setForeground(Color.BLACK);
				clickedLabel.setBackground(null);
			}
		});
		CRUDCH.comboBox_QuanHuyen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				CRUDCH.updateComBoBox_XaPhuong();
			}
		});

		CRUDCH.comboBox_TPHO.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		CRUDCH.comboBox_XaPhuong.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		if (type.equals("Sửa")) {
			MaCH = getSelectedMaCH();
			if (MaCH != null) {
				CuaHang CH;
				if (CuaHangDAO.getintance().isMaCHExists(MaCH)) {
					// lưu mã cửa hàng trước khi sửa để đối chiếu sau ki sửa
					old_MaCH = MaCH;

					CH = CuaHangDAO.getintance().selectById(MaCH);

					// đưa các dữ liệu của cửa hàng cần sửa lên giao diện sửa
					CRUDCH.textField_MaCH.setText(CH.getMaCH());
					CRUDCH.textField_TenCH.setText(CH.getTenCH());
					CRUDCH.textField_SDT.setText(CH.getSDT());
					CRUDCH.textField_DiaChi.setText(CH.getDiaChi());
					String[] diachi = CH.getDiaChi().split(", ");
					String ThanhPho = view.CuaHangView.chuyenThanhTenBien(diachi[diachi.length - 1]);
					String Quan_Huyen = view.CuaHangView.chuyenThanhTenBien(diachi[diachi.length - 2]);
					String Xa_Phuong = view.CuaHangView.chuyenThanhTenBien(diachi[diachi.length - 3]);
					String Duong = diachi[diachi.length - 4];

					for (String item : CRUDCH.ThanhPho) {
						if (ThanhPho.equals(view.CuaHangView.chuyenThanhTenBien(item))) {
							CRUDCH.comboBox_TPHO.setSelectedItem(item);
							break;
						}
					}

					for (String item : CRUDCH.Quan_Huyen) {
						if (Quan_Huyen.equals(view.CuaHangView.chuyenThanhTenBien(item))) {
							CRUDCH.comboBox_QuanHuyen.setSelectedItem(item);
							CRUDCH.updateComBoBox_XaPhuong();
							break;
						}
					}

					for (String item : CRUDCH.Xa_Phuong) {
						if (Xa_Phuong.equals(view.CuaHangView.chuyenThanhTenBien(item))) {
							CRUDCH.comboBox_XaPhuong.setSelectedItem(item);
							break;
						}
					}

					CRUDCH.textField_DiaChi.setText(Duong);
				}
			}

			else
				JOptionPane.showMessageDialog(CuaHangView, "Hãy chọn cửa hàng muốn sửa", "Lỗi",
						JOptionPane.ERROR_MESSAGE);
		}

		// xử lý thng6 tin ngay khi nhân nút xác nhận
		CRUDCH.Button_XacNhan.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// lấy dữ liệu từ giao diện sửa
				String maCH = CRUDCH.textField_MaCH.getText();
				String tenCH = CRUDCH.textField_TenCH.getText();
				String sdt = CRUDCH.textField_SDT.getText();
				String diaChi = CRUDCH.textField_DiaChi.getText() + ", " + CRUDCH.comboBox_XaPhuong.getSelectedItem()
						+ ", " + CRUDCH.comboBox_QuanHuyen.getSelectedItem() + ", "
						+ CRUDCH.comboBox_TPHO.getSelectedItem();

				// Kiểm tra xem các trường có được nhập đầy đủ không
				if (maCH.isEmpty() || maCH.trim().isEmpty() || tenCH.isEmpty() || tenCH.trim().isEmpty() || sdt.isEmpty() || diaChi.isEmpty()) {
					JOptionPane.showMessageDialog(CRUDCH, "Vui lòng nhập đầy đủ thông tin", "Lỗi",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				// kiểm tra xem mã cũ có trùng với mã mới không
				if (!old_MaCH.equals(maCH)) {
					// Kiểm tra xem mã cửa hàng đã tồn tại chưa
					if (CuaHangDAO.getintance().isMaCHExists(maCH)) {
						CuaHang CH = CuaHangDAO.getintance().selectById(maCH);
						if (CH.getIsDelete() == 0) {
							JOptionPane.showMessageDialog(CRUDCH, "Mã cửa hàng đã tồn tại", "Lỗi",
									JOptionPane.ERROR_MESSAGE);
							return;

						} else {
							int choice = JOptionPane.showConfirmDialog(CRUDCH,
									"Cửa hàng đã bị xóa, bạn có muốn khôi phục lại không?", "Xác nhận",
									JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

							if (choice == JOptionPane.YES_OPTION) {
								CuaHangDAO.getintance().restoreCuaHang(maCH);
								CuaHangView.loadCuaHang();
								CRUDCH.dispose();

							} else {
								JOptionPane.showMessageDialog(CRUDCH, "Mã cửa hàng đã tồn tại", "Lỗi",
										JOptionPane.ERROR_MESSAGE);
								return;
							}
						}
					}
				}
				// kiểm tra regex số điện thoạii
				if (!sdt.startsWith("0") || !sdt.matches("\\d+") || sdt.length() < 10 || sdt.length() > 11) {
					JOptionPane.showMessageDialog(CRUDCH, "Số điện thoại của cửa hàng không hợp lệ", "Lỗi",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				// Tạo đối tượng cửa hàng mới
				CuaHang CH = new CuaHang(maCH, tenCH, diaChi, sdt, 0);
				// Chỉnh sử dữ liệu cửa hàng trong cơ sở dữ liệu
				if (CH != null) {
					Boolean isCRUD = false;

					if (type.equals("Thêm"))
						isCRUD = CuaHangDAO.getintance().insertCuaHang(CH);
					else if (type.equals("Sửa"))
						isCRUD = CuaHangDAO.getintance().updateCuaHang(old_MaCH, CH);

					if (isCRUD) {
						CuaHangView.loadCuaHang();
						JOptionPane.showMessageDialog(CRUDCH, "Cửa hàng đã được " + CRUD_type + " thành công",
								"Thông báo", JOptionPane.INFORMATION_MESSAGE);
						CRUDCH.dispose();
					} else {
						JOptionPane.showMessageDialog(CRUDCH, "Không thể " + CRUD_type + " cửa hàng", "Lỗi",
								JOptionPane.ERROR_MESSAGE);
						return;
					}
				}
			}
		});
		CRUDCH.Button_HuyBo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!CRUDCH.textField_MaCH.getText().isEmpty() || !CRUDCH.textField_TenCH.getText().isEmpty()
						|| !CRUDCH.textField_SDT.getText().isEmpty() || !CRUDCH.textField_DiaChi.getText().isEmpty()) {
					int choice = JOptionPane.showConfirmDialog(CRUDCH, "Xác nhận hủy bỏ?", "Xác nhận",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

					if (choice == JOptionPane.YES_OPTION)
						CRUDCH.dispose();

					else
						return;
				}
				CRUDCH.dispose();
			}
		});
	}

	public void DeleteCuaHang(String MaCH) {
		CuaHang CH = CuaHangDAO.getintance().selectById(MaCH);
		String TenCH = CH.getTenCH();

		if (CuaHangDAO.getintance().isMaCHExists(MaCH)) {
			int choice = JOptionPane.showConfirmDialog(CuaHangView, "Xác nhận xóa cửa hàng " + TenCH, "Xác nhận",
					JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

			if (choice == JOptionPane.YES_OPTION) {
				CuaHangDAO.getintance().soft_deleteCuaHang(MaCH);
				CuaHangView.loadCuaHang();
				JOptionPane.showMessageDialog(CuaHangView, "Cửa hàng " + TenCH + " đã được xóa thành công", "Thông báo",
						JOptionPane.INFORMATION_MESSAGE);
			}

		} else
			JOptionPane.showMessageDialog(CuaHangView, "Cửa hàng không tồn lại", "Thông báo",
					JOptionPane.ERROR_MESSAGE);
	}

	public void ViewDetails(String MaCH) {
		if (CuaHangDAO.getintance().isMaCHExists(MaCH)) {

			CuaHang CH = CuaHangDAO.getintance().selectById(MaCH);
			XemChiTietCuaHang ChiTietCH = new XemChiTietCuaHang();

			ChiTietCH.Label_ChiTietCH_MaCH_Content.setText(CH.getMaCH());
			ChiTietCH.Label_ChiTietCH_TenCH_Content.setText(CH.getTenCH());
			ChiTietCH.Label_ChiTietCH_DiaChi_Content.setText(CH.getDiaChi());
			ChiTietCH.Label_ChiTietCH_SDT_Content.setText(CH.getSDT());
			ChiTietCH.load();
		}
	}

	public void Excel(String type) {
		Boolean isExcel = false;

		if (type.equals("Nhập"))
			isExcel = CuaHangDAO.getintance().readExcel();
		if (type.equals("Xuất"))
			isExcel = CuaHangDAO.getintance().writeExcel();

		if (isExcel) {
			CuaHangView.loadCuaHang();
			JOptionPane.showMessageDialog(CuaHangView, type + " dữ liệu Excel thành công", "Thông Báo",
					JOptionPane.INFORMATION_MESSAGE);
		} else
			JOptionPane.showMessageDialog(CuaHangView, "Không thể " + type + " dữ liệu Excel", "Lỗi",
					JOptionPane.ERROR_MESSAGE);

	}

	public String getSelectedMaCH() {
		int selectecRow = CuaHangView.table.getSelectedRow();
		String MaCH = null;
		if (selectecRow != -1) {
			MaCH = CuaHangView.table.getValueAt(selectecRow, 0).toString();
			return MaCH;
		} else
			JOptionPane.showMessageDialog(CuaHangView, "Hãy chọn cửa hàng muốn thực hiện thao tác", "Lỗi",
					JOptionPane.ERROR_MESSAGE);
		return MaCH;
	}

}
