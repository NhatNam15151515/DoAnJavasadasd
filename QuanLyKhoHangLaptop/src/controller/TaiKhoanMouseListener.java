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
import java.util.ArrayList;
//import java.sql.Date;
import java.util.Date;

import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import dao.NguoiDungDAO;
import dao.NhanVienDAO;
import model.NguoiDung;
import model.NhanVien;
import view.TaiKhoanView;
import view.ThemTaiKhoan;

public class TaiKhoanMouseListener implements MouseListener{

	private TaiKhoanView taikhoanview ;
	private ThemTaiKhoan tk;
	private NhanVien nv;
	private NguoiDung nd;
	public TaiKhoanMouseListener(TaiKhoanView taikhoanview) {
		this.taikhoanview = taikhoanview;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		JLabel clickedLabel = (JLabel) e.getSource();

        // Đặt màu sắc mới cho JLabel vừa được nhấn
        clickedLabel.setForeground(Color.WHITE);
        clickedLabel.setBackground(Color.GRAY);

        // Xử lý các thao tác với JLabel dựa trên nội dung của nó
        String labelText = clickedLabel.getText();

        if(labelText.equals("Thêm"))
        {
        	tk = new ThemTaiKhoan();
        	tk.addWindowListener(new WindowAdapter() {
    		    @Override
    		    public void windowClosing(WindowEvent e) {
    		        clickedLabel.setForeground(Color.BLACK);
    		        clickedLabel.setBackground(null);
    		    }
    		});

        	tk.button_huybo.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getActionCommand().equals("Hủy bỏ"))
					{
						tk.dispose();
						clickedLabel.setForeground(Color.BLACK);
        		        clickedLabel.setBackground(null);
					}
				}
			});

        	nv = new NhanVien();
        	nd = new NguoiDung();

            tk.button_xacnhan.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if(e.getActionCommand().equals("Xác nhận"))
					{

						ArrayList<String> arrMaNguoiDung = new ArrayList<String>();
			        	while(true)
			        	{
			        		arrMaNguoiDung = NguoiDungDAO.getintance().getColumn("MaNguoiDung");
			        		for (String string : arrMaNguoiDung) {
								if(tk.textField_MaND.getText().equals(string))
								{
									JOptionPane.showMessageDialog(tk, "Mã người dùng bị trùng lặp !\nVui lòng nhập lại !","Lỗi",JOptionPane.ERROR_MESSAGE);
									do
									{
										int count = 0;
										String input = JOptionPane.showInputDialog(tk, "Nhập lại mã người dùng:");

								       	if (input != null && !input.isEmpty()) {
								       		for (String string2 : arrMaNguoiDung) {
												if(string2.equals(input))
												{
													JOptionPane.showMessageDialog(tk, "Mã người dùng trùng lặp !\nVui lòng nhập lại !","Lỗi",JOptionPane.ERROR_MESSAGE);
													count=1;
													break;
												}
											}
								        } else {
								            JOptionPane.showMessageDialog(tk, "Bạn không nhập giá trị!");
								            count = 1;
								        }
								       	if(count==0)
								       	{
								       		tk.textField_MaND.setText(input);
								       		break;
								       	}

									}
									while(true);
								}
								else if(tk.textField_MaND.getText().equals(""))
								{
									JOptionPane.showMessageDialog(tk, "Mã người dùng bị bỏ trống !\n Vui lòng nhập mã người dùng","Lỗi",JOptionPane.ERROR_MESSAGE);

									do
									{
										int count = 0;
										String input = JOptionPane.showInputDialog(tk, "Nhập lại mã người dùng:");

								       	if (input != null && !input.isEmpty()) {
								       		for (String string2 : arrMaNguoiDung) {
												if(string2.equals(input))
												{
													JOptionPane.showMessageDialog(tk, "Mã người bị trùng lặp !\nVui lòng nhập lại !","Lỗi",JOptionPane.ERROR_MESSAGE);
													count=1;
													break;
												}
											}
								        } else {
								            JOptionPane.showMessageDialog(tk, "Bạn không nhập giá trị!");
								            count = 1;
								        }
								       	if(count==0)
								       	{
								       		tk.textField_MaND.setText(input);
								       		break;
								       	}
									}
									while(true);
								}
							}
			        		break;
			        	}
						nd.setMaNguoiDung(tk.textField_MaND.getText());



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

			        	ArrayList<String> arrMaNhanVien = new ArrayList<String>();
			        	while(true)
			        	{
			        		arrMaNhanVien = NhanVienDAO.getintance().getColumn("MaNhanVien");
			        		for (String string : arrMaNhanVien) {
								if(tk.textField_MaNV.getText().equals(string))
								{
									JOptionPane.showMessageDialog(tk, "Mã nhân viên bị trùng lặp !\nVui lòng nhập lại !","Lỗi",JOptionPane.ERROR_MESSAGE);
									do
									{
										int count = 0;
										String input = JOptionPane.showInputDialog(tk, "Nhập lại mã nhân viên:");

								       	if (input != null && !input.isEmpty()) {
								       		for (String string2 : arrMaNhanVien) {
												if(string2.equals(input))
												{
													JOptionPane.showMessageDialog(tk, "Mã nhân viên bị trùng lặp !\nVui lòng nhập lại !","Lỗi",JOptionPane.ERROR_MESSAGE);
													count=1;
													break;
												}
											}
								        } else {
								            JOptionPane.showMessageDialog(tk, "Bạn không nhập giá trị!");
								            count = 1;
								        }
								       	if(count==0)
								       	{
								       		tk.textField_MaNV.setText(input);
								       		break;
								       	}

									}
									while(true);
								}
								else if(tk.textField_MaNV.getText().equals(""))
								{
									JOptionPane.showMessageDialog(tk, "Mã nhân viên bị bỏ trống !\n Vui lòng nhập mã nhân viên","Lỗi",JOptionPane.ERROR_MESSAGE);

									do
									{
										int count = 0;
										String input = JOptionPane.showInputDialog(tk, "Nhập lại mã nhân viên:");

								       	if (input != null && !input.isEmpty()) {
								       		for (String string2 : arrMaNhanVien) {
												if(string2.equals(input))
												{
													JOptionPane.showMessageDialog(tk, "Mã nhân viên bị trùng lặp !\nVui lòng nhập lại !","Lỗi",JOptionPane.ERROR_MESSAGE);
													count=1;
													break;
												}
											}
								        } else {
								            JOptionPane.showMessageDialog(tk, "Bạn không nhập giá trị!");
								            count = 1;
								        }
								       	if(count==0)
								       	{
								       		tk.textField_MaNV.setText(input);
								       		break;
								       	}

									}
									while(true);
								}
							}
			        		break;
			        	}
			        	nv.setMaNhanVien(tk.textField_MaNV.getText());

			        	nv.setMaNguoiDung(nd.getMaNguoiDung());
			        	if(tk.textField_TaiKhoan.getText().equals("")||tk.textField_MatKhau.getText().equals("")||tk.textField_TaiKhoan.getText().equals("")&&tk.textField_MatKhau.getText().equals(""))
			        	{
			        		nd.setTaiKhoan(nv.getMaNguoiDung());
			        		nd.setMatKhau("1234");
			        	}
			        	else
			        	{
			        		nd.setTaiKhoan(tk.textField_TaiKhoan.getText());
			        		nd.setMatKhau(tk.textField_MatKhau.getText());
			        	}

			        	int result = JOptionPane.showConfirmDialog(tk, "Bạn có chắc muốn thêm tài khoản ?","Xác nhận",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			        	if(result == JOptionPane.YES_OPTION)
			        	{
							int check1 = NguoiDungDAO.getintance().insert(nd);
							int check2 = NhanVienDAO.getintance().insert(nv);

							if(check1 == 1 && check2 ==1)
							{
								JOptionPane.showMessageDialog(tk, "Tài khoản đã được thêm thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
								NhanVienDAO.getintance().WriteUpDateExcel();
								NguoiDungDAO.getintance().WriteUpDateExcel();
								NguoiDungDAO.getintance().UpDateKetHop();
								taikhoanview.updateTableData();
								taikhoanview.setKhoangCachTable();
								taikhoanview.comboBox_maND.addItem(nv.getMaNguoiDung());
							}
							else
							{
								JOptionPane.showMessageDialog(tk, "Tài khoản thêm thất bại", "Thông báo", JOptionPane.ERROR_MESSAGE);
							}
			        	}

					}
				}
			});

        }
        else if(labelText.equals("Xóa"))
        {
        	int selectedRow = taikhoanview.table.getSelectedRow();
    		if(selectedRow != -1 )
    		{	
    			String maNhanVien = (String) taikhoanview.table.getValueAt(selectedRow, 0);
    			nv = NhanVienDAO.getintance().selectById(maNhanVien);
    			
    			int result = JOptionPane.showConfirmDialog(taikhoanview ,
                        "Bạn có chắc muốn xóa tài khoản ?",
                        "Xác nhận",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
            	 if(result == JOptionPane.YES_OPTION){
            		 String s = nv.getMaNguoiDung();
            		for(int j=0;j<taikhoanview.comboBox_maND.getItemCount();j++)
         			{
                 		if(taikhoanview.comboBox_maND.getItemAt(j).equals(s))
                 		{
                 			taikhoanview.comboBox_maND.removeItemAt(j);
                 		}
         			}
            		 int check1 = NhanVienDAO.getintance().delete(nv.getMaNhanVien());
            		 int check2 = NguoiDungDAO.getintance().delete(nv.getMaNguoiDung());
            		 taikhoanview.model.removeRow(selectedRow);
            		 if(check1==1 && check2 ==1)
            		 {
            			 NhanVienDAO.getintance().WriteUpDateExcel();
            			 NguoiDungDAO.getintance().WriteUpDateExcel();
            			 NguoiDungDAO.getintance().UpDateKetHop();
            			 JOptionPane.showMessageDialog(taikhoanview, "Tài khoản đã được xóa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            			 
            		 }
            		 else 
            		 {
            			 JOptionPane.showMessageDialog(taikhoanview, "Tài khoản xóa thất bại", "Thông báo", JOptionPane.ERROR_MESSAGE);

            		 }
            		 clickedLabel.setForeground(Color.BLACK);
            	     clickedLabel.setBackground(null);
                 }
            	 else
            	 {
            		 clickedLabel.setForeground(Color.BLACK);
            	     clickedLabel.setBackground(null);
            	 }

    		}
    		else {
    			 JOptionPane.showMessageDialog(taikhoanview ,
                         "Bạn chưa chọn laptop !",
                         "Lỗi",
                         JOptionPane.ERROR_MESSAGE);
    			 clickedLabel.setForeground(Color.BLACK);
        	     clickedLabel.setBackground(null);
    		}
        }
        else if(labelText.equals("Sửa"))
        {
        	
        	int selectedRow = taikhoanview.table.getSelectedRow();
        	if(selectedRow != -1)
        	{

        		tk = new ThemTaiKhoan();
        		tk.button_huybo.addActionListener(new ActionListener() {

    				@Override
    				public void actionPerformed(ActionEvent e) {
    					if(e.getActionCommand().equals("Hủy bỏ"))
    					{
    						tk.dispose();
    						clickedLabel.setForeground(Color.BLACK);
            		        clickedLabel.setBackground(null);
    					}
    				}
    			});

            	tk.setTitle("Sửa thông tin");
            	tk.lblNewLabel_6.setText("Sửa thông tin tài khoản");
            	tk.addWindowListener(new WindowAdapter() {
        		    @Override
        		    public void windowClosing(WindowEvent e) {
        		        clickedLabel.setForeground(Color.BLACK);
        		        clickedLabel.setBackground(null);
        		    }
        		});

            	String maNV = (String) taikhoanview.table.getValueAt(selectedRow, 0);
            	ArrayList<NhanVien> arrNhanVien = NhanVienDAO.getintance().selectAll();
            	for (NhanVien nhanVien : arrNhanVien) {
					if(nhanVien.getMaNhanVien().equals(maNV))
						nv = nhanVien;
				}
            	ArrayList<NguoiDung> arrNguoiDung = NguoiDungDAO.getintance().selectAll();
            	for (NguoiDung nguoiDung : arrNguoiDung) {
					if(nguoiDung.getMaNguoiDung().equals(nv.getMaNguoiDung()))
						nd = nguoiDung;
				}

            	tk.textField_MaNV.setText(nv.getMaNhanVien());
            	tk.textField_HoTen.setText(nv.getTenNhanVien());
            	tk.textField_MaND.setText(nv.getMaNguoiDung());
            	tk.textField_MatKhau.setText(nd.getMatKhau());
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

    			        	if(tk.textField_TaiKhoan.getText().equals("")||tk.textField_MatKhau.getText().equals("")||tk.textField_TaiKhoan.getText().equals("")&&tk.textField_MatKhau.getText().equals(""))
    			        	{
    			        		nd.setTaiKhoan(nv.getMaNguoiDung());
    			        		nd.setMatKhau("1234");
    			        	}
    			        	else
    			        	{
    			        		nd.setTaiKhoan(tk.textField_TaiKhoan.getText());
    			        		nd.setMatKhau(tk.textField_MatKhau.getText());
    			        	}

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
    								taikhoanview.updateTableData();
    								taikhoanview.setKhoangCachTable();
    							}
    							else
    							{
    								JOptionPane.showMessageDialog(tk, "Tài khoản sửa thất bại", "Thông báo", JOptionPane.ERROR_MESSAGE);
    							}
    			        	}

    					}
    				}
    			});
        	}
        	else
        	{
        		JOptionPane.showMessageDialog(taikhoanview,"Bạn chưa chọn người dùng để sửa !","Lỗi",JOptionPane.ERROR_MESSAGE);
        		clickedLabel.setForeground(Color.BLACK);
       	     	clickedLabel.setBackground(null);
        	}
        }
        else if(labelText.equals("Xuất Excel"))
        {
        	boolean check1 = NguoiDungDAO.getintance().KetHopNguoiDungVaNhanVien();

        	if(check1 == true )
        	{
        		JOptionPane.showMessageDialog(taikhoanview,"Xuất file Excel thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        		clickedLabel.setForeground(Color.BLACK);
       	     	clickedLabel.setBackground(null);
        	}
        	else
        	{
        		JOptionPane.showMessageDialog(taikhoanview,"Xuất file Excel thất bại","Lỗi",JOptionPane.ERROR_MESSAGE);
        		clickedLabel.setForeground(Color.BLACK);
       	     	clickedLabel.setBackground(null);
        	}
        }

        else if(labelText.equals("Nhập Excel"))
        {


        	JFileChooser fileChooser = new JFileChooser();
    		fileChooser.setDialogTitle("Chọn vị trí lưu tệp Excel");
    		fileChooser.setFileFilter(new FileNameExtensionFilter("Excel files", "xlsx"));

    		int userSelection = fileChooser.showSaveDialog(null);
    		if (userSelection == JFileChooser.APPROVE_OPTION) {
    			String filePath = fileChooser.getSelectedFile().getAbsolutePath();
    			ArrayList<NhanVien> nhanvien = NhanVienDAO.getintance().ReadExcelKetHop(filePath);
            	ArrayList<NguoiDung> nguoidung = NguoiDungDAO.getintance().ReadExcelKetHop(filePath);
            	if(nhanvien.isEmpty()==false && nguoidung.isEmpty()==false)
            	{
            		taikhoanview.updateTableData(nguoidung);
            		JOptionPane.showMessageDialog(taikhoanview,"Nhập file Excel thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            		clickedLabel.setForeground(Color.BLACK);
           	     	clickedLabel.setBackground(null);
            	}
            	else
            	{
            		JOptionPane.showMessageDialog(taikhoanview,"Nhập file Excel thất bại","Lỗi",JOptionPane.ERROR_MESSAGE);
            		clickedLabel.setForeground(Color.BLACK);
           	     	clickedLabel.setBackground(null);
            	}
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