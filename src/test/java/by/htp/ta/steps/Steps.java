package by.htp.ta.steps;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

import by.htp.ta.driver.DriverSingleton;
import by.htp.ta.pages.LoginPage;
import by.htp.ta.pages.MainPage;

public class Steps {
	
	private WebDriver driver;

	private final Logger logger = LogManager.getRootLogger();

	public void initBrowser() {
		driver = DriverSingleton.getDriver();
	}

	public void closeDriver() {
		DriverSingleton.closeDriver();
	}

	public void login(String username, String password) {
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage();
		loginPage.login(username, password);
	}

	public boolean isLoggedIn(String username) {
		MainPage mainPage = new MainPage(driver);
		String actualUsername = mainPage.getLoggedInUserName().trim().toLowerCase();
		logger.info("Actual username: " + actualUsername);
		return actualUsername.equals(username);
	}
	
	public void checkNewMail(String mailAdress, String textMessage ) {
		MainPage mainPage = new MainPage(driver);
		mainPage.searchUnreadMail(mailAdress);
		mainPage.replyToMail(textMessage);
		logger.info("Answered by email: " + mailAdress);
	}
}