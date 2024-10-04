import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import test.data.Constants;

public class CreateAccountTest {

    WebDriver driver = new FirefoxDriver();

    @BeforeTest //metoda @BeforeTest se autoapeleaza inainte de rularea fiecarui test din clasa respectiva
    public void setup() {
        driver.get(Constants.BASE_URL);
        driver.manage().window().maximize();
    }

    @Test(
            testName = "TC01 - Create new account",
            description =
                    """
                    Step 1: User navigates to Magento homepage
                    Step 2: User click on Create an account button
                    Step 3: User type personal information
                    Step 4: User type Sign-in Information
                    Step 5: User click on Create an Account button
                    Step 4: User receive the expected message for Create an Account
                    """
    )
    public void createAccountTest() throws InterruptedException {
        driver.findElement(By.xpath("//a[contains(text(), 'Create an Account')]")).click();
        driver.findElement(By.xpath("//input[@id='firstname']"))
                .sendKeys(Constants.FIRST_NAME);
        driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(Constants.LAST_NAME);
        driver.findElement(By.xpath("//input[@id='email_address']"))
                .sendKeys(Constants.EMAIL1);
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(Constants.PASSWORD);
        driver.findElement(By.xpath("//input[@id='password-confirmation']"))
                .sendKeys(Constants.PASSWORD);
        driver.findElement(By.xpath("//button[@class='action submit primary']")).click();
        Thread.sleep(3000); // timp de asteptare o secunda (1=1000)
        String actualMessage = driver.findElement(By.xpath(
                "//div[@data-bind='html: $parent.prepareMessageForHtml(message.text)']")).getText();
        String expectedMessage = Constants.EXPECTED_MESSAGE_CREATE_ACCOUNT;
        Assert.assertEquals(actualMessage, expectedMessage);
    }

    @Test(
            testName = "TC02 - Go to Women and verify the Jackets title",
            description =
                    """
                    Step 1: User navigates to Magento homepage
                    Step 2: User click on Women button
                    Step 3: User click on Jackets button
                    Step 3: User verify Jackets title
                    Step 4: User receive the message that the title is as expected
                    """
    )
    public void goToWomenJacketTest(){
        driver.findElement(By.xpath("//span[contains(text(), 'Women')]")).click();
        driver.findElement(By.xpath("//a[contains(text(), 'Jackets')]")).click();
        String actualJacketsTitle = driver.findElement(By.xpath(
                "//span[@data-ui-id='page-title-wrapper']")).getText();
        String expectedJacketsTitle = Constants.TITLE_JACKETS;
        Assert.assertEquals(actualJacketsTitle, expectedJacketsTitle);
    }

    @Test(
            testName = "TC03 - E2E Buy a product",
            description =
                    """
                    Step 1: User navigates to Magento homepage
                    Step 2: User click on Sign in button
                    Step 3: User type email and password
                    Step 4: User click on Sign in button
                    Step 5: User click on Women button
                    Step 6: User click on Tee button
                    Step 7: User scroll down and click on a product
                    Step 8: User select the size and quantity
                    Step 9: User click on Add to Cart button
                    Step 10: User click on the cart button
                    Step 11: User click on Proceed to checkout button
                    Step 12: If the user is new on the shopping page - User type the Shipping Address
                             If the user is not new the shopping page, the address will be remember from the when was
                             last time logged and will fill the address
                    Step 13: User click on Next button
                    Step 14: User click on Place Order button
                    Step 15: User receive the message Thank you for your purchase! as expected
                    """
    )
    public void e2eBuyAWomenTeeshirtTest() throws InterruptedException {
        driver.findElement(By.xpath("(//a[contains(text(), 'Sign In')])[1]")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(Constants.EMAIL);
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(Constants.PASSWORD);
        driver.findElement(By.xpath("(//button[@id='send2'])[1]")).click();
        driver.findElement(By.xpath("//span[@class='action more button']")).click();
        driver.findElement(By.xpath("//a[contains(text(), 'Juliana Short-Sleeve Tee')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//div[@id='option-label-size-143-item-166']")).click();
        driver.findElement(By.xpath("//div[@id='option-label-color-93-item-60']")).click();
        driver.findElement(By.xpath("//input[@id='qty']")).clear();
        driver.findElement(By.xpath("//input[@id='qty']")).sendKeys("2");
        driver.findElement(By.xpath("//span[contains(text(), 'Add to Cart')]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@class='action showcart']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@id='top-cart-btn-checkout']")).click();
        Thread.sleep(4000);
        try{
            driver.findElement(By.xpath("//div[@class='shipping-address-item selected-item']"))
                    .isDisplayed();
            Thread.sleep(4000);
            driver.findElement(By.xpath("//button[@class='button action continue primary']")).click();
            Thread.sleep(4000);
            driver.findElement(By.xpath("//button[@class='action primary checkout']")).click();
            }
        catch (Exception e){
            driver.findElement(By.xpath("//input[@name='street[0]']"))
                    .sendKeys(Constants.USER_ADDRESS);
            driver.findElement(By.xpath("//input[@name='city']")).sendKeys(Constants.CITY);
            Thread.sleep(2000);
            driver.findElement(By.xpath("//select[@name='country_id']")).click();
            driver.findElement(By.xpath("//option[@data-title='Romania']")).click();
            driver.findElement(By.xpath("//select[@name='region_id']")).click();
            driver.findElement(By.xpath("//option[@data-title='Alba']")).click();
            driver.findElement(By.xpath("//input[@name='postcode']"))
                    .sendKeys(Constants.POSTCODE);
            driver.findElement(By.xpath("//input[@name='telephone']"))
                    .sendKeys(Constants.PHONE_NUMBER);
            driver.findElement(By.xpath("//button[@class='button action continue primary']")).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//button[@class='action primary checkout']")).click();
        }
        Thread.sleep(6000);
        String actualThankYouTitle = driver.findElement(By.xpath(
                "//span[@data-ui-id='page-title-wrapper']")).getText();
        String expectedThankYouTitle = Constants.EXPECTED_THANK_YOU_TITLE;
        Assert.assertEquals(actualThankYouTitle, expectedThankYouTitle);
    }
}
