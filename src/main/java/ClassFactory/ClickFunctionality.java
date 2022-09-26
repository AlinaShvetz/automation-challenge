package ClassFactory;
import io.cucumber.java.DataTableType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.HashMap;
public class ClickFunctionality {
    public ArrayList <WebElement>inputs;
    HashMap <String,WebElement> signinput;
    WebDriver driver;
    public HashMap<String, WebElement> getSigninput() {
        return signinput;
    }
    public ClickFunctionality(String drivername) {
        this.inputs = new ArrayList<WebElement>();
        this.driver = DriverFactory.addbrowser(drivername);
        this.signinput = new HashMap<>();
    }
    public void addDigitInput (){
        for (int i = 0; i <10; i++) {
            inputs.add(driver.findElement(By.xpath("//span[@aria-label='"+i+"']")));
        }
    }
    public void signadd (){
    signinput.put("Sqrt", driver.findElement(By.xpath("//span[@aria-label='Square Root']")));
    signinput.put("/",driver.findElement(By.xpath("//span[@aria-label='Divide']")));
    signinput.put("*", driver.findElement(By.xpath("//span[@aria-label='Times']")));
    signinput.put("-",driver.findElement(By.xpath("//span[@aria-label='Minus']")));
    signinput.put("+", driver.findElement(By.xpath("//span[@aria-label='Plus']")));
    signinput.put(".", driver.findElement(By.xpath("//span[@aria-label='Decimal']")));
    }
    public void ClickDigitInput(String num) {
        for (int i = 0; i < num.length(); i++) {
            Character split = num.charAt(i);
            if ((num.charAt(i))=='.') {
                signinput.get(".").click();
            } else {
                int numeric = Character.getNumericValue(split);
                inputs.get(numeric).click();
            }
        }
    }

    public void SignInput(String sign ) {
        signinput.get(sign).click();
    }
    public WebDriver getDriver() {
        return driver;
    }

}
