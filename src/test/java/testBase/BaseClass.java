package testBase;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

/**
 * Base class for all test cases
 * Handles test setup, teardown, and common utilities
 */
public abstract class BaseClass {
    protected WebDriver driver;
    public Logger logger;
    public Properties properties;
    /**
     * Setup method to initialize browser before each test class
     */
    @BeforeClass
    @Parameters({"os","browser"})
    public void setup(String os, String browser) throws IOException {
        FileReader fileReader = new FileReader("./src//test//resources//config.properties");
        properties = new Properties();
        properties.load(fileReader);
        logger = LogManager.getLogger(this.getClass());
        switch (browser.toLowerCase()) {
            case "chrome" : driver = new ChromeDriver(); break;
            case "edge" : driver = new EdgeDriver(); break;
            default :
                System.out.println("Invalid browser name"); return;
        }
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get(properties.getProperty("appURL"));
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
