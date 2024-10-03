import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ColorsTest {
   WebDriver driver;

    @BeforeMethod //metoda @BeforeTest se autoapeleaza inainte de rularea fiecarui test din clasa respectiva
    public void setup() {
        driver = new FirefoxDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();
    }

    @Test
    public void verifyShopNewYogaButtonColorTest() {
        String actualColor = driver.findElement(By.xpath("//span[@class='action more button']")).getCssValue("background-color");
        String expectedColor = "rgb(25, 121, 195)";
        Assert.assertEquals(actualColor, expectedColor);
    }

// Tema - 5 cazuri de test / 5 culori

    // Cazul 1
    @Test
    public void verifyTrainingOnDemandBackgroundColorTest() {
        driver.findElement(By.xpath("//span[contains(text(), 'Training')]")).click();
        String actualColor1 = driver.findElement(By.xpath("//a[@class='block-promo training-on-demand']")).getCssValue("background");
        String expectedColor1 = "rgb(0, 173, 226)";
        Assert.assertEquals(actualColor1, expectedColor1);
    }

    // Cazul 2
    @Test
    public void verifyCommercialSaleFreeShippingBackgroundColorTest() {
        driver.findElement(By.xpath("//span[contains(text(), 'Sale')]")).click();
        String actualColor2 = driver.findElement(By.xpath("//a[@class='block-promo sale-free-shipping']")).getCssValue("background");
        String expectedColor2 = "rgb(113, 181, 78)";
        Assert.assertEquals(actualColor2, expectedColor2);
    }

    // Cazul 3
    @Test
    public void verifyHotSellersTitleColorTest() {
        String actualColor3 = driver.findElement(By.xpath("//h2[@class='title']")).getCssValue("color");
        String expectedColor3 = "rgb(51, 51, 51)";
        Assert.assertEquals(actualColor3, expectedColor3);
    }

    // Cazul 4
    @Test
    public void verifyShortColorTest() {
        driver.findElement(By.xpath("//span[@class='action more button']")).click();
        String actualColor4 = driver.findElement(By.xpath("//div[@option-label='Purple'][1]")).getCssValue("background");
        String expectedColor4 = "rgb(239, 61, 255) 50% 50% no-repeat";
        Assert.assertEquals(actualColor4, expectedColor4);
    }

    // Cazul 5
    @Test
    public void verifyGoToHomePageColorTest() {
        driver.findElement(By.xpath("//span[@class='action more button']")).click();
        String actualColor4 = driver.findElement(By.xpath("//a[@title='Go to Home Page']")).getCssValue("color");
        String expectedColor4 = "rgb(0, 107, 180)";
        Assert.assertEquals(actualColor4, expectedColor4);
    }
}

