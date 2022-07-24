package seleniumHomework;

import lombok.extern.log4j.Log4j;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjectsHomework.*;

@Log4j
public class SauceDemoTests {

    ChromeDriver driver;
    LoginPage loginPage;
    InventoryPage inventoryPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    CheckoutOverviewPage checkoutOverviewPage;
    CheckoutSuccessPage checkoutSuccessPage;

    WebDriverWait webDriverWait;

    @BeforeMethod(alwaysRun = true)
    public void openBrowser() {
        log.info("Initialize ChromeWebDriver");
        this.driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        loginPage = new LoginPage();
        inventoryPage = new InventoryPage(driver);
        webDriverWait = new WebDriverWait(driver, 20);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        checkoutOverviewPage = new CheckoutOverviewPage(driver);
        checkoutSuccessPage = new CheckoutSuccessPage(driver);
    }


    @Test
    public void TestPageFirst() {
        loginPage.getUserName().sendKeys("standard_user");
        loginPage.getPassword().sendKeys("secret_sauce");
        loginPage.selectLogInButton().click();
        webDriverWait.until(ExpectedConditions.visibilityOf(inventoryPage.getProductButton()));
        Assert.assertTrue(inventoryPage.getProductButton().isDisplayed());
        inventoryPage.addProductToCart();
        inventoryPage.goToCart();
        cartPage.findRemoveButton();
        cartPage.clickCheckoutButton();
        checkoutPage.fillContacts("Name here", "Surname here", "Coding 12345");
        checkoutPage.clickContinueButton();
        Assert.assertEquals(checkoutOverviewPage.getItemName().getText(), "Sauce Labs Backpack");
        Assert.assertEquals(checkoutOverviewPage.getItemPrice().getText(), "$29.99");
        checkoutOverviewPage.getCheckoutDone();
        Assert.assertEquals(checkoutSuccessPage.getCheckoutComplete().getText(), "CHECKOUT: COMPLETE!");
        checkoutSuccessPage.returnBackHome();
    }

    @Test
    public void TestPageSecond() {
        loginPage.getUserName().sendKeys("standard_user");
        loginPage.getPassword().sendKeys("secret_sauce");
        loginPage.selectLogInButton().click();
        inventoryPage.goToCart();
        cartPage.clickCheckoutButton();
        checkoutPage.clickContinueButton();
        webDriverWait.until(ExpectedConditions.visibilityOf(checkoutPage.getErrorMessage()));
        Assert.assertEquals(checkoutPage.getErrorMessage().getText(), "Error: First Name is required");
        checkoutPage.fillFirstName("MyName");
        checkoutPage.clickContinueButton();
        Assert.assertEquals(checkoutPage.getErrorMessage().getText(), "Error: Last Name is required");
        checkoutPage.fillLastName("MySurname");
        checkoutPage.clickContinueButton();
        Assert.assertEquals(checkoutPage.getErrorMessage().getText(), "Error: Postal Code is required");
        checkoutPage.fillPostalCode("12345LV");
        checkoutPage.clickContinueButton();
        System.out.println("123");
    }

    @AfterMethod(alwaysRun = true)
    public void closeBrowser() {
        log.info("Closing ChromeWebDriver");
        driver.close();
        driver.quit();
    }
}
