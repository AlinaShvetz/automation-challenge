package DesmosTestingPackage;
import ClassFactory.ClickFunctionality;
import ClassFactory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
public class DesmosSelectiveFunctions {
    ClickFunctionality funct = new ClickFunctionality( "ffx");
    WebDriver driver = funct.getDriver();
    @Before
    public void TestCalass() {
        driver.get("https://www.desmos.com/fourfunction?lang=en");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        funct.addDigitInput();
        funct.signadd();
    }
    @When("I click on {string} keyboard input")
    public void digit_click(String digit_btn) {
        funct.ClickDigitInput(digit_btn);
        WebElement enterbutton = driver.findElement(By.xpath("//span[@aria-label='Enter']"));
        enterbutton.click();
    }
    @Then("^The output screen is displaying \"([^\"]*)\"$")
    public void digit_output(String digit) {
        WebElement outputTextArea = driver.findElement(By.xpath("//div[@class='dcg-math-field dcg-mq-editable-field dcg-mq-math-mode']"));
        String digit_output = outputTextArea.getText();
        System.out.println("The output is: "+ digit_output);
        Assert.assertEquals(digit_output,digit);
    }
    @When("I perform an arithmetic operation with any decimal number")
    public void decimal_number (DataTable dataTable)
    {   Map<String, String> tablevalue = dataTable.asMaps(String.class, String.class).get(0);
        String input = tablevalue.get("input2");
            funct.ClickDigitInput(tablevalue.get("input1"));
            funct.SignInput(tablevalue.get("operation"));
            funct.ClickDigitInput(tablevalue.get("input2"));
    }
    @Then("I get a correct {double}")
    public void getting_result (Double result){
        WebElement resultElement = driver.findElement(By.xpath("//span[@class='dcg-mq-root-block']"));
        WebElement restult = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@class='dcg-mq-root-block']")));
        String text = resultElement.getText();
        Double actualR = Double.parseDouble(text.substring(1, text.length()));
        Assert.assertEquals(actualR,result);
    }
    @After
    public void teardown (){
        driver.close();
    }
}