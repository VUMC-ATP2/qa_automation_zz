package mavenTestNGHomework;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@Slf4j
public class BrowserHomework {
    ChromeDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void openBrowser() {
        log.info("Initialize ChromeWebDriver");
        this.driver = new ChromeDriver();
        driver.get("https://www.delfi.lv/");
    }

    @Test
    public void webpageTitleTest() {
        Assert.assertEquals(driver.getTitle(), "DELFI - Vadošais ziņu portāls Latvijā - DELFI");
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        log.info("Closing ChromeWebDriver");
        driver.close();
    }
}
