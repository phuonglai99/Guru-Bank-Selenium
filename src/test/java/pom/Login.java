package pom;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Login extends BaseClass{
    private By userId = By.name("uid");
    private By password = By.name("password");
    private By buttonReset = By.name("btnReset");
    private By buttonLogin = By.name("btnLogin");
    private By linkToSubmitEmailPage = By.linkText("here");
    private String url = "https://www.demo.guru99.com/V4/";
    private String expectUrlLoginSucess = "https://www.demo.guru99.com/V4/manager/Managerhomepage.php";
    private String expectedTextLoginFail = "User or Password is not valid";


    public Login(WebDriver driver) {
        super(driver);
    }

    public void openPage() {
        driver.get(this.url);
    }

    public String getExpectLoginSucess() {
        return expectUrlLoginSucess;
    }

    public String getExpectLoginFail() {
        return expectedTextLoginFail;
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

    @Step("Login with account has username {0} and password is {1}")
    public void loginWithAccount(String username, String pass) {
        openPage();
        clickOnReset();
        fillInFormLogin(username, pass);
        clickOnLogin();
    }
    public void openPageSubmitEmail(){
        scrollToVisitElement(linkToSubmitEmailPage);
        clickOnElement(linkToSubmitEmailPage);
    }

    public void verifyLoginSuccessfully(String mangerId){
        Assert.assertEquals(getCurrentUrl(), expectUrlLoginSucess);
        Assert.assertEquals(new HomePage(driver).getMangerID(), "Manger Id : " + mangerId);
    }

    public void verifyLoginFailed(){
        Assert.assertEquals(showPopupErrorMsg(), expectedTextLoginFail);
    }


}
