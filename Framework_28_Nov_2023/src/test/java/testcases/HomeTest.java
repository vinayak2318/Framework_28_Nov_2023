package testcases;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.HomePage;
import testbase.WebTestBase;

public class HomeTest extends WebTestBase {
    HomePage homePage;

    HomeTest(){
        super();
    }

        @BeforeMethod
        public void preRequisite(){
            initialization();
            homePage = new HomePage();

        }

    @Test(description = "Verify discover page clickable.")
    public void verifyDiscoverPageClickable(){
        SoftAssert softAssert = new SoftAssert();
        homePage.closeFirstAd();
        homePage.discoverElement();
        softAssert.assertEquals(homePage.getDiscoverElementText(), "\"Cup Of Excellence® Month At Campos\"", " TEXT should be matched");
        softAssert.assertAll();
    }

        @AfterMethod
        public void tearDown(){
            driver.close();
        }
    }

