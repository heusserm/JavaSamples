//Sample Selenium Webdriver code in Java


import java.util.*;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;

public class Sample  {
    public static void main(String[] args) {
        
        //System.setProperty("webdriver.chrome.driver","/opt/local/bin/chromedriver");
        System.setProperty("webdriver.chrome.driver","./chromedriver");

        WebDriver driver = new org.openqa.selenium.chrome.ChromeDriver();

        // And now use this to visit Google
       driver.get("https://www.google.com/");
       driver.findElement(By.id("gb")).click();
       driver.findElement(By.name("q")).click();
       driver.findElement(By.name("q")).clear();
       driver.findElement(By.name("q")).sendKeys("sauce labs");
       driver.findElement(By.name("q")).sendKeys(Keys.ENTER); 

       ((JavascriptExecutor) driver).executeScript("window.open('https://www.google.com/search?q=Heusser')");
       Set <String> handles = driver.getWindowHandles();
       String firstWindowHandle = driver.getWindowHandle();
       handles.remove(firstWindowHandle);
       driver.switchTo().window(firstWindowHandle);
 

       System.out.println("Page title is: " + driver.getTitle());

       String secondWindowHandle = handles.iterator().next();
       driver.switchTo().window(secondWindowHandle);
       System.out.println("Page title is: " + driver.getTitle());

       driver.quit();
    }
}
