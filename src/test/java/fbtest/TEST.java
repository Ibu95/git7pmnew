package fbtest;

import org.testng.Assert;
import org.testng.annotations.*;

import fbpom.Login;
import utility.Home_Base;

public class TEST extends Home_Base {
	public static Login l;

	@BeforeClass
	private void bfr() {
		launch("Chrome");
		l = new Login();
	}

	@AfterClass
	private void aft() throws InterruptedException {
		tearDown();
	}

	@Test
	private void tc1() {
		Assert.fail();
		l.getUsr().sendKeys("Shv");
		l.getPas().sendKeys("Tec");
		l.getLg().click();
	}

	@Test
	private void tc2() {
		l.getUsr().sendKeys("Shv");
			Assert.fail();
		l.getPas().sendKeys("Tec");
		l.getLg().click();
	}

	@Test
	private void tc3() {
		l.getUsr().sendKeys("Shv");
		l.getPas().sendKeys("Tec");
		l.getLg().click();
	}

	@BeforeMethod
	private void bfrmtd() {
		driver.get("https://www.facebook.com/");
	}

	@AfterMethod
	private void aftmtd() {
		driver.navigate().refresh();
	}

}
