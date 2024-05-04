package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.DoiMatKhau;

public class DoiPassActionListener implements ActionListener{
	private DoiMatKhau view;

	public DoiPassActionListener(DoiMatKhau view) {
		this.view = view;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();

		if(src.equals("Hủy bỏ"))
		{
			view.dispose();
		}
		else if(src.equals("Xác nhận"))
		{
			view.dispose();
		}
	}

}