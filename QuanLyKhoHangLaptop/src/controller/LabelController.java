package controller;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;

import view.PhieuXuat;

public class LabelController {
	private static JLabel lastClickedLabel;
	private static PhieuXuat PhieuXuat;

	public static void addMouseListener(JLabel label) {
		label.addMouseListener(new MouseAdapter() {

			@Override

			public void mouseClicked(MouseEvent e) {
				JLabel clickedLabel = (JLabel) e.getSource();
				// Nếu có JLabel được nhấn trước đó, đặt lại màu sắc bình thường
				if (lastClickedLabel != null) {
					lastClickedLabel.setForeground(Color.WHITE);
					lastClickedLabel.setBackground(null);
				}

				// Đặt màu sắc mới cho JLabel vừa được nhấn
				clickedLabel.setForeground(Color.BLACK);
				clickedLabel.setBackground(Color.GRAY);
				//thêm nhập xuất
				if (clickedLabel.getText() == "Phiếu nhập") {
					PhieuXuat = new PhieuXuat();
					PhieuXuat.ChangeInformationToPhieuNhap();
					PhieuXuat.setVisible(true);
				}
				if (clickedLabel.getText() == "Phiếu xuất") {
					PhieuXuat = new PhieuXuat();
					PhieuXuat.ChangeInformationToPhieuXuat();
					PhieuXuat.setVisible(true);
				}
				// Cập nhật lastClickedLabel
				lastClickedLabel = clickedLabel;
			}
		});
	}

}
