
package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import dao.LaptopDAO;
import model.Laptop;
import javax.swing.SwingConstants;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;


public class ThemSanPham extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JTextField jtextField_masanpham;
	public JTextField jtextField_tensanpham;
	public JTextField jtextField_CPU;
	public JTextField jtextField_GPU;
	public JTextField jtextField_manhinh;
	public JTextField jtextField_Hang;
	public JTextField jtextField_hedieuhanh;
	public JTextField jtextField_gia;
	public JButton jbutton_xacnhan;
	public JButton jbutton_huybo;
	public JComboBox<String> comboBox_Rom;
	public JComboBox<String> comboBox_Ram;
	public JComboBox<String> comboBox_Nam;
	public JComboBox<String> comboBox_MaNCC;
	public JLabel lblNewLabel;
	private JPanel panel_center;
	private JPanel panel_South;
	private JPanel panel_MaLaptop;
	private JPanel panel_CPU;
	private JPanel panel_Ram;
	private JPanel panel_TenLap;
	private JPanel panel_GPU;
	private JPanel panel_Rom;
	private JPanel panel_HDH;
	private JPanel panel_Hang;
	private JPanel panel_NamSX;
	private JPanel panel_ManHinh;
	private JPanel panel_Gia;
	private JPanel panel_MaNCC;

	public ThemSanPham() {
		this.setTitle("Thêm sản phẩm");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 835, 539);
		contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		this.setLocationRelativeTo(null);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		
		JPanel jpanel_title = new JPanel();
		jpanel_title.setBackground(new Color(0, 128, 192));
		contentPane.add(jpanel_title,BorderLayout.NORTH);
		jpanel_title.setLayout(new BorderLayout(0, 0));
		
		lblNewLabel = new JLabel("Thêm sản phẩm mới");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 22));
		jpanel_title.add(lblNewLabel);
		//contentPane.add(jlabel_gia);
		
		jbutton_xacnhan = new JButton("Xác nhận");
		jbutton_xacnhan.setForeground(new Color(255, 255, 255));
		jbutton_xacnhan.setBackground(new Color(0, 128, 192));
		jbutton_xacnhan.setFont(new Font("Arial", Font.PLAIN, 18));
		//contentPane.add(jbutton_xacnhan);
		
		jbutton_huybo = new JButton("Hủy bỏ");
		jbutton_huybo.setForeground(Color.WHITE);
		jbutton_huybo.setFont(new Font("Arial", Font.PLAIN, 18));
		jbutton_huybo.setBackground(Color.RED);
		//contentPane.add(jbutton_huybo);
		
		String Ram[] = {"4 GB", "8 GB", "16 GB","32 GB","64 GB", "128 GB", "256 GB"};
		//contentPane.add(comboBox_Ram);
		
		String Rom [] = {"64 GB","128 GB","256 GB","512 GB","1 TB","2 TB", "4 TB"};
		//contentPane.add(comboBox_Rom);
		
		String Nam[] = {"2024","2023","2022","2021","2020","2019","2018"};
		//contentPane.add(jlabel_gia_1);
		
		
		comboBox_MaNCC = new JComboBox<String>();
		//contentPane.add(comboBox_MaNCC);
		
		panel_center = new JPanel();
		contentPane.add(panel_center, BorderLayout.CENTER);
		panel_center.setLayout(new GridLayout(4, 3, 20, 20));
		
		panel_MaLaptop = new JPanel();
		panel_MaLaptop.setBorder(new EmptyBorder(25, 0, 0, 0));
		panel_center.add(panel_MaLaptop);
		GridBagLayout gbl_panel_MaLaptop = new GridBagLayout();
		gbl_panel_MaLaptop.columnWidths = new int[]{130, 130, 0};
		gbl_panel_MaLaptop.rowHeights = new int[]{68, 0};
		gbl_panel_MaLaptop.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_MaLaptop.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_MaLaptop.setLayout(gbl_panel_MaLaptop);
		
			
			JLabel jlabel_masanpham = new JLabel("Mã sản phẩm");
			jlabel_masanpham.setHorizontalAlignment(SwingConstants.CENTER);
			jlabel_masanpham.setFont(new Font("Arial", Font.PLAIN, 16));
			GridBagConstraints gbc_jlabel_masanpham = new GridBagConstraints();
			gbc_jlabel_masanpham.anchor = GridBagConstraints.EAST;
			gbc_jlabel_masanpham.fill = GridBagConstraints.VERTICAL;
			gbc_jlabel_masanpham.insets = new Insets(0, 0, 0, 5);
			gbc_jlabel_masanpham.gridx = 0;
			gbc_jlabel_masanpham.gridy = 0;
			panel_MaLaptop.add(jlabel_masanpham, gbc_jlabel_masanpham);
		//contentPane.add(jlabel_masanpham);
		
		jtextField_masanpham = new JTextField();
		jtextField_masanpham.setFont(new Font("Arial", Font.PLAIN, 16));
		//contentPane.add(jtextField_masanpham);
		jtextField_masanpham.setColumns(10);
		GridBagConstraints gbc_jtextField_masanpham = new GridBagConstraints();
		gbc_jtextField_masanpham.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtextField_masanpham.gridx = 1;
		gbc_jtextField_masanpham.gridy = 0;
		panel_MaLaptop.add(jtextField_masanpham, gbc_jtextField_masanpham);
		
		
		panel_CPU = new JPanel();
		panel_CPU.setBorder(new EmptyBorder(25, 0, 0, 0));
		panel_center.add(panel_CPU);
		GridBagLayout gbl_panel_CPU = new GridBagLayout();
		gbl_panel_CPU.columnWidths = new int[]{130, 130, 0};
		gbl_panel_CPU.rowHeights = new int[]{68, 0};
		gbl_panel_CPU.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_CPU.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_CPU.setLayout(gbl_panel_CPU);
		//contentPane.add(jtextField_tensanpham);
		
		JLabel jlabel_CPU = new JLabel("CPU");
		jlabel_CPU.setHorizontalAlignment(SwingConstants.CENTER);
		jlabel_CPU.setFont(new Font("Arial", Font.PLAIN, 16));
		GridBagConstraints gbc_jlabel_CPU = new GridBagConstraints();
		gbc_jlabel_CPU.anchor = GridBagConstraints.EAST;
		gbc_jlabel_CPU.fill = GridBagConstraints.VERTICAL;
		gbc_jlabel_CPU.insets = new Insets(0, 0, 0, 5);
		gbc_jlabel_CPU.gridx = 0;
		gbc_jlabel_CPU.gridy = 0;
		panel_CPU.add(jlabel_CPU, gbc_jlabel_CPU);
		//contentPane.add(jlabel_CPU);
		
		jtextField_CPU = new JTextField();
		jtextField_CPU.setFont(new Font("Arial", Font.PLAIN, 16));
		jtextField_CPU.setColumns(10);
		GridBagConstraints gbc_jtextField_CPU = new GridBagConstraints();
		gbc_jtextField_CPU.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtextField_CPU.gridx = 1;
		gbc_jtextField_CPU.gridy = 0;
		panel_CPU.add(jtextField_CPU, gbc_jtextField_CPU);
		
		
		panel_Ram = new JPanel();
		panel_Ram.setBorder(new EmptyBorder(25, 0, 0, 0));
		panel_center.add(panel_Ram);
		GridBagLayout gbl_panel_Ram = new GridBagLayout();
		gbl_panel_Ram.columnWidths = new int[]{130, 130, 0};
		gbl_panel_Ram.rowHeights = new int[]{68, 0};
		gbl_panel_Ram.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_Ram.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_Ram.setLayout(gbl_panel_Ram);
		//contentPane.add(jtextField_GPU);
		
		JLabel jlabel_Ram = new JLabel("Ram");
		jlabel_Ram.setHorizontalAlignment(SwingConstants.CENTER);
		jlabel_Ram.setFont(new Font("Arial", Font.PLAIN, 16));
		GridBagConstraints gbc_jlabel_Ram = new GridBagConstraints();
		gbc_jlabel_Ram.anchor = GridBagConstraints.EAST;
		gbc_jlabel_Ram.fill = GridBagConstraints.VERTICAL;
		gbc_jlabel_Ram.insets = new Insets(0, 0, 0, 5);
		gbc_jlabel_Ram.gridx = 0;
		gbc_jlabel_Ram.gridy = 0;
		panel_Ram.add(jlabel_Ram, gbc_jlabel_Ram);
		comboBox_Ram = new JComboBox<String>(Ram);
		comboBox_Ram.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBox_Ram.setBackground(Color.WHITE);
		GridBagConstraints gbc_comboBox_Ram = new GridBagConstraints();
		gbc_comboBox_Ram.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_Ram.gridx = 1;
		gbc_comboBox_Ram.gridy = 0;
		panel_Ram.add(comboBox_Ram, gbc_comboBox_Ram);
		
		
		panel_TenLap = new JPanel();
		panel_TenLap.setBorder(new EmptyBorder(25, 0, 0, 0));
		panel_center.add(panel_TenLap);
		GridBagLayout gbl_panel_TenLap = new GridBagLayout();
		gbl_panel_TenLap.columnWidths = new int[]{130, 130, 0};
		gbl_panel_TenLap.rowHeights = new int[]{68, 0};
		gbl_panel_TenLap.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_TenLap.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_TenLap.setLayout(gbl_panel_TenLap);
		
		JLabel jlabel_tensanpham = new JLabel("Tên sản phẩm");
		jlabel_tensanpham.setFont(new Font("Arial", Font.PLAIN, 16));
		GridBagConstraints gbc_jlabel_tensanpham = new GridBagConstraints();
		gbc_jlabel_tensanpham.anchor = GridBagConstraints.EAST;
		gbc_jlabel_tensanpham.fill = GridBagConstraints.VERTICAL;
		gbc_jlabel_tensanpham.insets = new Insets(0, 0, 0, 5);
		gbc_jlabel_tensanpham.gridx = 0;
		gbc_jlabel_tensanpham.gridy = 0;
		panel_TenLap.add(jlabel_tensanpham, gbc_jlabel_tensanpham);
		//contentPane.add(jlabel_tensanpham);
		
		jtextField_tensanpham = new JTextField();
		jtextField_tensanpham.setFont(new Font("Arial", Font.PLAIN, 16));
		jtextField_tensanpham.setColumns(10);
		GridBagConstraints gbc_jtextField_tensanpham = new GridBagConstraints();
		gbc_jtextField_tensanpham.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtextField_tensanpham.gridx = 1;
		gbc_jtextField_tensanpham.gridy = 0;
		panel_TenLap.add(jtextField_tensanpham, gbc_jtextField_tensanpham);
		
		
		panel_GPU = new JPanel();
		panel_GPU.setBorder(new EmptyBorder(25, 0, 0, 0));
		panel_center.add(panel_GPU);
		GridBagLayout gbl_panel_GPU = new GridBagLayout();
		gbl_panel_GPU.columnWidths = new int[]{130, 130, 0};
		gbl_panel_GPU.rowHeights = new int[]{68, 0};
		gbl_panel_GPU.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_GPU.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_GPU.setLayout(gbl_panel_GPU);
		//contentPane.add(jtextField_CPU);
		
		JLabel jlabel_GPU = new JLabel("GPU");
		jlabel_GPU.setFont(new Font("Arial", Font.PLAIN, 16));
		GridBagConstraints gbc_jlabel_GPU = new GridBagConstraints();
		gbc_jlabel_GPU.anchor = GridBagConstraints.EAST;
		gbc_jlabel_GPU.fill = GridBagConstraints.VERTICAL;
		gbc_jlabel_GPU.insets = new Insets(0, 0, 0, 5);
		gbc_jlabel_GPU.gridx = 0;
		gbc_jlabel_GPU.gridy = 0;
		panel_GPU.add(jlabel_GPU, gbc_jlabel_GPU);
		//contentPane.add(jlabel_GPU);
		
		jtextField_GPU = new JTextField();
		jtextField_GPU.setFont(new Font("Arial", Font.PLAIN, 16));
		jtextField_GPU.setColumns(10);
		GridBagConstraints gbc_jtextField_GPU = new GridBagConstraints();
		gbc_jtextField_GPU.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtextField_GPU.gridx = 1;
		gbc_jtextField_GPU.gridy = 0;
		panel_GPU.add(jtextField_GPU, gbc_jtextField_GPU);
		
		panel_Rom = new JPanel();
		panel_Rom.setBorder(new EmptyBorder(25, 0, 0, 0));
		panel_center.add(panel_Rom);
		GridBagLayout gbl_panel_Rom = new GridBagLayout();
		gbl_panel_Rom.columnWidths = new int[]{130, 130, 0};
		gbl_panel_Rom.rowHeights = new int[]{68, 0};
		gbl_panel_Rom.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_Rom.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_Rom.setLayout(gbl_panel_Rom);
		//contentPane.add(jtextField_gia);
		
		JLabel jlabel_Rom = new JLabel("Rom");
		jlabel_Rom.setFont(new Font("Arial", Font.PLAIN, 16));
		GridBagConstraints gbc_jlabel_Rom = new GridBagConstraints();
		gbc_jlabel_Rom.anchor = GridBagConstraints.EAST;
		gbc_jlabel_Rom.fill = GridBagConstraints.VERTICAL;
		gbc_jlabel_Rom.insets = new Insets(0, 0, 0, 5);
		gbc_jlabel_Rom.gridx = 0;
		gbc_jlabel_Rom.gridy = 0;
		panel_Rom.add(jlabel_Rom, gbc_jlabel_Rom);
		comboBox_Rom = new JComboBox<String>(Rom);
		comboBox_Rom.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBox_Rom.setBackground(Color.WHITE);
		GridBagConstraints gbc_comboBox_Rom = new GridBagConstraints();
		gbc_comboBox_Rom.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_Rom.gridx = 1;
		gbc_comboBox_Rom.gridy = 0;
		panel_Rom.add(comboBox_Rom, gbc_comboBox_Rom);
		
		panel_HDH = new JPanel();
		panel_HDH.setBorder(new EmptyBorder(25, 0, 0, 0));
		panel_center.add(panel_HDH);
		GridBagLayout gbl_panel_HDH = new GridBagLayout();
		gbl_panel_HDH.columnWidths = new int[]{130, 130, 0};
		gbl_panel_HDH.rowHeights = new int[]{68, 0};
		gbl_panel_HDH.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_HDH.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_HDH.setLayout(gbl_panel_HDH);
		//contentPane.add(jlabel_hang);
		
		JLabel jlabel_hedieuhanh = new JLabel("Hệ điều hành");
		jlabel_hedieuhanh.setHorizontalAlignment(SwingConstants.CENTER);
		jlabel_hedieuhanh.setFont(new Font("Arial", Font.PLAIN, 16));
		GridBagConstraints gbc_jlabel_hedieuhanh = new GridBagConstraints();
		gbc_jlabel_hedieuhanh.anchor = GridBagConstraints.EAST;
		gbc_jlabel_hedieuhanh.fill = GridBagConstraints.VERTICAL;
		gbc_jlabel_hedieuhanh.insets = new Insets(0, 0, 0, 5);
		gbc_jlabel_hedieuhanh.gridx = 0;
		gbc_jlabel_hedieuhanh.gridy = 0;
		panel_HDH.add(jlabel_hedieuhanh, gbc_jlabel_hedieuhanh);
		//contentPane.add(jtextField_Hang);
		
		jtextField_hedieuhanh = new JTextField();
		jtextField_hedieuhanh.setFont(new Font("Arial", Font.PLAIN, 16));
		jtextField_hedieuhanh.setColumns(10);
		GridBagConstraints gbc_jtextField_hedieuhanh = new GridBagConstraints();
		gbc_jtextField_hedieuhanh.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtextField_hedieuhanh.gridx = 1;
		gbc_jtextField_hedieuhanh.gridy = 0;
		panel_HDH.add(jtextField_hedieuhanh, gbc_jtextField_hedieuhanh);
		
		panel_Hang = new JPanel();
		panel_Hang.setBorder(new EmptyBorder(25, 0, 0, 0));
		panel_center.add(panel_Hang);
		GridBagLayout gbl_panel_Hang = new GridBagLayout();
		gbl_panel_Hang.columnWidths = new int[]{130, 130, 0};
		gbl_panel_Hang.rowHeights = new int[]{68, 0};
		gbl_panel_Hang.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_Hang.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_Hang.setLayout(gbl_panel_Hang);
		//contentPane.add(jlabel_manhinh);
		
		JLabel jlabel_hang = new JLabel("Hãng");
		jlabel_hang.setFont(new Font("Arial", Font.PLAIN, 16));
		GridBagConstraints gbc_jlabel_hang = new GridBagConstraints();
		gbc_jlabel_hang.anchor = GridBagConstraints.EAST;
		gbc_jlabel_hang.fill = GridBagConstraints.VERTICAL;
		gbc_jlabel_hang.insets = new Insets(0, 0, 0, 5);
		gbc_jlabel_hang.gridx = 0;
		gbc_jlabel_hang.gridy = 0;
		panel_Hang.add(jlabel_hang, gbc_jlabel_hang);
		//contentPane.add(jtextField_manhinh);
		
		jtextField_Hang = new JTextField();
		jtextField_Hang.setFont(new Font("Arial", Font.PLAIN, 16));
		jtextField_Hang.setColumns(10);
		GridBagConstraints gbc_jtextField_Hang = new GridBagConstraints();
		gbc_jtextField_Hang.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtextField_Hang.gridx = 1;
		gbc_jtextField_Hang.gridy = 0;
		panel_Hang.add(jtextField_Hang, gbc_jtextField_Hang);
		
		
		panel_NamSX = new JPanel();
		panel_NamSX.setBorder(new EmptyBorder(25, 0, 0, 0));
		panel_center.add(panel_NamSX);
		GridBagLayout gbl_panel_NamSX = new GridBagLayout();
		gbl_panel_NamSX.columnWidths = new int[]{130, 130, 0};
		gbl_panel_NamSX.rowHeights = new int[]{68, 0};
		gbl_panel_NamSX.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_NamSX.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_NamSX.setLayout(gbl_panel_NamSX);
		//contentPane.add(jlabel_hedieuhanh);
		
		JLabel jlabel_namsanxuat = new JLabel("Năm sản xuất");
		jlabel_namsanxuat.setFont(new Font("Arial", Font.PLAIN, 16));
		GridBagConstraints gbc_jlabel_namsanxuat = new GridBagConstraints();
		gbc_jlabel_namsanxuat.anchor = GridBagConstraints.EAST;
		gbc_jlabel_namsanxuat.fill = GridBagConstraints.VERTICAL;
		gbc_jlabel_namsanxuat.insets = new Insets(0, 0, 0, 5);
		gbc_jlabel_namsanxuat.gridx = 0;
		gbc_jlabel_namsanxuat.gridy = 0;
		panel_NamSX.add(jlabel_namsanxuat, gbc_jlabel_namsanxuat);
		comboBox_Nam = new JComboBox<String>(Nam);
		comboBox_Nam.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBox_Nam.setBackground(Color.WHITE);
		GridBagConstraints gbc_comboBox_Nam = new GridBagConstraints();
		gbc_comboBox_Nam.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBox_Nam.gridx = 1;
		gbc_comboBox_Nam.gridy = 0;
		panel_NamSX.add(comboBox_Nam, gbc_comboBox_Nam);
		
		panel_ManHinh = new JPanel();
		panel_ManHinh.setBorder(new EmptyBorder(25, 0, 0, 0));
		panel_center.add(panel_ManHinh);
		GridBagLayout gbl_panel_ManHinh = new GridBagLayout();
		gbl_panel_ManHinh.columnWidths = new int[]{130, 130, 0};
		gbl_panel_ManHinh.rowHeights = new int[]{68, 0};
		gbl_panel_ManHinh.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_ManHinh.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_ManHinh.setLayout(gbl_panel_ManHinh);
		//contentPane.add(jlabel_Rom);
		
		JLabel jlabel_manhinh = new JLabel("Màn hình");
		jlabel_manhinh.setFont(new Font("Arial", Font.PLAIN, 16));
		GridBagConstraints gbc_jlabel_manhinh = new GridBagConstraints();
		gbc_jlabel_manhinh.anchor = GridBagConstraints.EAST;
		gbc_jlabel_manhinh.fill = GridBagConstraints.VERTICAL;
		gbc_jlabel_manhinh.insets = new Insets(0, 0, 0, 5);
		gbc_jlabel_manhinh.gridx = 0;
		gbc_jlabel_manhinh.gridy = 0;
		panel_ManHinh.add(jlabel_manhinh, gbc_jlabel_manhinh);
		//contentPane.add(jlabel_Ram);
		
		jtextField_manhinh = new JTextField();
		jtextField_manhinh.setFont(new Font("Arial", Font.PLAIN, 16));
		jtextField_manhinh.setColumns(10);
		GridBagConstraints gbc_jtextField_manhinh = new GridBagConstraints();
		gbc_jtextField_manhinh.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtextField_manhinh.gridx = 1;
		gbc_jtextField_manhinh.gridy = 0;
		panel_ManHinh.add(jtextField_manhinh, gbc_jtextField_manhinh);
		
		panel_Gia = new JPanel();
		panel_Gia.setBorder(new EmptyBorder(25, 0, 0, 0));
		panel_center.add(panel_Gia);
		GridBagLayout gbl_panel_Gia = new GridBagLayout();
		gbl_panel_Gia.columnWidths = new int[]{130, 130, 0};
		gbl_panel_Gia.rowHeights = new int[]{68, 0};
		gbl_panel_Gia.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_Gia.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_Gia.setLayout(gbl_panel_Gia);
		//contentPane.add(jlabel_namsanxuat);
		
		JLabel jlabel_gia = new JLabel("Giá");
		jlabel_gia.setFont(new Font("Arial", Font.PLAIN, 16));
		GridBagConstraints gbc_jlabel_gia = new GridBagConstraints();
		gbc_jlabel_gia.anchor = GridBagConstraints.EAST;
		gbc_jlabel_gia.fill = GridBagConstraints.VERTICAL;
		gbc_jlabel_gia.insets = new Insets(0, 0, 0, 5);
		gbc_jlabel_gia.gridx = 0;
		gbc_jlabel_gia.gridy = 0;
		panel_Gia.add(jlabel_gia, gbc_jlabel_gia);
		//contentPane.add(jtextField_hedieuhanh);
		
		jtextField_gia = new JTextField();
		jtextField_gia.setFont(new Font("Arial", Font.PLAIN, 16));
		jtextField_gia.setText("0");
		jtextField_gia.setColumns(10);
		GridBagConstraints gbc_jtextField_gia = new GridBagConstraints();
		gbc_jtextField_gia.fill = GridBagConstraints.HORIZONTAL;
		gbc_jtextField_gia.gridx = 1;
		gbc_jtextField_gia.gridy = 0;
		panel_Gia.add(jtextField_gia, gbc_jtextField_gia);
		
		panel_MaNCC = new JPanel();
		panel_MaNCC.setBorder(new EmptyBorder(25, 0, 0, 0));
		panel_center.add(panel_MaNCC);
		GridBagLayout gbl_panel_MaNCC = new GridBagLayout();
		gbl_panel_MaNCC.columnWidths = new int[]{130, 130, 0};
		gbl_panel_MaNCC.rowHeights = new int[]{68, 0};
		gbl_panel_MaNCC.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel_MaNCC.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_MaNCC.setLayout(gbl_panel_MaNCC);
		//contentPane.add(comboBox_Nam);
		
		JLabel jlabel_gia_1 = new JLabel("Mã nhà cung cấp");
		jlabel_gia_1.setFont(new Font("Arial", Font.PLAIN, 16));
		GridBagConstraints gbc_jlabel_gia_1 = new GridBagConstraints();
		gbc_jlabel_gia_1.anchor = GridBagConstraints.EAST;
		gbc_jlabel_gia_1.fill = GridBagConstraints.VERTICAL;
		gbc_jlabel_gia_1.insets = new Insets(0, 0, 0, 5);
		gbc_jlabel_gia_1.gridx = 0;
		gbc_jlabel_gia_1.gridy = 0;
		panel_MaNCC.add(jlabel_gia_1, gbc_jlabel_gia_1);
		comboBox_MaNCC = addItem("MaNhaCungCap");
		comboBox_MaNCC.setFont(new Font("Arial", Font.PLAIN, 16));
		comboBox_MaNCC.setBackground(Color.WHITE);
		GridBagConstraints gbc_tmp = new GridBagConstraints();
		gbc_tmp.fill = GridBagConstraints.HORIZONTAL;
		gbc_tmp.gridx = 1;
		gbc_tmp.gridy = 0;
		panel_MaNCC.add(comboBox_MaNCC, gbc_tmp);
		
		
		panel_South = new JPanel();
		contentPane.add(panel_South, BorderLayout.SOUTH);
		panel_South.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5));
		panel_South.add(jbutton_xacnhan);
		panel_South.add(jbutton_huybo);
		
		this.setVisible(true);
		//this.setResizable(false);
	}
	
	public String getText(JTextField textfield)
	{
		return textfield.getText();
	}
	
	public JComboBox<String> addItem(String s)
	{
		JComboBox<String> tmp = new JComboBox<String>();
		ArrayList<String> arr = LaptopDAO.getintance().getColumn(s);
		for (String string : arr) {
			tmp.addItem(string);
		}
		return tmp;
	}
	
	public void setJtextField(Laptop lt)
	{
		jtextField_tensanpham.setText(lt.getTenLaptop());
		jtextField_masanpham.setText(lt.getMaLaptop());
		jtextField_CPU.setText(lt.getCPU());
		jtextField_GPU.setText(lt.getGPU());
		jtextField_Hang.setText(lt.getHang());
		jtextField_hedieuhanh.setText(lt.getHeDieuHanh());
		jtextField_manhinh.setText(lt.getManHinh());
		DecimalFormat df = new DecimalFormat("#");
	    String formattedNumber = df.format(lt.getGia());
		jtextField_gia.setText(formattedNumber);
		comboBox_Ram.setSelectedItem(lt.getRam());
		comboBox_Rom.setSelectedItem(lt.getRom());
		comboBox_Nam.setSelectedItem(lt.getNamSanXuat()+"");
		comboBox_MaNCC.setSelectedItem(lt.getMaNhaCungCap());
	}
}




