package testcases;

import base.Baseclass;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Homepage;
import pages.LoginPage;
import pages.SearchPage;


public class SearchTest extends Baseclass {
    public SearchTest(){
        super();
    }
   public RemoteWebDriver driver;
    SearchPage searchPage;
    Homepage homepage;
    LoginPage loginPage;

    @BeforeMethod
    public void setup() throws ElementClickInterceptedException, InterruptedException {
        driver=intialzineBrowserandOpenApplication(p.getProperty("browserName"));
        homepage=new Homepage(driver);
    }
    @Test(priority = 1)
    public void verifySearchingWithExistingProductName() {
        homepage.searchproductname(dataprop.getProperty("ExistingProductName"));
        searchPage=homepage.searchbutton();
        Assert.assertTrue(searchPage.Searchedproduct());
    }
    @Test(priority = 2)
    public void verifySearchingWithNonExistingProductName() {
        homepage.searchproductname(dataprop.getProperty("NonExistingProductName"));
       searchPage= homepage.searchbutton();
        Assert.assertEquals(searchPage.noMatchingProductmessage(),dataprop.getProperty("noMatchingmessage"),"no product in search result");
    }
    @Test(priority = 3)
    public void verifySearchingWithEmptyProductName() {
        searchPage= homepage.searchbutton();
        Assert.assertEquals(searchPage.noMatchingProductmessage(),dataprop.getProperty("noMatchingmessage"),"no product in search result");
    }
    @Test(priority = 4 )
    public void verifySearchingWithSpaceProductName() {
     homepage.searchproductname(dataprop.getProperty("SpaceProductName"));
        searchPage= homepage.searchbutton();
        Assert.assertEquals(searchPage.noMatchingProductmessage(),dataprop.getProperty("noMatchingmessage"),"no product in search result");
    }
    @Test(priority = 5)
    public void verifySearchingForProductAfterLoginToApplication() throws InterruptedException {
        homepage.clickOnmyAccount();
        loginPage= homepage.login();
        loginPage.login(p.getProperty("validEmail"),p.getProperty("validPassword"));
        homepage.searchproductname(dataprop.getProperty("ExistingProductName"));
        searchPage= homepage.searchbutton();
      Assert.assertTrue(searchPage.Searchedproduct());
    }
    @AfterMethod
    public void closeBrowser(){
        driver.close();
    }

}
