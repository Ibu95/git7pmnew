package stepdef;

import java.text.SimpleDateFormat;
import java.util.Date;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import utility.Home_Base;

public class Hooks extends Home_Base {

	@Before("@chrome")
	public void bfr() {
		launch("Chrome");
	}

	@Before("@chrome_Ing")
	public void bfring() {
		launch("incognito");
	}

	@Before("@edge")
	public void bfredge() {
		launch("edge");
	}

	@After
	public void aft() throws InterruptedException {
		tearDown();
	}

	@BeforeAll()
	public static void launch() {
		System.out.println("Scenario start " + new SimpleDateFormat("dd-MMM HH-mm").format(new Date()));

	}

	@AfterAll
	public static void close() throws InterruptedException {
		System.out.println("Scenario Ends " + new SimpleDateFormat("dd-MMM HH-mm").format(new Date()));

	}
}
