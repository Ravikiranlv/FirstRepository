package make_my_trip;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TC_makeMyTrip_001 {
     
	@DataProvider
	public String[][] testData() throws IOException {
		String[][] dataFromExcel1 = Excelutility_01.readMultipleDataFromExcel("./testdata/Book1.xlsx", "Sheet2");
		return dataFromExcel1;
	}

	@Test(dataProvider = "testData")
	public void readDataProvider(String[] arr) throws EncryptedDocumentException, IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", "./softwares/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.navigate().to("https://www.makemytrip.com/");

		driver.findElement(By.xpath("//span[@class='langCardClose']")).click();
		driver.findElement(By.xpath("//span[text()='From']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		Actions act = new Actions(driver);
		WebElement ple = driver.findElement(By.xpath("//input[@placeholder='From']"));
		ple.sendKeys(arr[0]);
		Thread.sleep(2000);
		WebElement fromPlace = wait.until(
				ExpectedConditions.visibilityOf(driver.findElement(By.id("react-autowhatever-1-section-0-item-0"))));
		act.moveToElement(fromPlace).click().build().perform();

		driver.findElement(By.xpath("//span[text()='To']")).click();
		WebElement ple1 = driver.findElement(By.xpath("//input[@placeholder='To']"));
		ple1.sendKeys(arr[1]);
		Thread.sleep(2000);
		WebElement fromPlace1 = wait.until(
				ExpectedConditions.visibilityOf(driver.findElement(By.id("react-autowhatever-1-section-0-item-0"))));
		act.moveToElement(fromPlace1).click().build().perform();

		driver.findElement(By.xpath("//span[.='DEPARTURE']")).click();
		Thread.sleep(3000);
		LocalDateTime ldt = LocalDateTime.now().plusYears(9);
		ldt.plusDays(15);
		String month = ldt.getMonth().toString();
		String monthValue = month.substring(0, 1).toUpperCase() + month.substring(1, month.length()).toLowerCase();
		int year = ldt.getYear();
		int day = ldt.getDayOfMonth();

		selectDate(driver, "August", 2022, 22);
	}

	public static void selectDate(WebDriver driver, String monthValue, int year, int day) throws InterruptedException {
		for (;;) {
			try {
				driver.findElement(
						By.xpath("//div[text()='" + monthValue + " " + year + "']/../..//p[text()='" + day + "']"))
						.click();
				break;
			} catch (NoSuchElementException e) {
				driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
			}
		}
		driver.findElement(By.xpath("//a[text()='Search']")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions
		//		.presenceOfElementLocated(By.xpath("//span[@class='bgProperties icon20 overlayCrossIcon']")));
		//driver.findElement(By.xpath("//span[@class='bgProperties icon20 overlayCrossIcon']")).click();

		JavascriptExecutor jse = (JavascriptExecutor) driver;
		Thread.sleep(2000);
		for(int i=0;i<20;i++)
		{
		jse.executeScript("window.scrollBy(0,500);");
		}
		List<WebElement> count = driver.findElements(By.xpath("//div[@class='listingCard']"));
		int sizes = count.size();
		System.out.println(sizes);
		
		driver.quit();
	}

}
