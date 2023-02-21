package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class EnterYourEmail extends BaseClass{
    private By inputEmail = By.name("emailid");
    private By buttonSubmit = By.name("btnLogin");
    private String email = "plai34037@gmail.com";
    public EnterYourEmail(WebDriver driver) {
        super(driver);
    }
    public void submitEmail(){

        String oldtext = driver.findElement(inputEmail).getText();
        System.out.println(oldtext);
        typeText(inputEmail,email);
        clickOnElement(buttonSubmit);
    }
}
