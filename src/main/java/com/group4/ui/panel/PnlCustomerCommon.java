package com.group4.ui.panel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.group4.dao.IKhachHangDAO;
import com.group4.dao.impl.KhachHangDAO;
import com.group4.entities.KhachHang;

public class PnlCustomerCommon extends JPanel {
	private static final long serialVersionUID = 1L;
	private static IKhachHangDAO khachHangDAO;
	static {
		khachHangDAO = new KhachHangDAO();
	}

	private KhachHang khachHang;

	private JTextField txtCustomerID;
	private JButton btnSearchCusId;
	private JPanel pnlCustomerInfo;
	private JLabel lblCustomerName;
	private JLabel lblCustomerPhone;
	private JLabel lblCustomerAddress;

	/**
	 * Create the panel.
	 */
	public PnlCustomerCommon() {
		setLayout(new BorderLayout(0, 0));
		createLayout();

	}

	private void createLayout() {
		JPanel pnlCustomerID = new JPanel();
		this.add(pnlCustomerID);
		FlowLayout flowLayout = (FlowLayout) pnlCustomerID.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);

		JLabel lblCustomerID = new JLabel("Mã khách hàng: ");
		lblCustomerID.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblCustomerID.setHorizontalAlignment(SwingConstants.LEFT);
		pnlCustomerID.add(lblCustomerID);

		txtCustomerID = new JTextField();
		txtCustomerID.setFont(new Font("Dialog", Font.PLAIN, 20));
		pnlCustomerID.add(txtCustomerID);
		txtCustomerID.setColumns(15);

		btnSearchCusId = new JButton("Xác nhận");
		btnSearchCusId.setFont(new Font("Dialog", Font.PLAIN, 20));
		pnlCustomerID.add(btnSearchCusId);

		pnlCustomerInfo = new JPanel();
		this.add(pnlCustomerInfo);
		pnlCustomerInfo.setVisible(false);
		FlowLayout fl_pnlCustomerInfo = (FlowLayout) pnlCustomerInfo.getLayout();
		fl_pnlCustomerInfo.setAlignment(FlowLayout.LEFT);

		JLabel lblCustomerNameTitle = new JLabel("Tên khách hàng:");
		lblCustomerNameTitle.setFont(new Font("Dialog", Font.PLAIN, 20));
		pnlCustomerInfo.add(lblCustomerNameTitle);

		lblCustomerName = new JLabel("Nguyễn Minh Chiến");
		lblCustomerName.setFont(new Font("Dialog", Font.BOLD, 20));
		pnlCustomerInfo.add(lblCustomerName);

		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalGlue.setPreferredSize(new Dimension(20, 0));
		pnlCustomerInfo.add(horizontalGlue);

		JLabel lblCustomePhoneTitle = new JLabel("Số điện thoại: ");
		lblCustomePhoneTitle.setFont(new Font("Dialog", Font.PLAIN, 20));
		pnlCustomerInfo.add(lblCustomePhoneTitle);

		lblCustomerPhone = new JLabel("038965214");
		lblCustomerPhone.setFont(new Font("Dialog", Font.BOLD, 20));
		pnlCustomerInfo.add(lblCustomerPhone);

		Component horizontalGlue_1 = Box.createHorizontalGlue();
		horizontalGlue_1.setPreferredSize(new Dimension(20, 0));
		pnlCustomerInfo.add(horizontalGlue_1);

		JLabel lblCustomerAddressTitle = new JLabel("Địa chỉ: ");
		lblCustomerAddressTitle.setFont(new Font("Dialog", Font.PLAIN, 20));
		pnlCustomerInfo.add(lblCustomerAddressTitle);

		lblCustomerAddress = new JLabel("Bình Phước");
		lblCustomerAddress.setFont(new Font("Dialog", Font.BOLD, 20));
		pnlCustomerInfo.add(lblCustomerAddress);

		ganSuKienChoButton();

	}

	private void ganSuKienChoButton() {
		btnSearchCusId.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (isValidInput(txtCustomerID)) {
					Long cusId = null;
					try {
						cusId = Long.valueOf(txtCustomerID.getText());
					} catch (NumberFormatException ex) {
						hienThongBao("Lỗi định dạng nhập liệu", "Mã khách hàng phải là số nguyên lớn hơn 0",
								JOptionPane.ERROR_MESSAGE);
						txtCustomerID.requestFocus();
						return;
					}

					khachHang = khachHangDAO.findById(cusId);

					if (khachHang == null) {
						hienThongBao("Lỗi tìm kiếm", "Khách hàng không tồn tại trong hệ thống",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

					hienThongTinKhachHang(khachHang);

					visibleCustomeInfo(true);

				}

			}
		});

	}

	private void hienThongBao(String title, String msg, int errorMessage) {
		JLabel label = new JLabel(msg);
		label.setFont(new Font("Arial", Font.BOLD, 18));
		JOptionPane.showMessageDialog(this, label, title, errorMessage);

	}

	private boolean isValidInput(JTextField txt) {
		if (txt.getText().trim().isEmpty()) {
			hienThongBao("Lỗi nhập liệu", "Mời nhập dữ liệu!", JOptionPane.ERROR_MESSAGE);
			txt.requestFocus();
			return false;
		}
		return true;
	}

	/**
	 * Hiện thông tin khách hàng
	 * 
	 * @param khachHang: khách hàng cần hiện thông tin
	 */
	private void hienThongTinKhachHang(KhachHang khachHang) {
		lblCustomerName.setText(khachHang.getHoVaTen());
		lblCustomerPhone.setText(khachHang.getSoDienThoai());
		lblCustomerAddress.setText(khachHang.getDiaChi());
	}

	public boolean visibleCustomeInfo(boolean isVisible) {
		pnlCustomerInfo.setVisible(isVisible);
		return isVisible;

	}

	private KhachHang getKhachHang() {
		return khachHang;
	}

}
