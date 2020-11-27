package com.group4;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.group4.test.TestingThanhToanPhiTreHan;
import com.group4.ui.FrmMain;

public class DVDRentalApplication {
	public static void main(String[] args) {
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

		// dữ liệu test thuê đĩa
		//Testing.main();
		
		//dữ liệu test trong trường hợp có phí trễ han
		TestingThanhToanPhiTreHan.main();

	}
}
