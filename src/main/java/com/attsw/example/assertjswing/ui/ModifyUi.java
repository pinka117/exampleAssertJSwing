package com.attsw.example.assertjswing.ui;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.attsw.example.assertjswing.model.*;
import com.attsw.example.assertjswing.controller.*;

public class ModifyUi extends JPanel {

	private static final long serialVersionUID = 1L;
	private MainWindow mainUi;
	private ModifyUi mu = this;

	public ModifyUi(MainWindow mainWindow, Controller rep, String id) {
		this.mainUi = mainWindow;
		setLayout(new GridLayout(3, 2));
		Employee e = rep.search(id);
		JLabel nameLbl = new JLabel("Name");
		nameLbl.setName("name");
		this.add(nameLbl);
		JLabel mailLbl = new JLabel("Mail");
		mailLbl.setName("mail");
		this.add(mailLbl);
		JTextField name = new JTextField();
		name.setName("name");
		name.setText(e.getName());
		name.setSize(20, 10);
		this.add(name);
		JTextField mail = new JTextField();
		mail.setName("mail");
		mail.setText(e.getMail());
		mail.setSize(20, 10);
		this.add(mail);
		JButton okButton = new JButton("Ok");
		okButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (!name.getText().isEmpty() && !mail.getText().isEmpty()) {

					rep.modify(id, name.getText(), mail.getText());
					mainUi.viewMain();
				} else {
					JLabel empty = new JLabel("empty");
					empty.setName("empty");
					mu.add(empty);
					mu.revalidate();
				}
			}
		});
		okButton.setName("ok");
		this.add(okButton);
		
		this.add(new ReturnButton(mainWindow));
	}
}
