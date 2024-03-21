package testcases;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.CafeFinderPage;
import pages.HomePage;
import pages.LoginPage;
import pages.MyAccountPage;
import testbase.WebTestBase;

public class CafeFinderTest extends WebTestBase {
    HomePage homePage;
    LoginPage loginPage;
    MyAccountPage myAccountPage;
    CafeFinderPage cafeFinderPage;
    CafeFinderTest(){
        super();
    }

    @BeforeMethod
    public void preRequisite(){
        initialization();
        homePage = new HomePage();
        loginPage = new LoginPage();
        myAccountPage = new MyAccountPage();
        cafeFinderPage = new CafeFinderPage();
    }
    @Test(description = "Verify Cafe Finder option from the tooltip is clickable or not.")
    public void verify(){
        SoftAssert softAssert = new SoftAssert();
        homePage.closeFirstAd();
        cafeFinderPage.clickOnCafeFinder();
        softAssert.assertTrue(true,"Yes, the Cafe Finder option in tooltip is clickable.");
        softAssert.assertEquals(cafeFinderPage.getTextOfCafeFinderPage(), "VISIT A CAMPOS FLAGSHIP CAFE",
                "VISIT A CAMPOS FLAGSHIP CAFE text should be matched.");
        softAssert.assertAll();
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
