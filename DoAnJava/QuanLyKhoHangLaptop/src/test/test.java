package test;

import javax.swing.UIManager;

import view.mainView;

public class test {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new mainView();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
