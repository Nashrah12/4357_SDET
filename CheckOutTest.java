package tests;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import PageObectModel.CartPage;
import PageObectModel.CheckOut;
import PageObectModel.LogIn;
import PageObectModel.ProductPage;

public class CheckOutTest {
   WebDriver driver;
   LogIn login;
   ProductPage productpage;
   CartPage cartpage;
   CheckOut checkout;
   @BeforeClass
   void setup() {
	   driver = new ChromeDriver();
  	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  	   driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
         driver.manage().window().maximize();
         
         login = new LogIn(driver);
         productpage = new ProductPage(driver);
         cartpage = new CartPage(driver);
         checkout = new CheckOut(driver);  
   }
   @Test(priority =1)
   public void testLogIn() throws InterruptedException {
	   login.logIn();
	   login.setEmailId("nashrah112001@gmail.com");
	   login.setPass("password123");
	   
	   login.logInbtn();
	   
	   Assert.assertTrue(driver.getPageSource().contains("My Account"), "Login failed!");
	   Thread.sleep(3000);
   }
   @Test(priority =2)
   public void testProductSelection() throws InterruptedException {
	   productpage.homePage();
	   productpage.selectProduct();
	   String productName = productpage.getProductTitle();
  	   System.out.println("Selected Product: " + productName);
  	   Thread.sleep(3000);
       Assert.assertFalse(productName.isEmpty(), "Product title should not be empty!");  
   }
   @Test(priority =3)
   public void testAddToCartAndCheckout() {
	   cartpage.addToCart();
	   cartpage.isProductAddedToCart();
	   checkout.proceedToCheckout();
	   checkout.isProductOutOfStock();
	// Check if the product is out of stock
       if (checkout.isProductOutOfStock()) {
           System.out.println("Error: Product is out of stock!");
           Assert.fail("Product is out of stock, cannot proceed with checkout!");
       } else {
           checkout.completeCheckout();
           checkout.getMessage();
           checkout.selectCountry("India");
           checkout.selectState("Uttar Pradesh");
           String expectedMessage = "Your order has been placed!";
           Assert.assertTrue(driver.getPageSource().contains(expectedMessage), "Order was not placed successfully!");
       }
   }
   @AfterClass
   public void tearDown() {
       driver.quit();
   }
   }

