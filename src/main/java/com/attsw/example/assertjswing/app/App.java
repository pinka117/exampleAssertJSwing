package com.attsw.example.assertjswing.app;

import com.attsw.example.assertjswing.controller.Controller;
import com.attsw.example.assertjswing.model.ListModel;
import com.attsw.example.assertjswing.ui.MainWindow;

public class App {

	public static void main(String[] args) {
		ListModel lm = new ListModel();
		Controller co = new Controller(lm);
		MainWindow mw = new MainWindow(co);
		mw.setVisible(true);
	}
}