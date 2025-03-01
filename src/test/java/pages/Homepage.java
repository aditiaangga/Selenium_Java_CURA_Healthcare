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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Locale;

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

    public void verifyHomepage() throws InterruptedException {
        Thread.sleep(5000);
        waitForPageLoad();
        String homepage = waitForElementVisible(makeAppointment,10).getText();
        System.out.println(homepage);
        Assertions.assertEquals("Make Appointment", homepage);
        ss.takeScreenshotWithResizedHeight("homepage");
    }

    public void clickMakeAppointment() {
        waitForPageLoad();
        waitForElementVisible(makeAppointment, 10);
        ss.takeScreenshotWithResizedHeight("Make Appointment");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-500)");
        WebElement btnMakeAppointment = waitForElementVisible(buttonMakeAppointment,15);
        ss.takeScreenshotWithResizedHeight("Make Appointment");
        btnMakeAppointment.click();
    }

    public void goToMakeAppointment() throws InterruptedException {
        waitForPageLoad();
        waitForElementVisible(makeAppointment,10);
        ss.takeScreenshotWithResizedHeight("Make Appointment");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,-500)");
        ss.takeScreenshotWithResizedHeight("Make Appointment");
        waitForElementVisible(buttonMakeAppointment,10);
        js.executeScript("window.scrollBy(0,500)");
        ss.takeScreenshotWithResizedHeight("Make Appointment");
    }

    public void facility(String city){
        Select drpFacility = new Select(waitForElementVisible(By.id("combo_facility"),10));
        drpFacility.selectByValue(city+" CURA Healthcare Center");
    }

    public void hospitalReadmission(){
        WebElement checkbox = waitForElementVisible(hospitalReadmission,10);
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

    public void date(String date) throws InterruptedException {
//        waitForElementVisible(visitDate,10).sendKeys(date);
        // Set tanggal tertentu dalam format dd/MM/yyyy
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate targetDate = LocalDate.parse(date, formatter);

        // Ambil 3 huruf pertama dari nama bulan (contoh: "Feb" untuk February)
        String month = targetDate.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH).substring(0, 3);
        int year = targetDate.getYear();
        int day = targetDate.getDayOfMonth();

        waitForElementVisible(visitDate,10).click();
        waitForElementVisible(By.xpath("(//th[@class='datepicker-switch'])[1]"),10).click();
        waitForElementVisible(By.xpath("(//th[@class='datepicker-switch'])[2]"),10).click();
        waitForElementVisible(By.xpath("//span[.='"+year+"']"),10).click();
        waitForElementVisible(By.xpath("//span[.='"+month+"']"),10).click();
        waitForElementVisible(By.xpath("//td[.='"+day+"']"),10).click();
    }

    public void comment(String com){
        waitForElementVisible(comment,10).sendKeys(com);
    }

    public void submitBookAppointment(){
        waitForElementVisible(buttonBookAppointment,10).click();
    }

    public void emptyValidation(){
        WebElement visitDate = waitForElementVisible(By.name("visit_date"),10);
        Boolean isRequiredVisitDate = Boolean.valueOf(waitForElementVisible(By.name("visit_date"),10).getAttribute("required"));
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
        int retries = 0;
        int maxRetries = 5;  // Maksimum 5 kali percobaan

        while (retries < maxRetries) {
            try {
                WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
                return wait.until(ExpectedConditions.visibilityOfElementLocated(element));
            } catch (Exception e) {
                retries++;
                System.out.println("Percobaan ke-" + retries + ": Elemen belum terlihat, mencoba kembali...");

                if (retries == maxRetries) {
                    throw new RuntimeException("Gagal menemukan elemen setelah " + maxRetries + " percobaan.", e);
                }
            }
        }
        return null;
    }

    public void waitForPageLoad() {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
    }
}
