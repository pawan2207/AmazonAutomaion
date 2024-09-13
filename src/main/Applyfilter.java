package main;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;

import java.time.Duration;
import java.util.List;

public class Applyfilter {

    public static void main(String[] args) throws InterruptedException {
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
                      // Wait for the page to load
            driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(20));

            // Define the brands you want to select
            String[] brandsToSelect = {"POCO"}; // Example brands

            for (String brand : brandsToSelect) {
                try {
                    // Locate the checkbox element for the given brand
                    String checkboxXPath = String.format("//li[@aria-label='%s']//input[@type='checkbox']", brand);
                    System.out.println(checkboxXPath);
                    List<WebElement> checkboxes = driver.findElements(By.xpath(checkboxXPath));

                    // Click the checkbox if it is not already selected
                    for (WebElement checkbox : checkboxes) {
                        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkbox);
                    }
                } catch (Exception e) {
                    System.out.println("Could not find or select the checkbox for " + brand + ": " + e.getMessage());
                }
            }
            //get all product names after filter





        } finally {
            // Close the browser

        }
    }
}








