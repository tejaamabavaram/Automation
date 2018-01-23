package com.venkat_ajio.tests;

import org.testng.annotations.Test;

import com.qmetry.qaf.automation.ui.WebDriverTestCase;
import com.venkat_ajio.pages.HomeTestPage;
import com.venkat_ajio.pages.ProductDetailsTestPage;
import com.venkat_ajio.pages.SearchResultsTestPage;

public class AjioProductOrderSteps extends WebDriverTestCase {
	@Test
	public void testProductOrderSteps() throws InterruptedException
	{
		/* Homepage object creation and acess methods*/
		HomeTestPage homepage = new HomeTestPage();
		homepage.launchApplication();
		homepage.clickPopup();
		homepage.selectCategory("MEN", "Shirts");
		
		SearchResultsTestPage searchresultspage = new SearchResultsTestPage();
		searchresultspage.selectGrid("five-grid");
		searchresultspage.selectSortByValue("Price (highest first)");
		//searchresultspage.selectbrandItem("AJIO");
		searchresultspage.verifyProduct();
		searchresultspage.selectProduct(0);
		
		
		ProductDetailsTestPage productdetailspage = new ProductDetailsTestPage();
		productdetailspage.verifyProductDetailsPage();
		productdetailspage.selectSize();
		productdetailspage.addToCart();
		
	}

}
