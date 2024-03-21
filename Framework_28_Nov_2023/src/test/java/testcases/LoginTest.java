package testcases;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import testbase.WebTestBase;

public class LoginTest extends WebTestBase {
    HomePage homePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    LoginTest(){
        super();
    }

    @BeforeMethod
    public void preRequisite(){
        initialization();
        homePage = new HomePage();
        loginPage = new LoginPage();
        myAccountPage = new MyAccountPage();
    }
    @Test (description = "Verify login with valid username & valid password.")
    public void verifyLoginWithValidUserNameAndValidPassword(){
        SoftAssert softAssert = new SoftAssert();
        homePage.closeFirstAd();
        homePage.clickOnLoginAndRegister();
        loginPage.setLogin(prop.getProperty("validUserName"), prop.getProperty("validPassword"));
        softAssert.assertEquals(myAccountPage.getMyAccountElement(), "MY ACCOUNT", "MY ACCOUNT text should be matched.");
        softAssert.assertAll();
    }

    @Test (description = "Verify login with invalid username & valid password.")
    public void verifyLoginWithInvalidUserNameAndValidPassword(){
        SoftAssert softAssert = new SoftAssert();
        homePage.closeFirstAd();
        homePage.clickOnLoginAndRegister();
        loginPage.setLogin(prop.getProperty("invalidUserName"), prop.getProperty("validPassword"));
        softAssert.assertEquals(loginPage.getTextOfErrorMessage(), "ERROR", "ERROR text should be matched.");
        softAssert.assertAll();
    }

    @Test (description = "Verify login with valid username & invalid password.")
    public void verifyLoginWithValidUserNameAndInvalidPassword(){
        SoftAssert softAssert = new SoftAssert();
        homePage.closeFirstAd();
        homePage.clickOnLoginAndRegister();
        loginPage.setLogin(prop.getProperty("validUserName"), prop.getProperty("invalidPassword"));
        softAssert.assertEquals(loginPage.getTextOfErrorMessage(), "ERROR", "ERROR text should be matched.");
        softAssert.assertAll();
    }

    @Test (description = "Verify login with invalid username & invalid password.")
    public void verifyLoginWithInvalidUserNameAndInvalidPassword(){
        SoftAssert softAssert = new SoftAssert();
        homePage.closeFirstAd();
        homePage.clickOnLoginAndRegister();
        loginPage.setLogin(prop.getProperty("invalidUserName"), prop.getProperty("invalidPassword"));
        softAssert.assertEquals(loginPage.getTextOfErrorMessage(), "ERROR", "ERROR text should be matched.");
        softAssert.assertAll();
    }

    @Test (description = "Verify login with blank username & valid password.")
    public void verifyLoginWithBlankUserNameAndValidPassword(){
        SoftAssert softAssert = new SoftAssert();
        homePage.closeFirstAd();
        homePage.clickOnLoginAndRegister();
        loginPage.setLogin(prop.getProperty("blankUserName"), prop.getProperty("validPassword"));
        softAssert.assertEquals(loginPage.getTextOfUsernameRequiredErrorMessage(), "Error:", "Username is required message should be displayed.");
        softAssert.assertAll();
    }

    @Test (description = "Verify login with valid username & blank password.")
    public void verifyLoginWithValidUserNameAndBlankPassword(){
        SoftAssert softAssert = new SoftAssert();
        homePage.closeFirstAd();
        homePage.clickOnLoginAndRegister();
        loginPage.setLogin(prop.getProperty("validUserName"), prop.getProperty("blankPassword"));
        softAssert.assertEquals(loginPage.getTextOfPasswordRequiredErrorMessage(), "Error:", "The password field is empty message should be displayed.");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
