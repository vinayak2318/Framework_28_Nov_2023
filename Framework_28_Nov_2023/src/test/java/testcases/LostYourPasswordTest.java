package testcases;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;
import testbase.WebTestBase;

public class LostYourPasswordTest extends WebTestBase {
    HomePage homePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    LostYourPasswordPage lostYourPasswordPage;
    RegisterPage registerPage;
    LostYourPasswordTest(){
        super();
    }

    @BeforeMethod
    public void preRequisite(){
        initialization();
        homePage = new HomePage();
        loginPage = new LoginPage();
        myAccountPage = new MyAccountPage();
        lostYourPasswordPage = new LostYourPasswordPage();
        registerPage = new RegisterPage();
    }

    @Test(description = "Verify lost your password link with valid email.")
    public void verifyLostYourPasswordLinkWithValidEmail(){
        SoftAssert softAssert = new SoftAssert();
        homePage.closeFirstAd();
        homePage.clickOnLoginAndRegister();
        loginPage.clickOnLostYourPasswordLink();
        lostYourPasswordPage.setEmailForResetPassword(prop.getProperty("resetEmail"));
        lostYourPasswordPage.clickOnResetPasswordBtn();
        softAssert.assertEquals(lostYourPasswordPage.getTextOfResetPasswordMessage(), "THANK YOU", "THANK YOU text should be matched.");
        softAssert.assertAll();
    }

    @Test(description = "Verify lost your password link with keeping the email field blank.")
    public void verifyLostYourPasswordLinkWithKeepingEmailFieldBlank(){
        SoftAssert softAssert = new SoftAssert();
        homePage.closeFirstAd();
        homePage.clickOnLoginAndRegister();
        loginPage.clickOnLostYourPasswordLink();
        lostYourPasswordPage.clickOnResetPasswordBtn();
        softAssert.assertEquals(lostYourPasswordPage.getTextOfErrorMessage(), "Enter a username or email address.", "Enter a username or email address. text should be matched.");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
