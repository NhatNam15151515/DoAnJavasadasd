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
import javax.swing.JTextField;

import view.Phieunhap;

public class Controllerphieunhap {
	private static Phieunhap nh;

	public Controllerphieunhap(Phieunhap nhh) {
		this.nh = nhh;
	}

	public static void addMouseListener(JLabel label, Phieunhap nh) {
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JLabel check = (JLabel) e.getSource();
				if(check==nh.jl_nutadd) {
					nh.moadd();
				}else if(check==nh.jl_nutxoa) {
					nh.xoaphieu();
				}else if(check==nh.jl_nutsua) {
					nh.xemchitietphieu();
				}
			}
		});
	}

	public static void addActionListener(JComboBox label, Phieunhap nh) {
		label.addActionListener(new ActionListener() {
         	public void actionPerformed(ActionEvent e) {
				JComboBox check = (JComboBox) e.getSource();
         		if(check==nh.cmb_ncc) {
					nh.thaydoicombo2();
				}else if(check==nh.cmb_nvn) {
					
				}
         		}
         });
	}
	
	public static void addKeyListener(JTextField jt, Phieunhap nh) {
		jt.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				JTextField check=(JTextField)e.getSource();
					if(check==nh.txtx_timkiem) {
					nh.thanhtimkiem();
				}
			}
		});
	}

	public static void ActionListener(JButton jt, Phieunhap nh) {
		jt.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
	}
}
