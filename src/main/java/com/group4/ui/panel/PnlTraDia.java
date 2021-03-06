package com.group4.ui.panel;

import static com.group4.Injection.*;
import static com.group4.ui.panel.UtilsLayout.isInputFieldNotBlank;
import static com.group4.ui.panel.UtilsLayout.kichHoatButton;
import static com.group4.ui.panel.UtilsLayout.voHieuHoaButton;
import static com.group4.ui.panel.UtilsLayout.voHieuHoaTextField;
import static com.group4.ui.panel.UtilsLayout.xoaTrang;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.group4.business.ThanhToanPhiTreHanBUS;
import com.group4.business.ThueTraDiaBUS;
import com.group4.dao.IChiTietThueTraDAO;
import com.group4.dao.IDiaDAO;
import com.group4.dao.IKhachHangDAO;
import com.group4.dao.impl.ChiTietThueTraDAO;
import com.group4.dao.impl.DiaDAO;
import com.group4.dao.impl.KhachHangDAO;
import com.group4.entities.ChiTietThueTra;
import com.group4.entities.Dia;
import com.group4.entities.KhachHang;
import com.group4.entities.TrangThaiDia;
import com.group4.ui.ICloseUIListener;
import com.group4.ui.dialog.DlgGanDia;

public class PnlTraDia extends JPanel {
	private static final long serialVersionUID = 1L;
	private ICloseUIListener closeUIListener;
	private JTextField txtCustomerID;
	private JButton btnSearchDiaId;
	private JTextField txtKHID;
	private JButton btnXacNhan;
	private JTable tblListKH;
	private JButton btnThoat;

	private List<Dia> dsDiaTra = new ArrayList<Dia>();
	private KhachHang khachHangTra;

	public PnlTraDia() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setSize(1270, 600);
		setLayout(new BorderLayout(0, 0));

		JPanel pnlTitle = new JPanel();
		FlowLayout fl_pnlTitle = (FlowLayout) pnlTitle.getLayout();
		fl_pnlTitle.setVgap(20);
		add(pnlTitle, BorderLayout.NORTH);

		JLabel lblTitle = new JLabel("TRẢ ĐĨA");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 25));
		pnlTitle.add(lblTitle);

		JPanel pnlMain = new JPanel();
		add(pnlMain, BorderLayout.CENTER);
		pnlMain.setLayout(new BorderLayout(0, 0));

		JPanel pnl_dia = new JPanel();
		pnl_dia.setBorder(new TitledBorder(
				new CompoundBorder(new LineBorder(new Color(0, 0, 0), 2), new EmptyBorder(5, 5, 5, 5)),
				"Th\u00F4ng tin \u0111\u0129a", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlMain.add(pnl_dia, BorderLayout.NORTH);
		pnl_dia.setLayout(new BoxLayout(pnl_dia, BoxLayout.Y_AXIS));

		JPanel pnl_timkiemMa = new JPanel();
		FlowLayout fl_pnl_timkiemMa = (FlowLayout) pnl_timkiemMa.getLayout();
		fl_pnl_timkiemMa.setAlignment(FlowLayout.LEFT);
		pnl_dia.add(pnl_timkiemMa);

		JLabel lbl_maDia = new JLabel("Mã Đĩa Trả");
		lbl_maDia.setFont(new Font("Dialog", Font.PLAIN, 20));
		pnl_timkiemMa.add(lbl_maDia);

		txtCustomerID = new JTextField();
		txtCustomerID.setFont(new Font("Dialog", Font.PLAIN, 20));
		pnl_timkiemMa.add(txtCustomerID);
		txtCustomerID.setColumns(15);

		btnSearchDiaId = new JButton("Xác nhận");
		btnSearchDiaId.setFont(new Font("Dialog", Font.PLAIN, 20));
		pnl_timkiemMa.add(btnSearchDiaId);

		JPanel pnlCenter = new JPanel();
		pnlMain.add(pnlCenter, BorderLayout.CENTER);
		pnlCenter.setLayout(new BorderLayout(0, 0));

		JPanel pnlTraDia = new JPanel();
		pnlCenter.add(pnlTraDia, BorderLayout.CENTER);
		pnlTraDia.setLayout(new BorderLayout(0, 0));

		JPanel pnlGandia = new JPanel();
		pnlTraDia.add(pnlGandia, BorderLayout.CENTER);
		pnlGandia.setLayout(new BoxLayout(pnlGandia, BoxLayout.Y_AXIS));

		JPanel pnlThoat = new JPanel();
		FlowLayout fl_pnlthoat = (FlowLayout) pnlThoat.getLayout();
		fl_pnlthoat.setAlignment(FlowLayout.RIGHT);
		pnlGandia.add(pnlThoat);

		btnThoat = new JButton("Thoát");
		btnThoat.setFont(new Font("Dialog", Font.PLAIN, 20));
		pnlThoat.add(btnThoat);

		ganSuKienButton();
	}

	/**
	 * Thiết lập sự kiện cho button
	 */
	private void ganSuKienButton() {

		btnSearchDiaId.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (isInputFieldNotBlank(PnlTraDia.this, txtCustomerID)) {
					Long diskId = null;
					try {
						diskId = Long.valueOf(txtCustomerID.getText());
					} catch (NumberFormatException ne) {
						hienThongBao("Lỗi nhập liệu", "Mã đĩa là số nguyên lớn hơn 0", JOptionPane.ERROR_MESSAGE);
						txtCustomerID.requestFocus();
						return;
					}
					if (diskId == 0) {
						hienThongBao("Thông Báo", "Mã đĩa phải là số nguyên lớn hơn 0", JOptionPane.ERROR_MESSAGE);
						txtCustomerID.requestFocus();
						return;
					}
					ChiTietThueTra dsTraDia = null;
					try {
						dsTraDia = chiTietThueTraDAO.getmotCTTTChuaTraDiaTheoDia(diskId);
					} catch (Exception e2) {
						hienThongBao("Thông Báo", "Đĩa Chưa Được Thuê", JOptionPane.ERROR_MESSAGE);
						txtCustomerID.requestFocus();
						return;
					}
					System.out.println("------------------------------------------------------");
					System.out.println("dasdasds+" + dsTraDia);
					System.out.println("------------------------------------------------------");

					if (dsTraDia != null) {
						Dia diaTra = diaDAO.findById(diskId);
						KhachHang kh = dsTraDia.getKhachHang();

						System.out.println("dasdsa" + dsTraDia.getKhachHang());
						System.out.println("Day la Khach Hang" + kh.toString());

						themDiaVaoDSTra(diaTra);

						// update du lieu
						diaTra.setTrangThai(TrangThaiDia.ON_SHEFT);
						diaDAO.update(diaTra);

						dsTraDia.setNgayTra(LocalDate.now());
						chiTietThueTraDAO.update(dsTraDia);

						// so sanh ngay
						// ngay tra it hon ngay hien tai
						System.out.println(dsTraDia.getNgayToiHan().toString());
						if (dsTraDia.getNgayToiHan().compareTo(LocalDate.now()) < 0) {
							themPhiTreHen(dsDiaTra);
						}
						hienThongTinGanDia(diaTra);
						txtCustomerID.setText("");

					} else {
						hienThongBao("Lỗi tìm kiếm", "Đĩa Chưa Được Thuê", JOptionPane.ERROR_MESSAGE);
						txtCustomerID.requestFocus();
						return;
					}

				}
			}

		});

		btnThoat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				closeUIListener.onCloseUI(e);
			}
		});

	}

	/**
	 * Hiện thông tin gán đĩa
	 * 
	 * @param diaTra
	 */
	protected void hienThongTinGanDia(Dia diaTra) {
		DlgGanDia dlgGanDia = new DlgGanDia(diaTra);
		dlgGanDia.setCloseUIListener(new ICloseUIListener() {

			@Override
			public void onCloseUI(ActionEvent e) {
				dlgGanDia.dispose();
			}
		});

		dlgGanDia.setVisible(true);

	}

	/**
	 * Hiện thông báo
	 * 
	 * @param msg: thông báo cần hiển thị
	 */
	private void hienThongBao(String title, String msg, int msgType) {
		JLabel label = new JLabel(msg);
		label.setFont(new Font("Arial", Font.BOLD, 18));
		JOptionPane.showMessageDialog(this, label, title, msgType);

	}

	/**
	 * Thêm Phí Trễ Hẹn
	 * 
	 * @param
	 */
	private void themPhiTreHen(List<Dia> dsDiaTra) {
		// TODO Auto-generated method stub

		double totalPrice = thueTraDiaBUS.tinhTongTienThueDia(new HashSet<Dia>(dsDiaTra));

		double phitrehen = dsDiaTra.get(dsDiaTra.size() - 1).getLoaiDia().getPhiTreHan();

		double tongTien = totalPrice + phitrehen;

		String tongTienString = NumberFormat.getCurrencyInstance(new Locale("vi", "VN")).format(tongTien);

		hienThongBao("Thêm Phí Trễ Hẹn", " Phí Trễ Hẹn Lần Trước Là" + String.valueOf(totalPrice) + " Và Lần Này Là "
				+ String.valueOf(phitrehen) + " -Tổng:" + tongTienString, JOptionPane.INFORMATION_MESSAGE);
	}

	private void returnDia(KhachHang kh, List<Dia> dsDiaThue, LocalDate ngaytra) {
		thueTraDiaBUS.traDia(kh, new HashSet<Dia>(dsDiaThue), ngaytra);
		hienThongBao("Thông báo", "Trả đĩa thành công", JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Đưa đĩa vào danh sách muốn thuê
	 * 
	 * @param diaThue: đĩa muốn thuê
	 */
	private void themDiaVaoDSTra(Dia diaTra) {
		dsDiaTra.add(diaTra);
	}

	public void setCloseUIListener(ICloseUIListener closeUIListener) {
		this.closeUIListener = closeUIListener;
	}

}
