package pages;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.ScreenshotUtil;

public class Homepage {
    WebDriver driver;
    ScreenshotUtil ss = new ScreenshotUtil(driver);


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
        String homepage = driver.findElement(makeAppointment).getText();
        System.out.println(homepage);
        Assertions.assertEquals("Make Appointment", homepage);
        ss.takeScreenshotWithResizedHeight("homepage");
    }

    public void clickMakeAppointment() throws InterruptedException {
        Thread.sleep(1000);
        ss.takeScreenshotWithResizedHeight("Make Appointment");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-500)");
        Thread.sleep(1000);
        ss.takeScreenshotWithResizedHeight("Make Appointment");
        driver.findElement(buttonMakeAppointment).click();
    }

    public void goToMakeAppointment() throws InterruptedException {
        ss.takeScreenshotWithResizedHeight("Make Appointment");
        Thread.sleep(1000);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-500)");
        ss.takeScreenshotWithResizedHeight("Make Appointment");
        Thread.sleep(1000);
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
