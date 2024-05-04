package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.text.Normalizer;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
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

import controller.CuaHangActionListener;
import controller.CuaHangMouseListener;
import dao.CuaHangDAO;
import img.Source;
import model.CuaHang;
import model.XaPhuong;

public class CuaHangView extends JPanel {

	public static final long serialVersionUID = 1L;
	public Object[][] data;
	public DefaultTableModel model;
	public JTable table;
	public JScrollPane scrollPane;
	public JComboBox<Object> comboBox_search_XaPhuong;
	public JTextField textField_Search;
	public JButton jbutton_Sreach;
	public JButton jbutton_refesh;
	public JComboBox<Object> comboBox_search_QuanHuyen;
	public JComboBox<Object> comboBox_search_ThanhPho;
	public JPanel panel_border_timKiem;
	private CuaHangActionListener ac;

	public Source source = new Source();
	public String[] Quan_Huyen = { "Tất cả", "Quận 1", "Quận 2", "Quận 3", "Quận 4", "Quận 5", "Quận 6", "Quận 7",
			"Quận 8", "Quận 9", "Quận 10", "Quận 11", "Quận 12", "Quận Thủ Đức", "Quận Gò Vấp", "Quận Bình Thạnh",
			"Quận Tân Bình", "Quận Tân Phú", "Quận Phú Nhuận", "Quận Bình Tân", "Huyện Củ Chi", "Huyện Bình Chánh",
			"Huyện Nhà Bè", "Huyện Cần Giờ" };

	public String[] Xa_Phuong;
	public String[] ThanhPho = { "TP HCM" };
	private GridBagConstraints gbc_comboBox_search_XaPhuong;

	/**
	 * Create the panel.
	 */
	public CuaHangView() {
		this.setBounds(0, 0, 1200, 770);

		ac = new CuaHangActionListener(this);
		setLayout(new BorderLayout(0, 50));
		JPanel panel_menu = new JPanel();
		this.add(panel_menu, BorderLayout.NORTH);
		panel_menu.setLayout(new GridLayout(0, 2, 5, 0));
		JPanel panel_border_chucNang = new JPanel();
		panel_border_chucNang.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Chức năng",
				TitledBorder.LEFT, TitledBorder.ABOVE_TOP, new Font("Arial", Font.ITALIC, 14), new Color(0, 0, 0)));
		panel_border_chucNang.setBounds(10, 10, 450, 100);
		panel_border_chucNang.setLayout(new GridLayout(1, 6, 0, 0));
		panel_menu.add(panel_border_chucNang);

		JLabel jlabel_them = new JLabel("Thêm", source.icon_add, JLabel.CENTER);
		jlabel_them.setFont(new Font("Arial", Font.PLAIN, 12));
		jlabel_them.setVerticalTextPosition(JLabel.BOTTOM);
		jlabel_them.setHorizontalTextPosition(JLabel.CENTER);
		panel_border_chucNang.add(jlabel_them);

		JLabel jlabel_xoa = new JLabel("Xóa", source.icon_remove, JLabel.CENTER);
		jlabel_xoa.setFont(new Font("Arial", Font.PLAIN, 12));
		jlabel_xoa.setVerticalTextPosition(JLabel.BOTTOM);
		jlabel_xoa.setHorizontalTextPosition(JLabel.CENTER);
		panel_border_chucNang.add(jlabel_xoa);

		JLabel jlabel_sua = new JLabel("Sửa", source.icon_pencil, JLabel.CENTER);
		jlabel_sua.setFont(new Font("Arial", Font.PLAIN, 12));
		jlabel_sua.setVerticalTextPosition(JLabel.BOTTOM);
		jlabel_sua.setHorizontalTextPosition(JLabel.CENTER);
		panel_border_chucNang.add(jlabel_sua);

		JLabel jlabel_xemCT = new JLabel("Xem chi tiết", source.icon_eye, JLabel.CENTER);
		jlabel_xemCT.setFont(new Font("Arial", Font.PLAIN, 12));
		jlabel_xemCT.setVerticalTextPosition(JLabel.BOTTOM);
		jlabel_xemCT.setHorizontalTextPosition(JLabel.CENTER);
		panel_border_chucNang.add(jlabel_xemCT);

		JLabel jlabel_nhapExcel = new JLabel("Nhập Excel", source.icon_Excel, JLabel.CENTER);
		jlabel_nhapExcel.setFont(new Font("Arial", Font.PLAIN, 12));
		jlabel_nhapExcel.setVerticalTextPosition(JLabel.BOTTOM);
		jlabel_nhapExcel.setHorizontalTextPosition(JLabel.CENTER);
		panel_border_chucNang.add(jlabel_nhapExcel);

		JLabel jlabel_xuatExcel = new JLabel("Xuất Excel", source.icon_Excel, JLabel.CENTER);
		jlabel_xuatExcel.setFont(new Font("Arial", Font.PLAIN, 12));
		jlabel_xuatExcel.setVerticalTextPosition(JLabel.BOTTOM);
		jlabel_xuatExcel.setHorizontalTextPosition(JLabel.CENTER);
		panel_border_chucNang.add(jlabel_xuatExcel);

		panel_border_timKiem = new JPanel();
		panel_border_timKiem.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Tìm kiếm",
				TitledBorder.LEFT, TitledBorder.ABOVE_TOP, new Font("Arial", Font.ITALIC, 14), new Color(0, 0, 0)));
		panel_border_timKiem.setBounds(477, 10, 656, 152);
		GridBagLayout gbl_panel_border_timKiem = new GridBagLayout();
		gbl_panel_border_timKiem.columnWidths = new int[] { 230, 150, 100, 95, 0 };
		gbl_panel_border_timKiem.rowHeights = new int[] { 31, 33, 21, 0 };
		gbl_panel_border_timKiem.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_border_timKiem.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_border_timKiem.setLayout(gbl_panel_border_timKiem);

		textField_Search = new JTextField();
		GridBagConstraints gbc_textField_Search = new GridBagConstraints();
		gbc_textField_Search.weighty = 1.0;
		gbc_textField_Search.weightx = 1.0;
		gbc_textField_Search.fill = GridBagConstraints.BOTH;
		gbc_textField_Search.insets = new Insets(0, 0, 5, 5);
		gbc_textField_Search.gridwidth = 3;
		gbc_textField_Search.gridx = 0;
		gbc_textField_Search.gridy = 0;
		panel_border_timKiem.add(textField_Search, gbc_textField_Search);
		textField_Search.setColumns(10);
		textField_Search.addActionListener(ac);

		jbutton_Sreach = new JButton("Tìm kiếm");
		jbutton_Sreach.setFont(new Font("Arial", Font.PLAIN, 11));
		jbutton_Sreach.addActionListener(ac);
		jbutton_Sreach.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_jbutton_Sreach = new GridBagConstraints();
		gbc_jbutton_Sreach.weighty = 1.0;
		gbc_jbutton_Sreach.weightx = 1.0;
		gbc_jbutton_Sreach.fill = GridBagConstraints.BOTH;
		gbc_jbutton_Sreach.insets = new Insets(0, 0, 5, 0);
		gbc_jbutton_Sreach.gridx = 3;
		gbc_jbutton_Sreach.gridy = 0;
		panel_border_timKiem.add(jbutton_Sreach, gbc_jbutton_Sreach);

		comboBox_search_QuanHuyen = new JComboBox<Object>(Quan_Huyen);
		comboBox_search_QuanHuyen.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox_search_QuanHuyen.setBackground(Color.WHITE);
		GridBagConstraints gbc_comboBox_search_QuanHuyen = new GridBagConstraints();
		gbc_comboBox_search_QuanHuyen.weighty = 1.0;
		gbc_comboBox_search_QuanHuyen.weightx = 1.0;
		gbc_comboBox_search_QuanHuyen.fill = GridBagConstraints.BOTH;
		gbc_comboBox_search_QuanHuyen.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox_search_QuanHuyen.gridx = 1;
		gbc_comboBox_search_QuanHuyen.gridy = 1;
		panel_border_timKiem.add(comboBox_search_QuanHuyen, gbc_comboBox_search_QuanHuyen);
		comboBox_search_QuanHuyen.addActionListener(ac);
		comboBox_search_ThanhPho = new JComboBox<Object>(ThanhPho);
		comboBox_search_ThanhPho.setFont(new Font("Arial", Font.PLAIN, 14));
		comboBox_search_ThanhPho.setBackground(Color.WHITE);
		GridBagConstraints gbc_comboBox_search_ThanhPho = new GridBagConstraints();
		gbc_comboBox_search_ThanhPho.weighty = 1.0;
		gbc_comboBox_search_ThanhPho.weightx = 1.0;
		gbc_comboBox_search_ThanhPho.fill = GridBagConstraints.BOTH;
		gbc_comboBox_search_ThanhPho.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox_search_ThanhPho.gridx = 2;
		gbc_comboBox_search_ThanhPho.gridy = 1;
		panel_border_timKiem.add(comboBox_search_ThanhPho, gbc_comboBox_search_ThanhPho);

		comboBox_search_XaPhuong = new JComboBox<Object>(ChangeXaPhuong());
		comboBox_search_XaPhuong.setBackground(new Color(255, 255, 255));
		comboBox_search_XaPhuong.setFont(new Font("Arial", Font.PLAIN, 14));
		gbc_comboBox_search_XaPhuong = new GridBagConstraints();
		gbc_comboBox_search_XaPhuong.weighty = 1.0;
		gbc_comboBox_search_XaPhuong.weightx = 1.0;
		gbc_comboBox_search_XaPhuong.fill = GridBagConstraints.BOTH;
		gbc_comboBox_search_XaPhuong.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox_search_XaPhuong.gridx = 0;
		gbc_comboBox_search_XaPhuong.gridy = 1;
		panel_border_timKiem.add(comboBox_search_XaPhuong, gbc_comboBox_search_XaPhuong);
		comboBox_search_XaPhuong.addActionListener(ac);

		jbutton_refesh = new JButton(source.icon_refresh);
		jbutton_refesh.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_jbutton_refesh = new GridBagConstraints();
		gbc_jbutton_refesh.weighty = 1.0;
		gbc_jbutton_refesh.weightx = 1.0;
		gbc_jbutton_refesh.fill = GridBagConstraints.BOTH;
		gbc_jbutton_refesh.gridx = 3;
		gbc_jbutton_refesh.gridy = 1;
		panel_border_timKiem.add(jbutton_refesh, gbc_jbutton_refesh);
		jbutton_refesh.addActionListener(ac);
		CuaHangMouseListener mouse = new CuaHangMouseListener(this);
		panel_menu.add(panel_border_timKiem);
		jlabel_them.addMouseListener(mouse);
		jlabel_xoa.addMouseListener(mouse);
		jlabel_xemCT.addMouseListener(mouse);
		jlabel_nhapExcel.addMouseListener(mouse);
		jlabel_xuatExcel.addMouseListener(mouse);
		jlabel_sua.addMouseListener(mouse);

		scrollPane = new JScrollPane();
		this.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table = loadCuaHang();
		scrollPane.setViewportView(table);
		scrollPane.setEnabled(false);

	}

	public JTable loadCuaHang() {
		// Xóa bảng cũ nếu tồn tại
		ArrayList<CuaHang> ListCuaHang = loadDataFromSql();
		updateData(ListCuaHang);
		return table;
	}

	public void updateData(ArrayList<CuaHang> CuaHang) {
		// Kiểm tra table và scrollPane
		if (table != null && scrollPane != null) {
			table.setModel(new DefaultTableModel()); // Xóa dữ liệu của bảng
			scrollPane.setViewportView(null); // Xóa scroll pane
		}

		// Tạo bảng mới
		data = loadDataToObject(CuaHang);

		String column[] = { "Mã CH", "Tên Cửa Hàng", "Địa Chỉ", "Điện Thoại" };
		model = new DefaultTableModel(data, column);
		table = new JTable(model);
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		table.getColumnModel().getColumn(0).setPreferredWidth(10);
		table.getColumnModel().getColumn(1).setPreferredWidth(300);
		table.getColumnModel().getColumn(1).setMinWidth(20);
		table.getColumnModel().getColumn(2).setPreferredWidth(400);
		table.getColumnModel().getColumn(3).setPreferredWidth(25);

		// Thêm bảng mới vào scroll pane và trả về bảng
		scrollPane.setViewportView(table);
	}

	public ArrayList<CuaHang> loadDataFromSql() {
		return CuaHangDAO.getintance().selectAll();
	}

	public Object[][] loadDataToObject(ArrayList<CuaHang> CuaHang) {

		ArrayList<CuaHang> ListCuaHang = CuaHang;
		data = new Object[ListCuaHang.size()][5];
		int j = 0;
		for (int i = 0; i < ListCuaHang.size(); i++) {
			CuaHang CH = ListCuaHang.get(i);
			if (CH.getIsDelete() == 0) {
				data[j][0] = CH.getMaCH();
				data[j][1] = CH.getTenCH();
				data[j][2] = CH.getDiaChi();
				data[j][3] = CH.getSDT();
				data[j][4] = CH.getIsDelete();
				j++;
			}
		}
		// Cập nhật kích thước của mảng data
		Object newData[][] = new Object[j][5];
		for (int i = 0; i < j; i++) {
			for (int k = 0; k < 4; k++) {
				newData[i][k] = data[i][k];
			}
		}

		data = newData;
		return data;
	}

	public static String chuyenThanhTenBien(String tenQuanHuyen) {
		// Loại bỏ dấu và chuyển thành chữ viết thường
		String tenKhongDau = ChuyenThanhFontThuong(tenQuanHuyen);

		// Loại bỏ các từ "Quận" và "Huyện"
		// Loại bỏ các từ "Quận" và "Huyện"
		tenKhongDau = tenKhongDau.toLowerCase();

		// Loại bỏ khoảng trắng và dấu cách
		tenKhongDau = tenKhongDau.trim().replace(" ", "");

		return tenKhongDau;
	}

	// Loại bỏ dấu và chuyển thành chữ viết thường
	public static String ChuyenThanhFontThuong(String str) {
		str = Normalizer.normalize(str, Normalizer.Form.NFD);
		str = str.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
		// trường hợp đặc biệt
		str = str.replace("Đ", "D").replace("đ", "d");
		return str;
	}

	public String[] ChangeXaPhuong() {
		try {
			XaPhuong XaPhuong = new XaPhuong();
			String quan = (String) comboBox_search_QuanHuyen.getSelectedItem();
			if (quan.equals("Tất cả")) {
				return XaPhuong.allMap();
			}
			String[] xa_Phuong = XaPhuong.getxaPhuongMap().get(chuyenThanhTenBien(quan));
			// Tạo mảng mới có kích thước lớn hơn một đơn vị so với xa_Phuong
			String[] result = new String[xa_Phuong.length + 1];
			// Thêm "Tất cả" vào đầu mảng result
			result[0] = "Tất cả";
			// Sao chép tất cả các phần tử từ xa_Phuong vào mảng result từ vị trí thứ 1
			System.arraycopy(xa_Phuong, 0, result, 1, xa_Phuong.length);

			return result;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

	public void updateComBoBox_XaPhuong() {
		// Tạo lại comboBox_XaPhuong và cập nhật dữ liệu mới
		DefaultComboBoxModel<Object> model = new DefaultComboBoxModel<>(ChangeXaPhuong());
		comboBox_search_XaPhuong.setModel(model);
		// Thêm comboBox_XaPhuong vào panel_Title_DiaChi
		panel_border_timKiem.add(comboBox_search_XaPhuong, gbc_comboBox_search_XaPhuong);

		// Yêu cầu panel_Title_DiaChi cập nhật lại giao diện
		panel_border_timKiem.revalidate();
		panel_border_timKiem.repaint(); // Có thể cần repaint() để hiển thị ngay lập tức
	}

}
