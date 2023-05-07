package testRunner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {".//Features//Customer.feature",".//Features//Login_nop.feature"},glue = "stepDefinitions",monochrome = true,dryRun = false,plugin = {"pretty","html:.//test-outputs//outputs.html"},tags = "@sanity")
public class Runner_cust
{
}
