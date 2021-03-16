package com.Spree.TestCase;

import com.Spree.Pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.Spree.Pages.LogoutPage;

import java.io.IOException;


public class LoginLogoutValidationTest extends BaseTest {

    public String emailId;
    public String password;


    @Test
    public void verifyLoginSuccessMessage() throws InterruptedException {

        emailId = "skaladagi@yahoo.com";
        password = "selenium123";
        String actualLoginSuccessMessage = "Logged in successfully";

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(emailId, password);

        String message = loginPage.getLoginSuccessMessage();
        System.out.println(message);
        //Assert.assertEquals(message,actualLoginSuccessMessage);

        Assert.assertTrue(loginPage.validationMessage(message, actualLoginSuccessMessage));

    }


    @Test
    public void verifyInvalidLoginMessage() throws InterruptedException {
        emailId = "skladagi@yahoo.com";
        password = "1234567";
        String message = "Invalid email or password.";
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(emailId, password);
        String actualLoginSuccessMessage = loginPage.getLoginInvalidMessage();


        Assert.assertTrue(loginPage.validationMessage(message, actualLoginSuccessMessage));

    }

    @Test
    public void verifyInvalidLoginMessageTooltip() throws InterruptedException {
        emailId = "sklahoo.com";
        password = "1234567";
        String message = "Please include an '@' in the email address. 'sklahoo.com' is missing an '@'.";
        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(emailId, password);

        String tooltipMessage = loginPage.getLoginInvalidMessageToolTip();
        System.out.println(tooltipMessage);

        Assert.assertTrue(loginPage.validationMessage(message, tooltipMessage));

    }


    @Test
    public void logout() throws IOException, InterruptedException {
        emailId = "skaladagi@yahoo.com";
        password = "selenium123";
        String actualLogoutSuccessMessage = "Signed out successfully.";

        LoginPage loginPage = new LoginPage(driver);

        loginPage.login(emailId, password);

        LogoutPage lout = new LogoutPage(driver);
        lout.clickLogoutButton();
        String message = lout.getLogoutSuccessMessage();

        Assert.assertTrue(loginPage.validationMessage(message, actualLogoutSuccessMessage));

    }
}