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
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.group4.ui.ICloseUIListener;

public class PnlRentDisk extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private ICloseUIListener closeUIListener;
	
	
	private JLabel lblDateRent;
	private JTextField txtCustomerID;
	private JTextField txtDiskID;
	private JTable tblListDisk;
	private final JTable table = new JTable();
	private JButton btnRentDisk;
	private JButton btnClose;
	private JButton btnCancel;
	private JButton btnConfirm;
	private JLabel lblTotalPrice;
	private JButton btnSearchID;
	private JLabel lblCustomerName;
	private JLabel lblCustomerPhone;
	private JLabel lblCustomerAddress;
	
	/**
	 * Create the panel.
	 */
	public PnlRentDisk() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setSize(1270, 600);
		setLayout(new BorderLayout(0, 0));
		
		JPanel pnlTitle = new JPanel();
		FlowLayout fl_pnlTitle = (FlowLayout) pnlTitle.getLayout();
		fl_pnlTitle.setVgap(20);
		add(pnlTitle, BorderLayout.NORTH);
		
		JLabel lblTitle = new JLabel("THUÊ ĐĨA");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 25));
		pnlTitle.add(lblTitle);	
		
		JPanel pnlMain = new JPanel();
		add(pnlMain, BorderLayout.CENTER);
		pnlMain.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlCustomer = new JPanel();
		pnlCustomer.setBorder(new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 2), new EmptyBorder(5, 5, 5, 5)), "Th\u00F4ng tin kh\u00E1ch h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlMain.add(pnlCustomer, BorderLayout.NORTH);
		pnlCustomer.setLayout(new BoxLayout(pnlCustomer, BoxLayout.Y_AXIS));
		
		JPanel pnlDateRent = new JPanel();
		FlowLayout fl_pnlDateRent = (FlowLayout) pnlDateRent.getLayout();
		fl_pnlDateRent.setAlignment(FlowLayout.LEFT);
		pnlCustomer.add(pnlDateRent);
		
		JLabel lblDateRentTitle = new JLabel("Ngày thuê đĩa: ");
		lblDateRentTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnlDateRent.add(lblDateRentTitle);
		
		lblDateRent = new JLabel("20/10/2020");
		lblDateRent.setFont(new Font("Tahoma", Font.BOLD, 15));
		pnlDateRent.add(lblDateRent);
		
		JPanel pnlCustomerID = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnlCustomerID.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		pnlCustomer.add(pnlCustomerID);
		
		JLabel lblCustomerID = new JLabel("Mã khách hàng: ");
		lblCustomerID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCustomerID.setHorizontalAlignment(SwingConstants.LEFT);
		pnlCustomerID.add(lblCustomerID);
		
		txtCustomerID = new JTextField();
		txtCustomerID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnlCustomerID.add(txtCustomerID);
		txtCustomerID.setColumns(15);
		
		btnSearchID = new JButton("Tìm");
		btnSearchID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnlCustomerID.add(btnSearchID);
		
		JPanel pnlCustomerInfo = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) pnlCustomerInfo.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		pnlCustomer.add(pnlCustomerInfo);
		
		JLabel lblCustomerNameTitle = new JLabel("Tên khách hàng:");
		lblCustomerNameTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnlCustomerInfo.add(lblCustomerNameTitle);
		
		lblCustomerName = new JLabel("Nguyễn Minh Chiến");
		lblCustomerName.setFont(new Font("Tahoma", Font.BOLD, 15));
		pnlCustomerInfo.add(lblCustomerName);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		pnlCustomerInfo.add(horizontalGlue);
		
		JLabel lblCustomePhoneTitle = new JLabel("Số điện thoại: ");
		lblCustomePhoneTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnlCustomerInfo.add(lblCustomePhoneTitle);
		
		lblCustomerPhone = new JLabel("038965214");
		lblCustomerPhone.setFont(new Font("Tahoma", Font.BOLD, 15));
		pnlCustomerInfo.add(lblCustomerPhone);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		pnlCustomerInfo.add(horizontalGlue_1);
		
		JLabel lblCustomerAddressTitle = new JLabel("Địa chỉ: ");
		lblCustomerAddressTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnlCustomerInfo.add(lblCustomerAddressTitle);
		
		lblCustomerAddress = new JLabel("Bình Phước");
		lblCustomerAddress.setFont(new Font("Tahoma", Font.BOLD, 15));
		pnlCustomerInfo.add(lblCustomerAddress);
		
		JPanel pnlCenter = new JPanel();
		pnlMain.add(pnlCenter, BorderLayout.CENTER);
		pnlCenter.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlOperation = new JPanel();
		pnlCenter.add(pnlOperation, BorderLayout.EAST);
		pnlOperation.setLayout(new BoxLayout(pnlOperation, BoxLayout.Y_AXIS));
		
		JPanel pnlButton = new JPanel();
		pnlButton.setBorder(new CompoundBorder(new EmptyBorder(10, 0, 0, 0), new CompoundBorder(new LineBorder(new Color(0, 0, 0), 2), new EmptyBorder(5, 5, 5, 5))));
		pnlOperation.add(pnlButton);
		pnlButton.setLayout(new GridLayout(3, 1, 0, 0));
		
		btnConfirm = new JButton("Xác nhận");
		btnConfirm.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlButton.add(btnConfirm);
		
		btnCancel = new JButton("Huỷ bỏ");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlButton.add(btnCancel);
		
		btnClose = new JButton("Đóng");
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlButton.add(btnClose);
		
		JPanel pnlTotalPrice = new JPanel();
		pnlTotalPrice.setBorder(new CompoundBorder(new EmptyBorder(20, 0, 0, 0), new LineBorder(new Color(0, 0, 0), 2)));
		pnlOperation.add(pnlTotalPrice);
		
		JLabel lblTotalPriceTitle = new JLabel("Tổng tiền thuê đĩa");
		lblTotalPriceTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalPriceTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		lblTotalPrice = new JLabel("200.000");
		lblTotalPrice.setForeground(Color.RED);
		lblTotalPrice.setFont(new Font("Tahoma", Font.BOLD, 20));
		GroupLayout gl_pnlTotalPrice = new GroupLayout(pnlTotalPrice);
		gl_pnlTotalPrice.setHorizontalGroup(
			gl_pnlTotalPrice.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlTotalPrice.createSequentialGroup()
					.addGap(20)
					.addComponent(lblTotalPriceTitle, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
					.addGap(20))
				.addGroup(gl_pnlTotalPrice.createSequentialGroup()
					.addGap(96)
					.addComponent(lblTotalPrice, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
					.addGap(85))
		);
		gl_pnlTotalPrice.setVerticalGroup(
			gl_pnlTotalPrice.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlTotalPrice.createSequentialGroup()
					.addGap(73)
					.addComponent(lblTotalPriceTitle, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblTotalPrice)
					.addContainerGap(118, Short.MAX_VALUE))
		);
		pnlTotalPrice.setLayout(gl_pnlTotalPrice);
		
		JPanel pnlRentDisk = new JPanel();
		pnlRentDisk.setBorder(new CompoundBorder(new EmptyBorder(10, 0, 0, 20), new LineBorder(new Color(0, 0, 0), 2)));
		pnlCenter.add(pnlRentDisk, BorderLayout.CENTER);
		pnlRentDisk.setLayout(new BorderLayout(0, 0));
		
		JPanel pnlDiskID = new JPanel();
		FlowLayout fl_pnlDiskID = (FlowLayout) pnlDiskID.getLayout();
		fl_pnlDiskID.setAlignment(FlowLayout.LEFT);
		pnlRentDisk.add(pnlDiskID, BorderLayout.NORTH);
		
		JLabel lblDiskID = new JLabel("Nhập mã đĩa: ");
		lblDiskID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnlDiskID.add(lblDiskID);
		
		txtDiskID = new JTextField();
		txtDiskID.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnlDiskID.add(txtDiskID);
		txtDiskID.setColumns(15);
		
		btnRentDisk = new JButton("Thuê đĩa");
		btnRentDisk.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnlDiskID.add(btnRentDisk);
		
		JPanel pnlListDisk = new JPanel();
		pnlRentDisk.add(pnlListDisk, BorderLayout.CENTER);
		pnlListDisk.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrListDisk = new JScrollPane();
		pnlListDisk.add(scrListDisk, BorderLayout.CENTER);
		
		tblListDisk = new JTable();
		tblListDisk.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tblListDisk.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 \u0111\u0129a", "Ti\u00EAu \u0111\u1EC1", "Lo\u1EA1i \u0111\u0129a", "Gi\u00E1 thu\u00EA", "Ng\u00E0y \u0111\u1EBFn h\u1EA1n"
			}
		) {
			private static final long serialVersionUID = 1L;
			Class[] columnTypes = new Class[] {
				Integer.class, Integer.class, Object.class, Double.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrListDisk.setViewportView(tblListDisk);
		
		setEventForButton();
		
	}

	/**
	 * Thiết lập sự kiện cho button
	 */
	private void setEventForButton() {
		btnClose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				closeUIListener.onCloseUI(e);
				
			}
		});		
	}


	public void setCloseUIListener(ICloseUIListener closeUIListener) {
		this.closeUIListener = closeUIListener;
	}
}
