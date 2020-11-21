package com.group4.ui;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import com.group4.ui.panel.PnlManageDisk;
import com.group4.ui.panel.PnlRentDisk;

public class FrmMain extends JFrame {
	private static final long serialVersionUID = 1L;
	private JMenu mnRentDisk;
	private JMenu mnReturnDisk;
	private JMenu mnLateChargesPayment;
	private JMenu mnManage;
	private JMenuItem mntmCustomer;
	private JMenuItem mntmTitleDisk;
	private JMenuItem mntmDisk;
	private JMenuItem mntmRentalRate;
	private JMenuItem mntmRentalPerios;
	private JMenuItem mntmReportCustomer;
	private JMenuItem mntmReportTitle;
	private JMenuBar menuBar;
	private JMenu mnReport;
	private JMenu mnReservation;

	public FrmMain(String title) {
		super(title);
		buildFrame();
		buildComponentUi();
	}

	/**
	 * Tạo các thành phần giao diện
	 */
	private void buildComponentUi() {
		buildMenu();

	}

	private void buildMenu() {
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		mnRentDisk = new JMenu("Thuê đĩa");
		mnRentDisk.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnRentDisk);

		mnReturnDisk = new JMenu("Trả đĩa");
		mnReturnDisk.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnReturnDisk);

		mnLateChargesPayment = new JMenu("Thanh toán phí trễ hạn");
		mnLateChargesPayment.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnLateChargesPayment);
		
		mnReservation = new JMenu("Đặt trước đĩa");
		mnReservation.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnReservation);

		mnManage = new JMenu("Quản lý");
		mnManage.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnManage);

		mntmCustomer = new JMenuItem("Khách hàng");
		mntmCustomer.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mnManage.add(mntmCustomer);

		mntmTitleDisk = new JMenuItem("Tựa đề");
		mntmTitleDisk.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mnManage.add(mntmTitleDisk);

		mntmDisk = new JMenuItem("Đĩa");
		mntmDisk.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mnManage.add(mntmDisk);

		JMenu mnSettings = new JMenu("Thiết lập");
		mnSettings.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		mnManage.add(mnSettings);

		mntmRentalRate = new JMenuItem("Giá thuê cho loại đĩa");
		mntmRentalRate.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnSettings.add(mntmRentalRate);

		mntmRentalPerios = new JMenuItem("Thời gian thuê cho loại đĩa");
		mntmRentalPerios.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnSettings.add(mntmRentalPerios);

		mnReport = new JMenu("Báo cáo");
		mnReport.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnReport);

		mntmReportCustomer = new JMenuItem("Khách hàng");
		mntmReportCustomer.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnReport.add(mntmReportCustomer);

		mntmReportTitle = new JMenuItem("Tiêu đề");
		mntmReportTitle.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnReport.add(mntmReportTitle);

		setEventForMenu();
	}

	private void setEventForMenu() {
		//hiện giao diện thuê đĩa
		mnRentDisk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PnlRentDisk pnlRentDisk = new PnlRentDisk()	;
				openWorkUI(pnlRentDisk);
				pnlRentDisk.setCloseUIListener(new ICloseUIListener() {
					
					@Override
					public void onCloseUI(ActionEvent e) {
						closeWorkUI(pnlRentDisk);
						
					}
				});
				super.mouseClicked(e);
			}
		});
		//TODO: hiện giao diện trả đĩa
		
		//hiện giao diện quản lý đĩa
		mntmDisk.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				PnlManageDisk pnlManageDisk = new PnlManageDisk();
				openWorkUI(pnlManageDisk);
				pnlManageDisk.setCloseUIListener(new ICloseUIListener() {
					
					@Override
					public void onCloseUI(ActionEvent e) {
						closeWorkUI(pnlManageDisk);
						
					}
				});
			}
		});
		

	
	}

	private void closeWorkUI(JPanel panel) {
		getContentPane().remove(panel);
		getContentPane().repaint();
		getContentPane().validate();
		enableMenu(true);
	}

	private void openWorkUI(JPanel panel) {
		getContentPane().add(panel);
		getContentPane().repaint();
		getContentPane().validate();
		enableMenu(false);

	}

	private void enableMenu(boolean isEnable) {
		mnRentDisk.setEnabled(isEnable);
		mnReturnDisk.setEnabled(isEnable);
		mnManage.setEnabled(isEnable);
		mnLateChargesPayment.setEnabled(isEnable);
		mnReport.setEnabled(isEnable);
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
