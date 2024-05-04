package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.util.Calendar;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class ThemTaiKhoan extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField textField_MaNV;
	public JTextField textField_HoTen;
	public JTextField textField_SDT;
	public JTextField textField_MaND;
	public JTextField textField_TaiKhoan;
	public JTextField textField_MatKhau;
	public SpinnerNumberModel dayModel;
	public SpinnerNumberModel monthModel;
	public SpinnerNumberModel yearModel;
	public ButtonGroup buttonGroup;
	public JRadioButton radioButton1;
	public JRadioButton radioButton2;
	public JButton button_xacnhan;
	public JButton button_huybo;
	public JSpinner daySpinner;
	public JSpinner monthSpinner;
	public JSpinner yearSpinner;
	public JLabel lblNewLabel_6;
	public JLabel MatKhau;
	public JPanel panel_chinh;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThemTaiKhoan frame = new ThemTaiKhoan();
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
	public ThemTaiKhoan() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 714, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panelCenter = new JPanel();
		contentPane.add(panelCenter, BorderLayout.CENTER);
		GridBagLayout gbl_panelCenter = new GridBagLayout();
		gbl_panelCenter.columnWidths = new int[]{147, 147, 147, 147, 147, 147, 0};
		gbl_panelCenter.rowHeights = new int[]{533, 0};
		gbl_panelCenter.columnWeights = new double[]{1.0, 0.0, 0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_panelCenter.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panelCenter.setLayout(gbl_panelCenter);
		
		JLabel lblNewLabel = new JLabel("");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		panelCenter.add(lblNewLabel, gbc_lblNewLabel);
		
		panel_chinh = new JPanel();
		GridBagConstraints gbc_panel_chinh = new GridBagConstraints();
		gbc_panel_chinh.fill = GridBagConstraints.BOTH;
		gbc_panel_chinh.insets = new Insets(0, 0, 0, 5);
		gbc_panel_chinh.gridx = 1;
		gbc_panel_chinh.gridy = 0;
		gbc_panel_chinh.gridwidth = 4;
		panelCenter.add(panel_chinh, gbc_panel_chinh);
		GridBagLayout gbl_panel_chinh = new GridBagLayout();
		gbl_panel_chinh.columnWidths = new int[]{291, 291, 0};
		gbl_panel_chinh.rowHeights = new int[]{64, 64, 64, 64, 64, 64, 64, 64, 0};
		gbl_panel_chinh.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_chinh.rowWeights = new double[]{1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel_chinh.setLayout(gbl_panel_chinh);
		
		JLabel MaNhanVien = new JLabel("Mã nhân viên:");
		MaNhanVien.setForeground(new Color(0, 128, 192));
		MaNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_MaNhanVien = new GridBagConstraints();
		gbc_MaNhanVien.anchor = GridBagConstraints.WEST;
		gbc_MaNhanVien.fill = GridBagConstraints.VERTICAL;
		gbc_MaNhanVien.insets = new Insets(0, 0, 5, 5);
		gbc_MaNhanVien.gridx = 0;
		gbc_MaNhanVien.gridy = 0;
		panel_chinh.add(MaNhanVien, gbc_MaNhanVien);
		
		textField_MaNV = new JTextField();
		textField_MaNV.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_textField_MaNV = new GridBagConstraints();
		gbc_textField_MaNV.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_MaNV.insets = new Insets(0, 0, 5, 0);
		gbc_textField_MaNV.gridx = 1;
		gbc_textField_MaNV.gridy = 0;
		panel_chinh.add(textField_MaNV, gbc_textField_MaNV);
		textField_MaNV.setColumns(10);
		
		JLabel TenNhanVien = new JLabel("Họ tên:");
		TenNhanVien.setForeground(new Color(0, 128, 192));
		TenNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_TenNhanVien = new GridBagConstraints();
		gbc_TenNhanVien.fill = GridBagConstraints.BOTH;
		gbc_TenNhanVien.insets = new Insets(0, 0, 5, 5);
		gbc_TenNhanVien.gridx = 0;
		gbc_TenNhanVien.gridy = 1;
		panel_chinh.add(TenNhanVien, gbc_TenNhanVien);
		
		textField_HoTen = new JTextField();
		textField_HoTen.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_textField_HoTen = new GridBagConstraints();
		gbc_textField_HoTen.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_HoTen.insets = new Insets(0, 0, 5, 0);
		gbc_textField_HoTen.gridx = 1;
		gbc_textField_HoTen.gridy = 1;
		panel_chinh.add(textField_HoTen, gbc_textField_HoTen);
		textField_HoTen.setColumns(10);
		
		JLabel NgaySinh = new JLabel("Ngày sinh:");
		NgaySinh.setForeground(new Color(0, 128, 192));
		NgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_NgaySinh = new GridBagConstraints();
		gbc_NgaySinh.fill = GridBagConstraints.BOTH;
		gbc_NgaySinh.insets = new Insets(0, 0, 5, 5);
		gbc_NgaySinh.gridx = 0;
		gbc_NgaySinh.gridy = 2;
		panel_chinh.add(NgaySinh, gbc_NgaySinh);
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 2;
		panel_chinh.add(panel, gbc_panel);
		
        panel.setLayout(new FlowLayout());

        // Spinner để chọn ngày
        dayModel = new SpinnerNumberModel(1, 1, 31, 1);
        daySpinner = new JSpinner(dayModel);
        daySpinner.setFont(new Font("Tahoma", Font.PLAIN, 18));
        // Spinner để chọn tháng
        monthModel = new SpinnerNumberModel(1, 1, 12, 1);
        monthSpinner = new JSpinner(monthModel);
        monthSpinner.setFont(new Font("Tahoma", Font.PLAIN, 18));
        // Spinner để chọn năm
        yearModel = new SpinnerNumberModel(Calendar.getInstance().get(Calendar.YEAR), 1900, 2100, 1);
        yearSpinner = new JSpinner(yearModel);
        yearSpinner.setFont(new Font("Tahoma", Font.PLAIN, 18));
        panel.add(yearSpinner);
        JLabel label = new JLabel("/");
        label.setFont(new Font("Tahoma", Font.PLAIN, 18));
        panel.add(label);
        panel.add(monthSpinner);
        JLabel label_1 = new JLabel("/");
        label_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        panel.add(label_1);
        panel.add(daySpinner);
		
		JLabel GioiTinh = new JLabel("Giới tính:");
		GioiTinh.setForeground(new Color(0, 128, 192));
		GioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_GioiTinh = new GridBagConstraints();
		gbc_GioiTinh.fill = GridBagConstraints.BOTH;
		gbc_GioiTinh.insets = new Insets(0, 0, 5, 5);
		gbc_GioiTinh.gridx = 0;
		gbc_GioiTinh.gridy = 3;
		panel_chinh.add(GioiTinh, gbc_GioiTinh);
		
		JPanel panel_radio = new JPanel();
		GridBagConstraints gbc_panel_radio = new GridBagConstraints();
		gbc_panel_radio.insets = new Insets(0, 0, 5, 0);
		gbc_panel_radio.fill = GridBagConstraints.BOTH;
		gbc_panel_radio.gridx = 1;
		gbc_panel_radio.gridy = 3;
		panel_chinh.add(panel_radio, gbc_panel_radio);
		
		radioButton1 = new JRadioButton("Nam");
		radioButton1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		radioButton1.setHorizontalAlignment(SwingConstants.CENTER);
	    radioButton2 = new JRadioButton("Nữ");
	    radioButton2.setFont(new Font("Tahoma", Font.PLAIN, 18));
	    radioButton2.setHorizontalAlignment(SwingConstants.CENTER);
	    buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButton1);
        buttonGroup.add(radioButton2);
        panel_radio.setLayout(new GridLayout(1,2));
        panel_radio.add(radioButton1);
        panel_radio.add(radioButton2);
		
		JLabel SDT = new JLabel("Số điện thoại:");
		SDT.setForeground(new Color(0, 128, 192));
		SDT.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_SDT = new GridBagConstraints();
		gbc_SDT.fill = GridBagConstraints.BOTH;
		gbc_SDT.insets = new Insets(0, 0, 5, 5);
		gbc_SDT.gridx = 0;
		gbc_SDT.gridy = 4;
		panel_chinh.add(SDT, gbc_SDT);
		
		textField_SDT = new JTextField();
		textField_SDT.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_textField_SDT = new GridBagConstraints();
		gbc_textField_SDT.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_SDT.insets = new Insets(0, 0, 5, 0);
		gbc_textField_SDT.gridx = 1;
		gbc_textField_SDT.gridy = 4;
		panel_chinh.add(textField_SDT, gbc_textField_SDT);
		textField_SDT.setColumns(10);
		
		JLabel MaNguoiDung = new JLabel("Mã tài khoản:");
		MaNguoiDung.setForeground(new Color(0, 128, 192));
		MaNguoiDung.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_MaNguoiDung = new GridBagConstraints();
		gbc_MaNguoiDung.fill = GridBagConstraints.BOTH;
		gbc_MaNguoiDung.insets = new Insets(0, 0, 5, 5);
		gbc_MaNguoiDung.gridx = 0;
		gbc_MaNguoiDung.gridy = 5;
		panel_chinh.add(MaNguoiDung, gbc_MaNguoiDung);
		
		textField_MaND = new JTextField();
		textField_MaND.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_textField_MaND = new GridBagConstraints();
		gbc_textField_MaND.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_MaND.insets = new Insets(0, 0, 5, 0);
		gbc_textField_MaND.gridx = 1;
		gbc_textField_MaND.gridy = 5;
		panel_chinh.add(textField_MaND, gbc_textField_MaND);
		textField_MaND.setColumns(10);
		
		JLabel TaiKhoan = new JLabel("Tài khoản:");
		TaiKhoan.setForeground(new Color(0, 128, 192));
		TaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_TaiKhoan = new GridBagConstraints();
		gbc_TaiKhoan.fill = GridBagConstraints.BOTH;
		gbc_TaiKhoan.insets = new Insets(0, 0, 5, 5);
		gbc_TaiKhoan.gridx = 0;
		gbc_TaiKhoan.gridy = 6;
		panel_chinh.add(TaiKhoan, gbc_TaiKhoan);
		
		textField_TaiKhoan = new JTextField();
		textField_TaiKhoan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_textField_TaiKhoan = new GridBagConstraints();
		gbc_textField_TaiKhoan.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_TaiKhoan.insets = new Insets(0, 0, 5, 0);
		gbc_textField_TaiKhoan.gridx = 1;
		gbc_textField_TaiKhoan.gridy = 6;
		panel_chinh.add(textField_TaiKhoan, gbc_textField_TaiKhoan);
		textField_TaiKhoan.setColumns(10);
		
		MatKhau = new JLabel("Mật khẩu:");
		MatKhau.setForeground(new Color(0, 128, 192));
		MatKhau.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_MatKhau = new GridBagConstraints();
		gbc_MatKhau.fill = GridBagConstraints.BOTH;
		gbc_MatKhau.insets = new Insets(0, 0, 0, 5);
		gbc_MatKhau.gridx = 0;
		gbc_MatKhau.gridy = 7;
		panel_chinh.add(MatKhau, gbc_MatKhau);
		
		textField_MatKhau = new JTextField();
		textField_MatKhau.setFont(new Font("Tahoma", Font.PLAIN, 18));
		GridBagConstraints gbc_textField_MatKhau = new GridBagConstraints();
		gbc_textField_MatKhau.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_MatKhau.gridx = 1;
		gbc_textField_MatKhau.gridy = 7;
		panel_chinh.add(textField_MatKhau, gbc_textField_MatKhau);
		textField_MatKhau.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_1.fill = GridBagConstraints.VERTICAL;
		gbc_lblNewLabel_1.gridx = 5;
		gbc_lblNewLabel_1.gridy = 0;
		panelCenter.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JPanel panelSouth = new JPanel();
		contentPane.add(panelSouth, BorderLayout.SOUTH);
		
		button_xacnhan = new JButton("Xác nhận");
		button_xacnhan.setBackground(new Color(0, 128, 192));
		button_xacnhan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelSouth.add(button_xacnhan);
		
		button_huybo = new JButton("Hủy bỏ");
		button_huybo.setBackground(new Color(255, 0, 0));
		button_huybo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panelSouth.add(button_huybo);
		
		lblNewLabel_6 = new JLabel("Thêm tài khoản");
		lblNewLabel_6.setForeground(new Color(0, 128, 192));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_6, BorderLayout.NORTH);
		
		
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		
	}
	
	public void setYMD_now()
	{	

		dayModel = new SpinnerNumberModel(1, 1, 31, 1);
        daySpinner = new JSpinner(dayModel);
        daySpinner.setFont(new Font("Tahoma", Font.PLAIN, 18));

        // Spinner để chọn tháng
        monthModel = new SpinnerNumberModel(1, 1, 12, 1);
        monthSpinner = new JSpinner(monthModel);
        monthSpinner.setFont(new Font("Tahoma", Font.PLAIN, 18));
        // Spinner để chọn năm
        yearModel = new SpinnerNumberModel(Calendar.getInstance().get(Calendar.YEAR), 1900, 2100, 1);
        yearSpinner = new JSpinner(yearModel);
        yearSpinner.setFont(new Font("Tahoma", Font.PLAIN, 18));
	}
	
	public void setYMD(int ngay,int thang, int nam)
	{
		daySpinner.setValue(ngay);
		monthSpinner.setValue(thang);
		yearSpinner.setValue(nam);
	}
	
	
}