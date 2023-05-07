package pageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

public class Pageobj_addcust
{
    WebDriver pdriver;
    public Pageobj_addcust(WebDriver driver)
    {
        pdriver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath="//div[@class='os-content']/nav/ul/li[4]/a/p")
    WebElement cust_tab;
    @FindBy(xpath="//a[@href='/Admin/Customer/List']")
    WebElement cust_menu;
    @FindBy(xpath="//a[@href='/Admin/Customer/Create']")
    WebElement add_new;
    @FindBy(name="save")
    WebElement save_but;
    @FindBy(id ="Email")
    WebElement email;
    @FindBy(id="Password")
    WebElement pass;
    @FindBy(id="FirstName")
    WebElement firstname;
    @FindBy(id="LastName")
    WebElement lastname;
    @FindBy(id="Gender_Male")
    WebElement gender;
    @FindBy(name="DateOfBirth")
    WebElement dob;
    @FindBy(name="Company")
    WebElement company;
    @FindBy(id="IsTaxExempt")
    WebElement tax;
    @FindBy(xpath="(//div[@class='k-multiselect-wrap k-floatwrap'])[1]")
    WebElement newsettler;
    @FindBy(xpath="//li[text()='Test store 2']")
    WebElement news;
    @FindBy(xpath="//li[text()='Guests']")
    WebElement guests;


    @FindBy(id="VendorId")
    WebElement vendor;

    @FindBy(xpath = "//textarea[@id='AdminComment']")
    WebElement admin_comm;

    public void setPass(String pass)
    {

        this.pass.sendKeys(pass);
    }

    public void setEmail(String email) {
        this.email.sendKeys(email);
    }

    public void setAdd_new() {
        this.add_new.click();
    }
    public void setLastname(String lastname)
    {
        this.lastname.sendKeys(lastname);
    }
    public void setAdmin_comm(String admin_comm) {
        this.admin_comm.sendKeys(admin_comm);
    }

    public void setCompany(String company) {
        this.company.sendKeys(company);
    }

    public void setCust_menu() {
        this.cust_menu.click();
    }



    public void setCust_tab() {
        this.cust_tab.click();
    }

    public void setDob(String dob) {
        this.dob.sendKeys(dob);
    }

    public void setFirstname(String firstname) {
        this.firstname.sendKeys(firstname);
    }

    public void setGender() {
        this.gender.click();
    }

    public void setTax() {
        this.tax.click();
    }

    public void setSave_but() {
        this.save_but.click();
    }
    public void setCust_role(String role) throws InterruptedException {

        Actions a=new Actions(pdriver);
        WebElement cust_role=pdriver.findElement(By.xpath("(//div[@class='k-multiselect-wrap k-floatwrap'])[2]"));;
        Thread.sleep(5000);
        pdriver.findElement(By.xpath("//ul[@id='SelectedCustomerRoleIds_taglist']/li/span[2]")).click();
        a.moveToElement(cust_role).click().build().perform();
        guests.click();

    }
    public void setNewsettler()
    {
        Actions a=new Actions(pdriver);
        a.moveToElement(newsettler).click().build().perform();
        a.moveToElement(news).click().build().perform();
    }


    public void setVendor()
    {
        Select s=new Select(vendor);
        s.selectByIndex(1);

    }

}
