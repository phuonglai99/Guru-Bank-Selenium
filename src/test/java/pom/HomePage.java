package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BaseClass {
    private By mangerId = By.xpath("//*[contains(text(),'Manger Id :')]");
    String url = "";


    public HomePage(WebDriver driver) {
        super(driver);
    }


    public String getMangerID(){
        String text = getText(mangerId);
        //System.out.println("text la "+ text)
        return text;
    }
}
