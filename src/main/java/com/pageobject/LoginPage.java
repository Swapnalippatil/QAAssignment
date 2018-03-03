package com.pageobject;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Sleeper;

public class LoginPage {
	WebDriver driver;
	//To locate username field
	@FindBy(name = "user")
	private WebElement txtbxUserName;
	
	//To locate password field
	@FindBy(name = "passwd")
	private WebElement txtbxPassword;
	
	//To locate login button
	@FindBy(xpath = "//div[@class='submit']/button")
	private WebElement bnLogin;
	
	@FindBy(xpath = "//span[@class='user']/a")
	private WebElement linkUserName;

	//to initiate page object factory the code
	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	//Login functionality
	public void Login() throws InterruptedException {
		String userName = "swapnaupatil";
		txtbxUserName.sendKeys(userName);
		txtbxPassword.sendKeys("password");
		bnLogin.click();
		Thread.sleep(1000);
		String expectedUserName = linkUserName.getText();
		assertEquals(userName, expectedUserName );
	}
}
