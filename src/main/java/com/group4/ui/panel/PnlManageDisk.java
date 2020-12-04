package com.group4.ui.panel;

import static com.group4.ui.panel.UtilsLayout.hienThongBao;
import static com.group4.ui.panel.UtilsLayout.isInputFieldNotBlank;

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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.group4.business.XoaDiaBUS;
import com.group4.dao.IDiaDAO;
import com.group4.dao.impl.DiaDAO;
import com.group4.entities.Dia;
import com.group4.entities.LoaiDia;
import com.group4.ui.ICloseUIListener;

public class PnlManageDisk extends JPanel {
	private static final long serialVersionUID = 1L;

	private ICloseUIListener closeUIListener;
	private static IDiaDAO diaDAO;
	private static XoaDiaBUS xoaDiaBUS;
	static {
		diaDAO = new DiaDAO();
		xoaDiaBUS = new XoaDiaBUS();
	}
	private Dia diaNeedDelete;

	private JComboBox<LoaiDia> cmbDiskCategory;
	private JButton btnSearchTitle;
	private JButton btnAdd;
	private JButton btnCancel;
	private JButton btnClose;
	private JTextField txtDiskId;
	private JSpinner spnQuantity;
	private JLabel lblDiskTitle;
	private JButton btnDelete;
	private JLabel lblStatusDisk;
	private JLabel lblDiskCategoryR;
	private JLabel lblDiskId;
	private JPanel pnlDeleteDisk;
	private JButton btnSearchDiskId;

	public PnlManageDisk() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setSize(1270, 600);
		setLayout(new BorderLayout(0, 0));

		JPanel pnlNorth = new JPanel();
		FlowLayout fl_pnlNorth = (FlowLayout) pnlNorth.getLayout();
		fl_pnlNorth.setVgap(10);
		add(pnlNorth, BorderLayout.NORTH);

		JLabel lblTitle = new JLabel("QUẢN LÝ THÔNG TIN ĐĨA");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 25));
		pnlNorth.add(lblTitle);

		JPanel pnlCenter = new JPanel();
		add(pnlCenter, BorderLayout.CENTER);
		pnlCenter.setLayout(new BorderLayout(0, 0));

		JPanel pnlDiskInfo = new JPanel();
		pnlDiskInfo.setBorder(
				new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Th\u1EF1c hi\u1EC7n th\u00EAm \u0111\u0129a",
						TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
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

		JComboBox cmbTitleOfDisk = new JComboBox();
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

		spnQuantity = new JSpinner();
		spnQuantity.setModel(new SpinnerNumberModel(1, 1, 100, 1));
		spnQuantity.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel.add(spnQuantity);

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
				new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Th\u1EF1c hi\u1EC7n xo\u00E1 \u0111\u0129a",
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
		txtDiskId.setColumns(15);

		btnSearchDiskId = new JButton("Xác nhận");
		pnlSearchTitle.add(btnSearchDiskId);
		btnSearchDiskId.setFont(new Font("Dialog", Font.PLAIN, 20));

		pnlDeleteDisk = new JPanel();
		pnlDeleteDisk.setVisible(false);
		pnlDeleteDisk.setBorder(new LineBorder(new Color(0, 0, 255), 2));
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

		lblStatusDisk = new JLabel("Trên kệ");
		lblStatusDisk.setFont(new Font("Dialog", Font.BOLD, 16));
		pnlDeleteDisk.add(lblStatusDisk);

		Component horizontalGlue_3 = Box.createHorizontalGlue();
		horizontalGlue_3.setPreferredSize(new Dimension(30, 0));
		pnlDeleteDisk.add(horizontalGlue_3);

		btnDelete = new JButton("Xoá đĩa");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 21));
		pnlDeleteDisk.add(btnDelete);

		JButton btnCancelDelete = new JButton("Huỷ xoá");
		btnCancelDelete.setFont(new Font("Tahoma", Font.PLAIN, 20));
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

		ganSuKienChoButton();

	}

	private void ganSuKienChoButton() {
		btnClose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				closeUIListener.onCloseUI(e);

			}
		});

		btnSearchDiskId.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (isInputFieldNotBlank(PnlManageDisk.this, txtDiskId)) {
					String idStr = txtDiskId.getText();
					try {
						Long id = Long.valueOf(idStr);
						timKiemDia(id);
					} catch (NumberFormatException e2) {
						hienThongBao(PnlManageDisk.this, "Thông báo lỗi", "Mã đĩa là số nguyên lớn hơn 0",
								JOptionPane.ERROR_MESSAGE);
						requestFocusTxtDia();
						return;
					}
				}

			}
		});

		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				thucHienXoaDia(diaNeedDelete);
			}
		});

	}

	/**
	 * Thực hiên xoá đĩa
	 */
	private void thucHienXoaDia(Dia dia) {
		if (xoaDiaBUS.xoaDia(dia)) {
			hienThongBao(this, "Thông báo", "Xoá đĩa " + dia.getId() + " thành công", JOptionPane.INFORMATION_MESSAGE);
		} else {
			hienThongBao(this, "Thông báo lỗi", "Xoá đĩa " + dia.getId() + " không thành công \n do đĩa đang được thuê hoặc đặt trước",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	/**
	 * Tìm kiếm đĩa
	 * 
	 * @param id: mã đĩa
	 */
	private void timKiemDia(Long id) {
		Dia dia = diaDAO.findById(id);
		if (dia == null) {
			hienThongBao(this, "Thông báo lỗi", "Đĩa này không tồn tại trong hệ thống", JOptionPane.ERROR_MESSAGE);
			requestFocusTxtDia();
			return;
		}

		diaNeedDelete = dia;
		hienThongTinDia(dia);

	}

	private void requestFocusTxtDia() {
		txtDiskId.requestFocus();
		txtDiskId.selectAll();
	}

	/**
	 * Hiện thông tin đĩa
	 * 
	 * @param dia: đĩa cần hiện thông tin
	 */
	private void hienThongTinDia(Dia dia) {
		lblDiskId.setText(dia.getId() + "");
		lblDiskTitle.setText(dia.getTuaDe().getTenTuaDe());
		lblDiskCategoryR.setText(dia.getLoaiDia().getTenLoaiDia().name());
		lblStatusDisk.setText(dia.getTrangThai().toString());
		pnlDeleteDisk.setVisible(true);
	}

	public void setCloseUIListener(ICloseUIListener closeUIListener) {
		this.closeUIListener = closeUIListener;
	}

}
