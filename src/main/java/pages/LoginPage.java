package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

//Elements of LogIn Page

    @FindBy(xpath = "//input [@id = 'email']")
    WebElement userNameField;

    @FindBy(xpath = "//input [@id = 'pass']")
    WebElement passwordField;

    @FindBy(xpath = "//button [@class = 'action login primary']")
    WebElement submitButton;

    @FindBy(xpath = "//li [@data-block = 'user']")
    WebElement loginPageAccountButton;

    @FindBy(xpath = "//li [@class = 'greet welcome user-wrapper']")
    WebElement logoutButton;

    ChromeDriver driver = null;


    //Constructor
    public LoginPage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);


        driver.get(Strings.LOGIN_PAGE);

    }



    //     This method clicks and enter Username
    public void enterUserNameField (String name)
    {
        userNameField.click();
        userNameField.sendKeys(name);
    }
    //      This method clicks and enter password
    public void enterPassword (String password)
    {
        passwordField.click();
        passwordField.sendKeys(password);
    }
    //      This method gets user Logged in
    public void clickSubmitButton () {

        submitButton.click();

    }

    public void setLoginPageAccountButton(){
        loginPageAccountButton.click();
    }
    public void clickLogoutButton () {

        logoutButton.click();


    }

    /**
     * @param name
     * @param password
     */
    public void logInUser(String name, String password){


        enterUserNameField(name);
        enterPassword(password);
        clickSubmitButton();


    }



}
