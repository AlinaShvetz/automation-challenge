import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {
       // "src/test/resources/Desmos_Scenarios.feature",
       // "src/test/resources/Desmos_Buttons.feature",
        "src/test/resources/Desmos_Operations.feature"},
        glue = {"DesmosTestingPackage"})
public class DesmosTestRunner {

}
