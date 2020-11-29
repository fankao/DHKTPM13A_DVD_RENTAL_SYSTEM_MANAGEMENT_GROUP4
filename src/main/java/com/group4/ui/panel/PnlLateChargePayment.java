package com.group4.ui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.group4.business.ThanhToanPhiTreHanBUS;
import com.group4.entities.KhachHang;

public class PnlLateChargePayment extends JPanel {
	private static final long serialVersionUID = 1L;
	private static ThanhToanPhiTreHanBUS thanhToanPhiTreHanBUS;
	static {
		thanhToanPhiTreHanBUS = new ThanhToanPhiTreHanBUS();
	}
	
	private KhachHang khachHangThanhToan;
	
	private JTextField txtCustomerId;
	private JTable tblLateCharges;
	private JLabel lblCustomerName;
	private JLabel lblCustomerPhone;
	private JLabel lblCustomerAddress;
	private JLabel lblTotalPrice;
	private JButton btnCancel;
	private JButton btnConfirm;
	private JButton btnSearchCusId;
	private JPanel pnlCustomerInfo;

	/**
	 * Create the panel.
	 */
	public PnlLateChargePayment(KhachHang khachHang) {
		setLayout(new BorderLayout(0, 0));
		setSize(1270, 600);
		JLabel lbl_tieude = new JLabel("THANH TO\u00C1N PH\u00CD TR\u1EC4 H\u1EA0N");
		lbl_tieude.setFont(new Font("Tahoma", Font.BOLD, 24));
		lbl_tieude.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_tieude.setBackground(Color.LIGHT_GRAY);
		lbl_tieude.setForeground(new Color(160, 82, 45));
		add(lbl_tieude, BorderLayout.NORTH);
		
		JPanel pnl_main = new JPanel();
		add(pnl_main, BorderLayout.CENTER);
		pnl_main.setLayout(new BorderLayout(0, 0));
		
		JPanel pnl_timkhachhang = new JPanel();
		pnl_timkhachhang.setForeground(new Color(0, 0, 139));
		pnl_timkhachhang.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Kh\u00E1ch H\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 128)));
		pnl_main.add(pnl_timkhachhang, BorderLayout.NORTH);
		pnl_timkhachhang.setLayout(new BoxLayout(pnl_timkhachhang, BoxLayout.Y_AXIS));
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		pnl_timkhachhang.add(panel);
		
		JLabel lblCustomerId = new JLabel("Nhập mã khách hàng");
		lblCustomerId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(lblCustomerId);
		
		txtCustomerId = new JTextField();
		txtCustomerId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(txtCustomerId);
		txtCustomerId.setColumns(10);
		
		btnSearchCusId = new JButton("T\u00ECm");
		btnSearchCusId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(btnSearchCusId);
		
		pnlCustomerInfo = new JPanel();
		FlowLayout fl_pnlCustomerInfo = (FlowLayout) pnlCustomerInfo.getLayout();
		fl_pnlCustomerInfo.setAlignment(FlowLayout.LEFT);
		pnl_timkhachhang.add(pnlCustomerInfo);
		
		JLabel lblCustomerNameTit = new JLabel("H\u1ECD V\u00E0 T\u00EAn:");
		lblCustomerNameTit.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlCustomerInfo.add(lblCustomerNameTit);
		
		lblCustomerName = new JLabel("New label");
		lblCustomerName.setFont(new Font("Tahoma", Font.BOLD, 20));
		pnlCustomerInfo.add(lblCustomerName);
		
		Component horizontalGlue = Box.createHorizontalGlue();
		horizontalGlue.setPreferredSize(new Dimension(20, 0));
		pnlCustomerInfo.add(horizontalGlue);
		
		JLabel lbl_tieudesdt = new JLabel("S\u1ED1 \u0110i\u1EC7n Tho\u1EA1i:");
		lbl_tieudesdt.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlCustomerInfo.add(lbl_tieudesdt);
		
		lblCustomerPhone = new JLabel("R\u1ED7ng");
		lblCustomerPhone.setFont(new Font("Tahoma", Font.BOLD, 20));
		pnlCustomerInfo.add(lblCustomerPhone);
		
		Component horizontalGlue_1 = Box.createHorizontalGlue();
		horizontalGlue_1.setPreferredSize(new Dimension(20, 0));
		pnlCustomerInfo.add(horizontalGlue_1);
		
		JLabel lbl_diachi = new JLabel("Địa Chỉ:");
		lbl_diachi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlCustomerInfo.add(lbl_diachi);
		
		lblCustomerAddress = new JLabel("Rỗng");
		lblCustomerAddress.setFont(new Font("Tahoma", Font.BOLD, 20));
		pnlCustomerInfo.add(lblCustomerAddress);
		
		JPanel pnl_phitrehen = new JPanel();
		pnl_phitrehen.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Ph\u00ED Tr\u1EC5 H\u1EB9n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(106, 90, 205)));
		pnl_main.add(pnl_phitrehen);
		pnl_phitrehen.setLayout(new BorderLayout(0, 0));
		
		JPanel pnl_tablechiphitrehen = new JPanel();
		pnl_tablechiphitrehen.setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 20), new LineBorder(new Color(0, 0, 0), 2)));
		pnl_phitrehen.add(pnl_tablechiphitrehen, BorderLayout.CENTER);
		pnl_tablechiphitrehen.setLayout(null);
		
		JCheckBox chkSelectAll = new JCheckBox("Thanh to\u00E1n t\u1EA5t c\u1EA3");
		chkSelectAll.setFont(new Font("Tahoma", Font.PLAIN, 20));
		chkSelectAll.setBounds(10, 399, 208, 31);
		pnl_tablechiphitrehen.add(chkSelectAll);
		
		JLabel lbl_thanhtoanmotphan = new JLabel("Thanh to\u00E1n m\u1ED9t ph\u1EA7n:");
		lbl_thanhtoanmotphan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbl_thanhtoanmotphan.setBounds(407, 399, 221, 31);
		pnl_tablechiphitrehen.add(lbl_thanhtoanmotphan);
		
		JComboBox cmb_chonthanhtoan = new JComboBox();
		cmb_chonthanhtoan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cmb_chonthanhtoan.setModel(new DefaultComboBoxModel(new String[] {"1"}));
		cmb_chonthanhtoan.setBounds(640, 399, 47, 31);
		pnl_tablechiphitrehen.add(cmb_chonthanhtoan);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 992, 380);
		pnl_tablechiphitrehen.add(scrollPane);
		
		tblLateCharges = new JTable();
		tblLateCharges.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		scrollPane.setViewportView(tblLateCharges);
		
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
	    
	    tblLateCharges.setModel(model);
	    model.addColumn("Chọn");
	    model.addColumn("Mã Đĩa");
	    model.addColumn("Ngày thuê");
	    model.addColumn("Ngày trả dự kiến");
	    model.addColumn("Ngày trả thực tế");
	    model.addColumn("Phí trể hẹn");
		JPanel pnl_tongchiphitrehen = new JPanel();
		pnl_tongchiphitrehen.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		pnl_phitrehen.add(pnl_tongchiphitrehen, BorderLayout.EAST);
		pnl_tongchiphitrehen.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel pnl_tongtien = new JPanel();
		pnl_tongtien.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "T\u1ED5ng Ph\u00ED Tr\u1EC5 h\u1EA1n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnl_tongchiphitrehen.add(pnl_tongtien);
		pnl_tongtien.setLayout(new BorderLayout(0, 0));
		
		lblTotalPrice = new JLabel("0 đ");
		lblTotalPrice.setForeground(Color.RED);
		lblTotalPrice.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTotalPrice.setHorizontalAlignment(SwingConstants.CENTER);
		pnl_tongtien.add(lblTotalPrice);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new EmptyBorder(20, 20, 20, 20));
		pnl_tongchiphitrehen.add(panel_2);
		panel_2.setLayout(new GridLayout(3, 1, 10, 10));
		
		btnConfirm = new JButton("X\u00E1c Nh\u1EADn");
		panel_2.add(btnConfirm);
		btnConfirm.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		btnCancel = new JButton("H\u1EE7y B\u1ECF");
		panel_2.add(btnCancel);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JButton btnClose = new JButton("Thoát");
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2.add(btnClose);
		
		//hiện thông tin khách hàng
		if(khachHang!=null) {
			hienThongTinKhachHang(khachHang);
		}
		
		//gán sự kiện cho Button
		ganSuKienChoButton();
		
		
		
	
	}
	
	/**
	 * Gán sư kiện cho button
	 */
	private void ganSuKienChoButton() {
		btnSearchCusId.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		
	}

	/**
	 * Hiện thông tin khách hàng
	 * @param khachHang: khach hàng cần hiện thông tin
	 */
	private void hienThongTinKhachHang(KhachHang khachHang) {
		
		
	}
	/*
	 * private static void createAndShowGUI(KhachHang kh) {
	 * System.out.println("Created GUI on EDT? "+
	 * SwingUtilities.isEventDispatchThread()); JFrame f = new
	 * JFrame("Swing Paint Demo"); f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 * f.getContentPane().add(new PnlLateChargePayment(kh)); f.setSize(800, 600);
	 * f.setLocationRelativeTo(null); f.setVisible(true); }
	 */
}
