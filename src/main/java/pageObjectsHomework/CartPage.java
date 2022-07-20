package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
    public WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    private By removeButton = By.xpath("//button[@id=\"remove-sauce-labs-backpack\"]");
    private By checkoutButton = By.id("checkout");

    public void clickCheckoutButton() {
        driver.findElement(checkoutButton).click();
    }

    public void findRemoveButton() {
        driver.findElement(removeButton);
    }

}
