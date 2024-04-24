package pages;

import locators.ProductPageConstants;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {

    private WebDriver driver;

    private By productTitle = By.className(ProductPageConstants.PRODUCT_TITLE_CLASSNAME);
    private By addToCartButton = By.cssSelector(ProductPageConstants.ADD_TO_CART_BUTTON_CSS_SELECTOR);


    public ProductPage(WebDriver driver){
        this.driver = driver;
    }


    public String getProductTitle(){
        WebElement productTitleText = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(productTitle));
        return productTitleText.getText();
    }

    public String clickAddToCartButton(){
        WebElement addToCart = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCart.click();

        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent());

        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        alert.accept();

        driver.switchTo().defaultContent();

        return alertText;
    }
}
