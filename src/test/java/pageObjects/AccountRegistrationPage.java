package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import locators.AccountRegistrationPageLocators.*;  // Import inner classes

public class AccountRegistrationPage extends BasePage implements interfaces.AccountRegistrationPage {
    
    // Class-level variable to store the password
    private String enteredPassword;
    public static final String SUCCESSFUL_REGISTRATION_MESSAGE = "Your Account Has Been Created!";


    @FindBy(xpath = PersonalDetails.FIRST_NAME_INPUT)
    private WebElement txtFirstName;

    @FindBy(xpath = PersonalDetails.LAST_NAME_INPUT)
    private WebElement txtLastName;

    @FindBy(xpath = PersonalDetails.EMAIL_INPUT)
    private WebElement txtEmail;

    @FindBy(xpath = PersonalDetails.TELEPHONE_INPUT)
    private WebElement txtTelephone;

    @FindBy(xpath = Password.PASSWORD_INPUT)
    private WebElement txtPassword;

    @FindBy(xpath = Password.PASSWORD_CONFIRM_INPUT)
    private WebElement txtPasswordConfirm;

    @FindBy(xpath = Agreement.AGREE_CHECKBOX)
    private WebElement chkBoxAgree;

    @FindBy(xpath = Submit.CONTINUE_BUTTON)
    private WebElement btnContinue;

    @FindBy(xpath = Submit.SUCCESS_MESSAGE)
    private WebElement lblAccountCreatedMessage;

    public AccountRegistrationPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void setFirstName(String firstName) {
        enterText(txtFirstName, firstName);
    }

    @Override
    public void setLastName(String lastName) {
        enterText(txtLastName, lastName);
    }

    @Override
    public void setEmail(String email) {
        enterText(txtEmail, email);
    }

    @Override
    public void setTelephone(String phoneNumber) {
        enterText(txtTelephone, phoneNumber);
    }

    @Override
    public void setPassword(String password) {
        enterText(txtPassword, password);
        this.enteredPassword = password;
    }

    @Override
    public void setPasswordConfirm() {
        enterText(txtPasswordConfirm, enteredPassword);
    }

    @Override
    public void clickCheckboxAgree() {
        clickElement(chkBoxAgree);
    }

    @Override
    public void clickContinueButton() {
        clickElement(btnContinue);
    }

    @Override
    public String getAccountCreatedMessage() {
        try {
            return getElementText(lblAccountCreatedMessage);
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}
