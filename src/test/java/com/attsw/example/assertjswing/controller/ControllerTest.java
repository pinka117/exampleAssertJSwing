package com.attsw.example.assertjswing.controller;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import java.util.LinkedList;
import org.junit.Before;
import org.junit.Test;
import com.attsw.example.assertjswing.model.Employee;
import com.attsw.example.assertjswing.model.IModel;

public class ControllerTest {

	IModel ic;
	Controller cont;
	LinkedList<Employee> list;

	@Before
	public void setUp() {
		list = new LinkedList<Employee>();
		ic = mock(IModel.class);
		when(ic.allEmployees()).thenReturn(list);
		when(ic.search("1")).thenReturn(new Employee("1", "1", "1"));
		when(ic.remove("1")).thenReturn(true);
		cont = new Controller(ic);
	}

	@Test
	public void testNoEmployees() {
		assertEquals(0, cont.allEmployees().size());
		verify(ic, times(1)).allEmployees();
	}

	@Test
	public void testOneEmployee() {
		cont.add("1", "1", "1");
		list.add(new Employee("1", "1", "1"));
		verify(ic, times(1)).add(anyObject());
		assertEquals(1, cont.allEmployees().size());
		verify(ic, times(1)).allEmployees();
		assertEquals("1", cont.search("1").getId());
		verify(ic, times(1)).search("1");
	}

	@Test
	public void testRemove() {
		cont.add("1", "1", "1");
		list.add(new Employee("1", "1", "1"));
		cont.add("2", "2", "2");
		list.add(new Employee("2", "2", "2"));
		cont.remove("1");
		verify(ic, times(1)).remove("1");
	}

	@Test
	public void testModify() {
		cont.add("1", "1", "1");
		list.add(new Employee("1", "1", "1"));
		cont.modify("1", "2", "2");
		verify(ic, times(1)).modify("1", "2", "2");
	}
}
