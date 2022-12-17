package pom;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BaseClass {
    public WebDriver driver;
    public WebDriverWait wait;
    private static final int duration = 5;

    public BaseClass(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
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

}
