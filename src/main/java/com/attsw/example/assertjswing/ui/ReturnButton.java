package com.attsw.example.assertjswing.ui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

public class ReturnButton extends JButton{
	private static final long serialVersionUID = -3930945907513577865L;

	public ReturnButton(MainWindow mainWindow)
	{
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				mainWindow.viewMain();

			}
		});
setText("Return");
		setName("Return");
	}

}
