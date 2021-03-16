package com.Spree.TestCase;

import com.Spree.Pages.CartPage;
import com.Spree.Pages.HomePage;
import org.testng.annotations.Test;

public class CheckoutOrderAmountValidationTest extends BaseTest {
    @Test
    public void verifyCheckoutOrderAmount() {

            String searchText="Ruby on Rails Mug";
            HomePage homePage = new HomePage(driver);
            homePage.searchItem(searchText);
            CartPage cartPage=new CartPage(driver);
            String itemPrice=cartPage.addProductToCart();
            cartPage.validateTotalCartOrderAmount(itemPrice);
        }

    }


