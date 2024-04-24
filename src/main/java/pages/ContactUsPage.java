package pages;

import locators.ContactUsPageConstants;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ContactUsPage {
    private WebDriver driver;
    private By emailField = By.id(ContactUsPageConstants.EMAIL_FIELD_ID);
    private By nameField = By.id(ContactUsPageConstants.NAME_FIELD_ID);
    private By messageField = By.id(ContactUsPageConstants.MESSAGE_FIELD_ID);
    private By sendButton = By.className(ContactUsPageConstants.SEND_BUTTON_CLASSNAME);


    public ContactUsPage(WebDriver driver){
        this.driver = driver;
    }

    public String fillCredentials(String email, String name, String message){
        WebElement clickEmailField = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(emailField));
        clickEmailField.sendKeys(email);

        WebElement clickNameField = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(nameField));
        clickNameField.sendKeys(name);
        WebElement clickMessageField = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(messageField));
        clickMessageField.sendKeys(message);

        WebElement sendMessageButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(sendButton));
        sendMessageButton.click();

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();

        return alertText;
    }
}
