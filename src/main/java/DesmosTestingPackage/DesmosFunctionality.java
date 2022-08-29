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
    WebDriver driver;

    ArrayList<WebElement> button = new ArrayList<>();
    ArrayList <Integer> calculatenumber = new ArrayList<>();
    String rootPath = "//*[@id=\"main\"]/div/div/div/div[5]/div[2]/div/div/div";
    ClickFunctionality funct = new ClickFunctionality();

    @Before
    public void TestCalass() {
        driver = DriverFactory.addbrowser("chrome");
        driver.get("https://www.desmos.com/fourfunction?lang=en");

        button.add(driver.findElement(By.xpath(rootPath + "[5]/div[1]/span")));
        button.add(driver.findElement(By.xpath(rootPath + "[4]/div[1]/span")));
        button.add(driver.findElement(By.xpath(rootPath + "[4]/div[2]/span")));
        button.add(driver.findElement(By.xpath(rootPath + "[4]/div[3]/span")));
        button.add(driver.findElement(By.xpath(rootPath + "[3]/div[1]/span")));
        button.add(driver.findElement(By.xpath(rootPath + "[3]/div[2]/span")));
        button.add(driver.findElement(By.xpath(rootPath + "[3]/div[3]/span")));
        button.add(driver.findElement(By.xpath(rootPath + "[2]/div[1]/span")));
        button.add(driver.findElement(By.xpath(rootPath + "[2]/div[2]/span")));
        button.add(driver.findElement(By.xpath(rootPath + "[2]/div[3]/span")));
        button.add(driver.findElement(By.xpath(rootPath + "[1]/div[4]/span")));
        button.add(driver.findElement(By.xpath(rootPath + "[2]/div[4]/span")));
        button.add(driver.findElement(By.xpath(rootPath + "[3]/div[4]/span")));
        button.add(driver.findElement(By.xpath(rootPath + "[4]/div[4]/span")));
        button.add(driver.findElement(By.xpath(rootPath + "[1]/div[3]/span")));

    }
    @When("User performs mathematical operation {} on two one digit numbers: {} and {}")
    public void user_performs_mathematical_on_two_numbers(String operation, String  numberA, String numberB) {
        funct.DigitInput(numberA,button);
        funct.SignInput(operation,button);
        funct.DigitInput(numberB, button);
    }

    @When("User performs mathematical operation {} on three numbers: {} and {} and {}")
    public void Perform_three_number_operation (String operation, String  numberA, String numberB, String numberC){
        funct.DigitInput(numberA, button);
        funct.SignInput(operation,button);
        funct.DigitInput(numberB,button);
        funct.SignInput(operation, button);
        funct.DigitInput(numberC,button);
    }
    @When("User performs mixed mathematical operation on three numbers: {} {} {} {} {}")
    public void Perform_mixed_operations (String  numberA, String operation, String numberB, String operation2, String numberC ){

        funct.DigitInput(numberA, button);

        funct.SignInput(operation,button);

        funct.DigitInput(numberB,button);

        funct.SignInput(operation2, button);

        funct.DigitInput(numberC,button);

    }
    @Then("He gets the correct result {}")
    public void Restul_of_two_number_operation (Double result){
        System.out.println(result);
        WebElement elm = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/div[1]/div[2]/div/div[5]/div[2]/div[1]/span[2]"));
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        String text = elm.getText();
        Double actualR = Double.parseDouble(text.substring(1, text.length()));
        System.out.println(actualR);
        Assert.assertEquals(actualR,result);
    }

    @After
    public void teardown (){
        driver.quit();
    }
}
