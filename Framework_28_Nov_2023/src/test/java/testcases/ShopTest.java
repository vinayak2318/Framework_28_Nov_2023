package testcases;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.*;
import testbase.WebTestBase;

public class ShopTest extends WebTestBase {
    HomePage homePage;
    LoginPage loginPage;
    ShopPage shopPage;

    ShopTest(){
        super();
    }
    @BeforeMethod()
    public void preRequisite(){
        initialization();
        homePage=new HomePage();
        loginPage=new LoginPage();
        shopPage=new ShopPage();
    }

    @Test(description = "Verify user is able to select element from dropdown.")
    public void verifyUserIsAbleToSelectElementFromDropDown(){
        SoftAssert softAssert= new SoftAssert();
        homePage.closeFirstAd();
        shopPage.clickOnShopLink();
        homePage.closeFirstAd();
        shopPage.clickOnDropDown();
        softAssert.assertEquals(shopPage.getTextOfSelectedElement(),"SHOP");
        shopPage.selectDropDown();
        softAssert.assertAll();
    }

    @Test(description = "Verify functionality of shop page.")
    public  void verifyShopPage(){
        SoftAssert softAssert=new SoftAssert();
        homePage.closeFirstAd();
        homePage.clickOnLoginAndRegister();
        loginPage.setLogin(prop.getProperty("validUserName"), prop.getProperty("validPassword"));
        shopPage.clickOnShopLink();
        homePage.closeFirstAd();
        shopPage.sampleProductSelect();
        shopPage.selectWeightFromDropDown();
        shopPage.ShopProducts();
        softAssert.assertEquals(shopPage.getTextOfYourOrderPage(),"YOUR ORDER" , "Your Order text should be display");
        softAssert.assertAll();
    }

    @Test(description = "Verify shop link is clickable.")
    public void verifyShopLinkIsClickable(){
        SoftAssert softAssert= new SoftAssert();
        homePage.closeFirstAd();
        shopPage.clickOnShopLink();
        homePage.closeFirstAd();
        shopPage.clickOnDropDown();
        //shopPage.selectElementByVisibleText();
        softAssert.assertEquals(shopPage.getTextOfSelectedElement(),"SHOP");
        softAssert.assertAll();
    }

    @Test(description = "Verify user is able to find a product using filters.")
    public void verifyFiltersButton(){
        SoftAssert softAssert= new SoftAssert();
        homePage.closeFirstAd();
        shopPage.clickOnShopLink();
        homePage.closeFirstAd();
        shopPage.clickOnFiltersBtn();
        softAssert.assertEquals(shopPage.getTextOfSelectedElement(),"SHOP");
        softAssert.assertAll();
    }

    @Test(description = "Verify shop dropdown.")
    public void VerifyShopDropdown(){
        SoftAssert softAssert=new SoftAssert();
        homePage.closeFirstAd();
        shopPage.MoveToShopElement();
        softAssert.assertEquals(shopPage.getTextOfSelectedElement(),"SHOP");
        softAssert.assertAll();
    }

    @Test(description = "Verify user is able select element on shop dropdown.")
    public void selectElementOnShopDropdown(){
        SoftAssert softAssert=new SoftAssert();
        homePage.closeFirstAd();
        shopPage.MoveToShopElement();
        shopPage.clickOnShopDropDown();
        softAssert.assertEquals(shopPage.getTextOfSelectedElement(),"SHOP");
        softAssert.assertAll();
    }

    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}
