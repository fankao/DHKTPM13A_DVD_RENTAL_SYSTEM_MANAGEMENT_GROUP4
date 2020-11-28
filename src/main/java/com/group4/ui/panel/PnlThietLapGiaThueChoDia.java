package com.group4.ui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PnlThietLapGiaThueChoDia extends JPanel {
	private JTextField txtGiaThueHienTai;
	private JTextField txtGiaThueMoi;

	/**
	 * Create the panel.
	 */
	public PnlThietLapGiaThueChoDia() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel pnTitle = new JPanel();
		add(pnTitle, BorderLayout.NORTH);
		
		JLabel lblTitle = new JLabel("THIẾT LẬP GIÁ THUÊ CHO 1 LOẠI ĐĨA");
		lblTitle.setForeground(Color.BLUE);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 32));
		pnTitle.add(lblTitle);
		
		JPanel pnThietLapGiaThue = new JPanel();
		pnThietLapGiaThue.setBorder(null);
		add(pnThietLapGiaThue, BorderLayout.CENTER);
		pnThietLapGiaThue.setLayout(new BoxLayout(pnThietLapGiaThue, BoxLayout.X_AXIS));
		
		JPanel pnLeft = new JPanel();
		pnThietLapGiaThue.add(pnLeft);
		pnLeft.setLayout(new BoxLayout(pnLeft, BoxLayout.Y_AXIS));
		
		JPanel pnLBLLoaiDia = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnLBLLoaiDia.getLayout();
		flowLayout.setVgap(50);
		flowLayout.setAlignment(FlowLayout.RIGHT);
		pnLeft.add(pnLBLLoaiDia);
		
		JLabel lblLoaiDia = new JLabel("Loại đĩa:");
		lblLoaiDia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pnLBLLoaiDia.add(lblLoaiDia);
		
		JPanel pnLBLGiaThueHienTai = new JPanel();
		FlowLayout fl_pnLBLGiaThueHienTai = (FlowLayout) pnLBLGiaThueHienTai.getLayout();
		fl_pnLBLGiaThueHienTai.setVgap(50);
		fl_pnLBLGiaThueHienTai.setAlignment(FlowLayout.RIGHT);
		pnLeft.add(pnLBLGiaThueHienTai);
		
		JLabel lblGiaThueHienTai = new JLabel("Giá thuê hiện tại:");
		lblGiaThueHienTai.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pnLBLGiaThueHienTai.add(lblGiaThueHienTai);
		
		JPanel pnLBLGiaThueMoi = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) pnLBLGiaThueMoi.getLayout();
		flowLayout_2.setVgap(50);
		flowLayout_2.setAlignment(FlowLayout.RIGHT);
		pnLeft.add(pnLBLGiaThueMoi);
		
		JLabel lblGiaThueMoi = new JLabel("Giá thuê mới:");
		lblGiaThueMoi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pnLBLGiaThueMoi.add(lblGiaThueMoi);
		
		JPanel pnRight = new JPanel();
		pnThietLapGiaThue.add(pnRight);
		pnRight.setLayout(new BoxLayout(pnRight, BoxLayout.Y_AXIS));
		
		JPanel pnCBOLoaiDia = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) pnCBOLoaiDia.getLayout();
		flowLayout_3.setVgap(50);
		flowLayout_3.setAlignment(FlowLayout.LEFT);
		pnRight.add(pnCBOLoaiDia);
		
		JComboBox cboLoaiDia = new JComboBox();
		cboLoaiDia.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pnCBOLoaiDia.add(cboLoaiDia);
		
		JPanel pnTXTGiaThueHienTai = new JPanel();
		FlowLayout fl_pnTXTGiaThueHienTai = (FlowLayout) pnTXTGiaThueHienTai.getLayout();
		fl_pnTXTGiaThueHienTai.setVgap(50);
		fl_pnTXTGiaThueHienTai.setAlignment(FlowLayout.LEFT);
		pnRight.add(pnTXTGiaThueHienTai);
		
		txtGiaThueHienTai = new JTextField();
		txtGiaThueHienTai.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtGiaThueHienTai.setColumns(10);
		pnTXTGiaThueHienTai.add(txtGiaThueHienTai);
		
		JPanel pnTXTGiaThueMoi = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) pnTXTGiaThueMoi.getLayout();
		flowLayout_5.setVgap(50);
		flowLayout_5.setAlignment(FlowLayout.LEFT);
		pnRight.add(pnTXTGiaThueMoi);
		
		txtGiaThueMoi = new JTextField();
		txtGiaThueMoi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtGiaThueMoi.setColumns(10);
		pnTXTGiaThueMoi.add(txtGiaThueMoi);
		
		JPanel pnChucNang = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) pnChucNang.getLayout();
		add(pnChucNang, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("Lưu");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnChucNang.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Thoát");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnChucNang.add(btnNewButton_1);
	
		lblLoaiDia.setPreferredSize(lblGiaThueHienTai.getPreferredSize());
		lblGiaThueMoi.setPreferredSize(lblGiaThueHienTai.getPreferredSize());
	}

}
