package PageObectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CheckOut {
    WebDriver driver;
    public CheckOut(WebDriver driver) {
    	this.driver = driver;
    }
    By checkoutButton = By.xpath("//a[text()='Checkout']");
    By couponopt = By.xpath("//a[normalize-space()='Use Coupon Code']");
    By addcoupon = By.xpath("//input[@id='input-coupon']");
    By applycpn = By.xpath("//input[@id='button-coupon']");
    By estimateShipping = By.xpath("//body/div[@id='checkout-cart']/div[@class='row']/div[@id='content']/div[@id='accordion']/div[2]/div[1]");
    By country = By.xpath("//select[@id='input-country']");
     By state = By.xpath("//select[@id='input-zone']");
     By code = By.xpath("//input[@id='input-postcode']");
     By getquotes = By.xpath("//button[@id='button-quote']");
     By getmessage = By.xpath("//div[@class='alert alert-success alert-dismissible']");
     By outOfStockMessage = By.xpath("//div[contains(text(),'Products marked with *** are not available in the desired quantity or not in stock!')]");
  // Method to check out
     public void proceedToCheckout() {
         driver.findElement(checkoutButton).click();
     }
     public void completeCheckout() {
    	 driver.findElement(couponopt).click();
    	 driver.findElement(addcoupon).sendKeys("qwe3");
    	 driver.findElement(applycpn).click();
    	 driver.findElement(estimateShipping).click();
    	 driver.findElement(country).isSelected();
    	 driver.findElement(state).isSelected();
    	 driver.findElement(code).sendKeys("345tgs");
    	 driver.findElement(getquotes).click();
    	 
     }
     public String getMessage() {
    	 return driver.findElement(getmessage).getText();
     }
     public void selectCountry(String countryName) {
         WebElement dropdown = driver.findElement(country);
         Select select = new Select(dropdown);
         select.selectByVisibleText("India");
     }
     public void selectState(String stateName) {
         WebElement dropdown = driver.findElement(state);
         Select select = new Select(dropdown);
         select.selectByVisibleText(stateName);
     }
     // Method to check if product is out of stock
     public boolean isProductOutOfStock() {
         try {
             return driver.findElement(outOfStockMessage).isDisplayed(); // Check if out-of-stock message is displayed
         } catch (Exception e) {
             return false;  // If exception occurs, meaning message is not found, return false
         }
     }

}
