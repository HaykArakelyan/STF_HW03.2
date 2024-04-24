package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.LoginPage;
import pages.MonitorsPage;
import pages.ProductPage;

public class AllPOMTests extends BaseTest{
    @Test
    public void runAllTest(){
        LoginPage loginPage = homePage.openLoginFrom();
        String message = loginPage.fillInvalidCredentials("aua_sft", "invalidPassword");
        Assert.assertTrue(message.contains("Wrong password"));

        homePage.openLoginFrom();
        String userName = loginPage.fillValidCredentials("aua_sft", "VeryGoodPassword12!");
        Assert.assertTrue(userName.contains("aua_sft"));

        int numberOfElements = homePage.getNumberOfProductFirstPage();
        Assert.assertEquals(numberOfElements, 9);

        MonitorsPage monitorsPage = homePage.clickMonitorCategory();
        String categoryName = monitorsPage.getCategoryName();
        Assert.assertTrue(categoryName.contains("Monitors"));

        homePage.clickMonitorCategory();
        String firstProductName = monitorsPage.getTheNameOfFirstProduct();
        Assert.assertTrue(firstProductName.contains("Apple monitor 24"));

        ProductPage productPage = homePage.clickMonitorCategory().openTheFirstProduct();
        String productTitle = productPage.getProductTitle();
        Assert.assertTrue(productTitle.contains("Apple monitor 24"));

        String addToCardMessage = productPage.clickAddToCartButton();
        Assert.assertTrue(addToCardMessage.contains(("Product added")));

        ContactUsPage contactUsPage = homePage.openContactUsForm();
        String contactMessage = contactUsPage.fillCredentials("abc", "abc", "abc");
        Assert.assertTrue(contactMessage.contains("Thanks for the message"));
    }
}
