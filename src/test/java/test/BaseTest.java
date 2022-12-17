package test;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pom.HomePage;
import pom.Login;


public class BaseTest {
    public WebDriver driver;
    public Login login;
    public HomePage home;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void classLevelSetup() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    @BeforeMethod
    void init(){
        login = new Login(driver);
        home = new HomePage(driver);
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }
}
