package controller;


import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

public class LabelController {
    private static JLabel lastClickedLabel;

    public static void addMouseListener(JLabel label) {
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JLabel clickedLabel = (JLabel) e.getSource();

                // Nếu có JLabel được nhấn trước đó, đặt lại màu sắc bình thường
                if (lastClickedLabel != null) {
                    lastClickedLabel.setForeground(Color.WHITE);
                    lastClickedLabel.setBackground(null);
                }

                // Đặt màu sắc mới cho JLabel vừa được nhấn
                clickedLabel.setForeground(Color.BLACK);
                clickedLabel.setBackground(Color.GRAY);

                // Cập nhật lastClickedLabel
                lastClickedLabel = clickedLabel;
            }
        });
    }
}

