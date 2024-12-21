package StepDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import utils.DriverManager;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;

public class Hooks {
    WebDriver driver;
    private static Scenario currentScenario;

    @Before
    public void browserSetup(Scenario scenario){
//        WebDriverManager.edgedriver().setup();
//        driver = new EdgeDriver();
        System.setProperty("webdriver.edge.driver", "driver/msedgedriver.exe");

        EdgeOptions options = new EdgeOptions();
        options.addArguments("--remote-debugging-port=0"); // Hindari konflik port
        options.addArguments("--disable-dev-shm-usage");  // Kurangi penggunaan shared memory
        options.addArguments("--no-sandbox");            // Hindari sandbox (untuk debugging)
        options.addArguments("--headless=new");          // Jalankan di mode headless (opsional)

        driver = new EdgeDriver(options);
        DriverManager.setDriver(driver);
        currentScenario = scenario;
    }


    public static Scenario getCurrentScenario() {
        return currentScenario; // Mengambil Scenario dari variabel statis
    }


    @After(order = 1)
    public void tearDown(){
        driver.close();
        driver.quit();
    }

    @After
    public void takeScreenshotFinal(Scenario scenario) {
        try {
            WebDriver driver = DriverManager.getDriver();
            if (driver != null) {
                File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

                // Baca screenshot sebagai BufferedImage
                BufferedImage originalImage = ImageIO.read(screenshotFile);

                // Ambil ukuran asli gambar
                int originalWidth = originalImage.getWidth();
                int originalHeight = originalImage.getHeight();

                // Hitung lebar baru berdasarkan rasio aspek
                int newHeight = 700;
                int newWidth = (int) ((double) originalWidth / originalHeight * newHeight);

                // Buat image dengan ukuran yang diinginkan
                BufferedImage resizedImage = new BufferedImage(newWidth, newHeight, originalImage.getType());
                Graphics2D g2d = resizedImage.createGraphics();
                g2d.drawImage(originalImage, 0, 0, newWidth, newHeight, null);
                g2d.dispose();

                // Konversi resized image ke byte array
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ImageIO.write(resizedImage, "png", baos);
                byte[] resizedScreenshot = baos.toByteArray();

                // Lampirkan screenshot yang sudah diubah ukurannya ke skenario
//                scenario.attach(resizedScreenshot, "image/png", "Hooks");
                if (scenario.isFailed()) {
                    scenario.attach(resizedScreenshot, "image/png", "Failed Screenshot");
                    System.out.println("Screenshot taken for failed scenario: " + scenario.getName());
                } else {
                    // Opsional: ambil screenshot jika skenario berhasil
                    scenario.attach(resizedScreenshot, "image/png", "Passed Screenshot");
                    System.out.println("Screenshot taken for passed scenario: " + scenario.getName());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
