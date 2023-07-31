package fbpom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import utility.Home_Base;

public class Login extends Home_Base {

	// RT RV value/Data
	// WebElement user = driver.findElement(By.id("email"));

	public Login() {
		PageFactory.initElements(driver, this);
	}

	@FindBys({ @FindBy(id = "email"), @FindBy(xpath = "//input[@id='email']") })
	private WebElement usr;

	@FindAll({ @FindBy(name = "pass"), @FindBy(xpath = "//input[@name='pas']") })
	private WebElement pas;
	@FindBy(name = "login")
	private WebElement lg;

	public WebElement getUsr() {
		return usr;
	}

	public WebElement getPas() {
		return pas;
	}

	public WebElement getLg() {
		return lg;
	}

}
