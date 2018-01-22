package com.attsw.example.assertjswing.bdd.steps.delete;

import static org.junit.Assert.fail;
import static org.mockito.Mockito.*;
import java.util.LinkedList;
import org.assertj.swing.core.BasicRobot;
import org.assertj.swing.core.Robot;
import org.assertj.swing.edt.FailOnThreadViolationRepaintManager;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import com.attsw.example.assertjswing.controller.*;
import com.attsw.example.assertjswing.model.*;
import com.attsw.example.assertjswing.ui.*;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class DeleteSteps {

	private FrameFixture window;
	private Robot robot;
	private LinkedList<Employee> listEmployees;
	private IController es;

	@Given("^I want to delete$")
	public void showMainFrame() {
		FailOnThreadViolationRepaintManager.install();
		es = mock(IController.class);
		listEmployees = new LinkedList<Employee>();
		listEmployees.add(new Employee("1", "name1", "mail1"));
		when(es.allEmployees()).thenReturn(listEmployees);
		when(es.remove(anyString())).thenReturn(true);
		MainWindow frame = GuiActionRunner.execute(() -> new MainWindow(es));
		robot = BasicRobot.robotWithCurrentAwtHierarchy();
		robot.settings().delayBetweenEvents(100);
		robot.settings().timeoutToBeVisible(100);
		window = new FrameFixture(robot, frame);
		window.show();
	}

	@And("^id 1 is present$")
	public void isPresent() {
		window.label("1");
	}

	@When("^i remove id (.*)$")
	public void remove(String id) {
		listEmployees.removeLast();
		window.button("remove" + id).click();
		verify(es, times(1)).remove(id);
	}

	@Then("id 1 not present")
	public void notPresent() {
		try {
			window.label("1");
			fail();
		} catch (Exception e) {
		}
	}

	@After
	public void tearDown() {
		if (window != null) {
			window.cleanUp();
		}
	}
}