package com.group4.ui.panel;

import static com.group4.Injection.khachHangBUS;
import static com.group4.Injection.khachHangDAO;
import static com.group4.Injection.thanhToanPhiTreHanBUS;
import static com.group4.ui.panel.UtilsLayout.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.group4.entities.ChiTietThueTra;
import com.group4.entities.KhachHang;
import com.group4.ui.ICloseUIListener;

public class PnlCustomerReportUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ICloseUIListener closeUIListener;

	private String[] colName;
	private String[][] dataKH;
	private JTable tblDSKH;
	private JTable tblDSDiaTreHan;
	private JTable tblDSNoPhiTreHan;

	private JComboBox cmbOption;
	private JButton btnClose;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;

	/**
	 * Create the panel.
	 */
	public PnlCustomerReportUI() {
		setLayout(null);
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setSize(1270, 600);

		JLabel lblHeader = new JLabel("BÁO CÁO KHÁCH HÀNG");
		lblHeader.setBounds(463, 5, 353, 37);
		lblHeader.setFont(new Font("Tahoma", Font.BOLD, 30));
		add(lblHeader);

		colName = new String[] { "STT", "Mã khách hàng", "Họ và tên", "Số điện thoại", "Địa chỉ" };

		panel_2 = new JPanel();
		panel_2.setBorder(
				new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Danh s\u00E1ch kh\u00E1ch h\u00E0ng",
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(4, 153, 686, 389);
		add(panel_2);
		panel_2.setLayout(null);

		JScrollPane scrDSKH = new JScrollPane();
		scrDSKH.setBounds(6, 18, 665, 364);
		panel_2.add(scrDSKH);

		tblDSKH = new JTable(dataKH, colName);
		tblDSKH.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, },
				new String[] { "STT", "M\u00E3 kh\u00E1ch h\u00E0ng", "H\u1ECD v\u00E0 t\u00EAn",
						"S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "\u0110\u1ECBa ch\u1EC9",
						"S\u1ED1 \u0111\u0129a \u0111\u00E3 thu\u00EA" }));
		tblDSKH.getColumnModel().getColumn(0).setPreferredWidth(38);
		tblDSKH.getColumnModel().getColumn(1).setPreferredWidth(101);
		tblDSKH.getColumnModel().getColumn(2).setPreferredWidth(150);
		tblDSKH.getColumnModel().getColumn(3).setPreferredWidth(100);
		tblDSKH.getColumnModel().getColumn(4).setPreferredWidth(200);
		tblDSKH.getColumnModel().getColumn(5).setPreferredWidth(96);
		tblDSKH.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrDSKH.setViewportView(tblDSKH);


		panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"Danh s\u00E1ch \u0111\u0129a tr\u1EC5 h\u1EA1n", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel.setBounds(691, 153, 573, 216);
		add(panel);
		panel.setLayout(null);

		JScrollPane scrTreHan = new JScrollPane();

		scrTreHan.setBounds(6, 18, 555, 193);
		panel.add(scrTreHan);

		tblDSDiaTreHan = new JTable();
		tblDSDiaTreHan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tblDSDiaTreHan.setModel(
				new DefaultTableModel(new Object[][] { { null, null, null }, { null, null, null }, }, new String[] {
						"M\u00E3 \u0111\u0129a", "Ti\u00EAu \u0111\u1EC1", "Ng\u00E0y \u0111\u1EBFn h\u1EA1n" }));
		tblDSDiaTreHan.getColumnModel().getColumn(1).setPreferredWidth(220);
		tblDSDiaTreHan.getColumnModel().getColumn(2).setPreferredWidth(94);
		scrTreHan.setViewportView(tblDSDiaTreHan);

		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"),
				"Danh s\u00E1ch n\u1EE3 ph\u00ED tr\u1EC5 h\u1EA1n", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		panel_1.setBounds(691, 377, 573, 165);
		add(panel_1);
		panel_1.setLayout(null);

		JScrollPane scrDSNo = new JScrollPane();
		scrDSNo.setBounds(6, 18, 555, 140);
		panel_1.add(scrDSNo);

		tblDSNoPhiTreHan = new JTable();
		tblDSNoPhiTreHan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tblDSNoPhiTreHan.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "M\u00E3 \u0111\u0129a", "T\u1EF1a \u0111\u1EC1", "Ng\u00E0y \u0111\u1EBFn h\u1EA1n",
						"Ng\u00E0y tr\u1EA3 \u0111\u0129a", "Ph\u00ED tr\u1EC5 h\u1EA1n" }));
		tblDSNoPhiTreHan.getColumnModel().getColumn(0).setPreferredWidth(50);
		tblDSNoPhiTreHan.getColumnModel().getColumn(1).setPreferredWidth(220);
		tblDSNoPhiTreHan.getColumnModel().getColumn(2).setPreferredWidth(100);
		tblDSNoPhiTreHan.getColumnModel().getColumn(3).setPreferredWidth(120);
		tblDSNoPhiTreHan.getColumnModel().getColumn(4).setPreferredWidth(90);
		scrDSNo.setViewportView(tblDSNoPhiTreHan);

		JLabel lblBaoCao = new JLabel("Ch\u1ECDn lo\u1EA1i b\u00E1o c\u00E1o:");
		lblBaoCao.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBaoCao.setBounds(10, 113, 172, 28);
		add(lblBaoCao);

		cmbOption = new JComboBox();
		cmbOption.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cmbOption.setModel(new DefaultComboBoxModel(new String[] { "-- Chọn loại báo cáo --", "Tất cả khách hàng",
				"Khách hàng có đĩa trễ hạn", "Khách hàng có phí trễ hạn" }));
		cmbOption.setBounds(182, 109, 172, 32);
		add(cmbOption);

		btnClose = new JButton("Thoát");
		btnClose.setPreferredSize(new Dimension(65, 50));
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnClose.setBounds(1167, 555, 97, 38);
		add(btnClose);

		ganSuKienChonCombox();
		
		ganSuKienChoTable();

		ganSuKienChoButton();

	}

	private void ganSuKienChoTable() {
		tblDSKH.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent e) {
				int select = tblDSKH.getSelectedRow();
				if (select == -1)
					return;

				KhachHang khachHang = khachHangDAO.findById(Long.valueOf(tblDSKH.getValueAt(select, 1).toString()));

				hienThongTin(khachHang);

			}
		});
		
	}

	/**
	 * Hiện thông tin phí trễ hạn của khách hàng
	 * 
	 * @param khachHang khác hàng được chọn
	 */
	protected void hienThongTin(KhachHang khachHang) {
		hienDSDiaChuaTra(khachHangBUS.getDSChiTietChuaTraDia(khachHang));
		hienThongTinPhiTreHan(thanhToanPhiTreHanBUS.getDSThueTraTreHanTheoKH(khachHang.getId()));

	}

	/**
	 * Danh sách phí trễ hạn
	 * 
	 * @param dsThueTraTreHanTheoKH
	 */
	private void hienThongTinPhiTreHan(List<ChiTietThueTra> dsThueTraTreHanTheoKH) {
		DefaultTableModel tableModel = (DefaultTableModel) tblDSNoPhiTreHan.getModel();
		tableModel.setRowCount(0);
		for (ChiTietThueTra chiTietThueTra : dsThueTraTreHanTheoKH) {
			tableModel.addRow(new Object[] {chiTietThueTra.getDia().getId(),
					chiTietThueTra.getDia().getTuaDe(), chiTietThueTra.getNgayToiHan(), 
					chiTietThueTra.getNgayTra(),
					chiTietThueTra.getDia().getLoaiDia().getPhiTreHan() });
		}

	}

	/**
	 * Danh sách đĩa chưa trả
	 * 
	 * @param list
	 */
	private void hienDSDiaChuaTra(List<ChiTietThueTra> list) {
		DefaultTableModel tableModel = (DefaultTableModel) tblDSDiaTreHan.getModel();
		tableModel.setRowCount(0);
		for (ChiTietThueTra chiTietThueTra : list) {
			tableModel.addRow(new Object[] {chiTietThueTra.getDia().getId(),
					chiTietThueTra.getDia().getTuaDe(), chiTietThueTra.getNgayToiHan() });
		}

	}

	private void ganSuKienChoButton() {
		btnClose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int confirm = hienThongBaoXacNhan(PnlCustomerReportUI.this, "Thông báo xác nhận",
						"Xác nhận thoát chức năng ?");
				if (confirm == JOptionPane.NO_OPTION) {
					return;
				}
				closeUIListener.onCloseUI(e);

			}
		});
	}

	private void ganSuKienChonCombox() {
		cmbOption.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int select = cmbOption.getSelectedIndex();

				switch (select) {
				case 1:
					hienDanhSachKhachHang(khachHangDAO.findAll());
					break;
				case 2:

					break;
				case 3:
					hienDanhSachKhachHang(khachHangBUS.getDSKhachHangCoPhiTreHan());
					break;

				default:
					hienDanhSachKhachHang(new ArrayList<KhachHang>());
					break;
				}

			}
		});
	}

	/**
	 * Hiện danh sách khách hàng
	 * 
	 * @param dsKhachHangCoPhiTreHan
	 */
	private void hienDanhSachKhachHang(List<KhachHang> dsKhachHangCoPhiTreHan) {

		if (dsKhachHangCoPhiTreHan.size() == 0) {
			hienThongBao(this, "Thông báo", "Không có khách hàng nào bị trễ hạn trả đĩa",
					JOptionPane.INFORMATION_MESSAGE);
			return;
		}

		DefaultTableModel tableModel = (DefaultTableModel) tblDSKH.getModel();
		tableModel.setRowCount(0);
		int index = 1;
		for (KhachHang khachHang : dsKhachHangCoPhiTreHan) {
			tableModel.addRow(new Object[] { index++, khachHang.getId(), khachHang.getHoVaTen(),
					khachHang.getSoDienThoai(), khachHang.getDiaChi(), khachHangBUS.tinhSoDiaDaThue(khachHang) });
		}

	}

	public void setCloseUIListener(ICloseUIListener closeUIListener) {
		this.closeUIListener = closeUIListener;
	}
}
