package com.attsw.example.assertjswing.controller;

import java.util.List;
import com.attsw.example.assertjswing.model.Employee;

public interface Controller {
	public List<Employee> allEmployees();
	public Employee search(String id) ;
	public boolean remove(String string);
	public boolean add(String id,String name,String mail) ;
	public void modify(String id, String name, String mail) ;
}
