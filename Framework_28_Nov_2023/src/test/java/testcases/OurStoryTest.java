package testcases;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;
import testbase.WebTestBase;
import util.WebDriverUtil;

public class OurStoryTest extends WebTestBase {
    HomePage homePage;
    OurStoryPage ourStoryPage;

    OurStoryTest() {
        super();
    }

    @BeforeMethod
    public void preRequisite() {
        initialization();
        homePage = new HomePage();
        ourStoryPage = new OurStoryPage();
    }
    @Test(description = "Verify Our Story dropdown")
    public void verifyOurStoryDropdown(){
        SoftAssert softAssert = new SoftAssert();
        homePage.closeFirstAd();
        ourStoryPage.clickOnOurStory();
        softAssert.assertEquals(ourStoryPage.getHistoryElement(), "OUR HISTORY", "OUR HISTORY text should be matched.");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
