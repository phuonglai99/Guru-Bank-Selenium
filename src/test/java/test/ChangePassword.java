package test;

import CommonMethod.AllureReport;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners({AllureReport.class})
public class ChangePassword extends BaseTest{
    @Test
    void changePasswordWithIncorrectOldPass(){
        login.loginWithAccount("mngr463566", "baterEp");
        home.clickButtonChangePassword();
        changePass.submitFormChangePassword("123456","@123456","@123456");
        Assert.assertEquals(changePass.showPopupErrorMsg(),"Old Password is incorrect");
    }
}
