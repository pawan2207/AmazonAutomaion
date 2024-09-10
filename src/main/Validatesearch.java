package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Validatesearch {

    public static void main(String[] args) throws InterruptedException {
        String search_product = "android mobile";
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        driver.get("https://amazon.in");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(search_product);
        driver.findElement(By.id("nav-search-submit-button")).click();
        String actual = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']/span[3]")).getText();
        String result = (actual.contains(search_product)) ? "Test case pass" : "Test case fail";
        System.out.println(result);

    }


}
