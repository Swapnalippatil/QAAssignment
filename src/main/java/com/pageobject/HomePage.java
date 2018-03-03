package com.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dataProvider.ConfigFileReader;

public class HomePage {

	WebDriver driver;
	ConfigFileReader configFileReader;

	@FindBy(name = "q")
	private WebElement txtbxSearch;

	@FindBy(xpath = "//input[@type='submit']")
	private WebElement bnSearch;

	@FindBy(xpath = "//a[@href='https://www.reddit.com/r/gaming/']")
	private WebElement linkSubreddit;
	
	@FindBy(xpath = "//div[@class='content']//div[2]//p[1]/a")
	private WebElement linkTopPost;
	
	//to initiate page object factory the code
	public HomePage(WebDriver driver) {
		configFileReader = new ConfigFileReader();
		PageFactory.initElements(driver, this);
	}

	public void navigateTo_HomePage(WebDriver driver) {
		driver.get(configFileReader.getApplicationUrl());
	}

	public void typeSearchItem(String name) {
		txtbxSearch.sendKeys(name);
	}

	public void clickBnSearch() {
		bnSearch.click();
	}

	public void clickLinkSubreddit() {
		linkSubreddit.click();
	}
	
	//This will search the subreddit 'gaming' and print the first post's title.
	public void searchSubReddit() {
		typeSearchItem("gaming");
		clickBnSearch();
		clickLinkSubreddit();
		getTopPostsTitle();
	}
	
	public void getTopPostsTitle() {
		String textOfTopPost = linkTopPost.getText();
		System.out.println("Title of top Most posts : " + textOfTopPost);		
	}

}
