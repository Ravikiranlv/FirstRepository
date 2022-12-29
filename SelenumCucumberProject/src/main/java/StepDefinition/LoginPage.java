package StepDefinition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dev.failsafe.internal.util.Assert;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPage {
	public WebDriver driver;
	public LoginPage(WebDriver driver) {
		driver.get("https://demo.nopcommerce.com/login");
	    PageFactory.initElements(driver, this);
	}
	@FindBy(id="Email")
	@CacheLookup
	WebElement textemail;
	
	@FindBy(id="Password")
	@CacheLookup
	WebElement textPassword;
	
	@FindBy(xpath="//button[text()='Log in']")
	@CacheLookup
	WebElement clickLoginButton;
	
	@FindBy(linkText="Log out")
	@CacheLookup
	WebElement clickLogout;
	
	public void setuserName(String Uname)
	{
		textemail.clear();
		textemail.sendKeys(Uname);
	}
	
	public void SetPwd(String pwd)
	{
		textPassword.clear();
		textPassword.sendKeys(pwd);
	}
	
	public void ClickLogin()
	{
		clickLoginButton.click();
	}
	
	public void ClickLogout()
	{
		clickLogout.click();
	}

}
