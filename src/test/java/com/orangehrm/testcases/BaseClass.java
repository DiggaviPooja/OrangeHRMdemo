package com.orangehrm.testcases;

import com.orangehrm.Utilities.ReadConfig;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class BaseClass {

    ReadConfig rconfig = new ReadConfig();

    public static WebDriver driver;
    public String baseURL = rconfig.getApplicationURL();
    public String userName = rconfig.getUsername();
    public String password = rconfig.getPassword();
    //public static Logger logger;


    @BeforeClass
    public void setup() {

       // logger = LogManager.getLogger("orangeHRM");
        //PropertyConfigurator.configure("log4j.properties");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseURL);
       //   logger.info("Url is opened");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


    }

    @AfterClass
    public void tearDown() throws InterruptedException {
      //  Thread.sleep(5000);
        driver.quit();
    }

    public void captureScreen(WebDriver driver, String tname) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File target = new File("P:/TechStuffs/LetsKodeIt/inetbankingV1-master/OrangeHRMDemo" + "/Screenshots/" + tname + ".png");
        FileUtils.copyFile(source, target);
        System.out.println("Screenshot taken");
    }
}