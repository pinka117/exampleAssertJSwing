package com.attsw.example.assertjswing.controller;

import java.util.List;
import com.attsw.example.assertjswing.model.Employee;
import com.attsw.example.assertjswing.model.IModel;

public class Controller implements IController {

	private IModel model;

	public Controller(IModel model) {
		super();
		this.model = model;
	}

	@Override
	public List<Employee> allEmployees() {
		return model.allEmployees();
	}

	@Override
	public Employee search(String id) {
		return model.search(id);
	}

	@Override
	public boolean remove(String id) {
		return model.remove(id);
	}

	@Override
	public void add(String id, String name, String mail) {
		model.add(new Employee(id, name, mail));
	}

	@Override
	public void modify(String id, String name, String mail) {
		model.modify(id, name, mail);
	}
}