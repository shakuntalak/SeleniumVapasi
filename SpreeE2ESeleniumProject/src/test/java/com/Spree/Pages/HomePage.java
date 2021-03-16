package com.Spree.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.util.List;

public class HomePage {

    WebDriver driver;

    @FindBy(id = "keywords")
    private WebElement searchText;

    @FindBy(id = "link-to-cart")
    private WebElement cartButton;

    @FindBy(css = "input[class='btn btn-success']")
    private WebElement searchButton;

    @FindBys(@FindBy(css = "span[title*='Ruby']"))
    private List<WebElement> rubySearchItems;

    @FindBys(@FindBy(xpath = "//span[@class='info']"))
    private List<WebElement> searchItems;


    @FindBys(@FindBy(css = "input[class='btn btn-success']"))
    private List<WebElement> apacheSearchItems;

    @FindBy(linkText = "Bags")
    private WebElement catagoryBags;

    @FindBy(id = "Price_Range_$15.00_-_$18.00")
    private WebElement priceRange15To18;

    @FindBy(xpath = "//input[@class='btn btn-primary']")
    private WebElement filterSearchButton;

    @FindBys(@FindBy(css = ".price.selling.lead"))
    private List<WebElement> filterSearchItems;

    // initialization
    public HomePage(WebDriver driver) {
       this.driver = driver;
       PageFactory.initElements(driver, this);
    }

    public void applyFilter15To18() {
       catagoryBags.click();
       priceRange15To18.click();
       filterSearchButton.click();
    }


      public void verifyFilterSearchResult(){
       for(int i=0;i<filterSearchItems.size();i++)
       {
          String price;
          price=filterSearchItems.get(i).getText();
          price=price.replace("$","");
          double itemPrice= Double.parseDouble(price);
          System.out.println(itemPrice);
          Assert.assertTrue(itemPrice>=15 && itemPrice<=18);
       }
    }


    public void searchItem(String item)
    {
       searchText.clear();
       searchText.sendKeys(item);
       searchButton.click();
    }

    public void verifySearchResult(String result)
    {
       String searchedText;
       for(int i=0;i<searchItems.size();i++)
       {
          searchedText=searchItems.get(i).getText();
          System.out.println(searchedText);
          Assert.assertTrue(searchedText.contains(result));
       }
    }



}