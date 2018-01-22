package com.attsw.example.assertjswing.bdd.steps.modify;

import static org.mockito.Mockito.*;
import java.util.LinkedList;
import org.assertj.swing.core.BasicRobot;
import org.assertj.swing.core.Robot;
import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import com.attsw.example.assertjswing.model.*;
import com.attsw.example.assertjswing.ui.MainWindow;
import com.attsw.example.assertjswing.controller.*;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ModifySteps {
	private FrameFixture window;
	private Robot robot;
	private LinkedList<Employee> listEmployees;
	private MainWindow frame;
	private IController es;

	@Given("^I want to modify$")
	public void showMainFrame() {
		FailOnThreadViolationRepaintManager.install();
		es = mock(IController.class);
		listEmployees = new LinkedList<Employee>();
		listEmployees.add(new Employee("1", "name1", "mail1"));
		when(es.allEmployees()).thenReturn(listEmployees);
		when(es.search("1")).thenReturn(this.search("1"));
		frame = GuiActionRunner.execute(() -> new MainWindow(es));
		robot = BasicRobot.robotWithCurrentAwtHierarchy();
		robot.settings().delayBetweenEvents(100);
		robot.settings().timeoutToBeVisible(100);
		window = new FrameFixture(robot, frame);
		window.show();
	}

	private Employee search(String id) {
		for (int i = 0; i < listEmployees.size(); i++) {
			if (listEmployees.get(i).getId().equals(id)) {
				return listEmployees.get(i);
			}
		}
		return null;
	}

	@After
	public void tearDown() {
		if (window != null) {
			window.cleanUp();
		}
	}

	@When("^I modify key (.*) name to (.*)$")
	public void ModifyName(String id, String newName) {
		window.textBox("name").deleteText();
		window.textBox("name").enterText(newName);
		for (int i = 0; i < listEmployees.size(); i++) {
			if (listEmployees.get(i).getId().equals(id)) {
				listEmployees.get(i).setName(newName);
			}
		}
	}

	@And("^An employee with (.*),(.*),(.*) is present$")
	public void rowPresent(String id, String name, String mail) {
		window.label(id);
		window.label(name);
		window.label(mail);
	}

	@And("^I click (.*)$")
	public void iClickBtn(String btn) {
		window.button(btn).click();
	}

	@When("^I modify key (.*) mail to (.*)$")
	public void ModifyMail(String id, String newMail) {

		window.textBox("mail").deleteText();
		window.textBox("mail").enterText(newMail);
		for (int i = 0; i < listEmployees.size(); i++) {
			if (listEmployees.get(i).getId().equals(id)) {
				listEmployees.get(i).setMail(newMail);
			}
		}
	}

	@Then("^There is a label empty$")
	public void thereIsALabelEmpty() {
		window.label("empty");
	}

	@And("^I insert empty mail$")
	public void iInsertEmptyMail() {
		window.textBox("mail").deleteText();
	}

	@And("^I insert empty name$")
	public void iInsertEmptyName() {
		window.textBox("name").deleteText();
	}

}
