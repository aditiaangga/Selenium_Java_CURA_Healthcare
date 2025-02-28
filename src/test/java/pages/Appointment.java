package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Appointment {
    WebDriver driver;


    public Appointment(WebDriver driver){
        this.driver = driver;
    }

    public void verifyAppointment(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement confirmation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("summary")));
        confirmation.isDisplayed();
        System.out.println(confirmation.getText());
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
//        Assertions.assertEquals("Appointment Confirmation", confirmation.getText());
    }
}
