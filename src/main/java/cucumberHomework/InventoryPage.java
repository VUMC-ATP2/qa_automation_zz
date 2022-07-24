package cucumberHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WebDriverManager;

public class InventoryPage {

    WebDriver driver = WebDriverManager.getInstance();

    public InventoryPage() {
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
