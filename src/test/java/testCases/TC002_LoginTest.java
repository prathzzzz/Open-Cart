package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

    @Test
    public void verifyLogin()  {
        logger.info("*****Starting TC002_LoginTest*****");
        LoginPage loginPage = new LoginPage(driver);
        logger.info("Clicked My Account");
        loginPage.clickMyAccount();
        logger.info("Click Login Link");
        loginPage.clickLogin();
        logger.info("Entered Email");
        loginPage.setTxtEmail(properties.getProperty("email"));
        logger.info("Entered Password");
        loginPage.setTxtPassword(properties.getProperty("password"));
        logger.info("Submitted the form");
        loginPage.clickLoginBtn();
        if (loginPage.verifyLogin().equals(LoginPage.SUCCESSFUL_LOGIN_MESSAGE)) {
            Assert.assertTrue(true);
        } else {
            logger.info("Test Failed");
            Assert.fail();
        }
        logger.info("*****Finished TC002_LoginTest*****");
    }
}
