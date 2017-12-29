package com.attsw.example.assertjswing.ui;

import java.awt.Dimension;

import javax.swing.JFrame;

import com.attsw.example.assertjswing.controller.Controller;

public class MainWindow extends JFrame{

	private static final long serialVersionUID = 1L;
	private transient Controller controller;
	private MainWindow frame = this;

	public MainWindow(Controller controller) {
		this.controller = controller;
		this.setSize(500, 500);
		this.setResizable(false);
		this.setPreferredSize(new Dimension(500, 500));
		this.getContentPane().add(new MainUi(this, controller));
	}

	public void viewInsert() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(new InsertUi(this,controller));
		frame.revalidate();
	}
	public void viewMain() {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(new MainUi(this, controller));
		frame.revalidate();
	}
	public void viewModify(String id) {
		frame.getContentPane().removeAll();
		ModifyUi mod = new ModifyUi(this, controller,id);
		frame.getContentPane().add(mod);
		frame.revalidate();
		
	}

}
