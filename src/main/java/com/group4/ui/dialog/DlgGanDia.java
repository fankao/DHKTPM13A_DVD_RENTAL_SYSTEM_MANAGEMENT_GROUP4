package com.group4.ui.dialog;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import com.group4.business.DatTruocDiaBUS;
import com.group4.entities.ChiTietDatGiu;
import com.group4.entities.Dia;

public class DlgGanDia extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static DatTruocDiaBUS datTruocDiaBUS;
	static {
		datTruocDiaBUS = new DatTruocDiaBUS();
	}

	/**
	 * Create the dialog.
	 */
	public DlgGanDia(Dia dia) {
		ganDiaChoKhachHang(dia);
		
		setSize(625,428);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setModal(true);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(new FlowLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	private void ganDiaChoKhachHang(Dia dia) {
		
		if(dia == null) {
			System.out.println("Dfskhfskjdfhjkds");
			return;
		}
		
		ChiTietDatGiu chiTietDatGiu = datTruocDiaBUS.ganDia(dia);
		if(chiTietDatGiu==null) {
			this.dispose();
		}
		hienThongTinDatDia(chiTietDatGiu);
		
	}

	private void hienThongTinDatDia(ChiTietDatGiu chiTietDatGiu) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new DlgGanDia(null).setVisible(true);
				
			}
		});
	}

}
