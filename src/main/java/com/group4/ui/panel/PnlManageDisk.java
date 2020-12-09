package com.group4.ui.panel;

import static com.group4.Injection.*;
import static com.group4.ui.panel.UtilsLayout.*;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import com.group4.dao.IDiaDAO;
import com.group4.dao.ILoaiDiaDAO;
import com.group4.dao.ITuaDeDAO;
import com.group4.dao.impl.DiaDAO;
import com.group4.dao.impl.LoaiDiaDAO;
import com.group4.dao.impl.TuaDeDAO;
import com.group4.entities.Dia;
import com.group4.entities.LoaiDia;
import com.group4.entities.TrangThaiDia;
import com.group4.entities.TuaDe;
import com.group4.ui.ICloseUIListener;
import com.group4.ui.dialog.DlgSearchTitle;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Dimension;

public class PnlManageDisk extends JPanel {
	private static final long serialVersionUID = 1L;

	private ICloseUIListener closeUIListener;
	private Dia diaNeedDelete = null;

	private JComboBox<LoaiDia> cmbDiskCategory;
	private JButton btnSearchTitle;
	private JButton btnAdd;
	private JButton btnCancel;
	private JButton btnClose;
	private JTextField txtDiskId;
	private JTextField txtQuantity;
	private JLabel lblDiskTitle;
	private JButton btnDelete;
	private JLabel lblDiskStatus;
	private JLabel lblDiskCategoryR;
	private JLabel lblDiskId;
	private JPanel pnlDeleteDisk;
	private JButton btnSearchDiskId;
	private JButton btnCancelDelete;

	private JComboBox cmbTitleOfDisk;

	public PnlManageDisk() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setSize(1270, 600);
		setLayout(new BorderLayout(0, 0));

		JPanel pnlNorth = new JPanel();
		FlowLayout fl_pnlNorth = (FlowLayout) pnlNorth.getLayout();
		fl_pnlNorth.setVgap(10);
		add(pnlNorth, BorderLayout.NORTH);

		JLabel lblTitle = new JLabel("QUẢN LÝ THÔNG TIN ĐĨA");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 30));
		pnlNorth.add(lblTitle);

		JPanel pnlCenter = new JPanel();
		add(pnlCenter, BorderLayout.CENTER);
		pnlCenter.setLayout(new BorderLayout(0, 0));

		JPanel pnlDiskInfo = new JPanel();
		pnlDiskInfo.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Th\u00F4ng tin \u0111\u0129a",
				TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnlCenter.add(pnlDiskInfo, BorderLayout.NORTH);
		pnlDiskInfo.setLayout(new BoxLayout(pnlDiskInfo, BoxLayout.Y_AXIS));

		JPanel pnlDateCreated = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnlDateCreated.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		pnlDiskInfo.add(pnlDateCreated);

		JLabel lblDateCreateTitle = new JLabel("Ngày tạo đĩa:");
		lblDateCreateTitle.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblDateCreateTitle.setHorizontalAlignment(SwingConstants.CENTER);
		pnlDateCreated.add(lblDateCreateTitle);

		JLabel lblDateCreated = new JLabel("20/11/2020");
		lblDateCreated.setFont(new Font("Tahoma", Font.BOLD, 20));
		pnlDateCreated.add(lblDateCreated);

		JPanel pnlTitleOfDisk = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) pnlTitleOfDisk.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		pnlDiskInfo.add(pnlTitleOfDisk);

		JLabel lblTitleDiskTitle = new JLabel("Tựa đề: ");
		lblTitleDiskTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTitleDiskTitle.setFont(new Font("Dialog", Font.PLAIN, 20));
		pnlTitleOfDisk.add(lblTitleDiskTitle);

		cmbTitleOfDisk = new JComboBox();
		cmbTitleOfDisk.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlTitleOfDisk.add(cmbTitleOfDisk);

		Component horizontalGlue_4 = Box.createHorizontalGlue();
		horizontalGlue_4.setPreferredSize(new Dimension(30, 0));
		pnlTitleOfDisk.add(horizontalGlue_4);

		btnSearchTitle = new JButton("Tìm kiếm tựa đề");
		btnSearchTitle.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlTitleOfDisk.add(btnSearchTitle);

		JPanel pnlDiskCategory = new JPanel();
		FlowLayout fl_pnlDiskCategory = (FlowLayout) pnlDiskCategory.getLayout();
		fl_pnlDiskCategory.setAlignment(FlowLayout.LEFT);
		pnlDiskInfo.add(pnlDiskCategory);

		JLabel lblDiskCategory = new JLabel("Loại đĩa: ");
		lblDiskCategory.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDiskCategory.setFont(new Font("Dialog", Font.PLAIN, 20));
		pnlDiskCategory.add(lblDiskCategory);

		cmbDiskCategory = new JComboBox();
		cmbDiskCategory.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlDiskCategory.add(cmbDiskCategory);

		JPanel panel = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) panel.getLayout();
		flowLayout_6.setAlignment(FlowLayout.LEFT);
		pnlDiskInfo.add(panel);

		JLabel lblDiskQuantityTitle = new JLabel("Số lượng đĩa: ");
		lblDiskQuantityTitle.setFont(new Font("Dialog", Font.PLAIN, 20));
		panel.add(lblDiskQuantityTitle);

		txtQuantity = new JTextField();
		txtQuantity.setColumns(5);
		txtQuantity.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(txtQuantity);

		JPanel pnlOperation = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) pnlOperation.getLayout();
		flowLayout_3.setAlignment(FlowLayout.RIGHT);
		pnlDiskInfo.add(pnlOperation);

		btnAdd = new JButton("Thêm đĩa");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlOperation.add(btnAdd);

		btnCancel = new JButton("Huỷ");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlOperation.add(btnCancel);

		JPanel pnlDiskList = new JPanel();
		pnlDiskList.setBorder(new CompoundBorder(new EmptyBorder(10, 0, 0, 0),
				new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Danh s\u00E1ch \u0111\u0129a",
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0))));
		pnlCenter.add(pnlDiskList, BorderLayout.CENTER);
		pnlDiskList.setLayout(new BorderLayout(0, 0));

		JPanel pnlAbove = new JPanel();
		pnlDiskList.add(pnlAbove, BorderLayout.NORTH);
		pnlAbove.setLayout(new BoxLayout(pnlAbove, BoxLayout.Y_AXIS));

		JPanel pnlSearchTitle = new JPanel();
		FlowLayout fl_pnlSearchTitle = (FlowLayout) pnlSearchTitle.getLayout();
		fl_pnlSearchTitle.setAlignment(FlowLayout.LEFT);
		pnlAbove.add(pnlSearchTitle);

		JLabel lblDiskIdSearch = new JLabel("Nhập mã đĩa: ");
		pnlSearchTitle.add(lblDiskIdSearch);
		lblDiskIdSearch.setFont(new Font("Dialog", Font.PLAIN, 20));

		txtDiskId = new JTextField();
		pnlSearchTitle.add(txtDiskId);
		txtDiskId.setFont(new Font("Dialog", Font.PLAIN, 20));
		txtDiskId.setColumns(10);

		btnSearchDiskId = new JButton("Xác nhận");
		pnlSearchTitle.add(btnSearchDiskId);
		btnSearchDiskId.setFont(new Font("Dialog", Font.PLAIN, 20));

		pnlDeleteDisk = new JPanel();
		pnlDeleteDisk.setVisible(false);
		pnlDeleteDisk.setBorder(new LineBorder(Color.BLUE, 2));
		FlowLayout fl_pnlDeleteDisk = (FlowLayout) pnlDeleteDisk.getLayout();
		fl_pnlDeleteDisk.setAlignment(FlowLayout.LEFT);
		pnlAbove.add(pnlDeleteDisk);

		JLabel lblDiskIdTile = new JLabel("Mã đĩa: ");
		lblDiskIdTile.setFont(new Font("Dialog", Font.PLAIN, 16));
		pnlDeleteDisk.add(lblDiskIdTile);

		lblDiskId = new JLabel("454656898");
		lblDiskId.setFont(new Font("Dialog", Font.BOLD, 16));
		pnlDeleteDisk.add(lblDiskId);

		Component horizontalGlue = Box.createHorizontalGlue();
		pnlDeleteDisk.add(horizontalGlue);

		JLabel lblDiskTit = new JLabel("Tựa đề: ");
		lblDiskTit.setFont(new Font("Dialog", Font.PLAIN, 16));
		pnlDeleteDisk.add(lblDiskTit);

		lblDiskTitle = new JLabel("Chiến tranh giữa các vì sao");
		lblDiskTitle.setFont(new Font("Dialog", Font.BOLD, 16));
		pnlDeleteDisk.add(lblDiskTitle);

		Component horizontalGlue_1 = Box.createHorizontalGlue();
		pnlDeleteDisk.add(horizontalGlue_1);

		JLabel lblDiskCategoryTitle = new JLabel("Loại đĩa: ");
		lblDiskCategoryTitle.setFont(new Font("Dialog", Font.PLAIN, 16));
		pnlDeleteDisk.add(lblDiskCategoryTitle);

		lblDiskCategoryR = new JLabel("DVD");
		lblDiskCategoryR.setFont(new Font("Dialog", Font.BOLD, 16));
		pnlDeleteDisk.add(lblDiskCategoryR);

		Component horizontalGlue_2 = Box.createHorizontalGlue();
		pnlDeleteDisk.add(horizontalGlue_2);

		JLabel lblDiskStatusTitle = new JLabel("Trạng thái: ");
		lblDiskStatusTitle.setFont(new Font("Dialog", Font.PLAIN, 16));
		pnlDeleteDisk.add(lblDiskStatusTitle);

		lblDiskStatus = new JLabel("Trên kệ");
		lblDiskStatus.setFont(new Font("Dialog", Font.BOLD, 16));
		pnlDeleteDisk.add(lblDiskStatus);

		Component horizontalGlue_3 = Box.createHorizontalGlue();
		horizontalGlue_3.setPreferredSize(new Dimension(30, 0));
		pnlDeleteDisk.add(horizontalGlue_3);

		btnDelete = new JButton("Xoá đĩa");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlDeleteDisk.add(btnDelete);

		btnCancelDelete = new JButton("Huỷ xoá");
		btnCancelDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlDeleteDisk.add(btnCancelDelete);

		btnCancel.setPreferredSize(btnAdd.getPreferredSize());

		JPanel pnlClose = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) pnlClose.getLayout();
		flowLayout_5.setAlignment(FlowLayout.RIGHT);
		add(pnlClose, BorderLayout.SOUTH);

		lblDateCreateTitle.setPreferredSize(lblDiskQuantityTitle.getPreferredSize());
		lblTitleDiskTitle.setPreferredSize(lblDiskQuantityTitle.getPreferredSize());
		lblDiskCategory.setPreferredSize(lblDiskQuantityTitle.getPreferredSize());

		btnClose = new JButton("Đóng");
		pnlClose.add(btnClose);
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnClose.setPreferredSize(btnAdd.getPreferredSize());

		setEventForButton();
		loadComboboxLoaiDia(getLoaiDia());
		loadComboboxTuaDe(getTuaDe());
	}

	private void setEventForButton() {
		btnClose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int select = hienThongBaoXacNhan(PnlManageDisk.this, "Thông báo thoát chức năng",
						"Xác nhận thoát chức năng quản lý đĩa ?");
				if (select == JOptionPane.NO_OPTION) {
					return;
				}
				closeUIListener.onCloseUI(e);

			}
		});
		btnSearchDiskId.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (isInputFieldNotBlank(PnlManageDisk.this, txtDiskId)) {
					try {
						Long diaId = Long.valueOf(txtDiskId.getText());
						if (diaId == 0) {
							hienThongBao(PnlManageDisk.this, "Thông báo lỗi", "Mã đĩa phải là số nguyên lớn hơn 0",
									JOptionPane.ERROR_MESSAGE);
							txtDiskId.requestFocus();
							txtDiskId.selectAll();
							return;
						}
						Dia dia = diaDAO.findById(diaId);
						hienThongTinDia(dia);
						voHieuHoaTextField(txtDiskId);
						voHieuHoaButton(btnSearchDiskId);
					} catch (NumberFormatException e2) {
						hienThongBao(PnlManageDisk.this, "Thông báo lỗi", "Mã đĩa phải là số nguyên lớn hơn 0",
								JOptionPane.ERROR_MESSAGE);
						txtDiskId.requestFocus();
						txtDiskId.selectAll();
					}
				}

			}
		});

		btnCancelDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				kichHoatFieldNhapMaDia();
				xoaTrang(txtDiskId);
				pnlDeleteDisk.setVisible(false);

			}
		});

		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				xoaDia(diaNeedDelete);

			}
		});
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (cmbDiskCategory != null && cmbTitleOfDisk != null) {
					if (txtQuantity.getText().isEmpty()) {
						hienThongBao(PnlManageDisk.this, "Thông báo lỗi", "Số lượng đĩa trống",
								JOptionPane.ERROR_MESSAGE);
					} else if (txtQuantity.getText().matches("[a-zA-Z]")) {
						hienThongBao(PnlManageDisk.this, "Thông báo lỗi", "Vui lòng nhập số lượng đĩa là số",
								JOptionPane.ERROR_MESSAGE);
						txtQuantity.setText("");
					} else if (Integer.parseInt(txtQuantity.getText()) <= 0) {
						hienThongBao(PnlManageDisk.this, "Thông báo lỗi", "Vui lòng nhập số lượng đĩa lớn hơn 0",
								JOptionPane.ERROR_MESSAGE);
						txtQuantity.setText("");
					} else {
						int soLuongDia = Integer.parseInt(txtQuantity.getText());
						TuaDe tuaDe = (TuaDe) cmbTitleOfDisk.getSelectedItem();
						LoaiDia loaiDia = (LoaiDia) cmbDiskCategory.getSelectedItem();
						for (int i = 0; i < soLuongDia; i++) {
							Dia dia = new Dia();
							dia.setLoaiDia(loaiDia);
							dia.setTuaDe(tuaDe);
							dia.setTrangThai(TrangThaiDia.ON_SHEFT);
							diaDAO.create(dia);
						}
						hienThongBao(
								PnlManageDisk.this, "Thêm đĩa thành công", "Tựa đề: " + tuaDe.getTenTuaDe()
										+ ",\n Loại đĩa: " + loaiDia.getTenLoaiDia() + ",\n Số lượng đĩa:" + soLuongDia,
								JOptionPane.INFORMATION_MESSAGE);
					}
				} else {
					hienThongBao(PnlManageDisk.this, "Thông báo lỗi", "Chưa chọn tưa đề hoặc loại đĩa",
							JOptionPane.ERROR_MESSAGE);
				}

			}
		});

		btnSearchTitle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DlgSearchTitle searchTitleDlg = new DlgSearchTitle();
				searchTitleDlg.setLocationRelativeTo(null);
				searchTitleDlg.setVisible(true);

				if (searchTitleDlg.getTuaDe() != null) {
					cmbTitleOfDisk.setSelectedItem(searchTitleDlg.getTuaDe());
				}

			}
		});
	}

	/**
	 * Thực hiện xoá đĩa<br>
	 * <i>Note Nếu đĩa đã được thuê hoặc được gán thì hiện thông báo lỗi</i>
	 * 
	 * @param dia đĩa cần xoá
	 * 
	 */
	private void xoaDia(Dia dia) {
		if (!diaDAO.checkDiaCoTrenKe(dia.getId())) {
			hienThongBao(this, "Thông báo lỗi", "Đĩa đang được thuê hoặc đã được gán", JOptionPane.ERROR_MESSAGE);
			return;
		}

		int select = hienThongBaoXacNhan(this, "Thông báo xác nhận",
				"Xác nhận xoá đĩa (mã đĩa: " + dia.getId() + ") ?");

		if (select == JOptionPane.NO_OPTION) {
			return;
		}

		boolean isDeleted = diaDAO.delete(dia);
		if (isDeleted) {
			hienThongBao(this, "Thông báo", "Đĩa đã được xoá thành công", JOptionPane.INFORMATION_MESSAGE);
			diaNeedDelete = null;
			pnlDeleteDisk.setVisible(false);
			kichHoatFieldNhapMaDia();
		}
	}

	private void kichHoatFieldNhapMaDia() {
		xoaTrang(txtDiskId);
		kichHoatButton(btnSearchDiskId);
		kichHoatTextField(txtDiskId);
		txtDiskId.requestFocus();
	}

	/**
	 * Hiện thông tin đĩa cần xoá <i>Nếu đĩa không tồn tại thì hiện thông báo lỗi</i
	 * 
	 * @param dia đĩa;
	 */
	private void hienThongTinDia(Dia dia) {
		if (dia == null) {
			hienThongBao(this, "Thông báo lỗi", "Mã đĩa không tồn tại trong hệ thống", JOptionPane.ERROR_MESSAGE);
			return;
		}
		lblDiskId.setText(dia.getId() + "");
		lblDiskTitle.setText(dia.getTuaDe().getTenTuaDe());
		lblDiskCategoryR.setText(dia.getLoaiDia().getTenLoaiDia().name());
		lblDiskStatus.setText(dia.getTrangThai().name());
		pnlDeleteDisk.setVisible(true);

		diaNeedDelete = dia;
	}

	public void setCloseUIListener(ICloseUIListener closeUIListener) {
		this.closeUIListener = closeUIListener;
	}

	public void loadComboboxTuaDe(List<TuaDe> tuaDes) {
		DefaultComboBoxModel<TuaDe> comboBoxModel = (DefaultComboBoxModel<TuaDe>) cmbTitleOfDisk.getModel();
		comboBoxModel.removeAllElements();
		for (TuaDe tuaDe : tuaDes) {
			comboBoxModel.addElement(tuaDe);
		}
	}

	public void loadComboboxLoaiDia(List<LoaiDia> loaiDias) {
		DefaultComboBoxModel<LoaiDia> comboBoxModel = (DefaultComboBoxModel<LoaiDia>) cmbDiskCategory.getModel();
		comboBoxModel.removeAllElements();
		for (LoaiDia loaiDia : loaiDias) {
			comboBoxModel.addElement(loaiDia);
		}
	}

	private List<TuaDe> getTuaDe() {
		ITuaDeDAO dao = new TuaDeDAO();
		return dao.findAll();
	}

	private List<LoaiDia> getLoaiDia() {
		ILoaiDiaDAO dao = new LoaiDiaDAO();
		return dao.findAll();
	}
}
