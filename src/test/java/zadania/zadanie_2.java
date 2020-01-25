package zadania;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
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
    public void subTest_1(){
        driver.get("https://pl.wikipedia.org");
        String pageTitle = "Wikipedia, wolna encyklopedia";
        String  expectedURL = "https://pl.wikipedia.org/";

        Assertions.assertEquals(pageTitle, driver.getTitle(), "Page is not" +pageTitle);
        System.out.println("Assertion_1 "+driver.getTitle());

        Assertions.assertTrue(expectedURL.contains("pl.wikipedia"),driver.getCurrentUrl());
        System.out.println("Assertion_2 "+driver.getCurrentUrl());

        Assertions.assertTrue(driver.getPageSource().contains("lang=\"pl\""));
        System.out.println("Assertion_3");

        driver.findElement(By.cssSelector("a[lang='es']")).click();
        System.out.println("Lang swap ");


        String pageTitle2 = "Wikipedia, la enciclopedia libre";
        String  expectedURL2 = "https://es.wikipedia.org/";

        Assertions.assertEquals(pageTitle2, driver.getTitle(), "Page is not" +pageTitle2);
        System.out.println("Assertion_4 "+driver.getTitle());

        Assertions.assertTrue(expectedURL2.contains("es.wikipedia"),driver.getCurrentUrl());
        System.out.println("Assertion_5 "+driver.getCurrentUrl());

        Assertions.assertTrue(driver.getPageSource().contains("lang=\"es\""));
        System.out.println("Assertion_6");


    }

}
