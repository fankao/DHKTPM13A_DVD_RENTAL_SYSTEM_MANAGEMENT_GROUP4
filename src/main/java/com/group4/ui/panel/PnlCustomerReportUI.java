package com.group4.ui.panel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class PnlCustomerReportUI extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String[] colName;
	private String [][] dataKH;
	private JTable tblDSKH;
	private JTable tblDSTreHan;
	private JTable tblDSNoPhiTreHan;
	/**
	 * Create the panel.
	 */
	public PnlCustomerReportUI() {
		setLayout(null);
		
		JLabel lblHeader = new JLabel("BÁO CÁO KHÁCH HÀNG");
		lblHeader.setBounds(463, 5, 353, 37);
		lblHeader.setFont(new Font("Tahoma", Font.BOLD, 30));
		add(lblHeader);
		
		colName = new String [] {"STT", "Ma KH", "Ho va ten", "So dien thoai", "Dia chi"};
		dataKH = new String [][] {
			{"1", "KH001", "Ngoc Sang", "0123123123", "Go Vap, TPHCM"},
			{"2", "KH002", "Vu Bang", "12345667890", "Tan binh, TPHCM"}
		};
		
		JScrollPane scrDSKH = new JScrollPane();
		scrDSKH.setBounds(10, 189, 700, 500);
		add(scrDSKH);
		
		tblDSKH = new JTable(dataKH,colName);
		tblDSKH.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"STT", "ID", "H\u1ECD v\u00E0 t\u00EAn", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "\u0110\u1ECBa ch\u1EC9"
			}
		));
		tblDSKH.getColumnModel().getColumn(2).setPreferredWidth(150);
		tblDSKH.getColumnModel().getColumn(3).setPreferredWidth(100);
		tblDSKH.getColumnModel().getColumn(4).setPreferredWidth(150);
		tblDSKH.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrDSKH.setViewportView(tblDSKH);
		
		JScrollPane scrTreHan = new JScrollPane();
		scrTreHan.setBounds(720, 189, 539, 240);
		add(scrTreHan);
		tblDSTreHan = new JTable();
		tblDSTreHan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tblDSTreHan.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"ST", "M\u00E3 \u0111\u0129a", "Ti\u00EAu \u0111\u1EC1", "H\u1EA1n tr\u1EA3 \u0111\u0129a"
			}
		));
		tblDSTreHan.getColumnModel().getColumn(2).setPreferredWidth(150);
		scrTreHan.setViewportView(tblDSTreHan);
		
		JScrollPane scrDSNo = new JScrollPane();
		scrDSNo.setBounds(720, 449, 539, 240);
		add(scrDSNo);
		
		tblDSNoPhiTreHan = new JTable();
		tblDSNoPhiTreHan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tblDSNoPhiTreHan.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"STT", "M\u00E3 kh\u00E1ch h\u00E0ng", "Ti\u00EAu \u0111\u1EC1", "H\u1EA1n tr\u1EA3", "Ng\u00E0y tr\u1EA3", "Ti\u1EC1n ph\u1EA1"
			}
		));
		tblDSNoPhiTreHan.getColumnModel().getColumn(1).setPreferredWidth(95);
		tblDSNoPhiTreHan.getColumnModel().getColumn(2).setPreferredWidth(150);
		scrDSNo.setViewportView(tblDSNoPhiTreHan);
		
		JLabel lblBaoCao = new JLabel("Ch\u1ECDn lo\u1EA1i b\u00E1o c\u00E1o:");
		lblBaoCao.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblBaoCao.setBounds(10, 113, 172, 28);
		add(lblBaoCao);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"T\u1EA5t c\u1EA3 kh\u00E1ch h\u00E0ng", "Kh\u00E1ch h\u00E0ng c\u00F3 \u0111\u0129a tr\u1EC5 h\u1EA1n", "Kh\u00E1ch h\u00E0ng c\u00F3 ph\u00ED tr\u1EC5 h\u1EA1n"}));
		comboBox.setBounds(182, 109, 266, 40);
		add(comboBox);

	}
}
