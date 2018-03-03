package com.test.subreddit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.pageobject.HomePage;
import com.pageobject.LoginPage;
import com.pageobject.SubRedditPage;

import dataProvider.ConfigFileReader;
import managers.PageObjectManager;

public class Subreddit_Test {
	public static WebDriver driver;
	HomePage homePage;
	LoginPage loginPage;
	SubRedditPage subRedditPage;
	ConfigFileReader configFileReader;
	PageObjectManager pageObjectManager;
	
	@BeforeTest
	public void open() throws InterruptedException {
		configFileReader= new ConfigFileReader();

		System.setProperty("webdriver.chrome.driver", configFileReader.getDriverPath());
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		pageObjectManager = new PageObjectManager(driver);
		homePage = pageObjectManager.getHomePage();
		homePage.navigateTo_HomePage(driver);		
		Thread.sleep(2000);
	}

	@AfterTest
	public void close() {
		driver.close();
	}

	//Search sureddit gaming
	@Test(priority = 1)
	public void SearchSubreddit(){
		/*homePage.typeSearchItem("gaming");
		homePage.clickBnSearch();
		homePage.clickLinkSubreddit();*/
		homePage.searchSubReddit();
	}
	
	@Test(priority = 2)
	//Login functionality
	public void login() throws InterruptedException {
		loginPage = pageObjectManager.getLoginPage();
		loginPage.Login();
	}
	
	@Test(priority = 3)
	//This will Downvote the second post if it's upvoted already, upvote otherwise
	public void votePost() {
		subRedditPage = pageObjectManager.getSubRedditPage();
		subRedditPage.isVote();
	}
}
