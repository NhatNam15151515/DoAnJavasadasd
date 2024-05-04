package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIManager;

import controller.LoginActionlistener;
import img.Source;

public class login extends JFrame {
	LoginActionlistener ac = new LoginActionlistener(this);
	private static final long serialVersionUID = 1L;
	public JTextField textField_username;
	public JPasswordField passwordField;
	public Source source = new Source();
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new login();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public login() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(650, 450);
		this.setLocationRelativeTo(null);
		this.setTitle("Login");
		getContentPane().setLayout(new GridLayout(1, 2));
		
		JPanel jpanel_img = new JPanel();
		jpanel_img.setBackground(new Color(0, 128, 192));
		getContentPane().add(jpanel_img);
		
		JPanel jpanel_login = new JPanel();
		jpanel_login.setForeground(new Color(64, 128, 128));
		jpanel_login.setBackground(new Color(255, 255, 255));
		getContentPane().add(jpanel_login);
		jpanel_login.setLayout(null);

		JLabel jtextFiled_username = new JLabel("UserName");
		jtextFiled_username.setForeground(new Color(0, 0, 0));
		jtextFiled_username.setFont(new Font("Arial", Font.BOLD, 20));
		jtextFiled_username.setBounds(21, 93, 119, 24);
		jpanel_login.add(jtextFiled_username);

		JLabel jtextFiled_username_1 = new JLabel("PassWord");
		jtextFiled_username_1.setForeground(new Color(0, 0, 0));
		jtextFiled_username_1.setFont(new Font("Arial", Font.BOLD, 20));
		jtextFiled_username_1.setBounds(21, 183, 119, 24);
		jpanel_login.add(jtextFiled_username_1);

		jpanel_img.setLayout(null);
		JLabel jLabel_img = new JLabel(source.icon_dangnhap);
		jLabel_img.setBounds(84, 230, 128, 128);
		jpanel_img.add(jLabel_img);

		JLabel jLabel_user = new JLabel(source.icon_user);
		jLabel_user.setBounds(84, 102, 128, 128);
		jpanel_img.add(jLabel_user);

		textField_username = new JTextField();
		textField_username.setBackground(new Color(255, 255, 255));
		textField_username.setForeground(new Color(0, 0, 0));
		textField_username.setFont(new Font("Arial", Font.PLAIN, 14));
		textField_username.setBounds(21, 130, 264, 33);
		textField_username.setOpaque(true);
		jpanel_login.add(textField_username);
		textField_username.setColumns(10);

		JLabel jLabel = new JLabel("Quên mật khẩu ?");
		jLabel.setForeground(new Color(0, 0, 0));
		jLabel.setFont(new Font("Arial", Font.BOLD, 16));
		jLabel.setBounds(86, 352, 134, 24);
		jpanel_login.add(jLabel);

		JButton btnLogin = new JButton("Đăng nhập");
		btnLogin.addActionListener(ac);
		btnLogin.setForeground(new Color(0, 0, 0));
		btnLogin.setFont(new Font("Arial", Font.PLAIN, 20));
		btnLogin.setBounds(21, 287, 264, 41);
		jpanel_login.add(btnLogin);
		btnLogin.setBackground(new Color(0, 128, 192));
		
		passwordField = new JPasswordField();
		passwordField.setBounds(21, 217, 264, 36);
		jpanel_login.add(passwordField);

		this.setVisible(true);
		this.setResizable(false);
	}
	
	
	   
	
}
