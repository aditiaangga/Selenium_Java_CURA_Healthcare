package PracticeForm;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class automationPracticeForm {
    @Test
    public void Form() throws InterruptedException {

        WebDriverManager.edgedriver().setup();
//        EdgeOptions options = new EdgeOptions();
//        options.addArguments("headless");
        EdgeDriver driver = new EdgeDriver();

//        driver.get("https://demoqa.com/automation-practice-form");
        driver.get("https://www.tutorialspoint.com/selenium/selenium_automation_practice.htm");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");

        driver.findElement(By.name("firstname")).sendKeys("Aditia Angga");
        driver.findElement(By.name("lastname")).sendKeys("Perdana");
        Thread.sleep(1000);

        WebElement male = driver.findElement(By.cssSelector("[value='Male']"));
        boolean maleIsSelected = male.isSelected();
        if(maleIsSelected == false){
            male.click();
        }

        WebElement years = driver.findElement(By.cssSelector("[value='3']"));
        boolean yearsIsSelected = years.isSelected();
        if(yearsIsSelected == false){
            years.click();
        }
        Thread.sleep(1000);
        driver.findElement(By.xpath("//tr[5]//input[1]")).sendKeys("5 June 2023");

        WebElement manual = driver.findElement(By.cssSelector("[value='Manual Tester']"));
        boolean manualIsSelected = manual.isSelected();
        if (manualIsSelected == false){
            manual.click();
        }

        WebElement automation = driver.findElement(By.cssSelector("[value='Automation Tester']"));
        boolean automationIsSelected = automation.isSelected();
        if (automationIsSelected == false){
            automation.click();
        }

        Thread.sleep(1000);

        WebElement upload = driver.findElement(By.name("photo"));
        String dir = System.getProperty("user.dir") + "/picture/ktp sample.jpg";
        System.out.println(dir);
        upload.sendKeys(dir);

        WebElement ide = driver.findElement(By.cssSelector("[value='Selenium IDE']"));
        boolean ideIsSelected = ide.isSelected();
        if (ideIsSelected == false){
            ide.click();
        }

        WebElement webdriver = driver.findElement(By.cssSelector("[value='Selenium Webdriver']"));
        boolean webdriverIsSelected = webdriver.isSelected();
        if (webdriverIsSelected == false){
            webdriver.click();
        }

        js.executeScript("window.scrollBy(0,300)");

        Select continent = new Select(driver.findElement(By.name("continents")));
        continent.selectByVisibleText("Asia");

        WebElement sc = driver.findElement(By.name("selenium_commands"));
        Select select = new Select(sc);

        select.selectByVisibleText("Browser Commands");
        select.selectByVisibleText("Navigation Commands");
        select.selectByVisibleText("WebElement Commands");

        List<WebElement> listOfOptions = select.getAllSelectedOptions();
        for (WebElement obj : listOfOptions){
            System.out.println(obj.getText());
        }
        Thread.sleep(1000);
        driver.findElement(By.name("submit")).click();
        driver.switchTo().alert().accept();
    }
}
