package com.group4.ui.dialog;
import static com.group4.Injection.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.group4.business.ThanhToanPhiTreHanBUS;
import com.group4.entities.ChiTietThueTra;
import com.group4.entities.KhachHang;
import com.group4.ui.ICloseUIListener;
import com.group4.ui.panel.PnlLateChargePayment;

public class DlgThongBaoPhiTreHan extends JDialog {

	private static final long serialVersionUID = 1L;


	private List<ChiTietThueTra> dsPhiTreHan;
	private final JPanel contentPanel = new JPanel();
	private JTextField txtIDKH;
	private JTextField txtTongPhiTreHan;

	private JButton btnThanhToanPhiTreHan;

	private JButton btnHuy;

	private JDialog dlgThanhToan;

	/**
	 * Create the dialog.
	 * 
	 * @param dsTreHan
	 */
	public DlgThongBaoPhiTreHan(List<ChiTietThueTra> dsTreHan) {
		this.dsPhiTreHan = dsTreHan;
		setTitle("Thông báo phí trễ hạn");
		setSize(502, 300);
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblHeader = new JLabel("Khách hàng có phí trễ hạn");
			lblHeader.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblHeader.setBounds(111, 4, 280, 39);
			contentPanel.add(lblHeader);
		}
		{
			JLabel lblIDKH = new JLabel("Mã khách hàng: ");
			lblIDKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblIDKH.setBounds(12, 56, 168, 39);
			contentPanel.add(lblIDKH);
		}

		txtIDKH = new JTextField();
		txtIDKH.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtIDKH.setEditable(false);
		txtIDKH.setBounds(192, 56, 231, 39);
		contentPanel.add(txtIDKH);
		txtIDKH.setColumns(10);

		JLabel lblTongTien = new JLabel("Tổng tiền trễ hạn:");
		lblTongTien.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTongTien.setBounds(12, 121, 168, 39);
		contentPanel.add(lblTongTien);

		txtTongPhiTreHan = new JTextField();
		txtTongPhiTreHan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTongPhiTreHan.setEditable(false);
		txtTongPhiTreHan.setBounds(192, 120, 231, 40);
		contentPanel.add(txtTongPhiTreHan);
		txtTongPhiTreHan.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				btnThanhToanPhiTreHan = new JButton("Thanh toán phí trễ hạn");
				btnThanhToanPhiTreHan.setFont(new Font("Tahoma", Font.PLAIN, 20));
				buttonPane.add(btnThanhToanPhiTreHan);
				getRootPane().setDefaultButton(btnThanhToanPhiTreHan);
			}
			{
				btnHuy = new JButton("Huỷ");
				btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 20));
				btnHuy.setActionCommand("Cancel");
				buttonPane.add(btnHuy);
			}
		}
		hienThongTinPhiTreHan(dsTreHan);

		ganSuKienChoButton();
	}

	/**
	 * Xử lý sự kiện cho button
	 */
	private void ganSuKienChoButton() {
		btnThanhToanPhiTreHan.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				PnlLateChargePayment pnlLateChargePayment = new PnlLateChargePayment(dsPhiTreHan);
				hienDiaLog(pnlLateChargePayment);

			}
		});

		btnHuy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});

	}

	/**
	 * Hiện giao diện thanh toán phí trễ hạn
	 * 
	 * @param pnlLateChargePayment
	 */
	private void hienDiaLog(PnlLateChargePayment pnlLateChargePayment) {
		dlgThanhToan = new JDialog();
		dlgThanhToan.setSize(1270, 700);
		dlgThanhToan.setModal(true);
		dlgThanhToan.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		dlgThanhToan.setLocationRelativeTo(null);
		dlgThanhToan.getContentPane().add(pnlLateChargePayment, BorderLayout.CENTER);
		
		pnlLateChargePayment.setCloseUIListener(new ICloseUIListener() {

			@Override
			public void onCloseUI(ActionEvent e) {
				dlgThanhToan.dispose();

			}
		});
		
		dlgThanhToan.setVisible(true);
		

	}

	/**
	 * hiện thông tin phí trễ hạn
	 * 
	 * @param dsTreHan
	 */
	private void hienThongTinPhiTreHan(List<ChiTietThueTra> dsTreHan) {
		hienMaKhachHang(dsTreHan);

		hienTongPhiTreHan(dsTreHan);

	}

	/**
	 * Hiện tổng phí trễ hạn
	 * 
	 * @param dsTreHan
	 */
	private void hienTongPhiTreHan(List<ChiTietThueTra> dsTreHan) {
		double tongPhiTreHan = thanhToanPhiTreHanBUS.tinhTongTienPhiTreHan(dsTreHan);
		String tongPhiStr = NumberFormat.getCurrencyInstance(new Locale("vi", "VN")).format(tongPhiTreHan);
		txtTongPhiTreHan.setText(tongPhiStr);
	}

	/**
	 * Hiện mã khách hàng
	 * 
	 * @param dsTreHan
	 */
	private void hienMaKhachHang(List<ChiTietThueTra> dsTreHan) {
		KhachHang khachHang = dsTreHan.get(0).getKhachHang();
		txtIDKH.setText(khachHang.getId() + "");
	}
}
