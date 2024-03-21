package testcases;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import testbase.WebTestBase;

public class MyAccountTest extends WebTestBase {
    HomePage homePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;

    MyAccountTest(){
        super();
    }

    @BeforeMethod
    public void preRequisite(){
        initialization();
        homePage = new HomePage();
        loginPage = new LoginPage();
        myAccountPage = new MyAccountPage();
    }

    @Test(description = "Verify the search button on My Account Page.")
    public void verifySearchBtnOnMyAccountPage(){
        SoftAssert softAssert = new SoftAssert();
        homePage.closeFirstAd();
        homePage.clickOnLoginAndRegister();
        loginPage.setLogin(prop.getProperty("validUserName"), prop.getProperty("validPassword"));
        myAccountPage.clickOnSearchBtn();
        myAccountPage.sendTextInSearchTextBox();
        myAccountPage.clickOnSubmitBtn();
        softAssert.assertEquals(myAccountPage.getSearchBtnElement(), "TERMS & CONDITIONS", "TERMS & CONDITIONS text should be matched.");
        softAssert.assertAll();
    }

    @Test(description = "Verify recent order link on My Account page.")
    public void recentOrderFunctionality(){
        SoftAssert softAssert = new SoftAssert();
        homePage.closeFirstAd();
        homePage.clickOnLoginAndRegister();
        loginPage.setLogin(prop.getProperty("validUserName"), prop.getProperty("validPassword"));
        myAccountPage.recentOrdersElement();
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}

