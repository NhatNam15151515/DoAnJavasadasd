package view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class PhieuXuat extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JLabel Label_Tittle_PhieuXuat;
	private JPanel panel_NgayXuat;
	private JLabel Label_NgayXuat_Title_Ngay;
	private JLabel Label_CH_Content_DiaChi;
	private JLabel Label_CH_Content_DienThoai;
	private JLabel Label_CH_Title_DiaChi;
	private JLabel Label_CH_Content_MaCH;
	private JLabel Label_CH_Content_TenCH;
	private JLabel Label_CH_Title_MaCH;
	private JLabel Label_CH_Title_TenCH;
	private JPanel panel_CH;
	private JLabel Label_NV_Content_TenNV;
	private JLabel Label_NV_Title_TenNV;
	private JLabel Label_NV_Content_EmailNV;
	private JLabel Label_NV_Title_EmailNV;
	private JPanel panel_NV;
	private JLabel Label_ThongTinKho_Title_DienThoai;
	private JLabel Label_ThongTinKho_Title_DiaChi;
	private JLabel Label_ThongTinKho_Content_DienThoai;
	private JLabel Label_ThongTinKho_Content_DiaChi;
	private JLabel Label_ThongTinKho_Title_TenKho;
	private JPanel panel_ThongTinKho;
	private JLabel Label_NgayXuat_Content_MaHD;
	private JLabel Label_NgayXuat_Content_Ngay;
	private JLabel Label_NgayXuat_Title_MaHD;
	private JLabel Label_CH_Title_DienThoai;
	private JPanel panel_DanhSachSP;
	private JPanel panel_CH_KyTen;
	private JLabel Label_NV_KyTen_Title_KyTen;
	private JLabel Label_NV_KyTen_Title_NguoiLapPhieu;
	private JPanel panel_NV_KyTen;
	private JLabel Label_CH_KyTen_Title_KyTen;
	private JLabel Label_CH_KyTen_Title_DaiDienCH;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PhieuXuat frame = new PhieuXuat();
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
	
	public PhieuXuat() {
		this.setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 840, 730);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		Label_Tittle_PhieuXuat = new JLabel("PHIẾU XUẤT HÀNG");
		Label_Tittle_PhieuXuat.setFont(new Font("Arial", Font.BOLD, 25));
		Label_Tittle_PhieuXuat.setBounds(296, 97, 236, 37);
		contentPane.add(Label_Tittle_PhieuXuat);

		panel_NgayXuat = new JPanel();
		panel_NgayXuat.setBackground(new Color(255, 255, 255));
		panel_NgayXuat.setBounds(592, 11, 160, 60);
		contentPane.add(panel_NgayXuat);
		panel_NgayXuat.setLayout(null);

		Label_NgayXuat_Title_Ngay = new JLabel("Ngày:");
		Label_NgayXuat_Title_Ngay.setBounds(7, 11, 35, 13);
		Label_NgayXuat_Title_Ngay.setFont(new Font("Arial", Font.BOLD, 12));
		panel_NgayXuat.add(Label_NgayXuat_Title_Ngay);

		Label_NgayXuat_Title_MaHD = new JLabel("Mã HĐ:");
		Label_NgayXuat_Title_MaHD.setFont(new Font("Arial", Font.BOLD, 12));
		Label_NgayXuat_Title_MaHD.setBounds(7, 35, 40, 13);
		panel_NgayXuat.add(Label_NgayXuat_Title_MaHD);

		Label_NgayXuat_Content_Ngay = new JLabel("24/03/2023");
		Label_NgayXuat_Content_Ngay.setFont(new Font("Arial", Font.PLAIN, 12));
		Label_NgayXuat_Content_Ngay.setBounds(50, 7, 62, 20);
		panel_NgayXuat.add(Label_NgayXuat_Content_Ngay);

		Label_NgayXuat_Content_MaHD = new JLabel("HD001");
		Label_NgayXuat_Content_MaHD.setFont(new Font("Arial", Font.PLAIN, 12));
		Label_NgayXuat_Content_MaHD.setBounds(50, 31, 101, 20);
		panel_NgayXuat.add(Label_NgayXuat_Content_MaHD);

		panel_ThongTinKho = new JPanel();
		panel_ThongTinKho.setBackground(new Color(255, 255, 255));
		panel_ThongTinKho.setBounds(10, 11, 438, 60);
		contentPane.add(panel_ThongTinKho);
		panel_ThongTinKho.setLayout(null);

		Label_ThongTinKho_Title_TenKho = new JLabel("Trường Đại Học Sài Gòn");
		Label_ThongTinKho_Title_TenKho.setBounds(10, 0, 416, 18);
		Label_ThongTinKho_Title_TenKho.setFont(new Font("Arial", Font.BOLD, 16));
		panel_ThongTinKho.add(Label_ThongTinKho_Title_TenKho);

		Label_ThongTinKho_Content_DiaChi = new JLabel("Đ.7, Phong Phú, TP HCM");
		Label_ThongTinKho_Content_DiaChi.setFont(new Font("Arial", Font.PLAIN, 12));
		Label_ThongTinKho_Content_DiaChi.setBounds(60, 20, 368, 18);
		panel_ThongTinKho.add(Label_ThongTinKho_Content_DiaChi);

		Label_ThongTinKho_Content_DienThoai = new JLabel("039*******");
		Label_ThongTinKho_Content_DienThoai.setFont(new Font("Arial", Font.PLAIN, 12));
		Label_ThongTinKho_Content_DienThoai.setBounds(80, 37, 346, 18);
		panel_ThongTinKho.add(Label_ThongTinKho_Content_DienThoai);

		Label_ThongTinKho_Title_DiaChi = new JLabel("Địa Chỉ :");
		Label_ThongTinKho_Title_DiaChi.setFont(new Font("Arial", Font.PLAIN, 12));
		Label_ThongTinKho_Title_DiaChi.setBounds(10, 20, 47, 18);
		panel_ThongTinKho.add(Label_ThongTinKho_Title_DiaChi);

		Label_ThongTinKho_Title_DienThoai = new JLabel("Điện Thoại :");
		Label_ThongTinKho_Title_DienThoai.setFont(new Font("Arial", Font.PLAIN, 12));
		Label_ThongTinKho_Title_DienThoai.setBounds(10, 37, 66, 18);
		panel_ThongTinKho.add(Label_ThongTinKho_Title_DienThoai);

		panel_NV = new JPanel();
		panel_NV.setBackground(new Color(255, 255, 255));
		panel_NV.setLayout(null);
		panel_NV.setBounds(592, 130, 222, 60);
		contentPane.add(panel_NV);

		Label_NV_Title_EmailNV = new JLabel("Email:");
		Label_NV_Title_EmailNV.setFont(new Font("Arial", Font.BOLD, 12));
		Label_NV_Title_EmailNV.setBounds(7, 30, 40, 13);
		panel_NV.add(Label_NV_Title_EmailNV);

		Label_NV_Content_EmailNV = new JLabel("zzbestnamzz@gmail.com");
		Label_NV_Content_EmailNV.setFont(new Font("Arial", Font.PLAIN, 12));
		Label_NV_Content_EmailNV.setBounds(44, 26, 168, 20);
		panel_NV.add(Label_NV_Content_EmailNV);

		Label_NV_Title_TenNV = new JLabel("Nhân Viên:");
		Label_NV_Title_TenNV.setFont(new Font("Arial", Font.BOLD, 12));
		Label_NV_Title_TenNV.setBounds(7, 10, 64, 13);
		panel_NV.add(Label_NV_Title_TenNV);

		Label_NV_Content_TenNV = new JLabel("Trần Ngô Nhật Nam");
		Label_NV_Content_TenNV.setFont(new Font("Arial", Font.PLAIN, 12));
		Label_NV_Content_TenNV.setBounds(71, 6, 141, 20);
		panel_NV.add(Label_NV_Content_TenNV);

		panel_CH = new JPanel();
		panel_CH.setBackground(new Color(255, 255, 255));
		panel_CH.setLayout(null);
		panel_CH.setBounds(10, 130, 249, 89);
		contentPane.add(panel_CH);

		Label_CH_Title_TenCH = new JLabel("Tên CH:");
		Label_CH_Title_TenCH.setFont(new Font("Arial", Font.BOLD, 12));
		Label_CH_Title_TenCH.setBounds(10, 10, 53, 13);
		panel_CH.add(Label_CH_Title_TenCH);

		Label_CH_Title_MaCH = new JLabel("Mã CH:");
		Label_CH_Title_MaCH.setFont(new Font("Arial", Font.BOLD, 12));
		Label_CH_Title_MaCH.setBounds(10, 30, 53, 14);
		panel_CH.add(Label_CH_Title_MaCH);

		Label_CH_Content_TenCH = new JLabel("Thế giới di động");
		Label_CH_Content_TenCH.setFont(new Font("Arial", Font.PLAIN, 12));
		Label_CH_Content_TenCH.setBounds(56, 6, 182, 20);
		panel_CH.add(Label_CH_Content_TenCH);

		Label_CH_Content_MaCH = new JLabel("TGDD");
		Label_CH_Content_MaCH.setFont(new Font("Arial", Font.PLAIN, 12));
		Label_CH_Content_MaCH.setBounds(52, 27, 182, 20);
		panel_CH.add(Label_CH_Content_MaCH);

		Label_CH_Title_DiaChi = new JLabel("Địa Chỉ:");
		Label_CH_Title_DiaChi.setFont(new Font("Arial", Font.BOLD, 12));
		Label_CH_Title_DiaChi.setBounds(10, 50, 53, 14);
		panel_CH.add(Label_CH_Title_DiaChi);

		Label_CH_Content_DiaChi = new JLabel("Đ.7, Phong Phú, TP HCM");
		Label_CH_Content_DiaChi.setFont(new Font("Arial", Font.PLAIN, 12));
		Label_CH_Content_DiaChi.setBounds(56, 47, 182, 20);
		panel_CH.add(Label_CH_Content_DiaChi);

		Label_CH_Content_DienThoai = new JLabel("039*******");
		Label_CH_Content_DienThoai.setFont(new Font("Arial", Font.PLAIN, 12));
		Label_CH_Content_DienThoai.setBounds(76, 67, 172, 20);
		panel_CH.add(Label_CH_Content_DienThoai);

		Label_CH_Title_DienThoai = new JLabel("Điện Thoại:");
		Label_CH_Title_DienThoai.setFont(new Font("Arial", Font.BOLD, 12));
		Label_CH_Title_DienThoai.setBounds(10, 70, 63, 14);
		panel_CH.add(Label_CH_Title_DienThoai);

		panel_DanhSachSP = new JPanel();
		panel_DanhSachSP.setBackground(new Color(255, 255, 255));
		panel_DanhSachSP.setBounds(10, 219, 804, 274);
		contentPane.add(panel_DanhSachSP);
		panel_DanhSachSP.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(null);
		scrollPane.setBounds(10, 0, 784, 263);
		panel_DanhSachSP.add(scrollPane);

		table = new JTable();
		table.setBackground(new Color(255, 255, 255));
		scrollPane.setViewportView(table);
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		table.setModel(new DefaultTableModel(
				new Object[][] { { 1, "Laptop HP Gaming Victus 15-FB1023AX 94F20PA", "36 TH\u00C1NG", "Chi\u1EBFc",
						1000, 1000.0f, 1.2345679E10f }, },
				new String[] { "STT", "T\u00EAn H\u00E0ng", "B\u1EA3o H\u00E0nh", "\u0110VT", "SL",
						"\u0110\u01A1n Gi\u00E1", "Th\u00E0nh Ti\u1EC1n" }) {
			/**
							 * 
							 */
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] { Integer.class, String.class, String.class, String.class, Integer.class,
					Float.class, Float.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(15);
		table.getColumnModel().getColumn(0).setMinWidth(5);
		table.getColumnModel().getColumn(1).setPreferredWidth(340);
		table.getColumnModel().getColumn(2).setPreferredWidth(30);
		table.getColumnModel().getColumn(3).setPreferredWidth(20);
		table.getColumnModel().getColumn(4).setPreferredWidth(15);
		table.getColumnModel().getColumn(4).setMinWidth(0);
		table.getColumnModel().getColumn(5).setPreferredWidth(45);
		table.getColumnModel().getColumn(6).setPreferredWidth(55);

		panel_CH_KyTen = new JPanel();
		panel_CH_KyTen.setBackground(new Color(255, 255, 255));
		panel_CH_KyTen.setBounds(68, 493, 215, 85);
		contentPane.add(panel_CH_KyTen);
		panel_CH_KyTen.setLayout(null);

		Label_CH_KyTen_Title_DaiDienCH = new JLabel("Đại Diện Cửa Hàng");
		Label_CH_KyTen_Title_DaiDienCH.setBounds(0, 5, 215, 18);
		Label_CH_KyTen_Title_DaiDienCH.setHorizontalAlignment(SwingConstants.CENTER);
		Label_CH_KyTen_Title_DaiDienCH.setFont(new Font("Arial", Font.BOLD, 15));
		panel_CH_KyTen.add(Label_CH_KyTen_Title_DaiDienCH);

		Label_CH_KyTen_Title_KyTen = new JLabel("(Ký Họ,tên)");
		Label_CH_KyTen_Title_KyTen.setHorizontalAlignment(SwingConstants.CENTER);
		Label_CH_KyTen_Title_KyTen.setFont(new Font("Arial", Font.PLAIN, 11));
		Label_CH_KyTen_Title_KyTen.setBounds(78, 26, 59, 13);
		panel_CH_KyTen.add(Label_CH_KyTen_Title_KyTen);

		panel_NV_KyTen = new JPanel();
		panel_NV_KyTen.setBackground(new Color(255, 255, 255));
		panel_NV_KyTen.setLayout(null);
		panel_NV_KyTen.setBounds(537, 493, 215, 85);
		contentPane.add(panel_NV_KyTen);

		Label_NV_KyTen_Title_NguoiLapPhieu = new JLabel("Người Lập Phiếu");
		Label_NV_KyTen_Title_NguoiLapPhieu.setHorizontalAlignment(SwingConstants.CENTER);
		Label_NV_KyTen_Title_NguoiLapPhieu.setFont(new Font("Arial", Font.BOLD, 15));
		Label_NV_KyTen_Title_NguoiLapPhieu.setBounds(40, 5, 132, 18);
		panel_NV_KyTen.add(Label_NV_KyTen_Title_NguoiLapPhieu);

		Label_NV_KyTen_Title_KyTen = new JLabel("(Ký Họ,tên)");
		Label_NV_KyTen_Title_KyTen.setHorizontalAlignment(SwingConstants.CENTER);
		Label_NV_KyTen_Title_KyTen.setFont(new Font("Arial", Font.PLAIN, 11));
		Label_NV_KyTen_Title_KyTen.setBounds(78, 26, 59, 13);
		panel_NV_KyTen.add(Label_NV_KyTen_Title_KyTen);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER); // Căn lề văn bản theo trung tâm

		// Thiết lập căn lề cho từng cột trong JTable
		for (int i = 0; i < 5; i++) {
			table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
		}
		Font headerFont = table.getTableHeader().getFont();
		table.getTableHeader().setFont(headerFont.deriveFont(Font.BOLD));
	}

	public void ChangeInformationToPhieuNhap() {
		Label_Tittle_PhieuXuat.setText("PHIẾU NHẬP HÀNG");

		Label_CH_Title_TenCH.setText("Tên NCC:");
		Label_CH_Title_TenCH.setBounds(10, 10, 54, 13);
		Label_CH_Content_TenCH.setBounds(63, 6, 179, 20);
		Label_CH_Title_MaCH.setText("Mã NCC:");

		Label_CH_Title_MaCH.setBounds(10, 30, 54, 14);
		Label_CH_Content_MaCH.setBounds(60, 27, 179, 20);
		Label_CH_KyTen_Title_DaiDienCH.setText("Đại Diện Nhà Cung Cấp");
	}
	public void ChangeInformationToPhieuXuat() {
		Label_Tittle_PhieuXuat.setText("PHIẾU XUẤT HÀNG");

		Label_CH_Title_TenCH.setText("Tên CH:");
		Label_CH_Title_TenCH.setBounds(10, 10, 53, 13);
		Label_CH_Content_TenCH.setBounds(56, 6, 182, 20);
		
		Label_CH_Title_MaCH.setText("Mã CH:");
		Label_CH_Title_MaCH.setBounds(10, 30, 53, 14);
		Label_CH_Content_MaCH.setBounds(52, 27, 182, 20);

		Label_CH_KyTen_Title_DaiDienCH.setText("Đại Diện Cửa Hàng");
	}
}
