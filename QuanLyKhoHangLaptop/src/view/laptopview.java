package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import controller.LaptopActionListener;
import controller.LaptopMouseListener;
import dao.LaptopDAO;
import img.Source;
import model.Laptop;

import java.awt.Insets;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class laptopview extends JPanel {

	public JButton jbutton_refesh;
	public Object data[][];
	public JTable table;
	public DefaultTableModel model;
	public JScrollPane scrollPane;
	public JComboBox<String> comboBox_search;
	public JButton jbutton_Sreach;
	public JComboBox<String> comboBox_Gia;
	public JComboBox<String> comboBox_Rom;
	public JComboBox<String> comboBox_Ram;
	public JComboBox<String> comboBox_CPU;
	public JComboBox<String> comboBox_Hang;
	public JTextField textField;

	private Source source = new Source();
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public laptopview() {
		// this.setBounds(0, 0, 1189, 763);
		setLayout(new BorderLayout(0, 0));
		LaptopActionListener ac = new LaptopActionListener(this);
		JPanel panel_border_chucNang = new JPanel();
		panel_border_chucNang.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Chức năng",
				TitledBorder.LEFT, TitledBorder.ABOVE_TOP, new Font("Arial", Font.ITALIC, 14), new Color(0, 0, 0)));
		// panel_border_chucNang.setBounds(10, 10, 421, 81);

		JPanel jpanel_North = new JPanel(new GridLayout(1, 2));
		this.add(jpanel_North, BorderLayout.NORTH);
		jpanel_North.add(panel_border_chucNang);
		jpanel_North.setBorder(BorderFactory.createEmptyBorder(10, 0, 40, 0));

		panel_border_chucNang.setLayout(new GridLayout(1, 6));

		JLabel jlabel_them = new JLabel("Thêm", source.icon_add, JLabel.CENTER);
		jlabel_them.setFont(new Font("Arial", Font.PLAIN, 12));
		// jlabel_them.setBounds(10, 21, 44, 56);
		jlabel_them.setVerticalTextPosition(JLabel.BOTTOM);
		jlabel_them.setHorizontalTextPosition(JLabel.CENTER);
		panel_border_chucNang.add(jlabel_them);

		JLabel jlabel_sua = new JLabel("Sửa", source.icon_pencil, JLabel.CENTER);
		jlabel_sua.setFont(new Font("Arial", Font.PLAIN, 12));
		// jlabel_sua.setBounds(109, 21, 59, 56);
		jlabel_sua.setVerticalTextPosition(JLabel.BOTTOM);
		jlabel_sua.setHorizontalTextPosition(JLabel.CENTER);
		panel_border_chucNang.add(jlabel_sua);

		JLabel jlabel_xoa = new JLabel("Xóa", source.icon_remove, JLabel.CENTER);
		jlabel_xoa.setFont(new Font("Arial", Font.PLAIN, 12));
		// jlabel_xoa.setBounds(67, 21, 45, 56);
		jlabel_xoa.setVerticalTextPosition(JLabel.BOTTOM);
		jlabel_xoa.setHorizontalTextPosition(JLabel.CENTER);
		panel_border_chucNang.add(jlabel_xoa);

		JLabel jlabel_xemCT = new JLabel("Xem chi tiết", source.icon_eye, JLabel.CENTER);
		jlabel_xemCT.setFont(new Font("Arial", Font.PLAIN, 12));
		// jlabel_xemCT.setBounds(165, 21, 68, 56);
		jlabel_xemCT.setVerticalTextPosition(JLabel.BOTTOM);
		jlabel_xemCT.setHorizontalTextPosition(JLabel.CENTER);
		panel_border_chucNang.add(jlabel_xemCT);

		JLabel jlabel_nhapExcel = new JLabel("Nhập Excel", source.icon_Excel, JLabel.CENTER);
		jlabel_nhapExcel.setFont(new Font("Arial", Font.PLAIN, 12));
		// jlabel_nhapExcel.setBounds(265, 21, 68, 56);
		jlabel_nhapExcel.setVerticalTextPosition(JLabel.BOTTOM);
		jlabel_nhapExcel.setHorizontalTextPosition(JLabel.CENTER);
		panel_border_chucNang.add(jlabel_nhapExcel);

		JLabel jlabel_Excel = new JLabel("Xuất Excel", source.icon_Excel, JLabel.CENTER);
		jlabel_Excel.setFont(new Font("Arial", Font.PLAIN, 12));
		// jlabel_Excel.setBounds(343, 21, 68, 56);
		jlabel_Excel.setVerticalTextPosition(JLabel.BOTTOM);
		jlabel_Excel.setHorizontalTextPosition(JLabel.CENTER);
		panel_border_chucNang.add(jlabel_Excel);

		JPanel panel_border_timKiem = new JPanel();
		panel_border_timKiem.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Tìm kiếm",
				TitledBorder.LEFT, TitledBorder.ABOVE_TOP, new Font("Arial", Font.ITALIC, 14), new Color(0, 0, 0)));
		// panel_border_timKiem.setBounds(489, 10, 690, 137);

		String[] combo = { "Tất cả", "Windows", "MacOS" };
		// comboBox_CPU.addActionListener(ac);

		String ram[] = { "Tất cả", "4 GB", "8 GB", "16 GB", "32 GB", "64 GB", "128 GB" };
		// comboBox_Ram.addActionListener(ac);

		String rom[] = { "Tất cả", "256 GB", "512 GB", "1 TB", "2 TB", "4 TB" };
		// comboBox_Rom.addActionListener(ac);

		String s[] = { "Tất cả", "Dưới 10 triệu", "10-15 triệu", "15-20 triệu", "20-30 triệu", "30-50 triệu",
				"Hơn 50 triệu" };
		GridBagLayout gbl_panel_border_timKiem = new GridBagLayout();
		gbl_panel_border_timKiem.columnWidths = new int[] { 96, 96, 96, 96, 96, 0 };
		gbl_panel_border_timKiem.rowHeights = new int[] { 40, 40, 0 };
		gbl_panel_border_timKiem.columnWeights = new double[] { 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_border_timKiem.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		panel_border_timKiem.setLayout(gbl_panel_border_timKiem);
		comboBox_search = new JComboBox<String>(combo);
		comboBox_search.addActionListener(ac);
		comboBox_search.setBackground(new Color(255, 255, 255));
		comboBox_search.setFont(new Font("Arial", Font.PLAIN, 14));
		// comboBox_search.setBounds(10, 36, 95, 21);

		JPanel jpanel_search = new JPanel();
		jpanel_search.setLayout(new BorderLayout(0, 0));
		JLabel jlabel_search = new JLabel("Hệ điều hành");
		jlabel_search.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jpanel_search.add(jlabel_search, BorderLayout.NORTH);
		jpanel_search.add(comboBox_search, BorderLayout.CENTER);
		GridBagConstraints gbc_jpanel_search = new GridBagConstraints();
		gbc_jpanel_search.fill = GridBagConstraints.BOTH;
		gbc_jpanel_search.insets = new Insets(0, 0, 5, 5);
		gbc_jpanel_search.gridx = 0;
		gbc_jpanel_search.gridy = 0;
		panel_border_timKiem.add(jpanel_search, gbc_jpanel_search);

		textField = new JTextField();
		// textField.setBounds(131, 31, 343, 33);
		textField.setColumns(20);
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 0;
		gbc_textField.gridwidth = 2;
		panel_border_timKiem.add(textField, gbc_textField);

		jbutton_refesh = new JButton(source.icon_refresh);
		jbutton_refesh.addActionListener(ac);
		jbutton_refesh.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_jbutton_refesh = new GridBagConstraints();
		gbc_jbutton_refesh.anchor = GridBagConstraints.EAST;
		gbc_jbutton_refesh.fill = GridBagConstraints.VERTICAL;
		gbc_jbutton_refesh.insets = new Insets(0, 0, 5, 5);
		gbc_jbutton_refesh.gridx = 3;
		gbc_jbutton_refesh.gridy = 0;
		panel_border_timKiem.add(jbutton_refesh, gbc_jbutton_refesh);

		jbutton_Sreach = new JButton("Tìm kiếm");
		jbutton_Sreach.addActionListener(ac);
		jbutton_Sreach.setBackground(new Color(255, 255, 255));
		jbutton_Sreach.setBounds(573, 31, 107, 33);
		GridBagConstraints gbc_jbutton_Sreach = new GridBagConstraints();
		gbc_jbutton_Sreach.anchor = GridBagConstraints.EAST;
		gbc_jbutton_Sreach.fill = GridBagConstraints.VERTICAL;
		gbc_jbutton_Sreach.insets = new Insets(0, 0, 5, 0);
		gbc_jbutton_Sreach.gridx = 4;
		gbc_jbutton_Sreach.gridy = 0;
		panel_border_timKiem.add(jbutton_Sreach, gbc_jbutton_Sreach);
		// comboBox_Hang.setBounds(141, 74, 95, 21);

		JLabel lblHng = new JLabel("Hãng");
		lblHng.setFont(new Font("Arial", Font.PLAIN, 14));
		// lblHng.setBounds(10, 67, 95, 34);

		JPanel jpanel_Hang = new JPanel(new BorderLayout());
		jpanel_Hang.add(lblHng, BorderLayout.NORTH);
		GridBagConstraints gbc_jpanel_Hang = new GridBagConstraints();
		gbc_jpanel_Hang.fill = GridBagConstraints.BOTH;
		gbc_jpanel_Hang.insets = new Insets(0, 0, 0, 5);
		gbc_jpanel_Hang.gridx = 0;
		gbc_jpanel_Hang.gridy = 1;
		panel_border_timKiem.add(jpanel_Hang, gbc_jpanel_Hang);
		// comboBox_CPU.setBounds(130, 100, 245, 21);

		JLabel lblNewLabel = new JLabel("CPU");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		// lblNewLabel.setBounds(131, 74, 45, 26);

		JPanel jpanel_CPU = new JPanel(new BorderLayout());
		jpanel_CPU.add(lblNewLabel, BorderLayout.NORTH);
		GridBagConstraints gbc_jpanel_CPU = new GridBagConstraints();
		gbc_jpanel_CPU.fill = GridBagConstraints.BOTH;
		gbc_jpanel_CPU.insets = new Insets(0, 0, 0, 5);
		gbc_jpanel_CPU.gridx = 1;
		gbc_jpanel_CPU.gridy = 1;
		panel_border_timKiem.add(jpanel_CPU, gbc_jpanel_CPU);
		comboBox_Ram = new JComboBox<String>(ram);
		comboBox_Ram.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox_Ram.setBackground(Color.WHITE);
		// comboBox_Ram.setBounds(393, 100, 81, 21);

		JLabel lblRam = new JLabel("Ram");
		lblRam.setFont(new Font("Arial", Font.PLAIN, 14));
		// lblRam.setBounds(393, 74, 45, 27);

		JPanel jpanel_Ram = new JPanel(new BorderLayout());
		jpanel_Ram.add(lblRam, BorderLayout.NORTH);
		jpanel_Ram.add(comboBox_Ram, BorderLayout.CENTER);
		GridBagConstraints gbc_jpanel_Ram = new GridBagConstraints();
		gbc_jpanel_Ram.fill = GridBagConstraints.BOTH;
		gbc_jpanel_Ram.insets = new Insets(0, 0, 0, 5);
		gbc_jpanel_Ram.gridx = 2;
		gbc_jpanel_Ram.gridy = 1;
		panel_border_timKiem.add(jpanel_Ram, gbc_jpanel_Ram);
		comboBox_Rom = new JComboBox<String>(rom);
		comboBox_Rom.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox_Rom.setBackground(Color.WHITE);
		// comboBox_Rom.setBounds(484, 100, 75, 21);

		JLabel lblBNh = new JLabel("Bộ nhớ");
		lblBNh.setFont(new Font("Arial", Font.PLAIN, 14));
		// lblBNh.setBounds(484, 79, 64, 21);

		JPanel jpanel_Rom = new JPanel(new BorderLayout());
		jpanel_Rom.add(lblBNh, BorderLayout.NORTH);
		jpanel_Rom.add(comboBox_Rom, BorderLayout.CENTER);
		GridBagConstraints gbc_jpanel_Rom = new GridBagConstraints();
		gbc_jpanel_Rom.fill = GridBagConstraints.BOTH;
		gbc_jpanel_Rom.insets = new Insets(0, 0, 0, 5);
		gbc_jpanel_Rom.gridx = 3;
		gbc_jpanel_Rom.gridy = 1;
		panel_border_timKiem.add(jpanel_Rom, gbc_jpanel_Rom);
		comboBox_Gia = new JComboBox<String>(s);
		comboBox_Gia.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox_Gia.setBackground(Color.WHITE);
		// comboBox_Gia.setBounds(573, 100, 105, 21);

		JLabel lblGi = new JLabel("Giá");
		lblGi.setFont(new Font("Arial", Font.PLAIN, 14));
		// lblGi.setBounds(575, 74, 45, 27);

		JPanel jpanel_Gia = new JPanel(new BorderLayout());
		jpanel_Gia.add(lblGi, BorderLayout.NORTH);
		jpanel_Gia.add(comboBox_Gia, BorderLayout.CENTER);
		GridBagConstraints gbc_jpanel_Gia = new GridBagConstraints();
		gbc_jpanel_Gia.fill = GridBagConstraints.BOTH;
		gbc_jpanel_Gia.gridx = 4;
		gbc_jpanel_Gia.gridy = 1;
		panel_border_timKiem.add(jpanel_Gia, gbc_jpanel_Gia);

		comboBox_Hang = new JComboBox<String>();
		comboBox_Hang = addItem("Hang");
		jpanel_Hang.add(comboBox_Hang, BorderLayout.CENTER);
		comboBox_Hang.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox_Hang.setBackground(Color.WHITE);

		comboBox_CPU = new JComboBox<String>();
		comboBox_CPU = addItem("CPU");
		jpanel_CPU.add(comboBox_CPU, BorderLayout.CENTER);

		comboBox_CPU.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox_CPU.setBackground(Color.WHITE);
		jpanel_North.add(panel_border_timKiem);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 170, 1169, 593);
		this.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table = TaiKhoan();
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		JTableHeader header = table.getTableHeader();
		header.setFont(new Font("Arial", Font.BOLD, 14));
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		setKhoangCachTable();
		scrollPane.setViewportView(table);

		LaptopMouseListener mouse = new LaptopMouseListener(this);
		jlabel_them.addMouseListener(mouse);
		jlabel_Excel.addMouseListener(mouse);
		jlabel_sua.addMouseListener(mouse);
		jlabel_nhapExcel.addMouseListener(mouse);
		jlabel_xoa.addMouseListener(mouse);
		jlabel_xemCT.addMouseListener(mouse);
		jbutton_refesh.addActionListener(ac);
		comboBox_search.addActionListener(ac);
		comboBox_Hang.addActionListener(ac);
		comboBox_CPU.addActionListener(ac);
		comboBox_Ram.addActionListener(ac);
		comboBox_Rom.addActionListener(ac);
		comboBox_Gia.addActionListener(ac);
	}

	public JTable TaiKhoan() {
		ArrayList<Laptop> listLaptop = LaptopDAO.getintance().selectAll();

		data = new Object[listLaptop.size()][9];
		for (int i = 0; i < listLaptop.size(); i++) {
			Laptop t = listLaptop.get(i);
			data[i][0] = t.getMaLaptop();
			data[i][1] = t.getTenLaptop();
			data[i][2] = t.getSoLuong();
			DecimalFormat df = new DecimalFormat("#");
			String formattedNumber = df.format(t.getGia());
			data[i][3] = formattedNumber;
			data[i][4] = t.getCPU();
			data[i][5] = t.getRam();
			data[i][6] = t.getRom();
			data[i][7] = t.getHeDieuHanh();
			data[i][8] = t.getMaNhaCungCap();
		}
		String column[] = { "Id", "Tên laptop", "Số lượng", "Giá", "CPU", "Ram", "Bộ nhớ", "Hệ điều hành",
				"Mã nhà cung cấp" };
		model = new DefaultTableModel(data, column);
		table = new JTable(model);

		setKhoangCachTable();
		return table;
	}

	public void updateTableData(ArrayList<Laptop> listLaptop) {

		// Tạo lại mảng dữ liệu và cập nhật bảng
		Object newData[][] = new Object[listLaptop.size()][9];
		for (int i = 0; i < listLaptop.size(); i++) {
			Laptop t = listLaptop.get(i);
			newData[i][0] = t.getMaLaptop();
			newData[i][1] = t.getTenLaptop();
			newData[i][2] = t.getSoLuong();
			DecimalFormat df = new DecimalFormat("#");
			String formattedNumber = df.format(t.getGia());
			newData[i][3] = formattedNumber;
			newData[i][4] = t.getCPU();
			newData[i][5] = t.getRam();
			newData[i][6] = t.getRom();
			newData[i][7] = t.getHeDieuHanh();
			newData[i][8] = t.getMaNhaCungCap();
		}
		String column[] = { "Id", "Tên laptop", "Số lượng", "Giá", "CPU", "Ram", "Bộ nhớ", "Hệ điều hành",
				"Mã nhà cung cấp" };
		// Cập nhật mô hình của bảng
		model.setDataVector(newData, column);
		setKhoangCachTable();
		// Cập nhật lại giao diện
		this.revalidate();
		this.repaint();
	}

	public void setKhoangCachTable() {
		table.getColumnModel().getColumn(0).setPreferredWidth(52);
		table.getColumnModel().getColumn(1).setPreferredWidth(200);
		table.getColumnModel().getColumn(1).setMinWidth(15);
		table.getColumnModel().getColumn(2).setPreferredWidth(30);
		table.getColumnModel().getColumn(3).setPreferredWidth(40);
		table.getColumnModel().getColumn(4).setPreferredWidth(93);
		table.getColumnModel().getColumn(5).setPreferredWidth(35);
		table.getColumnModel().getColumn(6).setPreferredWidth(50);
		table.getColumnModel().getColumn(7).setPreferredWidth(100);
	}

	public ArrayList<Laptop> select_search_laptop(ArrayList<Laptop> list, String s) {
		s = s.toUpperCase();
		ArrayList<Laptop> arr = new ArrayList<Laptop>();
		for (Laptop laptop : list) {
			String tmp = laptop.getMaLaptop() + " " + laptop.getTenLaptop() + " " + laptop.getCPU() + " "
					+ laptop.getGPU() + " " + laptop.getRam() + " " + laptop.getRom() + " " + laptop.getManHinh() + " "
					+ laptop.getHeDieuHanh() + " " + laptop.getHang() + " " + laptop.getNamSanXuat() + " "
					+ laptop.getSoLuong() + " " + laptop.getGia();
			tmp = tmp.toUpperCase();
			if (tmp.indexOf(s) != -1) {
				arr.add(laptop);
			}
		}
		return arr;
	}

	public JComboBox<String> addItem(String s) {
		ArrayList<String> arr = LaptopDAO.getintance().getColumn(s);
		JComboBox<String> tmp = new JComboBox<String>();
		tmp.addItem("Tất cả");
		for (String string : arr) {
			tmp.addItem(string);
		}
		return tmp;
	}
}
