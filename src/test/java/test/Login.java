package test;

import CommonMethod.AllureReport;
import CommonMethod.ReadDataExcel;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import java.io.IOException;

import static CommonMethod.ReadDataExcel.FILE_PATH;
import static CommonMethod.ReadDataExcel.SHEET_NAME;

@Listeners({AllureReport.class})

public class Login extends BaseTest{

    @DataProvider(name = "invalid_data_login")
    public Object[][] dataInvalid() throws IOException {
        return ReadDataExcel.readData(FILE_PATH, SHEET_NAME);
    }

    @DataProvider(name = "valid_data_login")
    public Object[][] dataValid() {
        Object data[][] = new Object[][]{{"mngr463566", "123456@", "mngr463566"}};
        return data;
    }

    @Test(dataProvider = "valid_data_login", description = "Login with valid account")
    @Description("Login with valid account")
    @Severity(SeverityLevel.BLOCKER)
    void loginWithValidAccount(String username, String pass, String mangerId) throws IOException {
        login.loginWithAccount(username, pass);
        login.verifyLoginSuccessfully(mangerId);
    }
    @Test(dataProvider = "invalid_data_login")
    void loginWithInvalidAcount(String username, String pass) throws IOException {
        login.openPage();
        login.clickOnReset();
        login.fillInFormLogin(username, pass);
        login.clickOnLogin();
        login.verifyLoginFailed();
    }

    @Test
    void testAllureReport(){
        driver.get("https://www.youtube.com/watch?v=MH0OvhZ4WVs");
        Assert.assertEquals("tesst",driver.getCurrentUrl());
    }

}
