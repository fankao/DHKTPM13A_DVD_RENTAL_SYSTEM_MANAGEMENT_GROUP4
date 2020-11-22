package com.group4.ui.panel;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class PnlReservation extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JLabel lblCustomerName;
	private JButton btnConfirm;
	private JLabel lblReservationDate;
	private JLabel lblCustomerPhone;
	private JTextField textField_1;

	public PnlReservation() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setSize(1270, 600);
		setLayout(new BorderLayout(0, 0));
		
		JPanel pnlTitle = new JPanel();
		add(pnlTitle, BorderLayout.NORTH);
		
		JLabel lblTitle = new JLabel("ĐẶT TRƯỚC ĐĨA");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 25));
		pnlTitle.add(lblTitle);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlCustomer = new JPanel();
		pnlCustomer.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Th\u00F4ng tin kh\u00E1ch h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.add(pnlCustomer, BorderLayout.NORTH);
		pnlCustomer.setLayout(new BoxLayout(pnlCustomer, BoxLayout.Y_AXIS));
		
		JPanel pnlReservationDate = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnlReservationDate.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		pnlCustomer.add(pnlReservationDate);
		
		JLabel lblReservationDateTitle = new JLabel("Ngày đặt đĩa: ");
		lblReservationDateTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnlReservationDate.add(lblReservationDateTitle);
		
		lblReservationDate = new JLabel("20/10/2020");
		lblReservationDate.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblReservationDate.setToolTipText("");
		pnlReservationDate.add(lblReservationDate);
		
		JPanel pnlCustomerID = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) pnlCustomerID.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		pnlCustomer.add(pnlCustomerID);
		
		JLabel lblCustomerIDTitle = new JLabel("Mã khách hàng: ");
		lblCustomerIDTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnlCustomerID.add(lblCustomerIDTitle);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnlCustomerID.add(textField);
		textField.setColumns(15);
		
		btnConfirm = new JButton("Xác nhận");
		btnConfirm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnlCustomerID.add(btnConfirm);
		
		JPanel pnlCustomerInfo = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) pnlCustomerInfo.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		pnlCustomer.add(pnlCustomerInfo);
		
		JLabel lblCustomerNameTitle = new JLabel("Tên khách hàng: ");
		lblCustomerNameTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnlCustomerInfo.add(lblCustomerNameTitle);
		
		lblCustomerName = new JLabel("Nguyễn Minh Chiến");
		lblCustomerName.setFont(new Font("Tahoma", Font.BOLD, 15));
		pnlCustomerInfo.add(lblCustomerName);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		pnlCustomerInfo.add(horizontalGlue);
		
		JLabel lblCustomerPhoneTitle = new JLabel("Số điện thoại: ");
		lblCustomerPhoneTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnlCustomerInfo.add(lblCustomerPhoneTitle);
		
		lblCustomerPhone = new JLabel("0852369741");
		lblCustomerPhone.setFont(new Font("Tahoma", Font.BOLD, 15));
		pnlCustomerInfo.add(lblCustomerPhone);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		pnlCustomerInfo.add(horizontalGlue_1);
		
		JLabel lblCustomerAddressTitle = new JLabel("Địa chỉ: ");
		lblCustomerAddressTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnlCustomerInfo.add(lblCustomerAddressTitle);
		
		JLabel lblCustomerAddress = new JLabel("Bình Phước");
		lblCustomerAddress.setFont(new Font("Tahoma", Font.BOLD, 15));
		pnlCustomerInfo.add(lblCustomerAddress);
		
		JPanel pnlReservation = new JPanel();
		panel.add(pnlReservation, BorderLayout.CENTER);
		pnlReservation.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlTitleOfDisk = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) pnlTitleOfDisk.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		pnlReservation.add(pnlTitleOfDisk, BorderLayout.NORTH);
		
		JLabel lblTitleID = new JLabel("Tựa đề: ");
		lblTitleID.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlTitleOfDisk.add(lblTitleID);
		
		textField_1 = new JTextField();
		pnlTitleOfDisk.add(textField_1);
		textField_1.setColumns(10);
		
		

	}

}
