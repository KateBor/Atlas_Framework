package test;

import org.openqa.selenium.support.ui.WebDriverWait;
import util.DefaultMethodExtension;
import io.qameta.atlas.core.Atlas;
import io.qameta.atlas.webdriver.WebDriverConfiguration;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import page.OKSite;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public static WebDriver driver;
    private static Atlas atlas;
    public static WebDriverWait wait;

    @BeforeAll
    static void init() {
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\ChromeDriver\\chromedriver.exe");
        driver = new ChromeDriver();
       atlas = new Atlas(new WebDriverConfiguration(driver,"https://ok.ru")).
               extension(new DefaultMethodExtension());
       driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
       wait = new WebDriverWait(driver, 10000);
    }

    @AfterAll
    static void close(){
        driver.close();
    }

    public OKSite onSite() {
        return atlas.create(driver, OKSite.class);
    }
}
