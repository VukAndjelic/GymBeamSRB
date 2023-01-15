package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    //Elements of Home Page

    @FindBy(xpath = "//a [@class = 'logo no-lozad']" )
    WebElement companyLogo;

    @FindBy(xpath = "//span [@class = 'action nav-toggle']")
    WebElement HamburgerMenu;

    @FindBy(xpath = "//a [@href= 'https://gymbeam.rs/catalogsearch/result/?q=whey']")
    WebElement searchButton;

    @FindBy(xpath = "//input [@id = 'search']")
    WebElement searchField;

    @FindBy(xpath = "//li [@class = 'greet welcome user-wrapper']")
    WebElement choseLoginField;

    @FindBy(xpath = "//div [@class = 'field search']")
    WebElement clickLoginField;

    @FindBy(xpath = "//span [@class = 'badge-wrapper']")
    WebElement cartIconLink;

    @FindBy(xpath = "//div [@id = 'widget-homepage-categories']")
    WebElement productNavigationMenu;

    @FindBy(xpath = "//li [@class = 'level0 nav-1 category-item first level-top parent']")
    WebElement productSportskaIshrana;

    @FindBy(xpath = "//div [@id = 'widget-homepage-categories']")
    WebElement clickproductHomeWorkout;

    @FindBy(xpath = "//div [@class = 'product-item-info']")
    WebElement clickShowMoreProducts;


    ChromeDriver driver = null;
    //Constructor
    public HomePage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

        driver.get(Strings.HOME_PAGE);

    }
    //   This method clicks on Profile icon
    public void choseLoginField() {
        choseLoginField.click();
    }
    //   This method clicks on Login Button
    public void clickLoginField() {
        clickLoginField.click();
    }

    //  This method clicks on Cart Icon
    public void setCartIcon() {
        cartIconLink.click();
    }

    // This method clicks on Navigation Menu
    public void setProductNavigationMenu() {
        productNavigationMenu.click();
    }

    // This method clicks on Sportska Ishana in navigation menu
    public void setProductSportskaIshrana() {
        productSportskaIshrana.click();
    }

    // This method clicks on product Home workout
    public void clickproductHomeWorkout() {
        clickproductHomeWorkout.click();
    }

    // This method clicks on Company logo in header
    public void setCompanyLogo() {
        companyLogo.click();
    }

    // This method clicks on search field and enters wanted search word
    public void setSearchField(String product) {
        searchField.click();
        searchField.sendKeys(product);
    }

    // This method clicks on search button in header
    public void setSearchButton() {
        searchButton.click();
    }

    // This method clicks on Show more products at the bottom of the page to show more results
    public void clickShowMoreProducts(){
        clickShowMoreProducts.click();
    }
}
