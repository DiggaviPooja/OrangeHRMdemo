package com.orangehrm.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

      WebDriver ldriver;

    public LoginPage(WebDriver rdriver)
        {
            ldriver = rdriver;
            PageFactory.initElements(rdriver, this);
        }

        @FindBy(id = "txtUsername")
        @CacheLookup
        WebElement txtUserName;

        @FindBy(id = "txtPassword")
        @CacheLookup
        WebElement txtPassword;

        @FindBy(id = "btnLogin")
        @CacheLookup
        WebElement btnLogin;

        /*@FindBy(xpath = "//a[text() ='Welcome Fname']")
        @CacheLookup
        WebElement lnkLogout;*/

        //or
    @FindBy(id="welcome")
    @CacheLookup
    WebElement lnkLogout;

    @FindBy(xpath="//a[text()='Logout']")
    @CacheLookup
    WebElement aLogout;

    @FindBy(id="spanMessage")
    @CacheLookup
    WebElement inavlidCred;


        public void setUserName (String uname)
        {
            txtUserName.sendKeys(uname);
        }

        public void setPassword (String pwd)
        {
            txtPassword.sendKeys(pwd);
        }
        public void errorMessage()
        {inavlidCred.getText();
        System.out.println("login failed here: " +inavlidCred.getText());}


        public void clickSubmit ()
        {
            btnLogin.click();
        }

        public void clickLogout () throws InterruptedException {
            Thread.sleep(1000);
            lnkLogout.click();
        //    Select sel = new Select(lnkLogout);
            Thread.sleep(2000);
            System.out.println("selecting by Visible text");
           // sel.selectByVisibleText("Logout");
            aLogout.click();

        }
    }

