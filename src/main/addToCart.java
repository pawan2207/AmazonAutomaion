package main;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

public class addToCart {

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

        //check if item is added in card
        Thread.sleep(5000);
        int count = Integer.parseInt(driver.findElement(By.xpath("//div[@id='nav-cart-count-container']/span[@id='nav-cart-count']")).getText());
        System.out.println(count);
        String cart_item_count = (count > 0) ? "Yes added successfully" : "No item is not added in cart";
        System.out.println(cart_item_count);

        //Match selected product is available in cart or not.

        driver.findElement(By.id("nav-cart-count-container")).click();
        String Cart_Pname = driver.findElement(By.className("a-truncate-cut")).getText();

        System.out.println(product_name);
        System.out.println(Cart_Pname);
        if (Cart_Pname.contains(product_name)) {
            System.out.println("Item added successfully");
        } else {
            System.out.println("Item not found");
        }
        driver.quit();
    }
}


