package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

/**
 * Test class for Account Registration functionality
 * Verifies the complete user registration process
 */
public class TC001_AccountRegistrationTest extends BaseClass {
    /**
     * Test method to verify successful account registration
     * Steps:
     * 1. Navigate to registration page
     * 2. Fill in all required fields with random data
     * 3. Accept terms and submit form
     * 4. Verify success message
     */
    @Test
    public void verifyAccountRegistration() {
        // Initialize HomePage and navigate to registration
        HomePage homePage = new HomePage(driver);
        homePage.clickMyAccount();
        homePage.clickRegister();

        // Fill registration form with random data
        AccountRegistrationPage accountRegistrationPage = new AccountRegistrationPage(driver);
        accountRegistrationPage.setFirstName(generateRandomString());
        accountRegistrationPage.setLastName(generateRandomString());
        accountRegistrationPage.setEmail(generateRandomString() + "@gmail.com");
        accountRegistrationPage.setTelephone(generateRandomNumber());
        accountRegistrationPage.setPassword(generateRandomString() + "@" + generateRandomNumber() + generateRandomString());
        accountRegistrationPage.setPasswordConfirm();

        // Submit registration
        accountRegistrationPage.clickCheckboxAgree();
        accountRegistrationPage.clickContinueButton();

        // Verify successful registration
        String successfulRegistrationMessage = AccountRegistrationPage.SUCCESSFUL_REGISTRATION_MESSAGE;
        Assert.assertEquals(accountRegistrationPage.getAccountCreatedMessage(), successfulRegistrationMessage);
    }

}
