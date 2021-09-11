package com.orangehrm.Utilities;


//Listener class used to generate Extent reports

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import lombok.SneakyThrows;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;



public class Reporting extends TestListenerAdapter
{
    public ExtentSparkReporter spark;
    public ExtentReports extent;
    public ExtentTest logger;


    @SneakyThrows
    public void onStart(ITestContext testContext)
    {
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
        String repName="Test-Report-"+timeStamp+".html";

        spark=new ExtentSparkReporter("P:/TechStuffs/LetsKodeIt/inetbankingV1-master/OrangeHRMDemo" + "/test-output/"+repName);//specify location of the report
        spark.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");

        extent=new ExtentReports();

        extent.attachReporter(spark);
        extent.setSystemInfo("Host name","localhost");
        extent.setSystemInfo("Environemnt","QA");
        extent.setSystemInfo("user","Pooja");

        spark.config().setDocumentTitle("OrangeHRM Project"); // Tile of report
        spark.config().setReportName("Functional Test Automation Report"); // name of the report
     //   spark.config().setTestViewChartLocation(ChartLocation.TOP); //location of the chart
     //   spark.config().setAutoCreateRelativePathMedia(true);
        spark.config().setTheme(Theme.DARK);
    }

    public void onTestSuccess(ITestResult tr)
    {
        logger=extent.createTest(tr.getName()); // create new entry in th report
        logger.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN)); // send the passed information to the report with GREEN color highlighted
    }

    public void onTestFailure(ITestResult tr)
    {
        logger=extent.createTest(tr.getName()); // create new entry in th report
        logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED)); // send the passed information to the report with GREEN color highlighted

        String screenshotPath="P:/TechStuffs/LetsKodeIt/inetbankingV1-master/OrangeHRMDemo"+"/Screenshots/"+tr.getName()+".png";

        File f = new File(screenshotPath);

        if(f.exists())
        {
            logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
        }

    }

    public void onTestSkipped(ITestResult tr)
    {
        logger=extent.createTest(tr.getName()); // create new entry in th report
        logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
    }

    public void onFinish(ITestContext testContext)
    {
        extent.flush();
    }
}

