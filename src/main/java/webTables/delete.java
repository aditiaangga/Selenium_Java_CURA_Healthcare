package webTables;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class delete {
    @Test
    public void delete(){
        WebDriverManager.edgedriver().setup();
        EdgeDriver driver = new EdgeDriver();

        driver.get("https://demoqa.com/webtables");

        WebElement fixedban = driver.findElement(By.id("fixedban"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].parentNode.removeChild(arguments[0])", fixedban);

        WebElement delete1 = driver.findElement(By.id("delete-record-1"));
        WebElement delete2 = driver.findElement(By.id("delete-record-2"));
        WebElement delete3 = driver.findElement(By.id("delete-record-3"));
        jsExecutor.executeScript("arguments[0].scrollIntoView();", delete1);

        WebElement firstname = driver.findElement(By.xpath("//div[.='Alden']"));
        firstname.isDisplayed();
        if(firstname.getText().equals("Cierra")){
            delete1.click();
            Assertions.assertNotEquals("Cierra", firstname.getText());
        }
        else if (firstname.getText().equals("Alden")) {
            delete2.click();
            Assertions.assertNotEquals("Alden", firstname.getText());
        }
        else {
            delete3.click();
        }
    }
}
