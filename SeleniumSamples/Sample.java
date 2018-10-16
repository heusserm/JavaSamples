//Sample Selenium Webdriver code in Java

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class Sample  {
    public static void main(String[] args) {
        
        //System.setProperty("webdriver.chrome.driver","/opt/local/bin/chromedriver");
        System.setProperty("webdriver.chrome.driver","./chromedriver");

        WebDriver driver = new org.openqa.selenium.chrome.ChromeDriver();

        // And now use this to visit Google
        driver.get("http://www.google.com");

        // Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));

        // Enter something to search for
        element.sendKeys("Cheese!");

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        driver.quit();
    }
}
