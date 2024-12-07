package testCases;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDataDrivenTest extends BaseClass {

    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
    public void verifyLogin(String email, String password, String expected) {
        logger.info("Starting TC003_LoginDataDrivenTest");

        try {
            MyAccountPage myAccountPage = new MyAccountPage(driver);
            LoginPage loginPage = new LoginPage(driver);

            // Navigate to Login Page
            myAccountPage.clickMyAccount();
            loginPage.clickLogin();

            // Enter login credentials
            loginPage.setTxtEmail(email);
            loginPage.setTxtPassword(password);
            loginPage.clickLoginBtn();

            if (expected.equalsIgnoreCase("valid")) {
                handleValidCredentials(myAccountPage);
            } else if (expected.equalsIgnoreCase("invalid")) {
                handleInvalidCredentials(loginPage, myAccountPage);
            }
        } catch (Exception e) {
            logger.error("Test failed with exception: " + e.getMessage());
            Assert.fail("Test encountered an error: " + e.getMessage());
        }

        logger.info("Finished TC003_LoginDataDrivenTest");
    }

    private void handleValidCredentials(MyAccountPage myAccountPage) {
        try {
            String myAccountText = myAccountPage.getMyAccountText();
            Assert.assertEquals(myAccountText, MyAccountPage.SUCCESSFUL_LOGIN_MESSAGE,
                    "Valid credentials login failed");
            logger.info("Login successful for valid credentials");

            // Logout after successful login
            myAccountPage.clickMyAccount();
            myAccountPage.clickLogout();
        } catch (Exception e) {
            logger.error("Login failed for valid credentials: " + e.getMessage());
            Assert.fail("Valid credentials login failed with exception: " + e.getMessage());
        }
    }

    private void handleInvalidCredentials(LoginPage loginPage, MyAccountPage myAccountPage) {
        try {
            String errorMsg = loginPage.getIncorrectCredentialMessage();
            Assert.assertNotNull(errorMsg, "Error message not displayed for invalid credentials");
            logger.info("Login correctly failed for invalid credentials with error: " + errorMsg);
        } catch (Exception e) {
            logger.error("Unexpected state after invalid login attempt: " + e.getMessage());
            Assert.fail("Test encountered unexpected behavior after invalid login");
        }
    }
}
