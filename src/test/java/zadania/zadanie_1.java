package zadania;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class zadanie_1 {

    WebDriver driver;

    @BeforeEach
    public void driverSetup(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }
    @AfterEach
    public void driverQuit(){
        driver.close();
        driver.quit();
    }
    @Test
    public void test1(){
        driver.navigate().to("https://pl.wikipedia.org/");
        driver.navigate().to("https://nasa.gov");
        driver.navigate().back();
        String wikiTitle = "Wikipedia, wolna encyklopedia";
        Assertions.assertEquals(wikiTitle, driver.getTitle(),"Zjebalosie: " +wikiTitle);
        driver.navigate().forward();
        String nasaTitle = "NASA";
        Assertions.assertEquals(nasaTitle, driver.getTitle(),"Zjebalosie: " +nasaTitle);


    }

}
