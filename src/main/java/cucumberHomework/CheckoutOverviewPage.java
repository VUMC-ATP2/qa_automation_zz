package cucumberHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WebDriverManager;

public class CheckoutOverviewPage {
    WebDriver driver = WebDriverManager.getInstance();

    public CheckoutOverviewPage() {
        this.driver = driver;
    }

    private final By itemName = By.id("item_4_title_link");
    private final By itemPrice = By.xpath("//div[@class='inventory_item_price']");
    private final By totalPrice = By.xpath("//div[@class='summary_total_label']");
    private final By checkoutDone = By.id("finish");

    public WebElement getItemName() {
        return driver.findElement(itemName);
    }

    public WebElement getItemPrice() {
        return driver.findElement(itemPrice);
    }

    public WebElement getTotalPrice() {
        return driver.findElement(totalPrice);
    }

    public void getCheckoutDone() {
        driver.findElement(checkoutDone).click();
    }


}
