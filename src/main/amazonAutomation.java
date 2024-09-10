package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class amazonAutomation {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        driver.get("https://amazon.in");
        Actions hover = new Actions(driver);
        WebElement login = driver.findElement(By.xpath("//*[@id='nav-link-accountList']"));
        hover.moveToElement(login).perform();
        driver.findElement(By.xpath("//span[text()='Sign in']")).click();
        driver.findElement(By.xpath("//*[@id='ap_email']")).sendKeys("excellentpawan@gmail.com");
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("ap_password")).sendKeys("Shivansh@123");
        driver.findElement(By.id("signInSubmit")).click();
        String actual = driver.findElement(By.id("nav-link-accountList-nav-line-1")).getText();
        String expected = "Hello, Pawan";
        Assert.assertEquals(actual, expected);
        if (expected.equals(actual)) {
            System.out.println("pass");
        }
        String act_title = driver.getTitle();
        String exp_title = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
        Assert.assertEquals(act_title, exp_title);
        if (act_title.equals(exp_title))
        {
            System.out.println("landed on homepage");
        }
        driver.close();



    }


}
