package com.group4.ui;

import static com.group4.ui.panel.UtilsLayout.hienThongBao;
import static com.group4.ui.panel.UtilsLayout.hienThongBaoXacNhan;

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
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.group4.dao.impl.TaiKhoanDAO;
import com.group4.model.TaiKhoanModel;
import com.group4.ui.dialog.DlgLogin;

import com.group4.ui.panel.PnlBaoCaoTuaDe;

import com.group4.ui.panel.PnlCustomerReportUI;
import com.group4.ui.panel.PnlLateChargePayment;
import com.group4.ui.panel.PnlManageDisk;
import com.group4.ui.panel.PnlManagerTitle;
import com.group4.ui.panel.PnlQuanLyKhachHang;
import com.group4.ui.panel.PnlRentDisk;
import com.group4.ui.panel.PnlReservation;
import com.group4.ui.panel.PnlThietLapGiaThueChoDia;
import com.group4.ui.panel.PnlTraDia;

import com.group4.ui.panel.PnlUpdateTimeRent;

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
	private JMenuItem mntmManagerTitle;
	private JMenu mnAdmin;
	private JMenu mnSettings;

	public FrmMain(String title) {
		super(title);
		buildFrame();
		buildComponentUi();
	}

	/**
	 * Tạo khung giao diện chính
	 */
	private void buildFrame() {
		this.setSize(1280, 768);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
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

		mnSettings = new JMenu("Thiết lập");
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

		if (TaiKhoanModel.admin == null) {
			updateUIForNotAdmin();

		} else {
			mnAdmin.setText("Xin chào, " + TaiKhoanModel.admin.getUsername());
			mntmLogout.setVisible(true);
			mntmLogin.setVisible(false);
		}

		setEventForMenu();
		setEventWhenClickClose();
	}

	private void updateUIForNotAdmin() {
		mntmLogout.setVisible(false);
		mntmDisk.setVisible(false);
		mnReport.setVisible(false);
		mnSettings.setVisible(false);
		mntmTitleDisk.setVisible(false);
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
				hienGDThueDia();
				super.mouseClicked(e);
			}

			private void hienGDThueDia() {
				PnlRentDisk pnlRentDisk = new PnlRentDisk();
				openWorkUI(pnlRentDisk);
				pnlRentDisk.setCloseUIListener(new ICloseUIListener() {

					@Override
					public void onCloseUI(ActionEvent e) {
						closeWorkUI(pnlRentDisk);

					}
				});
			}
		});
		// TODO: hiện giao diện trả đĩa
		mnReturnDisk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				hienGDTraDia();
				super.mouseClicked(e);
			}
		});

		mntmProccessLateChargePayment.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				hienGDThanhToanTreHan();

			}

		});

		// hiện giao diện quản lý đĩa
		mntmDisk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				hienGDDia();
			}
		});
		mntmCustomer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				hienGDKhachHang();

			}
		});
		mntmProccessReservation.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				hienGDDatDia();

			}
		});

		mntmRentalRate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				hienGDThietLapGiaThue();
			}
		});
		mntmTitleDisk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				hienQuanLyTuaDe();
			}
		});

		mntmReportCustomer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				hienBaoCaoKhachHang();

			}
		});

		mntmLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				DlgLogin dlgLogin = new DlgLogin();
				hienDialog(dlgLogin);
			}
		});
		mntmLogout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int confirm = hienThongBaoXacNhan(FrmMain.this, "Thông báo xác nhận",
						"Xác nhận đăng xuất khỏi giao diện admin");
				if (confirm == JOptionPane.NO_OPTION) {
					return;
				}
				TaiKhoanModel.admin = null;
				validateUI();

			}
		});

		mntmRentalPerios.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				PnlUpdateTimeRent pnlUpdateTime = new PnlUpdateTimeRent();
				openWorkUI(pnlUpdateTime);
				pnlUpdateTime.setCloseUIListener(new ICloseUIListener() {

					@Override
					public void onCloseUI(ActionEvent e) {
						closeWorkUI(pnlUpdateTime);
					}
				});
			}
		});
		mntmReportTitle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				PnlBaoCaoTuaDe pnlBaocao = new PnlBaoCaoTuaDe();
				openWorkUI(pnlBaocao);
				pnlBaocao.setCloseUIListener(new ICloseUIListener() {

					@Override
					public void onCloseUI(ActionEvent e) {
						closeWorkUI(pnlBaocao);
					}
				});
			}
		});
	}

	protected void validateUI() {
		dispose();
		try {
			// UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new FrmMain("Hệ thống quản lý cho thuê băng đĩa").setVisible(true);
			}
		});

	}

	private void hienDialog(DlgLogin dlgLogin) {
		dlgLogin.setVisible(true);
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
		} else {
			isProcessingBusiness = false;
		}
	}

	private void hienGDThanhToanTreHan() {
		PnlLateChargePayment pnlLateChargePayment = new PnlLateChargePayment(null);
		openWorkUI(pnlLateChargePayment);
		pnlLateChargePayment.setCloseUIListener(new ICloseUIListener() {

			@Override
			public void onCloseUI(ActionEvent e) {
				closeWorkUI(pnlLateChargePayment);

			}
		});
	}

	private void hienBaoCaoKhachHang() {
		PnlCustomerReportUI customerReportUI = new PnlCustomerReportUI();
		openWorkUI(customerReportUI);
		customerReportUI.setCloseUIListener(new ICloseUIListener() {

			@Override
			public void onCloseUI(ActionEvent e) {
				closeWorkUI(customerReportUI);

			}
		});
	}

	private void hienQuanLyTuaDe() {
		PnlManagerTitle pnlManagerTitle = new PnlManagerTitle();
		openWorkUI(pnlManagerTitle);
		pnlManagerTitle.setCloseUIListener(new ICloseUIListener() {

			@Override
			public void onCloseUI(ActionEvent e) {
				closeWorkUI(pnlManagerTitle);
			}
		});
	}

	private void hienGDThietLapGiaThue() {
		PnlThietLapGiaThueChoDia pnlThietLapGiaThueChoLoaiDia = new PnlThietLapGiaThueChoDia();
		openWorkUI(pnlThietLapGiaThueChoLoaiDia);
		pnlThietLapGiaThueChoLoaiDia.setCloseUIListener(new ICloseUIListener() {

			@Override
			public void onCloseUI(ActionEvent e) {
				closeWorkUI(pnlThietLapGiaThueChoLoaiDia);
			}
		});
	}

	private void hienGDDatDia() {
		PnlReservation pnlReservation = new PnlReservation();
		openWorkUI(pnlReservation);
		pnlReservation.setCloseUIListener(new ICloseUIListener() {

			@Override
			public void onCloseUI(ActionEvent e) {
				closeWorkUI(pnlReservation);

			}
		});
	}

	private void hienGDKhachHang() {
		PnlQuanLyKhachHang pnlQuanLyKhachHang = new PnlQuanLyKhachHang();
		openWorkUI(pnlQuanLyKhachHang);
		pnlQuanLyKhachHang.setCloseUIListener(new ICloseUIListener() {

			@Override
			public void onCloseUI(ActionEvent e) {
				closeWorkUI(pnlQuanLyKhachHang);

			}
		});
	}

	private void hienGDDia() {
		PnlManageDisk pnlManageDisk = new PnlManageDisk();
		openWorkUI(pnlManageDisk);
		pnlManageDisk.setCloseUIListener(new ICloseUIListener() {

			@Override
			public void onCloseUI(ActionEvent e) {
				closeWorkUI(pnlManageDisk);

			}
		});
	}

	private void hienGDTraDia() {
		PnlTraDia pnlTraDia = new PnlTraDia();
		openWorkUI(pnlTraDia);
		pnlTraDia.setCloseUIListener(new ICloseUIListener() {

			@Override
			public void onCloseUI(ActionEvent e) {
				closeWorkUI(pnlTraDia);

			}
		});
	}

}
