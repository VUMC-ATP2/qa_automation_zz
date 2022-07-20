package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class InventoryPage {

    public WebDriver driver;

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    private By productButton = By.id("add-to-cart-sauce-labs-backpack");

    private By goToCart = By.id("shopping_cart_container");

    public void addProductToCart() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    public WebElement getProductButton() {
        return driver.findElement(productButton);
    }

    public void goToCart() {
        driver.findElement(goToCart).click();
    }

}
