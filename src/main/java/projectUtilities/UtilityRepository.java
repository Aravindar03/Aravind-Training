package projectUtilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import projectLogin.ProjectElements;

public class UtilityRepository {
	public static WebDriver driver;
	public static ProjectElements objprojectElements;

	public WebDriver getUrl(String url, String browser) {

		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "D:\\Chrome\\chromedriver.exe");
			driver = new ChromeDriver();
			break;

		case "mozilla":
			System.setProperty("webdriver.gecko.driver", "D:\\Firefox Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
			break;
		}
		driver.get(url);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		return driver;
	}

	public void screenshotCapture(String fileName, String extension) throws IOException {
		File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String timestamp = new SimpleDateFormat("dd_MM_yyyy__hh_mm_ss").format(new Date());
		File destnfile = new File("C:\\Users\\Aravind A R\\eclipse-workspace\\ObsquraProject\\target\\" + fileName + ""
				+ timestamp + "" + extension);
		FileHandler.copy(srcfile, destnfile);

	}

	public void sendKeys(WebElement property, String textcontent) {
		(property).sendKeys(textcontent);
	}

}
