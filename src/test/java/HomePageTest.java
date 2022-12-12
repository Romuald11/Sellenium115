import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomePageTest {



        private static WebDriver driver;

        @Test
        public void shouldBeVisibleTextOnHomePage(){
            driver = new ChromeDriver();
            driver.manage().window().maximize();

            driver.navigate().to("http://automationpractice.pl/index.php");
         String textInAlert = driver.findElement(By.className("alert")).getText();
           Assertions.assertEquals("No featured products at this time.",textInAlert);




        }
        @AfterAll
        public static void tearDown(){
            driver.close();

        }
    }

