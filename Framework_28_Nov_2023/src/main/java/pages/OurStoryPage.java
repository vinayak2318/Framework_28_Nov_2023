package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testbase.WebTestBase;
import util.ActionsUtil;
import util.DropDownUtil;
import util.WebElementUtil;

import java.util.List;

public class OurStoryPage extends WebTestBase {
    public OurStoryPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='Our Story']")
    WebElement ourStory;
    public void clickOnOurStory(){
        ActionsUtil.moveToElement(ourStory);
        WebElementUtil.clickOnElement(ourStory);
    }

/*    @FindBy(xpath = "//a[text()='Our Story']//following::a[1]")
    WebElement history;*/
/*    public void selectOptionFromOurStory(){
        WebElementUtil.clickOnElement(history);
    }*/

    @FindBy(xpath = "//h1[text()='our history']")
    WebElement ourHistoryText;
    public String getHistoryElement(){
        return WebElementUtil.getTextOfElement(ourHistoryText);
    }
}
