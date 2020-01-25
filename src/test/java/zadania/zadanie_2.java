package zadania;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class zadanie_2 {

    WebDriver driver;

    @BeforeEach
    public void setDriver(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(640, 480));

    }

    @AfterEach
    public void killDriver(){
        driver.quit();
    }

    @Test
    public void subTest1() {
        String pageTitleExpected = "Wikipedia, wolna encyklopedia";
        driver.get("https://pl.wikipedia.org");
        Assertions.assertEquals(pageTitleExpected, driver.getTitle(), "Page title is not equal" + pageTitleExpected);
    }
     @Test
        public void subTest2(){
        String  expectedURL = "https://pl.wikipedia.org/";
        driver.navigate().to("https://pl.wikipedia.org/");
        Assertions.assertEquals(expectedURL.contains("wikipedia.org/"), driver.getCurrentUrl().contains("pl.wikipedia.org"),"not" +expectedURL);
    }
    @Test
    public void subTest3(){
        String actPageLang = "lang=\"pl\"";
        driver.navigate().to("pl.wikipedia.org");
        Assertions.assertTrue(driver.getPageSource().contains(actPageLang), "lang is not:" +actPageLang);
    }


}
