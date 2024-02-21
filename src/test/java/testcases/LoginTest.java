package testcases;

import base.Baseclass;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import pages.AccountPage;
import pages.Homepage;
import pages.LoginPage;
import utilities.Utilites_1;

import java.io.IOException;
import java.time.Duration;

public class LoginTest extends Baseclass{
    public  RemoteWebDriver driver;
    Homepage homepage;
  LoginPage login;
    AccountPage accountPage;

    public LoginTest(){

        super();
    }
    @BeforeMethod
    public void setup() throws ElementClickInterceptedException, IOException, InterruptedException {
        driver= intialzineBrowserandOpenApplication(p.getProperty("browserName"));
        homepage=new Homepage(driver);
       homepage.clickOnmyAccount();
      login= homepage.login();

    }
    @Test(priority = 1)
    public void verifyLoginWithInValidCredentials()  {
        login.login(dataprop.getProperty("invalidEmail"),dataprop.getProperty("invalidPassword"));
        Assert.assertTrue(login.actualwarningmessage().contains(dataprop.getProperty("expectedWariningMessage")));
    }
    @Test(priority = 2)
    public void withoutcredentialslogin(){
    	//updatecommit
        login.loginbutton();
        Assert.assertTrue(login.warningmessageDisplay());
    }
    @Test(priority = 3,dataProvider = "supplydata")
    public void verifyLoginWithValidCredentials(String email,String password){
       login.login(email,password);
        Assert.assertEquals(driver.getTitle(),dataprop.getProperty("MyAccount"));
         accountPage=new AccountPage(driver);
        Assert.assertTrue(accountPage.edityouraccountinformation());
    }
    @Test(priority = 4)
    public void verifyTheValidEmailAddressAndInvaildPassword(){
        login.login(p.getProperty("validEmail"),dataprop.getProperty("invalidPassword"));
        Assert.assertTrue(login.actualwarningmessage().contains(dataprop.getProperty("expectedWariningMessage")));
    }
    @DataProvider
    public Object[][] supplydata() throws IOException {
        Object[][] data=Utilites_1.getTestDataFromExcel("Sheet1");
        return data;
    }
    @Test(priority = 5)
    public void verifyTheInvaildEmailAddressAndValidPassword(){
        login.login(Utilites_1.generateEmailtimestamp(),p.getProperty("validPassword"));
        Assert.assertTrue(login.actualwarningmessage().contains(dataprop.getProperty("expectedWariningMessage")));
    }
    @AfterMethod
    public void  closesite(){
        driver.close();
   }
}
