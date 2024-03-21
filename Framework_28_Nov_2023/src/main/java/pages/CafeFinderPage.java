package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testbase.WebTestBase;
import util.WebDriverUtil;
import util.WebElementUtil;

public class CafeFinderPage extends WebTestBase {
    public CafeFinderPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy (xpath = "//a[text()='Café Finder']")
    WebElement cafeFinder;
    public void clickOnCafeFinder(){
        WebDriverUtil.waitElementUntilClickable(cafeFinder);
    }

    @FindBy (xpath = "//h2[text()='VISIT A CAMPOS FLAGSHIP CAFE']")
    WebElement cafeFinderElementText;

    public String getTextOfCafeFinderPage(){
        return WebElementUtil.getTextOfElement(cafeFinderElementText);
    }
}
