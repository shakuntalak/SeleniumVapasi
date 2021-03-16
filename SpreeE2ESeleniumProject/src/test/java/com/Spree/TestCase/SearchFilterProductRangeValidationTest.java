package com.Spree.TestCase;

import com.Spree.Pages.HomePage;
import org.testng.annotations.Test;

public class SearchFilterProductRangeValidationTest extends BaseTest {
    @Test
    public void verifyFilterSearchProdutRange() throws InterruptedException {
            HomePage homePage = new HomePage(driver);
            homePage.applyFilter15To18();
            homePage.verifyFilterSearchResult();
        }

    }


