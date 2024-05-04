package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import dao.CuaHangDAO;
import model.CuaHang;
import view.CuaHangView;

public class CuaHangActionListener implements ActionListener {
	private CuaHangView CuaHangView;

	public CuaHangActionListener(CuaHangView cuaHangView) {
		this.CuaHangView = cuaHangView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object src = e.getSource();
		if (src == CuaHangView.comboBox_search_QuanHuyen) {

			CuaHangView.updateComBoBox_XaPhuong();

			ArrayList<CuaHang> newData = advancedSearch();
			CuaHangView.updateData(newData);

		}
		if (src == CuaHangView.comboBox_search_XaPhuong) {

			ArrayList<CuaHang> newData = advancedSearch();
			CuaHangView.updateData(newData);
		}
		if (src == CuaHangView.jbutton_Sreach) {
			String text = CuaHangView.textField_Search.getText();
			ArrayList<CuaHang> newData = CuaHangDAO.getintance().Select_search("Tất cả", text);
			CuaHangView.updateData(newData);
		}
		// hành động enter của text_seach tương đương hành động gị nút tìm kiếm
		CuaHangView.textField_Search.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Gọi hành động của nút refesh khi nhấn phím Enter
				CuaHangView.jbutton_Sreach.doClick();
			}
		});
		if (src == CuaHangView.jbutton_refesh) {

			CuaHangView.comboBox_search_QuanHuyen.setSelectedIndex(0);;
			CuaHangView.textField_Search.setText(null);
		}

	}

	// tìm kiếm nâng cao
	public ArrayList<CuaHang> advancedSearch() {
		String Quan_Huyen_condition = CuaHangView.comboBox_search_QuanHuyen.getSelectedItem().toString();
		String Xa_phuong_condition = CuaHangView.comboBox_search_XaPhuong.getSelectedItem().toString();
		ArrayList<CuaHang> mixerResult = CuaHangDAO.getintance().advancedSearch(Quan_Huyen_condition,Xa_phuong_condition);
		return mixerResult;
	}
}
