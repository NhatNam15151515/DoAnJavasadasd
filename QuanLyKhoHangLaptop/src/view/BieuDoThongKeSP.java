package view;

import java.awt.Color;
import java.awt.GridLayout;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

import dao.PhieuNhapDao;
import dao.PhieuXuatDao;

public class BieuDoThongKeSP extends JPanel {

	private static final long serialVersionUID = 1L;
	private DefaultCategoryDataset dataset2;
	private DefaultCategoryDataset dataset1;

	public BieuDoThongKeSP() {
		// Tạo bộ dữ liệu mẫu cho biểu đồ
		dataset1 = new DefaultCategoryDataset();
		dataset2 = new DefaultCategoryDataset();

		// Tạo biểu đồ đường từ bộ dữ liệu
		JFreeChart chart = createChart(dataset1, dataset2);
		setLayout(new GridLayout(1, 1, 0, 0));

		// Tạo một panel chứa biểu đồ
		ChartPanel chartPanel = new ChartPanel(chart);
		chartPanel.setPreferredSize(new java.awt.Dimension(900, 700)); // Đặt kích thước của biểu đồ
		add(chartPanel); // Thêm biểu đồ vào panel
	}

	public JFreeChart createChart(DefaultCategoryDataset dataset1, DefaultCategoryDataset dataset2) {
		JFreeChart chart = ChartFactory.createLineChart("Số lượng và Tổng giá trị", // Tiêu đề biểu đồ
				"Thời gian", // Nhãn trục x
				"Giá trị", // Nhãn trục y
				dataset2, // Bộ dữ liệu cho đường 1
				PlotOrientation.VERTICAL, // Hướng của biểu đồ
				true, // Hiển thị chú thích
				true, // Hiển thị tiêu đề
				false // Không hiển thị URL
		);

		// Lấy plot của biểu đồ
		CategoryPlot plot = (CategoryPlot) chart.getPlot();

		// Tạo trục y thứ hai
		NumberAxis yAxis2 = new NumberAxis("Tổng số lượng");
		plot.setRangeAxis(1, yAxis2);
		plot.setDataset(1, dataset1); // Sử dụng dataset1 cho đường biểu đồ thứ hai
		plot.mapDatasetToRangeAxis(1, 1);

		// Chỉnh sửa màu sắc của đường biểu đồ
		LineAndShapeRenderer renderer1 = new LineAndShapeRenderer();
		renderer1.setSeriesPaint(0, Color.BLUE); // Chỉnh màu sắc cho đường biểu đồ dataset1
		plot.setRenderer(1, renderer1); // Ánh xạ renderer1 với đường biểu đồ thứ hai

		// Chỉnh sửa chú thích
		plot.getRenderer().setSeriesVisibleInLegend(0, true); // Hiển thị chú thích cho đường biểu đồ dataset1
		plot.getRenderer().setSeriesVisibleInLegend(1, true); // Hiển thị chú thích cho đường biểu đồ dataset2

		return chart;
	}

	public DefaultCategoryDataset setData(String CongViec, String type, ArrayList<String> day, String dateFormatStr)
			throws ParseException {

		ArrayList<Integer> TongSoLuong = new ArrayList<>();
		ArrayList<Double> TongGiaTien = new ArrayList<>();// Sử dụng định dạng được truyền vào

		// Kiểm tra công việc là nhập hay xuất để chọn danh sách dữ liệu phù hợp
		if (CongViec.equals("Nhập Hàng")) {
			for (String ngay : day) {
				int tongSoLuong = PhieuNhapDao.getInstance().getTotalSoLuong(ngay);
				double tongGiaTien = PhieuNhapDao.getInstance().getTotalTongTien(ngay);
				TongSoLuong.add(tongSoLuong);
				TongGiaTien.add(tongGiaTien);
			}
		} else if (CongViec.equals("Xuất Hàng")) {
			for (String ngay : day) {
				int tongSoLuong = PhieuXuatDao.getInstance().getTotalSoLuong(ngay);
				double tongGiaTien = PhieuXuatDao.getInstance().getTotalTongTien(ngay);
				TongSoLuong.add(tongSoLuong);
				TongGiaTien.add(tongGiaTien);
			}
		}

		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
		// Thêm dữ liệu vào dataset từ danh sách đã tính toán
		for (int i = 0; i < day.size(); i++) {
			String ngay = day.get(i);
			if (type.equals("Số lượng")) {
				dataset.addValue(TongSoLuong.get(i), type, ngay); // Sử dụng định dạng để chuyển đổi thành chuỗi ngày
			} else if (type.equals("Giá trị")) {
				dataset.addValue(TongGiaTien.get(i), type, ngay); // Sử dụng định dạng để chuyển đổi thành chuỗi ngày
			}
		}

		return dataset;
	}

	public void Update(String CongViec, ArrayList<String> day, String dateFormatStr) {
		try {
			dataset1 = setData(CongViec, "Số lượng", day, dateFormatStr);
			dataset2 = setData(CongViec, "Giá trị", day, dateFormatStr);
			removeAll();
			JFreeChart chart = createChart(dataset1, dataset2);
			ChartPanel chartPanel = new ChartPanel(chart);
			chartPanel.setPreferredSize(new java.awt.Dimension(900, 700)); // Đặt kích thước của biểu đồ
			add(chartPanel);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
