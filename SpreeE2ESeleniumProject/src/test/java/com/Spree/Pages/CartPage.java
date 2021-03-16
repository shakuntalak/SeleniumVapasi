package com.Spree.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class CartPage {

    WebDriver driver;

    @FindBy(id = "link-to-cart")
    private WebElement cartButton;

    @FindBy(id = "add-to-cart-button")
    private WebElement addToCartButton;

    @FindBy(linkText = "Ruby on Rails Mug")
    private WebElement productRubyOnRailsMug;

    @FindBy(xpath = "//td[@class='lead']")
    private WebElement totalCartAmount;

    @FindBy(css = "span[itemprop='price']")
    private WebElement itemPrice;

    @FindBy(id = "quantity")
    private WebElement itemQuantity;

    @FindBy(css = "div[class='alert alert-info']")
    private WebElement emptyCartMessageLink;

    @FindBy(xpath = "//*[@name='commit']")
    private WebElement emptyCartButton;

    // initialization
    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        }

        public String addProductToCart() {
        productRubyOnRailsMug.click();
        String getItemPrice=itemPrice.getText();
        addToCartButton.click();
        return getItemPrice;
        }

    public void addProductToCartultiple(String productQuantity) {
        productRubyOnRailsMug.click();
        itemQuantity.clear();
        itemQuantity.sendKeys(productQuantity);
        addToCartButton.click();
    }


         public void validateTotalCartOrderAmount(String itemPrice)  {
         String cartTotalAmount=totalCartAmount.getText();
         Assert.assertEquals(cartTotalAmount,itemPrice);
        }

        public void validateClearCart() throws InterruptedException {
            emptyCartButton.click();
            String validateText=emptyCartMessageLink.getText();
            System.out.println(validateText);
            Assert.assertEquals(validateText,"Your cart is empty");
        }


}
