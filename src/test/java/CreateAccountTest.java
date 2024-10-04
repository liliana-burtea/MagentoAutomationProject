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

    @Test
    public void goToWomenJacketTest(){
        driver.findElement(By.xpath("//span[contains(text(), 'Women')]")).click();
        driver.findElement(By.xpath("//a[contains(text(), 'Jackets')]")).click();
        String actualJacketsTitle = driver.findElement(By.xpath("//span[@data-ui-id='page-title-wrapper']")).getText();
        String expectedJacketsTitle = "Jackets";
        Assert.assertEquals(actualJacketsTitle, expectedJacketsTitle);
    }

    @Test
    public void e2eBuyAWomenTeeshirtTest() throws InterruptedException {
        driver.findElement(By.xpath("(//a[contains(text(), 'Sign In')])[1]")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("ione17.popescu@gmail.com");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(".Testpass.123");
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
            driver.findElement(By.xpath("//div[@class='shipping-address-item selected-item']")).isDisplayed();
            Thread.sleep(4000);
            driver.findElement(By.xpath("//button[@class='button action continue primary']")).click();
            Thread.sleep(4000);
            driver.findElement(By.xpath("//button[@class='action primary checkout']")).click();
            }
        catch (Exception e){
            driver.findElement(By.xpath("//input[@name='street[0]']")).sendKeys("Dristorului, nr.6, Bl.21, Et.4, Apt.23");
            driver.findElement(By.xpath("//input[@name='city']")).sendKeys("Bucharest");
            Thread.sleep(2000);
            driver.findElement(By.xpath("//select[@name='country_id']")).click();
            driver.findElement(By.xpath("//option[@data-title='Romania']")).click();
            driver.findElement(By.xpath("//select[@name='region_id']")).click();
            driver.findElement(By.xpath("//option[@data-title='Alba']")).click();
            driver.findElement(By.xpath("//input[@name='postcode']")).sendKeys("123456");
            driver.findElement(By.xpath("//input[@name='telephone']")).sendKeys("+40723783673");
            driver.findElement(By.xpath("//button[@class='button action continue primary']")).click();
            Thread.sleep(5000);
            driver.findElement(By.xpath("//button[@class='action primary checkout']")).click();
        }
        Thread.sleep(6000);
        String actualThankYouTitle = driver.findElement(By.xpath("//span[@data-ui-id='page-title-wrapper']")).getText();
        String expectedThankYouTitle = "Thank you for your purchase!";
        Assert.assertEquals(actualThankYouTitle, expectedThankYouTitle);
    }

    // TODO: Muta datele de test (email, tel, adresa...etc, in constante, inclusiv mesajele de assert)
}
