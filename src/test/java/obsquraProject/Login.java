package obsquraProject;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import excelRead.ExcelReadLogin;
import excelRead.ExcelReadSearch;
import projectLogin.ProjectElements;
import projectUtilities.UtilityRepository;

import org.testng.annotations.BeforeTest;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Login {
	int i = 0;

	SoftAssert softAssert = new SoftAssert();
	static WebDriver driver1;
	UtilityRepository utilRep = new UtilityRepository();
	ProjectElements objElements;
	ExcelReadLogin objCredentials = new ExcelReadLogin();

	@Test(priority = 1)
	public void invaliduserLogin() throws IOException {

		objCredentials.excelReadinput(i);
		objElements.usernamefield.clear();
		objElements.passwordfield.clear();
		utilRep.sendKeys(objElements.usernamefield, objCredentials.username);
		utilRep.sendKeys(objElements.passwordfield, objCredentials.password);
		objElements.loginbutton.click();
		utilRep.screenshotCapture("LoginFailure", ".png");
		String expectedusername1 = "admin";
		String expectedpassword1 = "admin";
		Assert.assertEquals(objCredentials.username, expectedusername1);
		Assert.assertEquals(objCredentials.password, expectedpassword1);

	}

	@Test(priority = 2)
	public void validuserLogin() throws IOException {
		i++;

		objCredentials.excelReadinput(i);
		objElements.usernamefield.clear();
		objElements.passwordfield.clear();
		utilRep.sendKeys(objElements.usernamefield, objCredentials.username);
		utilRep.sendKeys(objElements.passwordfield, objCredentials.password);
		objElements.loginbutton.click();
		String expectedusername2 = "admin";
		String expectedpassword2 = "admin";
		Assert.assertEquals(objCredentials.username, expectedusername2);
		Assert.assertEquals(objCredentials.password, expectedpassword2);
		UtilityRepository.objprojectElements = objElements;

	}

	@Test(priority = 3)
	public void validateLogo() throws IOException {

		utilRep.screenshotCapture("logo", ".png");

	}

	@Test(priority = 4)
	public void validateTitle() throws IOException {
		String actualtitle = objElements.title.getText();
		String expectedtitle = "7rmart supermarket";
		Assert.assertEquals(actualtitle, expectedtitle);

	}

	@BeforeTest
	public void setUp() {
		driver1 = utilRep.getUrl("http://groceryapp.uniqassosiates.com/admin", "mozilla");
		UtilityRepository.driver = driver1;
		objElements = new ProjectElements(driver1);
	}

}
