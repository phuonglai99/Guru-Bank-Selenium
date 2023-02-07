package test;

import CommonMethod.AllureReport;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureReport.class})
public class TestSetup extends BaseTest{
    @Test
    void testAllureReport(){
        driver.get("https://www.youtube.com/watch?v=MH0OvhZ4WVs");
        Assert.assertEquals("https://www.youtube.com/watch?v=MH0OvhZ4WV",driver.getCurrentUrl());
    }
}
