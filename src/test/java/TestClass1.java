import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class TestClass1 {

    @Test
    public void goToWebsiteTest() {
        // Primul pas este sa deschid un browser
        // Pentru browser selenium ne ofera obiectul WebDriver
        WebDriver driver = new FirefoxDriver();
        // Pentru a naviga pe un link se foloseste metodsa .get
        driver.get("https://magento.softwaretestingboard.com/");
        driver.close();
    }

    @Test
    public void loginTest() {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();
        // Formula generica a unui XPath
        // //tag[@atribut='valoare']
        // Formula generica a unui XPath cu contains
        // //tag[contains(text(), 'textul cautat')]
        driver.findElement(By.xpath("(//a[contains(text(), 'Sign In')])[1]")).click();
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys("marinela.popescu@gmail.com");
        driver.findElement(By.xpath("//input[@id='pass']")).sendKeys(".Testpass.123");
        driver.findElement(By.xpath("(//button[@id='send2'])[1]")).click(); // cand am mai multe elemente
        // de acelasi fel in pagina, imbrac xpath-ul in paranteze rotund si deschid [] si pun indexul care incepe de la 1
    }
}

