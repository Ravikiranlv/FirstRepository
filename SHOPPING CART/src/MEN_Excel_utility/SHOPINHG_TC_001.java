package MEN_Excel_utility;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SHOPINHG_TC_001 {
	@DataProvider
	public String[][] Testdata() throws EncryptedDocumentException, IOException
	{
		String[][] dataFromExcel=Excelutility.ReadmultipleDataFromExcel("./testdata/Book1.xlsx","Shoppingkart");
		return dataFromExcel;
	}
	
	@Test(dataProvider = "Testdata")
	public void ReadDataFromDataProvider(String[] arr)
	{
		System.setProperty("webdriver.chrome.driver", "./softwares/chromedriver1.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		WebDriverWait wait=new WebDriverWait(driver, 10);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.navigate().to("http://www.firelawn.com/");
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		driver.findElement(By.xpath("//span[text()='Create your Firelawn Account']")).click();
		driver.findElement(By.id("FirstName")).sendKeys(arr[0]);
		driver.findElement(By.id("lastName")).sendKeys(arr[1]);
		driver.findElement(By.xpath("//input[@value='male']")).click();
		driver.findElement(By.id("phoneNumber")).sendKeys(arr[2]);
		driver.findElement(By.id("email")).sendKeys(arr[3]);
		driver.findElement(By.xpath("//input[@type='checkbox']")).click();
		driver.findElement(By.xpath("//button[text()='Register']")).click();
		
		driver.findElement(By.xpath("//button[text()='Sign In']")).click();
		driver.findElement(By.id("username")).sendKeys(arr[3]);
		driver.findElement(By.id("password")).sendKeys(arr[4]);
		driver.findElement(By.className("MuiButton-label")).click();
		
	}

}
