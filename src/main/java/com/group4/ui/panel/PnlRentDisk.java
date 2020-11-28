package com.group4.ui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import javax.swing.Box;
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
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.group4.business.ThanhToanPhiTreHanBUS;
import com.group4.business.ThueTraDiaBUS;
import com.group4.dao.IDiaDAO;
import com.group4.dao.IKhachHangDAO;
import com.group4.dao.impl.DiaDAO;
import com.group4.dao.impl.KhachHangDAO;
import com.group4.entities.ChiTietThueTra;
import com.group4.entities.Dia;
import com.group4.entities.KhachHang;
import com.group4.ui.ICloseUIListener;
import javax.swing.ListSelectionModel;

public class PnlRentDisk extends JPanel {

	private static final long serialVersionUID = 1L;

	private ICloseUIListener closeUIListener;

	private List<Dia> dsDiaThue = new ArrayList<Dia>();
	private KhachHang khachHangThueDia;

	private static IKhachHangDAO khachHangDAO;
	private static ThueTraDiaBUS thueTraDiaBUS;
	private static ThanhToanPhiTreHanBUS thanhToanPhiTreHanBUS;
	private static IDiaDAO diaDAO;

	static {
		khachHangDAO = new KhachHangDAO();
		thueTraDiaBUS = new ThueTraDiaBUS();
		thanhToanPhiTreHanBUS = new ThanhToanPhiTreHanBUS();
		diaDAO = new DiaDAO();
	}

	private JLabel lblDateRent;
	private JTextField txtCustomerID;
	private JTextField txtDiskID;
	private JTable tblListDisk;
	private JButton btnRentDisk;
	private JButton btnClose;
	private JButton btnCancel;
	private JButton btnConfirm;
	private JLabel lblTotalPrice;
	private JButton btnSearchCusId;
	private JLabel lblCustomerName;
	private JLabel lblCustomerPhone;
	private JLabel lblCustomerAddress;
	private JPanel pnlCustomerInfo;

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
		pnlCustomer.setBorder(
				new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 2), new EmptyBorder(5, 5, 5, 5)),
						"Th\u00F4ng tin kh\u00E1ch h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null,
						new Color(0, 0, 0)));
		pnlMain.add(pnlCustomer, BorderLayout.NORTH);
		pnlCustomer.setLayout(new BoxLayout(pnlCustomer, BoxLayout.Y_AXIS));

		JPanel pnlDateRent = new JPanel();
		FlowLayout fl_pnlDateRent = (FlowLayout) pnlDateRent.getLayout();
		fl_pnlDateRent.setAlignment(FlowLayout.LEFT);
		pnlCustomer.add(pnlDateRent);

		JLabel lblDateRentTitle = new JLabel("Ngày thuê đĩa: ");
		lblDateRentTitle.setFont(new Font("Dialog", Font.PLAIN, 20));
		pnlDateRent.add(lblDateRentTitle);

		lblDateRent = new JLabel("20/10/2020");
		lblDateRent.setFont(new Font("Dialog", Font.BOLD, 20));
		pnlDateRent.add(lblDateRent);

		JPanel pnlCustomerID = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnlCustomerID.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		pnlCustomer.add(pnlCustomerID);

		JLabel lblCustomerID = new JLabel("Mã khách hàng: ");
		lblCustomerID.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblCustomerID.setHorizontalAlignment(SwingConstants.LEFT);
		pnlCustomerID.add(lblCustomerID);

		txtCustomerID = new JTextField();
		txtCustomerID.setFont(new Font("Dialog", Font.PLAIN, 20));
		pnlCustomerID.add(txtCustomerID);
		txtCustomerID.setColumns(15);

		btnSearchCusId = new JButton("Xác nhận");
		btnSearchCusId.setFont(new Font("Dialog", Font.PLAIN, 20));
		pnlCustomerID.add(btnSearchCusId);

		pnlCustomerInfo = new JPanel();
		pnlCustomerInfo.setVisible(false);
		FlowLayout fl_pnlCustomerInfo = (FlowLayout) pnlCustomerInfo.getLayout();
		fl_pnlCustomerInfo.setAlignment(FlowLayout.LEFT);
		pnlCustomer.add(pnlCustomerInfo);

		JLabel lblCustomerNameTitle = new JLabel("Tên khách hàng:");
		lblCustomerNameTitle.setFont(new Font("Dialog", Font.PLAIN, 20));
		pnlCustomerInfo.add(lblCustomerNameTitle);

		lblCustomerName = new JLabel("Nguyễn Minh Chiến");
		lblCustomerName.setFont(new Font("Dialog", Font.BOLD, 20));
		pnlCustomerInfo.add(lblCustomerName);

		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalGlue.setPreferredSize(new Dimension(20, 0));
		pnlCustomerInfo.add(horizontalGlue);

		JLabel lblCustomePhoneTitle = new JLabel("Số điện thoại: ");
		lblCustomePhoneTitle.setFont(new Font("Dialog", Font.PLAIN, 20));
		pnlCustomerInfo.add(lblCustomePhoneTitle);

		lblCustomerPhone = new JLabel("038965214");
		lblCustomerPhone.setFont(new Font("Dialog", Font.BOLD, 20));
		pnlCustomerInfo.add(lblCustomerPhone);

		Component horizontalGlue_1 = Box.createHorizontalGlue();
		horizontalGlue_1.setPreferredSize(new Dimension(20, 0));
		pnlCustomerInfo.add(horizontalGlue_1);

		JLabel lblCustomerAddressTitle = new JLabel("Địa chỉ: ");
		lblCustomerAddressTitle.setFont(new Font("Dialog", Font.PLAIN, 20));
		pnlCustomerInfo.add(lblCustomerAddressTitle);

		lblCustomerAddress = new JLabel("Bình Phước");
		lblCustomerAddress.setFont(new Font("Dialog", Font.BOLD, 20));
		pnlCustomerInfo.add(lblCustomerAddress);

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
		btnConfirm.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlButton.add(btnConfirm);

		btnCancel = new JButton("Huỷ bỏ");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlButton.add(btnCancel);

		btnClose = new JButton("Đóng");
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlButton.add(btnClose);

		JPanel pnlTotalPrice = new JPanel();
		pnlTotalPrice
				.setBorder(new CompoundBorder(new EmptyBorder(20, 0, 0, 0), new LineBorder(new Color(0, 0, 0), 2)));
		pnlOperation.add(pnlTotalPrice);

		JLabel lblTotalPriceTitle = new JLabel("Tổng tiền thuê đĩa");
		lblTotalPriceTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTotalPriceTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));

		lblTotalPrice = new JLabel("200.000");
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
		txtDiskID.setEnabled(false);
		txtDiskID.setFont(new Font("Dialog", Font.PLAIN, 20));
		pnlDiskID.add(txtDiskID);
		txtDiskID.setColumns(15);

		btnRentDisk = new JButton("Thuê đĩa");
		btnRentDisk.setEnabled(false);
		btnRentDisk.setFont(new Font("Dialog", Font.PLAIN, 20));
		pnlDiskID.add(btnRentDisk);

		JPanel pnlListDisk = new JPanel();
		pnlRentDisk.add(pnlListDisk, BorderLayout.CENTER);
		pnlListDisk.setLayout(new BorderLayout(0, 0));

		JScrollPane scrListDisk = new JScrollPane();
		pnlListDisk.add(scrListDisk, BorderLayout.CENTER);

		tblListDisk = new JTable();
		tblListDisk.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblListDisk.setFont(new Font("Tahoma", Font.PLAIN, 18));
		tblListDisk.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 \u0111\u0129a", "Ti\u00EAu \u0111\u1EC1", "Lo\u1EA1i \u0111\u0129a", "Gi\u00E1 thu\u00EA", "Ng\u00E0y \u0111\u1EBFn h\u1EA1n"
			}
		));
		tblListDisk.getColumnModel().getColumn(0).setPreferredWidth(60);
		tblListDisk.getColumnModel().getColumn(1).setPreferredWidth(300);
		tblListDisk.getColumnModel().getColumn(3).setPreferredWidth(90);
		tblListDisk.getColumnModel().getColumn(4).setPreferredWidth(100);
		scrListDisk.setViewportView(tblListDisk);

		ganSuKienChoButton();

	}

	/**
	 * Thiết lập sự kiện cho button
	 */
	private void ganSuKienChoButton() {
		// Xác nhận khách hàng thuê đĩa
		btnSearchCusId.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (isValidInput(txtCustomerID)) {
					Long cusId = null;
					try {
						cusId = Long.valueOf(txtCustomerID.getText());
					} catch (NumberFormatException ex) {
						hienThongBao("Mã khách hàng phải là số nguyên lớn hơn 0");
						txtCustomerID.requestFocus();
						return;
					}

					khachHangThueDia = khachHangDAO.findById(cusId);
					hienThongTinKhachHang(khachHangThueDia);

				}

			}
		});
		// Thuê đĩa
		btnRentDisk.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (isValidInput(txtDiskID)) {
					Long diskId = null;
					try {
						diskId = Long.valueOf(txtDiskID.getText());
					} catch (NumberFormatException ne) {
						hienThongBao("Mã đĩa là số nguyên lớn hơn 0");
						txtDiskID.requestFocus();
						return;
					}

					Dia diaThue = diaDAO.findById(diskId);
					if (diaThue == null) {
						hienThongBao("Không tìm thấy đĩa trong hệ thống");
						txtDiskID.requestFocus();
						return;
					}

					themDiaVaoDSThue(diaThue);

				}

			}
		});

		// Xác nhận thuê đĩa
		btnConfirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				
				hienThongTinPhiTreHan(khachHangThueDia);
				
				thueTraDiaBUS.xuLyThueDia(khachHangThueDia, new HashSet<Dia>(dsDiaThue));
				hienThongBao("Thuê đĩa thành công");
			}
		});

		// Đóng giao diện thuê đĩa
		btnClose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				closeUIListener.onCloseUI(e);

			}
		});
	}

	/**
	 * Hiện Thông tin phí trễ hạn của khách hàng (nếu khách hàng trả đĩa trễ hạn)
	 * 
	 * @param cusId: mã khách hàng
	 */
	protected void hienThongTinPhiTreHan(KhachHang khachHang) {
		// hiện thông tin phí trễ hạn nếu có
		List<ChiTietThueTra> dsTreHan = 
				thanhToanPhiTreHanBUS.getDSThueTraTreHanTheoKH(khachHang.getId());
		if (dsTreHan.size() > 0) {
			// TODO: hiện danh Thông báo phí trễ hạn
			hienThongBao(khachHangThueDia.getHoVaTen() + " có phí trễ hạn");
		}

	}

	/**
	 * Đưa đĩa vào danh sách muốn thuê
	 * 
	 * @param diaThue: đĩa muốn thuê
	 */
	protected void themDiaVaoDSThue(Dia diaThue) {
		dsDiaThue.add(diaThue);
		hienDSDiaThue(dsDiaThue);
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
	 * Hiện thông tin khách hàng
	 * 
	 * @param khachHang: khách hàng cần hiện thông tin
	 */
	protected void hienThongTinKhachHang(KhachHang khachHang) {
		if (khachHang == null) {
			visibleCustomeInfo(false);
			hienThongBao("Không tìm thấy khách hàng trong hệ thống");
			return;
		}
		lblCustomerName.setText(khachHang.getHoVaTen());
		lblCustomerPhone.setText(khachHang.getSoDienThoai());
		lblCustomerAddress.setText(khachHang.getDiaChi());
		visibleCustomeInfo(true);
		visibleRetalDiskOperation(true);

	}

	/**
	 * Kích hoạt giao diện thuê đĩa
	 * @param b
	 */
	private void visibleRetalDiskOperation(boolean isVisible) {
		txtDiskID.setEnabled(isVisible);
		btnRentDisk.setEnabled(isVisible);
	
	}

	/**
	 * Hiện trường hiển thị thông tin khách hàng
	 * 
	 * @param isVisible: lựa chọn hiển thị (true: hiện thị/ false: ẩn)
	 */
	private void visibleCustomeInfo(boolean isVisible) {
		pnlCustomerInfo.setVisible(isVisible);

	}

	/**
	 * Kiểm tra trường nhập dữ liệu không bị trống
	 * 
	 * @param txt: trường nhập dữ liệu
	 * @return true: đã nhập dữ liệu / false: chưa nhập dữ liệu
	 */
	protected boolean isValidInput(JTextField txt) {
		if (txt.getText().trim().isEmpty()) {
			hienThongBao("Mời nhập dữ liệu!");
			txt.requestFocus();
			return false;
		}
		return true;
	}

	/**
	 * Hiện thông báo
	 * 
	 * @param msg: thông báo cần hiển thị
	 */
	private void hienThongBao(String msg) {
		JLabel label = new JLabel(msg);
		label.setFont(new Font("Arial", Font.BOLD, 18));
		JOptionPane.showMessageDialog(this, label);

	}

	public void setCloseUIListener(ICloseUIListener closeUIListener) {
		this.closeUIListener = closeUIListener;
	}

}
