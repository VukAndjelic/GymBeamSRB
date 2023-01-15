package tests;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.ProductPage;
import pages.Strings;

import java.util.List;


public class SearchTests {

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
     * 7.Click into search bar in header on main page
     * 8.Enter wanted word "Whey"
     *
     * Expected result:
     *
     * 6. Verify that user is successfully logged in account profile
     * 8. Verify that the user can see the list of products in dropdown
     */

    @Test

    public void SearchByTypingProductName() {
        ChromeDriver driver = openChromeDriver();
        try {

            LoginPage loginPage = new LoginPage(driver);
            loginPage.enterUserNameField(Strings.VALID_USERNAME);
            loginPage.enterPassword(Strings.VALID_PASS);
            loginPage.clickSubmitButton();

            HomePage homePage = new HomePage(driver);
            homePage.setSearchField("whey");

        } finally {
                driver.quit();
        }
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
     * 7.Click on Sportska ishrana in header
     * 8.Click on second item "True Whey"
     *
     * Expected result:
     *
     * 6. Verify that user is successfully logged in account profile
     * 7. Verify that user is guided to list of products on product page
     * 8. Verify that user is guided to the page of chosen product
     */
            @Test

            public void SearchProductFromNavigationMenu(){
                ChromeDriver driver = openChromeDriver();

                try {

                    LoginPage loginPage = new LoginPage(driver);
                    loginPage.enterUserNameField(Strings.VALID_USERNAME);
                    loginPage.enterPassword(Strings.VALID_PASS);
                    loginPage.clickSubmitButton();

                    HomePage homePage = new HomePage(driver);
                    homePage.setProductSportskaIshrana();

                    ProductPage productPage = new ProductPage(driver);
                    productPage.setSubMenuSportskaIshrana();
                    List<WebElement> listOfItems = driver.findElementsByXPath("//div [@id = 'product-item-info_5075']");

                    WebElement secondItem;

                    secondItem = listOfItems.get(0);
                    secondItem.click();

                    assert driver.getCurrentUrl().equals(Strings.TRUE_WHEY): "User in the wrong page.Expected:"+Strings.TRUE_WHEY+" Actual:"+driver.getCurrentUrl();
                }

            finally {
                    driver.quit();
                }
                }

        }

