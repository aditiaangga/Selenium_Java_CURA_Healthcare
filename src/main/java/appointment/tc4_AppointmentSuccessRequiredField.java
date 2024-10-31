package appointment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class tc4_AppointmentSuccessRequiredField {
    @Test
    public void AppointmentRequiredField(){

        String website = "https://katalon-demo-cura.herokuapp.com/";
        By menu = By.id("menu-toggle");
        By menuLogin = By.xpath("//a[.='Login']");
        By username = By.id("txt-username");
        By password = By.id("txt-password");
        By buttonLogin = By.id("btn-Login");
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
        assertEquals("Make Appointment", homepage);

        driver.findElement(By.id("txt_visit_date")).sendKeys("22/09/2022");
        driver.findElement(By.id("btn-book-appointment")).click();

        WebElement confirmation = driver.findElement(By.tagName("h2"));
        confirmation.isDisplayed();
        assertEquals("Appointment Confirmation", confirmation.getText());
    }
}
