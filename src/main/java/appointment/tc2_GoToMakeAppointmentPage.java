package appointment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.edge.EdgeDriver;

public class tc2_GoToMakeAppointmentPage {
    @Test
    public void MakeAppointmentPage() throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        EdgeDriver driver =new EdgeDriver();

        driver.get("https://katalon-demo-cura.herokuapp.com/");
        driver.findElement(By.id("menu-toggle")).click();
        driver.findElement(By.xpath("//a[.='Login']")).click();
        driver.findElement(By.id("txt-username")).sendKeys("John Doe");
        driver.findElement(By.id("txt-password")).sendKeys("ThisIsNotAPassword");
        driver.findElement(By.id("btn-Login")).click();
        String homepage = driver.findElement(By.tagName("h2")).getText();
        System.out.println(homepage);
        Assertions.assertEquals("Make Appointment", homepage);

        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-500)");
        Thread.sleep(1000);
        js.executeScript("window.scrollBy(0,500)");


    }
}
