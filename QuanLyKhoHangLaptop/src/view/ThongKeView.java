package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import controller.ThongKeActionListener;
import controller.ThongKeMouseListener;
import dao.PhieuNhapDao;
import dao.PhieuXuatDao;
import img.Source;

public class ThongKeView extends JPanel {

	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	private Source source = new Source();
	public JComboBox<Object> comboBox_ThoiGian;
	public JComboBox<Object> comboBox_NgayBD;
	public JComboBox<Object> comboBox_NgayKT;
	public String[] dateFormat = { "dd/MM/yyyy", "MM/yyyy", "yyyy" };
	public JComboBox<Object> comboBox_CongViec;
	public JPanel panel_Center;
	public BieuDoThongKeSP bd = new BieuDoThongKeSP();

	public ThongKeView() {
		setLayout(new BorderLayout(0, 0));
		this.setBounds(0, 0, 1200, 770);
		JPanel panel_ChucNang = new JPanel();
		add(panel_ChucNang, BorderLayout.NORTH);
		GridBagLayout gbl_panel_ChucNang = new GridBagLayout();
		gbl_panel_ChucNang.columnWidths = new int[] { 100, 296, 100, 296 };
		gbl_panel_ChucNang.rowHeights = new int[] { 30, 30 };
		gbl_panel_ChucNang.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0 };
		gbl_panel_ChucNang.rowWeights = new double[] { 0.0, 0.0 };
		panel_ChucNang.setLayout(gbl_panel_ChucNang);

		JLabel Label_ThoiGian = new JLabel("Thời gian");
		Label_ThoiGian.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_Label_ThoiGian = new GridBagConstraints();
		gbc_Label_ThoiGian.fill = GridBagConstraints.BOTH;
		gbc_Label_ThoiGian.insets = new Insets(5, 0, 5, 5);
		gbc_Label_ThoiGian.gridx = 0;
		gbc_Label_ThoiGian.gridy = 0;
		panel_ChucNang.add(Label_ThoiGian, gbc_Label_ThoiGian);
		String[] ThoiGian = { "Thống kê theo ngày", "Thống kê theo tháng", "Thống kê theo năm" };
		comboBox_ThoiGian = new JComboBox<Object>(ThoiGian);
		comboBox_ThoiGian.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_comboBox_ThoiGian = new GridBagConstraints();
		gbc_comboBox_ThoiGian.fill = GridBagConstraints.BOTH;
		gbc_comboBox_ThoiGian.insets = new Insets(5, 0, 5, 85);
		gbc_comboBox_ThoiGian.gridx = 1;
		gbc_comboBox_ThoiGian.gridy = 0;
		panel_ChucNang.add(comboBox_ThoiGian, gbc_comboBox_ThoiGian);

		JLabel Label_NgayBD = new JLabel("Ngày bắt đầu");
		Label_NgayBD.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_Label_NgayBD = new GridBagConstraints();
		gbc_Label_NgayBD.fill = GridBagConstraints.BOTH;
		gbc_Label_NgayBD.insets = new Insets(5, 30, 5, 50);
		gbc_Label_NgayBD.gridx = 2;
		gbc_Label_NgayBD.gridy = 0;
		panel_ChucNang.add(Label_NgayBD, gbc_Label_NgayBD);

		comboBox_NgayBD = new JComboBox<Object>();
		comboBox_NgayBD.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_comboBox_NgayBD = new GridBagConstraints();
		gbc_comboBox_NgayBD.fill = GridBagConstraints.BOTH;
		gbc_comboBox_NgayBD.insets = new Insets(5, 0, 5, 85);
		gbc_comboBox_NgayBD.gridx = 3;
		gbc_comboBox_NgayBD.gridy = 0;
		panel_ChucNang.add(comboBox_NgayBD, gbc_comboBox_NgayBD);

		JLabel Label_CongViec = new JLabel("Công việc");
		Label_CongViec.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_Label_CongViec = new GridBagConstraints();
		gbc_Label_CongViec.fill = GridBagConstraints.BOTH;
		gbc_Label_CongViec.insets = new Insets(5, 0, 5, 50);
		gbc_Label_CongViec.gridx = 0;
		gbc_Label_CongViec.gridy = 1;
		panel_ChucNang.add(Label_CongViec, gbc_Label_CongViec);

		String[] CongViec = { "Nhập Hàng", "Xuất Hàng" };
		comboBox_CongViec = new JComboBox<Object>(CongViec);
		comboBox_CongViec.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_comboBox_CongViec = new GridBagConstraints();
		gbc_comboBox_CongViec.fill = GridBagConstraints.BOTH;
		gbc_comboBox_CongViec.insets = new Insets(5, 0, 5, 85);
		gbc_comboBox_CongViec.gridx = 1;
		gbc_comboBox_CongViec.gridy = 1;
		panel_ChucNang.add(comboBox_CongViec, gbc_comboBox_CongViec);

		JLabel Label_NgayKT = new JLabel("Ngày kết thúc");
		Label_NgayKT.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_Label_NgayKT = new GridBagConstraints();
		gbc_Label_NgayKT.fill = GridBagConstraints.BOTH;
		gbc_Label_NgayKT.insets = new Insets(5, 30, 5, 50);
		gbc_Label_NgayKT.gridx = 2;
		gbc_Label_NgayKT.gridy = 1;
		panel_ChucNang.add(Label_NgayKT, gbc_Label_NgayKT);

		comboBox_NgayKT = new JComboBox<Object>();
		comboBox_NgayKT.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_comboBox_NgayKT = new GridBagConstraints();
		gbc_comboBox_NgayKT.fill = GridBagConstraints.BOTH;
		gbc_comboBox_NgayKT.insets = new Insets(5, 0, 5, 85);
		gbc_comboBox_NgayKT.gridx = 3;
		gbc_comboBox_NgayKT.gridy = 1;
		panel_ChucNang.add(comboBox_NgayKT, gbc_comboBox_NgayKT);

		panel_Center = new JPanel();
		panel_Center.add(bd);
		add(panel_Center, BorderLayout.CENTER);
		panel_Center.setLayout(new GridLayout(1, 1, 0, 0));

		JPanel panel_Menu = new JPanel();
		add(panel_Menu, BorderLayout.EAST);
		GridBagLayout gbl_panel_Menu = new GridBagLayout();
		gbl_panel_Menu.columnWidths = new int[] { 130 };
		gbl_panel_Menu.rowHeights = new int[] { 130, 130, 130, 130 };
		gbl_panel_Menu.columnWeights = new double[] { 0.0 };
		gbl_panel_Menu.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0 };
		panel_Menu.setLayout(gbl_panel_Menu);

		JLabel Label_NhanVien = new JLabel("Nhân Viên");
		Label_NhanVien.setBackground(new Color(255, 255, 255));
		Label_NhanVien.setFont(new Font("Arial", Font.BOLD, 16));
		Label_NhanVien.setIcon(source.icon_taikhoan);
		Label_NhanVien.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_Label_NhanVien = new GridBagConstraints();
		gbc_Label_NhanVien.fill = GridBagConstraints.BOTH;
		gbc_Label_NhanVien.insets = new Insets(20, 5, 20, 5);
		gbc_Label_NhanVien.gridx = 0;
		gbc_Label_NhanVien.gridy = 0;
		panel_Menu.add(Label_NhanVien, gbc_Label_NhanVien);

		JLabel Label_SanPham = new JLabel("Sản Phẩm");
		Label_SanPham.setFont(new Font("Arial", Font.BOLD, 16));
		Label_SanPham.setIcon(source.icon_sanpham);
		Label_SanPham.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_Label_SanPham = new GridBagConstraints();
		gbc_Label_SanPham.fill = GridBagConstraints.BOTH;
		gbc_Label_SanPham.insets = new Insets(20, 5, 20, 5);
		gbc_Label_SanPham.gridx = 0;
		gbc_Label_SanPham.gridy = 1;
		panel_Menu.add(Label_SanPham, gbc_Label_SanPham);

		JLabel Label_CuaHang = new JLabel("Cửa Hàng");
		Label_CuaHang.setFont(new Font("Arial", Font.BOLD, 16));
		Label_CuaHang.setIcon(source.icon_cuahang);
		Label_CuaHang.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_Label_CuaHang = new GridBagConstraints();
		gbc_Label_CuaHang.insets = new Insets(20, 5, 20, 5);
		gbc_Label_CuaHang.fill = GridBagConstraints.BOTH;
		gbc_Label_CuaHang.gridx = 0;
		gbc_Label_CuaHang.gridy = 2;
		panel_Menu.add(Label_CuaHang, gbc_Label_CuaHang);

		JLabel Label_NhaCC = new JLabel("Nhà Cung Cấp");
		Label_NhaCC.setFont(new Font("Arial", Font.BOLD, 16));
		Label_NhaCC.setIcon(source.icon_nhaCungCap);
		Label_NhaCC.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_Label_NhaCC = new GridBagConstraints();
		gbc_Label_NhaCC.insets = new Insets(20, 5, 20, 5);
		gbc_Label_NhaCC.fill = GridBagConstraints.BOTH;
		gbc_Label_NhaCC.gridx = 0;
		gbc_Label_NhaCC.gridy = 3;
		panel_Menu.add(Label_NhaCC, gbc_Label_NhaCC);
		ThongKeActionListener ac = new ThongKeActionListener(this);
		ThongKeMouseListener mouse = new ThongKeMouseListener(this);
		Label_SanPham.addMouseListener(mouse);
		comboBox_ThoiGian.addActionListener(ac);
		comboBox_CongViec.addActionListener(ac);
		comboBox_NgayBD.addActionListener(ac);
		comboBox_NgayKT.addActionListener(ac);

		updateDateFormats();
		setVisible(true);
	}

	public void updateDateFormats() {
		String selectedFormat = dateFormat[comboBox_ThoiGian.getSelectedIndex()];

		// xóa dữ liệu comboBox hiện tại
		comboBox_NgayBD.removeAllItems();
		comboBox_NgayKT.removeAllItems();

		ArrayList<String> startDayString = new ArrayList<String>();

		// lấy dữ liệu ngày/tháng/năm mới
		if (comboBox_CongViec.getSelectedItem().toString() == "Nhập Hàng")
			startDayString = PhieuNhapDao.getInstance().selectDay();
		else
			startDayString = PhieuXuatDao.getInstance().selectDay();

		// định dạng ngày
		ArrayList<String> dates = getDateFormats(startDayString, selectedFormat);

		// cập nhật dữ liệu
		for (String date : dates) {
			comboBox_NgayBD.addItem(date);
			comboBox_NgayKT.addItem(date);
		}
		comboBox_NgayBD.setSelectedIndex(0);
		comboBox_NgayKT.setSelectedIndex(0);
	}

	private ArrayList<String> getDateFormats(ArrayList<String> dateList, String dateFormat) {
		ArrayList<String> formattedDates = new ArrayList<String>();
		HashSet<String> uniqueDates = new HashSet<>();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		for (String dateString : dateList) {
			LocalDate date = LocalDate.parse(dateString, formatter);
			switch (dateFormat) {
			case "dd/MM/yyyy":
				uniqueDates.add(String.format("%02d", date.getDayOfMonth()) + "/"
						+ String.format("%02d", date.getMonthValue()) + "/" + date.getYear());
				break;
			case "MM/yyyy":
				uniqueDates.add(String.format("%02d", date.getMonthValue()) + "/" + date.getYear());
				break;
			case "yyyy":
				uniqueDates.add(String.valueOf(date.getYear()));
				break;
			default:
				break;
			}
		}
		formattedDates.addAll(uniqueDates);
		formattedDates.sort(null);
		return formattedDates;
	}

	public void updateData() {
		panel_Center.remove(bd);
		String congViec = comboBox_CongViec.getSelectedItem().toString();
		int StartDay = comboBox_NgayBD.getSelectedIndex();
		int EndDay = comboBox_NgayKT.getSelectedIndex();
		
		ArrayList<String> day = new ArrayList<String>();
		for (int i = StartDay; i <= EndDay; i++)
			if (comboBox_NgayBD.getItemAt(i)!=null)
				day.add(comboBox_NgayBD.getItemAt(i).toString());
		
		String DateFomart = dateFormat[comboBox_ThoiGian.getSelectedIndex()];
		bd.Update(congViec, day, DateFomart);
		panel_Center.add(bd);
	}

}
