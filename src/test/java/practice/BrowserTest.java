package practice;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page_object.MainPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

@Log4j
public class BrowserTest {

    private final String LOCAL_FILE = "file://" + this.getClass().getResource("/elements.html").getPath();
    // ChromeDriver driver;
    WebDriver driver;
    MainPage mainPage;

    @BeforeTest
    public void setProperties() {
        System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
        Logger.getLogger("org.openqa.selenium").setLevel(Level.OFF);
    }

    @BeforeMethod(alwaysRun = true)
    public void openBrowser() throws MalformedURLException {
        log.info("Initialize ChromeWebDriver");
        // this.driver = new ChromeDriver();
        ChromeOptions options = new ChromeOptions();
        options.setCapability("platformName", "Windows");
        //driver = new RemoteWebDriver(new URL("http://192.168.8.141:4444/"), options);
        driver = new RemoteWebDriver(new URL("https://oauth-stefucis-cf7cf:de713aea-6b0f-4b1a-ac17-89207d4209fa@ondemand.eu-central-1.saucelabs.com:443/wd/hub"), options);
        mainPage = new MainPage(driver);
        // driver.get("https://google.lv");
    }

    @Test
    public void chromeDriverTest() {
        // Assert.assertEquals(driver.getTitle(), "Google");
        // driver.manage().window().maximize(); // this maximizes screen of Chrome
    }

//    @Test
//    public void elementTest() {
//        driver.get(LOCAL_FILE);
////        WebElement nameField = driver.findElement(By.id("fNameID"));
////        nameField.sendKeys("John");
////        WebElement lastnameField = driver.findElement(By.id("lNameID"));
////        lastnameField.sendKeys("Berzins");
////        WebElement aboutMeField = driver.findElement(By.id("aboutMeID"));
////        aboutMeField.sendKeys("This is a text about me");
////        WebElement button = driver.findElement(By.id("checkDataID"));
////        button.click();
////        System.out.println("");
//    }

    @Test
    public void elementTest() {
        driver.get(LOCAL_FILE);
        mainPage = new MainPage(driver);
        // mainPage.getFirstNameField().sendKeys("John");
        mainPage.setFirstName("Jonny"); //same as previous line, but by using method defined in MainPage
        mainPage.setLastName("Steward");
        mainPage.setAboutMeField("This is a text about me");
        // mainPage.clickOnMe();
        Assert.assertFalse(mainPage.getStudentCheckBox().isSelected());
        mainPage.selectStudentCheckbox();
        Assert.assertTrue(mainPage.getStudentCheckBox().isSelected());

        for (WebElement element : mainPage.getAllUniversitiesOptions()) {
            System.out.println(element.getText());
        }

        mainPage.getUniversities().selectByValue("RSU");
        Assert.assertEquals(mainPage.getUniversities().getFirstSelectedOption().getText(), "Rīgas Stradiņa universitāte");
        mainPage.getUniversities().selectByVisibleText("Rīgas Tehniskā universitāte");
        Assert.assertEquals(mainPage.getUniversities().getFirstSelectedOption().getText(), "Rīgas Tehniskā universitāte");

        Assert.assertFalse(mainPage.getJavaRadioButton().isSelected());
        mainPage.getJavaRadioButton().click();
        Assert.assertTrue(mainPage.getJavaRadioButton().isSelected());

        //mainPage.clickOnMe();
        //wait.until(ExpectedConditions.visibilityOf(mainPage.getClickOnMeResult()));
        //wait.until(ExpectedConditions.textToBePresentInElement(mainPage.getClickOnMeResult(), "Viss ir labi!"));
        //Assert.assertEquals(mainPage.getClickOnMeResult().getText(), "Viss ir labi!");
    }

    @Test
    public void testTab() {
        driver.get(LOCAL_FILE);
        driver.findElement(By.linkText("LinkedIn")).click();
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        System.out.println();
    }

    @Test
    public void javascriptTest() {
        driver.get("https:///www.lu.lv");
        WebElement kontakti = driver.findElement(By.linkText("Kontakti"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", kontakti);

        //((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 1024)");
        System.out.println("123");
    }

    @Test
    public void actionTest() {
        driver.get(LOCAL_FILE);
        Actions actions = new Actions(driver);
        mainPage.getAboutMeField().click();
        actions.moveToElement(driver.findElement(By.id("aboutMeID")))
                .keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL)
                .keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL)
                .keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL)
                .keyDown(Keys.CONTROL).sendKeys("v").sendKeys("1").keyUp(Keys.CONTROL).perform();
    }


    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        log.info("Closing ChromeWebDriver");
        driver.close();
        driver.quit();
    }

}
