package com.attsw.example.assertjswing.ui;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.attsw.example.assertjswing.controller.Controller;

public class InsertUi extends JPanel{

	private MainWindow mainWindow;
	private Controller controller;
	private InsertUi iu = this;


	public InsertUi(MainWindow mainWindow, Controller controller) {
		this.mainWindow = mainWindow;
		this.controller = controller;
		setLayout(new GridLayout(3, 2));
		JLabel idLbl = new JLabel("Id");
		idLbl.setName("Id");
		this.add(idLbl);
		JLabel nameLbl = new JLabel("Name");
		nameLbl.setName("Name");
		this.add(nameLbl);

		JLabel mailLbl = new JLabel("Mail");
		mailLbl.setName("Mail");
		this.add(mailLbl);
		JTextField id = new JTextField();
		id.setName("Id");
		id.setSize(20, 10);
		this.add(id);
		JTextField name = new JTextField();
		name.setName("Name");
		name.setSize(20, 10);
		this.add(name);
		JTextField mail = new JTextField();
		mail.setName("Mail");
		mail.setSize(20, 10);
		this.add(mail);
		JButton okButton = new JButton("Ok");
		okButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (!id.getText().isEmpty() && !name.getText().isEmpty() && !mail.getText().isEmpty()) {
					if (controller.search(id.getText()) != null) {

						JLabel dup = new JLabel("Duplicate Id");
						dup.setName("Duplicate Id");
						iu.add(dup);
						iu.revalidate();

					} else {
						controller.add(id.getText(), name.getText(), mail.getText());
						mainWindow.viewInsert();
					}
				}
				else
				{

					JLabel empty = new JLabel("Empty");
					empty.setName("Empty");
					iu.add(empty);
					iu.revalidate();
				}
			}
		});

		okButton.setName("Ok");
		this.add(okButton);
		
		JButton returnButton = new JButton("Return");
		returnButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				mainWindow.viewMain();

			}
		});

		returnButton.setName("Return");
		this.add(returnButton);
	}

}
