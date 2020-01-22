package a003_getSourceData;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class sourceData {

    WebDriver driver;

    @BeforeEach
    public void setDriver(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().setSize(new Dimension(320, 280));

    }
    @AfterEach
    public void setQuitDriver(){
        driver.close();
        driver.quit();
    }

    @Test
    public void sourceDataURLGet(){
        String googleURL = "https://www.google.pl/";
        driver.navigate().to("https://www.google.pl/");
        Assertions.assertEquals(googleURL, driver.getCurrentUrl(),"Current URL is not"+ googleURL);
        System.out.println(googleURL);
    }

    @Test
    public void getTitle(){
        String ChipPageTitle = "CHIP";
        driver.navigate().to("https://www.chip.pl/");
        Assertions.assertEquals(ChipPageTitle, driver.getTitle(),"Page Title is not"+ ChipPageTitle);
        System.out.println(ChipPageTitle);
    }

    @Test
    public void getPageData(){
        String googlePng = "/logos/doodles/2020/grandfathers-day-2020-poland-6753651837108266-l.png";
        driver.navigate().to("https://www.google.pl");
        Assertions.assertTrue(driver.getPageSource().contains(googlePng), "Brak obrazu" + googlePng);


    }
}
