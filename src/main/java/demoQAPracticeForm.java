import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;

public class demoQAPracticeForm {
    @Test
    public void demoQA() throws InterruptedException {
        WebDriverManager.edgedriver().setup();
        EdgeDriver driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/automation-practice-form");

        WebElement fixedban = driver.findElement(By.id("fixedban"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].parentNode.removeChild(arguments[0])", fixedban);

        //name
        driver.findElement(By.id("firstName")).sendKeys("Aditia Angga");
        driver.findElement(By.id("lastName")).sendKeys("Perdana");

        //email
        driver.findElement(By.id("userEmail")).sendKeys("aditia.perdana@test.id");

        js.executeScript("window.scrollBy(0,500)");

        //gender
        WebElement male = driver.findElement(By.xpath("//label[.='Male']"));
        boolean maleIsSelected = male.isSelected();
        if(maleIsSelected == false){
            male.click();
        }
        Thread.sleep(2000);
        //Mobile
        driver.findElement(By.id("userNumber")).sendKeys("0812345678");

        //Date of Birth
        driver.findElement(By.id("dateOfBirthInput")).click();

        Select year = new Select (driver.findElement(By.className("react-datepicker__year-select")));
        year.selectByVisibleText("1999");

        Select month = new Select (driver.findElement(By.className("react-datepicker__month-select")));
        month.selectByVisibleText("May");

        driver.findElement(By.cssSelector(".react-datepicker__day--022")).click();

        //Subject
        WebElement subject = driver.findElement(By.id("subjectsInput"));
        subject.sendKeys("E");
        Thread.sleep(1000);
        subject.sendKeys(Keys.ENTER);
        subject.sendKeys("E");
        Thread.sleep(1000);
        driver.findElement(By.id("react-select-2-option-5")).click();

        //hobbies
        WebElement sports = driver.findElement(By.xpath("//label[.='Sports']"));
        boolean sportsIsSelected = sports.isSelected();
        if(sportsIsSelected == false){
            sports.click();
        }

        WebElement reading = driver.findElement(By.xpath("//label[.='Reading']"));
        boolean readingIsSelected = reading.isSelected();
        if(readingIsSelected == false){
            reading.click();
        }

        //upload picture
        WebElement upload = driver.findElement(By.id("uploadPicture"));
        String dir = System.getProperty("user.dir") + "/picture/ktp sample.jpg";
        System.out.println(dir);
        upload.sendKeys(dir);

        //current address
        driver.findElement(By.id("currentAddress")).sendKeys("Gandaria Road");

        //dropdown state
        driver.findElement(By.id("state")).click();
        driver.findElement(By.xpath("//div[.='Uttar Pradesh']")).click();

        //dropdown city
        driver.findElement(By.id("city")).click();
        driver.findElement(By.xpath("//div[.='Lucknow']")).click();

        //delete footer
        WebElement footer = driver.findElement(By.tagName("footer"));
        js.executeScript("arguments[0].parentNode.removeChild(arguments[0])", footer);

        //submit
        driver.findElement(By.id("submit")).click();

        //Validate Submit
        WebElement validate = driver.findElement(By.id("example-modal-sizes-title-lg"));
        System.out.println(validate.getText());
        Assertions.assertEquals("Thanks for submitting the form",validate.getText());
    }
}
