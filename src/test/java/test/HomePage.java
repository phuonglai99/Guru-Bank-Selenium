package test;

import CommonMethod.AllureReport;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureReport.class})
public class HomePage extends BaseTest {

    @Test
    void testClickLogout() {
        login.loginWithAccount("mngr463566", "baterEp");
        //home.clickButtonLogout();
        Assert.assertEquals(home.getEpectedUrl(),home.getCurrentUrl());
        //driver.findElement(By.linkText("New Customer")).click();
    }

}
