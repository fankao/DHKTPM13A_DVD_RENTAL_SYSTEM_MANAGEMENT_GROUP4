package com.group4.ui.panel;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import static com.group4.ui.panel.UtilsLayout.isInputFieldNotBlank;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.group4.dao.ILoaiDiaDAO;
import com.group4.dao.impl.LoaiDiaDAO;
import com.group4.entities.ChiTietThueTra;
import com.group4.entities.Dia;
import com.group4.entities.KhachHang;
import com.group4.entities.LoaiDia;
import com.group4.entities.TrangThaiDia;
import com.group4.entities.TuaDe;
import com.group4.ui.ICloseUIListener;

import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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
	private ICloseUIListener closeUIListener;
	private JButton btnCapNhat;
	private JButton btnThoat;
	private DefaultTableModel dtmLoaidia;
	private List<LoaiDia> dsLoaiDia;

	private static ILoaiDiaDAO loaidiaDAO;
	
	static {
		loaidiaDAO = new LoaiDiaDAO();
	}
	
	/**
	 * Create the panel.
	 */
	public PnlUpdateTimeRent() {
		setLayout(null);
		
		JLabel lblHeader = new JLabel("Thiet lap thoi gian thue dia");
		lblHeader.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblHeader.setBounds(573, 26, 319, 72);
		add(lblHeader);
		
		
		
		dtmLoaidia = new DefaultTableModel();
		dtmLoaidia.addColumn("ID");
		dtmLoaidia.addColumn("Tên Loại Đĩa");
		dtmLoaidia.addColumn("Số Ngày Thuê");
		table = new  JTable(dtmLoaidia);
		
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		JScrollPane scrollPane = new JScrollPane(table,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(36, 114, 542, 535);
		add(scrollPane);
		
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
		
		JLabel lblTuaDe = new JLabel("Tên Loại Đĩa: ");
		lblTuaDe.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTuaDe.setBounds(642, 296, 100, 32);
		add(lblTuaDe);
		
		JLabel lblSNT = new JLabel("Số Ngày Thuê:");
		lblSNT.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSNT.setBounds(642, 378, 100, 40);
		add(lblSNT);
		
		txtSoNgayThue = new JTextField();
		txtSoNgayThue.setBounds(752, 377, 300, 46);
		add(txtSoNgayThue);
		txtSoNgayThue.setColumns(10);
		
		btnCapNhat = new JButton("Cập Nhật");
		btnCapNhat.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnCapNhat.setBounds(814, 460, 190, 54);
		add(btnCapNhat);

		btnThoat = new JButton("Thoát");
		btnThoat.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnThoat.setBounds(960, 460, 190, 54);
		add(btnThoat);
		
		dsLoaiDia = loaidiaDAO.findAll();
		hienDanhSachLoaiDia(dsLoaiDia);
		
		ganSuKienButton();
	}
	private void ganSuKienButton() {	
		
		btnCapNhat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				LoaiDia dia = loaidiaDAO.findById(Long.parseLong(txtID.getText().toString()));
				
				dia.setSoNgayThue(Integer.parseInt(txtSoNgayThue.getText().toString()));
				
				loaidiaDAO.update(dia);
				xoaTrangFiled();
				hienDanhSachLoaiDia(dsLoaiDia);
				hienThongBao("Thành công","Thành Công",JOptionPane.DEFAULT_OPTION);
			}

		});

		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				// TODO Auto-generated method stub
				int select = table.getSelectedRow();
				
				if (select == -1 ) {
//					hienThongBao("Chưa Chọn","Mời Bạn Chọn Loại Đĩa",JOptionPane.ERROR_MESSAGE);
					return;
				}
				
//				LoaiDia dia = loaidiaDAO.findById(Long.parseLong(dtmLoaidia.getColumnName(0).toString()));
				hienThongTinLoaiDia(dsLoaiDia.get(select));

			}
		});
		btnThoat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				closeUIListener.onCloseUI(e);
			}
		});

	}
	private void xoaTrangFiled() {
		// TODO Auto-generated method stub
		txtID.setText("");
		txtTuaDe.setText("");
		txtSoNgayThue.setText("");
	}
	protected void hienThongTinLoaiDia(LoaiDia ld) {
		txtID.setText(ld.getId().toString());
		txtTuaDe.setText(ld.getTenLoaiDia().toString());
		txtSoNgayThue.setText(ld.getSoNgayThue()+"");
	}
	private void hienDanhSachLoaiDia(List<LoaiDia> dsLoaiDia) {
		DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
		tableModel.setRowCount(0);
		for(LoaiDia ld : dsLoaiDia) {
			tableModel.addRow(new Object[] {ld.getId(),ld.getTenLoaiDia(),ld.getSoNgayThue()});
		}
	}
	/**
	 * Hiện thông tin khách hàng theo mã Đĩa Trả
	 * 
	 * @param khachHang: khách hàng cần hiện thông tin
	 */
	private void hienDSLoaiDia(Long ld) {
		// TODO Auto-generated method stub
		LoaiDia loaidia = loaidiaDAO.findById(ld);
	}
	/**
	 * Hiện thông báo	
	 * 
	 * @param msg: thông báo cần hiển thị
	 */
	private void hienThongBao(String title, String msg, int msgType) {
		JLabel label = new JLabel(msg);
		label.setFont(new Font("Arial", Font.BOLD, 18));
		JOptionPane.showMessageDialog(this, label, title, msgType);

	}
	
	public void setCloseUIListener(ICloseUIListener closeUIListener) {
		this.closeUIListener = closeUIListener;
	}
}
