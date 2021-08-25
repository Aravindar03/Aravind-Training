package obsquraProject;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import excelRead.ExcelReadLogin;
import excelRead.ExcelReadSearch;
import projectLogin.ProjectElements;
import projectUtilities.UtilityRepository;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeTest;
import java.io.IOException;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class ManageUsers {

	SoftAssert softAssert = new SoftAssert();
	WebDriver driver;
	UtilityRepository utilRep = new UtilityRepository();
	ProjectElements objElements1;
	ExcelReadSearch objsearchData = new ExcelReadSearch();

	@Test(priority = 1)
	public void manageUsers() throws IOException {
		driver = UtilityRepository.driver;
		objElements1 = UtilityRepository.objprojectElements;
		objElements1.manageusers.click();
		String actualmanageusertitle = objElements1.listusertext.getText();
		String expectedmanageusertitle = "List Users";
		Assert.assertEquals(actualmanageusertitle, expectedmanageusertitle);
		// utilrep.screenshotCapture("userslist", ".png");// to take screenshot of the
		// user list page.
		int tablerowcount = objElements1.tablerow.size();
		System.out.println("Tablerowcount: " + tablerowcount);
		int tablecolumncount = objElements1.tablecolumn.size();
		System.out.println(tablecolumncount);

		for (int row = 1; row <= tablerowcount; row++) {

			for (int col = 1; col <= tablecolumncount; col++) {
				String tablecontent = driver
						.findElement(By.xpath("//table[@class='table table-bordered table-hover table-sm']/tbody/tr["
								+ row + "]/td[" + col + "]"))
						.getText();
				System.out.println(tablecontent);

			}
			System.out.println();
			row++;
		}
	}

	@Test(priority = 2)
	public void userstatusChange() throws IOException {
		String previousstatus = objElements1.userstausbuttontext.getText();
		System.out.println("Previous Status: " + previousstatus);
		String expectedstatusone = "Active";
		String expectedstatustwo = "Inactive";
		if (previousstatus.equals("expectedstatusone")) {
			objElements1.changeuserstatus.click();
			String currentstatus = objElements1.userstausbuttontext.getText();
			System.out.println("Current Status: " + currentstatus);
			Assert.assertEquals(currentstatus, expectedstatustwo);

		} else {
			objElements1.changeuserstatus.click();
			String currentstatus = objElements1.userstausbuttontext.getText();
			System.out.println("Current Status: " + currentstatus);
			Assert.assertEquals(currentstatus, expectedstatusone);

		}
		objElements1.alertclose.click();

	}

	@Test(priority = 3)
	public void deleteUser() throws IOException {
		objElements1.deleteuser.click();
		Alert alertbox = driver.switchTo().alert();
		// alertbox.accept(); //this code is commented because this part will delete
		// users from the list.
		alertbox.dismiss();

	}

	@Test(priority = 4)
	public void searchUser() throws IOException {
		objElements1.searchbutton.click();

		for (int search = 0; search <= 1; search++) {
			objElements1.searchnamefield.clear();
			objElements1.searchemailfield.clear();
			objElements1.searchphonefield.clear();

			objsearchData.excelReadsearch(search);
			utilRep.sendKeys(objElements1.searchnamefield, objsearchData.searchname);
			utilRep.sendKeys(objElements1.searchemailfield, objsearchData.searchemail);
			objElements1.searchstatusfield.click();
			Select statusvalue = new Select(objElements1.searchstatusfield);
			statusvalue.selectByValue("active");
			objElements1.searchclick.click();
			


		}
		objElements1.searchreset.click();

	}

	@Test(priority = 5)
	public void usercountDashboard() throws IOException {
		objElements1.navigatetohome.click();
		String totalusercount = objElements1.usercount.getText();
		System.out.println("Total user count: " + totalusercount);

	}

	@Test(priority = 6)
	public void manageNews() throws IOException {
		objElements1.managecontent.click();
		objElements1.managenews.click();
		objElements1.addnews.click();
		objElements1.newstextarea.click();
		utilRep.sendKeys(objElements1.newstextarea, "This is a test news added as part of project.");
		objElements1.savenews.click();
		objElements1.managenews.click();

	}

	@Test(priority = 7)
	public void userLogout() throws IOException {
		objElements1.logoutadmintext.click();
		objElements1.logoutclick.click();

	}

	@BeforeTest
	public void setUp() {

	}

}
