package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass {

    @Test
    public void verifyLogin() {
        logger.info("*****Starting TC002_LoginTest*****");
        
        MyAccountPage myAccountPage = new MyAccountPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        
        logger.info("Clicked My Account");
        myAccountPage.clickMyAccount();
        
        logger.info("Click Login Link");
        loginPage.clickLogin();
        
        logger.info("Entered Email");
        loginPage.setTxtEmail(properties.getProperty("email"));
        
        logger.info("Entered Password");
        loginPage.setTxtPassword(properties.getProperty("password"));
        
        logger.info("Submitted the form");
        loginPage.clickLoginBtn();
        
        if (myAccountPage.getMyAccountText().equals(MyAccountPage.SUCCESSFUL_LOGIN_MESSAGE)) {
            Assert.assertTrue(true);
        } else {
            logger.error("Test Failed");
            Assert.fail();
        }
        
        logger.info("*****Finished TC002_LoginTest*****");
    }
}