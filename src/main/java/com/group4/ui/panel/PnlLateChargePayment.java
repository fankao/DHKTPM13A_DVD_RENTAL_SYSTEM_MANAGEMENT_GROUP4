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

public class PnlLateChargePayment extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField txt_timmakhachang;
	private JTable table_trehen;

	/**
	 * Create the panel.
	 */
	public PnlLateChargePayment() {
		setLayout(new BorderLayout(0, 0));
		
		JLabel lbl_tieude = new JLabel("THANH TO\u00C1N PH\u00CD TR\u1EC4 H\u1EA0N");
		lbl_tieude.setFont(new Font("Tahoma", Font.BOLD, 24));
		lbl_tieude.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_tieude.setBackground(Color.LIGHT_GRAY);
		lbl_tieude.setForeground(new Color(160, 82, 45));
		add(lbl_tieude, BorderLayout.NORTH);
		
		JPanel pnl_main = new JPanel();
		add(pnl_main, BorderLayout.CENTER);
		pnl_main.setLayout(null);
		
		JPanel pnl_timkhachhang = new JPanel();
		pnl_timkhachhang.setForeground(new Color(0, 0, 139));
		pnl_timkhachhang.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Kh\u00E1ch H\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
		pnl_timkhachhang.setBounds(10, 11, 730, 110);
		pnl_main.add(pnl_timkhachhang);
		pnl_timkhachhang.setLayout(null);
		
		txt_timmakhachang = new JTextField();
		txt_timmakhachang.setBounds(10, 23, 127, 34);
		pnl_timkhachhang.add(txt_timmakhachang);
		txt_timmakhachang.setColumns(10);
		
		JButton btn_timmakhachhang = new JButton("T\u00ECm");
		btn_timmakhachhang.setBounds(153, 22, 55, 35);
		pnl_timkhachhang.add(btn_timmakhachhang);
		
		JLabel lbl_tieudehoten = new JLabel("H\u1ECD V\u00E0 T\u00EAn:");
		lbl_tieudehoten.setBounds(10, 85, 70, 14);
		pnl_timkhachhang.add(lbl_tieudehoten);
		
		JLabel lbl_tieudesdt = new JLabel("S\u1ED1 \u0110i\u1EC7n Tho\u1EA1i:");
		lbl_tieudesdt.setBounds(218, 85, 100, 14);
		pnl_timkhachhang.add(lbl_tieudesdt);
		
		JLabel lbl_hienthitenkhachhang = new JLabel("R\u1ED7ng");
		lbl_hienthitenkhachhang.setBounds(90, 85, 118, 14);
		pnl_timkhachhang.add(lbl_hienthitenkhachhang);
		
		JLabel lbl_hienthisdt = new JLabel("R\u1ED7ng");
		lbl_hienthisdt.setBounds(328, 85, 150, 14);
		pnl_timkhachhang.add(lbl_hienthisdt);
		
		JLabel lbl_diachi = new JLabel("Địa Chỉ:");
		lbl_diachi.setBounds(488, 85, 100, 14);
		pnl_timkhachhang.add(lbl_diachi);
		
		JLabel lbl_hienthidiachi = new JLabel("Rỗng");
		lbl_hienthidiachi.setBounds(593, 85, 127, 14);
		pnl_timkhachhang.add(lbl_hienthidiachi);
		
		JPanel pnl_phitrehen = new JPanel();
		pnl_phitrehen.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Ph\u00ED Tr\u1EC5 H\u1EB9n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(106, 90, 205)));
		pnl_phitrehen.setBounds(10, 146, 730, 259);
		pnl_main.add(pnl_phitrehen);
		pnl_phitrehen.setLayout(null);
		
		JPanel pnl_tablechiphitrehen = new JPanel();
		pnl_tablechiphitrehen.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnl_tablechiphitrehen.setBounds(10, 25, 525, 223);
		pnl_phitrehen.add(pnl_tablechiphitrehen);
		pnl_tablechiphitrehen.setLayout(null);
		
		JCheckBox chk_thanhtoantatca = new JCheckBox("Thanh to\u00E1n t\u1EA5t c\u1EA3");
		chk_thanhtoantatca.setBounds(20, 182, 149, 23);
		pnl_tablechiphitrehen.add(chk_thanhtoantatca);
		
		JLabel lbl_thanhtoanmotphan = new JLabel("Thanh to\u00E1n m\u1ED9t ph\u1EA7n:");
		lbl_thanhtoanmotphan.setBounds(209, 186, 130, 14);
		pnl_tablechiphitrehen.add(lbl_thanhtoanmotphan);
		
		JComboBox cmb_chonthanhtoan = new JComboBox();
		cmb_chonthanhtoan.setModel(new DefaultComboBoxModel(new String[] {"1"}));
		cmb_chonthanhtoan.setBounds(330, 183, 52, 20);
		pnl_tablechiphitrehen.add(cmb_chonthanhtoan);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 505, 165);
		pnl_tablechiphitrehen.add(scrollPane);
		
		table_trehen = new JTable();
		
		scrollPane.setViewportView(table_trehen);
		
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
	    
	    table_trehen.setModel(model);
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
	    
	    
		JPanel pnl_tongchiphitrehen = new JPanel();
		pnl_tongchiphitrehen.setBorder(new LineBorder(new Color(0, 0, 0)));
		pnl_tongchiphitrehen.setBounds(545, 25, 175, 223);
		pnl_phitrehen.add(pnl_tongchiphitrehen);
		pnl_tongchiphitrehen.setLayout(null);
		
		JPanel pnl_tongtien = new JPanel();
		pnl_tongtien.setBorder(new TitledBorder(null, "T\u1ED5ng Ph\u00ED", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnl_tongtien.setBounds(10, 11, 155, 110);
		pnl_tongchiphitrehen.add(pnl_tongtien);
		pnl_tongtien.setLayout(new BorderLayout(0, 0));
		
		JLabel lbl_tongtien = new JLabel("200000");
		lbl_tongtien.setFont(new Font("Tahoma", Font.BOLD, 14));
		lbl_tongtien.setHorizontalAlignment(SwingConstants.CENTER);
		pnl_tongtien.add(lbl_tongtien, BorderLayout.CENTER);
		
		JButton btn_Xacnhan = new JButton("X\u00E1c Nh\u1EADn");
		btn_Xacnhan.setBounds(44, 132, 89, 23);
		pnl_tongchiphitrehen.add(btn_Xacnhan);
		
		JButton btn_huy = new JButton("H\u1EE7y B\u1ECF");
		btn_huy.setBounds(44, 177, 89, 23);
		pnl_tongchiphitrehen.add(btn_huy);
		
		
	
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
        f.getContentPane().add(new PnlLateChargePayment());
        f.setSize(800, 600);
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
}
