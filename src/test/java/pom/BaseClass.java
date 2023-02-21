package pom;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BaseClass {
    public WebDriver driver;
    public WebDriverWait wait;
    public  JavascriptExecutor js;
    private static final int duration = 10;

    public BaseClass(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        js = (JavascriptExecutor) driver;
    }
    public void clickOnElement(By by){
        waitVisibilityElement(by).click();
    }

    public void typeText(By by, String text){
        waitVisibilityElement(by).sendKeys(text);
    }

    public String getText(By by){
        return waitVisibilityElement(by).getText();
    }

    public WebElement waitVisibilityElement(By by){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));

    }
    
    public List<WebElement> waitVisibilityElements(By by){
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
    }

    public Alert waitVisibilityAlert(){
        return wait.until(ExpectedConditions.alertIsPresent());
    }
    public void scrollToVisitElement(By by){
        js.executeScript("arguments[0].scrollIntoView();", waitVisibilityElement(by));
    }
    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }
    public boolean waitURLToBe(String url){
        return wait.until(ExpectedConditions.urlToBe(url));
    }
    public String showPopupErrorMsg() {
        waitVisibilityAlert();
        String ret = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        return ret;
    }
    public void closeAd(By iframe,By buttonclose) {
        if (driver.findElements(iframe).size() > 0) {
            System.out.println(driver.switchTo().frame(waitVisibilityElement(iframe)));
            System.out.println("Has a iframe");
            waitVisibilityElement(buttonclose).click();
            driver.switchTo().parentFrame();
        }
        else {
            System.out.println("No ads anymore");
        }
    }

}
