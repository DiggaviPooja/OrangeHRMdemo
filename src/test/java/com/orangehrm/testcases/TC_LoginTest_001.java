package com.orangehrm.testcases;

import com.orangehrm.pageObject.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_LoginTest_001 extends BaseClass{

    String text;

    @Test
    public void loginTest() throws IOException, InterruptedException {
        LoginPage lp=new LoginPage(driver);
        lp.setUserName(userName);
        logger.info("Entered username");
        lp.setPassword(password);
        logger.info("Entered password");
        lp.clickSubmit();
        logger.info("logged in");
        lp.clickLogout();
        logger.info("logged out");
        text= driver.getTitle();

        if(driver.getTitle().equals("OrangeHRM"))
        {
            Assert.assertTrue(true);
        }
        else
        {
            captureScreen(driver,"loginTest");
            Assert.assertTrue((false));
        }
    }
}
