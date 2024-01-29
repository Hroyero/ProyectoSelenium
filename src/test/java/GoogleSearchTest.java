
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class GoogleSearchTest {
    private WebDriver driver;

    @Before
    public void setUp()throws Exception{
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ryzen\\eclipse-workspace\\ProyectoSelenium\\src\\test\\resources\\ChromerDriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/?hl=es");

    }
    @Test
    public void testGooglePage(){
        WebElement searchBox = driver.findElement(By.name("q"));
         searchBox.clear();
         searchBox.sendKeys("Test Automation for Selenium");
         searchBox.submit();
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
         assertEquals("Test Automation for Selenium - Buscar con Google",driver.getTitle());
    }
    @After
    public void closeTest(){
        driver.quit();
    }

}
