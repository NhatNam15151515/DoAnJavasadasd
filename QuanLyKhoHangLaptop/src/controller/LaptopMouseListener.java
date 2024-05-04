package controller;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import dao.LaptopDAO;
import model.Laptop;
import view.laptopview;
import view.ThemSanPham;
import view.XemChiTiet;

public class LaptopMouseListener implements MouseListener{

	private laptopview laptopview ;
	
	public LaptopMouseListener(laptopview laptopview) {
		this.laptopview = laptopview;
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
        	ThemSanPham add = new ThemSanPham();
        	add.addWindowListener(new WindowAdapter() {
    		    @Override
    		    public void windowClosing(WindowEvent e) {
    		        clickedLabel.setForeground(Color.BLACK);
    		        clickedLabel.setBackground(null);
    		    }
    		});
        	Laptop lt = new Laptop();
        	
        	add.comboBox_Ram.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String selected_Ram = (String) add.comboBox_Ram.getSelectedItem();
					lt.setRam(selected_Ram);
					
				}
			});
        	
        	
			add.comboBox_Rom.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String selected_Rom = (String) add.comboBox_Rom.getSelectedItem();
					lt.setRom(selected_Rom);
				}
			});
			
			
			add.comboBox_Nam.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String selected_nam = (String) add.comboBox_Nam.getSelectedItem();
					lt.setNamSanXuat(Integer.parseInt(selected_nam));
				}
			});
			
			
			add.comboBox_MaNCC.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					String select_MaNCC = (String) add.comboBox_MaNCC.getSelectedItem();
					lt.setMaNhaCungCap(select_MaNCC);
				}
			});
			
			
			
			String defaultSelected_Ram = (String) add.comboBox_Ram.getSelectedItem();
        	String defaultSelected_Rom = (String) add.comboBox_Rom.getSelectedItem();
        	String defaultSelected_Nam = (String) add.comboBox_Nam.getSelectedItem();
        	String defaultSelected_MaNCC = (String) add.comboBox_MaNCC.getSelectedItem();
        	lt.setRam(defaultSelected_Ram);
        	lt.setRom(defaultSelected_Rom);
        	lt.setNamSanXuat(Integer.parseInt(defaultSelected_Nam));
			lt.setMaNhaCungCap(defaultSelected_MaNCC);
			
        	add.jbutton_xacnhan.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					
		        	lt.setTenLaptop(add.getText(add.jtextField_tensanpham));
		        	lt.setCPU(add.getText(add.jtextField_CPU));
		        	lt.setGPU(add.getText(add.jtextField_GPU));
		        	lt.setHeDieuHanh(add.getText(add.jtextField_hedieuhanh));
		        	lt.setManHinh(add.getText(add.jtextField_manhinh));
		        	lt.setHang(add.getText(add.jtextField_Hang));
		        	ArrayList<String> arrMaLaptop = new ArrayList<String>();
		        	while(true)
		        	{
		        		arrMaLaptop = LaptopDAO.getintance().getColumn("MaLaptop");
		        		for (String string : arrMaLaptop) {
							if(add.jtextField_masanpham.getText().equals(string))
							{
								JOptionPane.showMessageDialog(add, "Mã Laptop bị trùng lặp !\nVui lòng nhập lại !","Lỗi",JOptionPane.ERROR_MESSAGE);
								do
								{
									int count = 0;
									String input = JOptionPane.showInputDialog(add, "Nhập lại mã laptop:");
									
							       	if (input != null && !input.isEmpty()) {
							       		for (String string2 : arrMaLaptop) {
											if(string2.equals(input))
											{
												JOptionPane.showMessageDialog(add, "Mã Laptop bị trùng lặp !\nVui lòng nhập lại !","Lỗi",JOptionPane.ERROR_MESSAGE);
												count=1;
												break;
											}
										}
							        } else {
							            JOptionPane.showMessageDialog(add, "Bạn không nhập giá trị!");
							            count = 1;
							        }
							       	if(count==0)
							       	{
							       		add.jtextField_masanpham.setText(input);
							       		break;
							       	}
							       	
								}
								while(true);
							}
							else if(add.jtextField_masanpham.getText().equals(""))
							{
								JOptionPane.showMessageDialog(add, "Mã Laptop bị bỏ trống !\n Vui lòng nhập mã laptop","Lỗi",JOptionPane.ERROR_MESSAGE);
							
								do
								{
									int count = 0;
									String input = JOptionPane.showInputDialog(add, "Nhập lại mã laptop:");
									
							       	if (input != null && !input.isEmpty()) {
							       		for (String string2 : arrMaLaptop) {
											if(string2.equals(input))
											{
												JOptionPane.showMessageDialog(add, "Mã Laptop bị trùng lặp !\nVui lòng nhập lại !","Lỗi",JOptionPane.ERROR_MESSAGE);
												count=1;
												break;
											}
										}
							        } else {
							            JOptionPane.showMessageDialog(add, "Bạn không nhập giá trị!");
							            count = 1;
							        }
							       	if(count==0)
							       	{
							       		add.jtextField_masanpham.setText(input);
							       		lt.setMaLaptop(add.getText(add.jtextField_masanpham));
							       		break;
							       	}
							       	
								}
								while(true);
							}
						}
		        		break;
		        	}
					lt.setMaLaptop(add.getText(add.jtextField_masanpham));
		        	try {
						lt.setGia(Double.parseDouble(add.getText(add.jtextField_gia)));
					} catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(add,"Giá không hợp lệ !","Lỗi",JOptionPane.ERROR_MESSAGE);
						lt.setGia(0);
						e1.printStackTrace();
					}
					
		        	
		        	String src = e.getActionCommand();
					if(src.equals("Xác nhận"))
					{
						
			        	int result = JOptionPane.showConfirmDialog(add, "Bạn có chắc muốn thêm sản phẩm ?","Xác nhận",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			        	if(result == JOptionPane.YES_OPTION)
			        	{
							LaptopDAO.getintance().insert(lt);
							ArrayList<Laptop> Laptop = LaptopDAO.getintance().selectAll();
							laptopview.updateTableData(Laptop);
							JOptionPane.showMessageDialog(add, "Sản phẩm đã được thêm thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
							LaptopDAO.getintance().WriteUpDateExcel();
			        	}
					}
				}
			});
        	
        	
        	add.jbutton_huybo.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String src = e.getActionCommand();
					if(src.equals("Hủy bỏ"))
					{
						add.dispose();
						clickedLabel.setForeground(Color.BLACK);
	            	    clickedLabel.setBackground(null);
					}
				}
			});
        	
        }
        else if(labelText.equals("Xóa"))
        {
        	int selectedRow = laptopview.table.getSelectedRow();
    		if(selectedRow != -1 )
    		{	
    			Laptop lt = new Laptop();
    			Object malaptop = laptopview.table.getValueAt(selectedRow, 0);
    			lt.setMaLaptop(malaptop+"");
    			int result = JOptionPane.showConfirmDialog(laptopview ,
                        "Bạn có chắc muốn xóa sản phẩm ?",
                        "Xác nhận",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE);
            	 if(result == JOptionPane.YES_OPTION){
            		 LaptopDAO.getintance().delete(lt.getMaLaptop());
            		 laptopview.model.removeRow(selectedRow);
            		 ArrayList<Laptop> Laptop = LaptopDAO.getintance().selectAll();
            		 laptopview.updateTableData(Laptop);
            		 clickedLabel.setForeground(Color.BLACK);
            	     clickedLabel.setBackground(null);
            		 JOptionPane.showMessageDialog(laptopview, "Sản phẩm đã được xóa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
            		 LaptopDAO.getintance().WriteUpDateExcel();
                 }
            	 else
            	 {
            		 clickedLabel.setForeground(Color.BLACK);
            	     clickedLabel.setBackground(null);
            	 }
            	 
    		}
    		else {
    			 JOptionPane.showMessageDialog(laptopview ,
                         "Bạn chưa chọn laptop !",
                         "Lỗi",
                         JOptionPane.ERROR_MESSAGE);
    			 clickedLabel.setForeground(Color.BLACK);
        	     clickedLabel.setBackground(null);
    		}
        	
        }
        else if(labelText.equals("Sửa"))
        {
        		
        	/*Laptop[] lt = new Laptop[1];
        	    
        	int selectedRow = laptopview.table.getSelectedRow();
        	if (selectedRow != -1) {
        		SuaSanPham sua = new SuaSanPham();
            	sua.addWindowListener(new WindowAdapter() {
            	@Override
            	public void windowClosing(WindowEvent e) {
            		clickedLabel.setForeground(Color.BLACK);
            		clickedLabel.setBackground(null);
            		}
            	});
        	    Object malaptop = laptopview.table.getValueAt(selectedRow, 0);
        	    lt[0] = new Laptop();
        	    lt[0].setMaLaptop(malaptop + "");
        	    lt[0] = LaptopDAO.getintance().selectById(lt[0]);
        	    sua.setJtextField(lt[0]);
        	       
        	    
        	    sua.comboBox_Ram.addActionListener(new ActionListener() {
    				
    				@Override
    				public void actionPerformed(ActionEvent e) {
    					String selected_Ram = (String) sua.comboBox_Ram.getSelectedItem();
    					lt[0].setRam(selected_Ram);
    					
    				}
    			});
            	
            	
    			sua.comboBox_Rom.addActionListener(new ActionListener() {
    				
    				@Override
    				public void actionPerformed(ActionEvent e) {
    					String selected_Rom = (String) sua.comboBox_Rom.getSelectedItem();
    					lt[0].setRom(selected_Rom);
    				}
    			});
    			
    			
    			sua.comboBox_Nam.addActionListener(new ActionListener() {
    				
    				@Override
    				public void actionPerformed(ActionEvent e) {
    					String selected_nam = (String) sua.comboBox_Nam.getSelectedItem();
    					lt[0].setNamSanXuat(Integer.parseInt(selected_nam));
    				}
    			});
            	
    			sua.comboBox_MaNCC.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						String selected_MaNCC = (String) sua.comboBox_MaNCC.getSelectedItem();
						lt[0].setMaNhaCungCap(selected_MaNCC);
					}
				});
        	  
			
        	    
        	    
        	    sua.jbutton_xacnhan.addActionListener(new ActionListener() {
    				String ma = lt[0].getMaLaptop();
    				@Override
    				public void actionPerformed(ActionEvent e) {
    					
    		        	lt[0].setTenLaptop(sua.getText(sua.jtextField_tensanpham));
    		        	lt[0].setCPU(sua.getText(sua.jtextField_CPU));
    		        	lt[0].setGPU(sua.getText(sua.jtextField_GPU));
    		        	lt[0].setHeDieuHanh(sua.getText(sua.jtextField_hedieuhanh));
    		        	lt[0].setManHinh(sua.getText(sua.jtextField_manhinh));
    		        	lt[0].setHang(sua.getText(sua.jtextField_Hang));
    					lt[0].setMaLaptop(sua.getText(sua.jtextField_masanpham));
    		        	try {
    						lt[0].setGia(Double.parseDouble(sua.getText(sua.jtextField_gia)));
    					} catch (NumberFormatException e1) {
    						JOptionPane.showMessageDialog(sua,"Giá không hợp lệ !","Lỗi",JOptionPane.ERROR_MESSAGE);
    						lt[0].setGia(0);
    						e1.printStackTrace();
    					}
    					
    		        	
    		        	String src = e.getActionCommand();
    					if(src.equals("Xác nhận"))
    					{
    						
    			        	int result = JOptionPane.showConfirmDialog(sua, "Bạn có chắc muốn sửa sản phẩm ?","Xác nhận",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
    			        	if(result == JOptionPane.YES_OPTION)
    			        	{
    							LaptopDAO.getintance().updateALL(lt[0],ma);
    							ArrayList<Laptop> Laptop = LaptopDAO.getintance().selectAll();
    							laptopview.updateTableData(Laptop);
    							JOptionPane.showMessageDialog(sua, "Sản phẩm đã được sửa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    							
    			        	}
    					}
    				}
    			});
            	
            	
            	sua.jbutton_huybo.addActionListener(new ActionListener() {
    				
    				@Override
    				public void actionPerformed(ActionEvent e) {
    					// TODO Auto-generated method stub
    					String src = e.getActionCommand();
    					if(src.equals("Hủy bỏ"))
    					{
    						sua.dispose();
    						clickedLabel.setForeground(Color.BLACK);
    	            	    clickedLabel.setBackground(null);
    					}
    				}
    			});
        	}
        	else
        	{
        		JOptionPane.showMessageDialog(laptopview,"Bạn chưa chọn sản phảm để sửa !","Lỗi",JOptionPane.ERROR_MESSAGE);
        		clickedLabel.setForeground(Color.BLACK);
       	     	clickedLabel.setBackground(null);
        	}*/   
        	
        	
        	Laptop[] lt = new Laptop[1];
    	    
        	int selectedRow = laptopview.table.getSelectedRow();
        	if (selectedRow != -1) {
        		ThemSanPham sua = new ThemSanPham();
        		sua.setTitle("Sửa sản phẩm");
        		sua.lblNewLabel.setText("Sửa sản phẩm");
            	sua.addWindowListener(new WindowAdapter() {
            	@Override
            	public void windowClosing(WindowEvent e) {
            		clickedLabel.setForeground(Color.BLACK);
            		clickedLabel.setBackground(null);
            		}
            	});
        	    Object malaptop = laptopview.table.getValueAt(selectedRow, 0);
        	    lt[0] = new Laptop();
        	    lt[0].setMaLaptop(malaptop + "");
        	    lt[0] = LaptopDAO.getintance().selectById(lt[0]);
        	    sua.setJtextField(lt[0]);
        	       
        	    
        	    sua.comboBox_Ram.addActionListener(new ActionListener() {
    				
    				@Override
    				public void actionPerformed(ActionEvent e) {
    					String selected_Ram = (String) sua.comboBox_Ram.getSelectedItem();
    					lt[0].setRam(selected_Ram);
    					
    				}
    			});
            	
            	
    			sua.comboBox_Rom.addActionListener(new ActionListener() {
    				
    				@Override
    				public void actionPerformed(ActionEvent e) {
    					String selected_Rom = (String) sua.comboBox_Rom.getSelectedItem();
    					lt[0].setRom(selected_Rom);
    				}
    			});
    			
    			
    			sua.comboBox_Nam.addActionListener(new ActionListener() {
    				
    				@Override
    				public void actionPerformed(ActionEvent e) {
    					String selected_nam = (String) sua.comboBox_Nam.getSelectedItem();
    					lt[0].setNamSanXuat(Integer.parseInt(selected_nam));
    				}
    			});
            	
    			sua.comboBox_MaNCC.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						String selected_MaNCC = (String) sua.comboBox_MaNCC.getSelectedItem();
						lt[0].setMaNhaCungCap(selected_MaNCC);
					}
				});
        	  
			
        	    
        	    
        	    sua.jbutton_xacnhan.addActionListener(new ActionListener() {
    				String ma = lt[0].getMaLaptop();
    				@Override
    				public void actionPerformed(ActionEvent e) {
    					
    		        	lt[0].setTenLaptop(sua.getText(sua.jtextField_tensanpham));
    		        	lt[0].setCPU(sua.getText(sua.jtextField_CPU));
    		        	lt[0].setGPU(sua.getText(sua.jtextField_GPU));
    		        	lt[0].setHeDieuHanh(sua.getText(sua.jtextField_hedieuhanh));
    		        	lt[0].setManHinh(sua.getText(sua.jtextField_manhinh));
    		        	lt[0].setHang(sua.getText(sua.jtextField_Hang));
    					lt[0].setMaLaptop(sua.getText(sua.jtextField_masanpham));
    		        	try {
    						lt[0].setGia(Double.parseDouble(sua.getText(sua.jtextField_gia)));
    					} catch (NumberFormatException e1) {
    						JOptionPane.showMessageDialog(sua,"Giá không hợp lệ !","Lỗi",JOptionPane.ERROR_MESSAGE);
    						lt[0].setGia(0);
    						e1.printStackTrace();
    					}
    					
    		        	
    		        	String src = e.getActionCommand();
    					if(src.equals("Xác nhận"))
    					{
    						
    			        	int result = JOptionPane.showConfirmDialog(sua, "Bạn có chắc muốn sửa sản phẩm ?","Xác nhận",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
    			        	if(result == JOptionPane.YES_OPTION)
    			        	{
    							LaptopDAO.getintance().updateALL(lt[0],ma);
    							ArrayList<Laptop> Laptop = LaptopDAO.getintance().selectAll();
    							laptopview.updateTableData(Laptop);
    							JOptionPane.showMessageDialog(sua, "Sản phẩm đã được sửa thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    							LaptopDAO.getintance().WriteUpDateExcel();
    			        	}
    					}
    				}
    			});
            	
            	
            	sua.jbutton_huybo.addActionListener(new ActionListener() {
    				
    				@Override
    				public void actionPerformed(ActionEvent e) {
    					// TODO Auto-generated method stub
    					String src = e.getActionCommand();
    					if(src.equals("Hủy bỏ"))
    					{
    						sua.dispose();
    						clickedLabel.setForeground(Color.BLACK);
    	            	    clickedLabel.setBackground(null);
    					}
    				}
    			});
        	}
        	else
        	{
        		JOptionPane.showMessageDialog(laptopview,"Bạn chưa chọn sản phảm để sửa !","Lỗi",JOptionPane.ERROR_MESSAGE);
        		clickedLabel.setForeground(Color.BLACK);
       	     	clickedLabel.setBackground(null);
        	}    
        	
        }
        else if(labelText.equals("Xem chi tiết"))
        {
        	int selectedRow = laptopview.table.getSelectedRow();
        	if(selectedRow != -1)
        	{
        		Object malaptop = laptopview.table.getValueAt(selectedRow,0);
        		XemChiTiet xemct = new XemChiTiet();
        		Laptop lt = new Laptop();
        		lt.setMaLaptop(malaptop+"");
        		lt = LaptopDAO.getintance().selectById(lt);
        		xemct.setJLabel(lt);
        		xemct.addWindowListener(new WindowAdapter() {
        		    @Override
        		    public void windowClosing(WindowEvent e) {
        		        clickedLabel.setForeground(Color.BLACK);
        		        clickedLabel.setBackground(null);
        		    }
        		});
        	}
        	else
        	{
        		JOptionPane.showMessageDialog(laptopview,"Bạn chưa chọn sản phảm để xem !","Lỗi",JOptionPane.ERROR_MESSAGE);
        		clickedLabel.setForeground(Color.BLACK);
       	     	clickedLabel.setBackground(null);
        	}
        }
		
        else if(labelText.equals("Xuất Excel"))
        {
        	boolean check = LaptopDAO.getintance().WriteExcel();
        	if(check == true)
        	{
        		JOptionPane.showMessageDialog(laptopview,"Xuất file Excel thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        		clickedLabel.setForeground(Color.BLACK);
       	     	clickedLabel.setBackground(null);
        	}
        	else
        	{
        		JOptionPane.showMessageDialog(laptopview,"Xuất file Excel thất bại","Lỗi",JOptionPane.ERROR_MESSAGE);
        		clickedLabel.setForeground(Color.BLACK);
       	     	clickedLabel.setBackground(null);
        	}
        	
        }
		
        else if(labelText.equals("Nhập Excel"))
        {
        	ArrayList<Laptop> lt = LaptopDAO.getintance().ReadExcel();
        	if(lt.isEmpty()==false)
        	{
        		laptopview.updateTableData(lt);
        		JOptionPane.showMessageDialog(laptopview,"Nhập file Excel thành công", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
        		clickedLabel.setForeground(Color.BLACK);
       	     	clickedLabel.setBackground(null);
        	}
        	else
        	{
        		JOptionPane.showMessageDialog(laptopview,"Nhập file Excel thất bại","Lỗi",JOptionPane.ERROR_MESSAGE);
        		clickedLabel.setForeground(Color.BLACK);
       	     	clickedLabel.setBackground(null);
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

}

