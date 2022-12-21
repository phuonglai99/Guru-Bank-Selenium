package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ChangePassword extends BaseClass{
    public ChangePassword(WebDriver driver) {
        super(driver);
    }
    private String url = "https://www.demo.guru99.com/V4/manager/PasswordInput.php";
    private By oldPassField = By.name("oldpassword");
    private By newPassField = By.name("newpassword");
    private By confirmPassField = By.name("confirmpassword");
    private By buttonSubmit = By.name("sub");
    private By buttonReset = By.name("res");
private By iframe = By.cssSelector("iframe[id^='google_ads_iframe_']");
    private By buttonCloseAd = By.id("dismiss-button");

    public void submitFormChangePassword(String oldPass,String newPass,String confirmPass){
        closeAd(iframe,buttonCloseAd);
        clickOnElement(buttonReset);
        typeText(oldPassField,oldPass);
        typeText(newPassField,newPass);
        typeText(confirmPassField,confirmPass);
        clickOnElement(buttonSubmit);

    }



}
