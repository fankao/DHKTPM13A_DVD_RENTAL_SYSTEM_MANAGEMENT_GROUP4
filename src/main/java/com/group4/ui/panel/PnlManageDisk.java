package com.group4.ui.panel;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;
import javax.swing.BoxLayout;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import com.group4.entities.LoaiDia;
import com.group4.ui.ICloseUIListener;

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
	private JComboBox<LoaiDia> cmbDiskCategory;
	private JButton btnSearchTitle;
	private JButton btnAdd;
	private JButton btnSave;
	private JButton btnCancel;
	private JButton btnClose;
	private JTextField txtDiskId;
	private JTable tblDiskList;
	private JSpinner spnQuantity;
	private JLabel lblDiskTitle;
	private JButton btnDelete;
	private JLabel lblNewLabel;
	private JLabel lblDiskCategoryR;
	private JLabel lblDiskId;
	private JPanel pnlDeleteDisk;
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
		pnlDiskInfo.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Th\u00F4ng tin \u0111\u0129a", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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
		
		btnSave = new JButton("Lưu đĩa");
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlOperation.add(btnSave);
		
		btnCancel = new JButton("Huỷ");
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlOperation.add(btnCancel);
		
		JPanel pnlDiskList = new JPanel();
		pnlDiskList.setBorder(new CompoundBorder(new EmptyBorder(10, 0, 0, 0), new TitledBorder(new LineBorder(new Color(0, 0, 0), 2), "Danh s\u00E1ch \u0111\u0129a", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0))));
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
		
		JButton btnSearchDiskId = new JButton("Tìm kiếm");
		pnlSearchTitle.add(btnSearchDiskId);
		btnSearchDiskId.setFont(new Font("Dialog", Font.PLAIN, 20));
		
		pnlDeleteDisk = new JPanel();
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
		
		lblNewLabel = new JLabel("Trên kệ");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 16));
		pnlDeleteDisk.add(lblNewLabel);
		
		Component horizontalGlue_3 = Box.createHorizontalGlue();
		horizontalGlue_3.setPreferredSize(new Dimension(30, 0));
		pnlDeleteDisk.add(horizontalGlue_3);
		
		btnDelete = new JButton("Xoá đĩa");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlDeleteDisk.add(btnDelete);
		
		JButton btnCancelDelete = new JButton("Huỷ xoá");
		btnCancelDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
		pnlDeleteDisk.add(btnCancelDelete);
		
		JScrollPane scrDiskList = new JScrollPane();
		pnlDiskList.add(scrDiskList, BorderLayout.CENTER);
		
		tblDiskList = new JTable();
		tblDiskList.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 \u0111\u0129a", "T\u1EF1a \u0111\u1EC1", "Lo\u1EA1i \u0111\u0129a", "Gi\u00E1 th\u00E0nh", "Tr\u1EA1ng th\u00E1i", "Ng\u00E0y t\u1EA1o"
			}
		) {
			Class[] columnTypes = new Class[] {
				Long.class, String.class, Object.class, Double.class, String.class, Object.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		scrDiskList.setViewportView(tblDiskList);
		
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

	}
	private void setEventForButton() {
		btnClose.addActionListener(new ActionListener() {
			
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
