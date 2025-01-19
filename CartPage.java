package PageObectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
	WebDriver driver;
    public CartPage(WebDriver driver){
		this.driver = driver;
	}
    By addtocart = By.xpath("//button[@id='button-cart']");
    By cartIcon = By.xpath("//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']");
    By gotocart = By.xpath("//a[@title='Shopping Cart']//i[@class='fa fa-shopping-cart']");
    By viewCart = By.xpath("//strong[text()=' View Cart']");
    By successMessage = By.cssSelector(".alert-success");
    By cartProduct = By.xpath("//td[normalize-space()='Product Name']");
    
    public void addToCart() {
    	driver.findElement(addtocart).click();
    }
    public boolean isProductAddedToCart() {
    	return !driver.findElement(cartIcon).getText().equals("0 item(s) - $0.00");
    }
    public boolean isSuccessMessageDisplayed() {
        return driver.findElement(successMessage).getText().contains("Success: You have added ");
    }
    public boolean isProductInCart(String expectedProductName) {
        driver.findElement(cartIcon).click();
        driver.findElement(viewCart).click();
        return driver.findElement(cartProduct).getText().contains(expectedProductName);
    }
}
