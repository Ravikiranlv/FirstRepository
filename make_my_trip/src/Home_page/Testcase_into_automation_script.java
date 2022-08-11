package Home_page;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Testcase_into_automation_script {
	public WebDriverWait wait;
	public WebDriver driver;
	
	@BeforeClass
	public void Browserlaunch() {
		System.setProperty("webdriver.chrome.driver", "./softwares/chromedriver.exe");
		driver=new ChromeDriver();	
		Reporter.log("Browser is launched");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 20);
		driver.navigate().to("");	
	}
	@Test
	public void Login() throws EncryptedDocumentException, IOException, InterruptedException
	{
		String url = READdataFROMexcel.readFromExcel("./testdata/Book1.xlsx", "Sheet1", 0, 0);
		driver.get(url);
		Reporter.log("url is triggered");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[@id='wzrk-cancel']")));
		driver.findElement(By.xpath("//button[@id='wzrk-cancel']")).click();
		Home_Page_profile homePage = new Home_Page_profile();
		WebElement textfeild = homePage.getSearch();
		assertTrue(textfeild.isDisplayed(), "the url is not triggered");
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@aria-label='Close Notifications']")));
		//driver.findElement(By.xpath("//span[@aria-label='Close Notifications']")).click();
		//Home_Page_profile homePage = new Home_Page_profile();
	//	Thread.sleep(3000);    
	//	homePage.getSearch().sendKeys("jacket");
       // WebElement searchtext = homePage.getSearch();
      //  assertTrue(searchtext.isDisplayed(), "homepage is not displayed");
	}

}
