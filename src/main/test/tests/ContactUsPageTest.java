package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;

public class ContactUsPageTest extends BaseTest{

    @Test
    public void testSendContactUsMessage(){
        ContactUsPage contactUsPage = homePage.openContactUsForm();
        String message = contactUsPage.fillCredentials("abc", "abc", "abc");
        Assert.assertTrue(message.contains("Thanks for the message"));
    }
}
