package Tests;

import Utilities.BrowserFactory;
import Utilities.StringUtility;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class NG2 {
    WebDriver driver, driver2;

    @BeforeClass
    public void SetupChrome(){
        driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @BeforeClass
    public void SetupEdge(){
        driver2 = BrowserFactory.getDriver("edge");
        driver2.manage().window().maximize();
        driver2.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void chromeTest() {

        driver.get("https://google.com");
        String googleTitle = driver.getTitle();
        driver.navigate().to("https://etsy.com");
        String etsyTitle = driver.getTitle();
        driver.navigate().back();
        String googleTitle2 = driver.getTitle();
        driver.navigate().forward();
        String etsyTitle2 = driver.getTitle();

        Assert.assertEquals(googleTitle, googleTitle2);
        Assert.assertEquals(etsyTitle, etsyTitle2);

    }


    @Test
    public void edgeTest() {

        driver2.get("https://google.com");
        String googleTitleA = driver2.getTitle();
        driver2.navigate().to("https://etsy.com");
        String etsyTitleA = driver2.getTitle();
        driver2.navigate().back();
        String googleTitleB = driver2.getTitle();
        StringUtility.verifyEquals(googleTitleA, googleTitleB);

        driver2.navigate().forward();
        String etsyTitleB = driver2.getTitle();

        Assert.assertEquals(googleTitleA, googleTitleB);
        Assert.assertEquals(etsyTitleA, etsyTitleB);


    }

@AfterClass
    public void tearDownClass(){
        driver.close();
        driver2.close();
}


}
