import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import test.data.Constants;

public class End2EndTest {

    // Adauga 4 produse din departamente diferite in cos

    @Test(
            testName = "TC01 - Add 4 products from 4 different departments into the cart",
            description =
                    """
                    Step 1: User navigates to Magento homepage
                    Step 2: User click on Women button
                    Step 3: User click on Hoodies & Sweatshirts button
                    Step 4: User scroll down and click on a product from the list and add the first product to the cart
                    Step 5: User select the size and quantity
                    Step 6: User click on Add to Cart button
                    
                    Step 4: User navigates to Magento homepage
                    Step 5: User click on Men button
                    Step 6: User click on Taurus Elements Shell button
                    Step 7: User click on a product from the list and add the second product to the cart
                    Step 8: User select the size and quantity
                    Step 9: User click on Add to Cart button
                    
                    Step 10: User navigates to Magento homepage
                    Step 11: User click on Gear button
                    Step 12: User click on Watches button
                    Step 13: User click on a product from the list and add the third product to the cart
                    Step 14: User select the size and quantity
                    Step 15: User click on Add to Cart button
                    
                    Step 16: User navigates to Magento homepage
                    Step 17: User click on Sale button
                    Step 18: User click on Bras & Tanks button
                    Step 19: User click on a product from the list and add the forth product to the cart
                    Step 20: User select the size and quantity
                    Step 21: User click on Add to Cart button
                    
                    Step 22: User click on Show Cart button
                    Step 23: User click on Proceed to Checkout button
                    """
    )
    public void add5DifferentProductToCartTest() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get(Constants.BASE_URL);
        driver.manage().window().maximize();
    // First Product
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#ui-id-4")).click();
        driver.findElement(By.xpath("//a[contains(text(), 'Hoodies & Sweatshirts')]")).click();
        driver.findElement(By.xpath("//a[contains(text(), 'Cassia Funnel Sweatshirt')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@class='swatch-option text']")).click();
        driver.findElement(By.xpath("//div[@class='swatch-option color']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='product-addtocart-button']")).click();
    // Second Product
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#ui-id-5")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(text(), 'Jackets')]")).click();
        driver.findElement(By.xpath("//a[contains(text(), 'Taurus Elements Shell')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#option-label-size-143-item-166")).click();
        Thread.sleep(2000);
        driver.findElement((By.cssSelector("#option-label-color-93-item-60"))).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#product-addtocart-button")).click();
    // Third Product
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(text(), 'Gear')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(text(), 'Watches')]")).click();
        driver.findElement(By.xpath("//a[contains(text(), 'Summit Watch')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(text(), 'Add to Cart')]")).click();
    //Forth Product
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#ui-id-8")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[contains(text(), 'Bras & Tanks')]")).click();
        driver.findElement(By.xpath("//a[contains(text(), 'Breathe-Easy Tank')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#option-label-size-143-item-169")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("#option-label-color-93-item-57")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(text(), 'Add to Cart')]")).click();
        driver.findElement(By.xpath("//a[@class='action showcart']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='top-cart-btn-checkout']")).click();
        Thread.sleep(2000);
        }
}