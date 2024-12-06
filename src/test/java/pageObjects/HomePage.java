package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import locators.HomePageLocators;

/**
 * Page Object class for Home Page
 * Contains elements and methods specific to the home page
 */
public class HomePage extends BasePage implements interfaces.HomePage {
    
    @FindBy(xpath = HomePageLocators.TopMenu.MY_ACCOUNT_LINK)
    private WebElement lnkMyAccount;

    @FindBy(xpath = HomePageLocators.TopMenu.REGISTER_LINK)
    private WebElement lnkRegister;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void clickMyAccount() {
        clickElement(lnkMyAccount);
    }

    @Override
    public void clickRegister() {
        clickElement(lnkRegister);
    }


}
