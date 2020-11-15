package com.group4.ui;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import javax.swing.JPanel;
import java.awt.BorderLayout;

public class FrmMain extends JFrame {
	private static final long serialVersionUID = 1L;

	public FrmMain(String title) {
		super(title);
		buildFrame();
		buildComponentUi();
		setVisible(true);
	}

	/**
	 * Tạo các thành phần giao diện
	 */
	private void buildComponentUi() {
		buildMenu();
		JPanel pnlWork = new JPanel();
		getContentPane().add(pnlWork, BorderLayout.CENTER);
	}

	private void buildMenu() {
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JMenu mnRentDisk = new JMenu("Thuê đĩa");
		mnRentDisk.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnRentDisk);
		
		JMenu mnReturnDisk = new JMenu("Trả đĩa");
		mnReturnDisk.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnReturnDisk);
		
		JMenu mnLateChargesPayment = new JMenu("Thanh toán phí trễ hạn");
		mnLateChargesPayment.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnLateChargesPayment);
		
		JMenu mnManage = new JMenu("Quản lý");
		mnManage.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnManage);
		
		JMenuItem mntmCustomer = new JMenuItem("Khách hàng");
		mntmCustomer.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mnManage.add(mntmCustomer);
		
		JMenuItem mntmTitleDisk = new JMenuItem("Tựa đề");
		mntmTitleDisk.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mnManage.add(mntmTitleDisk);
		
		JMenuItem mntmDisk = new JMenuItem("Đĩa");
		mntmDisk.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mnManage.add(mntmDisk);
		
		JMenu mnSettings = new JMenu("Thiết lập");
		mnSettings.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mnManage.add(mnSettings);
		
		JMenuItem mntmRentalRate = new JMenuItem("Giá thuê cho loại đĩa");
		mntmRentalRate.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnSettings.add(mntmRentalRate);
		
		JMenuItem mntmRentalPerios = new JMenuItem("Thời gian thuê cho loại đĩa");
		mntmRentalPerios.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnSettings.add(mntmRentalPerios);
		
		JMenu mnReport = new JMenu("Báo cáo");
		mnReport.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnReport);
		
		JMenuItem mntmReportCustomer = new JMenuItem("Khách hàng");
		mntmReportCustomer.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnReport.add(mntmReportCustomer);
		
		JMenuItem mntmReportTitle = new JMenuItem("Tiêu đề");
		mnReport.add(mntmReportTitle);
	}

	/**
	 * Tạo khung giao diện chính
	 */
	private void buildFrame() {
		this.setSize(1280, 768);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}

}
