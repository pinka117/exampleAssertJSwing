package com.attsw.example.assertjswing.bdd.steps.insert;

import java.util.LinkedList;
import static org.mockito.Mockito.*;
import org.assertj.swing.core.BasicRobot;
import org.assertj.swing.core.Robot;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import com.attsw.example.assertjswing.controller.IController;
import com.attsw.example.assertjswing.model.Employee;
import com.attsw.example.assertjswing.ui.MainWindow;

public class InsertSteps {
	private FrameFixture window;
	private Robot robot;
	private LinkedList<Employee> listEmployees;
	private String idSave, nameSave, mailSave;
	private IController controller;

	@Given("^The main frame is visible$")
	public void showMainFrame() {
		controller = mock(IController.class);
		listEmployees = new LinkedList<Employee>();
		when(controller.allEmployees()).thenReturn(listEmployees);
		when(controller.search(anyString())).thenReturn(null);
		MainWindow frame = GuiActionRunner.execute(() -> new MainWindow(controller));
		robot = BasicRobot.robotWithCurrentAwtHierarchy();
		robot.settings().delayBetweenEvents(100);
		robot.settings().timeoutToBeVisible(100);
		window = new FrameFixture(robot, frame);
		window.show();
	}

	@When("^I click (.*)$")
	public void clickBtn(String btn) {
		if (btn.equals("Ok")) {
			for (int i = 0; i < listEmployees.size(); i++) {
				if (listEmployees.get(i).getId().equals(idSave)) {
					when(controller.search(anyString())).thenReturn(new Employee("1", "1", "1"));
				}
			}
			listEmployees.add(new Employee(idSave, nameSave, mailSave));
		}
		window.button(btn).click();
	}

	@Then("^A label (.*) is visible$")
	public void labelVisible(String lbl) {
		window.label(lbl);
	}

	@When("^I insert name (.*)$")
	public void insertName(String name) {
		window.textBox("Name").enterText(name);
		this.nameSave = name;
	}

	@And("^I insert id (.*)$")
	public void insertId(String id) {
		window.textBox("Id").enterText(id);
		this.idSave = id;
	}

	@And("^I insert mail (.*)$")
	public void insertMail(String mail) {
		window.textBox("Mail").enterText(mail);
		this.mailSave = mail;
	}

	@After
	public void tearDown() {
		if (window != null) {
			window.cleanUp();
		}
	}

	@Then("^There is an error message empty$")
	public void errorMessageEmpty() {
		listEmployees.removeLast();
		window.label("Empty");
	}

	@Then("^There is an error message Duplicate Id$")
	public void errorMessageDuplicateId() {
		window.label("Duplicate Id");
	}

	@When("^I insert lots of contacts$")
	public void iInsertLotsOfContacts() throws Throwable {
		for (Integer i = 0; i < 15; i++) {
			window.textBox("Id").enterText(i.toString());
			window.textBox("Mail").enterText("mail");
			window.textBox("Name").enterText("name");
			listEmployees.add(new Employee(i.toString(), "name", "mail"));
			window.button("Ok").click();
		}
	}

	@Then("^Contacts are visible$")
	public void contactsAreVisible() throws Throwable {
		for (int i = 0; i < listEmployees.size(); i++) {
			window.label(listEmployees.get(i).getId());
		}
	}
}