package projectLogin;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProjectElements {

	WebDriver driver;

	public ProjectElements(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "username")
	public WebElement usernamefield;
	@FindBy(name = "password")
	public WebElement passwordfield;
	@FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
	public WebElement loginbutton;

	@FindBy(linkText = "Manage Users")
	public WebElement manageusers;

	@FindBy(xpath = "//a[@class='brand-link navbar-dark']/img")
	public WebElement logo;

	@FindBy(xpath = "//span[text()='7rmart supermarket']")
	public WebElement title;

	@FindBy(xpath = "//div[@class='row mb-2']/div/h1")
	public WebElement listusertext;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr")
	public List<WebElement> tablerow;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td")
	public List<WebElement> tablecolumn;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[5]//a//span")
	public WebElement userstausbuttontext;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[5]//following-sibling::a[1]")
	public WebElement changeuserstatus;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[6]//a[1]")
	public WebElement changeuserstatusbutton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	public WebElement statuschangealert;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']//button")
	public WebElement alertclose;

	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[6]//following-sibling::a[2]")
	public WebElement deleteuser;

	@FindBy(xpath = "//div[@class='col-sm-12']//a[1]")
	public WebElement searchbutton;

	@FindBy(id = "un")
	public WebElement searchnamefield;
	@FindBy(id = "ut")
	public WebElement searchemailfield;
	@FindBy(id = "ph")
	public WebElement searchphonefield;
	@FindBy(id = "st")
	public WebElement searchstatusfield;
	@FindBy(xpath = "//div[@class='card-body']//button")
	public WebElement searchclick;
	@FindBy(xpath = "//div[@class='card-body']//a")
	public WebElement searchreset;

	@FindBy(linkText = "Home")
	public WebElement navigatetohome;
	@FindBy(xpath = "//div[@class='row']//div[9]//div//div//h3")
	public WebElement usercount;

	@FindBy(xpath = "//nav[@class='mt-2']//ul//li[8]//a//p//i")
	public WebElement managecontent;
	@FindBy(xpath = "//li[@class='nav-item has-treeview menu-open']//ul[4]//li//a")
	public WebElement managenews;
	@FindBy(xpath = "//div[@class='col-sm-12']//a[1]")
	public WebElement addnews;
	@FindBy(xpath = "//div[@class='form-group']//textarea")
	public WebElement newstextarea;
	@FindBy(xpath = "//div[@class='card-footer']//button")
	public WebElement savenews;

	@FindBy(xpath = "//nav/ul[2]/li/a")
	public WebElement logoutadmintext;
	@FindBy(xpath = "//nav/ul[2]/li/div/a[2]")
	public WebElement logoutclick;

}
