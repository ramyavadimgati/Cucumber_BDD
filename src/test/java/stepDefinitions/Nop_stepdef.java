package stepDefinitions;

import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pageObject.Nop_page;
import pageObject.Pageobj_addcust;
import pageObject.Pageobj_searchcust;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.LogManager;

public class Nop_stepdef extends Baseclass
{


   public Nop_page np;
   @Before
   public void onSetUp() throws IOException
   {
       conf_prop = new Properties();
       FileInputStream fin=new FileInputStream("C:\\Users\\prudh\\IdeaProjects\\Cucumber_BDD\\test-outputs\\config.properties");
       conf_prop.load(fin);
       String br = conf_prop.getProperty("browser");
       if (br.equals("chrome")) {
           System.setProperty("webdriver.chrome.driver", conf_prop.getProperty("chromepath"));
           driver = new ChromeDriver();
       } else if (br.equals("firefox")) {
           System.setProperty("webdriver.gecko.driver", conf_prop.getProperty("firefoxpath"));
           driver = new FirefoxDriver();
       }
   }
    @Given("User opens chrome browser")
    public void user_opens_chrome_browser()
    {
        //Adding log configurations
        logger = Logger.getLogger(Nop_stepdef.class);
        PropertyConfigurator.configure("C:\\Users\\prudh\\IdeaProjects\\Cucumber_BDD\\src\\test\\java\\log4j.properties");
        logger.info("Browser window opened");
       driver.manage().window().maximize();
    }
    @When("User enters nopcommerce website url {string}")
    public void user_enters_nopcommerce_website_url(String url)
    {
        logger.info("NOp commerce website opened");
        driver.get(url);
        np= new Nop_page(driver);
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
    }
    @And("User enters Email as {string} and Password as {string}")
    public void user_enters_email_as_and_password_as(String user, String pass)
    {
        logger.info("Entering email and password");
      np.setUser(user);
      np.setPass(pass);
    }
    @And("User click login button")
    public void user_click_login_button() throws InterruptedException {
        logger.info("Clicking login button");
       np.setLogin_but();
        Thread.sleep(5000);
    }
    @Then("Page title should be {string}")
    public void page_title_should_be(String title)  {

       if(driver.getPageSource().contains("Login was unsuccessful"))
       {
           logger.info("Login unsuccessful page displayed");
           System.out.println("Inside pagesoource");
           driver.quit();
        Assert.assertTrue(false);

       }
       else
       {
           logger.info("Opening Dashboard page");
          Assert.assertEquals(title,driver.getTitle());
       }
    }
    @When("User click on Customer tab")
    public void user_click_on_customer_tab()
    {
        logger.info("Clicking customer menu");
        addcust=new Pageobj_addcust(driver);
        addcust.setCust_tab();
    }
    @When("User click on customers menu")
    public void user_click_on_customers_menu()
    {
        logger.info("Clicking customer option");
        addcust.setCust_menu();
    }
    @When("User click on Add button")
    public void user_click_on_add_button() {
        logger.info("Adding new customer");
       addcust.setAdd_new();
    }
    @Then("Add new customer page displayed")
    public void add_new_customer_page_displayed()
    {
       if(driver.getTitle().equals("Add a new customer / nopCommerce administration"))
       {
           logger.info("Customer details page displayed");
           Assert.assertTrue(true);
           System.out.println("Successfully in add customer page");
       }
    }
    @When("User enters customer details")
    public void user_enters_customer_details() throws InterruptedException {
        logger.info("Entering customer details");
        Baseclass bc=new Baseclass();
       addcust.setEmail(bc.randomString()+"@gmail.com");
       addcust.setPass("xyz1234");
       addcust.setFirstname("Rita");
       addcust.setLastname("Naidu");
       addcust.setGender();
       addcust.setDob("5/5/2023");
       addcust.setCompany("IBM");
       addcust.setTax();
       addcust.setNewsettler();
       addcust.setCust_role("Guests");
       addcust.setVendor();
      addcust.setAdmin_comm("hi i am a new customer");

    }
    @When("User click on save button")
    public void user_click_on_save_button()
    {
        logger.info("Saving the details");
        addcust.setSave_but();
    }
    @Then("Customer details entered page displayed {string}")
    public void customer_details_entered_page_displayed(String string)
    {
        if(driver.getPageSource().contains(string))
        {
            logger.info("User details entered successfully");
            Assert.assertTrue(true);
            System.out.println("Successfully entered all details");
        }
        else
        {
            logger.info("Wrong details entered");
            Assert.assertTrue(false);
        }
    }

    @When("User enters emailid")
    public void user_enters_emailid() throws InterruptedException
    {
        logger.info("Searching customer by email");
       searchcust=new Pageobj_searchcust(driver);
       Thread.sleep(5000);
   //    searchcust.setSearch_icon();

        searchcust.setEmail("admin@yourStore.com");
      //  searchcust.setEmail("admin");


    }
    @When("user click on search button")
    public void user_click_on_search_button() throws InterruptedException {
        logger.info("Clicking search button");
        Thread.sleep(2000);
        searchcust.searchButton();
    }
    @When("User enter Email as {string} and Password as {string}")
    public void user_enter_email_as_and_password_as(String string, String string2)
    {
        logger.info("Entering email and password");
        np.setUser(string);
        np.setPass(string2);
    }

    @Then("User emailid info displayed")
    public void user_emailid_info_displayed() throws InterruptedException
    {
        logger.info("Customer email record displayed");
        searchcust.searchByEmail();



    }
    @When("user enters firstname and lastname")
    public void user_enters_firstname_and_lastname()  {
        logger.info("Searching customer by name");
        searchcust=new Pageobj_searchcust(driver);
        searchcust.setFirstname("James");
        searchcust.setLastname("Pan");

    }
    @Then("User name info displayed")
    public void user_name_info_displayed() throws InterruptedException
    {
        logger.info("Customer name record displayed");
        searchcust.custbyName();
    }
    @When("User click log out button")
    public void user_click_log_out_button()
    {
        logger.info("Clicking logout button");
        np.setLogout_but();
    }
    @And("close the browser")
    public void close_the_browser()
    {
        logger.info("Closing the browser");
        driver.quit();
    }


}
