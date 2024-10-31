package StepDef;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import pages.Appointment;
import pages.Homepage;
import pages.Login;
import utils.DriverManager;
import utils.ScreenshotUtil;


import java.io.File;
import java.io.IOException;

public class loginCURA {

    WebDriver driver = DriverManager.getDriver();
    ScreenshotUtil ss = new ScreenshotUtil(driver);
    Login login = new Login(driver);
    Homepage home = new Homepage(driver);

    @Given("User Open website CURA Healthcare with browser Edge")
    public void userOpenWebsiteCURAHealthcareWithBrowserEdge() throws IOException {
        driver.get("https://katalon-demo-cura.herokuapp.com/");
    }

    @When("User input username {string}, password {string} and Click Sign In")
    public void userInputUsernamePasswordAndClickSignIn(String user, String pass) throws IOException {
        login.clickMenuLogin();
        login.enterUsername(user);
        login.enterPassword(pass);
        ss.takeScreenshotWithResizedHeight("Login Page");
        login.clickLogin();
    }

    @Then("User verify Homepage")
    public void userVerifyHomepage() throws IOException {
        home.verifyHomepage();
    }

    @And("User Click Appointment")
    public void userClickAppointment() throws InterruptedException, IOException {
        home.clickMakeAppointment();
    }

    @And("User Go To Make Appointment")
    public void userGoToMakeAppointment() throws InterruptedException, IOException {
        home.goToMakeAppointment();
    }

    @And("User fill the Data {string}, {string}, {string}, {string} about Appointment")
    public void userFillTheDataAboutAppointment(String city, String hc, String date, String com) throws IOException {
        home.verifyHomepage();
        home.facility(city);
        home.hospitalReadmission();
        home.healthcareProgram(hc);
        ss.takeScreenshotWithResizedHeight("Fill The Data");
        home.date(date);
        home.comment(com);
        ss.takeScreenshotWithResizedHeight("Fill The Data");
        home.submitBookAppointment();
    }

    @Then("User verify Appointment")
    public void userVerifyAppointment() throws IOException {
        Appointment appointment = new Appointment(driver);
        appointment.verifyAppointment();
        ss.takeScreenshotWithResizedHeight("Appointment Confirmation");
    }

    @And("User fill the Date {string} about Appointment")
    public void userFillTheDateAboutAppointment(String date) throws IOException {
        home.verifyHomepage();
        home.date(date);
        ss.takeScreenshotWithResizedHeight("Fill The Data");
        home.submitBookAppointment();
    }

}
