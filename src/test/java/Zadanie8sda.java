import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Zadanie8sda {

    private static WebDriver driver;
    @BeforeAll
    public static void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.bbc.com/");
    }

    @Test
    public void iloscLinkoNaStronie(){
        driver = new ChromeDriver();
        driver.navigate().to("https://www.bbc.com/");
        driver.findElements(By.tagName("a"));
        List<WebElement> znalezioneLinki =driver.findElements(By.tagName("a"));
        System.out.println("Ilość znalezionych linków =" + znalezioneLinki.size());
    }

    @Test
    public void iloscObrazkowNaStronie(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://www.bbc.com/");
        List<WebElement> znalezioneLinki =driver.findElements(By.tagName("img"));
        System.out.println("Ilość znalezionych obrazów =" + znalezioneLinki.size());
    }

    @AfterAll
    public static void tearDown(){
        driver.close();
    }

}
