package com.group4.ui.dialog;

import static com.group4.Injection.*;
import static com.group4.ui.panel.UtilsLayout.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import com.group4.DVDRentalApplication;
import com.group4.dao.ITaiKhoanDAO;
import com.group4.dao.impl.TaiKhoanDAO;
import com.group4.entities.TaiKhoan;
import com.group4.model.TaiKhoanModel;
import com.group4.ui.FrmMain;
import com.group4.ui.ICloseUIListener;

import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;

public class DlgLogin extends JDialog {

	private final JPanel pnMain = new JPanel();

	private JTextField txtTenTK;
	private JPasswordField passwordField;
	private JButton btnDangNhap;
	private JButton btnThoat;

	private JDialog dlgLogin;

	private ICloseUIListener closeUIListener;

	/**
	 * Create the dialog.
	 */
	public DlgLogin() {
		setSize(570, 390);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		{
			JPanel pnTitle = new JPanel();
			FlowLayout flowLayout = (FlowLayout) pnTitle.getLayout();
			flowLayout.setVgap(20);
			getContentPane().add(pnTitle, BorderLayout.NORTH);
			{
				JLabel lblNewLabel = new JLabel("ĐĂNG NHẬP");
				lblNewLabel.setFont(new Font("Arial", Font.BOLD, 32));
				pnTitle.add(lblNewLabel);
			}
		}
		pnMain.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(pnMain, BorderLayout.CENTER);

		JLabel lblTenTK = new JLabel("Tên tài khoản:");
		lblTenTK.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblMatKhau = new JLabel("Mật khẩu:");
		lblMatKhau.setFont(new Font("Tahoma", Font.PLAIN, 20));

		txtTenTK = new JTextField();
		txtTenTK.setFont(new Font("Tahoma", Font.PLAIN, 20));
		txtTenTK.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 20));
		GroupLayout gl_pnMain = new GroupLayout(pnMain);
		gl_pnMain.setHorizontalGroup(gl_pnMain.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnMain.createSequentialGroup().addContainerGap(52, Short.MAX_VALUE)
						.addGroup(gl_pnMain
								.createParallelGroup(Alignment.LEADING).addComponent(lblTenTK).addComponent(lblMatKhau))
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addGroup(gl_pnMain.createParallelGroup(Alignment.LEADING, false).addComponent(passwordField)
								.addComponent(txtTenTK, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
						.addContainerGap(60, Short.MAX_VALUE)));
		gl_pnMain.setVerticalGroup(gl_pnMain.createParallelGroup(Alignment.LEADING).addGroup(gl_pnMain
				.createSequentialGroup().addGap(41)
				.addGroup(gl_pnMain.createParallelGroup(Alignment.BASELINE).addComponent(lblTenTK).addComponent(
						txtTenTK, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addGap(33)
				.addGroup(gl_pnMain.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMatKhau))
				.addContainerGap(24, Short.MAX_VALUE)));
		pnMain.setLayout(gl_pnMain);
		{
			JPanel pnButton = new JPanel();
			FlowLayout fl_pnButton = new FlowLayout(FlowLayout.CENTER);
			fl_pnButton.setVgap(20);
			fl_pnButton.setHgap(20);
			pnButton.setLayout(fl_pnButton);
			getContentPane().add(pnButton, BorderLayout.SOUTH);
			{
				btnDangNhap = new JButton("Đăng nhập");
				btnDangNhap.setFont(new Font("Tahoma", Font.PLAIN, 20));
				btnDangNhap.setActionCommand("OK");
				pnButton.add(btnDangNhap);
				btnDangNhap.setPreferredSize(new Dimension(160, 50));
				getRootPane().setDefaultButton(btnDangNhap);
			}
			{
				btnThoat = new JButton("Thoát");
				btnThoat.setFont(new Font("Tahoma", Font.PLAIN, 20));
				btnThoat.setActionCommand("Cancel");
				pnButton.add(btnThoat);
				btnThoat.setPreferredSize(new Dimension(160, 50));
			}
		}

		btnDangNhap.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (isValidInput()) {
					String username = txtTenTK.getText();
					String password = passwordField.getText();
					dangNhap(username, password);
				}

			}
		});

		btnThoat.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DlgLogin.this.dispose();
			}
		});

	}

	protected void dangNhap(String username, String password) {
		TaiKhoan taiKhoan = taiKhoanDAO.dangNhap(username, password);
		if (taiKhoan == null) {
			hienThongBao(this, "Thông báo lỗi", "Thông tin tài khoản hoặc mật khẩu không chính xác",
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		// nêu đang nhập thành công
		TaiKhoanModel.admin = taiKhoan;

		try {
			// UIManager.setLookAndFeel("com.jtattoo.plaf.mint.MintLookAndFeel");
			UIManager.setLookAndFeel("com.jtattoo.plaf.acryl.AcrylLookAndFeel");
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new FrmMain("Hệ thống quản lý cho thuê băng đĩa").setVisible(true);
			}
		});
		
		dispose();

	}

	private boolean isValidInput() {
		if (!isInputFieldNotBlank(this, txtTenTK) || !isInputFieldNotBlank(this, passwordField)) {
			return false;
		} else {
			String regex = "[0-9]{6}";
			String pass = passwordField.getText();
			if (!Pattern.matches(regex, pass)) {
				hienThongBao(this, "Thông báo lỗi", "Password gồm 6 chữ số, vui lòng nhập lại",
						JOptionPane.ERROR_MESSAGE);
				passwordField.requestFocus();
				passwordField.selectAll();
				return false;
			}
		}

		return true;
	}

	public void setCloseUIListener(ICloseUIListener closeUIListener) {
		this.closeUIListener = closeUIListener;
	}
}
