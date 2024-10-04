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

    @Test(
            testName = "TC01 - Valid username but empty password field",
            description =
                    """
                    Step 1: User navigates to Magento homepage
                    Step 2: User click on Shop button
                    Step 3: User verify Shop New Yoga Button color
                    Step 4: User receive the message that the color is as expected
                    """
    )
    public void verifyShopNewYogaButtonColorTest() {
        String actualColor = driver.findElement(By.xpath("//span[@class='action more button']"))
                .getCssValue(Constants.BACKGROUND_COLOR_CSS);
        String expectedColor = Constants.BLUE_COLOR;
        Assert.assertEquals(actualColor, expectedColor);
    }

    @Test(
            testName = "TC02 - Valid background color for Training on Demand",
            description =
                    """
                    Step 1: User navigates to Magento homepage
                    Step 2: User click on Training button
                    Step 3: User verify Training on demand background color
                    Step 4: User receive the message that the color is as expected
                    """
    )
    public void verifyTrainingOnDemandBackgroundColorTest() {
        driver.findElement(By.xpath("//span[contains(text(), 'Training')]")).click();
        String actualColor1 = driver.findElement(By.xpath("//a[@class='block-promo training-on-demand']"))
                .getCssValue(Constants.BACKGROUND_CSS);
        String expectedColor1 = Constants.LIGHT_BLUE_COLOR;
        Assert.assertEquals(actualColor1, expectedColor1);
    }

    @Test(
            testName = "TC03 - Valid background color of Free Shipping",
            description =
                    """
                    Step 1: User navigates to Magento homepage
                    Step 2: User click on Sale button
                    Step 3: User verify Free Shipping background color
                    Step 4: User receive the message that the color is as expected
                    """
    )
    public void verifyCommercialSaleFreeShippingBackgroundColorTest() {
        driver.findElement(By.xpath("//span[contains(text(), 'Sale')]")).click();
        String actualColor2 = driver.findElement(By.xpath("//a[@class='block-promo sale-free-shipping']"))
                .getCssValue(Constants.BACKGROUND_CSS);
        String expectedColor2 = Constants.GREEN_COLOR;
        Assert.assertEquals(actualColor2, expectedColor2);
    }

    @Test(
            testName = "TC04 - Valid title color for Hot Sellers",
            description =
                    """
                    Step 1: User navigates to Magento homepage
                    Step 2: User click on Sale button
                    Step 3: User verify Hot Sellers title color
                    Step 4: User receive the message that the color is as expected
                    """
    )
    public void verifyHotSellersTitleColorTest() {
        String actualColor3 = driver.findElement(By.xpath("//h2[@class='title']"))
                .getCssValue(Constants.COLOR_CSS);
        String expectedColor3 = Constants.GRAY_COLOR;
        Assert.assertEquals(actualColor3, expectedColor3);
    }

    @Test(
            testName = "TC05 - Valid Short color from New Luma Yoga Collection",
            description =
                    """
                    Step 1: User navigates to Magento homepage
                    Step 2: User click on New Luma Yoga Collection button
                    Step 3: User verify the Short color
                    Step 4: User receive the message that the color is as expected
                    """
    )
    public void verifyShortColorTest() {
        driver.findElement(By.xpath("//span[@class='action more button']")).click();
        String actualColor4 = driver.findElement(By.xpath("//div[@option-label='Purple'][1]"))
                .getCssValue(Constants.BACKGROUND_CSS);
        String expectedColor4 = Constants.PURPLE_COLOR;
        Assert.assertEquals(actualColor4, expectedColor4);
    }

    @Test(
            testName = "TC06 - Go to Homepage color title",
            description =
                    """
                    Step 1: User navigates to Magento homepage
                    Step 2: User click on Homepage button
                    Step 3: User verify the Homepage title color
                    Step 4: User receive the message that the color is as expected
                    """
    )
    public void verifyGoToHomePageColorTest() {
        driver.findElement(By.xpath("//span[@class='action more button']")).click();
        String actualColor4 = driver.findElement(By.xpath("//a[@title='Go to Home Page']"))
                .getCssValue(Constants.COLOR_CSS);
        String expectedColor4 = Constants.BLUE1_COLOR;
        Assert.assertEquals(actualColor4, expectedColor4);
    }
}