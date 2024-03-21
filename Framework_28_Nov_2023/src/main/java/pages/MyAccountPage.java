package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testbase.WebTestBase;
import util.WebDriverUtil;
import util.WebElementUtil;

public class MyAccountPage extends WebTestBase {
    public MyAccountPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//h2[text()='My Account']")
    WebElement myAccountElement;
    public String getMyAccountElement(){
        return WebElementUtil.getTextOfElement(myAccountElement);
    }

    @FindBy(xpath = "//input[@id='s']")
    WebElement searchBtn;
    public void clickOnSearchBtn() {
        WebDriverUtil.waitElementUntilClickable(searchBtn);
    }

    @FindBy(xpath = "//input[@id='searchsubmit']")
    WebElement submitSearchText;
    public void clickOnSubmitBtn() {
        WebDriverUtil.waitElementUntilClickable(submitSearchText);
    }

    @FindBy(xpath = "//h4[text()='Terms & Conditions']")
    WebElement afterSearchElement;
    public String getSearchBtnElement(){
        return WebElementUtil.getTextOfElement(afterSearchElement);
    }
    public void sendTextInSearchTextBox(){
        WebElementUtil.sendKeysOnElement(searchBtn, "Coffee");
    }

    @FindBy(xpath = "//a[text()='recent orders']")
    WebElement recentOrderBtn;
    public void recentOrdersElement(){
        WebDriverUtil.waitElementUntilClickable(recentOrderBtn);
    }
}


