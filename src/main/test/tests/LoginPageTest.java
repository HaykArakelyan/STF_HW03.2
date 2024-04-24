package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginPageTest extends BaseTest {
    @Test
    public void testFailLogIn(){
        LoginPage loginPage = homePage.openLoginFrom();
        String alertMessage = loginPage.fillInvalidCredentials("aua_sft", "invalidPassword");
        Assert.assertTrue(alertMessage.contains("Wrong password"));
    }
    @Test
    public void testSuccessfulLogIn(){
        LoginPage loginPage = homePage.openLoginFrom();
        String nameOfUser = loginPage.fillValidCredentials("aua_sft", "VeryGoodPassword12!");
        Assert.assertTrue(nameOfUser.contains("aua_sft"));
    }
}
