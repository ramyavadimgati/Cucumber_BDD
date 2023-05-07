package pageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Pageobj_searchcust
{
    WebDriver pdriver;
    public int rec=0;
    public Pageobj_searchcust(WebDriver driver)
    {
        pdriver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id="SearchEmail")
    WebElement email;
    @FindBy(id="SearchFirstName")
    WebElement firstname;
    @FindBy(id="SearchLastName")
    WebElement lastname;
    @FindBy(xpath="//button[@id='search-customers']")
    WebElement search;
    @FindBy(xpath="//div[text()='Search']")
    WebElement search_icon;

    By table_1 = By.xpath("//*[@id=\"customers-grid\"]/tbody/tr/td[2]");

    By table_2 = By.xpath("//*[@id=\"customers-grid\"]/tbody/tr/td[3]");


    public void setSearch_icon() {
        this.search_icon.click();
    }

    public void setEmail(String email) {

        this.email.sendKeys(email);

    }

    public void setFirstname(String firstname) {
        this.firstname.sendKeys(firstname);
    }

    public void setLastname(String lastname) {
        this.lastname.sendKeys(lastname);
    }

    public void searchButton() throws InterruptedException
    {

        search.click();



    }
    public void searchByEmail()
    {
        List<WebElement> option_1 = pdriver.findElements(table_1);
        System.out.println(option_1+"options_1");
        for (WebElement cell : option_1)
        {
            String email_id=cell.getText();
            String email_txt=this.email.getAttribute("value");
            //       System.out.println("emailid:"+email_id+"\t"+email_txt);
            if(email_id.equals(email_txt))
            {

                rec++;
            }
        }
        if(rec == 0 )
        {
            System.out.println("Entered email is not found");
            Assert.assertTrue(false);
        }

        else
        {

            System.out.println("Recordfound");
        }



    }

    public void custbyName() throws InterruptedException {

        List<WebElement> options_2 = pdriver.findElements(table_2);
        rec=0;
        String name=firstname.getAttribute("value")+" "+lastname.getAttribute("value");
        System.out.println("size"+options_2.size());
        for (WebElement cell : options_2)
        {
            String uname=cell.getText();

                  System.out.println(name+" "+uname);
            if(uname.equals(name))
            {
                System.out.println("inside");
                rec++;
            }
        }
        if(rec == 0 )
        {
            System.out.println("Entered name is not found");
            Assert.assertTrue(false);
        }

        else
        {

            System.out.println("Recordfound");
        }


    }
}
