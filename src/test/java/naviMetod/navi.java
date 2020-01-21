package naviMetod;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class navi {

    WebDriver driver;

    @BeforeEach
    public void driverSetup(){

    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().window().setSize(new Dimension(320,280));

    }

    @AfterEach
    public void driverQuit(){

        driver.quit();

    }

    @Test
    public void getMetod(){

        driver.get("https://google.pl");
        driver.navigate().to("https://chip.pl");
        driver.navigate().to("https://google.pl");
        driver.navigate().back();
        driver.navigate().forward();
    }


}
