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
        String homepage = waitForElementVisible(makeAppointment,15).getText();
        System.out.println(homepage);
        Assertions.assertEquals("Make Appointment", homepage);
        ss.takeScreenshotWithResizedHeight("homepage");
    }

    public void clickMakeAppointment() {
        waitForElementVisible(makeAppointment, 15);
        ss.takeScreenshotWithResizedHeight("Make Appointment");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-500)");
        WebElement btnMakeAppointment = waitForElementVisible(buttonMakeAppointment,15);
        ss.takeScreenshotWithResizedHeight("Make Appointment");
        btnMakeAppointment.click();
    }

    public void goToMakeAppointment() throws InterruptedException {
        ss.takeScreenshotWithResizedHeight("Make Appointment");
        waitForElementVisible(makeAppointment,15);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-500)");
        ss.takeScreenshotWithResizedHeight("Make Appointment");
        waitForElementVisible(buttonMakeAppointment,15);
        js.executeScript("window.scrollBy(0,500)");
        ss.takeScreenshotWithResizedHeight("Make Appointment");
    }

    public void facility(String city){
        Select drpFacility = new Select(waitForElementVisible(By.id("combo_facility"),15));
        drpFacility.selectByValue(city+" CURA Healthcare Center");
    }

    public void hospitalReadmission(){
        WebElement checkbox = waitForElementVisible(hospitalReadmission,15);
        boolean isSelected = checkbox.isSelected();
        if(isSelected == false) {
            checkbox.click();
        }
    }

    public void healthcareProgram(String hc){
        WebElement radiobtn = waitForElementVisible(By.xpath("//input[@value='"+hc+"']"),15);
        boolean Selected = radiobtn.isSelected();
        if(Selected == false) {
            radiobtn.click();
        }
    }

    public void date(String date){
        waitForElementVisible(visitDate,15).sendKeys(date);
    }

    public void comment(String com){
        waitForElementVisible(comment,15).sendKeys(com);
    }

    public void submitBookAppointment(){
        waitForElementVisible(buttonBookAppointment,15).click();
    }

    public void emptyValidation(){
        WebElement visitDate = waitForElementVisible(By.name("visit_date"),15);
        Boolean isRequiredVisitDate = Boolean.valueOf(waitForElementVisible(By.name("visit_date"),15).getAttribute("required"));
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

    public WebElement waitForElementVisible(By element, int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }
}
