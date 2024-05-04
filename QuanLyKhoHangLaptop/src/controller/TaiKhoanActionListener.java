package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import dao.NguoiDungDAO;
import dao.NhanVienDAO;
import model.NguoiDung;
import model.NhanVien;
import view.TaiKhoanView;

public class TaiKhoanActionListener implements ActionListener{

	private TaiKhoanView view ;
	public TaiKhoanActionListener(TaiKhoanView view) {
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		String src = e.getActionCommand();
		
		if(e.getSource()==view.button_refesh1)
		{
			view.textField_timkiem.setText(null);
		}
		else if(e.getSource()==view.button_search1)
		{
			ArrayList<NhanVien> nv = NhanVienDAO.getintance().select_search(view.comboBox_maND.getSelectedItem()+"",view.comboBox_gioitinh.getSelectedItem()+"");
			view.updateTableDataByNhanVien(nv);
			ArrayList<NguoiDung> nd = new ArrayList<NguoiDung>();
			for(int i=0;i<nv.size();i++)
			{
				NguoiDung ngd = NguoiDungDAO.getintance().selectByCondition("MaNguoiDung", nv.get(i).getMaNguoiDung());
				nd.add(ngd);
			}
			
			String tmp = view.textField_timkiem.getText();
			ArrayList<NhanVien> arr = view.select_search(tmp, nv, nd);
			view.updateTableDataByNhanVien(arr);
			
		}
		else if(e.getSource()==view.comboBox_gioitinh|| e.getSource()==view.comboBox_maND)
		{
			ArrayList<NhanVien> nv = NhanVienDAO.getintance().select_search(view.comboBox_maND.getSelectedItem()+"",view.comboBox_gioitinh.getSelectedItem()+"");
			view.updateTableDataByNhanVien(nv);
		}
	}

}
