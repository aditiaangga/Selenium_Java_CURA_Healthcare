package checkbox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class checkbox {
    @Test
    public void checkbox() {
        By toggleHome = By.xpath("//label[@for='tree-node-home']/preceding-sibling::button");
        By toggleDesktop = By.xpath("//label[@for='tree-node-desktop']/preceding-sibling::button");
        By toggleDocuments = By.xpath("//label[@for='tree-node-documents']/preceding-sibling::button");
        By toggleDownloads = By.xpath("//label[@for='tree-node-downloads']/preceding-sibling::button");
        By toggleWorkspace = By.xpath("//label[@for='tree-node-workspace']/preceding-sibling::button");
        By toggleOffice = By.xpath("//label[@for='tree-node-office']/preceding-sibling::button");
        By Home = By.xpath("//label[@for='tree-node-home']");
        By expandAll = By.xpath("//button[@title='Expand all']");
        By collapseAll = By.xpath("//button[@title='Collapse all']");
        By desktop = By.xpath("//label[@for='tree-node-desktop']");
        By documents = By.xpath("//label[@for='tree-node-documents']");
        By downloads = By.xpath("//label[@for='tree-node-downloads']");
        By notes = By.xpath("//label[@for='tree-node-notes']");
        By commands = By.xpath("//label[@for='tree-node-commands']");
        By workspace = By.xpath("//label[@for='tree-node-workspace']");
        By office = By.xpath("//label[@for='tree-node-office']");
        By wordFile = By.xpath("//label[@for='tree-node-wordFile']");
        By excelFile = By.xpath("//label[@for='tree-node-excelFile']");

        WebDriverManager.edgedriver().setup();
        EdgeDriver driver = new EdgeDriver();

        driver.get("https://demoqa.com/checkbox");

        WebElement fixedban = driver.findElement(By.id("fixedban"));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].parentNode.removeChild(arguments[0])", fixedban);
        jsExecutor.executeScript("window.scrollBy(0,200)");

        //checklist Home with Expand all and Collapse all
        driver.findElement(Home).click();
        WebElement resultHome = driver.findElement(By.id("result"));
        System.out.println("Checklist Home:\n"+resultHome.getText()+"\n");
        driver.findElement(expandAll).click();
        driver.findElement(collapseAll).click();
        driver.findElement(Home).click();

        //checklist Desktop
        driver.findElement(toggleHome).click();
        driver.findElement(desktop).click();
        WebElement resultDesktop = driver.findElement(By.id("result"));
        System.out.println("Checklist Desktop:\n"+resultDesktop.getText()+"\n");
        driver.findElement(toggleDesktop).click();
        driver.findElement(toggleDesktop).click();
        driver.findElement(desktop).click();

        //checklist Documents
        driver.findElement(documents).click();
        WebElement resultDocuments = driver.findElement(By.id("result"));
        System.out.println("Checklist Documents:\n"+resultDocuments.getText()+"\n");
        driver.findElement(toggleDocuments).click();
        driver.findElement(toggleDocuments).click();
        driver.findElement(documents).click();

        //checklist Downloads
        driver.findElement(downloads).click();
        WebElement resultDownloads = driver.findElement(By.id("result"));
        System.out.println("Checklist Downloads:\n"+resultDownloads.getText()+"\n");
        driver.findElement(toggleDownloads).click();
        driver.findElement(toggleDownloads).click();
        driver.findElement(downloads).click();

        //checklist Notes
        driver.findElement(toggleDesktop).click();
        driver.findElement(notes).click();
        WebElement resultNotes = driver.findElement(By.id("result"));
        System.out.println("Checklist Notes:\n"+resultNotes.getText()+"\n");
        driver.findElement(notes).click();

        //checklist Commands
        driver.findElement(commands).click();
        WebElement resultCommands = driver.findElement(By.id("result"));
        System.out.println("Checklist Commands:\n"+resultCommands.getText()+"\n");
        driver.findElement(commands).click();
        driver.findElement(toggleDesktop).click();

        //checklist WorkSpace
        driver.findElement(toggleDocuments).click();
        driver.findElement(workspace).click();
        WebElement resultWorkSpace = driver.findElement(By.id("result"));
        System.out.println("Checklist WorkSpace:\n"+resultWorkSpace.getText()+"\n");
        driver.findElement(toggleWorkspace).click();
        driver.findElement(workspace).click();
        driver.findElement(toggleWorkspace).click();

        //checklist Office
        driver.findElement(office).click();
        WebElement resultOffice = driver.findElement(By.id("result"));
        System.out.println("Checklist Office:\n"+resultOffice.getText()+"\n");
        driver.findElement(toggleOffice).click();
        driver.findElement(office).click();
        driver.findElement(toggleOffice).click();

        //checklist WordFile
        driver.findElement(toggleDownloads).click();
        driver.findElement(wordFile).click();
        WebElement resultWordFile = driver.findElement(By.id("result"));
        System.out.println("Checklist WordFile:\n"+resultWordFile.getText()+"\n");
        driver.findElement(wordFile).click();

        //checklist ExcelFile
        driver.findElement(excelFile).click();
        WebElement resultExcelFile = driver.findElement(By.id("result"));
        System.out.println("Checklist ExcelFile:\n"+resultExcelFile.getText()+"\n");
        driver.findElement(excelFile).click();
    }
}
