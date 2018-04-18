package by.htp.ta;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import by.htp.ta.steps.Steps;

public class GmailAutomationTest
{
	private Steps steps;
	private final String LOGIN = "name1@gmail.com";
	private final String LOGIN_FOR_REPLY = "name2@yandex.ru";
	private final String PASSWORD = "yourpassword";
	private final String TEXT_MESSAGE = "Hello from Selenium WebDriver!";

	@BeforeMethod(description = "Init browser")
	public void setUp() {
		steps = new Steps();
		steps.initBrowser();
	}
	
	@Test(description = "Check new unread mail")
	public void checkMail() {
		steps.login(LOGIN, PASSWORD);
		steps.checkNewMail(LOGIN_FOR_REPLY, TEXT_MESSAGE);
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser() {
		steps.closeDriver();
	}
}
