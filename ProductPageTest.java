package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObectModel.CartPage;
import PageObectModel.ProductPage;

public class ProductPageTest{
     WebDriver driver;
     ProductPage pp;
     CartPage cp;
     @BeforeClass
     void setup() {
    	 driver = new ChromeDriver();
  	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
  	   driver.get("https://tutorialsninja.com/demo/index.php?route=product/product&product_id=43");
         driver.manage().window().maximize();
         pp = new ProductPage(driver);
         cp = new CartPage(driver);
     }
     @Test(priority = 1)
     void  productSelect() {
    	 pp.homePage();
    	 pp.selectProduct();
    	 String productName = pp.getProductTitle();
    	 System.out.println("Selected Product: " + productName);
         Assert.assertFalse(productName.isEmpty(), "Product title should not be empty!");
         
     }
     @Test
     public void testProductInCart() {
         pp.homePage();
         pp.selectProduct();
         String productName = pp.getProductTitle();

         cp.addToCart();
         Assert.assertTrue(cp.isSuccessMessageDisplayed(), "Success message not displayed!");
         Assert.assertTrue(cp.isProductAddedToCart(), "Cart count did not update!");
         Assert.assertTrue(cp.isProductInCart(productName), "Product is NOT in the cart!");
     }
     @AfterClass
     public void tearDown() {
         driver.quit();
     }
     }

