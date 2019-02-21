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
        //System.setProperty("webdriver.chrome.driver","/opt/local/bin/chromedriver");
        System.setProperty("webdriver.chrome.driver","./chromedriver");

        DesiredCapabilities capabillities = DesiredCapabilities.chrome();
        //capabillities.setCapability("version", "72.0.3626.109");
        //capabillities.setCapability("platform", Platform.WINDOWS);
        //capabillities.setCapability("selenium-version", "3.141.59");
        //capabillities.setCapability("name", "Remote File Upload using Selenium 3's FileDetectors");

        String USERNAME = "YOUR_USERNAME";
        String ACCESS_KEY = "YOUR_ACCESS_KEY";
        String url =  "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.saucelabs.com:443/wd/hub";

        URL start_url;
        try {
            start_url = new URL(url);
        } catch(MalformedURLException ex) {
            return; 
        }
                   
        //RemoteWebDriver driver = new RemoteWebDriver(start_url, capabillities);        
        //driver.setFileDetector(new LocalFileDetector());
        
        
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        

        
        //driver.get("https://codepen.io/mobifreaks/pen/LIbca");
        driver.get("https://jsbin.com/uboqu3/1/edit?html,css,js,console,output");

        //If this gets out of date, try:
        //https://web.archive.org/web/20190126223837/https://fineuploader.com/demos.html
        //
        //The whole thing seems to run in javascript.
        //
        //If The wayback machine gets out of date, then we've got a problem.
        
        WebElement upload = driver.findElement(By.xpath("//input[type()='file']"));
        upload.sendKeys("broken_bulb.jpg");
        //driver.findElement(By.id("submit")).click();
        //upload.click();

        try {
        Thread.sleep(2000);
        } catch (Exception e) {
           return;
        }
        WebElement img = driver.findElement(By.xpath("//img['data:image/jpeg;base64'=substring(@src,1,22)]"));

        driver.quit();
    }
}
