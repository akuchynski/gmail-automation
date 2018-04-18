package by.htp.ta.pages;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage

{
	private final Logger logger = LogManager.getRootLogger();
	private final String BASE_URL = "https://gmail.com/";

	@FindBy(name = "identifier")
	private WebElement inputLogin;
	
	@FindBy(xpath = "//*[@id='identifierNext']/content/span")
	private WebElement buttonNext;

	@FindBy(name = "password")
	private WebElement inputPassword;
	
	@FindBy(xpath = "//*[@id='passwordNext']")
	private WebElement buttonSubmit;
	

	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
		logger.info("Login page opened");
	}

	public void login(String username, String password) {
		inputLogin.sendKeys(username);
		buttonNext.click();
		inputPassword.sendKeys(password);
		buttonSubmit.click();
		logger.info("Login performed");
	}
}
