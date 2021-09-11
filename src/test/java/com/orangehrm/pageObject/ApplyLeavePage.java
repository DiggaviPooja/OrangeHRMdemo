package com.orangehrm.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApplyLeavePage {

    WebDriver adriver;
    //JavascriptExecutor js = (JavascriptExecutor) adriver; //no need

    public ApplyLeavePage(WebDriver aldriver) {
        this.adriver = aldriver;
        PageFactory.initElements(aldriver, this);
    }

    @FindBy(xpath = "//a[@href='/index.php/leave/applyLeave']/img")
    @CacheLookup
    WebElement applyLeave;

    @FindBy(xpath = "//div[@class='message warning']")
    @CacheLookup
    WebElement warningMessage;


    public void getAPplyLeave() throws InterruptedException {
       // js.executeScript("arguments[0].click();",applyLeave); //no need
        Thread.sleep(2000);
        applyLeave.click();
    }

    public void getWarningMessage() {
        warningMessage.getText();
    }

  /*  public void goToHomePage() {

        String parentID = adriver.getWindowHandle();
        String parentTitle = adriver.switchTo().window(parentID).getTitle();
        System.out.println(parentTitle);
    }*/
}
