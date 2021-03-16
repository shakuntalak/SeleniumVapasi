package com.Spree.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
    @FindBy(xpath = "//a[contains(text(),'Logout')]")
    private WebElement submitLogoutButton;
    @FindBy(xpath = "//*[text()='Signed out successfully.']")
    private WebElement logoutSuccessMessage;

    // initialization
    public LogoutPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    //utilization
    public void clickLogoutButton() {
        submitLogoutButton.click();
    }
    public String getLogoutSuccessMessage(){
        String successMessage = logoutSuccessMessage.getText();
        return successMessage;
    }
}
