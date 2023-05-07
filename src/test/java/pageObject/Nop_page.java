package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Nop_page
{
    WebDriver ldriver;
    public Nop_page(WebDriver driver)
    {
        ldriver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id="Email")
    WebElement user;
    @FindBy(id="Password")
    WebElement pass;
    @FindBy(xpath ="//button[text()='Log in']")
    WebElement login_but;
    @FindBy(xpath="//a[text()='Logout']")
    WebElement logout_but;

    public void setUser(String user) {
        this.user.clear();
        this.user.sendKeys(user);

    }

    public void setPass(String pass) {
        this.pass.clear();
        this.pass.sendKeys(pass);
    }

    public void setLogin_but() {
        this.login_but.click();
    }

    public void setLogout_but() {
        this.logout_but.click();
    }
}
