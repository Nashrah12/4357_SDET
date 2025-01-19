package PageObectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogIn{
	WebDriver driver;
	//constructor
	 public LogIn(WebDriver driver){
		this.driver = driver;
	}
By myAccount = By.xpath("//span[normalize-space()='My Account']");
   By login = By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']");
   By emailId = By.xpath("//input[@id='input-email']");
   By password = By.xpath("//input[@id='input-password']");
   By loginbtn = By.xpath("//input[@value='Login']");
   By errorMsg = By.xpath("//div[@class='alert alert-danger alert-dismissible']");
  
   public void logIn() {
	   driver.findElement(myAccount).click();
	   driver.findElement(login).click();
   }
   public void setEmailId(String email) {
	   driver.findElement(emailId).sendKeys(email);
   }
   public void setPass(String pass ) {
	   driver.findElement(password).sendKeys(pass);
   }
   public void logInbtn() {
	   driver.findElement(loginbtn).click();
   }
   public String getErrorMessage() {
	   return driver.findElement(errorMsg).getText();
   }
}
