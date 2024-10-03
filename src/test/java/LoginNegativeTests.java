import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginNegativeTests {

    WebDriver driver = new FirefoxDriver();

    @BeforeTest
    public void setup() {
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();
    }

// TC01 - Valid username but empty password field
    @Test
    public void ValidEmailEmptyPasswordTest() throws InterruptedException {
        driver.findElement(By.xpath("(//a[contains(text(), 'Sign In')])[1]")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("a.b@gmail.com");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//button[@id='send2'])[1]")).click();
        String actualMessage1 = driver.findElement(By.xpath("//div[@id='pass-error']")).getText();
        String expectedMessage1 = "This is a required field.";
        Assert.assertEquals(actualMessage1, expectedMessage1);
        String actualColor1 = driver.findElement(By.xpath("//div[@id='pass-error']")).getCssValue("color");
        String expectedColor1 = "rgb(224, 43, 39)";
        Assert.assertEquals(actualColor1, expectedColor1);
    }

// TC02 - Empty field for username, valid password
    @Test
    public void emptyEmailValidPasswordTest() throws InterruptedException {
       driver.findElement(By.xpath("(//a[contains(text(), 'Sign In')])[1]")).click();
       driver.findElement(By.xpath("//input[@id='email']")).sendKeys("");
       driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("testpassword");
       Thread.sleep(2000);
       driver.findElement(By.xpath("(//button[@id='send2'])[1]")).click();
       String actualMessage2 = driver.findElement(By.xpath("//div[@id='email-error']")).getText();
       String expectedMessage2 = "This is a required field.";
       Assert.assertEquals(actualMessage2, expectedMessage2);
       String actualColor2 = driver.findElement(By.xpath("//div[@id='email-error']")).getCssValue("color");
       String expectedColor2 = "rgb(224, 43, 39)";
       Assert.assertEquals(actualColor2, expectedColor2);
    }

// TC03 - Invalid Email
    @Test
    public void invalidEmailTest() throws InterruptedException {
        driver.findElement(By.xpath("(//a[contains(text(), 'Sign In')])[1]")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("bla bla bla");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("testpassword");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//button[@id='send2'])[1]")).click();
        String actualMessage3 = driver.findElement(By.xpath("//div[@id='email-error']")).getText();
        String expectedMessage3 = "Please enter a valid email address (Ex: johndoe@domain.com).";
        Assert.assertEquals(actualMessage3, expectedMessage3);
        String actualColor3 = driver.findElement(By.xpath("//div[@id='email-error']")).getCssValue("color");
        String expectedColor3 = "rgb(224, 43, 39)";
        Assert.assertEquals(actualColor3, expectedColor3);
    }

// TC04 - Valid email invalid password
    @Test
    public void validEmailInvalidPasswordTest() throws InterruptedException {
        driver.findElement(By.xpath("(//a[contains(text(), 'Sign In')])[1]")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("ione17.popescu@gmail.com");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("invalid_password");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//button[@id='send2'])[1]")).click();
        String actualMessage4 = driver.findElement(By.xpath("//div[@class='messages']")).getCssValue("color");
        String expectedMessage4 = "rgb(51, 51, 51)";
        Assert.assertEquals(actualMessage4, expectedMessage4);
    }

// TC05 - Empty email, empty password
    @Test
    public void emptyEmailEmptyPasswordTest() throws InterruptedException {
        driver.findElement(By.xpath("(//a[contains(text(), 'Sign In')])[1]")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys("");
        Thread.sleep(2000);
        driver.findElement(By.xpath("(//button[@id='send2'])[1]")).click();
        String actualMessage5 = driver.findElement(By.xpath("//div[@id='email-error']")).getText();
        String expectedMessage5 = "This is a required field.";
        Assert.assertEquals(actualMessage5, expectedMessage5);
        String actualColor5 = driver.findElement(By.xpath("//div[@id='email-error']")).getCssValue("color");
        String expectedColor5 = "rgb(224, 43, 39)";
        Assert.assertEquals(actualColor5, expectedColor5);
        String actualMessage6 = driver.findElement(By.xpath("//div[@id='pass-error']")).getText();
        String expectedMessage6 = "This is a required field.";
        Assert.assertEquals(actualMessage6, expectedMessage6);
        String actualColor6 = driver.findElement(By.xpath("//div[@id='pass-error']")).getCssValue("color");
        String expectedColor6 = "rgb(224, 43, 39)";
        Assert.assertEquals(actualColor6, expectedColor6);
    }
}

