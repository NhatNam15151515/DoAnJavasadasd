package view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class XemChiTietCuaHang extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public JLabel Label_ChiTietCH_MaCH_Content;
	public JLabel Label_ChiTietCH_TenCH_Content;
	public JLabel Label_ChiTietCH_DiaChi_Content;
	public JLabel Label_ChiTietCH_SDT_Content;

	public XemChiTietCuaHang() {
		getContentPane().setEnabled(false);
		getContentPane().setLayout(new GridLayout(5, 1, 0, 0));
		JPanel panel_ChiTietCH_Title = new JPanel();
		getContentPane().add(panel_ChiTietCH_Title);
		FlowLayout fl_panel_ChiTietCH_Title = new FlowLayout(FlowLayout.CENTER, 5, 5);
		panel_ChiTietCH_Title.setLayout(fl_panel_ChiTietCH_Title);

		JLabel Label_ChiTietCH_Title = new JLabel("Chi Tiết Cửa Hàng");
		Label_ChiTietCH_Title.setForeground(new Color(0, 128, 255));
		Label_ChiTietCH_Title.setFont(new Font("Arial", Font.BOLD, 20));
		Label_ChiTietCH_Title.setHorizontalAlignment(SwingConstants.CENTER);
		panel_ChiTietCH_Title.add(Label_ChiTietCH_Title);
		JPanel panel_ChiTietCH_MaCH = new JPanel();
		getContentPane().add(panel_ChiTietCH_MaCH);

		GridBagLayout gbl_panel_ChiTietCH_MaCH = new GridBagLayout();
		gbl_panel_ChiTietCH_MaCH.columnWidths = new int[] { 152, 152, 0 };
		gbl_panel_ChiTietCH_MaCH.rowHeights = new int[] { 52, 0 };
		gbl_panel_ChiTietCH_MaCH.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_ChiTietCH_MaCH.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_ChiTietCH_MaCH.setLayout(gbl_panel_ChiTietCH_MaCH);

		JLabel Label_ChiTietCH_MaCH_Title = new JLabel("Mã Cửa Hàng:");
		Label_ChiTietCH_MaCH_Title.setForeground(new Color(0, 128, 255));
		Label_ChiTietCH_MaCH_Title.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_Label_ChiTietCH_MaCH_Title = new GridBagConstraints();
		gbc_Label_ChiTietCH_MaCH_Title.gridheight = 0;
		gbc_Label_ChiTietCH_MaCH_Title.fill = GridBagConstraints.BOTH;
		gbc_Label_ChiTietCH_MaCH_Title.insets = new Insets(0, 10, 0, 0);
		gbc_Label_ChiTietCH_MaCH_Title.gridx = 0;
		gbc_Label_ChiTietCH_MaCH_Title.gridy = 0;
		panel_ChiTietCH_MaCH.add(Label_ChiTietCH_MaCH_Title, gbc_Label_ChiTietCH_MaCH_Title);

		Label_ChiTietCH_MaCH_Content = new JLabel();
		Label_ChiTietCH_MaCH_Content.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_Label_ChiTietCH_MaCH_Content = new GridBagConstraints();
		gbc_Label_ChiTietCH_MaCH_Content.gridwidth = 0;
		gbc_Label_ChiTietCH_MaCH_Content.gridheight = 0;
		gbc_Label_ChiTietCH_MaCH_Content.insets = new Insets(0, 0, 0, 10);
		gbc_Label_ChiTietCH_MaCH_Content.fill = GridBagConstraints.BOTH;
		gbc_Label_ChiTietCH_MaCH_Content.gridx = 1;
		gbc_Label_ChiTietCH_MaCH_Content.gridy = 0;
		panel_ChiTietCH_MaCH.add(Label_ChiTietCH_MaCH_Content, gbc_Label_ChiTietCH_MaCH_Content);

		JPanel panel_ChiTietCH_TenCH = new JPanel();
		getContentPane().add(panel_ChiTietCH_TenCH);
		GridBagLayout gbl_panel_ChiTietCH_TenCH = new GridBagLayout();
		gbl_panel_ChiTietCH_TenCH.columnWidths = new int[] { 152, 152, 0 };
		gbl_panel_ChiTietCH_TenCH.rowHeights = new int[] { 52, 0 };
		gbl_panel_ChiTietCH_TenCH.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_ChiTietCH_TenCH.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_ChiTietCH_TenCH.setLayout(gbl_panel_ChiTietCH_TenCH);

		JLabel Label_ChiTietCH_TenCH_Title = new JLabel("Tên Cửa Hàng:");
		Label_ChiTietCH_TenCH_Title.setForeground(new Color(0, 128, 255));
		Label_ChiTietCH_TenCH_Title.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_Label_ChiTietCH_TenCH_Title = new GridBagConstraints();
		gbc_Label_ChiTietCH_TenCH_Title.gridheight = 0;
		gbc_Label_ChiTietCH_TenCH_Title.fill = GridBagConstraints.BOTH;
		gbc_Label_ChiTietCH_TenCH_Title.insets = new Insets(0, 10, 0, 0);
		gbc_Label_ChiTietCH_TenCH_Title.gridx = 0;
		gbc_Label_ChiTietCH_TenCH_Title.gridy = 0;
		panel_ChiTietCH_TenCH.add(Label_ChiTietCH_TenCH_Title, gbc_Label_ChiTietCH_TenCH_Title);

		Label_ChiTietCH_TenCH_Content = new JLabel();
		Label_ChiTietCH_TenCH_Content.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_Label_ChiTietCH_TenCH_Content = new GridBagConstraints();
		gbc_Label_ChiTietCH_TenCH_Content.gridwidth = 0;
		gbc_Label_ChiTietCH_TenCH_Content.gridheight = 0;
		gbc_Label_ChiTietCH_TenCH_Content.insets = new Insets(0, 0, 0, 10);
		gbc_Label_ChiTietCH_TenCH_Content.fill = GridBagConstraints.BOTH;
		gbc_Label_ChiTietCH_TenCH_Content.gridx = 1;
		gbc_Label_ChiTietCH_TenCH_Content.gridy = 0;
		panel_ChiTietCH_TenCH.add(Label_ChiTietCH_TenCH_Content, gbc_Label_ChiTietCH_TenCH_Content);

		JPanel panel_ChiTietCH_DiaChi = new JPanel();
		getContentPane().add(panel_ChiTietCH_DiaChi);
		GridBagLayout gbl_panel_ChiTietCH_DiaChi = new GridBagLayout();
		gbl_panel_ChiTietCH_DiaChi.columnWidths = new int[] { 152, 152, 0 };
		gbl_panel_ChiTietCH_DiaChi.rowHeights = new int[] { 52, 0 };
		gbl_panel_ChiTietCH_DiaChi.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_ChiTietCH_DiaChi.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_ChiTietCH_DiaChi.setLayout(gbl_panel_ChiTietCH_DiaChi);

		JLabel Label_ChiTietCH_DiaChi_Title = new JLabel("Địa Chỉ:");
		Label_ChiTietCH_DiaChi_Title.setForeground(new Color(0, 128, 255));
		Label_ChiTietCH_DiaChi_Title.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_Label_ChiTietCH_DiaChi_Title = new GridBagConstraints();
		gbc_Label_ChiTietCH_DiaChi_Title.gridheight = 0;
		gbc_Label_ChiTietCH_DiaChi_Title.fill = GridBagConstraints.BOTH;
		gbc_Label_ChiTietCH_DiaChi_Title.insets = new Insets(0, 10, 0, 0);
		gbc_Label_ChiTietCH_DiaChi_Title.gridx = 0;
		gbc_Label_ChiTietCH_DiaChi_Title.gridy = 0;
		panel_ChiTietCH_DiaChi.add(Label_ChiTietCH_DiaChi_Title, gbc_Label_ChiTietCH_DiaChi_Title);

		Label_ChiTietCH_DiaChi_Content = new JLabel();
		Label_ChiTietCH_DiaChi_Content.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_Label_ChiTietCH_DiaChi_Content = new GridBagConstraints();
		gbc_Label_ChiTietCH_DiaChi_Content.gridwidth = 0;
		gbc_Label_ChiTietCH_DiaChi_Content.gridheight = 0;
		gbc_Label_ChiTietCH_DiaChi_Content.insets = new Insets(0, 0, 0, 10);
		gbc_Label_ChiTietCH_DiaChi_Content.fill = GridBagConstraints.BOTH;
		gbc_Label_ChiTietCH_DiaChi_Content.gridx = 1;
		gbc_Label_ChiTietCH_DiaChi_Content.gridy = 0;
		panel_ChiTietCH_DiaChi.add(Label_ChiTietCH_DiaChi_Content, gbc_Label_ChiTietCH_DiaChi_Content);

		JPanel panel_ChiTietCH_SDT = new JPanel();
		getContentPane().add(panel_ChiTietCH_SDT);
		GridBagLayout gbl_panel_ChiTietCH_SDT = new GridBagLayout();
		gbl_panel_ChiTietCH_SDT.columnWidths = new int[] { 152, 152, 0 };
		gbl_panel_ChiTietCH_SDT.rowHeights = new int[] { 52, 0 };
		gbl_panel_ChiTietCH_SDT.columnWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_ChiTietCH_SDT.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		panel_ChiTietCH_SDT.setLayout(gbl_panel_ChiTietCH_SDT);

		JLabel Label_ChiTietCH_SDT_Title = new JLabel("Số Điện Thoại:");
		Label_ChiTietCH_SDT_Title.setHorizontalAlignment(SwingConstants.LEFT);
		Label_ChiTietCH_SDT_Title.setForeground(new Color(0, 128, 255));
		Label_ChiTietCH_SDT_Title.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_Label_ChiTietCH_SDT_Title = new GridBagConstraints();
		gbc_Label_ChiTietCH_SDT_Title.gridheight = 0;
		gbc_Label_ChiTietCH_SDT_Title.fill = GridBagConstraints.BOTH;
		gbc_Label_ChiTietCH_SDT_Title.insets = new Insets(0, 10, 0, 0);
		gbc_Label_ChiTietCH_SDT_Title.gridx = 0;
		gbc_Label_ChiTietCH_SDT_Title.gridy = 0;
		panel_ChiTietCH_SDT.add(Label_ChiTietCH_SDT_Title, gbc_Label_ChiTietCH_SDT_Title);

		Label_ChiTietCH_SDT_Content = new JLabel();
		Label_ChiTietCH_SDT_Content.setFont(new Font("Arial", Font.BOLD, 16));
		GridBagConstraints gbc_Label_ChiTietCH_SDT_Content = new GridBagConstraints();
		gbc_Label_ChiTietCH_SDT_Content.gridwidth = 0;
		gbc_Label_ChiTietCH_SDT_Content.gridheight = 0;
		gbc_Label_ChiTietCH_SDT_Content.insets = new Insets(0, 0, 0, 10);
		gbc_Label_ChiTietCH_SDT_Content.fill = GridBagConstraints.BOTH;
		gbc_Label_ChiTietCH_SDT_Content.gridx = 1;
		gbc_Label_ChiTietCH_SDT_Content.gridy = 0;
		panel_ChiTietCH_SDT.add(Label_ChiTietCH_SDT_Content, gbc_Label_ChiTietCH_SDT_Content);

		// Thêm 4 JPanel vào JFrame, mỗi hàng chứa một JPanel

		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setVisible(true);
	}
	public void load() {
		this.pack();
		this.setLocationRelativeTo(null);
	}

}