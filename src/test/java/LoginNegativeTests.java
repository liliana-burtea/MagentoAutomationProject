import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import test.data.Constants;

public class LoginNegativeTests {

    WebDriver driver = new FirefoxDriver();

    @BeforeTest
    public void setup() {
        driver.get(Constants.BASE_URL);
        driver.manage().window().maximize();
    }

    @Test(
            testName = "TC01 - Valid username but empty password field",
            description =
                """
                Step 1: User navigates to Magento homepage
                Step 2: User click on login button
                Step 3: User type valid email address
                Step 4: User let the password field empty
                Step 5: User click on Sign in button
                Step 6: User receive an error with invalid password
                """
    )
    public void ValidEmailEmptyPasswordTest() throws InterruptedException {
        driver.findElement(By.xpath("(//a[contains(text(), 'Sign In')])[1]")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(Constants.EMAIL);
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(Constants.EMPTY_PASSWORD);
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//button[@id='send2'])[1]")).click();
        String actualMessage1 = driver.findElement(By.xpath("//div[@id='pass-error']")).getText();
        String expectedMessage1 = Constants.EXPECTED_MESSAGE_REQUIRED_FIELD;
        Assert.assertEquals(actualMessage1, expectedMessage1);
        String actualColor1 = driver.findElement(By.xpath("//div[@id='pass-error']"))
                .getCssValue(Constants.COLOR_CSS);
        String expectedColor1 = Constants.RED_COLOR;
        Assert.assertEquals(actualColor1, expectedColor1);
    }

    @Test(
            testName = "TC02 - Empty field for username, valid password",
            description =
                    """
                    Step 1: User navigates to Magento homepage
                    Step 2: User click on login button
                    Step 3: User let the email address field empty
                    Step 4: User type the password
                    Step 5: User click on Sign in button
                    Step 6: User receive an error with validation field for email
                    """
    )
    public void emptyEmailValidPasswordTest() throws InterruptedException {
        driver.findElement(By.xpath("(//a[contains(text(), 'Sign In')])[1]")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(Constants.EMPTY_EMAIL);
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(Constants.PASSWORD);
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//button[@id='send2'])[1]")).click();
        String actualMessage2 = driver.findElement(By.xpath("//div[@id='email-error']")).getText();
        String expectedMessage2 = Constants.EXPECTED_MESSAGE_REQUIRED_FIELD;
        Assert.assertEquals(actualMessage2, expectedMessage2);
        String actualColor2 = driver.findElement(By.xpath("//div[@id='email-error']"))
                .getCssValue(Constants.COLOR_CSS);
        String expectedColor2 = Constants.RED_COLOR;
        Assert.assertEquals(actualColor2, expectedColor2);
    }

    @Test(
            testName = "TC03 - Invalid Email",
            description =
                    """
                    Step 1: User navigates to Magento homepage
                    Step 2: User click on login button
                    Step 3: User type an invalid email address
                    Step 4: User type the password
                    Step 5: User click on Sign in button
                    Step 6: User receive an error with validation field for email
                    """
    )
    public void invalidEmailTest() throws InterruptedException {
        driver.findElement(By.xpath("(//a[contains(text(), 'Sign In')])[1]")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(Constants.INVALID_EMAIL);
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(Constants.PASSWORD);
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//button[@id='send2'])[1]")).click();
        String actualMessage3 = driver.findElement(By.xpath("//div[@id='email-error']")).getText();
        String expectedMessage3 = Constants.EXPECTED_MESSAGE_VALID_EMAIL;
        Assert.assertEquals(actualMessage3, expectedMessage3);
        String actualColor3 = driver.findElement(By.xpath("//div[@id='email-error']"))
                .getCssValue(Constants.COLOR_CSS);
        String expectedColor3 = Constants.RED_COLOR;
        Assert.assertEquals(actualColor3, expectedColor3);
    }

    @Test(
            testName = "TC04 - Valid email invalid password",
            description =
                    """
                    Step 1: User navigates to Magento homepage
                    Step 2: User click on login button
                    Step 3: User type an valid email address
                    Step 4: User type an invalid password
                    Step 5: User click on Sign in button
                    Step 6: User receive an error with validation field for password
                    """
    )
    public void validEmailInvalidPasswordTest() throws InterruptedException {
        driver.findElement(By.xpath("(//a[contains(text(), 'Sign In')])[1]")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(
                Constants.EMAIL);
        driver.findElement(By.xpath("//input[@id='pass']"))
                .sendKeys(Constants.INVALID_PASSWORD);
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//button[@id='send2'])[1]")).click();
        String actualMessage4 = driver.findElement(By.xpath("//div[@class='messages']"))
                .getCssValue(Constants.COLOR_CSS);
        String expectedMessage4 = Constants.DARK_CHARCOAL_COLOR;
        Assert.assertEquals(actualMessage4, expectedMessage4);
    }

    @Test(
            testName = "TC05 - Empty email, empty password",
            description =
                    """
                    Step 1: User navigates to Magento homepage
                    Step 2: User click on login button
                    Step 3: User let the username for email address empty
                    Step 4: User let the username for password address empty
                    Step 5: User click on Sign in button
                    Step 6: User receive an error with validation field for email and password
                    """
    )
    public void emptyEmailEmptyPasswordTest() throws InterruptedException {
        driver.findElement(By.xpath("(//a[contains(text(), 'Sign In')])[1]")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(Constants.EMPTY_EMAIL);
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(Constants.EMPTY_PASSWORD);
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//button[@id='send2'])[1]")).click();
        String actualMessage5 = driver.findElement(By.xpath("//div[@id='email-error']")).getText();
        String expectedMessage5 = Constants.EXPECTED_MESSAGE_REQUIRED_FIELD;
        Assert.assertEquals(actualMessage5, expectedMessage5);
        String actualColor5 = driver.findElement(By.xpath("//div[@id='email-error']"))
                .getCssValue(Constants.COLOR_CSS);
        String expectedColor5 = Constants.EXPECTED_MESSAGE_REQUIRED_FIELD;
        Assert.assertEquals(actualColor5, expectedColor5);
        String actualMessage6 = driver.findElement(By.xpath("//div[@id='pass-error']")).getText();
        String expectedMessage6 = Constants.EXPECTED_MESSAGE_REQUIRED_FIELD;
        Assert.assertEquals(actualMessage6, expectedMessage6);
        String actualColor6 = driver.findElement(By.xpath("//div[@id='pass-error']"))
                .getCssValue(Constants.COLOR_CSS);
        String expectedColor6 = Constants.RED_COLOR;
        Assert.assertEquals(actualColor6, expectedColor6);
    }
}