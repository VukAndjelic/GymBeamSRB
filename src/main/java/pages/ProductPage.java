package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage{

    //Elements of product page
    @FindBy(xpath = "//a [@class = 'level-top']")
    WebElement subMenuSportskaIshrana;

    @FindBy(xpath = "//ul [@class = 'level1 submenu']")
    WebElement productProteini;

    @FindBy(xpath = "//svg [@class = 'gymtheme-icon']")
    WebElement clickIncrease;

    @FindBy(xpath = "//ul [@class = 'level0 submenu']//li [@class = 'level1 nav-1-1 category-item first parent'] ")
    WebElement subMenuZdravaHrana;

    @FindBy(xpath = "//div [@class = 'field configurable required']")
    WebElement clickProductSize;

    @FindBy(xpath = "//div [@id = 'product-item-info_35686']")
    WebElement clickWorkoutBar;


    @FindBy(xpath = "//button [@class = 'action primary tocart']")
    WebElement clickAddToCartOnProductPage;


    ChromeDriver driver = null;


    public ProductPage(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);}

    // This method clicks on Sportska ishana in submenu
    public void setSubMenuSportskaIshrana(){
        subMenuSportskaIshrana.click();
    }

    // This method clicks on Proteini in submenu
    public void setProductProteini(){
        productProteini.click();
    }

    // This method clicks on increase(+) on product to increase quantity
    public void clickIncrease(){
        clickIncrease.click();
    }

    // This method clicks on Zdrava hrana in submenu
    public void clickSubMenuZdravaHrana(){
        subMenuZdravaHrana.click();
    }

    // This method clicks to select which size of product to select
    public void clickProductSize(){
        clickProductSize.click();
    }

    // This method clicks on Add to cart on product page
    public void clickAddToCartOnProductPage(){
        clickAddToCartOnProductPage.click();
    }

    // This method clicks on Workout bar from product page
    public void clickWorkoutBar() {
        clickWorkoutBar.click();
    }

}