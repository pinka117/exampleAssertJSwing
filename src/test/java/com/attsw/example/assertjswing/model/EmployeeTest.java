package com.attsw.example.assertjswing.model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class EmployeeTest {
	private Employee e;

	@Before
	public void setUp() {
		e = new Employee("1", "mario", "mario@gmail.com");
	}

	@Test
	public void idTest() {
		assertEquals("1", e.getId());
	}

	@Test
	public void nameTest() {
		assertEquals("mario", e.getName());
	}

	@Test
	public void mailTest() {
		assertEquals("mario@gmail.com", e.getMail());
	}

	@Test
	public void mailChangeTest() {
		e.setMail("mail");
		assertEquals("mail", e.getMail());
	}

	@Test
	public void nameChangeTest() {
		e.setName("name");
		assertEquals("name", e.getName());
	}
}