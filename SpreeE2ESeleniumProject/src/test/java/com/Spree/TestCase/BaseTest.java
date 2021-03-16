package com.Spree.TestCase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestContext;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;
@Listeners(Listener.class)
public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;


    @BeforeClass
    public void setDriver(ITestContext testContext) {
        System.setProperty("webdriver.chrome.driver", "/Users/skaladagi/Desktop//Selenium/chromedriver");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 10);
        testContext.setAttribute("WebDriver", this.driver);

    }

    @BeforeMethod
    public void setURL(){
        driver.manage().deleteAllCookies();
        driver.get("https://spree-vapasi.herokuapp.com");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

//    @BeforeTest
//    public void setDriver(ITestContext testContext){
//        testContext.setAttribute("WebDriver", this.driver);
//    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

}