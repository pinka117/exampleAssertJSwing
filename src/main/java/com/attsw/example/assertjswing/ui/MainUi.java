package com.attsw.example.assertjswing.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.attsw.example.assertjswing.controller.Controller;
import com.attsw.example.assertjswing.model.Employee;

import java.awt.event.MouseAdapter;


public class MainUi extends JPanel{

	private static final long serialVersionUID = 1L;
	private MainWindow mainWindow;
	private transient Controller controller;
	private JPanel table;

	public MainUi(MainWindow mainWindow, Controller controller) {
		int rows = 1;
		this.mainWindow = mainWindow;
		this.controller = controller;
		setLayout(new BorderLayout());
		JButton btnAddContact = new JButton("Add contact");
		btnAddContact.setName("Add contact");
		btnAddContact.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				mainWindow.viewInsert();
			}
		});
		this.add(btnAddContact,BorderLayout.NORTH);
		table = new JPanel();
		LinkedList<String> columnNames = new LinkedList<>();
		columnNames.add("Id");
		columnNames.add("Name");
		columnNames.add("Mail");
		Iterator<String> itCN = columnNames.iterator();
		while (itCN.hasNext()) {

			String t = itCN.next();
			JLabel title = new JLabel(t);
			title.setName(t);
			table.add(title);
			}
			
			

		
	List<Employee> list = controller.allEmployees();
	Iterator<Employee> it = list.iterator();
	while (it.hasNext()) {
		Employee e = it.next();
		JLabel id = new JLabel(e.getId());
		id.setName(e.getId());
		table.add(id);
		JLabel name = new JLabel(e.getName());
		name.setName(e.getName());
		table.add(name);
		JLabel mail = new JLabel(e.getMail());
		mail.setName(e.getMail());
		table.add(mail);
		
		rows++;
	}
		
		
	table.setLayout(new GridLayout(rows, 3));
	add(table, BorderLayout.CENTER);
	}

}
