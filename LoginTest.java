package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import PageObectModel.LogIn;
@Test
public class LoginTest {
      WebDriver driver;
      LogIn login;
       @BeforeClass
       void setup() {
    	   driver = new ChromeDriver();
    	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	   driver.get("https://tutorialsninja.com/demo/");
           driver.manage().window().maximize();
           login = new LogIn(driver);
       }
       @Test(priority = 1)
	void testValidLogin() {
    	   login.logIn();
    	   login.setEmailId("nashrah10@gmail.com");
    	   login.setPass("password123");
    	   login.logInbtn();
    	// Assertion (Valid Login should not show error)
    	   Assert.assertFalse(login.getErrorMessage().contains("Warning"));
       }
       @Test(priority = 2)
       void testInvalidLogIn() {
    	   login.logIn();
    	   login.setEmailId("nashrah100@gmail.com");
    	   login.setPass("password12");
    	   login.logInbtn();
    	// Assertion (Invalid Login should show error)
    	   Assert.assertTrue(login.getErrorMessage().contains("Warning"));
       }
       @AfterClass
       public void teardown() {
           
              driver.quit();
           
       }
       
}
