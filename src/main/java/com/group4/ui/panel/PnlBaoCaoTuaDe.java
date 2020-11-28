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
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class PnlBaoCaoTuaDe extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTable table;

	/**
	 * Create the panel.
	 */
	public PnlBaoCaoTuaDe() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel pnl_title = new JPanel();
		add(pnl_title, BorderLayout.NORTH);
		
		JLabel lbl_title = new JLabel("B\u00C1O C\u00C1O T\u1EF0A \u0110\u1EC0");
		lbl_title.setForeground(Color.ORANGE);
		lbl_title.setFont(new Font("Tahoma", Font.BOLD, 24));
		pnl_title.add(lbl_title);
		
		JPanel pnl_baocaotuade = new JPanel();
		add(pnl_baocaotuade, BorderLayout.CENTER);
		pnl_baocaotuade.setLayout(null);
		
		JPanel pnl_chonlocchitieu = new JPanel();
		pnl_chonlocchitieu.setBounds(0, 0, 200, 461);
		pnl_chonlocchitieu.setBorder(new TitledBorder(null, "Ch\u1ECDn l\u1ECDc ch\u1EC9 ti\u00EAu c\u1EA7n l\u1ECDc", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnl_baocaotuade.add(pnl_chonlocchitieu);
		pnl_chonlocchitieu.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "L\u1ECDc", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 22, 180, 201);
		pnl_chonlocchitieu.add(panel);
		
		JPanel pnl_thongtin = new JPanel();
		pnl_thongtin.setBorder(new TitledBorder(null, "Th\u00F4ng Tin T\u1EF1a \u0110\u1EC1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnl_thongtin.setBounds(201, 0, 740, 461);
		pnl_baocaotuade.add(pnl_thongtin);
		pnl_thongtin.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 237, 619, 213);
		pnl_thongtin.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"BBB", "AAAA", "CCC", "DDD", "WWWW"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel pnl_thongtin1 = new JPanel();
		pnl_thongtin1.setBorder(new TitledBorder(null, "Th\u00F4ng Tin 1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnl_thongtin1.setBounds(10, 21, 167, 205);
		pnl_thongtin.add(pnl_thongtin1);
		
		JPanel pnl_thongtin2 = new JPanel();
		pnl_thongtin2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th\u00F4ng Tin 2", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnl_thongtin2.setBounds(189, 21, 167, 205);
		pnl_thongtin.add(pnl_thongtin2);
		
		JPanel pnl_thongtin3 = new JPanel();
		pnl_thongtin3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th\u00F4ng Tin 3", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnl_thongtin3.setBounds(366, 21, 167, 205);
		pnl_thongtin.add(pnl_thongtin3);
		
		JPanel pnl_thongtin4 = new JPanel();
		pnl_thongtin4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th\u00F4ng Tin 4", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnl_thongtin4.setBounds(550, 21, 167, 205);
		pnl_thongtin.add(pnl_thongtin4);
		
		JButton btn_Loc = new JButton("Lọc");
		btn_Loc.setBounds(10, 472, 89, 23);
		pnl_baocaotuade.add(btn_Loc);
		
		JButton btn_hienthi = new JButton("Hiển Thị");
		btn_hienthi.setBounds(111, 472, 89, 23);
		pnl_baocaotuade.add(btn_hienthi);
		
		JLabel lbl_tong = new JLabel("T\u1ED5ng T\u1EF1a \u0110\u1EC1:");
		lbl_tong.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_tong.setBounds(555, 462, 141, 23);
		pnl_baocaotuade.add(lbl_tong);
		
		JLabel lbl_tuade = new JLabel("Doanh S\u1ED1");
		lbl_tuade.setBounds(699, 462, 141, 20);
		pnl_baocaotuade.add(lbl_tuade);
		
		JLabel lbl_doanhthu = new JLabel("T\u1ED5ng Doanh Thu:");
		lbl_doanhthu.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_doanhthu.setBounds(555, 496, 141, 23);
		pnl_baocaotuade.add(lbl_doanhthu);
		
		JLabel lbl_doanhso = new JLabel("Doanh S\u1ED1");
		lbl_doanhso.setBounds(699, 496, 141, 20);
		pnl_baocaotuade.add(lbl_doanhso);
		
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
        f.getContentPane().add(new PnlBaoCaoTuaDe());
        f.setSize(1200, 600);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
