package base;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import utilities.Utilites_1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class Baseclass {

   public RemoteWebDriver driver;

    public Properties p;
    public Properties  dataprop;

       public Baseclass(){
           File f=new File(System.getProperty("user.dir")+"/src/main/java/com/org/myproject/qa/config/config.properties");
               File f1=new File(System.getProperty("user.dir")+"/src/main/java/testdata/testdata.properties");
               try {
                   FileInputStream fis1=new FileInputStream(f1);
                 dataprop=new Properties();
                   dataprop.load(fis1);
               } catch (IOException e1) {
                 e1.printStackTrace();
               }
           try {
               FileInputStream fis=new FileInputStream(f);
               p=new Properties();
               p.load(fis);
           } catch (IOException e) {
               e.printStackTrace();
           }
       }
       public  RemoteWebDriver  intialzineBrowserandOpenApplication(String browserChoice){
        if (browserChoice.equalsIgnoreCase("chrome")) {
           driver = new ChromeDriver();
        } else if (browserChoice.equalsIgnoreCase("firefox")) {
            driver = new FirefoxDriver();
        } else if (browserChoice.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();
        } else {
            System.out.println("Invalid browser choice. Please choose 'chrome', 'firefox', or 'edge'.");
            return  null;
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilites_1.wait_Time));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilites_1.page_Loading_Time));
        driver.get(p.getProperty("url"));
        return driver;
    }

}
