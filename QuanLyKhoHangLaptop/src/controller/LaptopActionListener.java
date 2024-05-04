package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import dao.LaptopDAO;
import model.Laptop;
import view.laptopview;

public class LaptopActionListener implements ActionListener {

	private laptopview laptopview;

	public LaptopActionListener(laptopview laptopview) {
		this.laptopview = laptopview;
	}

	public void actionPerformed(ActionEvent e) {

		// tìm kiếm nâng cao - Nam fixed
		if (e.getSource().equals(laptopview.comboBox_search) || e.getSource().equals(laptopview.comboBox_Hang)
				|| e.getSource().equals(laptopview.comboBox_CPU) || e.getSource().equals(laptopview.comboBox_Ram)
				|| e.getSource().equals(laptopview.comboBox_Rom) || e.getSource().equals(laptopview.comboBox_Gia)) {

			ArrayList<Laptop> lt = advancedSearch();
			if (lt != null)
				laptopview.updateTableData(lt);
		}
		if (e.getSource().equals(laptopview.jbutton_refesh)) {
			laptopview.comboBox_search.setSelectedIndex(0);
			laptopview.comboBox_Hang.setSelectedIndex(0);
			laptopview.comboBox_CPU.setSelectedIndex(0);
			laptopview.comboBox_Ram.setSelectedIndex(0);
			laptopview.comboBox_Rom.setSelectedIndex(0);
			laptopview.comboBox_Gia.setSelectedIndex(0);
			laptopview.textField.setText(null);
		}
		if (e.getSource().equals(laptopview.jbutton_Sreach)) {
			String condition = laptopview.textField.getText();
			ArrayList<Laptop> lt = LaptopDAO.getintance().Select_search("Tất cả", condition);
			if (lt != null)
				laptopview.updateTableData(lt);
		}
	}

	public ArrayList<Laptop> advancedSearch() {
		String HDH = laptopview.comboBox_search.getSelectedItem().toString();
		String Hang = laptopview.comboBox_Hang.getSelectedItem().toString();
		String CPU = laptopview.comboBox_CPU.getSelectedItem().toString();
		String Ram = laptopview.comboBox_Ram.getSelectedItem().toString();
		String Rom = laptopview.comboBox_Rom.getSelectedItem().toString();
		String Gia = laptopview.comboBox_Gia.getSelectedItem().toString();
		int gia_Min = 0;
		int gia_Max = 0;
		switch (Gia) {
		case "Dưới 10 triệu":
			gia_Min = 0;
			gia_Max = 10000000;
			break;
		case "10-15 triệu":
			gia_Min = 10000000;
			gia_Max = 15000000;
			break;
		case "15-20 triệu":
			gia_Min = 15000000;
			gia_Max = 20000000;
			break;
		case "20-30 triệu":
			gia_Min = 20000000;
			gia_Max = 30000000;
			break;
		case "30-50 triệu":
			gia_Min = 30000000;
			gia_Max = 50000000;
			break;
		case "Hơn 50 triệu":
			gia_Min = 50000000;
			gia_Max = Integer.MAX_VALUE;
			break;
		default:
			gia_Min = 0;
			gia_Max = Integer.MAX_VALUE;
			break;
		}
		ArrayList<Laptop> lt = LaptopDAO.getintance().advancedSearch(HDH, Hang, CPU, Ram, Rom, gia_Min, gia_Max);
		return lt;
	}
	// tìm kiếm nâng cao - Nam fixed

}
