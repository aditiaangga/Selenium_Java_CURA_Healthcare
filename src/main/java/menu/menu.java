package menu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class menu {
    @Test
    public void menu() {
        WebDriverManager.edgedriver().setup();
        EdgeDriver driver = new EdgeDriver();

        driver.get("https://demoqa.com/menu");

        WebElement fixedban = driver.findElement(By.id("fixedban"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].parentNode.removeChild(arguments[0])", fixedban);
        js.executeScript("window.scrollBy(0,300)");

        Actions act = new Actions(driver);
        WebElement mainItem1 = driver.findElement(By.xpath("//a[.='Main Item 1']"));
        mainItem1.isDisplayed();
        System.out.println(mainItem1.getText());

        WebElement mainItem2 = driver.findElement(By.xpath("//a[.='Main Item 2']"));
        mainItem2.isDisplayed();
        System.out.println(mainItem2.getText());

        WebElement mainItem3 = driver.findElement(By.xpath("//a[.='Main Item 3']"));
        mainItem3.isDisplayed();
        System.out.println(mainItem3.getText());

        act.moveToElement(mainItem2).perform();

        WebElement subItem1 = driver.findElement(By.xpath("//ul[@id='nav']//li[1]/a[.='Sub Item']"));
        subItem1.isDisplayed();
        System.out.println(subItem1.getText());

        WebElement subItem2 = driver.findElement(By.xpath("//ul[@id='nav']//li[2]/a[.='Sub Item']"));
        subItem2.isDisplayed();
        System.out.println(subItem2.getText());

        WebElement subSubList = driver.findElement(By.xpath("//a[.='SUB SUB LIST »']"));
        subSubList.isDisplayed();
        System.out.println(subSubList.getText());

        act.moveToElement(subSubList).perform();

        WebElement subSubItem1 = driver.findElement(By.xpath("//a[.='Sub Sub Item 1']"));
        subSubItem1.isDisplayed();
        System.out.println(subSubItem1.getText());

        WebElement subSubItem2 = driver.findElement(By.xpath("//a[.='Sub Sub Item 2']"));
        subSubItem2.isDisplayed();
        System.out.println(subSubItem2.getText());

    }
}
