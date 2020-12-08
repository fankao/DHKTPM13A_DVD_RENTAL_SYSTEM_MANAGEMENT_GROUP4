package com.group4.ui.panel;

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
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.group4.dao.IDiaDAO;
import com.group4.dao.impl.DiaDAO;
import com.group4.entities.Dia;
import com.group4.entities.KhachHang;
import com.group4.entities.TrangThaiDia;
import com.group4.ui.ICloseUIListener;

public class PnlBaoCaoTuaDe extends JPanel {
	private static final long serialVersionUID = 1L;
	private JComboBox<String> cb_loc;
	private JButton btnLoc;
	private DefaultTableModel dtmTuaDe;
	private JTable tblTuaDe;
	private JButton btnDong;
	private ICloseUIListener closeUIListener;
	private List<Dia> dsDia;
	
	
	private static IDiaDAO diaDAO;
	
	static {
		diaDAO = new DiaDAO();
	}
	/**
	 * Create the panel.
	 */
	public PnlBaoCaoTuaDe() {
		setForeground(Color.BLUE);
		setLayout(new BorderLayout(0, 0));
		setSize(1270,600);
		
		JPanel pnTitle = new JPanel();
		add(pnTitle, BorderLayout.NORTH);
		
		JLabel lblTitle = new JLabel("BÁO CÁO TỰA ĐỀ");
		lblTitle.setForeground(Color.BLACK);
		lblTitle.setFont(new Font("Arial", Font.BOLD, 32));
		pnTitle.add(lblTitle);
		
		JPanel pnDanhSachThongTinTD = new JPanel();
		add(pnDanhSachThongTinTD, BorderLayout.CENTER);
		pnDanhSachThongTinTD.setLayout(new BorderLayout(0, 0));
		
		JPanel pnLlocThongTin = new JPanel();
		pnDanhSachThongTinTD.add(pnLlocThongTin, BorderLayout.NORTH);
		pnLlocThongTin.setLayout(new BoxLayout(pnLlocThongTin, BoxLayout.X_AXIS));
		
		JPanel pnThongTin = new JPanel();
		pnThongTin.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "LỌC THÔNG TIN TỰA ĐỀ", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnLlocThongTin.add(pnThongTin);
		pnThongTin.setLayout(new BoxLayout(pnThongTin, BoxLayout.Y_AXIS));
		
		JPanel pnlLoc = new JPanel();
		pnThongTin.add(pnlLoc);
		
		JLabel lbllocthongtin = new JLabel("Lọc Thông Tin:");
		lbllocthongtin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlLoc.add(lbllocthongtin);
		
		cb_loc = new JComboBox<String>();
//		txtTenKhachHang.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlLoc.add(cb_loc);
//		cb_loc.setColumns(30);
		
		JPanel pnl_ButtonLoc = new JPanel();
		pnThongTin.add(pnl_ButtonLoc);
		
		btnLoc = new JButton("Lọc");
		btnLoc.setFont(new Font("Arial", Font.PLAIN, 20));
		pnThongTin.add(btnLoc);
		btnLoc.setPreferredSize(new Dimension(100, 50));
		
		JPanel pnlDanhSachTuaDe = new JPanel();
		pnlDanhSachTuaDe.setBorder(null);
		pnDanhSachThongTinTD.add(pnlDanhSachTuaDe, BorderLayout.CENTER);
		
		BorderLayout bl_pnDanhSachTuaDe = new BorderLayout();
		pnlDanhSachTuaDe.setLayout(bl_pnDanhSachTuaDe);
		
		pnDanhSachThongTinTD.add(pnlDanhSachTuaDe,BorderLayout.CENTER);
		
		JPanel pnTableBaoCao = new JPanel();
		pnTableBaoCao.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "Danh s\u00E1ch kh\u00E1ch h\u00E0ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlDanhSachTuaDe.add(pnTableBaoCao, BorderLayout.CENTER);
		pnTableBaoCao.setLayout(new BorderLayout());
		//tạo bảng
		dtmTuaDe = new DefaultTableModel();
		dtmTuaDe.addColumn("Id Tựa Đề");
		dtmTuaDe.addColumn("Tên Tựa Đề");
		dtmTuaDe.addColumn("Giá");
		dtmTuaDe.addColumn("Trạng Thái");
		dtmTuaDe.addColumn("Loại Đĩa");
		tblTuaDe = new JTable(dtmTuaDe);
		JScrollPane scTable = new JScrollPane(tblTuaDe,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		pnlDanhSachTuaDe.add(scTable,BorderLayout.CENTER);
		
		
		
		JPanel pnThoat = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnThoat.getLayout();
		flowLayout.setHgap(30);
		flowLayout.setAlignment(FlowLayout.RIGHT);
		pnDanhSachThongTinTD.add(pnThoat, BorderLayout.SOUTH);
		
		btnDong = new JButton("Đóng");
		btnDong.setFont(new Font("Arial", Font.PLAIN, 20));
		pnThoat.add(btnDong);
		btnDong.setPreferredSize(new Dimension(100, 50));
		
		HienThiComBoBox();
		
		
//		
		ganSuKienChoButton();
	}
	
	private void HienThiComBoBox() {
		// TODO Auto-generated method stub
		cb_loc.addItem(TrangThaiDia.ON_HOLD.toString());
		cb_loc.addItem(TrangThaiDia.ON_SHEFT.toString());
		cb_loc.addItem(TrangThaiDia.RENTED.toString());
	}

	private void hienDanhSachDia(List<Dia> dsDia) {
		DefaultTableModel tableModel = (DefaultTableModel) tblTuaDe.getModel();
		tableModel.setRowCount(0);
		for(Dia d: dsDia) {
			tableModel.addRow(new Object[] {d.getId(),d.getTuaDe().getTenTuaDe(),d.getLoaiDia().getPhiThue(),d.getTrangThai(),d.getLoaiDia().getTenLoaiDia()});
		}
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
	private void ganSuKienChoButton() {
		btnDong.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				closeUIListener.onCloseUI(e);
			}
		});
		btnLoc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (cb_loc.getSelectedItem().toString() == "Đã được gán") {
					dsDia = diaDAO.getDSDiaTheoTrangThai(TrangThaiDia.ON_HOLD);
					
					if (dsDia.size() > 0) {
						hienDanhSachDia(dsDia);
					}
					else
					{
						hienThongBao("Thông Báo","Không Có Thông Tin Cần Tìm", JOptionPane.DEFAULT_OPTION);
					}
				}
				else if (cb_loc.getSelectedItem().toString() == "Đã được thuê") {
					dsDia = diaDAO.getDSDiaTheoTrangThai(TrangThaiDia.RENTED);
					if (dsDia.size() > 0) {
						hienDanhSachDia(dsDia);
					}
					else
					{
						hienThongBao("Thông Báo","Không Có Thông Tin Cần Tìm", JOptionPane.DEFAULT_OPTION);
					}
				}
				else if (cb_loc.getSelectedItem().toString() == "Còn đĩa") {
					dsDia = diaDAO.getDSDiaTheoTrangThai(TrangThaiDia.ON_SHEFT);
					if (dsDia.size() > 0) {
						hienDanhSachDia(dsDia);
					}
					else
					{
						hienThongBao("Thông Báo","Không Có Thông Tin Cần Tìm", JOptionPane.DEFAULT_OPTION);
					}
				}
			}
		});
	}	
	public void setCloseUIListener(ICloseUIListener closeUIListener) {
		this.closeUIListener = closeUIListener;
	}
}
