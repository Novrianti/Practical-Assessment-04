package FolderTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    public ThreadLocal<WebDriver> driver= new ThreadLocal<>();
    public ThreadLocal<WebDriverWait> explicitWait= new ThreadLocal<>();

    //Before (Open Browser, Additional Open Website atau url/connection)
    @BeforeMethod
    public void openBrowser(){
        WebDriverManager.edgedriver().setup();
        EdgeOptions options= new EdgeOptions();

        //Getter and Setter
        driver.set(new EdgeDriver(options));
        driver.get().manage().window().maximize();//maxime window
        driver.get().get("https://demoblaze.com/");
        explicitWait.set(new WebDriverWait((driver.get()), Duration.ofSeconds(120)));
    }
    //After (Close Browser atau close connection)
    @AfterMethod
    public void closeBrowser(){
        driver.get().quit();
    }


}
