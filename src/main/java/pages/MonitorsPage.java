    package pages;

    import locators.MonitorsPageConstant;
    import org.openqa.selenium.By;
    import org.openqa.selenium.WebDriver;
    import org.openqa.selenium.WebElement;
    import org.openqa.selenium.support.ui.ExpectedConditions;
    import org.openqa.selenium.support.ui.WebDriverWait;

    import java.time.Duration;
    import java.util.List;

    public class MonitorsPage {
        private WebDriver driver;
        private By firstProductName = By.partialLinkText(MonitorsPageConstant.PRODUCT_PARTIAL_LINK_TEXT);
        private By categoryName = By.partialLinkText(MonitorsPageConstant.CATEGORY_LINK_TEXT);

        public MonitorsPage(WebDriver driver){
            this.driver = driver;
        }

        public String getTheNameOfFirstProduct(){
            WebElement firstProduct = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(firstProductName));
            return firstProduct.getText();
        }

        public String getCategoryName(){
            WebElement category = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(categoryName));
            return category.getText();
        }

        public ProductPage openTheFirstProduct(){
            WebElement firstProduct = new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.elementToBeClickable(firstProductName));
            firstProduct.click();
            return new ProductPage(driver);
        }

    }
