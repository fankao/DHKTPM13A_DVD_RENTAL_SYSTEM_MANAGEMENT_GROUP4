package com.group4.ui.panel;

import java.awt.Component;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UtilsLayout {
	
	public UtilsLayout() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Kích hoạt các textfield
	 * 
	 * @param fields: các field cần kích hoạt
	 */
	public static void kichHoatTextField(JTextField... fields) {
		for (JTextField txt : fields) {
			txt.setEditable(true);
		}

	}

	/**
	 * Kích hoạt các button
	 * 
	 * @param buttons: các button cần kích hoạt
	 */
	public static void kichHoatButton(JButton... buttons) {
		for (JButton btn : buttons) {
			btn.setEnabled(true);
		}

	}

	/**
	 * Vô hiệu hoá các textfeld
	 * 
	 * @param fields
	 */
	public static void voHieuHoaTextField(JTextField... fields) {
		for (JTextField txt : fields) {
			txt.setEditable(false);
		}
	}

	/**
	 * vô hiệu hoá các button
	 * 
	 * @param buttons: các button cần vô hiệu hoá
	 */
	public static void voHieuHoaButton(JButton... buttons) {
		for (JButton btn : buttons) {
			btn.setEnabled(false);
		}

	}
	
	/**
	 * Kiểm tra trường nhập dữ liệu không bị trống
	 * 
	 * @param txt: trường nhập dữ liệu
	 * @return true: đã nhập dữ liệu / false: chưa nhập dữ liệu
	 */
	public static boolean isInputFieldNotBlank(Component component,JTextField txt) {
		if (txt.getText().trim().isEmpty()) {
			hienThongBao(component,"Lỗi nhập liệu", "Mời nhập dữ liệu!", JOptionPane.ERROR_MESSAGE);
			txt.requestFocus();
			return false;
		}
		return true;
	}
	
	/**
	 * Thông báo xác nhận thực hiện một công việc nào đó
	 * 
	 * @param title: tiêu đề thông báo
	 * @param msg:   thông điệp
	 * @return Yes: thực hiện / No: không thực hiện
	 */
	public static int hienThongBaoXacNhan(Component component, String title, String msg) {
		JLabel label = new JLabel(msg);
		label.setFont(new Font("arial", Font.PLAIN, 18));
		return JOptionPane.showConfirmDialog(component, label, title, JOptionPane.YES_NO_OPTION);
	}

	/**
	 * Hiện thông báo
	 * 
	 * @param msg: thông báo cần hiển thị
	 */
	public static void hienThongBao(Component component, String title, String msg, int msgType) {
		JLabel label = new JLabel(msg);
		label.setFont(new Font("Arial", Font.BOLD, 18));
		JOptionPane.showMessageDialog(component, label, title, msgType);

	}

	/**
	 * Xoá trắng các textfield
	 * 
	 * @param fields: textfield cần xoá
	 */
	public static void xoaTrang(JTextField... fields) {
		for (JTextField txt : fields) {
			txt.setText("");
		}

	}

}
