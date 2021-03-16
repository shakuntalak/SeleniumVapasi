package com.Spree.TestCase;

import com.Spree.Pages.CartPage;
import com.Spree.Pages.HomePage;
import org.testng.annotations.Test;

public class ClearCartValidationTest extends BaseTest {
    @Test
    public void verifyCheckoutOrderAmount() throws InterruptedException {

            String searchText="Ruby on Rails Mug";
            HomePage homePage = new HomePage(driver);
            homePage.searchItem(searchText);
            CartPage cartPage=new CartPage(driver);
            cartPage.addProductToCartultiple("3");
            cartPage.validateClearCart();
        }

    }


