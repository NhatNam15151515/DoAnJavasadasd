package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import dao.nhacungcapDao;
import model.NhaCungCap;

public class AddNhaCungCap extends JFrame {
	private static Nhacungcap ncc;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JLabel txt_themmoisanpham;
	private JTextField tx1;
	private JTextField tx2;
	private JTextField tx4;
	private JTextField tx5;
	private JTextField tx3;
	private JButton btn_them;
	private JButton btn_huy;
	private JButton btn_sua;
	private JLabel lblNewLabel;

//	public AddNhaCungCap(NhaCungCap tmp) {
//	}
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddNhaCungCap frame = new AddNhaCungCap(ncc);
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
	public AddNhaCungCap(Nhacungcap nhatm) {
		this.ncc = nhatm;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(250, 150, 580, 326);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		getContentPane().setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setBackground(new Color(255, 255, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txt_themmoisanpham = new JLabel();
		txt_themmoisanpham.setHorizontalAlignment(SwingConstants.CENTER);

		txt_themmoisanpham.setText("Thêm sản phẩm mới");
		txt_themmoisanpham.setBackground(new Color(0, 128, 192));
		txt_themmoisanpham.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txt_themmoisanpham.setBounds(0, 0, 566, 48);
		txt_themmoisanpham.setOpaque(true);
		contentPane.add(txt_themmoisanpham);

		JLabel txt_mncc = new JLabel("Mã nhà cung cấp");
		txt_mncc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txt_mncc.setBounds(44, 61, 152, 30);
		contentPane.add(txt_mncc);

		tx1 = new JTextField();
		tx1.setBounds(44, 86, 212, 36);
		contentPane.add(tx1);
		tx1.setColumns(10);
		JLabel tx_tencc = new JLabel("Tên nhà cung cấp");
		tx_tencc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tx_tencc.setBounds(44, 138, 195, 30);
		contentPane.add(tx_tencc);

		tx2 = new JTextField();
		tx2.setColumns(10);
		tx2.setBounds(44, 163, 212, 36);
		contentPane.add(tx2);

		JLabel txtdc = new JLabel("Địa chỉ");
		txtdc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtdc.setBounds(338, 58, 98, 30);
		contentPane.add(txtdc);

		tx4 = new JTextField();
		tx4.setColumns(10);
		tx4.setBounds(338, 83, 212, 36);
		contentPane.add(tx4);

		JLabel txtsdt = new JLabel("Số điện thoại");
		txtsdt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtsdt.setBounds(338, 135, 126, 30);
		contentPane.add(txtsdt);

		tx5 = new JTextField();
		tx5.setColumns(10);
		tx5.setBounds(338, 163, 212, 36);
		contentPane.add(tx5);

		JLabel txtem = new JLabel("Email");
		txtem.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtem.setBounds(44, 219, 98, 30);
		contentPane.add(txtem);

		tx3 = new JTextField();
		tx3.setColumns(10);
		tx3.setBounds(44, 244, 212, 36);
		contentPane.add(tx3);

		btn_them = new JButton("Thêm");
		btn_them.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tx1.getText().length() <= 0 || tx2.getText() == "" || tx3.getText() == "" || tx4.getText() == ""
						|| tx5.getText() == "") {
					JOptionPane.showConfirmDialog(null, " Dữ liệu bạn nhập vào đang bị thiếu. Mời bạn nhập lại", "hi",
							JOptionPane.CLOSED_OPTION);
				} else {
					String mnc = tx1.getText();
					String tnc = tx2.getText();
					String email = tx3.getText();
					String dc = tx4.getText();
					String sdt = tx5.getText();
					NhaCungCap sp = new NhaCungCap(mnc, tnc, dc, sdt, email);
					System.out.println(sp.toString());
					nhacungcapDao.getInstance().insert(sp);
					JOptionPane.showMessageDialog(null, "Thêm sản phẩm thành công");
//							setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					int i = ncc.model.getRowCount();
					ncc.model.addRow(new Object[] { sp.getMaNhaCungCap(), sp.getTenNhaCungCap(), sp.getDiaChi(),
							sp.getSDT(), sp.getEmail() });
					ncc.table.setModel(ncc.model);
					JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(btn_them);
					currentFrame.dispose();
				}
			}
		});

		btn_them.setBackground(new Color(0, 255, 0));
		btn_them.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_them.setBounds(302, 239, 118, 36);
		contentPane.add(btn_them);
		btn_huy = new JButton("Hủy");
		btn_huy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
//			 		setVisible(false);
				JFrame currentFrame = (JFrame) SwingUtilities.getWindowAncestor(btn_huy);
				currentFrame.dispose();
			}
		});
		btn_huy.setForeground(new Color(64, 0, 64));
		btn_huy.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_huy.setBounds(432, 239, 118, 36);
		btn_huy.setBackground(Color.RED);
		contentPane.add(btn_huy);

		btn_sua = new JButton("SỬA");
		btn_sua.setBackground(new Color(0, 255, 0));
		btn_sua.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_sua.setBounds(302, 239, 118, 36);
		contentPane.add(btn_sua);

	}

}
