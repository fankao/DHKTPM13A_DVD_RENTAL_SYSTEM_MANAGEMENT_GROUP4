package com.group4.ui.panel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import static com.group4.ui.panel.UtilsLayout.kichHoatTextField;
import static com.group4.ui.panel.UtilsLayout.voHieuHoaButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.group4.dao.IKhachHangDAO;
import com.group4.dao.ITuaDeDAO;
import com.group4.dao.impl.KhachHangDAO;
import com.group4.dao.impl.TuaDeDAO;
import com.group4.entities.KhachHang;
import com.group4.entities.TuaDe;
import com.group4.ui.ICloseUIListener;

public class PnlQLTuade extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ICloseUIListener closeUIListener;
	private JTextField txtTenTuaDe;
//	private JTextField txtDiaChi;
//	private JTextField txtSoDienThoai;
	private JTextField txtNhapId;
	
	private JButton btnThemTuaDe;
	private JButton btnSuaTuaDe;
	private JButton btnLuuTuaDe;
	private JButton btnXoaTuaDe;
	private JButton btnDong;
	private JButton btnTimTuaDe;
	
	DefaultTableModel dtmTuaDe;
	JTable tblTuaDe;
	
	private TuaDe tuaDe;
	private List<TuaDe> dsTuaDe;
	
	private static ITuaDeDAO tuaDeDAO;
	
	static {
		tuaDeDAO = new TuaDeDAO();
	}
	
	/**
	 * Create the panel.
	 */
	public PnlQLTuade() {
		setForeground(Color.BLUE);
		setLayout(new BorderLayout(0, 0));
		setSize(1270,600);
		
		JPanel pnTitle = new JPanel();
		add(pnTitle, BorderLayout.NORTH);
		
		JLabel lblTitle = new JLabel("QU\u1EA2N L\u00DD TỰA ĐỀ");
		lblTitle.setForeground(Color.BLACK);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 32));
		pnTitle.add(lblTitle);
		
		JPanel pnDanhSachThongTinTuaDe = new JPanel();
		add(pnDanhSachThongTinTuaDe, BorderLayout.CENTER);
		pnDanhSachThongTinTuaDe.setLayout(new BorderLayout(0, 0));
		
		JPanel pnThongTinTuaDe = new JPanel();
		pnDanhSachThongTinTuaDe.add(pnThongTinTuaDe, BorderLayout.NORTH);
		pnThongTinTuaDe.setLayout(new BoxLayout(pnThongTinTuaDe, BoxLayout.X_AXIS));
		
		JPanel pnThongTin = new JPanel();
		pnThongTin.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Th\u00F4ng tin tựa đề", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnThongTinTuaDe.add(pnThongTin);
		pnThongTin.setLayout(new BoxLayout(pnThongTin, BoxLayout.Y_AXIS));
		
		JPanel pnTenTuaDe = new JPanel();
		pnThongTin.add(pnTenTuaDe);
		
		JLabel lblTenTuaDe = new JLabel("Tên khách hàng:");
		lblTenTuaDe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnTenTuaDe.add(lblTenTuaDe);
		
		txtTenTuaDe = new JTextField();
		txtTenTuaDe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnTenTuaDe.add(txtTenTuaDe);
		txtTenTuaDe.setColumns(30);
		
//		JPanel pnDiaChi = new JPanel();
//		pnThongTin.add(pnDiaChi);
//		
//		JLabel lblDiaChi = new JLabel("Địa chỉ:");
//		lblDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		pnDiaChi.add(lblDiaChi);
//		
//		txtDiaChi = new JTextField();
//		txtDiaChi.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		pnDiaChi.add(txtDiaChi);
//		txtDiaChi.setColumns(30);
		
		JPanel pnChucNang = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) pnChucNang.getLayout();
		flowLayout_1.setVgap(25);
		flowLayout_1.setHgap(10);
		pnChucNang.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnThongTinTuaDe.add(pnChucNang);
		
		btnThemTuaDe = new JButton("Thêm");
		btnThemTuaDe.setFont(new Font("Arial", Font.PLAIN, 20));
		pnChucNang.add(btnThemTuaDe);
		btnThemTuaDe.setPreferredSize(new Dimension(100, 50));
		
		btnSuaTuaDe = new JButton("Sửa");
		btnSuaTuaDe.setFont(new Font("Arial", Font.PLAIN, 20));
		pnChucNang.add(btnSuaTuaDe);
		btnSuaTuaDe.setPreferredSize(new Dimension(100, 50));
		
		btnXoaTuaDe = new JButton("Xóa");
		btnXoaTuaDe.setFont(new Font("Arial", Font.PLAIN, 20));
		pnChucNang.add(btnXoaTuaDe);
		btnXoaTuaDe.setPreferredSize(new Dimension(100, 50));
		
		btnLuuTuaDe = new JButton("Lưu");
		btnLuuTuaDe.setFont(new Font("Arial", Font.PLAIN, 20));
		pnChucNang.add(btnLuuTuaDe);
		btnLuuTuaDe.setPreferredSize(new Dimension(100, 50));
		
		
//		JPanel pnPhone = new JPanel();
//		pnThongTin.add(pnPhone);
//		
//		JLabel lblPhone = new JLabel("Số điện thoại:");
//		lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		pnPhone.add(lblPhone);
//		
//		txtSoDienThoai = new JTextField();
//		txtSoDienThoai.setFont(new Font("Tahoma", Font.PLAIN, 20));
//		pnPhone.add(txtSoDienThoai);
//		txtSoDienThoai.setColumns(30);
//		lblDiaChi.setPreferredSize(lblTenKhachHang.getPreferredSize());
//		lblPhone.setPreferredSize(lblTenKhachHang.getPreferredSize());
		
		JPanel pnDanhSachTuaDe = new JPanel();
		pnDanhSachTuaDe.setBorder(null);
		pnDanhSachThongTinTuaDe.add(pnDanhSachTuaDe, BorderLayout.CENTER);
		
		BorderLayout bl_pnDanhSachTuaDe = new BorderLayout();
		pnDanhSachTuaDe.setLayout(bl_pnDanhSachTuaDe);
		
		pnDanhSachThongTinTuaDe.add(pnDanhSachTuaDe,BorderLayout.CENTER);
		
		JPanel pnTableTuaDe = new JPanel();
		pnTableTuaDe.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Danh s\u00E1ch kh\u00E1ch h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnDanhSachTuaDe.add(pnTableTuaDe, BorderLayout.CENTER);
		pnTableTuaDe.setLayout(new BorderLayout());
		//tạo bảng
		dtmTuaDe = new DefaultTableModel();
		dtmTuaDe.addColumn("Id tựa đề");
		dtmTuaDe.addColumn("Tên tựa đề");
//		dtmTuaDe.addColumn("Địa chỉ");
//		dtmTuaDe.addColumn("Số điện thoại");
		tblTuaDe = new JTable(dtmTuaDe);
		JScrollPane scTable = new JScrollPane(tblTuaDe,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		pnTableTuaDe.add(scTable,BorderLayout.CENTER);
		
		JPanel pnTimTuaDe = new JPanel();
		FlowLayout fl_pnTimTuaDe = (FlowLayout) pnTimTuaDe.getLayout();
		fl_pnTimTuaDe.setAlignment(FlowLayout.LEFT);
		pnDanhSachTuaDe.add(pnTimTuaDe, BorderLayout.NORTH);
		
		JLabel lblNhap = new JLabel("Nhập id tựa đề:");
		lblNhap.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnTimTuaDe.add(lblNhap);
		
		txtNhapId = new JTextField();
		txtNhapId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnTimTuaDe.add(txtNhapId);
		txtNhapId.setColumns(10);
		
		btnTimTuaDe = new JButton("Tìm kiếm");
		btnTimTuaDe.setFont(new Font("Arial", Font.PLAIN, 20));
		pnTimTuaDe.add(btnTimTuaDe);
		
		JPanel pnThoat = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnThoat.getLayout();
		flowLayout.setHgap(30);
		flowLayout.setAlignment(FlowLayout.RIGHT);
		pnDanhSachThongTinTuaDe.add(pnThoat, BorderLayout.SOUTH);
		
		btnDong = new JButton("Đóng");
		btnDong.setFont(new Font("Arial", Font.PLAIN, 20));
		pnThoat.add(btnDong);
		btnDong.setPreferredSize(new Dimension(100, 50));
		
		dsTuaDe = tuaDeDAO.findAll();
		hienDanhSachKhachHang(dsTuaDe);
		ganSuKienChoButton();
		
		btnSuaTuaDe.setEnabled(false);
		btnXoaTuaDe.setEnabled(false);
		btnLuuTuaDe.setEnabled(false);
		txtTenTuaDe.setEditable(false);
//		txtDiaChi.setEditable(false);
//		txtSoDienThoai.setEditable(false);
		
	}
	private void hienDanhSachKhachHang(List<TuaDe> dsTuaDe) {
		DefaultTableModel tableModel = (DefaultTableModel) tblTuaDe.getModel();
		tableModel.setRowCount(0);
		for(TuaDe td : dsTuaDe) {
			tableModel.addRow(new Object[] {td.getId(),td.getTenTuaDe()});
		}
	}
	private void ganSuKienChoButton() {
		btnDong.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				closeUIListener.onCloseUI(e);
			}
		});
		
		tblTuaDe.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				btnLuuTuaDe.setEnabled(false);
				int select = tblTuaDe.getSelectedRow();
				
				if(select==-1)return;
				
				
				hienThongTinKhachHang(dsTuaDe.get(select));
				btnSuaTuaDe.setEnabled(true);
				btnXoaTuaDe.setEnabled(true);
				
				txtTenTuaDe.setEditable(false);
			}
			
		});
		
		btnThemTuaDe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				xuLyThemKhachHang();
			}
		});
		
		btnSuaTuaDe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnLuuTuaDe.setEnabled(true);
				txtTenTuaDe.setEditable(true);
				
			}
		});
		
		btnXoaTuaDe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int selectIndex = -1;
				selectIndex = tblTuaDe.getSelectedRow();
				
				if(selectIndex >=0 ) {
					TuaDe tuade = dsTuaDe.get(selectIndex);
					
					int option = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa khách hàng này?", "Xác nhận yêu cầu", JOptionPane.YES_NO_OPTION);
					
					if(option == JOptionPane.YES_OPTION) {
						
						tuaDeDAO.deleteById(tuade.getId());
						hienDanhSachKhachHang(tuaDeDAO.findAll());
						JOptionPane.showMessageDialog(null, "Xóa khách hàng thành công!!!");
					}
					
				}
			}
		});
		
		btnTimTuaDe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(isValidInput(txtNhapId)) {
					Long cusId = null;
					try {
						cusId = Long.valueOf(txtNhapId.getText());
					} catch (NumberFormatException e2) {
						hienThongBao("Mã khách hàng là số nguyên lớn hơn 0");
						txtNhapId.requestFocus();
						return;
					}
					
					tuaDe = tuaDeDAO.findById(cusId);
					hienThongTinKhachHang(tuaDe);
					btnSuaTuaDe.setEnabled(true);
					btnXoaTuaDe.setEnabled(true);
				}
			}
		});
		
		btnXoaTuaDe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(checkKhachHangDangThueDia()) {
					
				}
			}
		});
	}
	
	protected void xuLyThemKhachHang() {
		xoaTrangInput();
		voHieuHoaButton(btnLuuTuaDe,btnSuaTuaDe,btnXoaTuaDe);
		kichHoatTextField(txtTenTuaDe);
	}
	protected void xoaTrangInput() {
		txtTenTuaDe.setText("");
		txtTenTuaDe.requestFocus();
		
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
	protected void hienThongTinKhachHang(TuaDe td) {
		txtTenTuaDe.setText(td.getTenTuaDe());
	}
	public void setCloseUIListener(ICloseUIListener closeUIListener) {
		this.closeUIListener = closeUIListener;
	}
	
}
