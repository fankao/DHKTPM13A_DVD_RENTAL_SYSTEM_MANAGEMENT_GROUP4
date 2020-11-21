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

import com.group4.ui.ICloseUIListener;

import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.CompoundBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class PnlManageDisk extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private ICloseUIListener closeUIListener;
	
	private JLabel lblDiskID;
	private JComboBox cmbDiskCategory;
	private JButton btnSearchTitle;
	private JButton btnAdd;
	private JButton btnDelete;
	private JButton btnSave;
	private JButton btnCancel;
	private JButton btnClose;
	private JTextField txtDiskId;
	private JTable tblDiskList;
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
		lblDateCreateTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDateCreateTitle.setHorizontalAlignment(SwingConstants.CENTER);
		pnlDateCreated.add(lblDateCreateTitle);
		
		JLabel lblDateCreated = new JLabel("20/11/2020");
		lblDateCreated.setFont(new Font("Tahoma", Font.BOLD, 15));
		pnlDateCreated.add(lblDateCreated);
		
		JPanel pnlDiskID = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) pnlDiskID.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		pnlDiskInfo.add(pnlDiskID);
		
		JLabel lblDiskIdTitle = new JLabel("Mã đĩa:");
		lblDiskIdTitle.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnlDiskID.add(lblDiskIdTitle);
		
		lblDiskID = new JLabel("56565232");
		lblDiskID.setFont(new Font("Tahoma", Font.BOLD, 15));
		pnlDiskID.add(lblDiskID);
		
		JPanel pnlTitleOfDisk = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) pnlTitleOfDisk.getLayout();
		flowLayout_2.setAlignment(FlowLayout.LEFT);
		pnlDiskInfo.add(pnlTitleOfDisk);
		
		JLabel lblNewLabel = new JLabel("Tựa đề: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnlTitleOfDisk.add(lblNewLabel);
		
		JComboBox cmbTitleOfDisk = new JComboBox();
		cmbTitleOfDisk.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnlTitleOfDisk.add(cmbTitleOfDisk);
		
		btnSearchTitle = new JButton("Tìm kiếm tựa đề");
		pnlTitleOfDisk.add(btnSearchTitle);
		
		JPanel pnlDiskCategory = new JPanel();
		FlowLayout fl_pnlDiskCategory = (FlowLayout) pnlDiskCategory.getLayout();
		fl_pnlDiskCategory.setAlignment(FlowLayout.LEFT);
		pnlDiskInfo.add(pnlDiskCategory);
		
		JLabel lblNewLabel_1 = new JLabel("Loại đĩa: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnlDiskCategory.add(lblNewLabel_1);
		
		cmbDiskCategory = new JComboBox();
		cmbDiskCategory.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnlDiskCategory.add(cmbDiskCategory);
		
		JPanel pnlOperation = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) pnlOperation.getLayout();
		flowLayout_3.setAlignment(FlowLayout.RIGHT);
		pnlDiskInfo.add(pnlOperation);
		
		btnAdd = new JButton("Thêm đĩa");
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlOperation.add(btnAdd);
		
		btnDelete = new JButton("Xoá đĩa");
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlOperation.add(btnDelete);
		
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
		
		JPanel pnlSearchDisk = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) pnlSearchDisk.getLayout();
		flowLayout_4.setAlignment(FlowLayout.LEFT);
		pnlDiskList.add(pnlSearchDisk, BorderLayout.NORTH);
		
		JLabel lblDiskIdSearch = new JLabel("Nhập mã đĩa: ");
		lblDiskIdSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnlSearchDisk.add(lblDiskIdSearch);
		
		txtDiskId = new JTextField();
		txtDiskId.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pnlSearchDisk.add(txtDiskId);
		txtDiskId.setColumns(10);
		
		JButton btnSearchDiskId = new JButton("Tìm kiếm");
		pnlSearchDisk.add(btnSearchDiskId);
		
		JScrollPane scrDiskList = new JScrollPane();
		pnlDiskList.add(scrDiskList, BorderLayout.CENTER);
		
		tblDiskList = new JTable();
		tblDiskList.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"M\u00E3 \u0111\u0129a", "T\u1EF1a \u0111\u1EC1", "Lo\u1EA1i \u0111\u0129a", "Gi\u00E1 th\u00E0nh", "Ng\u00E0y t\u1EA1o"
			}
		) {
			Class[] columnTypes = new Class[] {
				Long.class, String.class, Object.class, Double.class, Object.class
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
