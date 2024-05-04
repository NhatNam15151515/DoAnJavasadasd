package controller;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import view.ThongKeView;

public class ThongKeMouseListener implements MouseListener {
	private ThongKeView thongKeView;

	public ThongKeMouseListener(ThongKeView tk) {
		this.thongKeView = tk;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		JLabel clickedLabel = (JLabel) e.getSource();
		clickedLabel.setBackground(null);
		clickedLabel.setForeground(Color.BLUE);
		String labelText = clickedLabel.getText();
		if (labelText.equals("Sản Phẩm")) {
			thongKeView.panel_Center.setVisible(false);
			thongKeView.panel_Center.removeAll();
			thongKeView.panel_Center.add(thongKeView.bd);
			thongKeView.comboBox_NgayBD.setSelectedIndex(0);
			thongKeView.comboBox_NgayKT.setSelectedIndex(0);
			thongKeView.comboBox_CongViec.setSelectedIndex(0);
			thongKeView.comboBox_ThoiGian.setSelectedIndex(0);
			thongKeView.panel_Center.setVisible(true);
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

}
