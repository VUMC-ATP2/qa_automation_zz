package mavenTestNGHomework;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestCalculator {

    @BeforeClass(alwaysRun = true)
    public void printWelcomeText() {
        System.out.println("Welcome to my automation testing homework");
    }

    @BeforeMethod(alwaysRun = true)
    public void printStartText() {
        System.out.println("The test has started");
    }

    @Test
    public void testAdd() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.add(10, 12), 22, "Add formula should be checked");
    }

    @Test
    public void testSubtract() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.subtract(50, 2), 48, "Subtract formula should be checked");
    }

    @Test
    public void testMultiply() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.multiply(50, 2), 100, "Multiply formula should be checked");
    }

    @Test
    public void testDivide() {
        Calculator calculator = new Calculator();
        Assert.assertEquals(calculator.divide(50, 25), 2, "Divide formula should be checked");
    }

    @AfterMethod(alwaysRun = true)
    public void printEndText() {
        System.out.println("Test has ended");
    }

    @AfterClass(alwaysRun = true)
    public void printGoodbyeText() {
        System.out.println("Thanks for joining me! See you next time!");
    }
}
