package pageObjectsHomework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

    private ChromeDriver driver;

    public LoginPage(ChromeDriver driver) {
        this.driver = driver;
    }

    private By userName = By.id("user-name");

    private By password = By.id("password");

    private By logInButton = By.id("login-button");

    public WebElement getUserName() {
        return this.driver.findElement(userName);
    }

    public WebElement getPassword() {
        return this.driver.findElement(password);
    }

    public WebElement selectLogInButton() {
        return this.driver.findElement(logInButton);
    }
}
