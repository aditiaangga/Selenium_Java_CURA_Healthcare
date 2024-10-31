package appointment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class tc3_AppointmentSuccessAllField {
    @Test
    public void AppointmentAllField(){

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
        Assertions.assertEquals("Make Appointment", homepage);

        Select drpFacility = new Select(driver.findElement(By.id("combo_facility")));
        drpFacility.selectByValue("Tokyo CURA Healthcare Center");

        WebElement checkbox = driver.findElement(By.id("chk_hospotal_readmission"));
        boolean isSelected = checkbox.isSelected();
        if(isSelected == false) {
            checkbox.click();
        }

        WebElement radiobtn = driver.findElement(By.xpath("//label[contains(.,'Medicare')]"));
        boolean Selected = radiobtn.isSelected();
        if(Selected == false) {
            radiobtn.click();
        }

        driver.findElement(By.id("txt_visit_date")).sendKeys("20/09/2022");
        driver.findElement(By.id("txt_comment")).sendKeys("Thank You");
        driver.findElement(By.id("btn-book-appointment")).click();

        WebElement confirmation = driver.findElement(By.tagName("h2"));
        confirmation.isDisplayed();
        Assertions.assertEquals("Appointment Confirmation", confirmation.getText());
    }
}
