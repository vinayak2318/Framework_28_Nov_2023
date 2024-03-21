package util;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import testbase.WebTestBase;

public class DropDownUtil extends WebTestBase {
    public static Select select;

    public static void dropDownElement(int index, WebElement element){
        select = new Select(element);
        select.selectByIndex(index);
    }

    public static void dropDownElement(String visibleText, WebElement element){
        select = new Select(element);
        select.selectByVisibleText(visibleText);
    }

    public static void dropDownVisibleText(String visibleWithText, WebElement element){
        select = new Select(element);
        select.selectByVisibleText(visibleWithText);
    }

}
