package com.group4.ui.dialog;
import static com.group4.Injection.*;
import static com.group4.ui.panel.UtilsLayout.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import com.group4.entities.ChiTietDatGiu;
import com.group4.entities.Dia;
import com.group4.entities.KhachHang;
import com.group4.entities.TuaDe;
import com.group4.ui.ICloseUIListener;
import com.group4.ui.panel.PnlCustomerCommon;

public class DlgGanDia extends JDialog {
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private ICloseUIListener closeUIListener;
	private ChiTietDatGiu chiTietDatGiu = null;

	private JLabel lblDiskId;
	private JLabel lblNewLabel_2;
	private JLabel lblDiskCate;
	private JLabel lblDiskTitle;
	private PnlCustomerCommon pnlCustomerCommon;
	private JPanel pnlCustomer;
	private JButton btnHuyGanDia;
	private JButton btnClose;
	private Dia diaGan;
	

	/**
	 * Create the dialog.
	 */
	public DlgGanDia(Dia dia) {
		setSize(922, 406);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));

		JLabel lblNewLabel = new JLabel("THÔNG TIN GÁN ĐĨA");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPanel.add(lblNewLabel, BorderLayout.NORTH);

		JPanel pnlInfo = new JPanel();
		contentPanel.add(pnlInfo, BorderLayout.CENTER);
		pnlInfo.setLayout(new BoxLayout(pnlInfo, BoxLayout.Y_AXIS));

		JPanel panel = new JPanel();
		pnlInfo.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_1 = new JPanel();
		panel.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.Y_AXIS));

		JPanel panel_2_1;
		panel_2_1 = new JPanel();
		FlowLayout fl_panel_2_1;
		fl_panel_2_1 = (FlowLayout) panel_2_1.getLayout();
		fl_panel_2_1.setAlignment(FlowLayout.LEFT);
		panel_1.add(panel_2_1);

		JLabel lblNewLabel_1 = new JLabel("Mã đĩa: ");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblDiskId = new JLabel("");
		lblDiskId.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_2_1.add(lblNewLabel_1);
		panel_2_1.add(lblDiskId);

		JPanel panel_2_2;
		panel_2_2 = new JPanel();
		FlowLayout fl_panel_2_2;
		fl_panel_2_2 = (FlowLayout) panel_2_2.getLayout();
		fl_panel_2_2.setAlignment(FlowLayout.LEFT);
		panel_1.add(panel_2_2);

		lblNewLabel_2 = new JLabel("Loại đĩa: ");
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_2_2.add(lblNewLabel_2);
		lblDiskCate = new JLabel("");
		lblDiskCate.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_2_2.add(lblDiskCate);

		JPanel panel_2_3;
		panel_2_3 = new JPanel();
		FlowLayout fl_panel_2_3;
		fl_panel_2_3 = (FlowLayout) panel_2_3.getLayout();
		fl_panel_2_3.setAlignment(FlowLayout.LEFT);
		panel_1.add(panel_2_3);
		JLabel lblNewLabel_2_1 = new JLabel("Tựa đề: ");
		lblNewLabel_2_1.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_2_3.add(lblNewLabel_2_1);

		lblDiskTitle = new JLabel("");
		lblDiskTitle.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel_2_3.add(lblDiskTitle);

		pnlCustomer = new JPanel();
		pnlCustomer.setBorder(new TitledBorder(null, "Th\u00F4ng tin kh\u00E1ch h\u00E0ng \u0111\u1EB7t \u0111\u0129a",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.add(pnlCustomer);
		pnlCustomer.setLayout(new BorderLayout(0, 0));

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);
		
		btnHuyGanDia = new JButton("Huỷ gán đĩa");
		btnHuyGanDia.setFont(new Font("Tahoma", Font.PLAIN, 20));
		buttonPane.add(btnHuyGanDia);
		btnClose = new JButton("Đóng");
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnClose.setActionCommand("Cancel");
		buttonPane.add(btnClose);
		
		
		ganDiaChoKhachHang(dia);
		ganSuKienChoButton();
	}

	private void ganSuKienChoButton() {
		btnClose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				closeUIListener.onCloseUI(e);
				
			}
		});
		
		 btnHuyGanDia.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				int confirm  = hienThongBaoXacNhan(DlgGanDia.this, "Thông báo xác nhận", "Xác nhận huỷ gán đĩa");
				if(confirm == JOptionPane.NO_OPTION) {
					return;
				}
				xuLyHuyGanDia(chiTietDatGiu);
				
			}
		});
		
	}

	/**
	 * Xử lý huỷ gán đĩa
	 */
	protected void xuLyHuyGanDia(ChiTietDatGiu ctdg) {
		chiTietDatGiuDAO.delete(ctdg);
		this.dispose();
		ganDiaChoKhachHang(diaGan);
		
	}

	private void ganDiaChoKhachHang(Dia dia) {
		if (dia == null) {
			this.dispose();
			return;
		}

		ChiTietDatGiu chiTietDatGiuR = datTruocDiaBUS.ganDia(dia);
		if (chiTietDatGiuR == null) {
			this.dispose();
			return;
		}
		
		chiTietDatGiu = chiTietDatGiuR;
		diaGan = dia;
		
		hienThongTinDia(dia);
		hienThongTinTuaDe(chiTietDatGiuR.getTuaDe());
		hienThongTinKhachHang(chiTietDatGiuR.getKhachHang());

	}

	private void hienThongTinDia(Dia dia) {
		lblDiskId.setText(dia.getId() + "");
		lblDiskCate.setText(dia.getLoaiDia().toString());

	}

	private void hienThongTinTuaDe(TuaDe tuaDe) {
		lblDiskTitle.setText(tuaDe.toString());
	}

	private void hienThongTinKhachHang(KhachHang khachHang) {
		pnlCustomerCommon = new PnlCustomerCommon(khachHang);
		pnlCustomer.add(pnlCustomerCommon);
		pnlCustomerCommon.setLayout(new BoxLayout(pnlCustomerCommon, BoxLayout.Y_AXIS));
		pnlCustomerCommon.getBtnSearchCusId().setVisible(false);
	}

	public void setCloseUIListener(ICloseUIListener closeUIListener) {
		this.closeUIListener = closeUIListener;
	}

}
