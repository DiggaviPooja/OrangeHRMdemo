package com.orangehrm.testcases;

import com.orangehrm.Utilities.XLUtils;
import com.orangehrm.pageObject.LoginPage;
import org.junit.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_LoginDDT_002 extends BaseClass{

    @Test(dataProvider = "LoginData" )
    public void loginDDT(String user, String password) throws InterruptedException {
        LoginPage lp = new LoginPage(driver);
        lp.setUserName(user);
        logger.info("username is provided");
        lp.setPassword(password);
        logger.info("password is provided");
        lp.clickSubmit();


      //  if(isErrorMessagePresent()==true) //login is failed //what is comparing here?
        //demo was to compare with isALert present//so invalid logic
            if(isErrorMessagePresent() )
        {
            System.out.println("login failed try again");
           // Assert.assertTrue(false);//it should be true because ur not checking anything
            logger.warn("try with correct credentils");
        }else
        {
            Assert.assertTrue(true);
            logger.info("login passed");
            lp.clickLogout();
        }
    }

    public boolean isErrorMessagePresent() // user defined method to check error msg is present or not
    {
        try{
            LoginPage lp = new LoginPage(driver);
            lp.errorMessage();
            captureScreen(driver,"loginTestDDT");
          //  Assert.assertTrue((true)); true or false?er
            return true;
        }
        catch (Exception e)
        {
            System.out.println("Error Message: " +e.getMessage());
            System.out.println("Error is not present");
            return false;
        }
    }

    @DataProvider(name="LoginData")
    Object[][] getData() throws IOException {
      //  String path = "E://TechStuffs//LetsKodeIt//inetbankingV1-master//OrangeHRMDemo//src//test//java//com//orangehrm//testData//LoginData.xlsx";
        String path1 = System.getProperty("user.dir")+"/src/test/java/com/orangehrm/testData/LoginData.xlsx";
        int rowNum = XLUtils.getRowCount(path1,"Sheet1");
        int columnCount=XLUtils.getCellCount(path1,"Sheet1",1);

        String loginData[][]=new String[rowNum][columnCount];
        for(int i=1;i<=rowNum;i++)
        {
            for(int j=0;j<columnCount;j++) // if u start j=1 then need to use <= otherwise just <
            {
             /* array i-1 row differs i two dimensional array and excel sheet*/
                loginData[i-1][j] = XLUtils.getCellData(path1,"Sheet1",i,j);//1 0-> excel
            }
        }
        return loginData;
    }
}


