package com.group4.ui.panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.group4.business.DatTruocDiaBUS;
import com.group4.entities.ChiTietDatGiu;
import com.group4.entities.KhachHang;
import com.group4.entities.TuaDe;
import com.group4.ui.ICloseUIListener;
import com.group4.ui.dialog.DlgSearchTitle;
import com.group4.ui.panel.PnlCustomerCommon.ItemClickListener;

public class PnlReservation extends JPanel {
	private static final long serialVersionUID = 1L;
	private ICloseUIListener closeUIListener;
	private static DatTruocDiaBUS datTruocDiaBUS;
	static {
		datTruocDiaBUS = new DatTruocDiaBUS();
	}
	private KhachHang khachHangDatBanSao;
	private List<ChiTietDatGiu> dsMuonDat = new ArrayList<ChiTietDatGiu>();

	private JLabel lblReservationDate;
	private JButton btnAccept;
	private JButton btnClose;
	private JButton btnCancel;
	private JButton btnSearchTitle;
	private JComboBox<TuaDe> cmbTitleOfDisk;
	private JPanel pnlTitleOfDisk;
	private PnlCustomerCommon pnlCustomerCommon;
	private JButton btnCancelReservation;
	private JButton btnConfirmTitle;
	private JList<ChiTietDatGiu> lstReservation;

	public PnlReservation() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setSize(1270, 600);
		setLayout(new BorderLayout(0, 0));

		JPanel pnlTitle = new JPanel();
		add(pnlTitle, BorderLayout.NORTH);

		JLabel lblTitle = new JLabel("ĐẶT TRƯỚC ĐĨA");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 25));
		pnlTitle.add(lblTitle);

		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new BorderLayout(0, 0));

		JPanel pnlCustomer = new JPanel();
		pnlCustomer.setBorder(new CompoundBorder(new EmptyBorder(0, 0, 10, 0),
				new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Th\u00F4ng tin kh\u00E1ch h\u00E0ng",
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0))));
		panel.add(pnlCustomer, BorderLayout.NORTH);
		pnlCustomer.setLayout(new BoxLayout(pnlCustomer, BoxLayout.Y_AXIS));

		JPanel pnlReservationDate = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnlReservationDate.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		pnlCustomer.add(pnlReservationDate);

		JLabel lblReservationDateTitle = new JLabel("Ngày đặt đĩa: ");
		lblReservationDateTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlReservationDate.add(lblReservationDateTitle);

		lblReservationDate = new JLabel("20/10/2020");
		lblReservationDate.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblReservationDate.setToolTipText("");
		pnlReservationDate.add(lblReservationDate);

		JPanel pnlReservation = new JPanel();
		pnlReservation.setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 0),
				new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Th\u00F4ng tin \u0111\u1EB7t \u0111\u0129a",
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0))));
		panel.add(pnlReservation, BorderLayout.CENTER);
		pnlReservation.setLayout(new BorderLayout(0, 0));

		pnlTitleOfDisk = new JPanel();
		pnlTitleOfDisk.setVisible(false);
		FlowLayout fl_pnlTitleOfDisk = (FlowLayout) pnlTitleOfDisk.getLayout();
		fl_pnlTitleOfDisk.setAlignment(FlowLayout.LEFT);
		pnlReservation.add(pnlTitleOfDisk, BorderLayout.NORTH);

		JLabel lblTitleID = new JLabel("Tựa đề: ");
		lblTitleID.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlTitleOfDisk.add(lblTitleID);

		cmbTitleOfDisk = new JComboBox<TuaDe>();
		cmbTitleOfDisk.setEditable(false);
		cmbTitleOfDisk.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlTitleOfDisk.add(cmbTitleOfDisk);

		btnConfirmTitle = new JButton("Xác nhận");
		btnConfirmTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlTitleOfDisk.add(btnConfirmTitle);

		JPanel pnlOperation = new JPanel();
		pnlOperation
				.setBorder(new CompoundBorder(new LineBorder(new Color(0, 0, 0), 2), new EmptyBorder(10, 10, 10, 10)));
		pnlReservation.add(pnlOperation, BorderLayout.EAST);
		pnlOperation.setLayout(new GridLayout(2, 1, 10, 10));

		JPanel pnlOprAbove = new JPanel();
		pnlOperation.add(pnlOprAbove);
		pnlOprAbove.setLayout(new GridLayout(3, 1, 0, 0));

		btnAccept = new JButton("Xác nhận đặt");
		pnlOprAbove.add(btnAccept);
		btnAccept.setFont(new Font("Tahoma", Font.PLAIN, 20));

		btnCancel = new JButton("Huỷ");
		pnlOprAbove.add(btnCancel);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 20));

		btnClose = new JButton("Đóng");
		pnlOprAbove.add(btnClose);
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 20));

		btnSearchTitle = new JButton("Tìm kiếm tựa đề\r\n");
		btnSearchTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlOperation.add(btnSearchTitle);

		JPanel pnlCenter = new JPanel();
		pnlCenter.setBorder(new CompoundBorder(new EmptyBorder(0, 0, 0, 20), new LineBorder(new Color(0, 0, 0), 2)));
		pnlReservation.add(pnlCenter, BorderLayout.CENTER);
		pnlCenter.setLayout(new BorderLayout(0, 0));

		JScrollPane scrollPane = new JScrollPane();
		pnlCenter.add(scrollPane, BorderLayout.CENTER);

		lstReservation = new JList<ChiTietDatGiu>(new DefaultListModel<ChiTietDatGiu>());
		lstReservation.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstReservation.setFont(new Font("Tahoma", Font.PLAIN, 20));
		scrollPane.setViewportView(lstReservation);

		JPanel panel_1 = new JPanel();
		pnlCenter.add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));

		JButton btnRemove = new JButton("Xoá bỏ");
		btnRemove.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnRemove.setEnabled(false);
		panel_1.add(btnRemove);

		btnCancelReservation = new JButton("Huỷ đặt đĩa");
		btnCancelReservation.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(btnCancelReservation);

		pnlCustomerCommon = new PnlCustomerCommon(null);
		pnlCustomer.add(pnlCustomerCommon);
		pnlCustomerCommon.setLayout(new BoxLayout(pnlCustomerCommon, BoxLayout.Y_AXIS));

		setEventForButton();

	}

	private void setEventForButton() {

		btnClose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				closeUIListener.onCloseUI(e);

			}
		});

		pnlCustomerCommon.setItemClickListener(new ItemClickListener() {

			@Override
			public void onClick(ActionEvent e, KhachHang khachHang) {
				khachHangDatBanSao = khachHang;
				List<TuaDe> dsTuaDeKHChuaDat = datTruocDiaBUS.getDSTuaDeKhachHangChuaDat(khachHangDatBanSao.getId());
				System.out.println("Số lượng tựa đề: " + dsTuaDeKHChuaDat.size());
				hienDanhSachTuaDe(dsTuaDeKHChuaDat);

			}
		});

		btnConfirmTitle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				TuaDe tuaDe = (TuaDe) cmbTitleOfDisk.getModel().getSelectedItem();
				themTuaDeVaoDSMuonDat(tuaDe);
				xoaTuaDeKhoiCombox(tuaDe);

			}
		});
		
		btnAccept.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				xacNhanDatDia(dsMuonDat);
				
			}
		});

		btnSearchTitle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DlgSearchTitle searchTitleDlg = new DlgSearchTitle();
				searchTitleDlg.setLocationRelativeTo(null);
				searchTitleDlg.setVisible(true);

				if (searchTitleDlg.getTuaDe() != null) {
					System.out.println(searchTitleDlg.getTuaDe());
				}

			}
		});

	}

	/**
	 * Xác nhận đặt bản sao của tựa đề
	 * @param ds
	 */
	private void xacNhanDatDia(List<ChiTietDatGiu> ds) {
		
		
	}

	/**
	 * Xoá tựa đề khỏi combobox sau khi thêm
	 * 
	 * @param tuaDe
	 */
	private void xoaTuaDeKhoiCombox(TuaDe tuaDe) {
		((DefaultComboBoxModel<TuaDe>) cmbTitleOfDisk.getModel()).removeElement(tuaDe);

	}

	/**
	 * Thêm tựa đề vào danh sách muốn đặt
	 * 
	 * @param tuaDe tựa đề
	 */
	private void themTuaDeVaoDSMuonDat(TuaDe tuaDe) {
		ChiTietDatGiu chiTietDatGiu = new ChiTietDatGiu();
		chiTietDatGiu.datGiuDia(khachHangDatBanSao, tuaDe);
		dsMuonDat.add(chiTietDatGiu);

		hienDanhSachDatGiu(dsMuonDat);

	}

	/**
	 * hiện danh sách muốn đặt và đã được gán đĩa
	 * 
	 * @param dsDatGiu
	 */
	private void hienDanhSachDatGiu(List<ChiTietDatGiu> dsDatGiu) {
		DefaultListModel<ChiTietDatGiu> listModel = (DefaultListModel<ChiTietDatGiu>) lstReservation.getModel();
		listModel.removeAllElements();
		for (ChiTietDatGiu chiTietDatGiu : dsDatGiu) {
			listModel.addElement(chiTietDatGiu);
		}

	}

	/**
	 * Lấy danh sách tựa đề mà khách hàng chưa đặt
	 * 
	 * @param dsTuaDeKHChuaDat danh sách tựa đề
	 */
	private void hienDanhSachTuaDe(List<TuaDe> dsTuaDeKHChuaDat) {
		DefaultComboBoxModel<TuaDe> comboBoxModel = (DefaultComboBoxModel<TuaDe>) cmbTitleOfDisk.getModel();
		comboBoxModel.removeAllElements();
		for (TuaDe tuaDe : dsTuaDeKHChuaDat) {
			comboBoxModel.addElement(tuaDe);
		}

		pnlTitleOfDisk.setVisible(true);

	}

	public void setCloseUIListener(ICloseUIListener closeUIListener) {
		this.closeUIListener = closeUIListener;
	}

}
