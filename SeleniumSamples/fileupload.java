//Sample Selenium Webdriver code in Java


import java.util.*;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;

public class File_upload  {
    public static void main(String[] args) {
        
        //System.setProperty("webdriver.chrome.driver","/opt/local/bin/chromedriver");
        System.setProperty("webdriver.chrome.driver","./chromedriver");



        DesiredCapabilities capabillities = DesiredCapabilities.chrome();
        capabillities.setCapability("version", "7");
        capabillities.setCapability("platform", Platform.getCurrent());
            capabillities.setCapability("selenium-version", "3.141.59");
            capabillities.setCapability("name", "Remote File Upload using Selenium 3's FileDetectors");
        driver = new RemoteWebDriver(
            new URL("http://mheusser:4cc8aa16-d0c6-4f65-b925-d56eea0f3fe4@ondemand.saucelabs.com:80/wd/hub"),
        capabillities);
        driver.setFileDetector(new LocalFileDetector());
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        
        driver.get("https://fineuploader.com/demos.html");
        WebElement upload = driver.findElement(By.name("qqfile"));
        upload.sendKeys("broken_bulb.jpg");
        driver.findElement(By.id("submit")).click();
        WebElement img = driver.findElement(By.xpath("//img[class()='qq-thumbnail-selector']");

        driver.quit();
    }
}
