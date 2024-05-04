package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.text.DecimalFormat;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;


import model.Laptop;

public class XemChiTiet extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel jlabel_malaptop_1;
	private JLabel jlabel_tenlaptop1;
	private JLabel jlabel_cpu1;
	private JLabel jlabel_gpu1;
	private JLabel jlabel_ram1;
	private JLabel jlabel_rom1;
	private JLabel jlabel_HDH1;
	private JLabel jlabel_manhinh1;
	private JLabel jlabel_hang1;
	private JLabel jlabel_namsanxuat1;
	private JLabel jlabel_soluong1;
	private JLabel jlabel_gia1;
	private JLabel jlabel_MaNCC1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new XemChiTiet();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public XemChiTiet() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 650, 600);
		this.setLocationRelativeTo(null);
		this.setTitle("Chi tiết sản phẩm");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout());
		JPanel jpanel_center = new JPanel();
		jpanel_center.setLayout(new GridLayout(13,2));
		
		JLabel jlabel_malaptop = new JLabel("Mã laptop :");
		jlabel_malaptop.setForeground(new Color(0, 128, 192));
		jlabel_malaptop.setFont(new Font("Arial", Font.PLAIN, 18));
		jlabel_malaptop.setBounds(26, 78, 96, 30);
		//contentPane.add(jlabel_malaptop);
		
		
		jlabel_malaptop_1 = new JLabel("");
		jlabel_malaptop_1.setFont(new Font("Arial", Font.PLAIN, 18));
		jlabel_malaptop_1.setBounds(195, 78, 388, 30);
		//contentPane.add(jlabel_malaptop_1);
		
		
		
		JLabel jlabel_tenlaptop = new JLabel("Ten laptop :");
		jlabel_tenlaptop.setForeground(new Color(0, 128, 192));
		jlabel_tenlaptop.setFont(new Font("Arial", Font.PLAIN, 18));
		jlabel_tenlaptop.setBounds(26, 118, 96, 30);
		//contentPane.add(jlabel_tenlaptop);
		
		JLabel jlabel_CPU = new JLabel("CPU :");
		jlabel_CPU.setForeground(new Color(0, 128, 192));
		jlabel_CPU.setFont(new Font("Arial", Font.PLAIN, 18));
		jlabel_CPU.setBounds(26, 158, 96, 30);
		//contentPane.add(jlabel_CPU);
		
		JLabel jlabel_GPU = new JLabel("GPU :");
		jlabel_GPU.setForeground(new Color(0, 128, 192));
		jlabel_GPU.setFont(new Font("Arial", Font.PLAIN, 18));
		jlabel_GPU.setBounds(26, 198, 96, 30);
		//contentPane.add(jlabel_GPU);
		
		JLabel jlabel_ram = new JLabel("Ram  :");
		jlabel_ram.setForeground(new Color(0, 128, 192));
		jlabel_ram.setFont(new Font("Arial", Font.PLAIN, 18));
		jlabel_ram.setBounds(26, 238, 96, 30);
		//contentPane.add(jlabel_ram);
		
		JLabel jlabel_rom = new JLabel("Rom  :");
		jlabel_rom.setForeground(new Color(0, 128, 192));
		jlabel_rom.setFont(new Font("Arial", Font.PLAIN, 18));
		jlabel_rom.setBounds(26, 278, 96, 30);
		//contentPane.add(jlabel_rom);
		
		JLabel jlabel_HDH = new JLabel("Hệ điều hành :");
		jlabel_HDH.setForeground(new Color(0, 128, 192));
		jlabel_HDH.setFont(new Font("Arial", Font.PLAIN, 18));
		jlabel_HDH.setBounds(26, 318, 123, 30);
		//contentPane.add(jlabel_HDH);
		
		JLabel jlabel_manhinh = new JLabel("Màn hình :");
		jlabel_manhinh.setForeground(new Color(0, 128, 192));
		jlabel_manhinh.setFont(new Font("Arial", Font.PLAIN, 18));
		jlabel_manhinh.setBounds(26, 358, 96, 30);
		//contentPane.add(jlabel_manhinh);
		
		JLabel jlabel_hang = new JLabel("Hãng :");
		jlabel_hang.setForeground(new Color(0, 128, 192));
		jlabel_hang.setFont(new Font("Arial", Font.PLAIN, 18));
		jlabel_hang.setBounds(26, 398, 96, 30);
		//contentPane.add(jlabel_hang);
		
		JLabel jlabel_namsanxuat = new JLabel("Năm sản xuất :");
		jlabel_namsanxuat.setForeground(new Color(0, 128, 192));
		jlabel_namsanxuat.setFont(new Font("Arial", Font.PLAIN, 18));
		jlabel_namsanxuat.setBounds(26, 438, 123, 30);
		//contentPane.add(jlabel_namsanxuat);
		
		JLabel jlabel_soluong = new JLabel("Số lượng :");
		jlabel_soluong.setForeground(new Color(0, 128, 192));
		jlabel_soluong.setFont(new Font("Arial", Font.PLAIN, 18));
		jlabel_soluong.setBounds(26, 478, 96, 30);
		//contentPane.add(jlabel_soluong);
		
		JLabel jlabel_gia = new JLabel("Giá :");
		jlabel_gia.setForeground(new Color(0, 128, 192));
		jlabel_gia.setFont(new Font("Arial", Font.PLAIN, 18));
		jlabel_gia.setBounds(26, 518, 96, 30);
		//contentPane.add(jlabel_gia);
		
		
		
		jlabel_tenlaptop1 = new JLabel("");
		jlabel_tenlaptop1.setFont(new Font("Arial", Font.PLAIN, 18));
		jlabel_tenlaptop1.setBounds(195, 118, 388, 30);
		//contentPane.add(jlabel_tenlaptop1);
		
		jlabel_cpu1 = new JLabel("");
		jlabel_cpu1.setFont(new Font("Arial", Font.PLAIN, 18));
		jlabel_cpu1.setBounds(195, 158, 388, 30);
		//contentPane.add(jlabel_cpu1);
		
		jlabel_gpu1 = new JLabel("");
		jlabel_gpu1.setFont(new Font("Arial", Font.PLAIN, 18));
		jlabel_gpu1.setBounds(195, 198, 388, 30);
		//contentPane.add(jlabel_gpu1);
		
		jlabel_ram1 = new JLabel("");
		jlabel_ram1.setFont(new Font("Arial", Font.PLAIN, 18));
		jlabel_ram1.setBounds(195, 238, 388, 30);
		//contentPane.add(jlabel_ram1);
		
		jlabel_rom1 = new JLabel("");
		jlabel_rom1.setFont(new Font("Arial", Font.PLAIN, 18));
		jlabel_rom1.setBounds(195, 278, 388, 30);
		//contentPane.add(jlabel_rom1);
		
		jlabel_HDH1 = new JLabel("");
		jlabel_HDH1.setFont(new Font("Arial", Font.PLAIN, 18));
		jlabel_HDH1.setBounds(195, 318, 388, 30);
		//contentPane.add(jlabel_HDH1);
		
		jlabel_manhinh1 = new JLabel("");
		jlabel_manhinh1.setFont(new Font("Arial", Font.PLAIN, 18));
		jlabel_manhinh1.setBounds(195, 358, 388, 30);
		//contentPane.add(jlabel_manhinh1);
		
		jlabel_hang1 = new JLabel("");
		jlabel_hang1.setFont(new Font("Arial", Font.PLAIN, 18));
		jlabel_hang1.setBounds(195, 398, 388, 30);
		//contentPane.add(jlabel_hang1);
		
		jlabel_namsanxuat1 = new JLabel("");
		jlabel_namsanxuat1.setFont(new Font("Arial", Font.PLAIN, 18));
		jlabel_namsanxuat1.setBounds(195, 438, 388, 30);
		//contentPane.add(jlabel_namsanxuat1);
		
		jlabel_soluong1 = new JLabel("");
		jlabel_soluong1.setFont(new Font("Arial", Font.PLAIN, 18));
		jlabel_soluong1.setBounds(195, 478, 388, 30);
		//contentPane.add(jlabel_soluong1);
		
		jlabel_gia1 = new JLabel("");
		jlabel_gia1.setFont(new Font("Arial", Font.PLAIN, 18));
		jlabel_gia1.setBounds(195, 518, 388, 30);
		//contentPane.add(jlabel_gia1);
		
		jlabel_MaNCC1 = new JLabel("");
		jlabel_MaNCC1.setFont(new Font("Arial", Font.PLAIN, 18));
		jlabel_MaNCC1.setBounds(195, 557, 388, 30);
		//contentPane.add(jlabel_MaNCC);
		
		JLabel jlabel_MaNCC = new JLabel("Mã nhà cung cấp: ");
		jlabel_MaNCC.setForeground(new Color(0, 128, 192));
		jlabel_MaNCC.setFont(new Font("Arial", Font.PLAIN, 18));
		jlabel_MaNCC.setBounds(26, 557, 147, 30);
		//contentPane.add(jlabel_gia_1);
		
		
		jpanel_center.add(jlabel_malaptop);
		jpanel_center.add(jlabel_malaptop_1);
		jpanel_center.add(jlabel_tenlaptop);
		jpanel_center.add(jlabel_tenlaptop1);
		jpanel_center.add(jlabel_CPU);
		jpanel_center.add(jlabel_cpu1);
		jpanel_center.add(jlabel_GPU);
		jpanel_center.add(jlabel_gpu1);
		jpanel_center.add(jlabel_ram);
		jpanel_center.add(jlabel_ram1);
		jpanel_center.add(jlabel_rom);
		jpanel_center.add(jlabel_rom1);
		jpanel_center.add(jlabel_HDH);
		jpanel_center.add(jlabel_HDH1);
		jpanel_center.add(jlabel_manhinh);
		jpanel_center.add(jlabel_manhinh1);
		jpanel_center.add(jlabel_hang);
		jpanel_center.add(jlabel_hang1);
		jpanel_center.add(jlabel_namsanxuat);
		jpanel_center.add(jlabel_namsanxuat1);
		jpanel_center.add(jlabel_gia);
		jpanel_center.add(jlabel_gia1);
		jpanel_center.add(jlabel_soluong);
		jpanel_center.add(jlabel_soluong1);
		jpanel_center.add(jlabel_MaNCC);
		jpanel_center.add(jlabel_MaNCC1);
		contentPane.add(jpanel_center,BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 192));
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel jlabel_chitiet = new JLabel("Chi tiết sản phẩm");
		jlabel_chitiet.setHorizontalAlignment(SwingConstants.CENTER);
		jlabel_chitiet.setForeground(Color.WHITE);
		jlabel_chitiet.setFont(new Font("Arial", Font.BOLD, 26));
		jlabel_chitiet.setBackground(Color.WHITE);
		panel.add(jlabel_chitiet);
		
		this.setVisible(true);
		
	}
	
	public void setJLabel(Laptop  lt)
	{
		jlabel_malaptop_1.setText(lt.getMaLaptop());
		jlabel_tenlaptop1.setText(lt.getTenLaptop());
		jlabel_cpu1.setText(lt.getCPU());
		jlabel_gpu1.setText(lt.getGPU());
		jlabel_HDH1.setText(lt.getHeDieuHanh());
		jlabel_manhinh1.setText(lt.getManHinh());
		jlabel_ram1.setText(lt.getRam());
		jlabel_rom1.setText(lt.getRom());
		jlabel_namsanxuat1.setText(lt.getNamSanXuat()+"");
		jlabel_soluong1.setText(lt.getSoLuong()+"");
		DecimalFormat df = new DecimalFormat("#");
	    String gia = df.format(lt.getGia());
	    jlabel_gia1.setText(gia+" vnd");
	    jlabel_hang1.setText(lt.getHang());
	    jlabel_MaNCC1.setText(lt.getMaNhaCungCap());
	}
	
}