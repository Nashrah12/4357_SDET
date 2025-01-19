package PageObectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
  WebDriver driver;
By myAccount = By.xpath("//span[normalize-space()='My Account']");
By register = By.xpath("//a[normalize-space()='Register']");
   By firstName = By.xpath("//input[@id='input-firstname']");
   By LastName = By.xpath("//input[@id='input-lastname']");
   By email    =     By.xpath("//input[@id='input-email']");
   By telephone = By.xpath("//input[@id='input-telephone']");
   By password = By.xpath("//input[@id='input-password']");
   By confirmPassword = By.xpath("//input[@id='input-confirm']");
   By LetterBox = By.xpath("//fieldset[2]");
   By AgreeBox = By.xpath("//input[@name='agree']");
   By ClickContinue = By.xpath("//input[@value='Continue']");
   By errorMessage = By.xpath("//div[@class='alert alert-danger alert-dismissible']");
   
	  public  RegisterPage(WebDriver driver){
		   this.driver = driver;
		   //PageFactory.initElements(driver, this);
	   }
	  public void clickRegister() {
		  driver.findElement(myAccount).click();
		  driver.findElement(register).click();
	  }
	  public void enterRegistrationDetails(String Fname, String Lname, String Email, String Tphone, String Pass, String ConfirmPass) {
	        driver.findElement(firstName).sendKeys(Fname);
	        driver.findElement(LastName).sendKeys(Lname);
	        driver.findElement(this.email).sendKeys(Email);
	        driver.findElement(telephone).sendKeys(Tphone);
	        driver.findElement(this.password).sendKeys(Pass);
	        driver.findElement(confirmPassword).sendKeys(ConfirmPass);
	    }
	  public void selectNewsletter() {
		  driver.findElement(LetterBox).click();
	  }
	  public void agreeToTerms() {
		  driver.findElement(AgreeBox).click();
	  }
	  public void clickContinue() {
		  driver.findElement(ClickContinue).click();
	  }
	  public String getErrorMessage() {
		  return driver.findElement(errorMessage).getText();
		  }
}