package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testbase.WebTestBase;
import util.WebDriverUtil;
import util.WebElementUtil;

public class RegisterPage extends WebTestBase {
    public RegisterPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "reg_email")
    WebElement newUserEmailTextBox;

    @FindBy(id= "reg_password")
    WebElement newUserPasswordTextBox;

    @FindBy(xpath = "//input[@value='Register']")
    WebElement registerBtn;


    public void setNewRegistration(String newUserName, String newUserPassword){
        WebElementUtil.sendKeysOnElement(newUserEmailTextBox, newUserName);
        WebElementUtil.sendKeysOnElement(newUserPasswordTextBox, newUserPassword);
        WebDriverUtil.waitElementUntilClickable(registerBtn);
    }
}
