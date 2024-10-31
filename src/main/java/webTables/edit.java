package webTables;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class edit {
    @Test
    public void edit(){
        WebDriverManager.edgedriver().setup();
        EdgeDriver driver = new EdgeDriver();

        driver.get("https://demoqa.com/webtables");

        WebElement fixedban = driver.findElement(By.id("fixedban"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].parentNode.removeChild(arguments[0])", fixedban);

        WebElement edit1 = driver.findElement(By.id("edit-record-1"));
        jsExecutor.executeScript("arguments[0].scrollIntoView();", edit1);

        WebElement cierra = driver.findElement(By.xpath("//div[.='Cierra']"));
        cierra.isDisplayed();
        if(cierra.getText().equals("Cierra")){
            edit1.click();

            WebElement firstname = driver.findElement(By.id("firstName"));
            firstname.clear();
            firstname.sendKeys("Aditia");

            WebElement lastname = driver.findElement(By.id("lastName"));
            lastname.clear();
            lastname.sendKeys("Perdana");

            WebElement email = driver.findElement(By.id("userEmail"));
            email.clear();
            email.sendKeys("aditia.perdana@test.id");

            WebElement age = driver.findElement(By.id("age"));
            age.clear();
            age.sendKeys("26");

            WebElement salary = driver.findElement(By.id("salary"));
            salary.clear();
            salary.sendKeys("1000");

            WebElement department = driver.findElement(By.id("department"));
            department.clear();
            department.sendKeys("IT");

            driver.findElement(By.id("submit")).click();
            driver.findElement(By.xpath("//div[.='Aditia']")).isDisplayed();
        }




    }
}
