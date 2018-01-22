package com.attsw.example.assertjswing.model;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ListModelTest {
	ListModel lm;
	Employee e;
	Employee e2;

	@Before
	public void setUp() {
		lm = new ListModel();
		e = new Employee("1", "1", "1");
		e2 = new Employee("2", "2", "2");
	}

	@Test
	public void testNoEmployees() {
		assertEquals(0, lm.allEmployees().size());
	}

	@Test
	public void testOneEmployee() {
		lm.add(e);
		assertEquals(1, lm.allEmployees().size());
		assertEquals(e, lm.search("1"));
	}

	@Test
	public void testTwoEmployees() {
		lm.add(e);
		lm.add(e2);
		assertEquals(2, lm.allEmployees().size());
		assertEquals(e2, lm.search("2"));
	}

	@Test
	public void testRemoveOk() {
		lm.add(e);
		lm.add(e2);
		assertTrue(lm.remove("2"));
		assertEquals(1, lm.allEmployees().size());
		assertNull(lm.search("2"));
	}

	@Test
	public void testRemoveNotPresent() {
		lm.add(e);
		assertFalse(lm.remove("2"));
	}
	@Test
	public void testModifyOk() {
		lm.add(e);
		assertTrue(lm.modify("1", "2", "2"));
		assertEquals("2",lm.search("1").getName());
		assertEquals("2",lm.search("1").getMail());
	}
	@Test
	public void testModifyNotPresent() {
		assertFalse(lm.modify("1", "2", "2"));
	}

}
