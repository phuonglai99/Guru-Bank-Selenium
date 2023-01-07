package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BaseClass {
    private By mangerId = By.xpath("//*[contains(text(),'Manger Id :')]");
    private By buttonLogout = By.linkText("Log out");
    private By changePassword = By.linkText("Change Password");
    private String url = "https://www.demo.guru99.com/V4/manager/Logout.php";


    public HomePage(WebDriver driver) {
        super(driver);
    }


    public String getMangerID() {
        String text = getText(mangerId);
        return text;
    }

    public void clickButtonChangePassword() {
        scrollToVisitElement(changePassword);
        clickOnElement(changePassword);
    }

    public String getEpectedUrl() {
        return this.url;
    }

}
