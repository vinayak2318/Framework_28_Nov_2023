package testcases;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import pages.RegisterPage;
import testbase.WebTestBase;

public class RegisterTest extends WebTestBase {
    HomePage homePage;
    LoginPage loginPage;
    RegisterPage registerPage;
    MyAccountPage myAccountPage;

    RegisterTest() {
        super();
    }

    @BeforeMethod
    public void preRequisite() {
        initialization();
        homePage = new HomePage();
        loginPage = new LoginPage();
        registerPage = new RegisterPage();
        myAccountPage = new MyAccountPage();
    }

    @Test(description = "Verify Click here to register link with valid id & valid password.")
    public void verifyClickHereToRegisterLinkWithValidIdAndValidPassword() {
        SoftAssert softAssert = new SoftAssert();
        homePage.closeFirstAd();
        homePage.clickOnLoginAndRegister();
        loginPage.clickHereToRegisterLink();
        registerPage.setNewRegistration(prop.getProperty("newUserName"), prop.getProperty("newUserPassword"));
        softAssert.assertEquals(myAccountPage.getMyAccountElement(), "MY ACCOUNT", "MY ACCOUNT text should be matched.");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
