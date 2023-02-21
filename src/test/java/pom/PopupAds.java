package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PopupAds extends BaseClass{
    private By iframe = By.cssSelector("iframe[id^='google_ads_iframe_']");
    private By buttonCloseAd = By.id("dismiss-button");
    private By inputEmail = By.name("emailid");

    public PopupAds(WebDriver driver) {
        super(driver);
    }
    public void closeAds() {
        if (driver.findElements(iframe).size() > 0) {
            System.out.println("Has a iframe");
            driver.switchTo().frame(waitVisibilityElement(iframe));
            System.out.println("Has a iframe");
            waitVisibilityElement(buttonCloseAd).click();
            driver.switchTo().parentFrame();
        }
        else {
            System.out.println("No ads anymore");
        }
    }
}
