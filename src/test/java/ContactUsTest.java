import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ContactUsTest {

    private static WebDriver driver;

    @BeforeAll
    public static void setDriver() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("http://automationpractice.pl/index.php");
    }

    @Test
    public void shouldNotAllowToSendEmptyContactUsForm() {
        //driver.findElement(By.linkText("Contact us")).click();
        //driver.findElement(By.tagName("a")).click();
        //driver.findElement(By.id("contact-link")).click();
        driver.findElement(By.cssSelector("#contact-link")).click();
        driver.findElement(By.name("submitMessage")).click();

        //driver.findElement(By.className("alert-danger")).isDisplayed();
        Assertions.assertTrue(driver.findElement(By.className("alert-danger")).isDisplayed());
    }

    @Test
    public void shouldNotAllowToSendConactUsFormWithOnlySelectedSubject(){
        driver.findElement(By.cssSelector("#contact-link")).click();

        WebElement subjectSelector = driver.findElement(By.id("id_contact"));
        Select subject = new Select(subjectSelector);
        subject.selectByVisibleText("Webmaster");

        driver.findElement(By.name("submitMessage")).click();
        Assertions.assertTrue(driver.findElement(By.className("alert-danger")).isDisplayed());
    }

    @AfterAll
    public static void tearDown() {
        driver.close();
    }

}