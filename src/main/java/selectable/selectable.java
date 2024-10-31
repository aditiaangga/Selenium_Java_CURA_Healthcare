package selectable;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.Color;

public class selectable {
    @Test
    public void selectable() {
        WebDriverManager.edgedriver().setup();
        EdgeDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/selectable");

        WebElement fixedban = driver.findElement(By.id("fixedban"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].parentNode.removeChild(arguments[0])", fixedban);
        js.executeScript("window.scrollBy(0,300)");

        WebElement list1 = driver.findElement(By.xpath("//li[.='Cras justo odio']"));
        String textList1 = list1.getText();
        String bgColorBefore1 = list1.getCssValue("background-color");
        String hexBGColorBefore1 = Color.fromString(bgColorBefore1).asHex();
        System.out.println("Before Click: ");
        System.out.println(textList1);
        System.out.println(bgColorBefore1);
        System.out.println(hexBGColorBefore1);
        Assertions.assertEquals(hexBGColorBefore1, "#ffffff");

        list1.click();

        String bgColorAfter1 = list1.getCssValue("background-color");
        String hexBGColorAfter1 = Color.fromString(bgColorAfter1).asHex();
        System.out.println("After Click: ");
        System.out.println(bgColorAfter1);
        System.out.println(hexBGColorAfter1);
        Assertions.assertEquals(hexBGColorAfter1, "#007bff");

        WebElement list3 = driver.findElement(By.xpath("//li[.='Morbi leo risus']"));
        String textList3 = list3.getText();
        String bgColorBefore3 = list3.getCssValue("background-color");
        String hexBGColorBefore3 = Color.fromString(bgColorBefore3).asHex();
        System.out.println("Before Click: ");
        System.out.println(textList3);
        System.out.println(bgColorBefore3);
        System.out.println(hexBGColorBefore3);
        Assertions.assertEquals(hexBGColorBefore3, "#ffffff");

        list3.click();

        String bgColorAfter3 = list3.getCssValue("background-color");
        String hexBGColorAfter3 = Color.fromString(bgColorAfter3).asHex();
        System.out.println("After Click: ");
        System.out.println(bgColorAfter3);
        System.out.println(hexBGColorAfter3);
        Assertions.assertEquals(hexBGColorAfter3, "#007bff");
    }
}
