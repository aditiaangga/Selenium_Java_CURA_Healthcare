package appointment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class tc5_AppointmentFailedFieldEmpty {
    @Test
    public void AppointmentFieldEmpty(){

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


        WebElement buttonBook = driver.findElement(By.id("btn-book-appointment"));
        buttonBook.click();
        buttonBook.isDisplayed();

    }
}
