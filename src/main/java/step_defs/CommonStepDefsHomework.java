package step_defs;

import cucumberHomework.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.WebDriverManager;

public class CommonStepDefsHomework {
    WebDriver driver = WebDriverManager.getInstance();
    LoginPage loginPage = new LoginPage();
    InventoryPage inventoryPage = new InventoryPage();
    CartPage cartPage = new CartPage();
    CheckoutPage checkoutPage = new CheckoutPage();
    CheckoutOverviewPage checkoutOverviewPage = new CheckoutOverviewPage();
    CheckoutSuccessPage checkoutSuccessPage = new CheckoutSuccessPage();

    @Given("I navigate to login page")
    public void navigateToLoginPage() {
        driver.get("https://www.saucedemo.com/");
    }

    @When("I login with credentials {string} and {string}")
    public void loginUsingCredentials(String username, String password) {
        loginPage.authorize(username, password);
    }

    @Then("I am successfully logged in to page")
    public void checkSuccessLogin() {
        Assertions.assertThat(driver.getCurrentUrl()).containsIgnoringCase("inventory.html");
    }

    @When("I add one product to cart")
    public void addToCart() {
        inventoryPage.addProductToCart();
    }

    @Then("I go to cart")
    public void goToCart() {
        inventoryPage.goToCart();
    }

    @Then("I see it in cart")
    public void seeInCart() {
        cartPage.findRemoveButton();
    }

    @When("I click on check-out")
    public void clickOnCheckout() {
        cartPage.clickCheckoutButton();
    }

    @Then("I fill the name with {string}, surname with {string} and zip code with {string} in check-out page")
    public void fillContactData(String name, String surname, String zipcode) {
        checkoutPage.fillContacts(name, surname, zipcode);
    }

    @Then("I can continue check-out")
    public void continueWithCheckout() {
        checkoutPage.clickContinueButton();
    }

    @When("I reach the Overview page, I check the information is correct")
    public void checkData() {
        checkoutOverviewPage.getItemName();
        checkoutOverviewPage.getItemPrice();
        checkoutOverviewPage.getTotalPrice();
    }

    @Then("I finish the purchase")
    public void finishPurchase() {
        checkoutOverviewPage.getCheckoutDone();
    }

    @Then("I make sure everything is good")
    public void CheckOverviewPage() {
        checkoutSuccessPage.getCheckoutComplete();
    }

    @Then("I go back to Home page")
    public void goBackHome() {
        checkoutSuccessPage.returnBackHome();
    }

    @Then("I check if name is mandatory field")
    public void fillFirstNameField() {
        checkoutPage.clickContinueButton();
    }

    @And("I check if the error message of name field is correct")
    public void checkIfTheErrorMessageOfNameIsCorrect() {
        Assert.assertEquals(checkoutPage.getErrorMessage().getText(), "Error: First Name is required");
    }

    @When("I fill the name field")
    public void fillTheNameField() {
        checkoutPage.fillFirstName("Name");
    }

    @Then("I check if surname field is mandatory")
    public void checkIfSurnameFieldIsMandatory() {
        checkoutPage.clickContinueButton();
    }

    @And("I check if the error message of surname field is correct")
    public void checkIfTheErrorMessageOfSurnameFieldIsCorrect() {
        Assert.assertEquals(checkoutPage.getErrorMessage().getText(), "Error: Last Name is required");
    }

    @When("I fill the name and surname field")
    public void iFillTheSurnameField() {
        checkoutPage.fillFirstName("Name");
        checkoutPage.fillLastName("Surname");
    }

    @Then("I check if zip code field is mandatory")
    public void iCheckIfZipCodeFieldIsMandatory() {
        checkoutPage.clickContinueButton();
    }

    @And("I check if the error message of zipcode field is correct")
    public void iCheckIfTheErrorMessageOfZipcodeFieldIsCorrect() {
        Assert.assertEquals(checkoutPage.getErrorMessage().getText(), "Error: Postal Code is required");
    }
}
