package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Appointment {
    WebDriver driver;


    public Appointment(WebDriver driver){
        this.driver = driver;
    }

    public void verifyAppointment(){
        WebElement confirmation = driver.findElement(By.id("summary"));
        confirmation.isDisplayed();
        System.out.println(confirmation.getText());
//        Assertions.assertEquals("Appointment Confirmation", confirmation.getText());
    }
}
