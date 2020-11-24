package com.group4.ui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.group4.entities.TuaDe;
import com.group4.ui.ICloseUIListener;
import com.group4.ui.dialog.DlgSearchTitle;

public class PnlReservation extends JPanel {
	private static final long serialVersionUID = 1L;
	private ICloseUIListener closeUIListener;

	private JTextField textField;
	private JLabel lblCustomerName;
	private JButton btnConfirmCustomer;
	private JLabel lblReservationDate;
	private JLabel lblCustomerPhone;
	private JButton btnAccept;
	private JButton btnClose;
	private JButton btnCancel;
	private JButton btnSearchTitle;
	private JButton btnRemove;
	private JComboBox<TuaDe> cmbTitleOfDisk;

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
		pnlCustomer.setBorder(new CompoundBorder(new EmptyBorder(0, 0, 10, 0),
				new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Th\u00F4ng tin kh\u00E1ch h\u00E0ng",
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0))));
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

		btnConfirmCustomer = new JButton("Xác nhận");
		btnConfirmCustomer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnlCustomerID.add(btnConfirmCustomer);

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
		pnlReservation.setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0),
				new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Th\u00F4ng tin \u0111\u1EB7t \u0111\u0129a",
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0))));
		panel.add(pnlReservation, BorderLayout.CENTER);
		pnlReservation.setLayout(new BorderLayout(0, 0));

		JPanel pnlTitleOfDisk = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) pnlTitleOfDisk.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		pnlReservation.add(pnlTitleOfDisk, BorderLayout.NORTH);

		JLabel lblTitleID = new JLabel("Tựa đề: ");
		lblTitleID.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlTitleOfDisk.add(lblTitleID);

		cmbTitleOfDisk = new JComboBox<TuaDe>();
		cmbTitleOfDisk.setEditable(false);
		cmbTitleOfDisk.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlTitleOfDisk.add(cmbTitleOfDisk);

		JButton btnConfirmTitle = new JButton("Xác nhận");
		btnConfirmTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlTitleOfDisk.add(btnConfirmTitle);

		JPanel pnlOperation = new JPanel();
		pnlOperation
				.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 2), new EmptyBorder(10, 10, 10, 10)));
		pnlReservation.add(pnlOperation, BorderLayout.EAST);
		pnlOperation.setLayout(new GridLayout(2, 1, 10, 10));

		JPanel pnlOprAbove = new JPanel();
		pnlOperation.add(pnlOprAbove);
		pnlOprAbove.setLayout(new GridLayout(3, 1, 0, 0));

		btnAccept = new JButton("Xác nhận đặt");
		pnlOprAbove.add(btnAccept);
		btnAccept.setFont(new Font("Tahoma", Font.PLAIN, 20));

		btnCancel = new JButton("Huỷ");
		pnlOprAbove.add(btnCancel);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 20));

		btnClose = new JButton("Đóng");
		pnlOprAbove.add(btnClose);
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 20));

		btnSearchTitle = new JButton("Tìm kiếm tựa đề\r\n");
		btnSearchTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlOperation.add(btnSearchTitle);

		JPanel pnlCenter = new JPanel();
		pnlCenter.setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 20), new LineBorder(new Color(0, 0, 0), 2)));
		pnlReservation.add(pnlCenter, BorderLayout.CENTER);
		pnlCenter.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		pnlCenter.add(scrollPane, BorderLayout.CENTER);

		JList lstReservation = new JList();
		lstReservation.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstReservation.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scrollPane.setViewportView(lstReservation);

		btnRemove = new JButton("Xoá bỏ");
		btnRemove.setEnabled(false);
		btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlCenter.add(btnRemove, BorderLayout.SOUTH);

		setEventForButton();

	}

	private void setEventForButton() {

		btnClose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				closeUIListener.onCloseUI(e);

			}
		});

		btnSearchTitle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DlgSearchTitle searchTitleDlg = new DlgSearchTitle();
				searchTitleDlg.setLocationRelativeTo(null);
				searchTitleDlg.setVisible(true);

				if (searchTitleDlg.getTuaDe() != null) {
					System.out.println(searchTitleDlg.getTuaDe());
				}

			}
		});

	}

	public void setCloseUIListener(ICloseUIListener closeUIListener) {
		this.closeUIListener = closeUIListener;
	}

}
