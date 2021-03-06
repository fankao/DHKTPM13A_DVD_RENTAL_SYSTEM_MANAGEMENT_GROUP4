package com.group4.ui.panel;

import static com.group4.Injection.diaDAO;
import static com.group4.Injection.thanhToanPhiTreHanBUS;
import static com.group4.Injection.thueTraDiaBUS;
import static com.group4.ui.panel.UtilsLayout.hienThongBao;
import static com.group4.ui.panel.UtilsLayout.isInputFieldNotBlank;
import static com.group4.ui.panel.UtilsLayout.kichHoatButton;
import static com.group4.ui.panel.UtilsLayout.kichHoatTextField;
import static com.group4.ui.panel.UtilsLayout.voHieuHoaButton;
import static com.group4.ui.panel.UtilsLayout.voHieuHoaTextField;
import static com.group4.ui.panel.UtilsLayout.xoaTrang;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.group4.entities.ChiTietThueTra;
import com.group4.entities.Dia;
import com.group4.entities.KhachHang;
import com.group4.entities.TrangThaiDia;
import com.group4.ui.ICloseUIListener;
import com.group4.ui.dialog.DlgThongBaoPhiTreHan;

public class PnlRentDisk extends JPanel {

	private static final long serialVersionUID = 1L;

	private ICloseUIListener closeUIListener;

	private List<Dia> dsDiaThue = new ArrayList<Dia>();
	private KhachHang khachHangThueDia;

	private JLabel lblDateRent;
	private JTextField txtDiskID;
	private JTable tblListDisk;
	private JButton btnClose;
	private JButton btnCancel;
	private JButton btnConfirm;
	private JLabel lblTotalPrice;
	private PnlCustomerCommon pnlCustomerCommon;
	private JButton btnRentDisk;
	private JPanel pnlDateRent;
	private JButton btnDeleteDisk;

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
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
		pnlTitle.add(lblTitle);

		JPanel pnlMain = new JPanel();
		add(pnlMain, BorderLayout.CENTER);
		pnlMain.setLayout(new BorderLayout(0, 0));

		JPanel pnlCustomer = new JPanel();
		pnlCustomer.setBorder(
				new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 2), new EmptyBorder(5, 5, 5, 5)),
						"Th\u00F4ng tin kh\u00E1ch h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null,
						new Color(0, 0, 0)));
		pnlMain.add(pnlCustomer, BorderLayout.NORTH);
		pnlCustomer.setLayout(new BoxLayout(pnlCustomer, BoxLayout.Y_AXIS));

		pnlDateRent = new JPanel();
		FlowLayout fl_pnlDateRent = (FlowLayout) pnlDateRent.getLayout();
		fl_pnlDateRent.setAlignment(FlowLayout.LEFT);
		pnlCustomer.add(pnlDateRent);

		JLabel lblDateRentTitle = new JLabel("Ngày thuê đĩa: ");
		lblDateRentTitle.setFont(new Font("Dialog", Font.PLAIN, 20));
		pnlDateRent.add(lblDateRentTitle);

		lblDateRent = new JLabel("20/10/2020");
		lblDateRent.setFont(new Font("Dialog", Font.BOLD, 20));
		pnlDateRent.add(lblDateRent);

		pnlCustomerCommon = new PnlCustomerCommon(null);
		pnlCustomer.add(pnlCustomerCommon);
		pnlCustomerCommon.setLayout(new BoxLayout(pnlCustomerCommon, BoxLayout.Y_AXIS));

		JPanel pnlCenter = new JPanel();
		pnlMain.add(pnlCenter, BorderLayout.CENTER);
		pnlCenter.setLayout(new BorderLayout(0, 0));

		JPanel pnlOperation = new JPanel();
		pnlCenter.add(pnlOperation, BorderLayout.EAST);
		pnlOperation.setLayout(new BoxLayout(pnlOperation, BoxLayout.Y_AXIS));

		JPanel pnlButton = new JPanel();
		pnlButton.setBorder(new CompoundBorder(new EmptyBorder(10, 0, 0, 0),
				new CompoundBorder(new LineBorder(new Color(0, 0, 0), 2), new EmptyBorder(5, 5, 5, 5))));
		pnlOperation.add(pnlButton);
		pnlButton.setLayout(new GridLayout(3, 1, 0, 0));

		btnConfirm = new JButton("Xác nhận");
		pnlButton.add(btnConfirm);
		btnConfirm.setEnabled(false);
		btnConfirm.setFont(new Font("Tahoma", Font.PLAIN, 20));

		btnCancel = new JButton("Huỷ bỏ");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlButton.add(btnCancel);

		btnClose = new JButton("Thoát");
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlButton.add(btnClose);

		JPanel pnlTotalPrice = new JPanel();
		pnlTotalPrice
				.setBorder(new CompoundBorder(new EmptyBorder(20, 0, 0, 0), new LineBorder(new Color(0, 0, 0), 2)));
		pnlOperation.add(pnlTotalPrice);

		JLabel lblTotalPriceTitle = new JLabel("Tổng tiền thuê đĩa");
		lblTotalPriceTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalPriceTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));

		lblTotalPrice = new JLabel(" 0 đ");
		lblTotalPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalPrice.setForeground(Color.RED);
		lblTotalPrice.setFont(new Font("Tahoma", Font.BOLD, 20));
		GroupLayout gl_pnlTotalPrice = new GroupLayout(pnlTotalPrice);
		gl_pnlTotalPrice.setHorizontalGroup(gl_pnlTotalPrice.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnlTotalPrice.createSequentialGroup().addGap(20)
						.addComponent(lblTotalPriceTitle, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE).addGap(20))
				.addGroup(gl_pnlTotalPrice.createSequentialGroup().addGap(96)
						.addComponent(lblTotalPrice, GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE).addGap(85)));
		gl_pnlTotalPrice.setVerticalGroup(gl_pnlTotalPrice.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnlTotalPrice.createSequentialGroup().addGap(73)
						.addComponent(lblTotalPriceTitle, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addGap(18).addComponent(lblTotalPrice).addContainerGap(118, Short.MAX_VALUE)));
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
		lblDiskID.setFont(new Font("Dialog", Font.PLAIN, 20));
		pnlDiskID.add(lblDiskID);

		txtDiskID = new JTextField();
		txtDiskID.setEditable(false);
		txtDiskID.setFont(new Font("Dialog", Font.PLAIN, 20));
		pnlDiskID.add(txtDiskID);
		txtDiskID.setColumns(15);

		btnRentDisk = new JButton("Thêm");
		btnRentDisk.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlDiskID.add(btnRentDisk);

		JPanel pnlListDisk = new JPanel();
		pnlRentDisk.add(pnlListDisk, BorderLayout.CENTER);
		pnlListDisk.setLayout(new BorderLayout(0, 0));

		JScrollPane scrListDisk = new JScrollPane();
		pnlListDisk.add(scrListDisk, BorderLayout.CENTER);

		tblListDisk = new JTable();
		tblListDisk.setRowHeight(20);
		tblListDisk.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblListDisk.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tblListDisk.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 \u0111\u0129a", "Ti\u00EAu \u0111\u1EC1", "Lo\u1EA1i \u0111\u0129a",
						"Gi\u00E1 thu\u00EA", "Ng\u00E0y \u0111\u1EBFn h\u1EA1n" }) {
			Class[] columnTypes = new Class[] { Object.class, Object.class, Object.class, Double.class, Object.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}

			boolean[] columnEditables = new boolean[] { false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tblListDisk.getColumnModel().getColumn(0).setResizable(false);
		tblListDisk.getColumnModel().getColumn(0).setPreferredWidth(60);
		tblListDisk.getColumnModel().getColumn(1).setResizable(false);
		tblListDisk.getColumnModel().getColumn(1).setPreferredWidth(300);
		tblListDisk.getColumnModel().getColumn(2).setResizable(false);
		tblListDisk.getColumnModel().getColumn(3).setResizable(false);
		tblListDisk.getColumnModel().getColumn(3).setPreferredWidth(90);
		tblListDisk.getColumnModel().getColumn(4).setResizable(false);
		tblListDisk.getColumnModel().getColumn(4).setPreferredWidth(100);
		scrListDisk.setViewportView(tblListDisk);

		btnDeleteDisk = new JButton("Xoá");
		btnDeleteDisk.setEnabled(false);
		btnDeleteDisk.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlListDisk.add(btnDeleteDisk, BorderLayout.SOUTH);

		hienNgayThueDia();

		ganSuKienChoButton();
		ganSuKienChoTable();
	}

	private void ganSuKienChoTable() {
		tblListDisk.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				int select = tblListDisk.getSelectedRow();
				if (select == -1)
					return;
				kichHoatButton(btnDeleteDisk);

			}
		});

	}

	/**
	 * Hiện ngày thuê đĩa
	 */
	private void hienNgayThueDia() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		lblDateRent.setText(formatter.format(LocalDate.now()));
	}

	/**
	 * Thiết lập sự kiện cho button
	 */
	private void ganSuKienChoButton() {

		pnlCustomerCommon.setItemClickListener(new PnlCustomerCommon.ItemClickListener() {

			@Override
			public void onClick(ActionEvent e, KhachHang khachHang) {
				khachHangThueDia = khachHang;
				kichHoatTextField(txtDiskID);
				kichHoatButton(btnRentDisk);

			}
		});

		btnRentDisk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (!isInputFieldNotBlank(PnlRentDisk.this, txtDiskID)) {
					hienThongBao(PnlRentDisk.this, "Thông báo lỗi", "Mời nhập mã đĩa muốn thuê",
							JOptionPane.ERROR_MESSAGE);
					txtDiskID.requestFocus();
					return;
				}

				try {
					Long diaId = Long.valueOf(txtDiskID.getText());
					if (diaId == 0) {
						thongBaoLoiMaDia("Mã đĩa phải là số nguyên lớn hơn 0");
					}
					Dia diaThue = diaDAO.findById(diaId);
					if (khongTheThueDia(diaThue)) {
						thongBaoLoiMaDia("Đĩa này đã được thuê hoặc đặt giữ");
						return;
					}

					themDia(diaThue);

					kichHoatButton(btnConfirm);

				} catch (NumberFormatException e2) {
					thongBaoLoiMaDia("Mã đĩa phải là số nguyên lớn hơn 0");

				}

			}
		});

		btnDeleteDisk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Dia dia = dsDiaThue.get(tblListDisk.getSelectedRow());
				tblListDisk.clearSelection();
				xoaDiaKhoiDSThue(dia);

			}
		});

		// Xác nhận thuê đĩa
		btnConfirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				hienThongTinPhiTreHan(khachHangThueDia);
				thueDia(khachHangThueDia, dsDiaThue);
				resetDSDiaThue();

			}

		});

		// huỷ thuê đĩa
		btnCancel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int select = hienThongBaoXacNhan("Huỷ thực hiện", "Xác nhận huỷ thực hiện thuê đĩa");
				if (select != JOptionPane.YES_OPTION)
					return;

				huyThueDia();

			}
		});

		// Đóng giao diện thuê đĩa
		btnClose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int select = hienThongBaoXacNhan("Thoát chức năng", "Xác nhận thoát chức năng này?");
				if (select == JOptionPane.YES_OPTION) {
					closeUIListener.onCloseUI(e);
				}

			}
		});

	}

	/**
	 * hiện thông báo lỗi
	 * 
	 * @param msg
	 */
	protected void thongBaoLoiMaDia(String msg) {
		hienThongBao(PnlRentDisk.this, "Thông báo lỗi", msg, JOptionPane.ERROR_MESSAGE);
		txtDiskID.requestFocus();
		txtDiskID.selectAll();

	}

	/**
	 * huỷ thuê đĩa
	 */
	private void huyThueDia() {
		resetDSDiaThue();

		hienTongTienThueDia(dsDiaThue);

		xoaTrang(pnlCustomerCommon.getTxtCustomerID(), txtDiskID);

		pnlCustomerCommon.visibleCustomeInfo(false);

		kichHoatButton(pnlCustomerCommon.getBtnSearchCusId(), btnClose);

		kichHoatTextField(pnlCustomerCommon.getTxtCustomerID());

		voHieuHoaTextField(txtDiskID);

		voHieuHoaButton(btnCancel, btnConfirm, btnRentDisk,btnDeleteDisk);
	}

	/**
	 * Kiểm tra đĩa có thể thuê được không
	 * 
	 * @param diaThue: đĩa muốn thuê
	 * @return true: nếu trạng thái đĩa là
	 */
	private boolean khongTheThueDia(Dia diaThue) {
		return !(diaThue.getTrangThai() == TrangThaiDia.ON_SHEFT);
	}

	/**
	 * Hiện tổng tiền thuê đĩa
	 * 
	 * @param diaThue: dsa
	 */
	private void hienTongTienThueDia(List<Dia> dsDiaThue) {

		double totalPrice = thueTraDiaBUS.tinhTongTienThueDia(new HashSet<Dia>(dsDiaThue));

		String totalPriceStr = NumberFormat.getCurrencyInstance(new Locale("vi", "VN")).format(totalPrice);

		lblTotalPrice.setText(totalPriceStr);
	}

	/**
	 * Xoá đĩa khỏi danh sách thuê
	 * 
	 * @param dia: đĩa muốn xoá, nếu dia = null thì xoá hết danh sách
	 */
	private void xoaDiaKhoiDSThue(Dia dia) {
		if (dia == null) {
			dsDiaThue.clear();
			voHieuHoaButton(btnConfirm);
		}
		dsDiaThue.remove(dia);

		hienDSDiaThue(dsDiaThue);
	}

	/**
	 * Thông báo xác nhận thực hiện một công việc nào đó
	 * 
	 * @param title: tiêu đề thông báo
	 * @param msg:   thông điệp
	 * @return Yes: thực hiện / No: không thực hiện
	 */
	private int hienThongBaoXacNhan(String title, String msg) {
		JLabel label = new JLabel(msg);
		label.setFont(new Font("arial", Font.PLAIN, 18));
		return JOptionPane.showConfirmDialog(PnlRentDisk.this, label, title, JOptionPane.YES_NO_OPTION);
	}

	/**
	 * Chức năng thuê đĩa
	 * 
	 * @param kh:        khách hàng thuê đĩa
	 * @param dsDiaThue: danh sách đĩa thuê
	 */
	private void thueDia(KhachHang kh, List<Dia> dsDiaThue) {
		thueTraDiaBUS.xuLyThueDia(khachHangThueDia, new HashSet<Dia>(dsDiaThue));
		hienThongBao(this, "Thông báo", "Thuê đĩa thành công", JOptionPane.INFORMATION_MESSAGE);
		voHieuHoaButton(btnConfirm);
	}

	/**
	 * xoá sách danh sách đĩa thuê sau khi thuê thành công
	 */
	private void resetDSDiaThue() {
		dsDiaThue.clear();
		hienDSDiaThue(dsDiaThue);
		xoaTrang(txtDiskID);
	}

	/**
	 * Hiện Thông tin phí trễ hạn của khách hàng (nếu khách hàng trả đĩa trễ hạn)
	 * 
	 * @param cusId: mã khách hàng
	 */
	private void hienThongTinPhiTreHan(KhachHang khachHang) {
		// hiện thông tin phí trễ hạn nếu có
		List<ChiTietThueTra> dsTreHan = thanhToanPhiTreHanBUS.getDSThueTraTreHanTheoKH(khachHang.getId());
		if (dsTreHan.size() > 0) {
			new DlgThongBaoPhiTreHan(dsTreHan).setVisible(true);
		}

	}

	/**
	 * hiện danh sách đĩa muốn thuê
	 * 
	 * @param ds: danh sách đĩa
	 */
	private void hienDSDiaThue(List<Dia> ds) {
		DefaultTableModel tableModel = (DefaultTableModel) tblListDisk.getModel();
		tableModel.setRowCount(0);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		for (Dia dia : ds) {
			tableModel.addRow(new Object[] { dia.getId(), dia.getTuaDe().getTenTuaDe(),
					dia.getLoaiDia().getTenLoaiDia(), dia.getLoaiDia().getPhiThue(),
					formatter.format(LocalDate.now().plusDays(dia.getLoaiDia().getSoNgayThue())) });
		}

	}

	/**
	 * Thêm đĩa vào danh sách thuê
	 * 
	 * @param diaThue
	 */
	private void themDia(Dia diaThue) {
		dsDiaThue.add(diaThue);

		hienDSDiaThue(dsDiaThue);

		xoaTrang(txtDiskID);
	}

	public void setCloseUIListener(ICloseUIListener closeUIListener) {
		this.closeUIListener = closeUIListener;
	}

}
