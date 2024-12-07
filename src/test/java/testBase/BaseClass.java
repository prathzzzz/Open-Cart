package testBase;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

/**
 * Base class for all test cases
 * Handles test setup, teardown, and common utilities
 */
public class BaseClass {
    protected static WebDriver driver;
    public Logger logger;
    public Properties properties;
    protected ChromeOptions chromeOptions;
    protected EdgeOptions edgeOptions;

    /**
     * Setup method to initialize browser before each test class
     */
    @BeforeClass
    @Parameters({"os", "browser", "headless"})
    public void setup(String os, String browser, String headless) throws IOException {
        FileReader fileReader = new FileReader("./src//test//resources//config.properties");
        properties = new Properties();
        properties.load(fileReader);
        logger = LogManager.getLogger(this.getClass());
        switch (browser.toLowerCase()) {
            case "chrome":
                chromeOptions = new ChromeOptions();
                if (headless.equalsIgnoreCase("headless")) {
                    chromeOptions.addArguments("--headless");
                }
                driver = new ChromeDriver(chromeOptions);
                break;

            case "edge":
                edgeOptions = new EdgeOptions();
                if (headless.equalsIgnoreCase("headless")) {
                    edgeOptions.addArguments("--headless");
                }
                driver = new EdgeDriver(edgeOptions);
                break;

            default:
                System.out.println("Invalid browser name");
                return;
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
     *
     * @return String random 5-character string
     */
    public String generateRandomString() {
        return RandomStringUtils.randomAlphabetic(5);
    }

    /**
     * Generates a random numeric string
     *
     * @return String random 10-digit number
     */
    public String generateRandomNumber() {
        return RandomStringUtils.randomNumeric(10);
    }
    public String captureScreen(String tname) throws IOException {

        String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());

        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);

        String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
        File targetFile=new File(targetFilePath);

        sourceFile.renameTo(targetFile);

        return targetFilePath;

    }
}
