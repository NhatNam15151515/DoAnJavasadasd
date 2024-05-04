package test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.text.ParseException;
import java.util.Date;

public class DatePickerExample {
    private static JSpinner daySpinner;
	private static JSpinner monthSpinner;
	private static JSpinner yearSpinner;

	public static void main(String[] args) {
        JFrame frame = new JFrame("Date Picker Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        // Spinner để chọn ngày
        SpinnerModel dayModel = new SpinnerNumberModel(1, 1, 31, 1);
        daySpinner = new JSpinner(dayModel);

        // Spinner để chọn tháng
        SpinnerModel monthModel = new SpinnerNumberModel(1, 1, 12, 1);
        monthSpinner = new JSpinner(monthModel);

        // Spinner để chọn năm
        SpinnerModel yearModel = new SpinnerNumberModel(Calendar.getInstance().get(Calendar.YEAR), 1900, 2100, 1);
        yearSpinner = new JSpinner(yearModel);

        panel.add(yearSpinner);
        panel.add(new JLabel("/"));
        panel.add(monthSpinner);
        panel.add(new JLabel("/"));
        panel.add(daySpinner);

        JButton selectButton = new JButton("Select");
        /*selectButton.addActionListener(e -> {
            int year = (int) yearSpinner.getValue();
            int month = (int) monthSpinner.getValue();
            int day = (int) daySpinner.getValue();
            
            // Kiểm tra ngày tháng năm hợp lệ
            if (isValidDate(year, month, day)) {
                String date = String.format("%04d/%02d/%02d", year, month, day);
                JOptionPane.showMessageDialog(null, "Selected date: " + date);
            } else {
                JOptionPane.showMessageDialog(null, "Invalid date!");
            }
            
        });*/


        selectButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleDateSelection();
            }

        });

        // Tạo phương thức handleDateSelection để xử lý việc chọn ngày tháng năm


        panel.add(selectButton);

        yearSpinner.setValue(2022);
        monthSpinner.setValue(2);
        daySpinner.setValue(2);
        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }

    // Phương thức kiểm tra ngày tháng năm hợp lệ
	private static boolean isValidDate(int year, int month, int day) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        sdf.setLenient(false);
        try {
            Date date = sdf.parse(year + "/" + month + "/" + day);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    private static void handleDateSelection() {
        // Lấy giá trị của ngày, tháng và năm từ Spinner
        int year = (int) yearSpinner.getValue();
        int month = (int) monthSpinner.getValue();
        int day = (int) daySpinner.getValue();

        // Kiểm tra ngày tháng năm hợp lệ và hiển thị thông báo
        if (isValidDate(year, month, day)) {
            String date = String.format("%04d/%02d/%02d", year, month, day);
            JOptionPane.showMessageDialog(null, "Selected date: " + date);
        } else {
            JOptionPane.showMessageDialog(null, "Invalid date!");
        }
    }


}