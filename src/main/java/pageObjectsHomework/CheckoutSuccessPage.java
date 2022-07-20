package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckoutSuccessPage {

    public WebDriver driver;

    public CheckoutSuccessPage(WebDriver driver) {
        this.driver = driver;
    }

    private By checkoutComplete = By.xpath("//span[@class='title']");

    private By backHome = By.id("back-to-products");

    public WebElement getCheckoutComplete() {
        return driver.findElement(checkoutComplete);
    }

    public void returnBackHome() {
        driver.findElement(backHome).click();
    }
}
