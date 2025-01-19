package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageObectModel.SearchProduct;

@Test
public class SearchTest {
   private WebDriver driver;
   private SearchProduct searchPage;
   @BeforeClass
   void setup() {
	   driver = new ChromeDriver();
	   driver = new ChromeDriver();
	   driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   driver.get("https://tutorialsninja.com/demo/");
       driver.manage().window().maximize();
       searchPage = new SearchProduct(driver);
   }
   public void testProductSearchValid() {
       searchPage.searchPro("Tablets");  // Change to invalid input to test failure case

       if (searchPage.isProductDisplayed()) {
           System.out.println("✅ Product found!");
           Assert.assertTrue(searchPage.isProductDisplayed(), "Product should be displayed.");
       } else if (searchPage.isNoResultsDisplayed()) {
           System.out.println("⚠ No results found!");
           Assert.assertTrue(searchPage.isNoResultsDisplayed(), "There is no product that matches the search criteria.");
       } else {
           System.out.println("❌ Unexpected behavior! Neither product nor error message appeared.");
           Assert.fail("Search behaviour is incorrect.");
       }  
   }
   public void testProductSearchInValid() {
       searchPage.searchPro("@#");  // Change to invalid input to test failure case

       if (searchPage.isProductDisplayed()) {
           System.out.println("✅ Product found!");
           Assert.assertTrue(searchPage.isProductDisplayed(), "Product should be displayed.");
       } else if (searchPage.isNoResultsDisplayed()) {
           System.out.println("⚠ No results found!");
           Assert.assertTrue(searchPage.isNoResultsDisplayed(), "There is no product that matches the search criteria.");
       } else {
           System.out.println("❌ Unexpected behavior! Neither product nor error message appeared.");
           Assert.fail("Search behaviour is incorrect.");
       }  
   }
   @AfterClass
   public void teardown() {
       
          driver.quit();
       
   }

}
