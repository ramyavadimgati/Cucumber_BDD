package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\prudh\\IdeaProjects\\Cucumber_BDD\\Features\\Login_nop.feature",glue="",dryRun = true,monochrome = true,plugin = {"html:test-output"})
public class Loginrun_nop
{


}
