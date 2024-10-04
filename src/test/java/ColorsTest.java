import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import test.data.Constants;

public class ColorsTest {
    WebDriver driver;

    // metoda @BeforeTest se autoapeleaza inainte de rularea fiecarui test din clasa respectiva
    @BeforeMethod
    public void setup() {
        driver = new FirefoxDriver();
        driver.get(Constants.BASE_URL);
        driver.manage().window().maximize();
    }

    @Test
    public void verifyShopNewYogaButtonColorTest() {
        String actualColor = driver.findElement(By.xpath("//span[@class='action more button']"))
                .getCssValue(Constants.BACKGROUND_COLOR_CSS);
        String expectedColor = Constants.BLUE_COLOR;
        Assert.assertEquals(actualColor, expectedColor);
    }

    @Test
    public void verifyTrainingOnDemandBackgroundColorTest() {
        driver.findElement(By.xpath("//span[contains(text(), 'Training')]")).click();
        String actualColor1 = driver.findElement(By.xpath("//a[@class='block-promo training-on-demand']"))
                .getCssValue(Constants.BACKGROUND_CSS);
        String expectedColor1 = Constants.LIGHT_BLUE_COLOR;
        Assert.assertEquals(actualColor1, expectedColor1);
    }

    @Test
    public void verifyCommercialSaleFreeShippingBackgroundColorTest() {
        driver.findElement(By.xpath("//span[contains(text(), 'Sale')]")).click();
        String actualColor2 = driver.findElement(By.xpath("//a[@class='block-promo sale-free-shipping']"))
                .getCssValue(Constants.BACKGROUND_CSS);
        String expectedColor2 = Constants.GREEN_COLOR;
        Assert.assertEquals(actualColor2, expectedColor2);
    }

    @Test
    public void verifyHotSellersTitleColorTest() {
        String actualColor3 = driver.findElement(By.xpath("//h2[@class='title']"))
                .getCssValue(Constants.COLOR_CSS);
        String expectedColor3 = Constants.GRAY_COLOR;
        Assert.assertEquals(actualColor3, expectedColor3);
    }

    @Test
    public void verifyShortColorTest() {
        driver.findElement(By.xpath("//span[@class='action more button']")).click();
        String actualColor4 = driver.findElement(By.xpath("//div[@option-label='Purple'][1]"))
                .getCssValue(Constants.BACKGROUND_CSS);
        String expectedColor4 = Constants.PURLPLE_COLOR;
        Assert.assertEquals(actualColor4, expectedColor4);
    }

    @Test
    public void verifyGoToHomePageColorTest() {
        driver.findElement(By.xpath("//span[@class='action more button']")).click();
        String actualColor4 = driver.findElement(By.xpath("//a[@title='Go to Home Page']"))
                .getCssValue(Constants.COLOR_CSS);
        String expectedColor4 = Constants.DARK_GRAY_COLOR;
        Assert.assertEquals(actualColor4, expectedColor4);
    }
}

// TODO: Muta toate culorile in constante
// TODO: Muta atributele de CSS in constante