package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.SeleniumHelper;

public class Login {
    WebDriver driver;
    SeleniumHelper sh = new SeleniumHelper(driver);

    public Login(WebDriver driver){
        this.driver = driver;
    }

    By menu = By.id("menu-toggle");
    By menuLogin = By.xpath("//a[.='Login']");
    By username = By.id("txt-username");
    By password = By.id("txt-password");
    By buttonLogin = By.id("btn-login");

    //Method to click menu Login
    public void clickMenuLogin() {
        sh.clickWithJS(menu,10);
        sh.clickWithJS(menuLogin,10);
        // driver.findElement(menu).click();
        // driver.findElement(menuLogin).click();
    }

    //Method to enter username
    public void enterUsername(String user) {
        driver.findElement(username).sendKeys(user);
    }

    //Method to enter password
    public void enterPassword(String pass) {
        driver.findElement(password).sendKeys(pass);
    }

    //Method to click on Login button
    public void clickLogin() {
        sh.clickWithJS(buttonLogin,10);
        // driver.findElement(buttonLogin).click();
    }
}
