package Test;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = {"src/test/resources/Features/SignUp.feature"},
        glue = "Steps/SignUp"
)
public class SignUpTest {
}
