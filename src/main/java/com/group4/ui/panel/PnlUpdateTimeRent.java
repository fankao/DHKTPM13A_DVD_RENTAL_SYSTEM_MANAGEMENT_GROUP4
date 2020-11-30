package com.group4.ui.panel;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PnlUpdateTimeRent extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTable table;
	private JTextField txtID;
	private JTextField txtTuaDe;
	private JTextField txtSoNgayThue;

	/**
	 * Create the panel.
	 */
	public PnlUpdateTimeRent() {
		setLayout(null);
		
		JLabel lblHeader = new JLabel("Thiet lap thoi gian thue dia");
		lblHeader.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHeader.setBounds(573, 26, 319, 72);
		add(lblHeader);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(36, 114, 542, 535);
		add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"STT", "ID", "Tua de", "So ngay thue"
			}
		));
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(table);
		
		JLabel lblTieude = new JLabel("Cap nhat thoi gian thue dia");
		lblTieude.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTieude.setBounds(717, 109, 392, 72);
		add(lblTieude);
		
		JLabel lblID = new JLabel("ID:");
		lblID.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblID.setBounds(642, 205, 100, 40);
		add(lblID);
		
		txtID = new JTextField();
		txtID.setEditable(false);
		txtID.setBounds(752, 203, 300, 49);
		add(txtID);
		txtID.setColumns(10);
		
		txtTuaDe = new JTextField();
		txtTuaDe.setEditable(false);
		txtTuaDe.setBounds(752, 290, 300, 49);
		add(txtTuaDe);
		txtTuaDe.setColumns(10);
		
		JLabel lblTuaDe = new JLabel("Tua de: ");
		lblTuaDe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTuaDe.setBounds(642, 296, 100, 32);
		add(lblTuaDe);
		
		JLabel lblSNT = new JLabel("So ngay thue:");
		lblSNT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSNT.setBounds(642, 378, 100, 40);
		add(lblSNT);
		
		txtSoNgayThue = new JTextField();
		txtSoNgayThue.setBounds(752, 377, 300, 46);
		add(txtSoNgayThue);
		txtSoNgayThue.setColumns(10);
		
		JButton btnCapNhat = new JButton("Cap Nhat");
		btnCapNhat.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCapNhat.setBounds(814, 460, 190, 54);
		add(btnCapNhat);

	}
}
