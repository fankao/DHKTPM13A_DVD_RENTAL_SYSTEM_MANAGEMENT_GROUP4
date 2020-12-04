package com.group4.ui.panel;
import static com.group4.ui.panel.UtilsLayout.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import com.group4.dao.IKhachHangDAO;
import com.group4.dao.impl.KhachHangDAO;
import com.group4.entities.KhachHang;
import com.group4.ui.ICloseUIListener;

public class PnlQuanLyKhachHang extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ICloseUIListener closeUIListener;
	private JTextField txtTenKhachHang;
	private JTextField txtDiaChi;
	private JTextField txtSoDienThoai;
	private JTextField txtNhapId;
	
	private JButton btnThemKhachHang;
	private JButton btnSuaKhachHang;
	private JButton btnLuuKhachHang;
	private JButton btnXoaKhachHang;
	private JButton btnDong;
	private JButton btnTimKH;
	
	DefaultTableModel dtmKhachHang;
	JTable tblKhachHang;
	
	private KhachHang khachHang;
	private List<KhachHang> dsKH;
	
	private static IKhachHangDAO khachHangDAO;
	
	static {
		khachHangDAO = new KhachHangDAO();
	}
	
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
		pnDanhSachThongTinKH.add(pnThongTinKhachHang, BorderLayout.NORTH);
		pnThongTinKhachHang.setLayout(new BoxLayout(pnThongTinKhachHang, BoxLayout.X_AXIS));
		
		JPanel pnThongTin = new JPanel();
		pnThongTin.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Th\u00F4ng tin kh\u00E1ch h\u00E0ng", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnThongTinKhachHang.add(pnThongTin);
		pnThongTin.setLayout(new BoxLayout(pnThongTin, BoxLayout.Y_AXIS));
		
		JPanel pnTenKH = new JPanel();
		pnThongTin.add(pnTenKH);
		
		JLabel lblTenKhachHang = new JLabel("Tên khách hàng:");
		lblTenKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnTenKH.add(lblTenKhachHang);
		
		txtTenKhachHang = new JTextField();
		txtTenKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnTenKH.add(txtTenKhachHang);
		txtTenKhachHang.setColumns(30);
		
		JPanel pnDiaChi = new JPanel();
		pnThongTin.add(pnDiaChi);
		
		JLabel lblDiaChi = new JLabel("Địa chỉ:");
		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnDiaChi.add(lblDiaChi);
		
		txtDiaChi = new JTextField();
		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnDiaChi.add(txtDiaChi);
		txtDiaChi.setColumns(30);
		
		JPanel pnChucNang = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) pnChucNang.getLayout();
		flowLayout_1.setVgap(25);
		flowLayout_1.setHgap(10);
		pnChucNang.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnThongTinKhachHang.add(pnChucNang);
		
		btnThemKhachHang = new JButton("Thêm");
		btnThemKhachHang.setFont(new Font("Arial", Font.PLAIN, 20));
		pnChucNang.add(btnThemKhachHang);
		btnThemKhachHang.setPreferredSize(new Dimension(100, 50));
		
		btnSuaKhachHang = new JButton("Sửa");
		btnSuaKhachHang.setFont(new Font("Arial", Font.PLAIN, 20));
		pnChucNang.add(btnSuaKhachHang);
		btnSuaKhachHang.setPreferredSize(new Dimension(100, 50));
		
		btnXoaKhachHang = new JButton("Xóa");
		btnXoaKhachHang.setFont(new Font("Arial", Font.PLAIN, 20));
		pnChucNang.add(btnXoaKhachHang);
		btnXoaKhachHang.setPreferredSize(new Dimension(100, 50));
		
		btnLuuKhachHang = new JButton("Lưu");
		btnLuuKhachHang.setFont(new Font("Arial", Font.PLAIN, 20));
		pnChucNang.add(btnLuuKhachHang);
		btnLuuKhachHang.setPreferredSize(new Dimension(100, 50));
		
		
		JPanel pnPhone = new JPanel();
		pnThongTin.add(pnPhone);
		
		JLabel lblPhone = new JLabel("Số điện thoại:");
		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnPhone.add(lblPhone);
		
		txtSoDienThoai = new JTextField();
		txtSoDienThoai.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnPhone.add(txtSoDienThoai);
		txtSoDienThoai.setColumns(30);
		lblDiaChi.setPreferredSize(lblTenKhachHang.getPreferredSize());
		lblPhone.setPreferredSize(lblTenKhachHang.getPreferredSize());
		
		JPanel pnDanhSachKhachHang = new JPanel();
		pnDanhSachKhachHang.setBorder(null);
		pnDanhSachThongTinKH.add(pnDanhSachKhachHang, BorderLayout.CENTER);
		
		BorderLayout bl_pnDanhSachKhachHang = new BorderLayout();
		pnDanhSachKhachHang.setLayout(bl_pnDanhSachKhachHang);
		
		pnDanhSachThongTinKH.add(pnDanhSachKhachHang,BorderLayout.CENTER);
		
		JPanel pnTableKhachHang = new JPanel();
		pnTableKhachHang.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Danh s\u00E1ch kh\u00E1ch h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnDanhSachKhachHang.add(pnTableKhachHang, BorderLayout.CENTER);
		pnTableKhachHang.setLayout(new BorderLayout());
		//tạo bảng
		dtmKhachHang = new DefaultTableModel();
		dtmKhachHang.addColumn("Id khách hàng");
		dtmKhachHang.addColumn("Tên khách hàng");
		dtmKhachHang.addColumn("Địa chỉ");
		dtmKhachHang.addColumn("Số điện thoại");
		tblKhachHang = new JTable(dtmKhachHang);
		JScrollPane scTable = new JScrollPane(tblKhachHang,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		pnTableKhachHang.add(scTable,BorderLayout.CENTER);
		
		JPanel pnTimKhachHang = new JPanel();
		FlowLayout fl_pnTimKhachHang = (FlowLayout) pnTimKhachHang.getLayout();
		fl_pnTimKhachHang.setAlignment(FlowLayout.LEFT);
		pnDanhSachKhachHang.add(pnTimKhachHang, BorderLayout.NORTH);
		
		JLabel lblNhap = new JLabel("Nhập id khách hàng:");
		lblNhap.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnTimKhachHang.add(lblNhap);
		
		txtNhapId = new JTextField();
		txtNhapId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnTimKhachHang.add(txtNhapId);
		txtNhapId.setColumns(10);
		
		btnTimKH = new JButton("Tìm kiếm");
		btnTimKH.setFont(new Font("Arial", Font.PLAIN, 20));
		pnTimKhachHang.add(btnTimKH);
		
		JPanel pnThoat = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnThoat.getLayout();
		flowLayout.setHgap(30);
		flowLayout.setAlignment(FlowLayout.RIGHT);
		pnDanhSachThongTinKH.add(pnThoat, BorderLayout.SOUTH);
		
		btnDong = new JButton("Đóng");
		btnDong.setFont(new Font("Arial", Font.PLAIN, 20));
		pnThoat.add(btnDong);
		btnDong.setPreferredSize(new Dimension(100, 50));
		
		dsKH = khachHangDAO.findAll();
		hienDanhSachKhachHang(dsKH);
		ganSuKienChoButton();
		
		btnSuaKhachHang.setEnabled(false);
		btnXoaKhachHang.setEnabled(false);
		btnLuuKhachHang.setEnabled(false);
		txtTenKhachHang.setEditable(false);
		txtDiaChi.setEditable(false);
		txtSoDienThoai.setEditable(false);
		
	}
	private void hienDanhSachKhachHang(List<KhachHang> dsKH) {
		DefaultTableModel tableModel = (DefaultTableModel) tblKhachHang.getModel();
		tableModel.setRowCount(0);
		for(KhachHang kh : dsKH) {
			tableModel.addRow(new Object[] {kh.getId(),kh.getHoVaTen(),kh.getDiaChi(),kh.getSoDienThoai()});
		}
	}
	private void ganSuKienChoButton() {
		btnDong.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				closeUIListener.onCloseUI(e);
			}
		});
		
		tblKhachHang.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				btnLuuKhachHang.setEnabled(false);
				int select = tblKhachHang.getSelectedRow();
				
				if(select==-1)return;
				
				
				hienThongTinKhachHang(dsKH.get(select));
				btnSuaKhachHang.setEnabled(true);
				btnXoaKhachHang.setEnabled(true);
				
				txtTenKhachHang.setEditable(false);
				txtDiaChi.setEditable(false);
				txtSoDienThoai.setEditable(false);
			}
			
		});
		
		btnThemKhachHang.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				xuLyThemKhachHang();
			}
		});
		
		btnSuaKhachHang.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnLuuKhachHang.setEnabled(true);
				txtTenKhachHang.setEditable(true);
				txtDiaChi.setEditable(true);
				txtSoDienThoai.setEditable(true);
			}
		});
		
		btnXoaKhachHang.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectIndex = -1;
				selectIndex = tblKhachHang.getSelectedRow();
				
				if(selectIndex >=0 ) {
					KhachHang kh = dsKH.get(selectIndex);
					
					int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa khách hàng này?", "Xác nhận yêu cầu", JOptionPane.YES_NO_OPTION);
					
					if(option == JOptionPane.YES_OPTION) {
						
						khachHangDAO.deleteById(kh.getId());
						hienDanhSachKhachHang(khachHangDAO.findAll());
						JOptionPane.showMessageDialog(null, "Xóa khách hàng thành công!!!");
					}
					
				}
			}
		});
		
		btnTimKH.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(isValidInput(txtNhapId)) {
					Long cusId = null;
					try {
						cusId = Long.valueOf(txtNhapId.getText());
						if(cusId <=0) {
							hienThongBao("mã khách hàng phải là số nguyên lớn hơn 0!");
							return;
						}
					} catch (NumberFormatException e2) {
						hienThongBao("Mã khách hàng là số nguyên lớn hơn 0");
						txtNhapId.requestFocus();
						return;
					}
					
					khachHang = khachHangDAO.findById(cusId);
					hienThongTinKhachHang(khachHang);
					btnSuaKhachHang.setEnabled(true);
					btnXoaKhachHang.setEnabled(true);
				}
			}
		});
		
		btnXoaKhachHang.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(checkKhachHangDangThueDia()) {
					
				}
			}
		});
	}
	
	protected void xuLyThemKhachHang() {
		xoaTrangInput();
		voHieuHoaButton(btnLuuKhachHang,btnSuaKhachHang,btnXoaKhachHang);
		kichHoatTextField(txtTenKhachHang,txtDiaChi,txtSoDienThoai);
	}
	protected void xoaTrangInput() {
		txtTenKhachHang.setText("");
		txtDiaChi.setText("");
		txtSoDienThoai.setText("");
		txtTenKhachHang.requestFocus();
		
	}
	protected boolean checkKhachHangDangThueDia() {
		
		return false;
	}
	protected boolean isValidInput(JTextField txt) {
		if(txt.getText().trim().isEmpty()) {
			hienThongBao("Mời nhập dữ liệu!");
			txtNhapId.requestFocus();
			return false;
		}
		return true;
	}
	private void hienThongBao(String string) {
		JLabel label = new JLabel(string);
		label.setFont(new Font("Arial", Font.BOLD, 18));
		JOptionPane.showMessageDialog(this, label);
	}
	protected void hienThongTinKhachHang(KhachHang khachHang) {
		txtTenKhachHang.setText(khachHang.getHoVaTen());
		txtDiaChi.setText(khachHang.getDiaChi());
		txtSoDienThoai.setText(khachHang.getSoDienThoai());
	}
	public void setCloseUIListener(ICloseUIListener closeUIListener) {
		this.closeUIListener = closeUIListener;
	}
	
}
