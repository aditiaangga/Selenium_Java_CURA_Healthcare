package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.ScreenshotUtil;

import java.time.Duration;

public class Homepage {
    WebDriver driver;
    ScreenshotUtil ss = new ScreenshotUtil(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));


    public Homepage(WebDriver driver){
        this.driver = driver;
    }
    By makeAppointment = By.tagName("h2");
    By buttonMakeAppointment = By.id("btn-make-appointment");
    By hospitalReadmission = By.id("chk_hospotal_readmission");
    By visitDate = By.id("txt_visit_date");
    By comment = By.id("txt_comment");
    By buttonBookAppointment = By.id("btn-book-appointment");

    public void verifyHomepage(){
        WebElement hp = wait.until(ExpectedConditions.visibilityOfElementLocated(makeAppointment));
        String homepage = hp.getText();
        System.out.println(homepage);
        Assertions.assertEquals("Make Appointment", homepage);
        ss.takeScreenshotWithResizedHeight("homepage");
    }

    public void clickMakeAppointment() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(makeAppointment));
        ss.takeScreenshotWithResizedHeight("Make Appointment");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-500)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonMakeAppointment));
        ss.takeScreenshotWithResizedHeight("Make Appointment");
        btnMakeAppointment.click();
    }

    public void goToMakeAppointment() throws InterruptedException {
        ss.takeScreenshotWithResizedHeight("Make Appointment");
        wait.until(ExpectedConditions.visibilityOfElementLocated(makeAppointment));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-500)");
        ss.takeScreenshotWithResizedHeight("Make Appointment");
        wait.until(ExpectedConditions.visibilityOfElementLocated(buttonMakeAppointment));
        js.executeScript("window.scrollBy(0,500)");
        ss.takeScreenshotWithResizedHeight("Make Appointment");
    }

    public void facility(String city){
        Select drpFacility = new Select(driver.findElement(By.id("combo_facility")));
        drpFacility.selectByValue(city+" CURA Healthcare Center");
    }

    public void hospitalReadmission(){
        WebElement checkbox = driver.findElement(hospitalReadmission);
        boolean isSelected = checkbox.isSelected();
        if(isSelected == false) {
            checkbox.click();
        }
    }

    public void healthcareProgram(String hc){
        WebElement radiobtn = driver.findElement(By.xpath("//input[@value='"+hc+"']"));
        boolean Selected = radiobtn.isSelected();
        if(Selected == false) {
            radiobtn.click();
        }
    }

    public void date(String date){
        driver.findElement(visitDate).sendKeys(date);
    }

    public void comment(String com){
        driver.findElement(comment).sendKeys(com);
    }

    public void submitBookAppointment(){
        driver.findElement(buttonBookAppointment).click();
    }

    public void emptyValidation(){
        WebElement visitDate = driver.findElement(By.name("visit_date"));
        Boolean isRequiredVisitDate = Boolean.valueOf(driver.findElement(By.name("visit_date")).getAttribute("required"));
        //visitDate.getAttribute("required");
        System.out.println(isRequiredVisitDate);
        visitDate.isDisplayed();
        String getTextVisitDate = visitDate.getText();
        Assertions.assertEquals(getTextVisitDate , "");
        Assertions.assertEquals(isRequiredVisitDate , "true");
//        Assertions.assertEquals(getTextVisitDate , "test");
        String message = visitDate.getAttribute("validationMessage");
        System.out.println("message : " + message);
        ss.takeScreenshotWithResizedHeight("Empty Validation");
    }
}
