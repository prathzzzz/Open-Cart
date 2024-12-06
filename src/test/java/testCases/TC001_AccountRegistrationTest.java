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
        logger.info("Starting TC001_AccountRegistrationTest");

        try {
            HomePage homePage = new HomePage(driver);
            homePage.clickMyAccount();
            logger.info("Clicked on MyAccount Link");
            homePage.clickRegister();
            logger.info("Clicked on Register Link");

            // Fill registration form with random data
            logger.info("Providing Customer Details");
            AccountRegistrationPage accountRegistrationPage = new AccountRegistrationPage(driver);
            accountRegistrationPage.setFirstName(generateRandomString());
            accountRegistrationPage.setLastName(generateRandomString());
            accountRegistrationPage.setEmail(generateRandomString() + "@gmail.com");
            accountRegistrationPage.setTelephone(generateRandomNumber());
            accountRegistrationPage.setPassword(generateRandomString() + "@" + generateRandomNumber() + generateRandomString());
            accountRegistrationPage.setPasswordConfirm();

            // Submit registration
            logger.info("Clicked Checkbox");
            accountRegistrationPage.clickCheckboxAgree();
            logger.info("Clicked Continue Button");
            accountRegistrationPage.clickContinueButton();

            // Verify successful registration
            String successfulRegistrationMessage = AccountRegistrationPage.SUCCESSFUL_REGISTRATION_MESSAGE;
            logger.info("Validating Expected Message");
            String actualMessage = accountRegistrationPage.getAccountCreatedMessage();
            logger.info("Actual message: " + actualMessage);
            if(actualMessage.equals(successfulRegistrationMessage)) {
                Assert.assertTrue(true);
            }else {
                logger.error("Test failed: ");
                Assert.fail();
            }
        } catch (Exception e) {
            Assert.fail();
        }
        logger.info("Finished TC001_AccountRegistrationTest");

    }

}
