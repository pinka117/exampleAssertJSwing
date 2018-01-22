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
	private JPanel pnl;
	private JPanel pnlerror;

	public ModifyUi(MainWindow mainWindow, IController rep, String id) {
		this.mainUi = mainWindow;
		setLayout(new GridLayout(3, 1));
		pnl = new JPanel();
		pnlerror = new JPanel();
		pnl.setLayout(new GridLayout(3, 2, 10, 30));
		Employee e = rep.search(id);
		JLabel nameLbl = new JLabel("Name");
		nameLbl.setName("name");
		pnl.add(nameLbl);
		JLabel mailLbl = new JLabel("Mail");
		mailLbl.setName("mail");
		pnl.add(mailLbl);
		JTextField name = new JTextField();
		name.setName("name");
		name.setText(e.getName());
		name.setSize(20, 10);
		pnl.add(name);
		JTextField mail = new JTextField();
		mail.setName("mail");
		mail.setText(e.getMail());
		mail.setSize(20, 10);
		pnl.add(mail);
		JButton okButton = new JButton("Ok");
		okButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (!name.getText().isEmpty() && !mail.getText().isEmpty()) {
					rep.modify(id, name.getText(), mail.getText());
					mainUi.viewMain();
				} else {
					JLabel empty = new JLabel("Empty");
					empty.setName("empty");
					pnlerror.removeAll();
					pnlerror.add(empty);
					mu.revalidate();
				}
			}
		});
		okButton.setName("ok");
		pnl.add(okButton);
		pnl.add(new ReturnButton(mainWindow));
		this.add(pnl);
		this.add(pnlerror);
		this.add(new JPanel());
	}
}
