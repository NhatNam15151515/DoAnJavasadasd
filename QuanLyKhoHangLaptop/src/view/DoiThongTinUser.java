package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import controller.ThongTinMouseListener;
import img.Source;
import model.NguoiDung;
import model.NhanVien;

public class DoiThongTinUser extends JPanel {

	private Source source = new Source();
	private JLabel manv1;
	private JLabel tennv1;
	private JLabel ngaysinh1;
	private JLabel gioitinh1;
	private JLabel sdt1;
	private JLabel mand1;
	private JLabel tentaikhoan1;
	public JLabel jlabel_sua;
	public JPanel panel_chinh;
	public JPanel panel_center;
	public JLabel jlabel_doithongtin;
	private static final long serialVersionUID = 1L;
	public DoiThongTinUser() {
		setLayout(new BorderLayout(0, 0));
		this.setBounds(0, 0, 1189, 763);
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(1,3));
	
		JPanel panel_border_chucNang = new JPanel();
		panel_border_chucNang.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Chức năng",
				TitledBorder.LEFT, TitledBorder.ABOVE_TOP, new Font("Arial", Font.ITALIC, 14), new Color(0, 0, 0)));
		panel_border_chucNang.setLayout(new GridLayout(1,2));
		JPanel panel_1 = new JPanel();
		panel.add(panel_border_chucNang);
		panel.add(panel_1);
		
		jlabel_doithongtin = new JLabel("Đổi thông tin",source.icon_change, JLabel.CENTER);
		jlabel_doithongtin.setFont(new Font("Arial", Font.PLAIN, 12));
		jlabel_doithongtin.setVerticalTextPosition(JLabel.BOTTOM);
		jlabel_doithongtin.setHorizontalTextPosition(JLabel.CENTER);
		
		
		panel_border_chucNang.add(jlabel_doithongtin);
		jlabel_sua = new JLabel("Đổi mật khẩu", source.icon_pencil, JLabel.CENTER);
		jlabel_sua.setFont(new Font("Arial", Font.PLAIN, 12));
		jlabel_sua.setVerticalTextPosition(JLabel.BOTTOM);
		jlabel_sua.setHorizontalTextPosition(JLabel.CENTER);
		panel_border_chucNang.add(jlabel_sua);
		JPanel panel_tmp = new JPanel();
		panel.add(panel_tmp);
		
		panel_center = new JPanel();
		add(panel_center, BorderLayout.CENTER);
		GridBagLayout gbl_panel_center = new GridBagLayout();
		gbl_panel_center.columnWidths = new int[]{237, 237, 237, 237, 237, 0};
		gbl_panel_center.rowHeights = new int[]{686, 0};
		gbl_panel_center.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_center.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_center.setLayout(gbl_panel_center);
		JPanel panel_tmp1 = new JPanel();
		GridBagConstraints gbc_panel_tmp1 = new GridBagConstraints();
		gbc_panel_tmp1.fill = GridBagConstraints.BOTH;
		gbc_panel_tmp1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_tmp1.gridx = 0;
		gbc_panel_tmp1.gridy = 0;
		panel_center.add(panel_tmp1, gbc_panel_tmp1);
		panel_chinh = new JPanel();
		GridBagConstraints gbc_panel_chinh = new GridBagConstraints();
		gbc_panel_chinh.fill = GridBagConstraints.BOTH;
		gbc_panel_chinh.insets = new Insets(0, 0, 0, 5);
		gbc_panel_chinh.gridx = 1;
		gbc_panel_chinh.gridy = 0;
		gbc_panel_chinh.gridwidth = 3;
		panel_center.add(panel_chinh, gbc_panel_chinh);
		panel_chinh.setLayout(new GridLayout(7,2));
		
		JLabel jlabel_MaNV = new JLabel("Mã nhân viên:");
		jlabel_MaNV.setForeground(new Color(0, 128, 192));
		jlabel_MaNV.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_chinh.add(jlabel_MaNV);
		
		manv1 = new JLabel("");
		manv1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_chinh.add(manv1);
		
		JLabel jlabel_TenNhanVien = new JLabel("Tên nhân viên:");
		jlabel_TenNhanVien.setForeground(new Color(0, 128, 192));
		jlabel_TenNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_chinh.add(jlabel_TenNhanVien);
		
		tennv1 = new JLabel("");
		tennv1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_chinh.add(tennv1);
		
		JLabel jlabel_NgaySinh = new JLabel("Ngày sinh:");
		jlabel_NgaySinh.setForeground(new Color(0, 128, 192));
		jlabel_NgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_chinh.add(jlabel_NgaySinh);
		
		ngaysinh1 = new JLabel("");
		ngaysinh1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_chinh.add(ngaysinh1);
		
		JLabel jlabel_GioiTinh = new JLabel("Giới tính:");
		jlabel_GioiTinh.setForeground(new Color(0, 128, 192));
		jlabel_GioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_chinh.add(jlabel_GioiTinh);
		
		gioitinh1 = new JLabel("");
		gioitinh1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_chinh.add(gioitinh1);
		
		JLabel jlable_SDT = new JLabel("Số điện thoại:");
		jlable_SDT.setForeground(new Color(0, 128, 192));
		jlable_SDT.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_chinh.add(jlable_SDT);
		
		sdt1 = new JLabel("");
		sdt1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_chinh.add(sdt1);
		
		JLabel jlabel_MaND = new JLabel("Mã người dùng:");
		jlabel_MaND.setForeground(new Color(0, 128, 192));
		jlabel_MaND.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_chinh.add(jlabel_MaND);
		
		mand1 = new JLabel("");
		mand1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_chinh.add(mand1);
		
		JLabel jlabel_tk = new JLabel("Tên tài khoản");
		jlabel_tk.setForeground(new Color(0, 128, 192));
		jlabel_tk.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_chinh.add(jlabel_tk);
		
		tentaikhoan1 = new JLabel("");
		tentaikhoan1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_chinh.add(tentaikhoan1);
		JPanel panel_tmp2 = new JPanel();
		GridBagConstraints gbc_panel_tmp2 = new GridBagConstraints();
		gbc_panel_tmp2.fill = GridBagConstraints.BOTH;
		gbc_panel_tmp2.gridx = 4;
		gbc_panel_tmp2.gridy = 0;
		panel_center.add(panel_tmp2, gbc_panel_tmp2);
		panel_tmp2.setLayout(new GridLayout(1, 0, 0, 0));
		
		
		ThongTinMouseListener mouse = new ThongTinMouseListener(this);
		jlabel_sua.addMouseListener(mouse);
		jlabel_doithongtin.addMouseListener(mouse);
	}
	
	public void setJlabel(NhanVien nv, NguoiDung nd)
	{
		manv1.setText(nv.getMaNhanVien());
		tennv1.setText((nv.getTenNhanVien()));
		ngaysinh1.setText(nv.getNgaySinh()+"");
		if(nv.getGioiTinh()==1)
		{
			gioitinh1.setText("Nam");
		}
		else
		{
			gioitinh1.setText("Nữ");
		}
		sdt1.setText(nv.getSDT());
		mand1.setText(nv.getMaNguoiDung());
		tentaikhoan1.setText(nd.getTaiKhoan());
	}
	
	public void setJPanelCenter()
	{
		panel_center = new JPanel();
		add(panel_center, BorderLayout.CENTER);
		GridBagLayout gbl_panel_center = new GridBagLayout();
		gbl_panel_center.columnWidths = new int[]{237, 237, 237, 237, 237, 0};
		gbl_panel_center.rowHeights = new int[]{686, 0};
		gbl_panel_center.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_center.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_center.setLayout(gbl_panel_center);
		JPanel panel_tmp1 = new JPanel();
		GridBagConstraints gbc_panel_tmp1 = new GridBagConstraints();
		gbc_panel_tmp1.fill = GridBagConstraints.BOTH;
		gbc_panel_tmp1.insets = new Insets(0, 0, 0, 5);
		gbc_panel_tmp1.gridx = 0;
		gbc_panel_tmp1.gridy = 0;
		panel_center.add(panel_tmp1, gbc_panel_tmp1);
		panel_chinh = new JPanel();
		GridBagConstraints gbc_panel_chinh = new GridBagConstraints();
		gbc_panel_chinh.fill = GridBagConstraints.BOTH;
		gbc_panel_chinh.insets = new Insets(0, 0, 0, 5);
		gbc_panel_chinh.gridx = 1;
		gbc_panel_chinh.gridy = 0;
		gbc_panel_chinh.gridwidth = 3;
		panel_center.add(panel_chinh, gbc_panel_chinh);
		panel_chinh.setLayout(new GridLayout(7,2));
		
		JLabel jlabel_MaNV = new JLabel("Mã nhân viên:");
		jlabel_MaNV.setForeground(new Color(0, 128, 192));
		jlabel_MaNV.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_chinh.add(jlabel_MaNV);
		
		manv1 = new JLabel("");
		manv1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_chinh.add(manv1);
		
		JLabel jlabel_TenNhanVien = new JLabel("Tên nhân viên:");
		jlabel_TenNhanVien.setForeground(new Color(0, 128, 192));
		jlabel_TenNhanVien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_chinh.add(jlabel_TenNhanVien);
		
		tennv1 = new JLabel("");
		tennv1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_chinh.add(tennv1);
		
		JLabel jlabel_NgaySinh = new JLabel("Ngày sinh:");
		jlabel_NgaySinh.setForeground(new Color(0, 128, 192));
		jlabel_NgaySinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_chinh.add(jlabel_NgaySinh);
		
		ngaysinh1 = new JLabel("");
		ngaysinh1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_chinh.add(ngaysinh1);
		
		JLabel jlabel_GioiTinh = new JLabel("Giới tính:");
		jlabel_GioiTinh.setForeground(new Color(0, 128, 192));
		jlabel_GioiTinh.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_chinh.add(jlabel_GioiTinh);
		
		gioitinh1 = new JLabel("");
		gioitinh1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_chinh.add(gioitinh1);
		
		JLabel jlable_SDT = new JLabel("Số điện thoại:");
		jlable_SDT.setForeground(new Color(0, 128, 192));
		jlable_SDT.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_chinh.add(jlable_SDT);
		
		sdt1 = new JLabel("");
		sdt1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_chinh.add(sdt1);
		
		JLabel jlabel_MaND = new JLabel("Mã người dùng:");
		jlabel_MaND.setForeground(new Color(0, 128, 192));
		jlabel_MaND.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_chinh.add(jlabel_MaND);
		
		mand1 = new JLabel("");
		mand1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_chinh.add(mand1);
		
		JLabel jlabel_tk = new JLabel("Tên tài khoản");
		jlabel_tk.setForeground(new Color(0, 128, 192));
		jlabel_tk.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_chinh.add(jlabel_tk);
		
		tentaikhoan1 = new JLabel("");
		tentaikhoan1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		panel_chinh.add(tentaikhoan1);
		JPanel panel_tmp2 = new JPanel();
		GridBagConstraints gbc_panel_tmp2 = new GridBagConstraints();
		gbc_panel_tmp2.fill = GridBagConstraints.BOTH;
		gbc_panel_tmp2.gridx = 4;
		gbc_panel_tmp2.gridy = 0;
		panel_center.add(panel_tmp2, gbc_panel_tmp2);
		panel_tmp2.setLayout(new GridLayout(1, 0, 0, 0));
		
		ThongTinMouseListener mouse = new ThongTinMouseListener(this);
		jlabel_sua.addMouseListener(mouse);
		
	}
}