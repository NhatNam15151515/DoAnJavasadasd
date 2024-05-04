package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.CuaHangDAO;
import dao.PhieuNhapDao;
import dao.PhieuXuatDao;
import dao.nhacungcapDao;
import model.NhaCungCap;
import model.ChiTietPhieuNhap;
import model.ChiTietPhieuXuat;
import model.CuaHang;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Xemchitietxuat extends JFrame {
//	ArrayList<NhaCungCap> nhacungcap;
	   ArrayList<ChiTietPhieuXuat> ctpn;
  CuaHang nc1;
	String tennv,tennhacc;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	public JPanel panel_xemchitiet;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Xemchitietnhap frame = new Xemchitietnhap();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public Xemchitietxuat(String maphieun,String macuahang,String ngayn,String tennhanvien) {
		this.ctpn=PhieuXuatDao.getInstance().laydulieutuphieu(maphieun);
		this.nc1=CuaHangDAO.getintance().selectById(macuahang);
		tennv=tennhanvien;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
//		setBounds(100, 100, 1115, 546);
		setBounds(100, 100, 1300, 546);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		 panel_xemchitiet = new JPanel();
		panel_xemchitiet.setBackground(new Color(255, 255, 255));
		contentPane.add(panel_xemchitiet);
		panel_xemchitiet.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel_xemchitiet.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1, 3, 0, 0));
		panel.setOpaque(true);
		
		JPanel panel1 = new JPanel();
		panel1.setBackground(new Color(255, 255, 255));
		panel.add(panel1);
		panel1.setOpaque(true);
		panel1.setLayout(new GridLayout(3, 1, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Trường Đại Học Sài Gòn");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Địa chỉ: 273 Đ. An Dương Vương");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Điện thoại: 02838354409");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel1.add(lblNewLabel_2);
		
		JPanel panel2 = new JPanel();
		panel2.setBackground(new Color(255, 255, 255));
		panel.add(panel2);
		
		JPanel panel3 = new JPanel();
		panel3.setBackground(new Color(255, 255, 255));
		panel.add(panel3);
		panel3.setLayout(new GridLayout(2, 1, 0, 0));
		
		JLabel jl_laytime = new JLabel("Ngày: "+ngayn);
		jl_laytime.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel3.add(jl_laytime);
		
		JLabel jl_layma = new JLabel("Mã phiếu: "+maphieun);
		jl_layma.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel3.add(jl_layma);
		
		JPanel panel_1 = new JPanel();
		panel_xemchitiet.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_3 = new JLabel("PHIẾU XUẤT HÀNG");
		lblNewLabel_3.setBackground(new Color(255, 255, 255));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setOpaque(true);
		panel_1.add(lblNewLabel_3, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new GridLayout(1, 4, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(255, 255, 255));
		panel_3.add(panel_4);
		panel_4.setLayout(new GridLayout(4, 1, 0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("Tên cửa hàng: "+nc1.getTenCH());
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		lblNewLabel_4.setText(nc1.getTenNhaCungCap());
		panel_4.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Mã cửa hàng: "+nc1.getMaCH());
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_4.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Địa chỉ: "+nc1.getDiaChi());
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_4.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Số điện thoại: "+nc1.getSDT());
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_4.add(lblNewLabel_7);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(255, 255, 255));
		panel_3.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(255, 255, 255));
		panel_3.add(panel_6);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(new Color(255, 255, 255));
		panel_3.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel_9 = new JLabel("Nhân viên: "+tennv);
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_7.add(lblNewLabel_9);
		
		JPanel panel_8 = new JPanel();
		panel_2.add(panel_8, BorderLayout.SOUTH);
		panel_8.setLayout(new GridLayout(1, 4, 0, 0));
		
		JPanel panel_10 = new JPanel();
		panel_8.add(panel_10);
		panel_10.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_14 = new JPanel();
		panel_14.setBackground(new Color(255, 255, 255));
		panel_10.add(panel_14, BorderLayout.WEST);
		JPanel panel_15 = new JPanel();
		panel_15.setBackground(new Color(255, 255, 255));
		panel_10.add(panel_15, BorderLayout.CENTER);
		panel_15.setLayout(new GridLayout(3, 1, 0, 0));
		
		JLabel lblNewLabel_10 = new JLabel("Đại diện cửa hàng");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_15.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("(Ký họ tên)");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_15.add(lblNewLabel_11);
		
		JLabel lblNewLabel_113 = new JLabel(""+nc1.getTenCH());
		lblNewLabel_113.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_113.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_15.add(lblNewLabel_113);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(new Color(255, 255, 255));
		panel_8.add(panel_11);
		
		JPanel panel_12 = new JPanel();
		panel_12.setBackground(new Color(255, 255, 255));
		panel_8.add(panel_12);
		
		JPanel panel_13 = new JPanel();
		panel_13.setBackground(new Color(255, 255, 255));
		panel_8.add(panel_13);
		panel_13.setLayout(new GridLayout(3, 1, 0, 0));
		
		JLabel lblNewLabel_13 = new JLabel("Người lập phiếu");
		lblNewLabel_13.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 20));
		panel_13.add(lblNewLabel_13);
		
		JLabel lblNewLabel_12 = new JLabel("(Ký họ tên)");
		lblNewLabel_12.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_13.add(lblNewLabel_12);
		
		JLabel lblNewLabel_123 = new JLabel(""+tennv);
		lblNewLabel_123.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_123.setFont(new Font("Tahoma", Font.PLAIN, 15));
		panel_13.add(lblNewLabel_123);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(255, 255, 255));
		panel_2.add(panel_9, BorderLayout.CENTER);
		 String column []= {"Mã sản phẩm","Số lượng","Thành tiền"};
			Object data [][]= {};
			 panel_9.setLayout(new BorderLayout(0, 0));
//			 panel_phai.setLayout(new BorderLayout(0, 0));
			 table = new JTable(data,column);
			 table.setBackground(new Color(255, 255, 255));
			 JScrollPane scrollPane = new JScrollPane(table);
			 scrollPane.setBounds(197, 0, 100, 100);
			 panel_9.add(scrollPane);
			table.setDefaultEditor(Object.class, null);
			table.setModel(new DefaultTableModel(
				new Object[][] {			
				},
				new String[] {
						"Mã sản phẩm","Số lượng","Thành tiền"
				}
			));
			
			 model = (DefaultTableModel) table.getModel();
			for (ChiTietPhieuXuat sp : ctpn) {
//				stt++;
				DecimalFormat df2 = new DecimalFormat("#");
			     String formattedNumber2 = df2.format(sp.getThanhTien());
			    model.addRow(new Object[] {
			    		sp.getMaLaptop(),sp.getSoLuong(),formattedNumber2
			    });
			}
			table.getTableHeader().setResizingAllowed(false);
			table.getTableHeader().setReorderingAllowed(false);
//		JLabel lblNewLabel = new JLabel("Thông tin phiếu nhập");
//		lblNewLabel.setOpaque(true);
//		lblNewLabel.setBackground(new Color(0, 128, 255));
//		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
//		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		panel.add(lblNewLabel);
//		
//		JPanel panel_1 = new JPanel();
//		contentPane.add(panel_1, BorderLayout.CENTER);
		
	}

}
