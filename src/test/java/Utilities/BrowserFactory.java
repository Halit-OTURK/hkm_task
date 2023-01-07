package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.security.PublicKey;

public class BrowserFactory {

    public static WebDriver getDriver(String Browsername){
        if (Browsername.equalsIgnoreCase("chrome")) {

            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();

        } else if (Browsername.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        }else if (Browsername.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver();
        }
        else {
            System.out.println("Given browser type does not exist/or is not currently supported");
            System.out.println("Driver = null");
            return null;
        }
    }

}
