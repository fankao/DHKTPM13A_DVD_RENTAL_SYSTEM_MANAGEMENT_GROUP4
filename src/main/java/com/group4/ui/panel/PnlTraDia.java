package com.group4.ui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class PnlTraDia extends JPanel {
	private JTable tbl_tradia;
	private JTextField textField;

	public PnlTraDia() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel pnl_top = new JPanel();
		add(pnl_top, BorderLayout.NORTH);
		
		JLabel lbl_tieude = new JLabel("TR\u1EA2 \u0110\u0128A");
		lbl_tieude.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_tieude.setForeground(Color.GRAY);
		lbl_tieude.setFont(new Font("Tahoma", Font.BOLD, 24));
		pnl_top.add(lbl_tieude);
		
		JPanel pnl_tradia = new JPanel();
		add(pnl_tradia, BorderLayout.CENTER);
		pnl_tradia.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 680, 325);
		pnl_tradia.add(scrollPane);
		
		tbl_tradia = new JTable();
		tbl_tradia.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"M\u00E3 Thu\u00EA \u0110\u0129a", "T\u00EAn Kh\u00E1ch H\u00E0ng", "Ng\u00E0y L\u1EADp H\u00F3a \u0110\u01A1n", "Tr\u1EA1ng Th\u00E1i"
			}
		));
		scrollPane.setViewportView(tbl_tradia);
		
		JLabel lbl_timkiem = new JLabel("T\u00ECm Ki\u1EBFm:");
		lbl_timkiem.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_timkiem.setBounds(10, 361, 100, 30);
		pnl_tradia.add(lbl_timkiem);
		
		textField = new JTextField();
		textField.setBounds(141, 363, 229, 30);
		pnl_tradia.add(textField);
		textField.setColumns(10);
		
		JButton btn_tradia = new JButton("Tr\u1EA3 \u0110\u0129a");
		btn_tradia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_tradia.setBounds(404, 347, 108, 56);
		pnl_tradia.add(btn_tradia);
		
		JButton btn_themphitrehen = new JButton("Th\u00EAm Ph\u00ED Tr\u1EC5 H\u1EB9n");
		btn_themphitrehen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btn_themphitrehen.setBounds(522, 347, 147, 56);
		pnl_tradia.add(btn_themphitrehen);
		
		
	}
		
	 public static void main(String[] args) {
	        SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                createAndShowGUI(); 
	            }
	        });
	    }

	    private static void createAndShowGUI() {
	        System.out.println("Created GUI on EDT? "+
	        SwingUtilities.isEventDispatchThread());
	        JFrame f = new JFrame("Swing Paint Demo");
	        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        f.getContentPane().add(new PnlTraDia());
	        f.setSize(800, 600);
	        f.setLocationRelativeTo(null);
	        f.setVisible(true);
	    }
}
