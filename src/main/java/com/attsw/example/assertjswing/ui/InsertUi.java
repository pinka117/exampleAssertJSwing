package com.attsw.example.assertjswing.ui;

import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import com.attsw.example.assertjswing.controller.IController;

public class InsertUi extends JPanel {

	private static final long serialVersionUID = 1L;
	private MainWindow mainWindow;
	private transient IController controller;
	private InsertUi iu = this;
	private JTextField id;
	private JTextField name;
	private JTextField mail;
	private JPanel pnl;

	public InsertUi(MainWindow mainWindow, IController controller) {
		this.mainWindow = mainWindow;
		this.controller = controller;
		setLayout(new GridLayout(3, 1));
		pnl = new JPanel();
		addComp();
		this.add(pnl);
		this.add(new JPanel());
		this.add(new JPanel());
	}

	private void addComp() {
		pnl.setLayout(new GridLayout(3, 2, 10, 30));
		addLabels();
		addFields();
		addOkButton();
		pnl.add(new ReturnButton(mainWindow));
	}

	private void addOkButton() {
		JButton okButton = new JButton("Ok");
		okButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (!id.getText().isEmpty() && !name.getText().isEmpty() && !mail.getText().isEmpty()) {
					if (controller.search(id.getText()) != null) {
						JLabel dup = new JLabel("Duplicate Id");
						dup.setName("Duplicate Id");
						pnl.removeAll();
						addComp();
						pnl.add(dup);
						iu.revalidate();
					} else {
						controller.add(id.getText(), name.getText(), mail.getText());
						mainWindow.viewInsert();
					}
				} else {
					JLabel empty = new JLabel("Empty");
					empty.setName("Empty");
					pnl.removeAll();
					addComp();
					pnl.add(empty);
					iu.revalidate();
				}
			}
		});
		okButton.setName("Ok");
		pnl.add(okButton);
	}

	private void addFields() {
		id = new JTextField();
		id.setName("Id");
		id.setSize(20, 10);
		pnl.add(id);
		name = new JTextField();
		name.setName("Name");
		name.setSize(20, 10);
		pnl.add(name);
		mail = new JTextField();
		mail.setName("Mail");
		mail.setSize(20, 10);
		pnl.add(mail);
	}

	private void addLabels() {
		JLabel idLbl = new JLabel("Id");
		idLbl.setName("Id");
		pnl.add(idLbl);
		JLabel nameLbl = new JLabel("Name");
		nameLbl.setName("Name");
		pnl.add(nameLbl);
		JLabel mailLbl = new JLabel("Mail");
		mailLbl.setName("Mail");
		pnl.add(mailLbl);
	}
}