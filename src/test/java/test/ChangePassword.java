package test;

import CommonMethod.AllureReport;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
@Listeners({AllureReport.class})
public class ChangePassword extends BaseTest{

    @Test
    void changePasswordFailedWithIncorrectOldPass(){
        login.loginWithAccount("mngr463566", "baterEp");
        home.clickButtonChangePassword();
        changePass.submitFormChangePassword("123456","@123456","@123456");
        Assert.assertEquals(changePass.showPopupErrorMsg(),"Old Password is incorrect");
    }
    @Test
    void changePasswordFailedWithNoMatchConfirmPass(){

    }

    @Test
    void changePasswordSuccessWithValidField(){
        login.loginWithAccount("mngr463566", "123456@");
        home.clickButtonChangePassword();
        changePass.submitFormChangePassword("123456@","123456@","123456@");
        changePass.verifyChangePassSuccess();
        login.loginWithAccount("mngr463566","123456@");
        login.verifyLoginSuccessfully("mngr463566");
    }

}
