package com.group4.ui.panel;
import static com.group4.Injection.*;
import static com.group4.ui.panel.UtilsLayout.*;

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
import javax.swing.DefaultListModel;
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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;

import com.group4.business.ThanhToanPhiTreHanBUS;
import com.group4.entities.ChiTietDatGiu;
import com.group4.entities.ChiTietThueTra;
import com.group4.entities.ChiTietThueTraID;
import com.group4.entities.KhachHang;
import com.group4.model.TaiKhoanModel;
import com.group4.ui.ICloseUIListener;
import com.group4.ui.panel.PnlCustomerCommon.ItemClickListener;

public class PnlLateChargePayment extends JPanel{
	private static final long serialVersionUID = 1L;
	private ICloseUIListener closeUIListener;
	private List<ChiTietThueTra> dsTreHan;
	private List<ChiTietThueTra> dsThanhToanTreHan = new ArrayList<ChiTietThueTra>();
	private List<ChiTietThueTra> dsHuyTreHan = new ArrayList<ChiTietThueTra>();
	private KhachHang khachHangThanhToan;
	private JTable tblLateCharges;
	private JLabel lblTotalPrice;
	private JButton btnCancel;
	private JButton btnConfirm;
	private PnlCustomerCommon pnlCustomerCommon;
	private JCheckBox chkSelectAll;
	private JSpinner spnQuantity;
	private JButton btnClose;
	private JButton btnCancelLateChargePayment;

	/**
	 * Create the panel.
	 */
	public PnlLateChargePayment(List<ChiTietThueTra> ds) {
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

		pnlCustomerCommon = new PnlCustomerCommon(getKhachHang(ds));
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
		chkSelectAll.setEnabled(false);
		chkSelectAll.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chkSelectAll.setBounds(10, 399, 208, 31);
		pnl_tablechiphitrehen.add(chkSelectAll);

		JLabel lbl_thanhtoanmotphan = new JLabel("Thanh to\u00E1n m\u1ED9t ph\u1EA7n:");
		lbl_thanhtoanmotphan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_thanhtoanmotphan.setBounds(407, 399, 212, 31);
		pnl_tablechiphitrehen.add(lbl_thanhtoanmotphan);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 924, 380);
		pnl_tablechiphitrehen.add(scrollPane);

		tblLateCharges = new JTable();
		tblLateCharges.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tblLateCharges.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		scrollPane.setViewportView(tblLateCharges);

		DefaultTableModel model = new DefaultTableModel() {
			private static final long serialVersionUID = 1L;

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
		spnQuantity.setEnabled(false);
		spnQuantity.setFont(new Font("Tahoma", Font.PLAIN, 20));
		spnQuantity.setBounds(619, 399, 54, 31);
		pnl_tablechiphitrehen.add(spnQuantity);
		model.addColumn("Chọn");
		model.addColumn("Mã Đĩa");
		model.addColumn("Ngày thuê");
		model.addColumn("Ngày trả dự kiến");
		model.addColumn("Ngày trả thực tế");
		model.addColumn("Phí trễ hạn");
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
		panel_2.setLayout(new GridLayout(4, 1, 10, 10));

		btnCancelLateChargePayment = new JButton("Hủy Phí Trễ Hẹn");
		btnCancelLateChargePayment.setEnabled(false);
		panel_2.add(btnCancelLateChargePayment);
		btnCancelLateChargePayment.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		btnConfirm = new JButton("X\u00E1c Nh\u1EADn");
		btnConfirm.setEnabled(false);
		panel_2.add(btnConfirm);
		btnConfirm.setFont(new Font("Tahoma", Font.PLAIN, 20));

		btnCancel = new JButton("H\u1EE7y B\u1ECF");
		panel_2.add(btnCancel);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 20));

		btnClose = new JButton("Thoát");
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(btnClose);
		
		if(TaiKhoanModel.admin == null) {
			btnCancelLateChargePayment.setVisible(false);
		}

		if (ds != null) {
			dsTreHan = thanhToanPhiTreHanBUS.getDSThueTraTreHanTheoKH(getKhachHang(ds).getId());
			khachHangThanhToan = getKhachHang(dsTreHan);
			hienDanhSachPhiTreHan(dsTreHan);
		}

		voHieuHoaTextFieldSpinner();

		// gán sự kiện cho Button
		ganSuKienChoButton();
		
		// Xử lý sự kiện chọn phí trễ hạn để thanh toán
		ganSuKienChonCheckBoxTable();

		// gán sự kiện cho checkbox
		ganSuKienChoCheckbox();

		// gán sự kiện cho JSpinner
		ganSuKienChoJSpinner();
		
		// Xu ly huy phi tre hen
		gansuKienHuyPhiTreHen();
		

	}
	// gan su kien
	private void gansuKienHuyPhiTreHen() {
		// TODO Auto-generated method stub
		tblLateCharges.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblLateCharges.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
					
					@Override
					public void valueChanged(ListSelectionEvent e) {
						int select = tblLateCharges.getSelectedRow();
						if (select != -1) {							
							dsHuyTreHan.add(dsTreHan.get(select));
						}
						if (dsHuyTreHan.size() == 0) {
							voHieuHoaButton(btnCancelLateChargePayment);
						} else {		
							kichHoatButton(btnCancelLateChargePayment);
						}
					}
		});	
	}

	/**
	 * Lấy thông tin khách hàng trễ hạn trả đĩa
	 * 
	 * @param ds: danh sách phí trễ hạn
	 * @return: KhachHang: thông tin khách hàng
	 */
	private KhachHang getKhachHang(List<ChiTietThueTra> ds) {
		if (ds == null) {
			return null;
		}
		return ds.get(0).getKhachHang();
	}

	/**
	 * Xử lý sự liện chọn thanh toán một phần phí trễ hạn
	 */
	private void ganSuKienChoJSpinner() {
		spnQuantity.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				int soLuong = (int) spnQuantity.getValue();
				if (soLuong < dsThanhToanTreHan.size()) {
					tblLateCharges.setValueAt(false, dsThanhToanTreHan.size() - 1, 0);
					dsThanhToanTreHan.remove(dsThanhToanTreHan.size() - 1);
				} else {
					chonPhiTreHanCanThanhToan(soLuong);
				}

				System.out.println("Số phí trễ hạn muốn trả: " + spnQuantity.getValue().toString());
				hienTongTienThanhToanPhiTreHan(dsThanhToanTreHan);

				if (dsThanhToanTreHan.size() > 0) {
					kichHoatButton(btnConfirm);
					voHieuHoaButton(btnCancelLateChargePayment);
				} else {
					voHieuHoaButton(btnConfirm);
					voHieuHoaButton(btnCancelLateChargePayment);
				}
			}
		});

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

	/**
	 * Xử lý sự kiện khi chọn check box All
	 */
	private void ganSuKienChoCheckbox() {
		chkSelectAll.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (chkSelectAll.isSelected()) {
					chonCheckBoxAll();

				} else {
					boChonCheckboxAll();
				}
				chonPhiTreHanCanThanhToan(dsThanhToanTreHan.size());
				hienTongTienThanhToanPhiTreHan(dsThanhToanTreHan);
			}

		});

	}

	/**
	 * Bỏ chọn checkbox thanh toán tất cả
	 */
	private void boChonCheckboxAll() {
		dsThanhToanTreHan.clear();
		spnQuantity.setEnabled(true);
		voHieuHoaButton(btnConfirm);
		voHieuHoaButton(btnCancelLateChargePayment);
	}

	/**
	 * chọn checkbox thanh toán tất cả
	 */
	private void chonCheckBoxAll() {
		dsThanhToanTreHan = new ArrayList<ChiTietThueTra>(dsTreHan);
		spnQuantity.setEnabled(false);
		kichHoatButton(btnConfirm);
		voHieuHoaButton(btnCancelLateChargePayment);
	}

	/**
	 * Chọn số lượng phí trễ hạn cần thanh toán
	 * 
	 * @param size: số lượng phí
	 */

	private void chonPhiTreHanCanThanhToan(int size) {
		if (size > 0) {
			dsThanhToanTreHan.clear();
			for (int i = 0; i < size; i++) {
				tblLateCharges.getModel().setValueAt(true, i, 0);
				dsThanhToanTreHan.add(dsTreHan.get(i));
			}
		} else {
			for (int i = 0; i < dsTreHan.size(); i++) {
				tblLateCharges.getModel().setValueAt(false, i, 0);
			}
		}

	}

	/**
	 * Xử lý sự kiện chọn phí trễ hạn để thanh toán
	 */
	private void ganSuKienChonCheckBoxTable() {
		tblLateCharges.getModel().addTableModelListener(new TableModelListener() {

			@Override
			public void tableChanged(TableModelEvent e) {
				int select = tblLateCharges.getSelectedRow();
				if (select == -1)
					return;
				System.out.println("Check box table is clicked: "+select+"");
				if (((Boolean) tblLateCharges.getValueAt(select, e.getColumn())) == true) {
					dsThanhToanTreHan.add(dsTreHan.get(select));
					dsHuyTreHan.remove(dsTreHan.get(select));
					if (dsHuyTreHan.size() == 0) {
						voHieuHoaButton(btnCancelLateChargePayment);
					}
				} else {
					dsThanhToanTreHan.remove(select);
				}
				
				if (dsThanhToanTreHan.size() == 0) {
					voHieuHoaButton(btnConfirm);
				} else {
					kichHoatButton(btnConfirm);
					voHieuHoaButton(btnCancelLateChargePayment);
				}

				thietLapSoLuongPhiMuonTra(dsThanhToanTreHan.size());
				hienTongTienThanhToanPhiTreHan(dsThanhToanTreHan);
				tblLateCharges.clearSelection();

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
					formatter.format(ct.getNgayToiHan()), formatter.format(ct.getNgayTra()), ct.getDia().phiTreHan() });
		}

		setVisibleCacLuaChonThanhToan(true);
	}

	/**
	 * Gán sư kiện cho button
	 */
	private void ganSuKienChoButton() {
		pnlCustomerCommon.setItemClickListener(new ItemClickListener() {

			@Override
			public void onClick(ActionEvent e, KhachHang khachHang) {
				khachHangThanhToan = khachHang;
				System.out.println(khachHangThanhToan.getId());
				hienChiTietPhiTreHan(khachHangThanhToan);

			}

		});

		btnCancelLateChargePayment.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (dsHuyTreHan.size() == 0) {
					hienThongBao(PnlLateChargePayment.this, "Thông báo", "Chưa chọn phí trễ hạn cần hủy",
							JOptionPane.WARNING_MESSAGE);
					return;
				}
					thucHienHuyPhiTreHan();

			}

			
		});
		
		btnConfirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (dsThanhToanTreHan.size() == 0) {
					hienThongBao(PnlLateChargePayment.this, "Thông báo", "Chưa chọn phí trễ hạn cần thanh toán",
							JOptionPane.WARNING_MESSAGE);
					return;
				}

				int select = hienThongBaoXacNhan(PnlLateChargePayment.this, "Xác nhận",
						"Xác nhận thanh toán phí trễ hạn ?");
				if (select == JOptionPane.YES_OPTION) {
					thucHienThanhToanPhiTreHan();
					voHieuHoaButton(btnCancelLateChargePayment);
				}

			}
		});

		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int confirm = hienThongBaoXacNhan(PnlLateChargePayment.this, "Xác nhận huỷ",
						"Xác nhận huỷ việc thanh toán phí trễ hạn ?");
				if (confirm == JOptionPane.YES_OPTION) {
					huyThanhToanPhiTreHan();
				}

			}
		});

		btnClose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int confirm = hienThongBaoXacNhan(PnlLateChargePayment.this, "Xác nhận thoát",
						"Xác nhận thoát chức năng thanh toán phí trễ hạn ?");
				if (confirm == JOptionPane.YES_OPTION) {
					closeUIListener.onCloseUI(e);
					
				}

			}
		});

	}
	/**
	 * Huỷ phí trễ hạn
	 */
	private void thucHienHuyPhiTreHan() {
	
		int selectIndex = -1;
		selectIndex = tblLateCharges.getSelectedRow();
		if (selectIndex >= 0) {
			ChiTietThueTra ct = dsTreHan.get(selectIndex);
			
			int option = hienThongBaoXacNhan(PnlLateChargePayment.this, "Thông báo xác nhận",
					"Bạn có muốn xóa phí trễ hẹn này này?");

			if (option == JOptionPane.YES_OPTION) {
				ThanhToanPhiTreHanBUS bus = new ThanhToanPhiTreHanBUS();
				if (bus.xoaChiTietThueTra(ct) == true) {
					dsTreHan = thanhToanPhiTreHanBUS.getDSThueTraTreHanTheoKH(khachHangThanhToan.getId());
					hienThongBao(this, "Thông báo", "Hủy phí trễ hạn thành công", JOptionPane.INFORMATION_MESSAGE);
					
					tblLateCharges.clearSelection();
					((DefaultTableModel) tblLateCharges.getModel()).removeRow(selectIndex);		
					
					
					hienDanhSachPhiTreHan(dsTreHan);
					resetCacLuaChonThanhToan();
					voHieuHoaButton(btnCancelLateChargePayment);

					if (dsTreHan.size() == 0) {
						huyThanhToanPhiTreHan();
					}
					
				}
			}
		}
		
	}
	
	/**
	 * Huỷ thanh thanh toán phí trễ hạn
	 */
	private void huyThanhToanPhiTreHan() {
		voHieuHoaButton(btnConfirm);
		voHieuHoaButton(btnCancelLateChargePayment);
		if (dsThanhToanTreHan.size() == 0) {
			dsTreHan.clear();
			hienDanhSachPhiTreHan(dsTreHan);
			pnlCustomerCommon.visibleCustomeInfo(false);
			setVisibleCacLuaChonThanhToan(false);
			voHieuHoaButton(btnCancel);
			khachHangThanhToan = null;

		} else {
			resetCacLuaChonThanhToan();
			resetDSPhiTreHan(dsTreHan);
		}

	}

	/**
	 * đặt lại bảng phí trễ hạn
	 * 
	 * @param ds
	 */
	private void resetDSPhiTreHan(List<ChiTietThueTra> ds) {
		dsThanhToanTreHan.clear();
		hienDanhSachPhiTreHan(ds);
		hienTongTienThanhToanPhiTreHan(dsThanhToanTreHan);
	}

	/**
	 * Thực hiện thanh toán phí trễ hạn
	 */
	private void thucHienThanhToanPhiTreHan() {
		boolean daThanhToanPhiTreHan = thanhToanPhiTreHanBUS.ghiNhanThanhToanPhiTreHan(dsThanhToanTreHan);
		if (daThanhToanPhiTreHan) {
			dsTreHan = thanhToanPhiTreHanBUS.getDSThueTraTreHanTheoKH(khachHangThanhToan.getId());
			hienThongBao(this, "Thông báo", "Thanh toán phí trễ hạn thành công", JOptionPane.INFORMATION_MESSAGE);
			resetDSPhiTreHan(dsTreHan);
		}
		resetCacLuaChonThanhToan();

		voHieuHoaButton(btnConfirm);

		if (dsTreHan.size() == 0) {
			huyThanhToanPhiTreHan();
		}
	}

	/**
	 * Đặt lại các lựa chọn thanh toán phí trễ hạn
	 */
	private void resetCacLuaChonThanhToan() {
		setVisibleCacLuaChonThanhToan(false);
		spnQuantity.setEnabled(true);
		chkSelectAll.setEnabled(true);
		chonPhiTreHanCanThanhToan(0);

	}

	/**
	 * Hiện thông tin về các phí trễ hạn của khách hàng
	 * 
	 * @param khachHang: khách hàng cần hiện thông tin
	 */
	private void hienChiTietPhiTreHan(KhachHang khachHang) {
		dsTreHan = thanhToanPhiTreHanBUS.getDSThueTraTreHanTheoKH(khachHang.getId());

		if (dsTreHan.size() == 0) {
			hienThongBao(this, "Thông báo", "Khách hàng " + khachHang.getHoVaTen() + " chưa có phí trễ hạn",
					JOptionPane.INFORMATION_MESSAGE);
			pnlCustomerCommon.visibleCustomeInfo(false);
			return;
		}

		hienDanhSachPhiTreHan(dsTreHan);

		spnQuantity.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), Integer.valueOf(dsTreHan.size()),
				new Integer(1)));

		setVisibleCacLuaChonThanhToan(true);
		voHieuHoaTextFieldSpinner();

	}

	private void setVisibleCacLuaChonThanhToan(boolean isActive) {
		if (isActive == false) {
			chkSelectAll.setSelected(false);
			setSpinnerSoLuong(0, dsTreHan.size());
		}
		chkSelectAll.setEnabled(isActive);
		spnQuantity.setEnabled(isActive);
	}

	/**
	 * Hiện số phí trễ hạn muốn trả
	 * 
	 * @param obj: spps
	 */
	private void thietLapSoLuongPhiMuonTra(int obj) {
		setSpinnerSoLuong(obj, dsThanhToanTreHan.size());
	}

	private void setSpinnerSoLuong(int obj, int size) {
		spnQuantity.setModel(new SpinnerNumberModel(obj, 0, size, 1));
		voHieuHoaTextFieldSpinner();
	}

	public void setCloseUIListener(ICloseUIListener closeUIListener) {
		this.closeUIListener = closeUIListener;
	}

		
		


}
