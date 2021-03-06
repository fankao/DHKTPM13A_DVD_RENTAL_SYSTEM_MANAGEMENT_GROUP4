package com.group4.ui.panel;
import static com.group4.Injection.*;
import static com.group4.ui.panel.UtilsLayout.*;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.AbstractListModel;
import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.JButton;
import java.awt.FlowLayout;

import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.hibernate.internal.util.ValueHolder.DeferredInitializer;

import com.group4.business.TuaDeBUS;
import com.group4.dao.ITuaDeDAO;
import com.group4.dao.impl.TuaDeDAO;
import com.group4.entities.TuaDe;
import com.group4.model.TaiKhoanModel;
import com.group4.ui.ICloseUIListener;

import javax.swing.JList;
import javax.swing.JOptionPane;

public class PnlManagerTitle extends JPanel {
	private JTextField txtTenTuaDe;
	private JButton btnThem;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnLuu;
	private JButton btnThoat;
	private JButton btnHuy;
	private JList<TuaDe> listTuaDe;

	private TuaDe tuaDe;
	DefaultListModel modelListTuaDe;
	List dsTuaDe;

	private ICloseUIListener closeUIListener;


	/**
	 * Create the panel.
	 */
	public PnlManagerTitle() {
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setSize(1270, 600);
		setLayout(new BorderLayout(0, 0));

		JPanel pnTitle = new JPanel();
		add(pnTitle, BorderLayout.NORTH);

		JLabel lblTitle = new JLabel("QUẢN LÝ TỰA ĐỀ");
		lblTitle.setFont(new Font("Arial", Font.BOLD, 30));
		pnTitle.add(lblTitle);

		JPanel pnMain = new JPanel();
		add(pnMain, BorderLayout.CENTER);
		pnMain.setLayout(new BoxLayout(pnMain, BoxLayout.X_AXIS));

		JPanel pnLeft = new JPanel();
		pnLeft.setBorder(
				new TitledBorder(null, "Ch\u1EE9c n\u0103ng", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		pnMain.add(pnLeft);
		pnLeft.setLayout(new BoxLayout(pnLeft, BoxLayout.Y_AXIS));

		JPanel panel = new JPanel();
		FlowLayout flowLayout_4 = (FlowLayout) panel.getLayout();
		flowLayout_4.setHgap(15);
		flowLayout_4.setVgap(30);
		pnLeft.add(panel);

		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_1.getLayout();
		flowLayout_1.setHgap(15);
		flowLayout_1.setVgap(30);
		pnLeft.add(panel_1);

		JLabel lblTenTuaDe = new JLabel("Tên tựa đề:");
		lblTenTuaDe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(lblTenTuaDe);

		txtTenTuaDe = new JTextField();
		txtTenTuaDe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_1.add(txtTenTuaDe);
		txtTenTuaDe.setColumns(20);

		JPanel panel_2 = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_2.getLayout();
		flowLayout_2.setHgap(15);
		flowLayout_2.setVgap(30);
		pnLeft.add(panel_2);

		JPanel panel_3 = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) panel_3.getLayout();
		flowLayout_3.setHgap(15);
		flowLayout_3.setVgap(30);
		pnLeft.add(panel_3);

		btnThem = new JButton("Thêm");
		btnThem.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_3.add(btnThem);

		btnSua = new JButton("Sửa");
		btnSua.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_3.add(btnSua);

		btnXoa = new JButton("Xóa");
		btnXoa.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_3.add(btnXoa);

		btnLuu = new JButton("Lưu");
		btnLuu.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel_3.add(btnLuu);

		JPanel pnRight = new JPanel();
		pnRight.setBorder(new TitledBorder(null, "Danh s\u00E1ch t\u1EF1a \u0111\u1EC1", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		pnMain.add(pnRight);

		JPanel pnThoat = new JPanel();
		FlowLayout flowLayout = (FlowLayout) pnThoat.getLayout();
		flowLayout.setHgap(15);
		flowLayout.setVgap(30);
		flowLayout.setAlignment(FlowLayout.RIGHT);
		add(pnThoat, BorderLayout.SOUTH);

		btnThoat = new JButton("Thoát");
		btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pnThoat.add(btnThoat);

		btnThem.setPreferredSize(new Dimension(100, 50));
		btnLuu.setPreferredSize(new Dimension(100, 50));
		btnSua.setPreferredSize(new Dimension(100, 50));
		btnXoa.setPreferredSize(new Dimension(100, 50));

		btnHuy = new JButton("Hủy");
		btnHuy.setFont(new Font("Tahoma", Font.PLAIN, 20));
		panel_3.add(btnHuy);
		btnHuy.setPreferredSize(new Dimension(100, 50));
		btnThoat.setPreferredSize(new Dimension(100, 50));

		// Tạo list tựa đề
		modelListTuaDe = new DefaultListModel<TuaDe>();
		pnRight.setLayout(new BorderLayout(0, 0));
		listTuaDe = new JList<TuaDe>(modelListTuaDe);
		listTuaDe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnRight.add(listTuaDe);
		
		if(TaiKhoanModel.admin !=null) {
			btnXoa.setVisible(false);	
			btnThem.setVisible(false);
		}

		voHieuHoaButton(btnSua, btnXoa, btnHuy, btnLuu);
		voHieuHoaTextField(txtTenTuaDe);
		dsTuaDe = tuaDeDAO.findAll();
		hienDanhSachTuaDe(dsTuaDe);
		ganSuKienChoButton();
		ganSuKienChoJList();

	}

	private void ganSuKienChoJList() {
		listTuaDe.getSelectionModel().addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				int select = listTuaDe.getSelectedIndex();
				if (select == -1) {
					return;
				}
				tuaDe = (TuaDe) dsTuaDe.get(select);
				hienThongTinTuaDe(tuaDe);
				voHieuHoaTextField(txtTenTuaDe);
				kichHoatButton(btnSua, btnXoa,btnHuy);
				voHieuHoaButton(btnThem);
			}
		});
	}

	private void hienThongTinTuaDe(TuaDe tuaDe) {
		txtTenTuaDe.setText(tuaDe.getTenTuaDe());
	}

	private void ganSuKienChoButton() {
		btnThoat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				closeUIListener.onCloseUI(e);
			}
		});
		btnThem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				listTuaDe.clearSelection();
				kichHoatButton(btnLuu, btnHuy);
				voHieuHoaButton(btnThem);
				kichHoatTextField(txtTenTuaDe);
				xoaTrangInput();

			}
		});
		btnHuy.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				xuLyHuyThaoTac();
				voHieuHoaTextField(txtTenTuaDe);
				voHieuHoaButton(btnSua,btnXoa);
				listTuaDe.clearSelection();
			}
		});
		btnXoa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				int selectIndex = -1;
				selectIndex = listTuaDe.getSelectedIndex();
				if (selectIndex >= 0) {
					TuaDe td = (TuaDe) dsTuaDe.get(selectIndex);

					int option = hienThongBaoXacNhan(PnlManagerTitle.this, "Thông báo xác nhận",
							"Bạn có muốn xóa tựa đề này?");

					if (option == JOptionPane.YES_OPTION) {
						if (tuaDeBUS.xoaTuaDe(td) == false) {
							hienThongBao(PnlManagerTitle.this, "Thông báo lỗi",
									"Không thể xóa tựa đề do tựa đề đang có đĩa hoặc được đặt giữ",
									JOptionPane.ERROR_MESSAGE);
							return;
						}
						dsTuaDe = tuaDeDAO.findAll();
						listTuaDe.clearSelection();
						hienDanhSachTuaDe(dsTuaDe);
						hienThongBao(PnlManagerTitle.this, "Thông báo", "Xóa tựa đề thành công",
								JOptionPane.INFORMATION_MESSAGE);
						xoaTrangInput();
						voHieuHoaButton(btnSua,btnXoa);
						kichHoatButton(btnThem);
					}
				}
			}
		});
		btnLuu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(isValidInput()) {
					String name = txtTenTuaDe.getText();
					if(tuaDe == null) {
						tuaDe = new TuaDe();
					}
					tuaDe.setTenTuaDe(name);
					
					xuLyLuuTuaDe(tuaDe);
					listTuaDe.clearSelection();
					dsTuaDe = tuaDeDAO.findAll();
					hienDanhSachTuaDe(dsTuaDe);
					
					xoaTrangInput();
					voHieuHoaButton(btnLuu,btnHuy);
					kichHoatButton(btnThem);
					voHieuHoaTextField(txtTenTuaDe);
				}
			}
		});
	}
	
	private void xuLyLuuTuaDe(TuaDe td) {
		if(td.getId()!=null && td.getId() > 0) {
			//cập nhật
			td = tuaDeDAO.update(tuaDe);
			if(td!=null) {
				hienThongBao(this, "Thông báo", "Cập nhật tựa đề thành công", JOptionPane.INFORMATION_MESSAGE);
			}
		}else {
			//Thêm mới
			td = tuaDeDAO.create(tuaDe);
			if(td != null) {
				hienThongBao(this, "Thông báo", 
						"Thêm mới tựa đề thành công", 
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
		tuaDe = null;
	}
	
	private boolean isValidInput() {
		if(!isInputFieldNotBlank(this,txtTenTuaDe)) {
			return false;
		}
		return true;
	}

	private void xuLyHuyThaoTac() {
		listTuaDe.clearSelection();
		txtTenTuaDe.setText("");
		voHieuHoaButton(btnLuu, btnHuy);
		kichHoatButton(btnThem);
	}

	private void xoaTrangInput() {
		txtTenTuaDe.setText("");
		txtTenTuaDe.requestFocus();

	}

	private void hienDanhSachTuaDe(List<TuaDe> dsTD) {
		DefaultListModel<TuaDe> listModel = (DefaultListModel<TuaDe>) listTuaDe.getModel();
		listModel.removeAllElements();
		for (TuaDe tuaDe : dsTD) {
			listModel.addElement(tuaDe);
		}
	}

	public void setCloseUIListener(ICloseUIListener closeUIListener) {
		this.closeUIListener = closeUIListener;
	}
}
