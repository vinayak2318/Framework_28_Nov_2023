package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testbase.WebTestBase;
import util.WebDriverUtil;
import util.WebElementUtil;

public class LoginPage extends WebTestBase {
    public LoginPage(){
        PageFactory.initElements(driver, this);
    }
    @FindBy(id = "username")
    WebElement userNameTextBox;

    @FindBy(id = "password")
    WebElement passwordTextBox;

    @FindBy(name = "login")
    WebElement loginBtn;
    public void setLogin(String userName, String password){
        WebElementUtil.sendKeysOnElement(userNameTextBox, userName);
        WebElementUtil.sendKeysOnElement(passwordTextBox, password);
        WebDriverUtil.waitElementUntilClickable(loginBtn);
    }

    @FindBy(xpath = "//strong[text()='ERROR']")
    WebElement errorMessage;
    public String getTextOfErrorMessage(){
        return WebElementUtil.getTextOfElement(errorMessage);
    }


    @FindBy(xpath = "//a[text()='Click here']")
    WebElement registerNewUser;
    public void clickHereToRegisterLink(){
        WebDriverUtil.waitElementUntilClickable(registerNewUser);
    }


    @FindBy(xpath = "//a[text()='Lost your password?']")
    WebElement lostYourPassword;
    public void clickOnLostYourPasswordLink(){
        WebElementUtil.clickOnElement(lostYourPassword);
    }

    @FindBy(xpath = "//strong[text()='Error:']")
    WebElement usernameRequiredErrorMessage;
    public String getTextOfUsernameRequiredErrorMessage(){
        return WebElementUtil.getTextOfElement(usernameRequiredErrorMessage);
    }

    @FindBy(xpath = "//strong[text()='Error:']")
    WebElement passwordRequiredErrorMessage;
    public String getTextOfPasswordRequiredErrorMessage(){
        return WebElementUtil.getTextOfElement(passwordRequiredErrorMessage);
    }
}
