package com.group4.ui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.group4.ui.ICloseUIListener;

public class PnlQuanLyKhachHang extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ICloseUIListener closeUIListener;
	private JTextField txtTenKhachHang;
	private JTextField txtDiaChi;
	private JTextField txtPhone;

	DefaultTableModel tableModel;
	JTable table;
	private JButton btnThoat;
	/**
	 * Create the panel.
	 */
	public PnlQuanLyKhachHang() {
		setForeground(Color.BLUE);
		setLayout(new BorderLayout(0, 0));
		setSize(1270,600);
		
		JPanel pnTitle = new JPanel();
		add(pnTitle, BorderLayout.NORTH);
		
		JLabel lblTitle = new JLabel("QU\u1EA2N L\u00DD KH\u00C1CH H\u00C0NG");
		lblTitle.setForeground(Color.BLACK);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 32));
		pnTitle.add(lblTitle);
		
		JPanel pnDanhSachThongTinKH = new JPanel();
		add(pnDanhSachThongTinKH, BorderLayout.CENTER);
		pnDanhSachThongTinKH.setLayout(new BorderLayout(0, 0));
		
		JPanel pnThongTinKhachHang = new JPanel();
		pnDanhSachThongTinKH.add(pnThongTinKhachHang, BorderLayout.WEST);
		pnThongTinKhachHang.setLayout(new BorderLayout(0, 0));
		
		JPanel pnThongTin = new JPanel();
		pnThongTin.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Th\u00F4ng tin kh\u00E1ch h\u00E0ng", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(255, 0, 0)));
		pnThongTinKhachHang.add(pnThongTin, BorderLayout.CENTER);
		pnThongTin.setLayout(new BoxLayout(pnThongTin, BoxLayout.Y_AXIS));
		
		JPanel pnTenKH = new JPanel();
		pnThongTin.add(pnTenKH);
		
		JLabel lblTenKhachHang = new JLabel("Tên khách hàng:");
		pnTenKH.add(lblTenKhachHang);
		
		txtTenKhachHang = new JTextField();
		pnTenKH.add(txtTenKhachHang);
		txtTenKhachHang.setColumns(30);
		
		JPanel pnDiaChi = new JPanel();
		pnThongTin.add(pnDiaChi);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		pnDiaChi.add(lblDiaChi);
		
		txtDiaChi = new JTextField();
		pnDiaChi.add(txtDiaChi);
		txtDiaChi.setColumns(30);
		
		JPanel pnChucNang = new JPanel();
		pnChucNang.setBorder(new TitledBorder(null, "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		pnThongTinKhachHang.add(pnChucNang, BorderLayout.SOUTH);
		
		JButton btnThemKhachHang = new JButton("Thêm");
		pnChucNang.add(btnThemKhachHang);
		
		JButton btnSuaKhachHang = new JButton("Sửa");
		pnChucNang.add(btnSuaKhachHang);
		
		JButton btnXoaKhachHang = new JButton("Xóa");
		pnChucNang.add(btnXoaKhachHang);
		
		JButton btnLuu = new JButton("Lưu");
		pnChucNang.add(btnLuu);
		
		btnThoat = new JButton("Thoát");
		pnChucNang.add(btnThoat);
		
		
		
		JPanel pnPhone = new JPanel();
		pnThongTin.add(pnPhone);
		
		JLabel lblPhone = new JLabel("Số điện thoại:");
		pnPhone.add(lblPhone);
		
		txtPhone = new JTextField();
		pnPhone.add(txtPhone);
		txtPhone.setColumns(30);
		lblDiaChi.setPreferredSize(lblTenKhachHang.getPreferredSize());
		lblPhone.setPreferredSize(lblTenKhachHang.getPreferredSize());
		
		JPanel pnDanhSachKhachHang = new JPanel();
		pnDanhSachKhachHang.setBorder(null);
		pnDanhSachThongTinKH.add(pnDanhSachKhachHang, BorderLayout.CENTER);
		
		pnDanhSachKhachHang.setLayout(new BorderLayout());
		
		pnDanhSachThongTinKH.add(pnDanhSachKhachHang,BorderLayout.CENTER);
		
		JPanel pnTableKhachHang = new JPanel();
		pnDanhSachKhachHang.add(pnTableKhachHang, BorderLayout.CENTER);
		pnTableKhachHang.setLayout(new BorderLayout(0, 0));
		
		JPanel pnTitleTableKhachHang = new JPanel();
		pnDanhSachKhachHang.add(pnTitleTableKhachHang, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Danh sách khách hàng");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 24));
		pnTitleTableKhachHang.add(lblNewLabel);
		
		tableModel = new DefaultTableModel();
		table = new JTable(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"M\u00E3 Kh\u00E1ch h\u00E0ng", "T\u00EAn kh\u00E1ch h\u00E0ng", "\u0110\u1ECBa ch\u1EC9", "S\u1ED1 \u0111i\u1EC7n tho\u1EA1i", "Gi\u1EDBi t\u00EDnh"
			}
		));
		JScrollPane scTable = new JScrollPane(table,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		pnTableKhachHang.add(scTable,BorderLayout.CENTER);
		ganSuKienChoButton();
	}
	private void ganSuKienChoButton() {
		btnThoat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				closeUIListener.onCloseUI(e);
				
			}
		});
		
	}
	public void setCloseUIListener(ICloseUIListener closeUIListener) {
		this.closeUIListener = closeUIListener;
	}
	
}
