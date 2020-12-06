package com.group4.ui.panel;

import static com.group4.ui.panel.UtilsLayout.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.group4.business.KhachHangBUS;
import com.group4.business.ThanhToanPhiTreHanBUS;
import com.group4.business.ThueTraDiaBUS;
import com.group4.dao.impl.KhachHangDAO;
import com.group4.entities.ChiTietThueTra;
import com.group4.entities.KhachHang;
import com.group4.ui.ICloseUIListener;

public class PnlCustomerReportUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ICloseUIListener closeUIListener;

	private static KhachHangBUS khachHangBUS;
	private static KhachHangDAO khachHangDAO;
	private static ThanhToanPhiTreHanBUS thanhToanPhiTreHanBUS;
	static {
		thanhToanPhiTreHanBUS = new ThanhToanPhiTreHanBUS();
		khachHangDAO = new KhachHangDAO();
		khachHangBUS = new KhachHangBUS();
	}

	private String[] colName;
	private String[][] dataKH;
	private JTable tblDSKH;
	private JTable tblDSTreHan;
	private JTable tblDSNoPhiTreHan;

	private JComboBox cmbOption;
	private JButton btnClose;

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

		JScrollPane scrDSKH = new JScrollPane();
		scrDSKH.setBounds(10, 189, 766, 346);
		add(scrDSKH);

		tblDSKH = new JTable(dataKH, colName);
		tblDSKH.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null },
				{ null, null, null, null, null }, { null, null, null, null, null }, { null, null, null, null, null },
				{ null, null, null, null, null }, }, colName));
		tblDSKH.getColumnModel().getColumn(2).setPreferredWidth(150);
		tblDSKH.getColumnModel().getColumn(3).setPreferredWidth(100);
		tblDSKH.getColumnModel().getColumn(4).setPreferredWidth(150);
		tblDSKH.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrDSKH.setViewportView(tblDSKH);

		JScrollPane scrTreHan = new JScrollPane();
		scrTreHan.setBounds(788, 189, 470, 193);
		add(scrTreHan);

		tblDSTreHan = new JTable();
		tblDSTreHan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tblDSTreHan.setModel(
				new DefaultTableModel(new Object[][] { { null, null, null, null }, { null, null, null, null }, },
						new String[] { "ST", "M\u00E3 \u0111\u0129a", "Ti\u00EAu \u0111\u1EC1", "Ngày đến hạn" }));
		tblDSTreHan.getColumnModel().getColumn(2).setPreferredWidth(150);
		scrTreHan.setViewportView(tblDSTreHan);

		JScrollPane scrDSNo = new JScrollPane();
		scrDSNo.setBounds(788, 395, 470, 140);
		add(scrDSNo);

		tblDSNoPhiTreHan = new JTable();
		tblDSNoPhiTreHan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tblDSNoPhiTreHan.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "STT", "Ngày đến hạn", "Ngày trả đĩa", "Phí trễ hạn" }));
		tblDSNoPhiTreHan.getColumnModel().getColumn(1).setPreferredWidth(95);
		tblDSNoPhiTreHan.getColumnModel().getColumn(2).setPreferredWidth(150);
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
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnClose.setBounds(1161, 562, 97, 25);
		add(btnClose);

		ganSuKienChonCombox();

		ganSuKienChoButton();

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
	
	protected void hienThongTin(KhachHang khachHang) {
		hienThongTinThueTra(khachHang.getDsChiTietThueTra());
		hienThongTinPhiTreHan(thanhToanPhiTreHanBUS.getDSThueTraTreHanTheoKH(khachHang.getId()));
		
	}

	private void hienThongTinPhiTreHan(List<ChiTietThueTra> dsThueTraTreHanTheoKH) {
		// TODO Auto-generated method stub
		
	}

	private void hienThongTinThueTra(Set<ChiTietThueTra> dsChiTietThueTra) {
		// TODO Auto-generated method stub
		
	}

	private void ganSuKienChoButton() {
		btnClose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
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
					khachHang.getSoDienThoai(), khachHang.getDiaChi() });
		}

	}

	public void setCloseUIListener(ICloseUIListener closeUIListener) {
		this.closeUIListener = closeUIListener;
	}
}
