package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import controller.Controllernhacungcap;
import dao.nhacungcapDao;
import model.NhaCungCap;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Nhacungcap extends JFrame {
	private JTextField textField;
	private NhaCungCap nhacung1;
	ArrayList<NhaCungCap> dsnhacungcap = nhacungcapDao.getInstance().selectAll();
	public JTextField txtx_timkiem;
	public JLabel jl_nutadd;
	private JTextField tx1;
	private JTextField tx2;
	private JTextField tx4;
	private JTextField tx5;
	private JTextField tx3;
	public JButton btn_them;
	private JButton btn_huy;
	private JPanel panel_conthansp;
	public JTable table;
	public DefaultTableModel model;
	public JLabel jl_nutxoa;
	private JPanel panel_sua;
	private JLabel txt_themmoisanpham;
	public JButton btn_sua;
	public JButton btn_lammoi;
	public JComboBox cbb_timkiem;
	public JLabel jl_nutsua;
	public JPanel panel_cungcap;
	public JPanel panel_menu;
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel jp_chucnang;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Nhacungcap frame = new Nhacungcap();
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
	public Nhacungcap() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1400, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		panel_menu = new JPanel();
		panel_menu.setBackground(new Color(0, 128, 192));
		contentPane.add(panel_menu, BorderLayout.WEST);
		panel_menu.setForeground(new Color(255, 255, 255));
		panel_menu.setBounds(0, 0, 197, 763);
//			panel_cungcap.setBackground(new Color(192, 192, 192));
//			getContentPane().add(panel_cungcap);
		panel_menu.setLayout(new GridLayout(13, 1, 0, 0));
//			scrollPane.setBounds(0, 0, 1189, 602);

		JLabel lblNewLabel = new JLabel("Hi !");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		panel_menu.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Admin");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		panel_menu.add(lblNewLabel_1);

		JLabel jlabel_sanpham = new JLabel("Sản phẩm");
		jlabel_sanpham.setFont(new Font("Arial", Font.PLAIN, 20));
		jlabel_sanpham.setForeground(new Color(255, 255, 255));
		ImageIcon icon_sanpham = new ImageIcon("G:\\My Drive\\DoAnJava\\QuanLyKhoHangLaptop\\src\\img\\product.png");
		jlabel_sanpham.setIcon(icon_sanpham);
		panel_menu.add(jlabel_sanpham);

		JLabel jlabel_nhacungcap = new JLabel("Nhà cung cấp");
		jlabel_nhacungcap.setForeground(Color.WHITE);
		jlabel_nhacungcap.setFont(new Font("Arial", Font.PLAIN, 20));
		ImageIcon icon_nhaCungCap = new ImageIcon(
				"G:\\My Drive\\DoAnJava\\QuanLyKhoHangLaptop\\src\\img\\supplier.png");
		jlabel_nhacungcap.setIcon(icon_nhaCungCap);
		panel_menu.add(jlabel_nhacungcap);

		JLabel jlabel_nhaphang = new JLabel("Nhập hàng");
		jlabel_nhaphang.setForeground(Color.WHITE);
		jlabel_nhaphang.setFont(new Font("Arial", Font.PLAIN, 20));
		ImageIcon icon_nhaphang = new ImageIcon("G:\\My Drive\\DoAnJava\\QuanLyKhoHangLaptop\\src\\img\\nhaphang.png");
		jlabel_nhaphang.setIcon(icon_nhaphang);
		panel_menu.add(jlabel_nhaphang);

		JLabel jlabel_phieunhap = new JLabel("Phiếu nhập");
		jlabel_phieunhap.setForeground(Color.WHITE);
		jlabel_phieunhap.setFont(new Font("Arial", Font.PLAIN, 20));
		ImageIcon icon_phieunhap = new ImageIcon(
				"G:\\My Drive\\DoAnJava\\QuanLyKhoHangLaptop\\src\\img\\phieunhap.png");
		jlabel_phieunhap.setIcon(icon_phieunhap);
		panel_menu.add(jlabel_phieunhap);

		JLabel jlabel_xuathang = new JLabel("Xuất hàng");
		jlabel_xuathang.setForeground(Color.WHITE);
		jlabel_xuathang.setFont(new Font("Arial", Font.PLAIN, 20));
		ImageIcon icon_xuathang = new ImageIcon("G:\\My Drive\\DoAnJava\\QuanLyKhoHangLaptop\\src\\img\\xuathang.png");
		jlabel_xuathang.setIcon(icon_xuathang);
		panel_menu.add(jlabel_xuathang);

		JLabel jlabel_phieuxuat = new JLabel("Phiếu xuất");
		jlabel_phieuxuat.setForeground(Color.WHITE);
		jlabel_phieuxuat.setFont(new Font("Arial", Font.PLAIN, 20));
		ImageIcon icon_phieuxuat = new ImageIcon(
				"G:\\My Drive\\DoAnJava\\QuanLyKhoHangLaptop\\src\\img\\phieuxuat.png");
		jlabel_phieuxuat.setIcon(icon_phieuxuat);
		panel_menu.add(jlabel_phieuxuat);

		JLabel jlabel_cuahang = new JLabel("Cửa hàng");
		jlabel_cuahang.setForeground(Color.WHITE);
		jlabel_cuahang.setFont(new Font("Arial", Font.PLAIN, 20));
		ImageIcon icon_cuahang = new ImageIcon("G:\\My Drive\\DoAnJava\\QuanLyKhoHangLaptop\\src\\img\\store.png");
		jlabel_cuahang.setIcon(icon_cuahang);
		panel_menu.add(jlabel_cuahang);

		JLabel jlabel_taikhoan = new JLabel("Tài khoản");
		jlabel_taikhoan.setForeground(Color.WHITE);
		jlabel_taikhoan.setFont(new Font("Arial", Font.PLAIN, 20));
		ImageIcon icon_taikhoan = new ImageIcon("G:\\My Drive\\DoAnJava\\QuanLyKhoHangLaptop\\src\\img\\taikhoan.png");
		jlabel_taikhoan.setIcon(icon_taikhoan);
		panel_menu.add(jlabel_taikhoan);

		JLabel jlabel_thongke = new JLabel("Thống kê");
		jlabel_thongke.setForeground(Color.WHITE);
		jlabel_thongke.setFont(new Font("Arial", Font.PLAIN, 20));
		ImageIcon icon_thongke = new ImageIcon("G:\\My Drive\\DoAnJava\\QuanLyKhoHangLaptop\\src\\img\\thongke.png");
		jlabel_thongke.setIcon(icon_thongke);
		panel_menu.add(jlabel_thongke);

		JLabel jlabel_đổiThongtin = new JLabel("Đổi thông tin");
		jlabel_đổiThongtin.setForeground(Color.WHITE);
		jlabel_đổiThongtin.setFont(new Font("Arial", Font.PLAIN, 20));
		ImageIcon icon_doithongtin = new ImageIcon(
				"G:\\My Drive\\DoAnJava\\QuanLyKhoHangLaptop\\src\\img\\thongtin.png");
		jlabel_đổiThongtin.setIcon(icon_doithongtin);
		panel_menu.add(jlabel_đổiThongtin);

		JLabel jlabel_dangxuat = new JLabel("Đăng xuất");
		jlabel_dangxuat.setForeground(Color.WHITE);
		jlabel_dangxuat.setFont(new Font("Arial", Font.PLAIN, 20));
		ImageIcon icon_dangxuat = new ImageIcon("G:\\My Drive\\DoAnJava\\QuanLyKhoHangLaptop\\src\\img\\dangxuat.png");
		jlabel_dangxuat.setIcon(icon_dangxuat);
		panel_menu.add(jlabel_dangxuat);

		JPanel panel_cungcap = new JPanel();
		panel_cungcap.setBounds(197, 0, 1189, 763);
		contentPane.add(panel_cungcap, BorderLayout.CENTER);
		panel_cungcap.setLayout(new BorderLayout(0, 0));

		jp_chucnang = new JPanel();
		jp_chucnang.setBounds(10, 10, 398, 97);
//			jp_chucnang.setLayout(new FlowLayout());
//			jp_chucnang.setLayout(new FlowLayout(FlowLayout.LEFT, 50, 50)); // Thiết lập FlowLayout với khoảng cách giữa các thành phần là 10px
		jp_chucnang.setLayout(new GridLayout(1, 2, 50, 50));
		panel_cungcap.add(jp_chucnang, BorderLayout.NORTH);

		JPanel jc_cntrai = new JPanel();
		jc_cntrai.setBounds(10, 10, 398, 97);
		jc_cntrai.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		jp_chucnang.add(jc_cntrai);
		jc_cntrai.setLayout(new GridLayout(2, 5, 0, 0));

		JPanel jp_timkiem = new JPanel();
		jp_timkiem.setBounds(450, 10, 695, 97);
		jp_timkiem.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"T\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		jp_chucnang.add(jp_timkiem);
		jp_timkiem.setLayout(new GridLayout(1, 3, 2, 2));

		cbb_timkiem = new JComboBox();
		cbb_timkiem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jp_timkiem.add(cbb_timkiem);
//				jp_chucnang.setLayout(null);
		cbb_timkiem.addItem("Tất cả");
		cbb_timkiem.addItem("Mã cung cấp");
		cbb_timkiem.addItem("Địa chỉ");
		cbb_timkiem.addItem("Số điện thoại");
		cbb_timkiem.addItem("Email");
		cbb_timkiem.addItem("Tên");

		cbb_timkiem.setSelectedIndex(0);

		txtx_timkiem = new JTextField();
		jp_timkiem.add(txtx_timkiem);
		txtx_timkiem.setColumns(10);

		ImageIcon icon_lammoi = new ImageIcon(
				"D:\\LUYENTAPJAVA\\DoAnJava-main\\QuanLyKhoHangLaptop\\src\\img\\loadicon.png");
//				JLabel jlabel_them = new JLabel("Thêm", icon_add, JLabel.CENTER);
		btn_lammoi = new JButton("Làm mới", icon_lammoi);
		btn_lammoi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btn_lammoi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jp_timkiem.add(btn_lammoi);
		///////// chan///////////////
		// them
		ImageIcon icon_add = new ImageIcon("D:\\LUYENTAPJAVA\\DoAnJava-main\\QuanLyKhoHangLaptop\\src\\img\\plus.png");
		JLabel jl_chuthem = new JLabel("Thêm");
		jl_chuthem.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jl_chuthem.setBounds(15, 63, 45, 21);
		jl_nutadd = new JLabel("");
		jl_nutadd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jl_nutadd.setBounds(15, 13, 33, 55);
		jl_nutadd.setIcon(icon_add);
		jc_cntrai.add(jl_nutadd);
		ImageIcon icon_xoa = new ImageIcon(
				"D:\\LUYENTAPJAVA\\DoAnJava-main\\QuanLyKhoHangLaptop\\src\\img\\remove.png");
		JLabel jl_chuxoa = new JLabel("Xóa");
		jl_chuxoa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jl_chuxoa.setBounds(86, 63, 33, 21);
		jl_nutxoa = new JLabel("");
		jl_nutxoa.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jl_nutxoa.setBounds(80, 13, 39, 55);
		jl_nutxoa.setIcon(icon_xoa);
		jc_cntrai.add(jl_nutxoa);
		ImageIcon icon_sua = new ImageIcon(
				"D:\\LUYENTAPJAVA\\DoAnJava-main\\QuanLyKhoHangLaptop\\src\\img\\pencil.png");
		jl_nutsua = new JLabel("");
		jl_nutsua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jl_nutsua.setBounds(142, 13, 39, 55);
		jl_nutsua.setIcon(icon_sua);
		JLabel jl_chusua = new JLabel("Sửa");
		jl_chusua.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jl_chusua.setBounds(142, 63, 28, 21);
		jc_cntrai.add(jl_nutsua);

		ImageIcon icon_xuatexcel = new ImageIcon(
				"D:\\LUYENTAPJAVA\\DoAnJava-main\\QuanLyKhoHangLaptop\\src\\img\\xuatExcel.png");
		JLabel jl_nutxuatexcel = new JLabel("");
		jl_nutxuatexcel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jl_nutxuatexcel.setBounds(220, 13, 33, 55);
		jc_cntrai.add(jl_nutxuatexcel);
		JLabel jl_chuxuatexcel = new JLabel("Xuất Excel");
		jl_chuxuatexcel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jl_chuxuatexcel.setBounds(208, 63, 70, 21);
		jl_nutxuatexcel.setIcon(icon_xuatexcel);

		ImageIcon icon_nhapexcel = new ImageIcon(
				"D:\\LUYENTAPJAVA\\DoAnJava-main\\QuanLyKhoHangLaptop\\src\\img\\xuatExcel.png");
		JLabel jl_nutnhapexcel = new JLabel("");
		jl_nutnhapexcel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jl_nutnhapexcel.setBounds(301, 13, 70, 55);
		jc_cntrai.add(jl_nutnhapexcel);
		JLabel jl_chunhapexcel = new JLabel("Nhập Excel");
		jl_chunhapexcel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jl_chunhapexcel.setBounds(300, 63, 88, 21);
		jl_nutnhapexcel.setIcon(icon_nhapexcel);

		jc_cntrai.add(jl_chuthem);
		jc_cntrai.add(jl_chuxoa);
		jc_cntrai.add(jl_chusua);
		jc_cntrai.add(jl_chuxuatexcel);
		jc_cntrai.add(jl_chunhapexcel);

		JPanel panel_sanpham = new JPanel();
		panel_sanpham.setBounds(0, 0, 1189, 763);
		panel_cungcap.add(panel_sanpham);
		panel_sanpham.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1189, 763);
		panel_sanpham.add(scrollPane);
		String column[] = { "Mã NCC", "Tên nhà cung cấp", "Địa chỉ", "Số điện thoại", "Email" };
		Object data[][] = {};
		table = new JTable(data, column);
		table.setForeground(new Color(0, 0, 0));
		table.setDefaultEditor(Object.class, null);
		table.setModel(new DefaultTableModel(new Object[][] {

		}, new String[] { "Mã NCC", "Tên nhà cung cấp", "Địa chỉ", "Số điện thoại", "Email" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(15);
		table.getColumnModel().getColumn(1).setPreferredWidth(150);
		table.getColumnModel().getColumn(2).setPreferredWidth(190);
		table.getColumnModel().getColumn(3).setPreferredWidth(15);
		table.getColumnModel().getColumn(4).setPreferredWidth(40);
		model = (DefaultTableModel) table.getModel();
		for (NhaCungCap nc : dsnhacungcap) {
			model.addRow(new Object[] { nc.getMaNhaCungCap(), nc.getTenNhaCungCap(), nc.getDiaChi(), nc.getSDT(),
					nc.getEmail() });
		}
		table.getTableHeader().setResizingAllowed(false);
		table.getTableHeader().setReorderingAllowed(false);
		JTableHeader header = table.getTableHeader();
		header.setFont(new Font("Arial", Font.BOLD, 14));
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		scrollPane.setViewportView(table);

		Controllernhacungcap.addMouseListener(jl_nutadd, this);
		Controllernhacungcap.addMouseListener(jl_nutxoa, this);
		Controllernhacungcap.addMouseListener(jl_nutsua, this);
		Controllernhacungcap.addKeyListener(txtx_timkiem, this);
		Controllernhacungcap.ActionListener(btn_lammoi, this);

	}

	public void hienaddnhacungcap() {
		int i = table.getSelectedRow();
		AddNhaCungCap framee = new AddNhaCungCap(this);
		framee.setVisible(true);
	}

	public void hiensuanhacungcap() {
		int i = table.getSelectedRow();
//			public NhaCungCap(String maNhaCungCap, String tenNhaCungCap, String diaChi, String sDT, String email) {
		String mnc = model.getValueAt(i, 0) + "";
		String tnc = model.getValueAt(i, 1) + "";
		String dc = model.getValueAt(i, 2) + "";
		String sdt = model.getValueAt(i, 3) + "";
		String email = model.getValueAt(i, 4) + "";
		nhacung1 = new NhaCungCap(mnc, tnc, dc, sdt, email);
		FixNhaCungCap frame = new FixNhaCungCap(this, 2, nhacung1);
		frame.setVisible(true);
	}

	public void nhannutxoa() {
		int i = table.getSelectedRow();
		if (i < 0)
			JOptionPane.showConfirmDialog(null, "Bạn chưa chọn dòng cần xóa", "THÔNG BÁO", JOptionPane.CLOSED_OPTION);
		else {
			int luachon = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn xóa nó không ?");
			if (luachon == JOptionPane.YES_OPTION) {
				String mnc = model.getValueAt(i, 0) + "";
				String tnc = model.getValueAt(i, 1) + "";
				String dc = model.getValueAt(i, 2) + "";
				String sdt = model.getValueAt(i, 3) + "";
				String email = model.getValueAt(i, 4) + "";
				NhaCungCap nc1 = new NhaCungCap(mnc, tnc, dc, sdt, email);
				nhacungcapDao.getInstance().delete1(nc1);
				model.removeRow(i);
			}
		}
	}

	public void nutlammoi() {
		model.setRowCount(0);
		txtx_timkiem.setText("");
		for (NhaCungCap nc : dsnhacungcap) {
			model.addRow(new Object[] { nc.getMaNhaCungCap(), nc.getTenNhaCungCap(), nc.getTenNhaCungCap(),
					nc.getTenNhaCungCap(), nc.getEmail() });
		}
		cbb_timkiem.setSelectedIndex(0);

	}

	public void thanhtimkiem() {
		dsnhacungcap = nhacungcapDao.getInstance().selectAll();
		String text = txtx_timkiem.getText();
		model.setRowCount(0);
		String timitem = cbb_timkiem.getSelectedItem() + "";
		if (timitem.equals("Tất cả")) {
			for (NhaCungCap nc : dsnhacungcap) {
				if (nc.getMaNhaCungCap().toLowerCase().contains(text.toLowerCase())
						|| nc.getEmail().toLowerCase().contains(text.toLowerCase())
						|| nc.getTenNhaCungCap().toLowerCase().contains(text.toLowerCase())
						|| (nc.getTenNhaCungCap() + "").toLowerCase().contains(text.toLowerCase())
						|| nc.getEmail().toLowerCase().contains(text.toLowerCase())) {
					model.addRow(new Object[] { nc.getMaNhaCungCap(), nc.getTenNhaCungCap(), nc.getDiaChi(),
							nc.getSDT(), nc.getEmail() });
				}

			}
		}
		if (timitem.equals("Tên")) {
			for (NhaCungCap nc : dsnhacungcap) {
				if (nc.getTenNhaCungCap().toLowerCase().contains(text.toLowerCase())) {
					model.addRow(new Object[] { nc.getMaNhaCungCap(), nc.getTenNhaCungCap(), nc.getDiaChi(),
							nc.getSDT(), nc.getEmail() });
				}

			}
		} else if (timitem.equals("Mã cung cấp")) {
			for (NhaCungCap nc : dsnhacungcap) {
				if (nc.getMaNhaCungCap().toLowerCase().contains(text.toLowerCase())) {
					model.addRow(new Object[] { nc.getMaNhaCungCap(), nc.getTenNhaCungCap(), nc.getDiaChi(),
							nc.getSDT(), nc.getEmail() });
				}

			}
		}

		else if (timitem.equals("Địa chỉ")) {
			for (NhaCungCap nc : dsnhacungcap) {
				if (nc.getDiaChi().toLowerCase().contains(text.toLowerCase())) {
					model.addRow(new Object[] { nc.getMaNhaCungCap(), nc.getTenNhaCungCap(), nc.getDiaChi(),
							nc.getSDT(), nc.getEmail() });
				}

			}
		}

		else if (timitem.equals("Số điện thoại")) {
			for (NhaCungCap nc : dsnhacungcap) {
				if ((nc.getSDT() + "").toLowerCase().contains(text.toLowerCase())) {
					model.addRow(new Object[] { nc.getMaNhaCungCap(), nc.getTenNhaCungCap(), nc.getDiaChi(),
							nc.getSDT(), nc.getEmail() });
				}

			}
		}

		else if (timitem.equals("Email")) {
			for (NhaCungCap nc : dsnhacungcap) {
				if (nc.getEmail().toLowerCase().contains(text.toLowerCase())) {
					model.addRow(new Object[] { nc.getMaNhaCungCap(), nc.getTenNhaCungCap(), nc.getDiaChi(),
							nc.getSDT(), nc.getEmail() });
				}

			}
		}
	}
}
