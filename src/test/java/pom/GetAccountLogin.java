package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class GetAccountLogin extends BaseClass{
    By accountLogin = By.xpath("//*[@class='accpage']//following-sibling::td");
    public GetAccountLogin(WebDriver driver) {
        super(driver);
    }
    public String getAccountLogin(){
        List<WebElement> account = waitVisibilityElements(accountLogin);
        String acc = "";
        for (WebElement webElement : account) {
            acc = acc + webElement.getText()+" ";
        }
        System.out.println("in ra ten ne"+acc);
        return acc;
    }
}
