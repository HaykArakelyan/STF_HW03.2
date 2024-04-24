package pages;

import locators.HomePageConstants;
import locators.MonitorsPageConstant;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {
    private WebDriver driver;
    private final By loginButton = By.id(HomePageConstants.LOGIN_BUTTON_ID);
    private final By contactUsButton = By.xpath(HomePageConstants.CONTACT_BUTTON_XPATH);
    private final By monitorCategoryButton = By.partialLinkText(HomePageConstants.MONITOR_CATEGORY_PARTIAL_LINK_TEXT);
    private By productListContainerId = By.id(HomePageConstants.PRODUCT_LIST_CONTAINER_ID);
    private By productCardContainer = By.cssSelector(HomePageConstants.PRODUCT_CARD_CONTAINER_CSS_SELECTOR);

    public HomePage(WebDriver driver){
        this.driver = driver;
    }


    public int getNumberOfProductFirstPage(){
        WebElement productContainer = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(productListContainerId));


        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(productCardContainer));


//            List<WebElement> innerDivs = productContainer.findElements(productCardContainer);
        List<WebElement> innerDivs = productContainer.findElements(By.className("col-lg-4"));

        return innerDivs.size();
    }

    public LoginPage openLoginFrom(){
        WebElement clickLogInButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(loginButton));
        clickLogInButton.click();
        return new LoginPage(driver);
    }

    public ContactUsPage openContactUsForm(){
        WebElement clickContactUsButton = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(contactUsButton));
        clickContactUsButton.click();

        return new ContactUsPage(driver);
    }

    public MonitorsPage clickMonitorCategory(){
        WebElement monitorCategory = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(monitorCategoryButton));
        monitorCategory.click();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlToBe("https://www.demoblaze.com/#"));

        return new MonitorsPage(driver);
    }

}
