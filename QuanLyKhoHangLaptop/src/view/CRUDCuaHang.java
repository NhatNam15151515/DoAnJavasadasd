package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import model.XaPhuong;

//dùng chung cho cả thêm và sửa
public class CRUDCuaHang extends JFrame {

	public static final long serialVersionUID = 1L;
	public JPanel contentPane;
	public JTextField textField_MaCH;
	public JTextField textField_TenCH;
	public JTextField textField_SDT;
	public JTextField textField_DiaChi;
	public JComboBox<Object> comboBox_QuanHuyen;
	public JButton Button_HuyBo;
	public JButton Button_XacNhan;
	public JComboBox<Object> comboBox_XaPhuong;
	public JPanel panel_Button;
	public JComboBox<Object> comboBox_TPHO;
	public JLabel Label_DiaChi;
	public JPanel panel_Title_DiaChi;
	public JLabel Label_SDT;
	public JPanel panel_Title_SDT;
	public JLabel Label_TenCH;
	public JPanel panel_Title_TenCH;
	public JLabel Label_MaCH;
	public JPanel panel_Title_ThemCH;
	public JLabel Label_ThemCH;
	public JPanel panel_Title_MaCH;
	public String ThanhPho[] = { "TP HCM" };

	public String[] Quan_Huyen = { "Quận 1", "Quận 2", "Quận 3", "Quận 4", "Quận 5", "Quận 6", "Quận 7", "Quận 8",
			"Quận 9", "Quận 10", "Quận 11", "Quận 12", "Quận Thủ Đức", "Quận Gò Vấp", "Quận Bình Thạnh",
			"Quận Tân Bình", "Quận Tân Phú", "Quận Phú Nhuận", "Quận Bình Tân", "Huyện Củ Chi", "Huyện Bình Chánh",
			"Huyện Nhà Bè", "Huyện Cần Giờ" };
	public String[] Xa_Phuong = {};

	public CRUDCuaHang() {
		// super("Thêm Cửa Hàng");
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 551, 440);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[] { 401, 0 };
		gbl_contentPane.rowHeights = new int[] { 43, 71, 62, 62, 106, 48, 0 };
		gbl_contentPane.columnWeights = new double[] { 0.0, Double.MIN_VALUE };
		gbl_contentPane.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPane.setLayout(gbl_contentPane);

		panel_Title_ThemCH = new JPanel();
		panel_Title_ThemCH.setBackground(new Color(0, 128, 192));
		GridBagConstraints gbc_panel_Title_ThemCH = new GridBagConstraints();
		gbc_panel_Title_ThemCH.weightx = 1.0;
		gbc_panel_Title_ThemCH.fill = GridBagConstraints.BOTH;
		gbc_panel_Title_ThemCH.gridx = 0;
		gbc_panel_Title_ThemCH.gridy = 0;
		contentPane.add(panel_Title_ThemCH, gbc_panel_Title_ThemCH);
		panel_Title_ThemCH.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		Label_ThemCH = new JLabel("Thêm Cửa Hàng");
		Label_ThemCH.setHorizontalAlignment(SwingConstants.CENTER);
		Label_ThemCH.setForeground(Color.WHITE);
		Label_ThemCH.setFont(new Font("Arial", Font.BOLD, 20));
		panel_Title_ThemCH.add(Label_ThemCH);

		panel_Title_MaCH = new JPanel();
		GridBagConstraints gbc_panel_Title_MaCH = new GridBagConstraints();
		gbc_panel_Title_MaCH.fill = GridBagConstraints.BOTH;
		gbc_panel_Title_MaCH.weightx = 1.0;
		gbc_panel_Title_MaCH.weighty = 1.0;
		gbc_panel_Title_MaCH.insets = new Insets(20, 0, 20, 0);
		gbc_panel_Title_MaCH.gridx = 0;
		gbc_panel_Title_MaCH.gridy = 1;
		contentPane.add(panel_Title_MaCH, gbc_panel_Title_MaCH);
		GridBagLayout gbl_panel_Title_MaCH = new GridBagLayout();
		gbl_panel_Title_MaCH.columnWidths = new int[] { 113, 258, 0 };
		gbl_panel_Title_MaCH.rowHeights = new int[] { 28, 0 };
		gbl_panel_Title_MaCH.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_Title_MaCH.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_Title_MaCH.setLayout(gbl_panel_Title_MaCH);

		Label_MaCH = new JLabel("Mã Cửa Hàng ");
		Label_MaCH.setVerticalAlignment(SwingConstants.BOTTOM);
		Label_MaCH.setHorizontalAlignment(SwingConstants.LEFT);
		Label_MaCH.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_label_MaCH = new GridBagConstraints();
		gbc_label_MaCH.weighty = 1.0;
		gbc_label_MaCH.weightx = 1.0;
		gbc_label_MaCH.fill = GridBagConstraints.BOTH;
		gbc_label_MaCH.insets = new Insets(0, 10, 0, 5);
		gbc_label_MaCH.gridx = 0;
		gbc_label_MaCH.gridy = 0;
		panel_Title_MaCH.add(Label_MaCH, gbc_label_MaCH);

		textField_MaCH = new JTextField();
		textField_MaCH.setHorizontalAlignment(SwingConstants.LEFT);
		textField_MaCH.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_textField_MaCH = new GridBagConstraints();
		gbc_textField_MaCH.weighty = 1.0;
		gbc_textField_MaCH.insets = new Insets(0, 0, 0, 10);
		gbc_textField_MaCH.weightx = 1.0;
		gbc_textField_MaCH.fill = GridBagConstraints.BOTH;
		gbc_textField_MaCH.gridx = 1;
		gbc_textField_MaCH.gridy = 0;
		panel_Title_MaCH.add(textField_MaCH, gbc_textField_MaCH);
		textField_MaCH.setColumns(18);

		panel_Title_TenCH = new JPanel();
		GridBagConstraints gbc_panel_Title_TenCH = new GridBagConstraints();
		gbc_panel_Title_TenCH.weighty = 1.0;
		gbc_panel_Title_TenCH.weightx = 1.0;
		gbc_panel_Title_TenCH.fill = GridBagConstraints.BOTH;
		gbc_panel_Title_TenCH.insets = new Insets(15, 0, 15, 0);
		gbc_panel_Title_TenCH.gridx = 0;
		gbc_panel_Title_TenCH.gridy = 2;
		contentPane.add(panel_Title_TenCH, gbc_panel_Title_TenCH);
		GridBagLayout gbl_panel_Title_TenCH = new GridBagLayout();
		gbl_panel_Title_TenCH.columnWidths = new int[] { 120, 258, 0 };
		gbl_panel_Title_TenCH.rowHeights = new int[] { 28, 0 };
		gbl_panel_Title_TenCH.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_Title_TenCH.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_Title_TenCH.setLayout(gbl_panel_Title_TenCH);

		Label_TenCH = new JLabel("Tên Cửa Hàng");
		Label_TenCH.setVerticalAlignment(SwingConstants.BOTTOM);
		Label_TenCH.setHorizontalAlignment(SwingConstants.LEFT);
		Label_TenCH.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_label_TenCH = new GridBagConstraints();
		gbc_label_TenCH.weighty = 1.0;
		gbc_label_TenCH.weightx = 1.0;
		gbc_label_TenCH.fill = GridBagConstraints.BOTH;
		gbc_label_TenCH.insets = new Insets(0, 10, 0, 0);
		gbc_label_TenCH.gridx = 0;
		gbc_label_TenCH.gridy = 0;
		panel_Title_TenCH.add(Label_TenCH, gbc_label_TenCH);

		textField_TenCH = new JTextField();
		textField_TenCH.setHorizontalAlignment(SwingConstants.LEFT);
		textField_TenCH.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_TenCH.setColumns(18);
		GridBagConstraints gbc_textField_TenCH = new GridBagConstraints();
		gbc_textField_TenCH.weighty = 1.0;
		gbc_textField_TenCH.weightx = 1.0;
		gbc_textField_TenCH.insets = new Insets(0, 4, 0, 10);
		gbc_textField_TenCH.fill = GridBagConstraints.BOTH;
		gbc_textField_TenCH.gridx = 1;
		gbc_textField_TenCH.gridy = 0;
		panel_Title_TenCH.add(textField_TenCH, gbc_textField_TenCH);

		panel_Title_SDT = new JPanel();
		GridBagConstraints gbc_panel_Title_SDT = new GridBagConstraints();
		gbc_panel_Title_SDT.weighty = 1.0;
		gbc_panel_Title_SDT.weightx = 1.0;
		gbc_panel_Title_SDT.fill = GridBagConstraints.BOTH;
		gbc_panel_Title_SDT.insets = new Insets(15, 0, 15, 0);
		gbc_panel_Title_SDT.gridx = 0;
		gbc_panel_Title_SDT.gridy = 3;
		contentPane.add(panel_Title_SDT, gbc_panel_Title_SDT);
		GridBagLayout gbl_panel_Title_SDT = new GridBagLayout();
		gbl_panel_Title_SDT.columnWidths = new int[] { 120, 258, 0 };
		gbl_panel_Title_SDT.rowHeights = new int[] { 28, 0 };
		gbl_panel_Title_SDT.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_Title_SDT.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_Title_SDT.setLayout(gbl_panel_Title_SDT);

		Label_SDT = new JLabel("Số Điện Thoại");
		Label_SDT.setVerticalAlignment(SwingConstants.BOTTOM);
		Label_SDT.setHorizontalAlignment(SwingConstants.LEFT);
		Label_SDT.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_label_SDT = new GridBagConstraints();
		gbc_label_SDT.weighty = 1.0;
		gbc_label_SDT.weightx = 1.0;
		gbc_label_SDT.fill = GridBagConstraints.BOTH;
		gbc_label_SDT.insets = new Insets(0, 10, 0, 0);
		gbc_label_SDT.gridx = 0;
		gbc_label_SDT.gridy = 0;
		panel_Title_SDT.add(Label_SDT, gbc_label_SDT);

		textField_SDT = new JTextField();
		textField_SDT.setHorizontalAlignment(SwingConstants.LEFT);
		textField_SDT.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_SDT.setColumns(18);
		GridBagConstraints gbc_textField_SDT = new GridBagConstraints();
		gbc_textField_SDT.weighty = 1.0;
		gbc_textField_SDT.weightx = 1.0;
		gbc_textField_SDT.insets = new Insets(0, 9, 0, 10);
		gbc_textField_SDT.fill = GridBagConstraints.BOTH;
		gbc_textField_SDT.gridx = 1;
		gbc_textField_SDT.gridy = 0;
		panel_Title_SDT.add(textField_SDT, gbc_textField_SDT);

		panel_Title_DiaChi = new JPanel();
		GridBagLayout gbl_panel_Title_DiaChi = new GridBagLayout();
		gbl_panel_Title_DiaChi.columnWidths = new int[] { 121, 96, 151, 0 };
		gbl_panel_Title_DiaChi.rowHeights = new int[] { 28, 30, 28, 0 };
		gbl_panel_Title_DiaChi.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_Title_DiaChi.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_Title_DiaChi.setLayout(gbl_panel_Title_DiaChi);

		Label_DiaChi = new JLabel("Địa Chỉ");
		Label_DiaChi.setVerticalAlignment(SwingConstants.BOTTOM);
		Label_DiaChi.setHorizontalAlignment(SwingConstants.LEFT);
		Label_DiaChi.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_label_DiaChi = new GridBagConstraints();
		gbc_label_DiaChi.weighty = 1.0;
		gbc_label_DiaChi.weightx = 1.0;
		gbc_label_DiaChi.fill = GridBagConstraints.BOTH;
		gbc_label_DiaChi.insets = new Insets(15, 10, 0, 5);
		gbc_label_DiaChi.gridx = 0;
		gbc_label_DiaChi.gridy = 0;
		panel_Title_DiaChi.add(Label_DiaChi, gbc_label_DiaChi);

		textField_DiaChi = new JTextField();
		textField_DiaChi.setToolTipText("");
		textField_DiaChi.setHorizontalAlignment(SwingConstants.LEFT);
		textField_DiaChi.setFont(new Font("Arial", Font.PLAIN, 18));
		textField_DiaChi.setColumns(18);
		GridBagConstraints gbc_textField_DiaChi = new GridBagConstraints();
		gbc_textField_DiaChi.weighty = 1.0;
		gbc_textField_DiaChi.gridwidth = 2;
		gbc_textField_DiaChi.weightx = 1.0;
		gbc_textField_DiaChi.fill = GridBagConstraints.BOTH;
		gbc_textField_DiaChi.insets = new Insets(5, 12, 0, 10);
		gbc_textField_DiaChi.gridx = 1;
		gbc_textField_DiaChi.gridy = 0;
		panel_Title_DiaChi.add(textField_DiaChi, gbc_textField_DiaChi);

		comboBox_QuanHuyen = new JComboBox<Object>(Quan_Huyen);
		comboBox_QuanHuyen.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_comboBox_QuanHuyen = new GridBagConstraints();
		gbc_comboBox_QuanHuyen.weighty = 1.0;
		gbc_comboBox_QuanHuyen.weightx = 1.0;
		gbc_comboBox_QuanHuyen.fill = GridBagConstraints.BOTH;
		gbc_comboBox_QuanHuyen.insets = new Insets(0, 10, 0, 5);
		gbc_comboBox_QuanHuyen.gridwidth = 2;
		gbc_comboBox_QuanHuyen.gridx = 0;
		gbc_comboBox_QuanHuyen.gridy = 2;
		panel_Title_DiaChi.add(comboBox_QuanHuyen, gbc_comboBox_QuanHuyen);
		comboBox_TPHO = new JComboBox<Object>(ThanhPho);
		comboBox_TPHO.setBackground(new Color(255, 255, 255));
		comboBox_TPHO.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_comboBox_TPHO = new GridBagConstraints();
		gbc_comboBox_TPHO.insets = new Insets(0, 0, 0, 10);
		gbc_comboBox_TPHO.weighty = 1.0;
		gbc_comboBox_TPHO.weightx = 1.0;
		gbc_comboBox_TPHO.fill = GridBagConstraints.BOTH;
		gbc_comboBox_TPHO.gridx = 2;
		gbc_comboBox_TPHO.gridy = 2;
		panel_Title_DiaChi.add(comboBox_TPHO, gbc_comboBox_TPHO);

		comboBox_XaPhuong = new JComboBox<Object>(ChangeXaPhuong());
		comboBox_XaPhuong.setFont(new Font("Arial", Font.PLAIN, 18));
		GridBagConstraints gbc_comboBox_XaPhuong = new GridBagConstraints();
		gbc_comboBox_XaPhuong.fill = GridBagConstraints.BOTH;
		gbc_comboBox_XaPhuong.weightx = 1.0;
		gbc_comboBox_XaPhuong.weighty = 1.0;
		gbc_comboBox_XaPhuong.insets = new Insets(10, 11, 10, 10);
		gbc_comboBox_XaPhuong.gridwidth = 3;
		gbc_comboBox_XaPhuong.gridx = 0;
		gbc_comboBox_XaPhuong.gridy = 1;
		panel_Title_DiaChi.add(comboBox_XaPhuong, gbc_comboBox_XaPhuong);

		GridBagConstraints gbc_panel_Title_DiaChi = new GridBagConstraints();
		gbc_panel_Title_DiaChi.insets = new Insets(15, 0, 5, 0);
		gbc_panel_Title_DiaChi.fill = GridBagConstraints.BOTH;
		gbc_panel_Title_DiaChi.weightx = 1.0;
		gbc_panel_Title_DiaChi.weighty = 2.0;
		gbc_panel_Title_DiaChi.gridx = 0;
		gbc_panel_Title_DiaChi.gridy = 4;
		contentPane.add(panel_Title_DiaChi, gbc_panel_Title_DiaChi);

		panel_Button = new JPanel();
		GridBagConstraints gbc_panel_Button = new GridBagConstraints();
		gbc_panel_Button.insets = new Insets(10, 0, 10, 0);
		gbc_panel_Button.weighty = 1.0;
		gbc_panel_Button.weightx = 1.0;
		gbc_panel_Button.fill = GridBagConstraints.BOTH;
		gbc_panel_Button.gridx = 0;
		gbc_panel_Button.gridy = 5;
		contentPane.add(panel_Button, gbc_panel_Button);

		Button_XacNhan = new JButton("Xác Nhận");
		Button_XacNhan.setBackground(new Color(0, 128, 192));
		Button_XacNhan.setForeground(new Color(255, 255, 255));
		Button_XacNhan.setFont(new Font("Arial", Font.PLAIN, 18));
		Button_XacNhan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_Button.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panel_Button.add(Button_XacNhan);

		Button_HuyBo = new JButton("Hủy Bỏ");
		Button_HuyBo.setForeground(new Color(255, 255, 255));
		Button_HuyBo.setBackground(new Color(255, 0, 0));
		Button_HuyBo.setFont(new Font("Arial", Font.PLAIN, 18));
		panel_Button.add(Button_HuyBo);

		this.pack();
		this.setVisible(true);
		this.setResizable(true);
	}

	public String[] ChangeXaPhuong() {
		try {
			XaPhuong XaPhuong = new XaPhuong();
			String quan = (String) comboBox_QuanHuyen.getSelectedItem();
			String[] Xa_Phuong = XaPhuong.getxaPhuongMap().get(CuaHangView.chuyenThanhTenBien(quan));

			return Xa_Phuong;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	public void updateComBoBox_XaPhuong() {

		// Tạo lại comboBox_XaPhuong và cập nhật dữ liệu mới
		DefaultComboBoxModel<Object> model = new DefaultComboBoxModel<>(ChangeXaPhuong());
		comboBox_XaPhuong.setModel(model);

		// Yêu cầu panel_Title_DiaChi cập nhật lại giao diện
		panel_Title_DiaChi.revalidate();
		panel_Title_DiaChi.repaint(); // Có thể cần repaint() để hiển thị ngay lập tức
	}

}
