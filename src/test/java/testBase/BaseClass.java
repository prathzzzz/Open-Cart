package testBase;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.time.Duration;

/**
 * Base class for all test cases
 * Handles test setup, teardown, and common utilities
 */
public abstract class BaseClass {
    protected WebDriver driver;

    /**
     * Setup method to initialize browser before each test class
     */
    @BeforeClass
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("http://localhost/opencart/upload/");
    }

    /**
     * Teardown method to clean up after each test class
     */
    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    /**
     * Generates a random alphabetic string
     * @return String random 5-character string
     */
    public String generateRandomString() {
        return RandomStringUtils.randomAlphabetic(5);
    }

    /**
     * Generates a random numeric string
     * @return String random 10-digit number
     */
    public String generateRandomNumber() {
        return RandomStringUtils.randomNumeric(10);
    }
}
