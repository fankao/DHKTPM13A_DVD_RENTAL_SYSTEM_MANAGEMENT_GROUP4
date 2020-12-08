package com.group4.ui.dialog;
import static com.group4.Injection.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import com.group4.entities.TuaDe;

public class DlgSearchTitle extends JDialog {
	private static final long serialVersionUID = 1L;
	private TuaDe tuaDe;

	private final JPanel contentPanel = new JPanel();
	private JTextField txtSearch;
	private JButton btnConfirm;
	private JButton btnClose;
	private JList<TuaDe> lstResultTitle;

	/**
	 * Create the dialog.
	 */
	public DlgSearchTitle() {
		setResizable(false);
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setModal(true);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setSize(455, 476);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));

		JPanel pnlSearch = new JPanel();
		pnlSearch.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2),
				"Nh\u1EADp t\u1EF1a \u0111\u1EC1 c\u1EA7n t\u00ECm", TitledBorder.LEADING, TitledBorder.TOP, null,
				new Color(0, 0, 0)));
		FlowLayout fl_pnlSearch = (FlowLayout) pnlSearch.getLayout();
		fl_pnlSearch.setAlignment(FlowLayout.LEFT);
		contentPanel.add(pnlSearch, BorderLayout.NORTH);

		txtSearch = new JTextField();
		txtSearch.setFont(new Font("Tahoma", Font.PLAIN, 20));
		pnlSearch.add(txtSearch);
		txtSearch.setColumns(20);

		JPanel pnlResult = new JPanel();
		pnlResult.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 2),
				"K\u1EBFt qu\u1EA3 t\u00ECm ki\u1EBFm", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLACK));
		contentPanel.add(pnlResult, BorderLayout.CENTER);
		pnlResult.setLayout(new BorderLayout(0, 0));

		lstResultTitle = new JList<TuaDe>(new DefaultListModel<>());
		lstResultTitle.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		lstResultTitle.setFont(new Font("Tahoma", Font.PLAIN, 18));
		pnlResult.add(lstResultTitle, BorderLayout.CENTER);

		JPanel buttonPane = new JPanel();
		buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
		getContentPane().add(buttonPane, BorderLayout.SOUTH);

		btnConfirm = new JButton("Xác nhận");
		btnConfirm.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnConfirm.setActionCommand("OK");
		buttonPane.add(btnConfirm);
		getRootPane().setDefaultButton(btnConfirm);

		btnClose = new JButton("Đóng");
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnClose.setActionCommand("Cancel");
		buttonPane.add(btnClose);

		btnConfirm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tuaDe = lstResultTitle.getSelectedValue();
				System.out.println("Dialog: " + tuaDe);
				dispose();

			}
		});

		btnClose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		timKiemTuaDe();

	}

	private void timKiemTuaDe() {
		txtSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				String key = txtSearch.getText().toLowerCase().trim();
				if(key.length() == 0) {
					hienKetQuaTimKiem(tuaDeDAO.findAll());
				}else {
					List<TuaDe> list = tuaDeBUS.timKiemTuaDe(key);
					hienKetQuaTimKiem(list);
				}
				super.keyPressed(e);
			}
		});
		
	}

	protected void hienKetQuaTimKiem(List<TuaDe> list) {
		DefaultListModel<TuaDe> model = (DefaultListModel<TuaDe>) lstResultTitle.getModel();
		model.removeAllElements();
		for (TuaDe tuaDe : list) {
			model.addElement(tuaDe);
		}
	}

	public TuaDe getTuaDe() {
		return tuaDe;
	}

}
