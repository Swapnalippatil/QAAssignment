package com.pageobject;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubRedditPage {
	WebDriver driver;
	// To locate
	@FindBy(xpath = "//div[@id='thing_t3_7yy2ob']/div[contains(@class,'midcol')]")
	private WebElement voteButtons;

	@FindBy(xpath = "//div[@id='thing_t3_7yy2ob']//data-event-action='downvote'")
	private WebElement bnDownvote;

	@FindBy(xpath = "//div[@id='thing_t3_7yy2ob']//data-event-action='upvote'")
	private WebElement bnUpvote;

	// to initiate page object factory the code
	public SubRedditPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	//This will Downvote the second post if it's upvoted already, upvote otherwise
	public void isVote() {
		
		assertTrue(!voteButtons.isDisplayed() == true, "vote element is not displaying..");
		if (voteButtons.isDisplayed() == true) {
			if (!(voteButtons.getAttribute("class").contains("likes"))) {
				bnDownvote.click();
			}
			else {
				bnUpvote.click();
			}
		}

	}

}
