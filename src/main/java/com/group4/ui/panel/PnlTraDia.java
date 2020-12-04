package com.group4.ui.panel;

import static com.group4.ui.panel.UtilsLayout.isInputFieldNotBlank;
import static com.group4.ui.panel.UtilsLayout.kichHoatButton;
import static com.group4.ui.panel.UtilsLayout.voHieuHoaButton;
import static com.group4.ui.panel.UtilsLayout.voHieuHoaTextField;
import static com.group4.ui.panel.UtilsLayout.xoaTrang;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.group4.business.ThanhToanPhiTreHanBUS;
import com.group4.business.ThueTraDiaBUS;
import com.group4.dao.IChiTietThueTraDAO;
import com.group4.dao.IDiaDAO;
import com.group4.dao.IKhachHangDAO;
import com.group4.dao.impl.ChiTietThueTraDAO;
import com.group4.dao.impl.DiaDAO;
import com.group4.dao.impl.KhachHangDAO;
import com.group4.entities.ChiTietThueTra;
import com.group4.entities.Dia;
import com.group4.entities.KhachHang;
import com.group4.entities.TrangThaiDia;
import com.group4.ui.ICloseUIListener;

public class PnlTraDia extends JPanel {
	private static final long serialVersionUID = 1L;
	private ICloseUIListener closeUIListener;
	private JTextField txtCustomerID;
	private JButton btnSearchDiaId;
	private JTextField txtKHID;
	private JButton btnXacNhan;
	private JTable tblListKH;
	private JLabel lbltuade;
	private JLabel lblhotenKH;
	private JLabel lblhiendcKH;
	private JButton btnGanDia;
	private JButton btnHuy;
	private JButton btnThoat;
	private JLabel lblngaydatKH;

	
	private JLabel lblhienSDTKH;
	
	private List<Dia> dsDiaTra = new ArrayList<Dia>();
	private KhachHang khachHangTra;
	
	private static IKhachHangDAO khachHangDAO;
	private static ThueTraDiaBUS thueTraDiaBUS;
	private static ThanhToanPhiTreHanBUS thanhToanPhiTreHanBUS;
	private static IDiaDAO diaDAO;
	private static IChiTietThueTraDAO thuetraDAO;

	static {
		khachHangDAO = new KhachHangDAO();
		thueTraDiaBUS = new ThueTraDiaBUS();
		thanhToanPhiTreHanBUS = new ThanhToanPhiTreHanBUS();
		diaDAO = new DiaDAO();
		thuetraDAO = new ChiTietThueTraDAO();
	}
	
	public PnlTraDia() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setSize(1270, 600);
		setLayout(new BorderLayout(0, 0));

		JPanel pnlTitle = new JPanel();
		FlowLayout fl_pnlTitle = (FlowLayout) pnlTitle.getLayout();
		fl_pnlTitle.setVgap(20);
		add(pnlTitle, BorderLayout.NORTH);

		JLabel lblTitle = new JLabel("TRẢ ĐĨA");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 25));
		pnlTitle.add(lblTitle);

		JPanel pnlMain = new JPanel();
		add(pnlMain, BorderLayout.CENTER);
		pnlMain.setLayout(new BorderLayout(0, 0));

		JPanel pnl_dia = new JPanel();
		pnl_dia.setBorder(new TitledBorder(
				new CompoundBorder(new LineBorder(new Color(0, 0, 0), 2), new EmptyBorder(5, 5, 5, 5)),
				"Th\u00F4ng tin \u0111\u0129a", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlMain.add(pnl_dia, BorderLayout.NORTH);
		pnl_dia.setLayout(new BoxLayout(pnl_dia, BoxLayout.Y_AXIS));

		JPanel pnl_timkiemMa = new JPanel();
		FlowLayout fl_pnl_timkiemMa = (FlowLayout) pnl_timkiemMa.getLayout();
		fl_pnl_timkiemMa.setAlignment(FlowLayout.LEFT);
		pnl_dia.add(pnl_timkiemMa);

		JLabel lbl_maDia = new JLabel("Mã Đĩa Trả");
		lbl_maDia.setFont(new Font("Dialog", Font.PLAIN, 20));
		pnl_timkiemMa.add(lbl_maDia);

		txtCustomerID = new JTextField();
		txtCustomerID.setFont(new Font("Dialog", Font.PLAIN, 20));
		pnl_timkiemMa.add(txtCustomerID);
		txtCustomerID.setColumns(15);

		btnSearchDiaId = new JButton("Xác nhận");
		btnSearchDiaId.setFont(new Font("Dialog", Font.PLAIN, 20));
		pnl_timkiemMa.add(btnSearchDiaId);

		JPanel pnlCenter = new JPanel();
		pnlMain.add(pnlCenter, BorderLayout.CENTER);
		pnlCenter.setLayout(new BorderLayout(0, 0));

		JPanel pnlTraDia = new JPanel();
		pnlTraDia.setBorder(new CompoundBorder(new EmptyBorder(10, 0, 0, 20), new LineBorder(new Color(0, 0, 0), 2)));
		pnlCenter.add(pnlTraDia, BorderLayout.CENTER);
		pnlTraDia.setLayout(new BorderLayout(0, 0));

		JPanel pnlGandia = new JPanel();
		pnlGandia.setBorder(
				new TitledBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 2), new EmptyBorder(5, 5, 5, 5)),
						"G\u00E1n \u0110\u0129a", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		pnlTraDia.add(pnlGandia, BorderLayout.CENTER);
		pnlGandia.setLayout(new BoxLayout(pnlGandia, BoxLayout.Y_AXIS));

		JPanel pnltuade = new JPanel();
		FlowLayout fl_pnltuade = (FlowLayout) pnltuade.getLayout();
		fl_pnltuade.setAlignment(FlowLayout.LEFT);
		pnlGandia.add(pnltuade);

		JLabel lblTuadeTitle = new JLabel("Tựa Đề: ");
		lblTuadeTitle.setFont(new Font("Dialog", Font.PLAIN, 20));
		pnltuade.add(lblTuadeTitle);

		lbltuade = new JLabel("Con Bò Cười");
		lbltuade.setFont(new Font("Dialog", Font.BOLD, 20));
		pnltuade.add(lbltuade);

		JPanel pnlthontinhKH = new JPanel();
		FlowLayout fl_pnlthontinhKH = (FlowLayout) pnlthontinhKH.getLayout();
		fl_pnlthontinhKH.setAlignment(FlowLayout.LEFT);
		pnlGandia.add(pnlthontinhKH);

		JLabel lblHoten = new JLabel("Họ Tên: ");
		lblHoten.setFont(new Font("Dialog", Font.PLAIN, 20));
		pnlthontinhKH.add(lblHoten);

		/* Ten KH */
		lblhotenKH = new JLabel("Nguyen Van Vy");
		lblhotenKH.setFont(new Font("Dialog", Font.BOLD, 20));
		pnlthontinhKH.add(lblhotenKH);

		Component horizontalGlue_2 = Box.createHorizontalGlue();
		horizontalGlue_2.setPreferredSize(new Dimension(20, 0));
		horizontalGlue_2.setMinimumSize(new Dimension(20, 0));
		pnlthontinhKH.add(horizontalGlue_2);

		JLabel lblSDTKH = new JLabel("Số Điện Thoại: ");
		lblSDTKH.setFont(new Font("Dialog", Font.PLAIN, 20));
		pnlthontinhKH.add(lblSDTKH);

		/* SDT KH */
		lblhienSDTKH = new JLabel("0924444659");
		lblhienSDTKH.setFont(new Font("Dialog", Font.BOLD, 20));
		pnlthontinhKH.add(lblhienSDTKH);

		Component horizontalGlue_2_1 = Box.createHorizontalGlue();
		horizontalGlue_2_1.setPreferredSize(new Dimension(20, 0));
		horizontalGlue_2_1.setMinimumSize(new Dimension(20, 0));
		pnlthontinhKH.add(horizontalGlue_2_1);

		JLabel lblDCKH = new JLabel("Địa chỉ: ");
		lblDCKH.setFont(new Font("Dialog", Font.PLAIN, 20));
		pnlthontinhKH.add(lblDCKH);

		/* SDT KH */
		lblhiendcKH = new JLabel("Gò Vấp");
		lblhiendcKH.setFont(new Font("Dialog", Font.BOLD, 20));
		pnlthontinhKH.add(lblhiendcKH);

		JPanel pnlNgayDatKH = new JPanel();
		FlowLayout fl_pnlNgayDatKH = (FlowLayout) pnlNgayDatKH.getLayout();
		fl_pnlNgayDatKH.setAlignment(FlowLayout.LEFT);
		pnlGandia.add(pnlNgayDatKH);

		JLabel lbl_ngaydat = new JLabel("Ngày Đặt Giữ: ");
		lbl_ngaydat.setFont(new Font("Dialog", Font.PLAIN, 20));
		pnlNgayDatKH.add(lbl_ngaydat);

		/* Ten KH */
		lblngaydatKH = new JLabel("15/05/2020");
		lblngaydatKH.setFont(new Font("Dialog", Font.BOLD, 20));
		pnlNgayDatKH.add(lblngaydatKH);

		JPanel pnlButton = new JPanel();
		FlowLayout fl_pnlbutton = (FlowLayout) pnlButton.getLayout();
		fl_pnlbutton.setAlignment(FlowLayout.CENTER);
		pnlGandia.add(pnlButton);

		btnGanDia = new JButton("Gán Đĩa");
		btnGanDia.setFont(new Font("Dialog", Font.PLAIN, 20));
		btnHuy = new JButton("Hủy Bỏ");
		btnHuy.setFont(new Font("Dialog", Font.PLAIN, 20));
		pnlButton.add(btnGanDia);
		pnlButton.add(btnHuy);

		JPanel pnlThoat = new JPanel();
		FlowLayout fl_pnlthoat = (FlowLayout) pnlThoat.getLayout();
		fl_pnlthoat.setAlignment(FlowLayout.RIGHT);
		pnlGandia.add(pnlThoat);

		btnThoat = new JButton("Thoát");
		btnThoat.setFont(new Font("Dialog", Font.PLAIN, 20));
		pnlThoat.add(btnThoat);

		ganSuKienButton();
	}
	
	/**
	 * Thiết lập sự kiện cho button
	 */
	private void ganSuKienButton() {
		
		btnSearchDiaId.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (isInputFieldNotBlank(PnlTraDia.this,txtCustomerID)) {
					Long diskId = null;
					try {
						diskId = Long.valueOf(txtCustomerID.getText());
					} catch (NumberFormatException ne) {
						hienThongBao("Lỗi nhập liệu", "Mã đĩa là số nguyên lớn hơn 0", JOptionPane.ERROR_MESSAGE);
						txtCustomerID.requestFocus();
						return;
					}

					List<ChiTietThueTra> dsTraDia = thuetraDAO.getDSChuaTraDiaTheoDia(diskId);
					Dia diaTra = diaDAO.findById(diskId);	
					KhachHang kh = dsTraDia.get(0).getKhachHang();
					System.out.println("dasdsa"+dsTraDia.get(0).getKhachHang());
					System.out.println("Day la Khach Hang"+kh.toString());
					khachHangTra = kh;
					
					System.out.println("dasdasds+"+ khachHangTra);
					if (dsTraDia == null) {
						hienThongBao("Lỗi tìm kiếm", "Không Tìm Thấy Đĩa", JOptionPane.ERROR_MESSAGE);
						txtCustomerID.requestFocus();
						return;
					}
					
					themDiaVaoDSTra(diaTra);
					hienDSDiaTra(dsTraDia);
					// Tra Dia
//					returnDia(khachHangTra,dsDiaTra,LocalDate.now());
//					diaTra.setTrangThai(TrangThaiDia.ON_SHEFT);
//					System.out.println("Trag Thai"+diaTra.getTrangThai());
//					dsTraDia.get(0).setNgayTra(LocalDate.now());
//					System.out.println("DS Tra Dia"+dsTraDia.get(0).getNgayTra());
//					
					
					diaTra.setTrangThai(TrangThaiDia.ON_SHEFT);
					diaDAO.update(diaTra);
					
//					ChiTietThueTra ct = thuetraDAO.getDSChuaTraDiaTheoDiavaKH(diaTra.getId());
					dsTraDia.get(0).setNgayTra(LocalDate.now());
					thuetraDAO.update(dsTraDia.get(0));
					
					// ngay tra it hon ngay hien tai
					System.out.println(dsTraDia.get(0).getNgayToiHan().toString());
					if(dsTraDia.get(0).getNgayToiHan().compareTo(LocalDate.now())>0){
						themPhiTreHen(dsDiaTra);
					}
				}
			}
			
		});
		
		btnThoat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				closeUIListener.onCloseUI(e);
			}
		});

	}

	/**
	 * Hiện thông tin khách hàng theo mã Đĩa Trả
	 * 
	 * @param khachHang: khách hàng cần hiện thông tin
	 */
	private void hienDSDiaTra(List<ChiTietThueTra> dsTraDia) {
		// TODO Auto-generated method stub
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		for(ChiTietThueTra ct : dsTraDia)
		{
			lbltuade.setText(ct.getDia().getTuaDe().getTenTuaDe().toString());
			lblhotenKH.setText(ct.getKhachHang().getHoVaTen().toString());
			lblhienSDTKH.setText(ct.getKhachHang().getSoDienThoai().toString());			
			lblhiendcKH.setText(ct.getKhachHang().getDiaChi().toString());			
			lblngaydatKH.setText(formatter.format(ct.getNgayToiHan()));
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
	/**
	 * Thêm Phí Trễ Hẹn	
	 * 
	 * @param 
	 */
	private void themPhiTreHen(List<Dia> dsDiaTra) {
		// TODO Auto-generated method stub
		
		double totalPrice = thueTraDiaBUS.tinhTongTienThueDia(new HashSet<Dia>(dsDiaTra));
		
		double phitrehen = 100;
		
		double tongTien = totalPrice + phitrehen;
		
		String tongTienString = NumberFormat.getCurrencyInstance(new Locale("vi", "VN")).format(tongTien);

		hienThongBao("Thêm Phí Trễ Hẹn","Phí Trễ Hẹn Lần Trước Là"+String.valueOf(totalPrice)+"Và Lần Này Là "+String.valueOf(phitrehen)+"-Tổng:"+tongTienString, JOptionPane.INFORMATION_MESSAGE);
	}
	
	
	private void returnDia(KhachHang kh, List<Dia> dsDiaThue,LocalDate ngaytra) {
		thueTraDiaBUS.traDia(kh, new HashSet<Dia>(dsDiaThue),ngaytra);
		hienThongBao("Thông báo", "Trả đĩa thành công", JOptionPane.INFORMATION_MESSAGE);
	}
	
	/**
	 * Đưa đĩa vào danh sách muốn thuê
	 * 
	 * @param diaThue: đĩa muốn thuê
	 */
	private void themDiaVaoDSTra(Dia diaTra) {
		dsDiaTra.add(diaTra);
	}
	
	public void setCloseUIListener(ICloseUIListener closeUIListener) {
		this.closeUIListener = closeUIListener;
	}

}
