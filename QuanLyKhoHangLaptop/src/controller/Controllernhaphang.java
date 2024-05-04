package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

import view.Phieunhap;
import view.NhapHang;

public class Controllernhaphang {
	private static NhapHang nh;

	public Controllernhaphang(NhapHang nhh) {
		this.nh = nhh;
	}

	public static void addMouseListener(JLabel label, NhapHang nh) {
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel check = (JLabel) e.getSource();
				
			}
		});
	}

	public static void addMouseListener(JTable label, NhapHang nh) {
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JTable check = (JTable) e.getSource();
				if(check==nh.table) {
					nh.themsanpham();
				}else if(check==nh.table1) {
					nh.clickvaotable1();
				}
			}
		});
	}
	
	public static void addActionListener(JComboBox label, NhapHang nh) {
		label.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
				JComboBox check = (JComboBox) e.getSource();
         		
         		}
         });
	}
	
	public static void addKeyListener(JTextField jt, NhapHang nh) {
		jt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				JTextField check=(JTextField)e.getSource();
				if(check==nh.jt_soluong) {
					nh.hiengiakhithem();
				}else if (check==nh.jt_otimkiem){
					nh.thanhtimkiem();
				}
			}
		});
	}

	
	
	public static void ActionListener(JButton jt, NhapHang nh) {
		jt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JButton check=(JButton)e.getSource();
				if(check==nh.btn_themsp) {
					nh.themvaobang();
				}else if(check==nh.btn_nhaphang) {
					nh.nhaphang();
				}else if(check ==nh.btn_quaylai) {
					nh.nutquaylai();
				}else if(check==nh.btn_timkiem) {
					nh.lammoithanh();
				}else if(check==nh.btn_xoasp) {
					nh.xoasanphamthem();
				}else if(check==nh.btn_suasp) {
					nh.suasanphamthem();
				}
			}
		});
	}
}
