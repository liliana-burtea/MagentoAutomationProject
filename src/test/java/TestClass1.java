import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;
import test.data.Constants;

public class TestClass1 {

    @Test(
            testName = "TC01 - User open Firefox browser - Magento homepage",
            description =
                    """
                    Step 1: User Open Firefox browser
                    Step 2: User navigates to Magento homepage
                    Step 3: User open Magento homepage successfuly
                    """
    )
    public void goToWebsiteTest() {
        // Primul pas este sa deschid un browser
        // Pentru browser selenium ne ofera obiectul WebDriver
        WebDriver driver = new FirefoxDriver();
        // Pentru a naviga pe un link se foloseste metodsa .get
        driver.get(Constants.BASE_URL);
        driver.close();
    }

    @Test(
            testName = "TC02 - User is login to Magento homepage",
            description =
                    """
                    Step 1: User navigates to Magento homepage
                    Step 2: User click on login button
                    Step 3: User type valid email address
                    Step 4: User type valid password
                    Step 5: User click on Sign in button
                    Step 6: User is logged in successfuly
                    """
    )
    public void loginTest() {
        WebDriver driver = new FirefoxDriver();
        driver.get(Constants.BASE_URL);
        driver.manage().window().maximize();
        // Formula generica a unui XPath
        // //tag[@atribut='valoare']
        // Formula generica a unui XPath cu contains
        // //tag[contains(text(), 'textul cautat')]
        driver.findElement(By.xpath("(//a[contains(text(), 'Sign In')])[1]")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(Constants.EMAIL);
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(Constants.PASSWORD);
        driver.findElement(By.xpath("(//button[@id='send2'])[1]")).click(); // cand am mai multe elemente
    // de acelasi fel in pagina, imbrac xpath-ul in paranteze rotund si deschid [] si pun indexul care incepe de la 1
    }
}

