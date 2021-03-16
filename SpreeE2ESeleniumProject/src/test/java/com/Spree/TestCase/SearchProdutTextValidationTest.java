package com.Spree.TestCase;

import com.Spree.Pages.HomePage;
import org.testng.annotations.Test;

public class SearchProdutTextValidationTest extends BaseTest {
    @Test
    public void verifySearch() throws InterruptedException {

        String[] searchItems={"Ruby","Apache"};
        for(String searchText:searchItems) {
            HomePage homePage = new HomePage(driver);
            homePage.searchItem(searchText);
            homePage.verifySearchResult(searchText);
        }

    }

}
