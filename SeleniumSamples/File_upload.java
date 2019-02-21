//Sample Selenium Webdriver code in Java



import java.util.*;
import java.net.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.LocalFileDetector;
import java.util.concurrent.TimeUnit;
import java.net.URL;

public class File_upload  {
    public static void main(String[] args)  {        
        System.setProperty("webdriver.chrome.driver","./chromedriver");

        DesiredCapabilities capabillities = DesiredCapabilities.chrome();

        String USERNAME = "USERNAME";
        String ACCESS_KEY = "ACCESS_KEY";
        String url =  "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

        URL start_url;
        try {
            start_url = new URL(url);
        } catch(MalformedURLException ex) {
            return; 
        }
        
        //-----------------------------------
        // These are the Remotewebdriver lines
        // Comment them out to run locally
        RemoteWebDriver driver = new RemoteWebDriver(start_url, capabillities);        
        driver.setFileDetector(new LocalFileDetector());
        //------------------------------------
        
        //------------------------------------
        // These are the local webdriver lines
        // Uncomment them to run locally
        //WebDriver driver = new ChromeDriver();
        //driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        //------------------------------------
        
        driver.get("http://xndev.com/display-image/");
     

        WebElement upload = driver.findElement(By.xpath("//*[@id='post-2554']/div/input"));
        
        //In windows the slash below will need to be reversed
        upload.sendKeys(System.getProperty("user.dir") + '/' + "broken_bulb.jpg");


        WebElement img = driver.findElement(By.xpath("//img['data:image/jpeg;base64'=substring(@src,1,22)]"));

        driver.quit();
    }
}
