package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import PageObectModel.RegisterPage;

import org.testng.annotations.BeforeClass;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

@Test
public class RegisterTest{
      WebDriver driver;
      RegisterPage registerPage;
       @BeforeClass
       void setup() {
    	   driver = new ChromeDriver();
    	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	   driver.get("https://tutorialsninja.com/demo/");
           driver.manage().window().maximize();
           registerPage = new RegisterPage(driver);
       }
       @Test(priority = 1)
	void testValidInput() {
    	 registerPage.clickRegister();
    	 registerPage.enterRegistrationDetails("aaliya","Khan","nashrah10@gmail.com","6789089345", "password123","password123");
    	  registerPage.selectNewsletter();
    	  registerPage.agreeToTerms();
    	  registerPage.clickContinue();
    	// Assertion to verify successful registration
    	  Assert.assertEquals(driver.getTitle(),"Your Account Has Been Created!");
    	
    	   }
       @Test(priority = 2)
       void testInvalidInputInName() {
    	   registerPage.clickRegister();
    	   registerPage.enterRegistrationDetails("223", "465", "N78@gmail.com", "7865432198","password123", "password123");
    	   registerPage.selectNewsletter();
     	   registerPage.agreeToTerms();
     	   registerPage.clickContinue();
     	  // Assertion to check error message
     	  Assert.assertTrue(registerPage.getErrorMessage().contains("Warning"));
       }
       @AfterClass
       public void teardown() {
           
              driver.quit();
           
       }
       
}
