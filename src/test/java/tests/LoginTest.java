package tests;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.Strings;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    public ChromeDriver openChromeDriver () {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximazed");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--incognito");
        options.setExperimentalOption("excludeSwitches",new String[]{"enable-automation"});
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
     *
     * Expected result:
     * 6. Verify that user is successfully logged in account profile
     */

        @Test
    public void LoginWithValidCreds(){
            ChromeDriver driver = openChromeDriver();
            try {

        HomePage homePage = new HomePage(driver);
        homePage.choseLoginField();
        homePage.clickLoginField();

        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterUserNameField(Strings.VALID_USERNAME);
        loginPage.enterPassword(Strings.VALID_PASS);
        loginPage.clickSubmitButton();
        assert driver.getCurrentUrl().equals(Strings.LOGIN_PAGE): "User in the wrong page.Expected:"+Strings.LOGIN_PAGE+" Actual:"+driver.getCurrentUrl();
    } finally {
//                driver.quit();
            }
        }
    /**
     * Login with valid username and invalid password
     *
     * Steps:
     *
     * 1. User navigate to GYMBEAM.RS website
     * 2. Click on profile icon
     * 3.Click on Login field
     * 4.Enter valid username
     * 5.Enter invalid pass
     * 6.Click on Login button
     *
     * Expected result:
     * 6. Verify that user is not logged in account profile and remains on account page
     */

        @Test

    public void LogInWithInvalidPass ()  {
            ChromeDriver driver = openChromeDriver();
            try {
                HomePage homePage = new HomePage(driver);
                homePage.choseLoginField();
                homePage.clickLoginField();

                LoginPage loginPage = new LoginPage(driver);
                loginPage.enterUserNameField("andjelic.vuk96@gmail.com");
                loginPage.enterPassword(Strings.INVALID_PASS);
                loginPage.clickSubmitButton();
                assert driver.getCurrentUrl().equals(Strings.LOGIN_PAGE): "User in the wrong page.Expected:"+Strings.LOGIN_PAGE+" Actual:"+driver.getCurrentUrl();

            } finally {
//                driver.quit();
            }
        }






    }




