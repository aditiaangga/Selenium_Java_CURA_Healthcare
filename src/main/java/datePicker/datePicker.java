package datePicker;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class datePicker {
    @Test
    public void datePicker() {
        WebDriverManager.edgedriver().setup();
        EdgeDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/date-picker");

        WebElement fixedban = driver.findElement(By.id("fixedban"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].parentNode.removeChild(arguments[0])", fixedban);
        js.executeScript("window.scrollBy(0,300)");

        driver.findElement(By.id("datePickerMonthYearInput")).click();

        Select year = new Select (driver.findElement(By.className("react-datepicker__year-select")));
        year.selectByVisibleText("1997");

        Select month = new Select (driver.findElement(By.className("react-datepicker__month-select")));
        month.selectByVisibleText("May");

        driver.findElement(By.cssSelector(".react-datepicker__day--014")).click();

        driver.findElement(By.id("dateAndTimePickerInput")).click();
        driver.findElement(By.className("react-datepicker__year-read-view--selected-year")).click();
        WebElement previous = driver.findElement(By.xpath("//div[13]"));
        for (int i = 0; i < 10; i++) { //looping 10 times
            previous.click();
        }
        driver.findElement(By.xpath("//div[.='2015']")).click();

        driver.findElement(By.className("react-datepicker__month-read-view--down-arrow")).click();
        driver.findElement(By.xpath("//div[.='May']")).click();

        driver.findElement(By.cssSelector(".react-datepicker__day--014")).click();

        driver.findElement(By.xpath("//li[.='13:45']")).click();
    }
}
