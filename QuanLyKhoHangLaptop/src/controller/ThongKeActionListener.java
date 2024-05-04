package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.ThongKeView;

public class ThongKeActionListener implements ActionListener {
	private ThongKeView ThongKeView;

	public ThongKeView getThongKeView() {
		return ThongKeView;
	}

	public void setThongKeView(ThongKeView thongKeView) {
		ThongKeView = thongKeView;
	}

	public ThongKeActionListener(ThongKeView tk) {
		this.ThongKeView = tk;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(ThongKeView.comboBox_CongViec)
				|| e.getSource().equals(ThongKeView.comboBox_ThoiGian)) {
			// Cập nhật định dạng cho combobox Ngày bắt đầu và Ngày kết thúc
			ThongKeView.updateDateFormats();
			ThongKeView.updateData();
			return;
		}

		if (e.getSource().equals(ThongKeView.comboBox_NgayBD)) {
			int StartDate = ThongKeView.comboBox_NgayBD.getSelectedIndex();
			int EndDate = ThongKeView.comboBox_NgayKT.getSelectedIndex();

			if (StartDate > EndDate)
				ThongKeView.comboBox_NgayBD.setSelectedIndex(EndDate);

			ThongKeView.updateData();
			return;
		}
		if (e.getSource().equals(ThongKeView.comboBox_NgayKT)) {
			int StartDate = ThongKeView.comboBox_NgayBD.getSelectedIndex();
			int EndDate = ThongKeView.comboBox_NgayKT.getSelectedIndex();

			if (StartDate > EndDate)
				ThongKeView.comboBox_NgayBD.setSelectedIndex(StartDate);

			ThongKeView.updateData();
			return;

		}
	}

}
