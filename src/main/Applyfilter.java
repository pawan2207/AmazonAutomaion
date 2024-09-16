package main;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class Applyfilter {
    @Test
  public void Applyfilter(){

        //  public static void main(String[] args) {
        // Initialize WebDriver
        System.setProperty("webdriver.edge.driver", "C:\\Windows\\System32\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // Open URL and search for product
        String searchProduct = "android mobile";
        driver.get("https://amazon.in");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(searchProduct);
        driver.findElement(By.id("nav-search-submit-button")).click();

        try {
            // Define the brands you want to select
            String[] brandsToSelect = {"POCO"}; // Example brands

            for (String brand : brandsToSelect) {
                try {
                    // Locate and select the brand checkbox using XPath
                    String checkboxXPath = String.format("//li[@aria-label='%s']//input[@type='checkbox']", brand);
                    List<WebElement> checkboxes = driver.findElements(By.xpath(checkboxXPath));

                    // Click the checkbox if it exists
                    for (WebElement checkbox : checkboxes) {
                        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
                    }
                } catch (Exception e) {
                    System.out.println("Could not find or select the checkbox for " + brand + ": " + e.getMessage());
                }
            }

            // Get all product names after filtering
            List<WebElement> filteredProducts = driver.findElements(By.xpath("//h2[@class='a-size-mini a-spacing-none a-color-base s-line-clamp-2']/a/span"));
            System.out.println("Filtered products count: " + filteredProducts.size());

            // Validate each product's name against the selected brands
            for (WebElement product : filteredProducts) {
                String productName = product.getText();

                // Check if the product name contains any selected brand
                for (String brand : brandsToSelect) {
                    if (productName.contains(brand)) {
                        System.out.println(String.format("Product: %s | Brand: %s | Status: Pass", productName, brand));
                    } else {
                        System.out.println(String.format("Product: %s | Brand: %s | Status: Fail", productName, brand));
                    }
                }
            }
        } finally {
            // Close the browser
            driver.quit();
        }
    }
//}

}


