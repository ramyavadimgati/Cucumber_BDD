package testRunner;



import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features="C://Users//prudh//IdeaProjects//Cucumber_BDD//Features//Login_Feature.feature", glue="Login_step")
public class Login_runner
{
    Login_runner()
    {

    }
}
