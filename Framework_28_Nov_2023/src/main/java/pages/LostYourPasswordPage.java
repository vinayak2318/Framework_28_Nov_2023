package pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import testbase.WebTestBase;
import util.WebDriverUtil;
import util.WebElementUtil;

public class LostYourPasswordPage extends WebTestBase {
    public LostYourPasswordPage(){
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "user_login")
    WebElement emailForResetPassword;
    public void setEmailForResetPassword(String resetEmail){
        WebElementUtil.sendKeysOnElement(emailForResetPassword, resetEmail);
    }

    @FindBy(xpath = "//input[@value='Reset password']")
    WebElement resetPasswordBtn;
    public void clickOnResetPasswordBtn(){
        WebDriverUtil.waitElementUntilClickable(resetPasswordBtn);
    }

    @FindBy(xpath = "//h2[text()='Thank you']")
    WebElement resetPasswordMessage;
    public String getTextOfResetPasswordMessage(){
        return WebElementUtil.getTextOfElement(resetPasswordMessage);
    }

    @FindBy(xpath = "//div[@class='wc-block-components-notice-banner__content']")
    WebElement errorMessage;
    //Error msg for keeping the email field blank
    public String getTextOfErrorMessage(){      //Error msg for keeping the email field blank
        return WebElementUtil.getTextOfElement(errorMessage);
    }
}
