package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import pages.Strings;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ShoppingTests {
    public ChromeDriver openChromeDriver() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximazed");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--incognito");
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        ChromeDriver driver = new ChromeDriver(options);
        return driver;

    }

    /**
     * Login with valid username and password
     *
     * Steps:
     *
     * 1. User navigate to GYMBEAM.RS website
     * 2. Click on profile icon
     * 3.Click on Login field
     * 4.Enter valid username
     * 5.Enter valid pass
     * 6.Click on Login button
     * 7.Click on Company logo
     * 8.Click on "Poceti vezbati od kuce" in the recommended list of products on main page
     * 9.Click on Workout bar in product list
     * 10. Click on ad to cart on product page
     *
     * Expected result:
     *
     * 6. Verify that user is successfully logged in account profile
     * 7. Verify that user is guided to the main page
     * 8. Verify that user is guided to the list of product for "Poceti vezbati od kuce"
     * 9. Verify that product details are shown
     * 10.Verify that one item is shown in cart
     */
    @Test

    public void AddOneItemToCart(){
        ChromeDriver driver = openChromeDriver();

        try {

            LoginPage loginPage = new LoginPage(driver);
            loginPage.enterUserNameField(Strings.VALID_USERNAME);
            loginPage.enterPassword(Strings.VALID_PASS);
            loginPage.clickSubmitButton();

            HomePage homePage = new HomePage(driver);
            homePage.setCompanyLogo();
            driver.findElementByXPath("//img[@data-src='https://gymbeam.rs/media/catalog/category/category-workout_web.png']").click();

            ProductPage productPage = new ProductPage(driver);
            productPage.clickWorkoutBar();
            productPage.clickAddToCartOnProductPage();
            assert driver.getCurrentUrl().equals(Strings.WORKOUT_BAR): "User in the wrong page.Expected:"+Strings.WORKOUT_BAR+" Actual:"+driver.getCurrentUrl();
        }

        finally {
                    driver.quit();
        }
    }
}
