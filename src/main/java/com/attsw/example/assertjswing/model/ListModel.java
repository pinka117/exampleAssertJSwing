package com.attsw.example.assertjswing.model;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ListModel implements IModel {

	private LinkedList<Employee> list = new LinkedList<>();

	@Override
	public List<Employee> allEmployees() {
		return list;
	}

	public void add(Employee employee) {
		list.add(employee);
	}

	public Employee search(String id) {
		Iterator<Employee> it = list.iterator();
		while (it.hasNext()) {
			Employee e = it.next();
			if (e.getId().equals(id)) {
				return e;
			}
		}
		return null;
	}

	public boolean remove(String id) {
		Employee rm = this.search(id);
		if (rm != null) {
			list.remove(rm);
			return true;
		}
		return false;
	}

	@Override
	public boolean modify(String id, String name, String mail) {
		Employee rm = this.search(id);
		if (rm != null) {
			rm.setName(name);
			rm.setMail(mail);
			return true;
		}
		return false;
	}
}