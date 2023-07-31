package stepdef;

import java.io.InputStream;
import java.util.Properties;

import fbpom.Login;
import io.cucumber.java.en.*;
import utility.Home_Base;

public class Fb_SetpDef extends Home_Base {
	public static Login l;

	@Given("User Open the chrome Incognito Browser")
	public void user_open_the_chrome_incognito_browser() {
		launch("incognito");
		l = new Login();
	}

	@Given("User Open the Edge Browser")
	public void user_open_the_edge_browser() {
		launch("edge");
		l = new Login();
	}



	@When("User Load the Facebook login page")
	public void user_load_the_facebook_login_page() {
		l = new Login();
		driver.get("https://www.facebook.com/");
	}

	@Given("User Enter the Valid Username {string}")
	public void user_enter_the_valid_username(String string) {
		l.getUsr().sendKeys(string);
	}

	@Given("User Enter the Valid  Password {string}")
	public void user_enter_the_valid_password(String string) {
		l.getPas().sendKeys(string);
	}

	@When("User Click the Login button")
	public void user_click_the_login_button() {
		l.getLg().click();

	}

	@Then("it should accept the Login and Load home Page")
	public void it_should_accept_the_login_and_load_home_page() {
		System.out.println("Login Sucess");
	}

	

}
