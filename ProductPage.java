package PageObectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductPage {
      WebDriver driver;
      public ProductPage(WebDriver driver){
  		this.driver = driver;
  	}
     By homepage = By.xpath("//i[@class='fa fa-home']");
     By selectFirstProduct = By.xpath("//div[@id='content']//div[1]//div[1]//div[2]//h4[1]");
     By productTitle = By.xpath("//div[@class='caption']//a[contains(text(),'MacBook')]");
     
   public  void homePage() {
    	 driver.findElement(homepage).click();
     }
     public void selectProduct() {
    	 driver.findElement(selectFirstProduct).click();
     }
     public String getProductTitle() {
         return driver.findElement(productTitle).getText();
     }
}
