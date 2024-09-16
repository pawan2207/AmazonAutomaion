package main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import static ImpFiles.Functions.applyFilter;
import static ImpFiles.Functions.searchProductInSearchField;

public class TestWithFunctions {
    public static void main(String[] args) {
        String search_product = "mi mobile";
        System.setProperty("webdriver.edge.driver", "C:\\Windows\\System32\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.get("https://amazon.in");
        searchProductInSearchField(driver, search_product);
        applyFilter(driver);


    }
}
