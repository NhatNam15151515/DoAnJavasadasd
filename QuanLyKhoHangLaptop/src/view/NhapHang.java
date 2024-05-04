package view;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.sql.Date;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.Controllernhaphang;
import dao.LaptopDAO;
import dao.PhieuNhapDao;
import model.ChiTietPhieuNhap;
import model.Laptop;
import model.PhieuNhap;

public class NhapHang extends JFrame {
	ArrayList<Laptop> sanpham=LaptopDAO.getintance().selectAll();
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel_menu;
	public JTable table;
	private DefaultTableModel model;
	public JTable table1;
	private DefaultTableModel model1;
	private JPanel panel_menu1;
	private JPanel panel_trenn;
	private JPanel panel_duoii;
	private JTextField jl_mapn;
	private JTextField jt_ngaynhap;
	private JTextField jt_masanpham;
	private JTextField jt_tensanpham;
	private JTextField jtmanhanvien;
	public JTextField jt_soluong;
	private JTextField jt_thanhtien;
	public JTextField jt_otimkiem;
	private int stt=0,stt1=0;
	private double tongtien=0;
	public JPanel panel_nhaphang;
	public JButton btn_themsp;
	public JButton btn_suasp;
	public JButton btn_xoasp;
	private JLabel kqtongtiennn;
	private JButton btn_nhapexcel;
	public JButton btn_nhaphang;
	private JTextField jt_manhacc;
	private LocalDate ngay = LocalDate.now();
	private Date date = Date.valueOf(ngay);
	public JButton btn_quaylai;
	public JButton btn_timkiem;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NhapHang frame = new NhapHang();
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
	public NhapHang() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 1400, 800);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));
        
		 panel_menu= new JPanel();
		panel_menu.setBackground(new Color(0, 128, 192));
		 contentPane.add(panel_menu, BorderLayout.WEST);
		 panel_menu.setForeground(new Color(255, 255, 255));
	panel_menu.setBounds(0, 0, 197, 763);
//		panel_cungcap.setBackground(new Color(192, 192, 192));
//		getContentPane().add(panel_cungcap);
		panel_menu.setLayout(new GridLayout(13, 1, 0, 0));
//		scrollPane.setBounds(0, 0, 1189, 602);

		
		JLabel lblNewLabel = new JLabel("Hi !");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		panel_menu.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Admin");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		panel_menu.add(lblNewLabel_1);
		
		JLabel jlabel_sanpham = new JLabel("Sản phẩm");
		jlabel_sanpham.setFont(new Font("Arial", Font.PLAIN, 20));
		jlabel_sanpham.setForeground(new Color(255, 255, 255));
		ImageIcon icon_sanpham = new ImageIcon("D:\\LAMDOAN\\DoAn\\src\\img\\product.png");
		jlabel_sanpham.setIcon(icon_sanpham);
		panel_menu.add(jlabel_sanpham);
		
		
		
		
		JLabel jlabel_nhacungcap = new JLabel("Nhà cung cấp");
		jlabel_nhacungcap.setForeground(Color.WHITE);
		jlabel_nhacungcap.setFont(new Font("Arial", Font.PLAIN, 20));
		ImageIcon icon_nhaCungCap = new ImageIcon("D:\\LAMDOAN\\DoAn\\src\\img\\loadicon.png");
		jlabel_nhacungcap.setIcon(icon_nhaCungCap);
		panel_menu.add(jlabel_nhacungcap);
		
		
		JLabel jlabel_nhaphang = new JLabel("Nhập hàng");
		jlabel_nhaphang.setForeground(Color.WHITE);
		jlabel_nhaphang.setFont(new Font("Arial", Font.PLAIN, 20));
		ImageIcon icon_nhaphang = new ImageIcon("D:\\LAMDOAN\\DoAn\\src\\img\\supplier.png");
		jlabel_nhaphang.setIcon(icon_nhaphang);
		panel_menu.add(jlabel_nhaphang);
		
		
		JLabel jlabel_phieunhap = new JLabel("Phiếu nhập");
		jlabel_phieunhap.setForeground(Color.WHITE);
		jlabel_phieunhap.setFont(new Font("Arial", Font.PLAIN, 20));
		ImageIcon icon_phieunhap = new ImageIcon("D:\\LAMDOAN\\DoAn\\src\\img\\phieunhap.png");
		jlabel_phieunhap.setIcon(icon_phieunhap);
		panel_menu.add(jlabel_phieunhap);

		
		JLabel jlabel_xuathang = new JLabel("Xuất hàng");
		jlabel_xuathang.setForeground(Color.WHITE);
		jlabel_xuathang.setFont(new Font("Arial", Font.PLAIN, 20));
		ImageIcon icon_xuathang = new ImageIcon("D:\\LAMDOAN\\DoAn\\src\\img\\xuathang.png");
		jlabel_xuathang.setIcon(icon_xuathang);
		panel_menu.add(jlabel_xuathang);
		
		
		JLabel jlabel_phieuxuat = new JLabel("Phiếu xuất");
		jlabel_phieuxuat.setForeground(Color.WHITE);
		jlabel_phieuxuat.setFont(new Font("Arial", Font.PLAIN, 20));
		ImageIcon icon_phieuxuat = new ImageIcon("D:\\LAMDOAN\\DoAn\\src\\img\\phieuxuat.png");
		jlabel_phieuxuat.setIcon(icon_phieuxuat);
		panel_menu.add(jlabel_phieuxuat);
		
		
		JLabel jlabel_cuahang = new JLabel("Cửa hàng");
		jlabel_cuahang.setForeground(Color.WHITE);
		jlabel_cuahang.setFont(new Font("Arial", Font.PLAIN, 20));
		ImageIcon icon_cuahang = new ImageIcon("D:\\LAMDOAN\\DoAn\\src\\img\\store.png");
		jlabel_cuahang.setIcon(icon_cuahang);
		panel_menu.add(jlabel_cuahang);
		
		
		JLabel jlabel_taikhoan = new JLabel("Tài khoản");
		jlabel_taikhoan.setForeground(Color.WHITE);
		jlabel_taikhoan.setFont(new Font("Arial", Font.PLAIN, 20));
		ImageIcon icon_taikhoan = new ImageIcon("D:\\LAMDOAN\\DoAn\\src\\img\\taikhoan.png");
		jlabel_taikhoan.setIcon(icon_taikhoan);
		panel_menu.add(jlabel_taikhoan);
		
		
		
		JLabel jlabel_thongke = new JLabel("Thống kê");
		jlabel_thongke.setForeground(Color.WHITE);
		jlabel_thongke.setFont(new Font("Arial", Font.PLAIN, 20));
		ImageIcon icon_thongke = new ImageIcon("D:\\LAMDOAN\\DoAn\\src\\img\\thongke.png");
		jlabel_thongke.setIcon(icon_thongke);
		panel_menu.add(jlabel_thongke);
		
		
		JLabel jlabel_đổiThongtin = new JLabel("Đổi thông tin");
		jlabel_đổiThongtin.setForeground(Color.WHITE);
		jlabel_đổiThongtin.setFont(new Font("Arial", Font.PLAIN, 20));
		ImageIcon icon_doithongtin = new ImageIcon("D:\\LAMDOAN\\DoAn\\src\\img\\thongtin.png");
		jlabel_đổiThongtin.setIcon(icon_doithongtin);
		panel_menu.add(jlabel_đổiThongtin);
		
		
		
		JLabel jlabel_dangxuat = new JLabel("Đăng xuất");
		jlabel_dangxuat.setForeground(Color.WHITE);
		jlabel_dangxuat.setFont(new Font("Arial", Font.PLAIN, 20));
		ImageIcon icon_dangxuat = new ImageIcon("D:\\LAMDOAN\\DoAn\\src\\img\\dangxuat.png");
		jlabel_dangxuat.setIcon(icon_dangxuat);
		panel_menu.add(jlabel_dangxuat);
        
        
         panel_nhaphang = new JPanel();
		panel_nhaphang.setBounds(197, 0, 1189, 763);
        contentPane.add(panel_nhaphang, BorderLayout.CENTER);
        panel_nhaphang.setLayout(new BorderLayout(0, 0));
        
        JPanel panel = new JPanel();
        panel_nhaphang.add(panel, BorderLayout.EAST);
        panel.setBounds(0, 0, 197, 763);
        panel.setLayout(new BorderLayout(0, 0));

        JPanel panel_bentren = new JPanel();
        panel_bentren.setLayout(new GridLayout(6, 1, 0, 0));
        panel.add(panel_bentren,BorderLayout.CENTER);
        panel.setBounds(0, 0, 197, 763);
        JLabel mapn = new JLabel("Mã phiếu nhập");
        mapn.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_bentren.add(mapn);
        jl_mapn = new JTextField();
        panel_bentren.add(jl_mapn);
        jl_mapn.setColumns(10);
        JLabel manhacc = new JLabel("Mã nhà cung cấp");
        manhacc.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_bentren.add(manhacc);
         jt_manhacc = new JTextField();
        panel_bentren.add(jt_manhacc);
        jt_manhacc.setColumns(1);   
	        JLabel ngaynhap = new JLabel("Ngày nhập");
	        ngaynhap.setFont(new Font("Tahoma", Font.PLAIN, 15));
	        panel_bentren.add(ngaynhap);
		        jt_ngaynhap = new JTextField();
		        jt_ngaynhap.setText(date+"");
		        jt_ngaynhap.setEnabled(false);
		        panel_bentren.add(jt_ngaynhap);
		        jt_ngaynhap.setColumns(1);       
		        JLabel manhanvien = new JLabel("Mã nhân viên");
		        manhanvien.setFont(new Font("Tahoma", Font.PLAIN, 15));
		        panel_bentren.add(manhanvien);
			        jtmanhanvien = new JTextField();
			        panel_bentren.add(jtmanhanvien);
			        jtmanhanvien.setColumns(1); 
        
        
        
        JPanel panel_benduoi = new JPanel();
        panel_benduoi.setLayout(new GridLayout(3, 1, 0, 0));
        panel.add(panel_benduoi,BorderLayout.SOUTH);
        panel.setBounds(0, 0, 197, 763);
        
        JPanel panel_conduoi = new JPanel();
        panel_conduoi.setLayout(new GridLayout(1, 2, 0, 0));
        panel_benduoi.add(panel_conduoi);
        JLabel tongtiennn = new JLabel("Tổng tiền : ");
        tongtiennn.setHorizontalAlignment(SwingConstants.CENTER);
        tongtiennn.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_conduoi.add(tongtiennn);
         kqtongtiennn = new JLabel("0đ");
        kqtongtiennn.setHorizontalAlignment(SwingConstants.CENTER);
        kqtongtiennn.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_conduoi.add(kqtongtiennn);
        
         btn_nhaphang = new JButton("Nhập hàng");
        btn_nhaphang.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel_benduoi.add(btn_nhaphang);
        
         btn_quaylai = new JButton("Quay lại");
        btn_quaylai.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel_benduoi.add(btn_quaylai);
        
        
//        panel.setBounds(0, 0, 197, 763);
//        JLabel manhanvien = new JLabel("Mã nhân viên");
//        manhanvien.setFont(new Font("Tahoma", Font.PLAIN, 15));
//        panel_bentren.add(manhanvien);
//	        jtmanhanvien = new JTextField();
//	        panel_bentren.add(jtmanhanvien);
//	        jtmanhanvien.setColumns(1);
//        
        
        JPanel panel_1 = new JPanel();
        panel_nhaphang.add(panel_1, BorderLayout.CENTER);
        panel_1.setLayout(new BorderLayout(0, 0));
        
      
        
        JPanel panel_3 = new JPanel();
        panel_1.add(panel_3, BorderLayout.SOUTH);
	        
	        
      
			        
	        JPanel panel_giua = new JPanel();
//	        panel_nhaphang.add(panel_giua, BorderLayout.CENTER);
	        panel_giua.setLayout(new GridLayout(1, 2, 0, 0));
	        panel_1.add(panel_giua, BorderLayout.CENTER);

	        
	        JPanel panelg_trai = new JPanel();
	        panel_giua.add(panelg_trai);
	        JPanel panelg_phai = new JPanel();
	        panel_giua.add(panelg_phai);
	        panelg_phai.setLayout(new GridLayout(5, 2, 0, 0));
	        panelg_trai.setLayout(new BorderLayout(0, 0));
	        
	        JPanel panelg_trai_tren = new JPanel();
	        panelg_trai.add(panelg_trai_tren,BorderLayout.NORTH);
	        panelg_trai_tren.setLayout(new BoxLayout(panelg_trai_tren, BoxLayout.X_AXIS));
	        jt_otimkiem = new JTextField();
	        panelg_trai_tren.add(jt_otimkiem);
			ImageIcon icon_lammoi =  new ImageIcon("D:\\LUYENTAPJAVA\\DoAnJava-main\\QuanLyKhoHangLaptop\\src\\img\\loadicon.png");
	         btn_timkiem = new JButton("Làm mới",icon_lammoi);
	        btn_timkiem.setBackground(new Color(255, 255, 255));
	        btn_timkiem.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        panelg_trai_tren.add(btn_timkiem);
	        
	        
	        JLabel jl_masanpham = new JLabel("Mã sản phẩm");
	        jl_masanpham.setHorizontalAlignment(SwingConstants.CENTER);
	        jl_masanpham.setFont(new Font("Tahoma", Font.PLAIN, 15));
	        panelg_phai.add(jl_masanpham);
	        
	        
	        jt_masanpham = new JTextField();
	        jt_masanpham.setEnabled(false);
	        jt_masanpham.setToolTipText("");
	        panelg_phai.add(jt_masanpham);
	        jt_masanpham.setColumns(1);   
	        JLabel jl_tensanpham = new JLabel("Tên sản phẩm");
	        jl_tensanpham.setHorizontalAlignment(SwingConstants.CENTER);
	        jl_tensanpham.setFont(new Font("Tahoma", Font.PLAIN, 15));
	        panelg_phai.add(jl_tensanpham);
	        jt_tensanpham = new JTextField();
	        jt_tensanpham.setEnabled(false);
	        panelg_phai.add(jt_tensanpham);
	        jt_tensanpham.setColumns(1);  
	        JLabel jl_soluong = new JLabel("Số lượng");
	        jl_soluong.setHorizontalAlignment(SwingConstants.CENTER);
	        jl_soluong.setFont(new Font("Tahoma", Font.PLAIN, 15));
	        panelg_phai.add(jl_soluong);
	        jt_soluong = new JTextField();
	        panelg_phai.add(jt_soluong);
	        jt_soluong.setColumns(1);   
	        
	        JLabel jl_thanhtien = new JLabel("Thành tiền");
	        jl_thanhtien.setHorizontalAlignment(SwingConstants.CENTER);
	        jl_thanhtien.setFont(new Font("Tahoma", Font.PLAIN, 15));
	        panelg_phai.add(jl_thanhtien);
	        jt_thanhtien = new JTextField();
	        jt_thanhtien.setEnabled(false);
	        panelg_phai.add(jt_thanhtien);
	        jt_thanhtien.setColumns(1);   
	        
	         btn_suasp = new JButton("Sửa sản phẩm");
	        btn_suasp.setEnabled(false);
	        btn_suasp.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        panelg_phai.add(btn_suasp);
	        
	         btn_xoasp = new JButton("Xóa sản phẩm");
	        btn_xoasp.setEnabled(false);
	        btn_xoasp.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        panelg_phai.add(btn_xoasp);
//	        JLabel jl_masanpham = new JLabel("Mã sản phẩm");
//	        jl_masanpham.setFont(new Font("Tahoma", Font.PLAIN, 15));
//	        panelg_phai.add(jl_masanpham);
//	        JLabel jl_tensanpham = new JLabel("Tên sản phẩm");
//	        jl_tensanpham.setFont(new Font("Tahoma", Font.PLAIN, 15));
//	        panelg_phai.add(jl_tensanpham);
//	        jt_masanpham = new JTextField();
//	        panelg_phai.add(jt_masanpham);
//	        jt_masanpham.setColumns(1);   
//	        jt_tensanpham = new JTextField();
//	        panelg_phai.add(jt_tensanpham);
//	        jt_tensanpham.setColumns(1);  
	        
	        
	        String column []= {"Mã máy","Tên máy","Số lượng"};
			Object data [][]= {};
//			 panel_phai.setLayout(new BorderLayout(0, 0));
			 table = new JTable(data,column);
//			 table.addKeyListener(new KeyAdapter() {
//			 	@Override
//			 	public void keyPressed(KeyEvent e) {
//			 	}
//			 });
			 JScrollPane scrollPane = new JScrollPane(table);
			 scrollPane.setBounds(197, 0, 100, 100);
			 panelg_trai.add(scrollPane,BorderLayout.CENTER);
			table.setDefaultEditor(Object.class, null);
			table.setModel(new DefaultTableModel(
				new Object[][] {			
				},
				new String[] {
						"Mã máy","Tên máy","Số lượng"
				}
			));
			
			 model = (DefaultTableModel) table.getModel();
			for (Laptop sp : sanpham) {
				stt=0;
			    model.addRow(new Object[] {
			    		sp.getMaLaptop(),sp.getTenLaptop(),sp.getSoLuong()
			    });
			}
			table.getTableHeader().setResizingAllowed(false);
			table.getTableHeader().setReorderingAllowed(false);
	      
			JPanel panelg_trai_duoi = new JPanel();
	        panelg_trai.add(panelg_trai_duoi,BorderLayout.SOUTH);
	        panelg_trai_duoi.setLayout(new GridLayout(1, 2, 0, 0));
	         btn_themsp = new JButton("Thêm sản phẩm");
	         btn_themsp.setBackground(new Color(0, 255, 255));
	        btn_themsp.setFont(new Font("Tahoma", Font.PLAIN, 20));
	         btn_nhapexcel = new JButton("Nhập Excel");
	        btn_nhapexcel.setBackground(new Color(0, 255, 0));
	        btn_nhapexcel.setFont(new Font("Tahoma", Font.PLAIN, 20));
	        panelg_trai_duoi.add(btn_themsp);
	        panelg_trai_duoi.add(btn_nhapexcel);

			String column1 []= {"Mã máy","Tên máy","Số lượng","Đơn giá"};
			Object data1 [][]= {};
			 panel_3.setLayout(new BorderLayout(0, 0));
//			 panel_phai.setLayout(new BorderLayout(0, 0));
			 table1 = new JTable(data1,column1);
			 JScrollPane scrollPane1 = new JScrollPane(table1);
			 scrollPane1.setBounds(197, 0, 100, 100);
			 panel_3.add(scrollPane1);
			table1.setDefaultEditor(Object.class, null);
			table1.setModel(new DefaultTableModel(
				new Object[][] {			
				},
				new String[] {
						"STT","Mã nhà cung cấp","Mã sản phẩm","Tên sản phẩm","CPU","GPU","Ram","Rom","Hệ điều hành","Màn hình","Hãng","Gía","Số lượng"
				}
			));
			
			 model1 = (DefaultTableModel) table1.getModel();
//			for (PhieuNhap sp : sanpham) {
//				
//			    model.addRow(new Object[] {
//			    		stt,sp.getMaPhieuNhap(),PhieuNhapDao.getInstance().laytennhacungcap(sp.getMaNhaCungCap()),PhieuNhapDao.getInstance().laytennhanvien(sp.getMaNhanVien()),sp.getNgayNhap(),sp.getTongTien()
//			    });
//			}
			table1.getTableHeader().setResizingAllowed(false);
			table1.getTableHeader().setReorderingAllowed(false);
			
			Controllernhaphang.ActionListener(btn_themsp, this);
			Controllernhaphang.addKeyListener(jt_otimkiem, this);
			Controllernhaphang.addKeyListener(jt_soluong, this);
			Controllernhaphang.addMouseListener(table, this);
			Controllernhaphang.addMouseListener(table1, this);
			Controllernhaphang.ActionListener(btn_nhaphang, this);
			Controllernhaphang.ActionListener(btn_quaylai, this);
			Controllernhaphang.ActionListener(btn_timkiem, this);
			Controllernhaphang.ActionListener(btn_xoasp, this);
			Controllernhaphang.ActionListener(btn_suasp, this);


	}

	public void suasanphamthem() {
		 int i=table1.getSelectedRow();
		 jt_masanpham.setText(model1.getValueAt(i, 2)+"");
		 jt_tensanpham.setText(model1.getValueAt(i, 3)+"");
		 jt_soluong.setText(model1.getValueAt(i, 12)+"");
		 jt_thanhtien.setText(model1.getValueAt(i, 11)+"");
	}
	
	public void xoasanphamthem() {
		 int i=table1.getSelectedRow();
		 if(i<0) JOptionPane.showConfirmDialog(null, "Bạn chưa chọn dòng cần xóa","THÔNG BÁO",JOptionPane.CLOSED_OPTION);	
		 else {
    	 int luachon=JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn xóa nó không ?");
    	 if(luachon==JOptionPane.YES_OPTION) {
    		 String mp=model1.getValueAt(i, 1)+"";
//    		 PhieuNhapDao.getInstance().deletetheoma(mp);
    			model1.removeRow(i);
    	 }
		 }
	}
	
	public void thanhtimkiem() {
		stt=0;
		model.setRowCount(0);
		String textall=jt_otimkiem.getText();
		for (Laptop sp : sanpham) {
			stt=0;
			if(sp.getMaLaptop().contains(textall) || sp.getTenLaptop().contains(textall)) {
		    model.addRow(new Object[] {
		    		sp.getMaLaptop(),sp.getTenLaptop(),sp.getSoLuong()
		    });
			}
		}
		
	}
	
	public void lammoithanh() {
		model.setRowCount(0);
		jt_otimkiem.setText("");
		for (Laptop sp : sanpham) {
			stt=0;
		    model.addRow(new Object[] {
		    		sp.getMaLaptop(),sp.getTenLaptop(),sp.getSoLuong()
		    });
		}
	}
	
	public void nutquaylai() {
		panel_nhaphang.setVisible(false);
		panel_nhaphang.removeAll();
		Phieunhap pn=new Phieunhap();
		panel_nhaphang.add(pn.panel_phieunhap);
		panel_nhaphang.setVisible(true);
	}
	
	public void nhaphang() {
		String maphieun=jl_mapn.getText();
		String manhacc=jt_manhacc.getText();
		String tongtienn=tongtien+"";
		int tongsl=Integer.parseInt(jt_soluong.getText());
		String manhanvi=jtmanhanvien.getText();
		String xoais=0+"";
		System.out.println(maphieun);
		DecimalFormat df2 = new DecimalFormat("#");
	     String formattedNumber2 = df2.format(Double.parseDouble(tongtienn));
			PhieuNhap pn1=new PhieuNhap(maphieun,manhacc,manhanvi,Double.parseDouble(formattedNumber2),tongsl,date,0);
			PhieuNhapDao.getInstance().insert(pn1);
			for(int i=0;i<table1.getRowCount();i++) {
				String masanpham=model1.getValueAt(i, 2)+"";
				int soluongm = Integer.parseInt(String.valueOf(model1.getValueAt(i, 12)));
				String thanhtienm=model1.getValueAt(i, 11)+"";
				ChiTietPhieuNhap ctpn=new ChiTietPhieuNhap(maphieun,masanpham,soluongm,Double.parseDouble(thanhtienm),0);
				PhieuNhapDao.getInstance().inchitietphieu(ctpn);
				LaptopDAO.getintance().update1dulieu(masanpham, soluongm);
			}
			model.setRowCount(0);
			model1.setRowCount(0);
			jl_mapn.setText("");
			jt_manhacc.setText("");
			jtmanhanvien.setText("");
			sanpham=LaptopDAO.getintance().selectAll();
			for (Laptop sp : sanpham) {
				stt=0;
			    model.addRow(new Object[] {
			    		sp.getMaLaptop(),sp.getTenLaptop(),sp.getSoLuong()
			    });
			}
			
			
			JOptionPane.showConfirmDialog(null, "Nhập hàng thành công","THÔNG BÁO",JOptionPane.CLOSED_OPTION);	
	}
	
	public void clickvaotable1() {
		 btn_xoasp.setBackground(new Color(255, 128, 128));
		    btn_suasp.setBackground(new Color(255, 128, 64));
	        btn_themsp.setBackground(new Color(255, 255, 255));
	        btn_nhapexcel.setBackground(new Color(255, 255, 255));
	        btn_xoasp.setForeground(new Color(255, 255, 255));
	        btn_suasp.setForeground(new Color(255, 255, 255));
	        int rowCount = model1.getRowCount();
		    if (rowCount > 0) {
		        int lastRow = rowCount-1;
		        table1.setRowSelectionInterval(lastRow, lastRow);
		        table1.changeSelection(lastRow, 0, true, true);
		    }
	}
	
	public void themsanpham() {
		jt_soluong.setText("");
		btn_suasp.setBackground(new Color(255, 255, 255));
        btn_xoasp.setBackground(new Color(255, 255, 255));
	    table1.setRowSelectionAllowed(false);
	    btn_suasp.setEnabled(false);
	    btn_xoasp.setEnabled(false);
		 int i=table.getSelectedRow();
		 jt_masanpham.setText(model.getValueAt(i, 0)+"");
		 jt_tensanpham.setText(model.getValueAt(i, 1)+"");
	}
	
	public void themvaobang() {
		if(jt_soluong.getText().length()>0) {
			stt1++;
	 Laptop lt=LaptopDAO.getintance().lay1sp(jt_masanpham.getText());
		    model1.addRow(new Object[] {
//					"STT","Mã sản phẩm","Tên sản phẩm","CPU","GPU","Ram","Rom","Hệ điều hành","Màn hình","Hãng","Gía","Số lượng"
		    		stt1,lt.getMaNhaCungCap(),lt.getMaLaptop(),lt.getTenLaptop(),lt.getCPU(),lt.getGPU(),lt.getRam(),lt.getRom(),lt.getHeDieuHanh(),lt.getManHinh(),lt.getHang(),jt_thanhtien.getText(),jt_soluong.getText()
		    		
		    });
		    int rowCount = model1.getRowCount();
		    if (rowCount > 0) {
		        int lastRow = rowCount-1;
		        table1.setRowSelectionInterval(lastRow, lastRow);
		        table1.changeSelection(lastRow, 0, false, false);
			    table1.setRowSelectionAllowed(true);

		    }
		    tongtien+=Double.parseDouble(jt_thanhtien.getText());
		    DecimalFormat df1 = new DecimalFormat("#");
		     String formattedNumber1 = df1.format(tongtien);
		    kqtongtiennn.setText(formattedNumber1+"đ");
		    jt_masanpham.setText("");
		    jt_tensanpham.setText("");
		    jt_soluong.setText("");
		    jt_thanhtien.setText("");
		    btn_suasp.setEnabled(true);
		    btn_xoasp.setEnabled(true);
		    btn_suasp.setBackground(new Color(255, 128, 64));
	        btn_xoasp.setBackground(new Color(255, 128, 128));
		}else JOptionPane.showConfirmDialog(null, "Bạn chưa nhập số lượng","THÔNG BÁO",JOptionPane.CLOSED_OPTION);	
	}
	
	public void hiengiakhithem() {
		 String sol=jt_soluong.getText();
		if(sol.length()>0) {
		 int j=table.getSelectedRow();
		 String tmpma=model.getValueAt(j, 0)+"";
		 //Laptop lap=LaptopDAO.getintance().lay1sp(tmpma);
		 //double giaca=Double.parseDouble(sol)*lap.getGia();
	     DecimalFormat df = new DecimalFormat("#");
	    // String formattedNumber = df.format(giaca);
		 //jt_thanhtien.setText(formattedNumber);
		 
		 }else 		 jt_thanhtien.setText("");

	}
}
