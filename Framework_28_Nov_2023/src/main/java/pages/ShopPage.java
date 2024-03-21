package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testbase.WebTestBase;
import util.ActionsUtil;
import util.DropDownUtil;
import util.WebDriverUtil;
import util.WebElementUtil;

public class ShopPage extends WebTestBase {
    public ShopPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a[text()='Shop']")
    WebElement shopLink;

    @FindBy(id = "sort")
    WebElement sortDropDown;

    @FindBy(xpath = "//option[text()='Latest']")
    WebElement selectElement;

    @FindBy(xpath = "//div[text()='Campos Superior Blend']")
    WebElement sampleProduct;

    @FindBy(xpath = "//select[@class='pa_weight']")
    WebElement selectBtn;

    @FindBy(xpath = "//div[text()='Whole Beans']")
    WebElement selectGrind;
    @FindBy(xpath = "//div[text()='Once off']")
    WebElement selectFrequency;

    @FindBy(xpath = "//div[text()=' - Add to cart']")
    WebElement addToCart;
    @FindBy(xpath = "//a[text()='Checkout']")
    WebElement checkOut;
    @FindBy(xpath = "//h3[text()='Your order']")
    WebElement yourOrderPageText;
    @FindBy(xpath = "//a[contains(@class,'filter-bar__inner__section__trigger filter__')]")
    WebElement filtersBtn;
    @FindBy(xpath = "//label[text()='Cup Of Excellence®']")
    WebElement selectFilter;
    @FindBy(xpath = "//a[text()='See 4 results']")
    WebElement seeResult;
    @FindBy(xpath = "//a[text()='Coffee']")
    WebElement shopDropDown;

    public void clickOnFiltersBtn(){
        WebDriverUtil.waitElementUntilClickable(filtersBtn);
        WebDriverUtil.waitElementUntilClickable(selectFilter);
        WebDriverUtil.waitElementUntilClickable(seeResult);
    }

    public void clickOnShopLink(){
        WebDriverUtil.waitElementUntilClickable(shopLink);
    }
    public void sampleProductSelect(){
        WebDriverUtil.waitElementUntilClickable(sampleProduct);
    }
    public void selectWeightFromDropDown(){
        WebDriverUtil.waitElementUntilClickable(selectBtn);
        DropDownUtil.dropDownElement("500g", selectBtn);
    }

    public void ShopProducts(){
        WebDriverUtil.waitElementUntilClickable(selectGrind);
        WebDriverUtil.waitElementUntilClickable(addToCart);
        WebDriverUtil.waitElementUntilClickable(checkOut);
    }
    public String getTextOfYourOrderPage(){
        return WebElementUtil.getTextOfElement(yourOrderPageText);
    }

    public void clickOnDropDown(){
        WebDriverUtil.waitElementUntilClickable(sortDropDown);

    }
    public void selectDropDown(){
        WebDriverUtil.waitElementUntilClickable(sortDropDown);

        DropDownUtil.dropDownElement("Latest" , sortDropDown);


    }
    public void MoveToShopElement(){
        ActionsUtil.moveToElement(shopLink);
    }
    public void clickOnShopDropDown(){
        WebDriverUtil.waitElementUntilClickable(shopDropDown);
    }
    public String getTextOfSelectedElement(){
        return WebElementUtil.getTextOfElement(shopLink);

    }

}
