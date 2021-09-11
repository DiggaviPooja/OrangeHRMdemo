package com.orangehrm.testcases;

import com.orangehrm.pageObject.ApplyLeavePage;
import com.orangehrm.pageObject.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_ApplyLeave_003 extends BaseClass {
    String text;

@Test
public void applyingLeave() throws IOException, InterruptedException {
    ApplyLeavePage leavePage = new ApplyLeavePage(driver);
    LoginPage lp=new LoginPage(driver);
    lp.setUserName(userName);
    logger.info("Entered username");
    lp.setPassword(password);
    logger.info("Entered password");
    lp.clickSubmit();
    logger.info("navigate to next page");
    leavePage.getAPplyLeave();
    logger.info("clicked on APply Leave");
    leavePage.getWarningMessage();
    logger.info("warning message is displayed");
    lp.clickLogout();
    logger.info("logged out");
    text= driver.getTitle();

    if(driver.getTitle().equals("OrangeHRM"))
    {
        Assert.assertTrue(true);
    }
    else
    {
        captureScreen(driver,"AppyLeave");
        Assert.assertTrue((false));
    }




}
}
