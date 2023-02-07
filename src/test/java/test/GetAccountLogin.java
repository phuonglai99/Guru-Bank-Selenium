package test;

import org.testng.annotations.Test;

public class GetAccountLogin extends BaseTest{
    @Test
    void openPageGetAccount(){
        login.openPage();
        login.openPageSubmitEmail();
        popupAds.closeAds();
        enterYourEmail.submitEmail();
        popupAds.closeAds();
        getAccountLogin.getAccountLogin();
    }
}
