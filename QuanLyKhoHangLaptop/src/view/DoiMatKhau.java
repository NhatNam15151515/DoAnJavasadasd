package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SwingConstants;
import controller.DoiPassActionListener;


public class DoiMatKhau extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public JPasswordField passwordField_1;
	public JPasswordField passwordField_2;
	public JPasswordField passwordField_3;
	public JButton btnHuyBo;
	public JButton btnXacNhan;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DoiMatKhau frame = new DoiMatKhau();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public DoiMatKhau() {
		this.setTitle("Đổi mật khẩu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 483, 312);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{181, 181, 0};
		gbl_panel.rowHeights = new int[]{57, 57, 57, 0};
		gbl_panel.columnWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel jlabel_matkhau = new JLabel("Mật khẩu");
		jlabel_matkhau.setForeground(new Color(0, 128, 192));
		jlabel_matkhau.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_jlabel_matkhau = new GridBagConstraints();
		gbc_jlabel_matkhau.insets = new Insets(0, 0, 5, 5);
		gbc_jlabel_matkhau.gridx = 0;
		gbc_jlabel_matkhau.gridy = 0;
		panel.add(jlabel_matkhau, gbc_jlabel_matkhau);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_passwordField_1 = new GridBagConstraints();
		gbc_passwordField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField_1.insets = new Insets(0, 0, 5, 0);
		gbc_passwordField_1.gridx = 1;
		gbc_passwordField_1.gridy = 0;
		panel.add(passwordField_1, gbc_passwordField_1);
		
		JLabel jlabel_mk1 = new JLabel("Mật khẩu mới");
		jlabel_mk1.setForeground(new Color(0, 128, 192));
		jlabel_mk1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_jlabel_mk1 = new GridBagConstraints();
		gbc_jlabel_mk1.fill = GridBagConstraints.VERTICAL;
		gbc_jlabel_mk1.insets = new Insets(0, 0, 5, 5);
		gbc_jlabel_mk1.gridx = 0;
		gbc_jlabel_mk1.gridy = 1;
		panel.add(jlabel_mk1, gbc_jlabel_mk1);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_passwordField_2 = new GridBagConstraints();
		gbc_passwordField_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField_2.insets = new Insets(0, 0, 5, 0);
		gbc_passwordField_2.gridx = 1;
		gbc_passwordField_2.gridy = 1;
		panel.add(passwordField_2, gbc_passwordField_2);
		
		JLabel jlabel_mk2 = new JLabel("Mật khẩu mới");
		jlabel_mk2.setForeground(new Color(0, 128, 192));
		jlabel_mk2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_jlabel_mk2 = new GridBagConstraints();
		gbc_jlabel_mk2.insets = new Insets(0, 0, 0, 5);
		gbc_jlabel_mk2.gridx = 0;
		gbc_jlabel_mk2.gridy = 2;
		panel.add(jlabel_mk2, gbc_jlabel_mk2);
		
		passwordField_3 = new JPasswordField();
		passwordField_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		GridBagConstraints gbc_passwordField_3 = new GridBagConstraints();
		gbc_passwordField_3.fill = GridBagConstraints.HORIZONTAL;
		gbc_passwordField_3.gridx = 1;
		gbc_passwordField_3.gridy = 2;
		panel.add(passwordField_3, gbc_passwordField_3);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		btnXacNhan = new JButton("Xác nhận");
		btnXacNhan.setBackground(new Color(0, 128, 192));
		btnXacNhan.setForeground(new Color(0, 0, 0));
		btnXacNhan.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(btnXacNhan);
		
		btnHuyBo = new JButton("Hủy bỏ");
		btnHuyBo.setBackground(new Color(255, 0, 0));
		btnHuyBo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_1.add(btnHuyBo);
		
	}
	
	
}