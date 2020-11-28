package com.group4.ui.panel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PnlQLTuade extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTable tbl_qlTua;

	/**
	 * Create the panel.
	 */
	public PnlQLTuade() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel pnl_Tieude = new JPanel();
		add(pnl_Tieude, BorderLayout.NORTH);
		
		JLabel lbl_Tieude = new JLabel("Qu\u1EA3n L\u00FD T\u1EF1a \u0110\u1EC1");
		lbl_Tieude.setFont(new Font("Tahoma", Font.BOLD, 24));
		pnl_Tieude.add(lbl_Tieude);
		
		JPanel pnl_quanlytuade = new JPanel();
		add(pnl_quanlytuade, BorderLayout.CENTER);
		pnl_quanlytuade.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("file1");
		lblNewLabel.setBounds(24, 21, 116, 14);
		pnl_quanlytuade.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(150, 18, 86, 20);
		pnl_quanlytuade.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("file2");
		lblNewLabel_1.setBounds(24, 64, 89, 14);
		pnl_quanlytuade.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(150, 61, 86, 20);
		pnl_quanlytuade.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("file3");
		lblNewLabel_2.setBounds(24, 108, 116, 14);
		pnl_quanlytuade.add(lblNewLabel_2);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		rdbtnNewRadioButton.setBounds(174, 104, 109, 23);
		pnl_quanlytuade.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("New radio button");
		rdbtnNewRadioButton_1.setBounds(285, 104, 109, 23);
		pnl_quanlytuade.add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("file4");
		lblNewLabel_3.setBounds(400, 21, 134, 14);
		pnl_quanlytuade.add(lblNewLabel_3);
		
		textField_2 = new JTextField();
		textField_2.setBounds(544, 18, 86, 20);
		pnl_quanlytuade.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("file5");
		lblNewLabel_4.setBounds(400, 61, 134, 14);
		pnl_quanlytuade.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(544, 61, 86, 20);
		pnl_quanlytuade.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("file6");
		lblNewLabel_5.setBounds(400, 108, 134, 14);
		pnl_quanlytuade.add(lblNewLabel_5);
		
		textField_4 = new JTextField();
		textField_4.setBounds(544, 105, 86, 20);
		pnl_quanlytuade.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnNewButton = new JButton("Th\u00EAm");
		btnNewButton.setBounds(24, 158, 89, 23);
		pnl_quanlytuade.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("X\u00F3a");
		btnNewButton_1.setBounds(163, 158, 89, 23);
		pnl_quanlytuade.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("S\u1EEDa");
		btnNewButton_2.setBounds(301, 158, 89, 23);
		pnl_quanlytuade.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("M\u1EDBi");
		btnNewButton_3.setBounds(453, 158, 89, 23);
		pnl_quanlytuade.add(btnNewButton_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 218, 680, 182);
		pnl_quanlytuade.add(scrollPane);
		
		tbl_qlTua = new JTable();
		tbl_qlTua.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(tbl_qlTua);
		
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
        f.getContentPane().add(new PnlQLTuade());
        f.setSize(800, 600);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
