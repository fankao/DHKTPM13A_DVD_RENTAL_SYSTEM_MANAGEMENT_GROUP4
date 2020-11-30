package com.group4.ui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

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
		lblSDTKH = new JLabel("0924444659");
		lblSDTKH.setFont(new Font("Dialog", Font.BOLD, 20));
		pnlthontinhKH.add(lblSDTKH);

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

	private void ganSuKienButton() {
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

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

	private static void createAndShowGUI() {
		System.out.println("Created GUI on EDT " + SwingUtilities.isEventDispatchThread());
		JFrame f = new JFrame("Swing Paint Demo");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.getContentPane().add(new PnlTraDia());
		f.setSize(800, 600);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
}
