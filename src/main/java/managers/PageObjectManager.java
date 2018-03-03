package managers;

import org.openqa.selenium.WebDriver;

import com.pageobject.HomePage;
import com.pageobject.LoginPage;
import com.pageobject.SubRedditPage;

public class PageObjectManager {
	private WebDriver driver;
	private HomePage homePage;
	private LoginPage loginPage;
	private SubRedditPage subRedditPage;

	// This constructor is asking for parameter of type WebDriver.
	// As to create an object of the Pages, this class requires a driver
	// Now who so ever will create the object of this class needs to provide the
	// driver like :PageObjectManager pageObjectManager = new PageObjectManager(driver);
	public PageObjectManager(WebDriver driver) {
		this.driver = driver;
	}

	//This method has two responsibilities:
	//To create an Object of Page Class only if the object is null.
	//To supply the already created object if it is not null 

	public HomePage getHomePage() {
		return (homePage == null) ? homePage = new HomePage(driver) : homePage;
	}
	
	public LoginPage getLoginPage() {
		return (loginPage == null) ? loginPage = new LoginPage(driver) : loginPage;
	}

	public SubRedditPage getSubRedditPage() {
		return (subRedditPage == null) ? subRedditPage = new SubRedditPage(driver) : subRedditPage;
	}


}
