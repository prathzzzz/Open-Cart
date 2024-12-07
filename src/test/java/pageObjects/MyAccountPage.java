package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import locators.MyAccountPageLocators.*;

public class MyAccountPage extends BasePage implements interfaces.MyAccountPage {
    public static final String SUCCESSFUL_LOGIN_MESSAGE = "My Account";

    @FindBy(xpath = TopMenu.MY_ACCOUNT_LINK)
    private WebElement lnkMyAccount;

    @FindBy(xpath = Dashboard.MY_ACCOUNT_TEXT)
    private WebElement txtMyAccount;

    @FindBy(xpath = Dashboard.LOGOUT)
    private WebElement btnLogout;



    public MyAccountPage(WebDriver driver) {
        super(driver);
    }



    @Override
    public void clickMyAccount() {
        clickElement(lnkMyAccount);
    }

    @Override
    public String getMyAccountText() {
        return getElementText(txtMyAccount);
    }

    @Override
    public void clickLogout() {
        clickElement(btnLogout);
    }
} 