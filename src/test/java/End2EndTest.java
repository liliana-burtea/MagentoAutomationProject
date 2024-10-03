import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class End2EndTest {

    // Adauga 5 produse din departamente diferite in cos

    @Test
    public void add5DifferentProductToCartTest() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://magento.softwaretestingboard.com/");
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
        //Fifth Product
        //////////
        driver.findElement(By.xpath("//a[@class='action showcart']")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@id='top-cart-btn-checkout']")).click();
        Thread.sleep(2000);

        }

}

// Tema Negative Tests
// O clasa noua in care testez: Login
// Testeaza textul si culoarea fiecarei erori (in teste separate in clasa respectiva)
