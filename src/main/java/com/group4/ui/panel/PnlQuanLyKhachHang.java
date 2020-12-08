package com.group4.ui.panel;
import static com.group4.Injection.*;
import static com.group4.ui.panel.UtilsLayout.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.regex.Pattern;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.group4.business.KhachHangBUS;
import com.group4.dao.IKhachHangDAO;
import com.group4.dao.impl.KhachHangDAO;
import com.group4.entities.KhachHang;
import com.group4.model.TaiKhoanModel;
import com.group4.ui.ICloseUIListener;
import javax.swing.SwingConstants;

public class PnlQuanLyKhachHang extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ICloseUIListener closeUIListener;
	private KhachHang khachHang = null;
	private List<KhachHang> dsKH;

	private JTextField txtTenKhachHang;
	private JTextField txtDiaChi;
	private JTextField txtSoDienThoai;
	private JTextField txtNhapId;

	private JButton btnThemKhachHang;
	private JButton btnSuaKhachHang;
	private JButton btnLuuKhachHang;
	private JButton btnXoaKhachHang;
	private JButton btnDong;
	private JButton btnTimKH;
	private JButton btnHuy;

	DefaultTableModel dtmKhachHang;
	JTable tblKhachHang;

	/**
	 * Create the panel.
	 */
	public PnlQuanLyKhachHang() {
		setForeground(Color.BLUE);
		setLayout(new BorderLayout(0, 0));
		setSize(1270, 600);

		JPanel pnTitle = new JPanel();
		add(pnTitle, BorderLayout.NORTH);

		JLabel lblTitle = new JLabel("QU\u1EA2N L\u00DD KH\u00C1CH H\u00C0NG");
		lblTitle.setForeground(Color.BLACK);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 32));
		pnTitle.add(lblTitle);

		JPanel pnDanhSachThongTinKH = new JPanel();
		add(pnDanhSachThongTinKH, BorderLayout.CENTER);
		pnDanhSachThongTinKH.setLayout(new BorderLayout(0, 0));

		JPanel pnThongTinKhachHang = new JPanel();
		pnDanhSachThongTinKH.add(pnThongTinKhachHang, BorderLayout.NORTH);
		pnThongTinKhachHang.setLayout(new BoxLayout(pnThongTinKhachHang, BoxLayout.X_AXIS));

		JPanel pnThongTin = new JPanel();
		pnThongTin.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Th\u00F4ng tin kh\u00E1ch h\u00E0ng",
				TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnThongTinKhachHang.add(pnThongTin);
		pnThongTin.setLayout(new BoxLayout(pnThongTin, BoxLayout.Y_AXIS));

		JPanel pnTenKH = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) pnTenKH.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		pnThongTin.add(pnTenKH);

		JLabel lblTenKhachHang = new JLabel("Tên khách hàng:");
		lblTenKhachHang.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTenKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnTenKH.add(lblTenKhachHang);

		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnTenKH.add(txtTenKhachHang);
		txtTenKhachHang.setColumns(20);

		JPanel pnPhone = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) pnPhone.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		pnThongTin.add(pnPhone);

		JLabel lblPhone = new JLabel("Số điện thoại:");
		lblPhone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnPhone.add(lblPhone);

		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnPhone.add(txtSoDienThoai);
		txtSoDienThoai.setColumns(10);
		lblPhone.setPreferredSize(lblTenKhachHang.getPreferredSize());
		txtSoDienThoai.setEditable(false);

		JPanel pnDiaChi = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) pnDiaChi.getLayout();
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		pnThongTin.add(pnDiaChi);

		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnDiaChi.add(lblDiaChi);

		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnDiaChi.add(txtDiaChi);
		txtDiaChi.setColumns(25);

		JPanel pnChucNang = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) pnChucNang.getLayout();
		flowLayout_1.setVgap(25);
		flowLayout_1.setHgap(10);
		pnChucNang.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Ch\u1EE9c n\u0103ng",
				TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnThongTinKhachHang.add(pnChucNang);

		btnThemKhachHang = new JButton("Thêm");
		btnThemKhachHang.setFont(new Font("Arial", Font.PLAIN, 20));
		pnChucNang.add(btnThemKhachHang);
		btnThemKhachHang.setPreferredSize(new Dimension(100, 50));

		btnSuaKhachHang = new JButton("Sửa");
		btnSuaKhachHang.setFont(new Font("Arial", Font.PLAIN, 20));
		pnChucNang.add(btnSuaKhachHang);
		btnSuaKhachHang.setPreferredSize(new Dimension(100, 50));

		btnXoaKhachHang = new JButton("Xóa");
		btnXoaKhachHang.setFont(new Font("Arial", Font.PLAIN, 20));
		pnChucNang.add(btnXoaKhachHang);
		btnXoaKhachHang.setPreferredSize(new Dimension(100, 50));

		btnHuy = new JButton("Huỷ");
		btnHuy.setPreferredSize(new Dimension(89, 50));
		btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnChucNang.add(btnHuy);

		btnLuuKhachHang = new JButton("Lưu");
		btnLuuKhachHang.setFont(new Font("Arial", Font.PLAIN, 20));
		pnChucNang.add(btnLuuKhachHang);
		btnLuuKhachHang.setPreferredSize(new Dimension(100, 50));
		lblDiaChi.setPreferredSize(lblTenKhachHang.getPreferredSize());

		JPanel pnDanhSachKhachHang = new JPanel();
		pnDanhSachKhachHang.setBorder(null);
		pnDanhSachThongTinKH.add(pnDanhSachKhachHang, BorderLayout.CENTER);

		BorderLayout bl_pnDanhSachKhachHang = new BorderLayout();
		pnDanhSachKhachHang.setLayout(bl_pnDanhSachKhachHang);

		pnDanhSachThongTinKH.add(pnDanhSachKhachHang, BorderLayout.CENTER);

		JPanel pnTableKhachHang = new JPanel();
		pnTableKhachHang.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)),
				"Danh s\u00E1ch kh\u00E1ch h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnDanhSachKhachHang.add(pnTableKhachHang, BorderLayout.CENTER);
		pnTableKhachHang.setLayout(new BorderLayout());
		// tạo bảng
		dtmKhachHang = new DefaultTableModel();
		dtmKhachHang.addColumn("Id khách hàng");
		dtmKhachHang.addColumn("Tên khách hàng");
		dtmKhachHang.addColumn("Địa chỉ");
		dtmKhachHang.addColumn("Số điện thoại");
		tblKhachHang = new JTable(dtmKhachHang);
		tblKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		JScrollPane scTable = new JScrollPane(tblKhachHang, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		pnTableKhachHang.add(scTable, BorderLayout.CENTER);

		JPanel pnTimKhachHang = new JPanel();
		FlowLayout fl_pnTimKhachHang = (FlowLayout) pnTimKhachHang.getLayout();
		fl_pnTimKhachHang.setAlignment(FlowLayout.LEFT);
		pnDanhSachKhachHang.add(pnTimKhachHang, BorderLayout.NORTH);

		JLabel lblNhap = new JLabel("Nhập id khách hàng:");
		lblNhap.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnTimKhachHang.add(lblNhap);

		txtNhapId = new JTextField();
		txtNhapId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnTimKhachHang.add(txtNhapId);
		txtNhapId.setColumns(10);

		btnTimKH = new JButton("Tìm kiếm");
		btnTimKH.setFont(new Font("Arial", Font.PLAIN, 20));
		pnTimKhachHang.add(btnTimKH);

		JPanel pnThoat = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnThoat.getLayout();
		flowLayout.setHgap(30);
		flowLayout.setAlignment(FlowLayout.RIGHT);
		pnDanhSachThongTinKH.add(pnThoat, BorderLayout.SOUTH);

		btnDong = new JButton("Đóng");
		btnDong.setFont(new Font("Arial", Font.PLAIN, 20));
		pnThoat.add(btnDong);
		btnDong.setPreferredSize(new Dimension(100, 50));
		
		if(TaiKhoanModel.admin == null) {
			btnXoaKhachHang.setVisible(false);
		}

		voHieuHoaButton(btnSuaKhachHang, btnXoaKhachHang, btnLuuKhachHang, btnHuy);

		voHieuHoaTextField(txtSoDienThoai, txtDiaChi, txtTenKhachHang);

		dsKH = khachHangDAO.findAll();
		hienDanhSachKhachHang(dsKH);
		ganSuKienChoButton();
		ganSuKienChoTable();

	}

	/**
	 * Xử lý sự kiện cho table
	 */
	private void ganSuKienChoTable() {
		tblKhachHang.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				btnLuuKhachHang.setEnabled(false);
				int select = tblKhachHang.getSelectedRow();

				if (select == -1)
					return;

				hienThongTinKhachHang(dsKH.get(select));
				voHieuHoaButton(btnThemKhachHang);
				kichHoatButton(btnSuaKhachHang, btnXoaKhachHang, btnHuy);
				voHieuHoaTextField(txtTenKhachHang, txtSoDienThoai, txtDiaChi);
			}

		});

	}

	/**
	 * Hiện danh sách khách hàng
	 * 
	 * @param dsKH
	 */
	private void hienDanhSachKhachHang(List<KhachHang> dsKH) {
		DefaultTableModel tableModel = (DefaultTableModel) tblKhachHang.getModel();
		tableModel.setRowCount(0);
		for (KhachHang kh : dsKH) {
			tableModel.addRow(new Object[] { kh.getId(), kh.getHoVaTen(), kh.getDiaChi(), kh.getSoDienThoai() });
		}
	}

	/**
	 * Gắn sự kiện cho Button
	 */
	private void ganSuKienChoButton() {
		btnDong.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				closeUIListener.onCloseUI(e);
			}
		});

		btnThemKhachHang.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				xuLyThemKhachHang();
			}
		});

		btnLuuKhachHang.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (isValidInput()) {
					String name = txtDiaChi.getText();
					String phone = txtSoDienThoai.getText();
					String address = txtDiaChi.getText();
					if (khachHang != null) {
						khachHang.setHoVaTen(name);
						khachHang.setSoDienThoai(phone);
						khachHang.setDiaChi(address);
					} else {
						khachHang = new KhachHang(name, phone, address);
					}

					luuThongTinKhachHang(khachHang);
					hienDanhSachKhachHang(khachHangDAO.findAll());
					xoaTrangInput();
				}
			}
		});

		btnSuaKhachHang.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				kichHoatButton(btnLuuKhachHang, btnHuy);
				kichHoatTextField(txtTenKhachHang, txtDiaChi, txtSoDienThoai);
			}
		});
		btnHuy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				xuLyHuyThaoTac();

			}
		});

		btnXoaKhachHang.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int selectIndex = -1;
				selectIndex = tblKhachHang.getSelectedRow();

				if (selectIndex >= 0) {
					KhachHang kh = dsKH.get(selectIndex);

					int option = hienThongBaoXacNhan(PnlQuanLyKhachHang.this, "Thông báo xác nhận",
							"Bạn có muốn xóa khách hàng này?");

					if (option == JOptionPane.YES_OPTION) {

						if (khachHangBUS.xoaKhachHang(kh) == false) {
							hienThongBao(PnlQuanLyKhachHang.this, "Thông báo lỗi",
									"Không thể xoá khách hàng do khách hàng đang thực hiện việc thuê hoặc đặt đĩa",
									JOptionPane.ERROR_MESSAGE);
							return;
						}
						hienDanhSachKhachHang(khachHangDAO.findAll());
						hienThongBao(PnlQuanLyKhachHang.this, "Thông báo",
								"Xoá khách hàng (mã số: " + kh.getId() + ") thành công",
								JOptionPane.INFORMATION_MESSAGE);
					}

				}
			}
		});

		btnTimKH.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (isInputFieldNotBlank(PnlQuanLyKhachHang.this, txtNhapId)) {
					Long cusId = null;
					try {
						cusId = Long.valueOf(txtNhapId.getText());
						if (cusId <= 0) {
							hienThongBao(PnlQuanLyKhachHang.this, "Thông báo lỗi",
									"Mã khách hàng là số nguyên lớn hơn 0", JOptionPane.ERROR_MESSAGE);
							txtNhapId.requestFocus();
							txtNhapId.selectAll();
						}
					} catch (NumberFormatException e2) {
						hienThongBao(PnlQuanLyKhachHang.this, "Thông báo lỗi", "Mã khách hàng là số nguyên lớn hơn 0",
								JOptionPane.ERROR_MESSAGE);
						txtNhapId.requestFocus();
						txtNhapId.selectAll();
						return;
					}

					khachHang = khachHangDAO.findById(cusId);
					hienThongTinKhachHang(khachHang);

					kichHoatButton(btnSuaKhachHang, btnXoaKhachHang, btnHuy);
				}
			}
		});

	}

	/**
	 * Xử lý huỷ thao tác
	 */
	private void xuLyHuyThaoTac() {
		tblKhachHang.clearSelection();
		xoaTrangInput();
		voHieuHoaButton(btnXoaKhachHang, btnSuaKhachHang, btnLuuKhachHang, btnHuy);
		kichHoatButton(btnThemKhachHang);
		voHieuHoaTextField(txtDiaChi, txtTenKhachHang, txtSoDienThoai);

	}

	/**
	 * Lưu thông tin cập nhập khách hàng
	 * 
	 * @param kh khách hàng cần lưu
	 */
	private void luuThongTinKhachHang(KhachHang kh) {
		if (kh.getId() != null && kh.getId() > 0) {
			// cập nhật khách hàng
			kh = khachHangDAO.update(khachHang);
			if (kh != null) {
				hienThongBao(this, "Thông báo", "Câp nhật khách hàng (mã số: " + kh.getId() + ") thành công",
						JOptionPane.INFORMATION_MESSAGE);
			}

		} else {
			// thêm mới khách hàng
			kh = khachHangDAO.create(khachHang);
			if (kh != null) {
				hienThongBao(this, "Thông báo", "Thêm mới khách hàng (mã số: " + kh.getId() + ") thành công",
						JOptionPane.INFORMATION_MESSAGE);
			}

		}
		khachHang = null;

	}

	/**
	 * Tiền xử lý trước khi tiến hành thêm khách hàng
	 */
	private void xuLyThemKhachHang() {
		xoaTrangInput();
		voHieuHoaButton(btnThemKhachHang);
		kichHoatButton(btnLuuKhachHang, btnHuy);
		kichHoatTextField(txtTenKhachHang, txtDiaChi, txtSoDienThoai);
	}

	/**
	 * Xoá trắng các trường nhập dữ liệu
	 */
	private void xoaTrangInput() {
		txtTenKhachHang.setText("");
		txtDiaChi.setText("");
		txtSoDienThoai.setText("");
		txtTenKhachHang.requestFocus();

	}

	/**
	 * Kiểm tra trường nhập hợp lệ
	 * 
	 * @return
	 */
	private boolean isValidInput() {
		if (!isInputFieldNotBlank(this, txtTenKhachHang) || !isInputFieldNotBlank(this, txtSoDienThoai)
				|| !isInputFieldNotBlank(this, txtDiaChi)) {
			return false;
		}

		String regex = "^(03|07|08|09|01[2|6|8|9])+([0-9]{8})+";

		String phoneNumber = txtSoDienThoai.getText();

		if (!Pattern.matches(regex, phoneNumber)) {
			hienThongBao(this, "Thông báo lỗi",
					"Số điện thoại phải bao gồm 10 chữ số (bắt đầu bởi 03|07|08|09|01[2|6|8|9]) ",
					JOptionPane.ERROR_MESSAGE);
			txtSoDienThoai.requestFocus();
			txtSoDienThoai.selectAll();
			return false;
		}
		return true;

	}

	private void hienThongTinKhachHang(KhachHang khachHang) {
		txtTenKhachHang.setText(khachHang.getHoVaTen());
		txtDiaChi.setText(khachHang.getDiaChi());
		txtSoDienThoai.setText(khachHang.getSoDienThoai());
	}

	public void setCloseUIListener(ICloseUIListener closeUIListener) {
		this.closeUIListener = closeUIListener;
	}

}
