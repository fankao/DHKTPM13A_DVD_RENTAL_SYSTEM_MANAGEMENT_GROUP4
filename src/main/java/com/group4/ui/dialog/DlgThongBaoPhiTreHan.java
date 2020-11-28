package com.group4.ui.dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class DlgThongBaoPhiTreHan extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtIDKH;
	private JTextField txtTongPhiTreHan;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgThongBaoPhiTreHan dialog = new DlgThongBaoPhiTreHan();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgThongBaoPhiTreHan() {
		setTitle("Thông báo phí trễ hạn");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblHeader = new JLabel("Khách hàng có phí trễ hạn");
			lblHeader.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblHeader.setBounds(105, 8, 211, 39);
			contentPanel.add(lblHeader);
		}
		{
			JLabel lblIDKH = new JLabel("ID khách hàng: ");
			lblIDKH.setFont(new Font("Tahoma", Font.PLAIN, 14));
			lblIDKH.setBounds(49, 56, 119, 31);
			contentPanel.add(lblIDKH);
		}
		
		txtIDKH = new JTextField();
		txtIDKH.setEditable(false);
		txtIDKH.setBounds(160, 54, 231, 39);
		contentPanel.add(txtIDKH);
		txtIDKH.setColumns(10);
		
		JLabel lblTongTien = new JLabel("Tổng tiền trễ hạn:");
		lblTongTien.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTongTien.setBounds(38, 120, 119, 39);
		contentPanel.add(lblTongTien);
		
		txtTongPhiTreHan = new JTextField();
		txtTongPhiTreHan.setEditable(false);
		txtTongPhiTreHan.setBounds(160, 119, 231, 40);
		contentPanel.add(txtTongPhiTreHan);
		txtTongPhiTreHan.setColumns(10);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Trả phí trễ hạn");
				okButton.setFont(new Font("Tahoma", Font.BOLD, 14));
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Hủy");
				cancelButton.setFont(new Font("Tahoma", Font.BOLD, 14));
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
