package a004_Cookies;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Cookies {

    WebDriver driver;
    @BeforeEach
    public void cookiesBegin(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(640, 480));

    }

    @AfterEach
    public void cookiesEnd(){
        driver.close();
        driver.quit();
    }

    @Test
    public void gettingCookies(){


    }


}
