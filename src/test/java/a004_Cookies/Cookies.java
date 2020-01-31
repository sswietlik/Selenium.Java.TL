package a004_Cookies;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class Cookies {

    WebDriver driver;
    @BeforeEach
    public void cookiesBegin(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(640, 480));
        driver.navigate().to("https://www.amazon.com/");
        driver.

    }

    @AfterEach
    public void cookiesEnd(){
        driver.close();
        driver.quit();
    }

    @Test
    public void gettingCookies() throws InterruptedException {
        Set<Cookie> cookies = driver.manage().getCookies();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assertions.assertEquals(9,driver.manage().getCookies().size(),"nubmer of cookies is not what expected");
        Cookie cookieSessionId = driver.manage().getCookieNamed("session-id");
        driver.manage().deleteCookieNamed("session-id");
        Assertions.assertEquals(9,driver.manage().getCookies().size(),"nubmer of cookies is not what expected");
        driver.manage().deleteAllCookies();
        Assertions.assertEquals(0,driver.manage().getCookies().size(),"nubmer of cookies is not what expected");

    }


}
