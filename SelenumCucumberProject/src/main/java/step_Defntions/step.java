package step_Defntions;


import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import StepDefinition.LoginPage;
import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class step {
	public WebDriver driver;
	public LoginPage lp;
	@Given("User Launch Crome browser")
	public void user_launch_crome_browser() {
		System.setProperty("webdriver.chrome.driver", "./softwares/chromedriver1.exe");
	    driver=new ChromeDriver();
	    lp=new LoginPage(driver);
	}

	@When("User open URL\"https:\\/\\/demo.nopcommerce.com\\/login\"")
	public void user_open_url_https_demo_nopcommerce_com_login(String URL) {
	   driver.get("https://demo.nopcommerce.com/login");
	}

	@When("User enters Email as {string} and password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
	    lp.setuserName(email);
	    lp.SetPwd(password);
	}

	@When("Click on Loin")
	public void click_on_loin() {
	    lp.ClickLogin();
	}

	@Then("page Title should be {string}")
	public void page_title_should_be1(String title) {
	   if(driver.getPageSource().contains("Login was unsuccessful"))
	   {
		   driver.close();
		   assert assertTrue(false);
		   }
	   else
	   {
		   assert asserequal(title,driver.getTitle());
	   }
	}

	private boolean asserequal(String title, String string) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean assertTrue(boolean b) {
		// TODO Auto-generated method stub
		return false;
	}

	@When("user Click on Log out link")
	public void user_click_on_log_out_link() throws InterruptedException {
	   lp.ClickLogout();
	   Thread.sleep(2000);
	}

	@Then("Close Browser")
	public void close_browser() {
	    driver.close();
	}


}
