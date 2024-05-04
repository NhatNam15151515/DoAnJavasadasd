package test;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;


public class BieuDO {
    public static void main(String[] args) {
        // Tạo bộ dữ liệu mẫu cho biểu đồ
        DefaultPieDataset<String> dataset = new DefaultPieDataset<String>();
        dataset.setValue("Apple", 30);
        dataset.setValue("Banana", 50);
        dataset.setValue("Orange", 20);

        // Tạo biểu đồ tròn từ bộ dữ liệu
        JFreeChart chart = ChartFactory.createPieChart(
                "Fruit Distribution",  // Tiêu đề biểu đồ
                dataset,               // Bộ dữ liệu
                true,                  // In chú thích
                true,                  // Hiển thị các nhãn giá trị
                false                  // Không hiển thị URL
        );

        // Tạo một giao diện người dùng Swing và thêm biểu đồ vào đó
        JFrame frame = new JFrame("Pie Chart Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ChartPanel chartPanel = new ChartPanel(chart);
        frame.getContentPane().add(chartPanel);
        frame.pack();
        frame.setVisible(true);
    }
}