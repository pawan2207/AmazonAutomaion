package ImpFiles;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;
import java.util.List;

public class Functions {


    public static void searchProductInSearchField(WebDriver driver, String search_string) {

        driver.findElement(By.id("twotabsearchtextbox")).sendKeys(search_string);
        driver.findElement(By.id("nav-search-submit-button")).click();
    }

    public static void applyFilter(WebDriver driver) {

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


    }
}
