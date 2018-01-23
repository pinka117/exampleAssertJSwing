package com.attsw.example.assertjswing.model;

import java.util.List;

public interface IModel {

	List<Employee> allEmployees();

	public void add(Employee employee);

	public Employee search(String id);

	public boolean remove(String id);

	public boolean modify(String id, String name, String mail);
}