package controller;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import view.XuatHang;

public class Controllerxuathang {
	private static XuatHang nh;
	public Controllerxuathang(XuatHang nhh) {
		this.nh=nhh;
	}
	
	public static void addMouseListener(JLabel label,XuatHang nh) {
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel check = (JLabel) e.getSource();
		        
			}
		});
	}
	
	public static void addKeyListener(JTextField jt,XuatHang nh) {
		jt.addKeyListener(new KeyAdapter() {
		@Override
		public void keyReleased(KeyEvent e) {
			if(e.getSource()==nh.jt_otimkiem) {
				nh.thanhtimkiem();
			}
		}	
	});
	}
	
	
	public static void ActionListener(JButton jt,XuatHang nh) {
		jt.addMouseListener(new MouseAdapter() {
		 	@Override
		 	public void mouseClicked(MouseEvent e) {
		 		if(e.getSource()== nh.btn_themsp) {
					nh.themsanpham();
				}
				else if(e.getSource()==nh.btn_xoasp) {
					nh.xoasanpham();
				}else if(e.getSource()==nh.btn_lammoi) {
					nh.lammoithanh();
				
				}else if(e.getSource()==nh.btn_nhaphang) {
					nh.NhapHang();
				}else if(e.getSource()==nh.btn_suasoluong){
					nh.suasl();
				}
		 	}
		 });
	}
}
