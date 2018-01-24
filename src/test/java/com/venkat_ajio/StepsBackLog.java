/**
 * 
 */
package com.venkat_ajio;

import com.qmetry.qaf.automation.step.NotYetImplementedException;
import com.qmetry.qaf.automation.step.QAFTestStep;
import com.venkat_ajio.pages.HomeTestPage;
import com.venkat_ajio.pages.ProductDetailsTestPage;
import com.venkat_ajio.pages.SearchResultsTestPage;

/**
 * @author Venkatarami.Reddy
 */

public class StepsBackLog {
	HomeTestPage homepage = new HomeTestPage();
	SearchResultsTestPage searchresultspage = new SearchResultsTestPage();
	ProductDetailsTestPage productdetailspage = new ProductDetailsTestPage();

	@QAFTestStep(description = "user is on the Homepage of www.Ajio.com")
	public void userIsOnTheHomepageOfWwwAjioCom() throws InterruptedException {
		homepage.launchApplication();
		homepage.clickPopup();
	}
	@QAFTestStep(description = "user selects {shirts} from {MEN} category")
	public void userSelectsFromCategory(String shirts, String MEN) {
		homepage.selectCategory("MEN", "Shirts");
	}
	 
/*
	@QAFTestStep(description = "search page should be displays with list of shirts")
	public void searchPageShouldBeDisplaysWithListOfShirts() {
		searchresultspage.verifyProduct();
	}
*/

	@QAFTestStep(description = "search results page dispalys shirts with five grid container")
	public void searchResultsPageDispalysShirtsWithFiveGridContainer() {
		searchresultspage.selectGrid("five-grid");
	}

	@QAFTestStep(description = "user selects shirts using the filter {Price (highest first)}")
	public void userSelectsShirtsUsingTheFilter(String filter)
			throws InterruptedException {
		searchresultspage.selectSortByValue(filter);
	}

	@QAFTestStep(description = "search results page displays shirts in Highest price")
	public void searchResultsPageDisplaysShirtsInHighestPrice() {
		searchresultspage.verifyProduct();
	}

	/*
	 * @QAFTestStep(description = "user clicks on {0}")
	 * public void userClicksOn(String str0) {
	 * // TODO: remove NotYetImplementedException and call test steps
	 * throw new NotYetImplementedException();
	 * }
	 */
	@QAFTestStep(description = "user clicks on {0} item")
	public void userClicksOnItem(String str0) {
		searchresultspage.selectProduct(0);
	}

	@QAFTestStep(description = "product details page displays with correct details")
	public void productDetailsPageDisplaysWithCorrectDetails() {
		productdetailspage.verifyProductDetailsPage();
		productdetailspage.getProductDescription();
	}

	@QAFTestStep(description = "user selects the {size} and clicks on {add to bag}")
	public void userSelectsTheAndClicksOn(String size, String addtobag)
			throws InterruptedException {
		productdetailspage.selectSize();
		productdetailspage.addToCart();
	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user clicks on {0}")
	public void userClicksOn(String str0) {
		// TODO: remove NotYetImplementedException and call test steps
		throw new NotYetImplementedException();
	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "user selects the {0}")
	public void userSelectsThe(String str0) {
		// TODO: remove NotYetImplementedException and call test steps
		throw new NotYetImplementedException();
	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	@QAFTestStep(description = "product adds to cart")
	public void productAddsToCart() {
		// TODO: remove NotYetImplementedException and call test steps
		throw new NotYetImplementedException();
	}

	/**
	 * Auto-generated code snippet by QMetry Automation Framework.
	 */
	

}
