package pages;

import locators.LogInPageConstants;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private final By usernameField = By.id(LogInPageConstants.USERNAME_FIELD_ID);
    private final By passwordField = By.id(LogInPageConstants.PASSWORD_FIELD_ID);
    private final By logInButton = By.xpath(LogInPageConstants.SIGN_IN_BUTTON_XPATH);
    private final By closeButton = By.xpath(LogInPageConstants.CLOSE_BUTTON_XPATH);
    private final By nameOfUser = By.id(LogInPageConstants.NAME_OF_USER_ID);

    private final By loginModal = By.id(LogInPageConstants.LOGIN_MODAL_ID);
    public LoginPage(WebDriver driver){
        this.driver = driver;
    }


    public String fillInvalidCredentials(String username, String password){
        WebElement clickUserNameField = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(usernameField));
        clickUserNameField.sendKeys(username);

        WebElement clickPasswordField = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(passwordField));
        clickPasswordField.sendKeys(password);

        WebElement clickLogInButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(logInButton));
        clickLogInButton.click();


        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();

        WebElement modal = driver.findElement(loginModal);

        WebElement clickCloseButton = modal.findElement(By.className("btn-secondary"));

        clickCloseButton.click();

        return alertText;
    }

    public String fillValidCredentials(String username, String password){
        WebElement clickUserNameField = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(usernameField));
        clickUserNameField.clear();
        clickUserNameField.sendKeys(username);

        WebElement clickPasswordField = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(passwordField));
        clickPasswordField.clear();
        clickPasswordField.sendKeys(password);

        WebElement clickLogInButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(logInButton));
        clickLogInButton.click();

        WebElement nameOfUserText = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(nameOfUser));

        return nameOfUserText.getText();
    }


}
