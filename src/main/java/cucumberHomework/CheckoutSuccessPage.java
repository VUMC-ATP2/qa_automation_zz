package cucumberHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WebDriverManager;

public class CheckoutSuccessPage {

    WebDriver driver = WebDriverManager.getInstance();

    public CheckoutSuccessPage() {
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
