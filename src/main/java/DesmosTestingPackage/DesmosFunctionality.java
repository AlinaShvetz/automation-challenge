package DesmosTestingPackage;
import ClassFactory.ClickFunctionality;
import ClassFactory.DriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class DesmosFunctionality {
    ClickFunctionality funct = new ClickFunctionality( "ffx");
    WebDriver driver = funct.getDriver();

    @Before
    public void TestCalass() {
        driver.get("https://www.desmos.com/fourfunction?lang=en");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        funct.addDigitInput();
        funct.signadd();
    }
    @When("User performs mathematical operation {} on two one digit numbers: {} and {}")
    public void user_performs_mathematical_on_two_numbers(String operation, String  numberA, String numberB) {
        funct.ClickDigitInput(numberA);
        funct.SignInput(operation);
        funct.ClickDigitInput(numberB);
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    }
    @When("User performs mathematical operation {} on three numbers: {} and {} and {}")
    public void Perform_three_number_operation (String operation, String  numberA, String numberB, String numberC){
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        funct.ClickDigitInput(numberA);
        funct.SignInput(operation);
        funct.ClickDigitInput(numberB);
        funct.SignInput(operation);
        funct.ClickDigitInput(numberC);
    }
    @When("User performs mixed mathematical operation on three numbers: {} {} {} {} {}")
    public void Perform_mixed_operations (String  numberA, String operation, String numberB, String operation2, String numberC ){
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        funct.ClickDigitInput(numberA);
        funct.SignInput(operation);
        funct.ClickDigitInput(numberB);
        funct.SignInput(operation2);
        funct.ClickDigitInput(numberC);

    }
    @Then("He gets the correct result {}")
    public void Restul_of_two_number_operation (Double result){
        WebElement elm = driver.findElement(By.xpath("//span[@class='dcg-mq-root-block']"));
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        String text = elm.getText();
        Double actualR = Double.parseDouble(text.substring(1, text.length()));
        Assert.assertEquals(actualR,result);
    }

    @After
    public void teardown (){
        driver.close();
    }
}
