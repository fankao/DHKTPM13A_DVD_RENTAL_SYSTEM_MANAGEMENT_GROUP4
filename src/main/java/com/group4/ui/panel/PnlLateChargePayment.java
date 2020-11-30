package com.group4.ui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import com.group4.business.ThanhToanPhiTreHanBUS;
import com.group4.entities.ChiTietThueTra;
import com.group4.entities.KhachHang;
import com.group4.ui.panel.PnlCustomerCommon.ItemClickListener;

public class PnlLateChargePayment extends JPanel {
	private static final long serialVersionUID = 1L;
	private static ThanhToanPhiTreHanBUS thanhToanPhiTreHanBUS;
	static {
		thanhToanPhiTreHanBUS = new ThanhToanPhiTreHanBUS();
	}
	private List<ChiTietThueTra> dsTreHan;
	private List<ChiTietThueTra> dsThanhToanTreHan = new ArrayList<ChiTietThueTra>();
	private KhachHang khachHangThanhToan;
	private JTable tblLateCharges;
	private JLabel lblTotalPrice;
	private JButton btnCancel;
	private JButton btnConfirm;
	private PnlCustomerCommon pnlCustomerCommon;
	private JCheckBox chkSelectAll;
	private JSpinner spnQuantity;

	/**
	 * Create the panel.
	 */
	public PnlLateChargePayment(KhachHang khachHang) {
		setLayout(new BorderLayout(0, 0));
		setSize(1270, 600);
		JLabel lbl_tieude = new JLabel("THANH TO\u00C1N PH\u00CD TR\u1EC4 H\u1EA0N");
		lbl_tieude.setFont(new Font("Tahoma", Font.BOLD, 24));
		lbl_tieude.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_tieude.setBackground(Color.LIGHT_GRAY);
		lbl_tieude.setForeground(new Color(160, 82, 45));
		add(lbl_tieude, BorderLayout.NORTH);

		JPanel pnl_main = new JPanel();
		add(pnl_main, BorderLayout.CENTER);
		pnl_main.setLayout(new BorderLayout(0, 0));

		pnlCustomerCommon = new PnlCustomerCommon(khachHang);
		pnl_main.add(pnlCustomerCommon);
		pnlCustomerCommon.setForeground(new Color(0, 0, 139));
		pnlCustomerCommon.setLayout(new BoxLayout(pnlCustomerCommon, BoxLayout.Y_AXIS));

		pnlCustomerCommon.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Kh\u00E1ch H\u00E0ng",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
		pnl_main.add(pnlCustomerCommon, BorderLayout.NORTH);

		JPanel pnl_phitrehen = new JPanel();
		pnl_phitrehen.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"Ph\u00ED Tr\u1EC5 H\u1EB9n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(106, 90, 205)));
		pnl_main.add(pnl_phitrehen);
		pnl_phitrehen.setLayout(new BorderLayout(0, 0));

		JPanel pnl_tablechiphitrehen = new JPanel();
		pnl_tablechiphitrehen
				.setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 20), new LineBorder(new Color(0, 0, 0), 2)));
		pnl_phitrehen.add(pnl_tablechiphitrehen, BorderLayout.CENTER);
		pnl_tablechiphitrehen.setLayout(null);

		chkSelectAll = new JCheckBox("Thanh to\u00E1n t\u1EA5t c\u1EA3");
		chkSelectAll.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chkSelectAll.setBounds(10, 399, 208, 31);
		pnl_tablechiphitrehen.add(chkSelectAll);

		JLabel lbl_thanhtoanmotphan = new JLabel("Thanh to\u00E1n m\u1ED9t ph\u1EA7n:");
		lbl_thanhtoanmotphan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_thanhtoanmotphan.setBounds(407, 399, 212, 31);
		pnl_tablechiphitrehen.add(lbl_thanhtoanmotphan);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 992, 380);
		pnl_tablechiphitrehen.add(scrollPane);

		tblLateCharges = new JTable();
		tblLateCharges.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tblLateCharges.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		scrollPane.setViewportView(tblLateCharges);

		DefaultTableModel model = new DefaultTableModel() {
			public Class<?> getColumnClass(int column) {
				switch (column) {
				case 0:
					return Boolean.class;
				case 1:
					return String.class;
				case 2:
					return String.class;
				case 3:
					return String.class;
				case 4:
					return String.class;

				default:
					return String.class;
				}
			}
		};

		tblLateCharges.setModel(model);

		spnQuantity = new JSpinner();
		spnQuantity.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spnQuantity.setBounds(619, 399, 54, 31);
		pnl_tablechiphitrehen.add(spnQuantity);
		model.addColumn("Chọn");
		model.addColumn("Mã Đĩa");
		model.addColumn("Ngày thuê");
		model.addColumn("Ngày trả dự kiến");
		model.addColumn("Ngày trả thực tế");
		model.addColumn("Phí trể hạn");
		JPanel pnl_tongchiphitrehen = new JPanel();
		pnl_tongchiphitrehen.setPreferredSize(new Dimension(200, 10));
		pnl_tongchiphitrehen.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pnl_phitrehen.add(pnl_tongchiphitrehen, BorderLayout.EAST);
		pnl_tongchiphitrehen.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel pnl_tongtien = new JPanel();
		pnl_tongtien.setBorder(
				new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "T\u1ED5ng Ph\u00ED Tr\u1EC5 h\u1EA1n",
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnl_tongchiphitrehen.add(pnl_tongtien);
		pnl_tongtien.setLayout(new BorderLayout(0, 0));

		lblTotalPrice = new JLabel("0 đ");
		lblTotalPrice.setForeground(Color.RED);
		lblTotalPrice.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTotalPrice.setHorizontalAlignment(SwingConstants.CENTER);
		pnl_tongtien.add(lblTotalPrice);

		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(20, 20, 20, 20));
		pnl_tongchiphitrehen.add(panel_2);
		panel_2.setLayout(new GridLayout(3, 1, 10, 10));

		btnConfirm = new JButton("X\u00E1c Nh\u1EADn");
		panel_2.add(btnConfirm);
		btnConfirm.setFont(new Font("Tahoma", Font.PLAIN, 20));

		btnCancel = new JButton("H\u1EE7y B\u1ECF");
		panel_2.add(btnCancel);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JButton btnClose = new JButton("Thoát");
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(btnClose);

		if (khachHang != null) {
			dsTreHan = thanhToanPhiTreHanBUS.getDSThueTraTreHanTheoKH(khachHang.getId());
			hienDanhSachPhiTreHan(dsTreHan);
		}

		voHieuHoaTextFieldSpinner();

		// gán sự kiện cho Button
		ganSuKienChoButton();

		// Xử lý sự kiện chọn phí trễ hạn để thanh toán
		ganSuKienChonPhiTreHan();

		// gán sự kiện cho checkbox
		ganSuKienChoCheckbox();

		// gán sự kiện cho JSpinner
		ganSuKienChoJSpinner();

	}

	/**
	 * Xử lý sự liện chọn thanh toán một phần phí trễ hạn
	 */
	private void ganSuKienChoJSpinner() {
		spnQuantity.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				thietLapSoLuongPhiMuonTra(spnQuantity.getValue().toString());
				chonPhiTreHanCanThanhToan((int) spnQuantity.getValue());

			}
		});

		hienTongTienThanhToanPhiTreHan(dsThanhToanTreHan);

	}

	/**
	 * Hiện tông tiền thanh toán phí trễ hạn
	 * 
	 * @param ds: danh sách phí trễ hạn đã chọn
	 */
	private void hienTongTienThanhToanPhiTreHan(List<ChiTietThueTra> ds) {
		double tongTien = thanhToanPhiTreHanBUS.tinhTongTienPhiTreHan(ds);
		String tongTienStr = NumberFormat.getInstance(new Locale("vi", "VN")).format(tongTien);
		lblTotalPrice.setText(tongTienStr);

	}

	private void voHieuHoaTextFieldSpinner() {
		((JSpinner.DefaultEditor) spnQuantity.getEditor()).getTextField().setEditable(false);
	}

	private void ganSuKienChoCheckbox() {
		chkSelectAll.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (chkSelectAll.isSelected()) {
					dsThanhToanTreHan = new ArrayList<ChiTietThueTra>(dsTreHan);
					spnQuantity.setEnabled(false);

				} else {
					dsThanhToanTreHan.clear();
					spnQuantity.setEnabled(true);
				}
				chonPhiTreHanCanThanhToan(dsThanhToanTreHan.size());
				hienTongTienThanhToanPhiTreHan(dsThanhToanTreHan);

			}
		});

	}

	/**
	 * Chọn số lượng phí trễ hạn cần thanh toán
	 * 
	 * @param size: số lượng phí
	 */

	private void chonPhiTreHanCanThanhToan(int size) {
		if (size > 0) {
			for (int i = 0; i < size; i++)
				tblLateCharges.getModel().setValueAt(true, i, 0);
		} else {
			System.out.println("số lượng phí trễ hạn: " + dsTreHan.size());
			for (int i = 0; i < dsTreHan.size(); i++)
				tblLateCharges.getModel().setValueAt(false, i, 0);
		}

	}

	/**
	 * Xử lý sự kiện chọn phí trễ hạn để thanh toán
	 */
	private void ganSuKienChonPhiTreHan() {
		tblLateCharges.getModel().addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {
				int select = tblLateCharges.getSelectedRow();
				if (select == -1)
					return;

				if (((Boolean) tblLateCharges.getValueAt(select, e.getColumn())) == true) {
					dsThanhToanTreHan.add(dsTreHan.get(select));
				} else {
					dsThanhToanTreHan.remove(select);
				}

				hienDanhSachPhiTreHan(dsThanhToanTreHan);
			}
		});

	}

	/**
	 * Hiện danh sách trễ hạn
	 * 
	 * @param ds: danh sách trễ hạn
	 */
	private void hienDanhSachPhiTreHan(List<ChiTietThueTra> ds) {
		DefaultTableModel tableModel = (DefaultTableModel) tblLateCharges.getModel();
		tableModel.setRowCount(0);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		for (ChiTietThueTra ct : ds) {
			tableModel.addRow(new Object[] { false, ct.getDia().getId(), formatter.format(ct.getNgayThue()),
					formatter.format(ct.ngayTraDuKien()), formatter.format(ct.getNgayTra()), ct.getDia().phiTreHan() });
		}
	}

	/**
	 * Gán sư kiện cho button
	 */
	private void ganSuKienChoButton() {
		pnlCustomerCommon.setItemClickListener(new ItemClickListener() {

			@Override
			public void onClick(ActionEvent e, KhachHang khachHang) {
				khachHangThanhToan = khachHang;
				dsTreHan = thanhToanPhiTreHanBUS.getDSThueTraTreHanTheoKH(khachHangThanhToan.getId());
				hienDanhSachPhiTreHan(dsTreHan);

				spnQuantity.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0),
						Integer.valueOf(dsTreHan.size()), new Integer(1)));

				voHieuHoaTextFieldSpinner();

			}
		});

		btnConfirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				boolean daThanhToanPhiTreHan = thanhToanPhiTreHanBUS.ghiNhanThanhToanPhiTreHan(dsThanhToanTreHan);

				if (daThanhToanPhiTreHan) {
					dsThanhToanTreHan.clear();
					dsTreHan = thanhToanPhiTreHanBUS.getDSThueTraTreHanTheoKH(khachHangThanhToan.getId());
					hienDanhSachPhiTreHan(dsTreHan);
				}

			}
		});

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

	private void thietLapSoLuongPhiMuonTra(String obj) {
		int quantity = 0;
		try {
			quantity = Integer.parseInt(obj);
		} catch (NumberFormatException e2) {
			hienThongBao("Lỗi nhập liệu", "Số lượng phí trễ hạn muốn trả \n phải là số nguyên lớn hơn 0",
					JOptionPane.ERROR_MESSAGE);
			spnQuantity.setValue(new Integer(0));
		}
		if (quantity == 0) {
			hienThongBao("Cảnh báo", "Số lượng phí trễ hạn muốn trả \n phải là số nguyên lớn hơn 0",
					JOptionPane.WARNING_MESSAGE);
			return;
		}

		spnQuantity.setValue(quantity);
	}

	private List<ChiTietThueTra> getDsTreHan() {
		return dsTreHan;
	}

}
