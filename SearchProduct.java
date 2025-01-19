package PageObectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchProduct {
         WebDriver driver;
         //Locators
        By searchBox = By.xpath("//input[@placeholder='Search']");
        By searchButton = By.xpath("//i[@class='fa fa-search']");
        By productResults = By.xpath("//div[@class='product-thumb']");
        By noResultsMessage = By.xpath("//p[contains(text(),'There is no product that matches the search criteria')]");
        
        public SearchProduct(WebDriver driver) {		
        	this.driver = driver;
        }
        public void searchPro(String productName) {
        	driver.findElement(searchBox).clear();
        	driver.findElement(searchBox).sendKeys(productName);
        	driver.findElement(searchButton).click();
        }
        public boolean isProductDisplayed() {
            List<WebElement> products = driver.findElements(productResults);
            return products.size() > 0;  // If products exist, return true
        }
        public boolean isNoResultsDisplayed() {
            List<WebElement> noResults = driver.findElements(noResultsMessage);
            return noResults.size() > 0;  // If no results message appears, return true
        }
        
        		
}
