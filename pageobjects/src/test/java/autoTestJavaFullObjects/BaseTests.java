package autoTestJavaFullObjects;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by mrozp on 2017-05-31.
 */
public abstract class BaseTests {

    private final String GECKO_DRIVER_NAME = "webdriver.gecko.driver";
    private final String GECKO_DRIVER_PATH = "C:\\bin\\geckodriver.exe";
    private final String CHROME_DRIVER_NAME = "webdriver.chrome.driver";
    private final String CHROME_DRIVER_PATH = "C:\\bin\\chromedriver.exe";
    private final String BROWSER = "Firefox";
    protected WebDriver driver;

    @Before
    public void TestSetup() {
        if(BROWSER=="Firefox"){
            System.setProperty(GECKO_DRIVER_NAME, GECKO_DRIVER_PATH);
            driver = new FirefoxDriver();
        }
        if(BROWSER=="Chrome"){
            System.setProperty(CHROME_DRIVER_NAME, CHROME_DRIVER_PATH);
            driver = new ChromeDriver();
        }
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @After
    public void TestTeardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected String generateRandomText() {
        String text = "";
        for (int i=0; i<5; i++) {
            text = UUID.randomUUID().toString() + " " + text;
        }
        return text.trim();
    }

}
