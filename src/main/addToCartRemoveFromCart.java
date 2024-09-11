package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class addToCartRemoveFromCart {

    public static void main(String[] args) throws InterruptedException {

        //Name of product going to search
        String search_product = "mi mobile";
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));

        // Open url and add search product
        driver.get("https://amazon.in");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(search_product);
        driver.findElement(By.id("nav-search-submit-button")).click();

        // Get product name of the first product and select it
        String product_name = driver.findElement(By.xpath("//span[@class='a-size-medium a-color-base a-text-normal']")).getText();
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[text()='Add to cart']")).click();

        //Clear the cart.
        Thread.sleep(5000);
        driver.findElement(By.id("nav-cart-count-container")).click();
        WebElement items = driver.findElement(By.xpath("//select[@name='quantity']"));

        //create object
        Select dropdown = new Select(items);
        dropdown.selectByVisibleText("0 (Delete)");

        //Verify cart is empty

       Thread.sleep(1000);

        String Actual_message = driver.findElement(By.xpath("//h2")).getText();
        System.out.println(Actual_message);
        System.out.println((Actual_message.contains("Your Amazon Cart is empty.")) ? "Yes item is removed" : "No, item is not removed");


    }
}


