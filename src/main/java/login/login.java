package login;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;


public class login {
    @Test
    public void loginCURAHealthcare(){

        String website = "https://katalon-demo-cura.herokuapp.com/";
        By menu = By.id("menu-toggle");
        By menuLogin = By.xpath("//a[.='Login']");
        By username = By.id("txt-username");
        By password = By.id("txt-password");
        By buttonLogin = By.id("btn-login");
        By makeAppointment = By.tagName("h2");

        WebDriverManager.edgedriver().setup();
        EdgeDriver driver =new EdgeDriver();

        driver.get(website);
        driver.findElement(menu).click();
        driver.findElement(menuLogin).click();
        driver.findElement(username).sendKeys("John Doe");
        driver.findElement(password).sendKeys("ThisIsNotAPassword");
        driver.findElement(buttonLogin).click();
        String homepage = driver.findElement(makeAppointment).getText();
        System.out.println(homepage);
        Assertions.assertEquals("Make Appointment", homepage);
    }
}
