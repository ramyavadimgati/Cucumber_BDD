package stepDefinitions;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pageObject.Pageobj_addcust;
import pageObject.Pageobj_searchcust;

import java.util.Properties;

public class Baseclass
{
    WebDriver driver;
    Pageobj_addcust addcust;
    Pageobj_searchcust searchcust;
    public Properties conf_prop;
    public static Logger logger;
    public String randomString()
    {
        String random= RandomStringUtils.randomAlphabetic(5);
        return random;
    }
}
