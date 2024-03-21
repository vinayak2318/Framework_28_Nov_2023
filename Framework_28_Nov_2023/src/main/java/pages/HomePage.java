package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testbase.WebTestBase;
import util.WebDriverUtil;
import util.WebElementUtil;

public class HomePage extends WebTestBase {
    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@class='newsletter__close newsletter__trigger']")
    WebElement closeAd;
    public void closeFirstAd(){
        WebDriverUtil.waitElementUntilClickable(closeAd);
    }


    @FindBy(xpath = "//a[@class='user-controls__ul__li__a']")
    WebElement loginAndRegister;
    public void clickOnLoginAndRegister(){
        WebDriverUtil.waitElementUntilClickable(loginAndRegister);
    }

    @FindBy(xpath = "(//a[text()='DISCOVER MORE'])[2]")
    WebElement discoverBtn;
    public void discoverElement(){
        WebDriverUtil.waitElementUntilClickable(discoverBtn);
    }

    @FindBy(xpath = "//div[@class='article_nav_bar-page_title']")
    WebElement discoverText;
    public String getDiscoverElementText(){
        return  WebElementUtil.getTextOfElement(discoverText);
    }
}
