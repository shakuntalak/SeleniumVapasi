package com.Spree.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    WebDriver driver;
   //declaration
    @FindBy(id = "spree_user_email")
    private WebElement emailField;

    @FindBy(css = "[type='password']")
    private WebElement passwordField;

    @FindBy(id = "spree_user_remember_me")
    private WebElement rememberMeCheckbox;

    @FindBy(xpath = "//input[@value='Login']")
    private WebElement submitLoginButton;

    @FindBy(xpath = "//*[text()='Logged in successfully']")
    private WebElement loginSuccessMessage;

    @FindBy(xpath = "//*[text()='Invalid email or password.']")
    private WebElement loginInvalidMessage;

    @FindBy(id = "link-to-login")
    private WebElement loginButtonLink;

    @FindBy(id = "spree_user_email")
    private WebElement email;

  // initialization
  public LoginPage(WebDriver driver) {
      this.driver= driver;
      PageFactory.initElements(driver, this);
}

    public LoginPage() {

    }

    //utilization
    public boolean validationMessage(String message, String actualMessage)
    {
        if(message.equalsIgnoreCase(actualMessage))
            return true;
        else
            return false;
    }



    public void login(String emailId, String password) throws InterruptedException {
        loginButtonLink.click();
        emailField.sendKeys(emailId);
        passwordField.sendKeys(password);
        submitLoginButton.click();
    }

    public String getLoginSuccessMessage() {
        String successMessage = loginSuccessMessage.getText();
        System.out.println(successMessage);
        return successMessage;
    }

    public String getLoginInvalidMessage(){
        String successMessage = loginInvalidMessage.getText();
        System.out.println(successMessage);
        return successMessage;
    }

    public String getLoginInvalidMessageToolTip(){
        String tooltipMessage = email.getAttribute("validationMessage");
        return tooltipMessage;
    }

    public void setEmail(String email) {
        emailField.sendKeys(email);
    }
    public void setPassword(String password) {
        passwordField.sendKeys(password);
    }
    public void checkRememberMe() {
        rememberMeCheckbox.click();
    }
    public void clickLoginButton() {
        submitLoginButton.click();
    }
    public void clickRememberMe(){
        if (rememberMeCheckbox.isSelected()) {
            System.out.println("Remember me checkbox is already selected");
        }
        else{
            System.out.println("checking remember me checkbox now");
            rememberMeCheckbox.click();
        }

    }

    public void testLoginIssue(){
        System.out.println("testLogin Issue -----------------");
    }
}
