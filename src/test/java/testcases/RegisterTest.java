package testcases;
import base.Baseclass;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.Homepage;
import pages.RegisterPage;
import pages.SucessPage;
import utilities.Utilites_1;

import java.time.Duration;

public class RegisterTest extends Baseclass {
    public RegisterTest(){

        super();
    }
   public RemoteWebDriver driver;
    Homepage homepage;
    RegisterPage registerPage;
    SucessPage ss;

    @BeforeMethod
    public void setup() throws ElementClickInterceptedException, InterruptedException {
        driver= intialzineBrowserandOpenApplication(p.getProperty("browserName"));
        homepage =new Homepage(driver);
        homepage.clickOnmyAccount();
        registerPage= homepage.registerbutton();
    }
    @Test(priority = 1)
    public void verifyRegisteringAnAccountWithMandatoryFields()  {
registerPage. registerAccountWithMandatoryFields(dataprop.getProperty("firstname"),dataprop.getProperty("lastname"),Utilites_1.generateEmailtimestamp(), dataprop.getProperty("telephone"),dataprop.getProperty("input_password"),dataprop.getProperty("input_password"));
        Assert.assertTrue(registerPage.continuebuttonClick().registrationSuccessHeading().contains(dataprop.getProperty("accountSucessfullycreatedHeading")));
    }
    @Test(priority = 2)
    public void verifyRegisterungAnAccountWithAllFields(){
       registerPage. registerwithAccountWithAllFields(dataprop.getProperty("firstname"),dataprop.getProperty("lastname"),Utilites_1.generateEmailtimestamp(),dataprop.getProperty("telephone"),dataprop.getProperty("input_password"),dataprop.getProperty("input_password"));
       Assert.assertTrue(registerPage.continuebuttonClick().registrationSuccessHeading().contains(dataprop.getProperty("accountSucessfullycreatedHeading")));
    }
    @Test(priority = 3)
    public void verifyRegisteringAnAccountByEnteringDifferentPasswordIntoPassswordAndConfirmField(){

        Assert.assertTrue(registerPage.registerwithPassswordAndConfirmFieldsame(dataprop.getProperty("firstname"),dataprop.getProperty("lastname"),Utilites_1.generateEmailtimestamp(),dataprop.getProperty("telephone"),dataprop.getProperty("input_password"),dataprop.getProperty("diffrent_input_password")).contains(dataprop.getProperty("confirmpasswordwarningmessage")));
    }
    @Test(priority = 4)
    public void verifyRegisteringAnAccountByProvidingTheExistingAccountDetails(){
        Assert.assertTrue(registerPage.registerwithProvidingTheExistingAccountDetails(dataprop.getProperty("firstname"),dataprop.getProperty("lastname"),p.getProperty("validEmail"),dataprop.getProperty("telephone"),dataprop.getProperty("input_password"),dataprop.getProperty("input_password")).contains(dataprop.getProperty("duplicateemailwarningmessage")),"Warning message regarding duplicate email not displayed");
    }
    @Test(priority = 5)
    public void verifyRegisteringAccountWithoutFillingDetails(){
        registerPage.continuebuttonClick();
        Assert.assertTrue(registerPage.PrivacyPolicyWarningMessage().contains(dataprop.getProperty("PrivacyPolicyWarningMessage")),"Warning message regarding Privacy policy not displayed");
        Assert.assertEquals(registerPage.FirstnameWarningMessage(),dataprop.getProperty("FirstnameWarningMessage"),"First name warning message not displayed");
        Assert.assertEquals(registerPage.LastnameWarningMessage(),dataprop.getProperty("LastnameWarningMessage"),"Last name warning message not displayed");
        Assert.assertEquals(registerPage.EmailAddressWarningmessage(),dataprop.getProperty("EmailAddressWarningmessage")," E-Mail Address warning message not displayed");
        Assert.assertEquals(registerPage.telephoneWarningMessage(),dataprop.getProperty("telephoneWarningMessage")," Telephone warning message not displayed");
        Assert.assertEquals(registerPage.passwordWarningmessage(),dataprop.getProperty("passwordWarningmessage")," password warning message not displayed");
    }
    @AfterMethod
    public void closeBrowser(){
        driver.close();
    }
}


