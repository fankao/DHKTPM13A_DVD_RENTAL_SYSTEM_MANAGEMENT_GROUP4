package com.group4.ui;

import static com.group4.ui.panel.UtilsLayout.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.group4.ui.panel.PnlLateChargePayment;
import com.group4.ui.panel.PnlManageDisk;
import com.group4.ui.panel.PnlQuanLyKhachHang;
import com.group4.ui.panel.PnlRentDisk;
import com.group4.ui.panel.PnlReservation;
import com.group4.ui.panel.PnlThietLapGiaThueChoDia;
import com.group4.ui.panel.PnlTraDia;

public class FrmMain extends JFrame {
	private static final long serialVersionUID = 1L;
	private boolean isProcessingBusiness;

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
	private JMenuItem mntmProccessReservation;
	private JMenuItem mntmCancelReservation;
	private JMenuItem mntmProccessLateChargePayment;
	private JMenuItem mntmCancelLateCharge;
	private JMenuItem mntmLogin;
	private JMenuItem mntmLogout;
	private JMenu mnAdmin;

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

		mnLateChargesPayment = new JMenu("Phí trễ hạn");
		mnLateChargesPayment.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnLateChargesPayment);

		mntmProccessLateChargePayment = new JMenuItem("Thanh toán phí trễ hạn");
		mntmProccessLateChargePayment.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnLateChargesPayment.add(mntmProccessLateChargePayment);

		mntmCancelLateCharge = new JMenuItem("Huỷ phí trễ hạn");
		mntmCancelLateCharge.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnLateChargesPayment.add(mntmCancelLateCharge);

		mnReservation = new JMenu("Đặt đĩa");
		mnReservation.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnReservation);

		mntmProccessReservation = new JMenuItem("Tiến hành đặt đĩa");
		mntmProccessReservation.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnReservation.add(mntmProccessReservation);

		mntmCancelReservation = new JMenuItem("Huỷ đặt đĩa");
		mntmCancelReservation.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnReservation.add(mntmCancelReservation);

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

		mntmReportTitle = new JMenuItem("Tựa đề của đĩa");
		mntmReportTitle.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnReport.add(mntmReportTitle);

		mnAdmin = new JMenu("Tài khoản");
		mnAdmin.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		menuBar.add(mnAdmin);

		mntmLogin = new JMenuItem("Đăng nhập");
		mntmLogin.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnAdmin.add(mntmLogin);

		mntmLogout = new JMenuItem("Đăng xuất");
		mntmLogout.setFont(new Font("Segoe UI", Font.PLAIN, 18));
		mnAdmin.add(mntmLogout);

		setEventForMenu();
		setEventWhenClickClose();
	}

	/**
	 * Xử lý sự kiện đóng màn hình
	 */
	private void setEventWhenClickClose() {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {

				if (isProcessingBusiness) {
					hienThongBao(FrmMain.this, "Thông báo cảnh báo",
							"Đang thực hiện một chức năng không thể thoát ứng dụng", JOptionPane.WARNING_MESSAGE);
					return;
				}

				int confirm = hienThongBaoXacNhan(FrmMain.this, "Thông báo xác nhận", "Xác nhận thoát ứng dụng ?");
				if (confirm == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
			}
		});

	}

	private void setEventForMenu() {
		// hiện giao diện thuê đĩa
		mnRentDisk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PnlRentDisk pnlRentDisk = new PnlRentDisk();
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
		// TODO: hiện giao diện trả đĩa
		mnReturnDisk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				PnlTraDia pnlTraDia = new PnlTraDia();
				openWorkUI(pnlTraDia);
				pnlTraDia.setCloseUIListener(new ICloseUIListener() {

					@Override
					public void onCloseUI(ActionEvent e) {
						closeWorkUI(pnlTraDia);

					}
				});
				super.mouseClicked(e);
			}
		});

		mntmProccessLateChargePayment.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PnlLateChargePayment pnlLateChargePayment = new PnlLateChargePayment(null);
				openWorkUI(pnlLateChargePayment);
				pnlLateChargePayment.setCloseUIListener(new ICloseUIListener() {

					@Override
					public void onCloseUI(ActionEvent e) {
						closeWorkUI(pnlLateChargePayment);

					}
				});

			}
		});

		// hiện giao diện quản lý đĩa
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

		mntmCustomer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PnlQuanLyKhachHang pnlQuanLyKhachHang = new PnlQuanLyKhachHang();
				openWorkUI(pnlQuanLyKhachHang);
				pnlQuanLyKhachHang.setCloseUIListener(new ICloseUIListener() {

					@Override
					public void onCloseUI(ActionEvent e) {
						closeWorkUI(pnlQuanLyKhachHang);

					}
				});

			}
		});
		mntmProccessReservation.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PnlReservation pnlReservation = new PnlReservation();
				openWorkUI(pnlReservation);
				pnlReservation.setCloseUIListener(new ICloseUIListener() {

					@Override
					public void onCloseUI(ActionEvent e) {
						closeWorkUI(pnlReservation);

					}
				});

			}
		});

		mntmRentalRate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PnlThietLapGiaThueChoDia pnlThietLapGiaThueChoLoaiDia = new PnlThietLapGiaThueChoDia();
				openWorkUI(pnlThietLapGiaThueChoLoaiDia);
				pnlThietLapGiaThueChoLoaiDia.setCloseUIListener(new ICloseUIListener() {

					@Override
					public void onCloseUI(ActionEvent e) {
						closeWorkUI(pnlThietLapGiaThueChoLoaiDia);
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
		mnReservation.setEnabled(isEnable);
		mnManage.setEnabled(isEnable);
		mnLateChargesPayment.setEnabled(isEnable);
		mnReport.setEnabled(isEnable);
		mnAdmin.setEnabled(isEnable);

		if (isEnable == false) {
			isProcessingBusiness = true;
		}else {
			isProcessingBusiness = false;
		}
	}

	/**
	 * Tạo khung giao diện chính
	 */
	private void buildFrame() {
		this.setSize(1280, 768);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setLocationRelativeTo(null);
	}

}
