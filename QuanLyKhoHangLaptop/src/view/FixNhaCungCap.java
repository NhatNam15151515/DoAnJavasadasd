package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import model.NhaCungCap;
import dao.nhacungcapDao;

import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FixNhaCungCap extends JFrame {
	private static Nhacungcap ncc;
	private static int t;
	private static NhaCungCap nc;

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel txt_themmoisanpham;
	private JTextField tx1;
	private JTextField tx2;
	private JTextField tx4;
	private JTextField tx5;
	private JTextField tx3;
	private JButton btn_them;
	private JButton btn_huy;
	private JButton btn_sua;
	private JLabel lblNewLabel;

//	public AddNhaCungCap(NhaCungCap tmp) {
//	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FixNhaCungCap frame = new FixNhaCungCap(ncc,t,nc);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FixNhaCungCap(Nhacungcap tmp,int sa,NhaCungCap nhacung) {
		this.ncc=tmp;
		this.t=sa;
		this.nc=nhacung;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(250, 150, 580, 326);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		getContentPane().setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setBackground(new Color(255, 255, 255));
		
//		panel_conthansp.setBackground(new Color(255, 255, 255));
//		panel_conthansp.setBounds(250, 150, 580, 326);
//		panel_conthansp.setLayout(null);
//		panel_conthansp.setVisible(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
//		JLabel lblNewLabel = new JLabel("Thêm sản phẩm mới");
//		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		lblNewLabel.setBounds(0, 0, 640, 48);
//		contentPane.add(lblNewLabel);
//		
//		JLabel lblMNhCung = new JLabel("Mã nhà cung cấp");
//		lblMNhCung.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		lblMNhCung.setBounds(33, 41, 152, 38);
//		contentPane.add(lblMNhCung);
//		
//		textField = new JTextField();
//		textField.setBounds(33, 78, 164, 38);
//		contentPane.add(textField);
//		textField.setColumns(10);
//		
//		JLabel lblTnNhCung = new JLabel("Tên nhà cung cấp");
//		lblTnNhCung.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		lblTnNhCung.setBounds(33, 126, 164, 38);
//		contentPane.add(lblTnNhCung);
//		
//		textField_1 = new JTextField();
//		textField_1.setColumns(10);
//		textField_1.setBounds(33, 163, 164, 38);
//		contentPane.add(textField_1);
//		
//		JLabel lblEmail = new JLabel("Email");
//		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		lblEmail.setBounds(33, 214, 152, 38);
//		contentPane.add(lblEmail);
//		
//		textField_2 = new JTextField();
//		textField_2.setColumns(10);
//		textField_2.setBounds(33, 251, 164, 38);
//		contentPane.add(textField_2);
//		
//		JLabel lblaCh = new JLabel("Địa chỉ");
//		lblaCh.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		lblaCh.setBounds(278, 41, 152, 38);
//		contentPane.add(lblaCh);
//		
//		textField_3 = new JTextField();
//		textField_3.setColumns(10);
//		textField_3.setBounds(278, 78, 164, 38);
//		contentPane.add(textField_3);
//		
//		JLabel lblSinThoi = new JLabel("Số điện thoại");
//		lblSinThoi.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		lblSinThoi.setBounds(278, 126, 152, 38);
//		contentPane.add(lblSinThoi);
//		
//		textField_4 = new JTextField();
//		textField_4.setColumns(10);
//		textField_4.setBounds(278, 163, 164, 38);
//		contentPane.add(textField_4);
		
		
//		 panel_conthansp = new JPanel();
//			panel_conthansp.setBackground(new Color(255, 255, 255));
//			panel_conthansp.setBounds(250, 150, 580, 326);
//			panel_conthansp.setLayout(null);
//			panel_conthansp.setVisible(false);
//			layeredPane.add(panel_conthansp, JLayeredPane.PALETTE_LAYER);
		
			
			 txt_themmoisanpham = new JLabel();
			 txt_themmoisanpham.setHorizontalAlignment(SwingConstants.CENTER);
				 txt_themmoisanpham.setText("Sửa sản phẩm");
					txt_themmoisanpham.setBackground(new Color(0, 128, 192));
					txt_themmoisanpham.setFont(new Font("Tahoma", Font.PLAIN, 20));
					txt_themmoisanpham.setBounds(0, 0, 566, 48);
					txt_themmoisanpham.setOpaque(true);
					contentPane.add(txt_themmoisanpham);
			 
			 
			JLabel txt_mncc = new JLabel("Mã nhà cung cấp");
			txt_mncc.setFont(new Font("Tahoma", Font.PLAIN, 20));
			txt_mncc.setBounds(44, 61, 152, 30);
			contentPane.add(txt_mncc);
			
			tx1 = new JTextField();
			tx1.setText(nc.getMaNhaCungCap());
			tx1.setBounds(44, 86, 212, 36);
			contentPane.add(tx1);
			tx1.setColumns(10);
			if(t==2) 	 		tx1.setEnabled(false);
			JLabel tx_tencc = new JLabel("Tên nhà cung cấp");
			tx_tencc.setFont(new Font("Tahoma", Font.PLAIN, 20));
			tx_tencc.setBounds(44, 138, 195, 30);
			contentPane.add(tx_tencc);
			
			tx2 = new JTextField();
			tx2.setText(nc.getTenNhaCungCap());
			tx2.setColumns(10);
			tx2.setBounds(44, 163, 212, 36);
			contentPane.add(tx2);
			
			JLabel txtdc = new JLabel("Địa chỉ");
			txtdc.setFont(new Font("Tahoma", Font.PLAIN, 20));
			txtdc.setBounds(338, 58, 98, 30);
			contentPane.add(txtdc);
			
			tx4 = new JTextField();
			tx4.setText(nc.getDiaChi());
			tx4.setColumns(10);
			tx4.setBounds(338, 83, 212, 36);
			contentPane.add(tx4);
			
			JLabel txtsdt = new JLabel("Số điện thoại");
			txtsdt.setFont(new Font("Tahoma", Font.PLAIN, 20));
			txtsdt.setBounds(338, 135, 126, 30);
			contentPane.add(txtsdt);
			
			tx5 = new JTextField();
			tx5.setText(nc.getSDT());
			tx5.setColumns(10);
			tx5.setBounds(338, 163, 212, 36);
			contentPane.add(tx5);
			
			JLabel txtem = new JLabel("Email");
			txtem.setFont(new Font("Tahoma", Font.PLAIN, 20));
			txtem.setBounds(44, 219, 98, 30);
			contentPane.add(txtem);
			
			tx3 = new JTextField();
			tx3.setText(nc.getEmail());
			tx3.setColumns(10);
			tx3.setBounds(44, 244, 212, 36);
			contentPane.add(tx3);

				 btn_them = new JButton("Sửa");
				 btn_them.addMouseListener(new MouseAdapter() {
					 	@Override
					 	public void mouseClicked(MouseEvent e) {
					 		int i=ncc.table.getSelectedRow();
//				       	 String mnc=tx1.getText();
							String tnc=tx2.getText();
							String email=tx3.getText();
							String dc=tx4.getText();
							String sdt=tx5.getText();
							
//				       	 	model.setValueAt(tx1.getText(), i, 0);
				       	 	ncc.model.setValueAt(tx2.getText(), i, 1);
				       	 	ncc.model.setValueAt(tx4.getText(), i, 2);
				       	 	ncc.model.setValueAt(tx5.getText(), i, 3);
				       	 	ncc.model.setValueAt(tx3.getText(), i, 4);
							NhaCungCap nc2=new NhaCungCap(ncc.model.getValueAt(i, 0)+"",tnc,dc,sdt,email);
							nhacungcapDao.getInstance().update(nc2);
							JOptionPane.showMessageDialog(null, "Sửa sản phẩm thành công");
							JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(btn_them);
			                currentFrame.dispose();	
					 	}
					 });
			
			 
			btn_them.setBackground(new Color(0, 255, 0));
			btn_them.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btn_them.setBounds(302, 239, 118, 36);
			contentPane.add(btn_them);
			 btn_huy = new JButton("Hủy");
			 btn_huy.addMouseListener(new MouseAdapter() {
			 	@Override
			 	public void mouseClicked(MouseEvent e) {
//			 		setVisible(false);
			 		JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(btn_huy);
	                currentFrame.dispose();
			 	}
			 });
			btn_huy.setForeground(new Color(64, 0, 64));
			btn_huy.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btn_huy.setBounds(432, 239, 118, 36);
			btn_huy.setBackground(Color.RED);
			contentPane.add(btn_huy);
			
			btn_sua = new JButton("SỬA");
			btn_sua.setBackground(new Color(0, 255, 0));
			btn_sua.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btn_sua.setBounds(302, 239, 118, 36);
			contentPane.add(btn_sua);
			
			
			
	}

}
