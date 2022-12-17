package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login extends BaseClass{
    private By userId = By.name("uid");
    private By password = By.name("password");
    private By buttonReset = By.name("btnReset");
    private By buttonLogin = By.name("btnLogin");
    private String url = "https://www.demo.guru99.com/V4/";
    private String expectLoginSucess = "https://www.demo.guru99.com/V4/manager/Managerhomepage.php";
    private String expectLoginFail = "User or Password is not valid";


    public Login(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(this.url);
    }

    public String getExpectLoginSucess() {
        return expectLoginSucess;
    }

    public String getExpectLoginFail() {
        return expectLoginFail;
    }

    @Step("Clear old text in textarea")
    public void clickOnReset() {
        clickOnElement(buttonReset);
    }

    @Step("Enter username is {0} and pass is {1} to login form")
    public void fillInFormLogin(String username, String pass) {
        typeText(userId,username);
        typeText(password,pass);
    }

    @Step("Click on button login")
    public void clickOnLogin() {
        clickOnElement(buttonLogin);
    }

    @Step("get current url after login")
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    @Step("Check open popup alert after login with invalid account")
    public String showPopupErrorMsg() {
        waitVisibilityAlert();
        String ret = driver.switchTo().alert().getText();
        driver.switchTo().alert().accept();
        return ret;
    }

    @Step("Login with account has username {0} and password is {1}")
    public void loginWithAccount(String username, String pass) {
        openPage();
        clickOnReset();
        fillInFormLogin(username, pass);
        clickOnLogin();
    }

}
