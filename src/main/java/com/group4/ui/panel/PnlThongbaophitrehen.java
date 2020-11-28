package com.group4.ui.panel;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PnlThongbaophitrehen extends JPanel {

	/**
	 * Create the panel.
	 */
	public PnlThongbaophitrehen() {
		setLayout(new BorderLayout(0, 0));
		
		JLabel lbl_tieude = new JLabel("THÔNG BÁO PHÍ TRỄ HẸN");
		lbl_tieude.setFont(new Font("Tahoma", Font.BOLD, 24));
		lbl_tieude.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_tieude.setBackground(Color.LIGHT_GRAY);
		lbl_tieude.setForeground(new Color(160, 82, 45));
		add(lbl_tieude, BorderLayout.NORTH);
		
		JPanel pnl_main = new JPanel();
		add(pnl_main, BorderLayout.CENTER);
		pnl_main.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Mã Khách Hàng:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBounds(34, 34, 123, 26);
		pnl_main.add(lblNewLabel);
		
		JLabel lblTnKhchHng = new JLabel("Tên Khách Hàng:");
		lblTnKhchHng.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTnKhchHng.setBounds(34, 79, 123, 26);
		pnl_main.add(lblTnKhchHng);
		
		JLabel lblPhTrHn = new JLabel("Phí Trễ Hẹn:");
		lblPhTrHn.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPhTrHn.setBounds(34, 129, 123, 26);
		pnl_main.add(lblPhTrHn);
		
		JLabel lbl_maKH = new JLabel("Mã Khách Hàng:");
		lbl_maKH.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_maKH.setBounds(191, 34, 123, 26);
		pnl_main.add(lbl_maKH);
		
		JLabel lbl_tenKH = new JLabel("Mã Khách Hàng:");
		lbl_tenKH.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_tenKH.setBounds(191, 79, 123, 26);
		pnl_main.add(lbl_tenKH);
		
		JLabel lbl_phitrehen = new JLabel("Mã Khách Hàng:");
		lbl_phitrehen.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lbl_phitrehen.setBounds(191, 129, 123, 26);
		pnl_main.add(lbl_phitrehen);
		
		JButton btnNewButton = new JButton("Thoát");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(423, 184, 89, 34);
		pnl_main.add(btnNewButton);
		
		DefaultTableModel model=new DefaultTableModel()
	    {
	      public Class<?> getColumnClass(int column)
	      {
	        switch(column)
	        {
	        case 0:
	          return Boolean.class;
	        case 1:
	          return String.class;
	        case 2:
	          return String.class;
	        case 3:
	          return String.class;
	        case 4:
	          return String.class;

	          default:
	            return String.class;
	        }
	      }
	    };
	    model.addColumn("Chọn");
	    model.addColumn("Mã Đĩa");
	    model.addColumn("Ngày thuê");
	    model.addColumn("Ngày trả dự kiến");
	    model.addColumn("Ngày trả thực tế");
	    model.addColumn("Phí trể hẹn");
	    for(int i=0;i<=12;i++)
	    {
	      model.addRow(new Object[0]);
	      model.setValueAt(false,i,0);
	      model.setValueAt("MD"+(i+1), i, 1);
	      model.setValueAt("02/10/2020", i, 2);
	      model.setValueAt("05/10/2020", i, 3);
	      model.setValueAt("07/10/2020", i, 4);
	      model.setValueAt("1000000", i, 5);
	    }
		
		
	
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
        f.getContentPane().add(new PnlThongbaophitrehen());
        f.setSize(800, 600);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
