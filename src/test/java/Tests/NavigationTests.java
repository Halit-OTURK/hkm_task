package Tests;

import Utilities.BrowserFactory;
import Utilities.StringUtility;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class NavigationTests {
    public static void main(String[] args) {

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://google.com");
        String googleTitle= driver.getTitle();
        driver.navigate().to("https://etsy.com");
        String etsyTitle= driver.getTitle();
        driver.navigate().back();
        String googleTitle2= driver.getTitle();
        StringUtility.verifyEquals(googleTitle,googleTitle2);

        if (googleTitle.equals(googleTitle2)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }

        driver.navigate().forward();
        String etsyTitle2= driver.getTitle();

        StringUtility.verifyEquals(etsyTitle,etsyTitle2);

        if (etsyTitle.equals(etsyTitle2)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }


        driver.close();



        WebDriver driver2 = BrowserFactory.getDriver("edge");
        driver2.manage().window().maximize();
        driver2.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver2.get("https://google.com");
        String googleTitleA= driver2.getTitle();
        driver2.navigate().to("https://etsy.com");
        String etsyTitleA= driver2.getTitle();
        driver2.navigate().back();
        String googleTitleB= driver2.getTitle();
        StringUtility.verifyEquals(googleTitleA,googleTitleB);

        if (googleTitleA.equals(googleTitleB)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }

        driver2.navigate().forward();
        String etsyTitleB= driver2.getTitle();

        StringUtility.verifyEquals(etsyTitleA,etsyTitleB);

        if (etsyTitleA.equals(etsyTitleB)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }


        driver2.close();
    }


}
/*
Test Case
1. Open browser
2. Go to website https://google.com
3. Save the title in a string variable
4. Go to https://etsy.com
5. Save the title in a string variable
6. Navigate back to previous page
7. Verify that title is same is in step 3
8. Navigate forward to previous page
9. Verify that title is same is in step 5
 */