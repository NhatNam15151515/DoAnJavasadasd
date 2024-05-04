package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

import controller.TaiKhoanActionListener;
import controller.TaiKhoanMouseListener;
import dao.NguoiDungDAO;
import dao.NhanVienDAO;
import img.Source;
import model.NguoiDung;
import model.NhanVien;
import javax.swing.SwingConstants;

public class TaiKhoanView extends JPanel {

	private static final long serialVersionUID = 1L;

	public Object data[][];
	public JTable table;
	public DefaultTableModel model;
	public JScrollPane scrollPane;
	private Source source = new Source();
	public JTextField textField_timkiem;

	public JButton button_refesh1;

	public JButton button_search1;

	public JComboBox<String> comboBox_gioitinh;

	public JComboBox<String> comboBox_maND;

	public TaiKhoanView() {
		setLayout(new BorderLayout(0, 0));

		JPanel panel_border_chucNang = new JPanel();
		panel_border_chucNang.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Chức năng",
				TitledBorder.LEFT, TitledBorder.ABOVE_TOP, new Font("Arial", Font.ITALIC, 14), new Color(0, 0, 0)));

		JPanel jpanel_North = new JPanel(new GridLayout(1, 2));
		this.add(jpanel_North, BorderLayout.NORTH);
		jpanel_North.add(panel_border_chucNang);
		jpanel_North.setBorder(BorderFactory.createEmptyBorder(10, 0, 40, 0));

		panel_border_chucNang.setLayout(new GridLayout(1, 6));

		JLabel jlabel_them = new JLabel("Thêm", source.icon_add, JLabel.CENTER);
		jlabel_them.setFont(new Font("Arial", Font.PLAIN, 12));
		jlabel_them.setVerticalTextPosition(JLabel.BOTTOM);
		jlabel_them.setHorizontalTextPosition(JLabel.CENTER);
		panel_border_chucNang.add(jlabel_them);

		JLabel jlabel_sua = new JLabel("Sửa", source.icon_pencil, JLabel.CENTER);
		jlabel_sua.setFont(new Font("Arial", Font.PLAIN, 12));
		jlabel_sua.setVerticalTextPosition(JLabel.BOTTOM);
		jlabel_sua.setHorizontalTextPosition(JLabel.CENTER);
		panel_border_chucNang.add(jlabel_sua);

		JLabel jlabel_xoa = new JLabel("Xóa", source.icon_remove, JLabel.CENTER);
		jlabel_xoa.setFont(new Font("Arial", Font.PLAIN, 12));
		jlabel_xoa.setVerticalTextPosition(JLabel.BOTTOM);
		jlabel_xoa.setHorizontalTextPosition(JLabel.CENTER);
		panel_border_chucNang.add(jlabel_xoa);
		JLabel jlabel_nhapExcel = new JLabel("Nhập Excel", source.icon_Excel, JLabel.CENTER);
		jlabel_nhapExcel.setFont(new Font("Arial", Font.PLAIN, 12));
		jlabel_nhapExcel.setVerticalTextPosition(JLabel.BOTTOM);
		jlabel_nhapExcel.setHorizontalTextPosition(JLabel.CENTER);
		panel_border_chucNang.add(jlabel_nhapExcel);

		JLabel jlabel_Excel = new JLabel("Xuất Excel", source.icon_Excel, JLabel.CENTER);
		jlabel_Excel.setFont(new Font("Arial", Font.PLAIN, 12));
		jlabel_Excel.setVerticalTextPosition(JLabel.BOTTOM);
		jlabel_Excel.setHorizontalTextPosition(JLabel.CENTER);
		panel_border_chucNang.add(jlabel_Excel);

		JPanel panel_border_timKiem = new JPanel();
		panel_border_timKiem.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Tìm kiếm",
				TitledBorder.LEFT, TitledBorder.ABOVE_TOP, new Font("Arial", Font.ITALIC, 14), new Color(0, 0, 0)));
		jpanel_North.add(panel_border_timKiem);
		GridBagLayout gbl_panel_border_timKiem = new GridBagLayout();
		gbl_panel_border_timKiem.columnWidths = new int[] { 100, 100, 100, 100, 100, 0 };
		gbl_panel_border_timKiem.rowHeights = new int[] { 22, 22, 0 };
		gbl_panel_border_timKiem.columnWeights = new double[] { 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel_border_timKiem.rowWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		panel_border_timKiem.setLayout(gbl_panel_border_timKiem);

		textField_timkiem = new JTextField();
		textField_timkiem.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_textField_timkiem = new GridBagConstraints();
		gbc_textField_timkiem.fill = GridBagConstraints.BOTH;
		gbc_textField_timkiem.insets = new Insets(0, 0, 5, 5);
		gbc_textField_timkiem.gridx = 0;
		gbc_textField_timkiem.gridy = 0;
		gbc_textField_timkiem.gridwidth = 3;

		panel_border_timKiem.add(textField_timkiem, gbc_textField_timkiem);
		textField_timkiem.setColumns(10);

		button_refesh1 = new JButton(source.icon_refresh);
		button_refesh1.setBackground(new Color(255, 255, 255));
		button_refesh1.setFont(new Font("Arial", Font.PLAIN, 12));
		button_refesh1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		GridBagConstraints gbc_button_refesh1 = new GridBagConstraints();
		gbc_button_refesh1.fill = GridBagConstraints.BOTH;
		gbc_button_refesh1.insets = new Insets(0, 0, 5, 5);
		gbc_button_refesh1.gridx = 3;
		gbc_button_refesh1.gridy = 0;
		panel_border_timKiem.add(button_refesh1, gbc_button_refesh1);

		button_search1 = new JButton("Tìm kiếm");
		button_search1.setBackground(new Color(255, 255, 255));
		button_search1.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_button_search1 = new GridBagConstraints();
		gbc_button_search1.fill = GridBagConstraints.BOTH;
		gbc_button_search1.insets = new Insets(0, 0, 5, 0);
		gbc_button_search1.gridx = 4;
		gbc_button_search1.gridy = 0;
		panel_border_timKiem.add(button_search1, gbc_button_search1);

		JLabel lblNewLabel = new JLabel("Mã tài khoản");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 1;
		panel_border_timKiem.add(lblNewLabel, gbc_lblNewLabel);

		comboBox_maND = new JComboBox<>();
		comboBox_maND.setBackground(new Color(255, 255, 255));
		comboBox_maND = addItemMaNguoiDung();
		comboBox_maND.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_comboBox_maND = new GridBagConstraints();
		gbc_comboBox_maND.fill = GridBagConstraints.BOTH;
		gbc_comboBox_maND.insets = new Insets(0, 0, 0, 5);
		gbc_comboBox_maND.gridx = 1;
		gbc_comboBox_maND.gridy = 1;
		panel_border_timKiem.add(comboBox_maND, gbc_comboBox_maND);

		JLabel lblNewLabel_1 = new JLabel("Giới tính");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_1.gridx = 3;
		gbc_lblNewLabel_1.gridy = 1;
		panel_border_timKiem.add(lblNewLabel_1, gbc_lblNewLabel_1);

		comboBox_gioitinh = new JComboBox<>();
		comboBox_gioitinh.setBackground(new Color(255, 255, 255));
		comboBox_gioitinh.addItem("Tất cả");
		comboBox_gioitinh.addItem("nam");
		comboBox_gioitinh.addItem("nữ");
		comboBox_gioitinh.setFont(new Font("Arial", Font.PLAIN, 12));
		GridBagConstraints gbc_comboBox_gioitinh = new GridBagConstraints();
		gbc_comboBox_gioitinh.fill = GridBagConstraints.BOTH;
		gbc_comboBox_gioitinh.gridx = 4;
		gbc_comboBox_gioitinh.gridy = 1;
		panel_border_timKiem.add(comboBox_gioitinh, gbc_comboBox_gioitinh);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 170, 1169, 593);
		this.add(scrollPane, BorderLayout.CENTER);

		table = new JTable();
		table = SanPham();
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		JTableHeader header = table.getTableHeader();
		header.setFont(new Font("Arial", Font.BOLD, 14));
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		setKhoangCachTable();
		scrollPane.setViewportView(table);

		TaiKhoanMouseListener mouse = new TaiKhoanMouseListener(this);
		jlabel_them.addMouseListener(mouse);
		jlabel_Excel.addMouseListener(mouse);
		jlabel_sua.addMouseListener(mouse);
		jlabel_nhapExcel.addMouseListener(mouse);
		jlabel_xoa.addMouseListener(mouse);

		TaiKhoanActionListener ac = new TaiKhoanActionListener(this);
		button_refesh1.addActionListener(ac);
		button_search1.addActionListener(ac);
		textField_timkiem.addActionListener(ac);
		comboBox_gioitinh.addActionListener(ac);
		comboBox_maND.addActionListener(ac);
	}

	public JTable SanPham() {
		ArrayList<NguoiDung> nd = NguoiDungDAO.getintance().selectByCondition();
		ArrayList<NhanVien> nv = NhanVienDAO.getintance().selectByCondition(nd);
		data = new Object[nd.size()][7];
		for (int i = 0; i < nd.size(); i++) {
			NhanVien nhanvien = nv.get(i);
			NguoiDung nguoidung = nd.get(i);
			data[i][0] = nhanvien.getMaNhanVien();
			data[i][1] = nhanvien.getTenNhanVien();
			data[i][2] = nhanvien.getNgaySinh();
			if (nhanvien.getGioiTinh() == 1) {
				data[i][3] = "nam";
			} else if (nhanvien.getGioiTinh() == 0) {
				data[i][3] = "nữ";
			}

			data[i][4] = nhanvien.getSDT();
			data[i][5] = nhanvien.getMaNguoiDung();
			data[i][6] = nguoidung.getTaiKhoan();
		}
		String column[] = { "MaNV", "Họ tên ", "Ngày sinh", "Giới tính", "SDT", "Mã tài khoản", "Tài khoản" };
		model = new DefaultTableModel(data, column);
		table = new JTable(model);

		setKhoangCachTable();
		return table;
	}

	public void updateTableData() {

		ArrayList<NguoiDung> nd = NguoiDungDAO.getintance().selectByCondition();
		ArrayList<NhanVien> nv = NhanVienDAO.getintance().selectByCondition(nd);
		Object newData[][] = new Object[nd.size()][7];
		for (int i = 0; i < nd.size(); i++) {
			NhanVien nhanvien = nv.get(i);
			NguoiDung nguoidung = nd.get(i);
			if (nguoidung.getPhamViTruyCap() == 1) {
				continue;
			}
			newData[i][0] = nhanvien.getMaNhanVien();
			newData[i][1] = nhanvien.getTenNhanVien();
			newData[i][2] = nhanvien.getNgaySinh();
			if (nhanvien.getGioiTinh() == 1) {
				newData[i][3] = "nam";
			} else if (nhanvien.getGioiTinh() == 0) {
				newData[i][3] = "nữ";
			}

			newData[i][4] = nhanvien.getSDT();
			newData[i][5] = nhanvien.getMaNguoiDung();
			newData[i][6] = nguoidung.getTaiKhoan();
		}
		String column[] = { "MaNV", "Họ tên ", "Ngày sinh", "Giới tính", "SDT", "Mã tài khoản", "Tài khoản" };

		// Cập nhật mô hình của bảng
		model.setDataVector(newData, column);
		setKhoangCachTable();
		// Cập nhật lại giao diện
		this.revalidate();
		this.repaint();
	}

	public void updateTableData(ArrayList<NguoiDung> nd) {

		Object newData[][] = new Object[nd.size()][9];
		for (int i = 0; i < nd.size(); i++) {
			NguoiDung nguoidung = nd.get(i);
			NhanVien nhanvien = NhanVienDAO.getintance().selectByCondition("MaNguoiDung", nguoidung.getMaNguoiDung());
			if (nguoidung.getPhamViTruyCap() == 1) {
				continue;
			}
			newData[i][0] = nhanvien.getMaNhanVien();
			newData[i][1] = nhanvien.getTenNhanVien();
			newData[i][2] = nhanvien.getNgaySinh();
			if (nhanvien.getGioiTinh() == 1) {
				newData[i][3] = "nam";
			} else if (nhanvien.getGioiTinh() == 0) {
				newData[i][3] = "nữ";
			}

			newData[i][4] = nhanvien.getSDT();
			newData[i][5] = nhanvien.getMaNguoiDung();
			newData[i][6] = nguoidung.getTaiKhoan();
		}
		String column[] = { "MaNV", "Họ tên ", "Ngày sinh", "Giới tính", "SDT", "Mã tài khoản", "Tài khoản" };

		// Cập nhật mô hình của bảng
		model.setDataVector(newData, column);
		setKhoangCachTable();
		// Cập nhật lại giao diện
		this.revalidate();
		this.repaint();
	}

	public void updateTableDataByNhanVien(ArrayList<NhanVien> arrNhanVien) {

		Object newData[][] = new Object[arrNhanVien.size()][9];
		for (int i = 0; i < arrNhanVien.size(); i++) {
			NhanVien nhanvien = arrNhanVien.get(i);
			NguoiDung nguoidung = NguoiDungDAO.getintance().selectByCondition("MaNguoiDung", nhanvien.getMaNguoiDung());
			if (nguoidung.getPhamViTruyCap() == 0) {
				newData[i][0] = nhanvien.getMaNhanVien();
				newData[i][1] = nhanvien.getTenNhanVien();
				newData[i][2] = nhanvien.getNgaySinh();
				if (nhanvien.getGioiTinh() == 1) {
					newData[i][3] = "nam";
				} else if (nhanvien.getGioiTinh() == 0) {
					newData[i][3] = "nữ";
				}

				newData[i][4] = nhanvien.getSDT();
				newData[i][5] = nhanvien.getMaNguoiDung();
				newData[i][6] = nguoidung.getTaiKhoan();
			}

		}
		String column[] = { "MaNV", "Họ tên ", "Ngày sinh", "Giới tính", "SDT", "Mã tài khoản", "Tài khoản" };

		// Cập nhật mô hình của bảng
		model.setDataVector(newData, column);
		setKhoangCachTable();
		// Cập nhật lại giao diện
		this.revalidate();
		this.repaint();
	}

	public void setKhoangCachTable() {
		table.getColumnModel().getColumn(0).setPreferredWidth(40);
		table.getColumnModel().getColumn(1).setPreferredWidth(170);
	}

	public JComboBox<String> addItemMaNguoiDung() {
		ArrayList<NguoiDung> nd = NguoiDungDAO.getintance().select_search("");
		ArrayList<NhanVien> arr = new ArrayList<NhanVien>();
		for (int i = 0; i < nd.size(); i++) {
			NhanVien nv = NhanVienDAO.getintance().selectByCondition("MaNguoiDung", nd.get(i).getMaNguoiDung());
			arr.add(nv);
		}

		JComboBox<String> tmp = new JComboBox<String>();
		tmp.addItem("Tất cả");
		for (int i = 0; i < arr.size(); i++) {
			tmp.addItem(arr.get(i).getMaNguoiDung());
		}
		return tmp;
	}

	public ArrayList<NhanVien> select_search(String s, ArrayList<NhanVien> nv, ArrayList<NguoiDung> nd) {
		ArrayList<NhanVien> kq = new ArrayList<NhanVien>();
		s = s.toUpperCase();
		for (int i = 0; i < nv.size(); i++) {
			String tmp = nv.get(i).getTenNhanVien() + nv.get(i).getMaNguoiDung() + nv.get(i).getGioiTinh() + ""
					+ nv.get(i).getMaNhanVien() + nv.get(i).getSDT() + nv.get(i).getNgaySinh()
					+ nd.get(i).getTaiKhoan();
			tmp = tmp.toUpperCase();
			if (tmp.indexOf(s) != -1) {
				kq.add(nv.get(i));
			}
		}
		return kq;
	}

	public void setComboBoxMaNguoiDung() {
		comboBox_maND = addItemMaNguoiDung();
	}
}