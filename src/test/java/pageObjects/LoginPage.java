package pageObjects;

import locators.LoginPageLocators.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage implements interfaces.LoginPage {
    @FindBy(xpath = TopMenu.LOGIN_LINK)
    private WebElement lnkLogin;
    @FindBy(xpath = LoginForm.EMAIL_INPUT)
    private WebElement txtEmail;
    @FindBy(xpath = LoginForm.PASSWORD_INPUT)
    private WebElement txtPassword;
    @FindBy(xpath = LoginForm.LOGIN_BUTTON)
    private WebElement btnLogin;
    @FindBy(xpath = LoginForm.INCORRECT_CREDENTIALS)
    private WebElement lblIncorrectCredentials;

    /**
     * Constructor to initialize WebDriver and wait objects
     *
     * @param driver WebDriver instance to be used
     */
    public LoginPage(WebDriver driver) {
        super(driver);
    }

//    public void clickMyAccount() {
//        clickElement(lnkMyAccount);
//    }

    public void clickLogin() {
        clickElement(lnkLogin);
    }

    public void setTxtEmail(String email) {
        enterText(txtEmail, email);
    }

    public void setTxtPassword(String password) {
        enterText(txtPassword, password);
    }

    public void clickLoginBtn() {
        clickElement(btnLogin);
    }

    @Override
    public String getIncorrectCredentialMessage() {
        return getElementText(lblIncorrectCredentials);
    }
//    public String verifyLogin() {
//        return getElementText(txtVerifyLogin);
//    }
}
