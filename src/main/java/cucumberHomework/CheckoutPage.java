package cucumberHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WebDriverManager;

public class CheckoutPage {
    WebDriver driver = WebDriverManager.getInstance();

    public CheckoutPage() {
        this.driver = driver;
    }

    private By firstName = By.id("first-name");

    private By lastName = By.id("last-name");

    private By postalCode = By.id("postal-code");

    private By continueButton = By.id("continue");

    private By errorMessage = By.xpath("//*[@class='error-message-container error']");


    public void fillContacts(String name, String surname, String zipCode) {
        driver.findElement(firstName).sendKeys(name);
        driver.findElement(lastName).sendKeys(surname);
        driver.findElement(postalCode).sendKeys(zipCode);
    }

    public void fillFirstName(String nameName) {
        driver.findElement(firstName).sendKeys(nameName);
    }

    public void fillLastName(String surnameName) {
        driver.findElement(lastName).sendKeys(surnameName);
    }

    public void fillPostalCode(String postalCodeInsert) {
        driver.findElement(postalCode).sendKeys(postalCodeInsert);
    }

    public void clickContinueButton() {
        driver.findElement(continueButton).click();
    }

    public WebElement getErrorMessage() {
        return driver.findElement(errorMessage);
    }

}
