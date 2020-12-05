package com.group4.ui.dialog;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.group4.dao.ITaiKhoanDAO;
import com.group4.dao.impl.TaiKhoanDAO;
import com.group4.entities.TaiKhoan;
import com.group4.model.TaiKhoanModel;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JTextField;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;

public class DlgLogin extends JDialog {

	private final JPanel pnMain = new JPanel();
	private static ITaiKhoanDAO taiKhoanDAO;
	static {
		taiKhoanDAO = new TaiKhoanDAO();
	}
	
	private JTextField txtTenTK;
	private JPasswordField passwordField;
	private JButton btnDangNhap;
	private JButton btnThoat;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgLogin dialog = new DlgLogin();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgLogin() {
		setBounds(100, 100, 570, 390);
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
		gl_pnMain.setHorizontalGroup(
			gl_pnMain.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_pnMain.createSequentialGroup()
					.addContainerGap(52, Short.MAX_VALUE)
					.addGroup(gl_pnMain.createParallelGroup(Alignment.LEADING)
						.addComponent(lblTenTK)
						.addComponent(lblMatKhau))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_pnMain.createParallelGroup(Alignment.LEADING, false)
						.addComponent(passwordField)
						.addComponent(txtTenTK, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE))
					.addContainerGap(60, Short.MAX_VALUE))
		);
		gl_pnMain.setVerticalGroup(
			gl_pnMain.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_pnMain.createSequentialGroup()
					.addGap(41)
					.addGroup(gl_pnMain.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblTenTK)
						.addComponent(txtTenTK, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(33)
					.addGroup(gl_pnMain.createParallelGroup(Alignment.BASELINE)
						.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblMatKhau))
					.addContainerGap(24, Short.MAX_VALUE))
		);
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
				if(isValidInput()) {
					String username = txtTenTK.getText();
					String password = passwordField.getText();
					
					dangNhap(username,password);
				}
				
			}
		});
		
		
		
	}

	protected void dangNhap(String username, String password) {
		TaiKhoan taiKhoan = taiKhoanDAO.dangNhap(username, password);
		//nêu đang nhập thành công
		TaiKhoanModel.admin = taiKhoan;
		
	}

	protected boolean isValidInput() {
		
		return true;
	}
}
