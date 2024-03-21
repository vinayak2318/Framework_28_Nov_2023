package util;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import testbase.WebTestBase;

public class ActionsUtil extends WebTestBase {
    public static void moveToElement(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
    }
    public static void enterButton(WebElement element){
        Actions actions = new Actions(driver);
        actions.moveToElement(element).sendKeys(Keys.ENTER);
    }
}

