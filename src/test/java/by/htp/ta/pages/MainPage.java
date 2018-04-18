package by.htp.ta.pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage {
	private final String BASE_URL = "https://gmail.com/";
	
	@FindBy(xpath = "//div[@class='gb_Qc gb_mb gb_Lg gb_R']")
	private WebElement linkUserProfile;

	@FindBy(xpath = "//div[@class='gb_Ib']")
	private WebElement textLoggedUser;
	
	@FindBy(xpath = "//td[@class='gsib_a']/div/input")
	private WebElement textSearchMail;
	
	@FindBy(xpath = "//button[@aria-label='Поиск Gmail']")
	private WebElement buttonSearchMail;
	
	@FindBy(xpath = "//div[@gh='tl']/div/div/table/*/tr/td[6]")
	private WebElement clickOnMail;
	
	@FindBy(xpath = "//div[@class='amn']/span")
	private WebElement linkAnswerToMail;
	
	@FindBy(xpath = "//div[@data-tooltip='Дополнительно']")
	private WebElement clickMenuText;
	
	@FindBy(xpath = "//div[@role='menu'] /div[@class='SK AX']/div[@role='menuitemcheckbox']")
	private WebElement selectPlainText;
	
	
	@FindBy(xpath = "//div[@role='textbox']")
	private WebElement textboxAnswerToMail;
	
	@FindBy(xpath = "//tr[@class='btC']/td/div/div[2]")
	private WebElement buttonSend;
	

	public MainPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public String getLoggedInUserName() {
		linkUserProfile.click();
		System.out.println("LoggedUser" + textLoggedUser.getText());
		return textLoggedUser.getText();
	}
	
	public void searchUnreadMail(String mailAdress){
		textSearchMail.sendKeys("is:unread from:(" + mailAdress + ")");
		buttonSearchMail.click();
		clickOnMail.click();
	}
	
	public void replyToMail(String textMessage) {
		linkAnswerToMail.click();
		clickMenuText.click();
		selectPlainText.click();
		textboxAnswerToMail.sendKeys(textMessage);
		buttonSend.click();
	}

	@Override
	public void openPage() {
		driver.navigate().to(BASE_URL);
	}
}