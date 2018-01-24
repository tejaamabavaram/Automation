package com.venkat_ajio.pages;

import java.util.List;
import org.hamcrest.Matchers;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.Select;
import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFExtendedWebElement;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Reporter;
import com.qmetry.qaf.automation.util.Validator;
import com.venkat_ajio.bean.ProductBeanInfo;
import com.venkat_ajio.components.ProductComponent;

public class SearchResultsTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "searchresults.grid.link")
	private QAFWebElement searchresultsGridLink;
	
	@FindBy(locator = "searchresults.productcomponent.component")
	private List<ProductComponent> searchresultsProductcomponentComponent;

	@FindBy(locator = "searchresults.pcount.text")
	private QAFWebElement searchresultsPcountText;

	@FindBy(locator = "searchresults.sortby.dropdown")
	private QAFWebElement searchresultsSortbyDropdown;

	@FindBy(locator = "searchresults.brandname.checkbox")
	private QAFWebElement searchresultsBrandnameCheckbox;

	@FindBy(locator = "searchresults.discount.checkbox")
	private QAFWebElement searchresultsDiscountCheckbox;
	
	@FindBy(locator = "searchresults.filterstext.txt")
	private QAFWebElement searchresultsFilterstextTxt;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getSearchresultsGridLink() {
		return searchresultsGridLink;
	}

	public List<ProductComponent> getSearchresultsProductcomponentComponent() {
		return searchresultsProductcomponentComponent;
	}

	public QAFWebElement getSearchresultsPcountText() {
		return searchresultsPcountText;
	}

	public QAFWebElement getSearchresultsBrandnameCheckbox() {
		return searchresultsBrandnameCheckbox;
	}

	public QAFWebElement getSearchresultsSortbyDropdown() {
		return searchresultsSortbyDropdown;
	}
	
	public QAFWebElement getSearchresultsDiscountCheckbox() {
		return searchresultsDiscountCheckbox;
	}
	
	public QAFWebElement getSearchresultsFilterstextTxt() {
		return searchresultsFilterstextTxt;
	}

	public void selectGrid(String gridtype) {
		QAFExtendedWebElement grid = new QAFExtendedWebElement(String.format(
				ConfigurationManager.getBundle().getString("searchresults.grid.link"),
				gridtype));
		try {
			if (grid.isDisplayed() && grid.isPresent()) {
				grid.click();
				Thread.sleep(5000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectSortByValue(String option) throws InterruptedException {
		QAFExtendedWebElement sortby =
				new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle()
						.getString("searchresults.sortby.dropdown"), option));
		Select select = new Select(sortby);
		select.selectByVisibleText(option);
		Thread.sleep(5000);
	}

	/*public void selectbrandItem(String branditem) throws InterruptedException
	{
		QAFExtendedWebElement brandname = new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getString("searchresults.brandname.checkbox"), branditem));
		brandname.waitForVisible();
		if(branditem.equalsIgnoreCase(branditem))
		{
			brandname.click();
			Thread.sleep(5000);
		
		}
	}*/
	public void selectBrand(String brand) {
		QAFExtendedWebElement brandname =new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getString("searchresults.brandname.checkbox"), brand));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", brandname);
		
	}
	
	public void verifySelectedBranditems(String brand) {
		int count=0;
		for(ProductComponent p:getSearchresultsProductcomponentComponent())
		{
			if(p.getSearchresultsBrandLink().getText().equalsIgnoreCase(brand))
			{
				System.out.println(p.getSearchresultsBrandLink().getText());
				Reporter.log("pass");
				System.out.println(count++);
			}
			else
			{
				Reporter.log("FAIL");
			}
		}

	}
	
	public void setDicount(String discount) {
		QAFExtendedWebElement discpercentage =new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getString("searchresults.discount.checkbox"), discount));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", discpercentage);
	
	}
	
	public void verifyDiscountItems(String discount)
	{
	for(ProductComponent pc: getSearchresultsProductcomponentComponent())
	{
				
	}
	}
	public void verifyProduct() {
		//getSearchresultsProductcomponentComponent().get(0).getSearchresultsPriceLink().waitForVisible();
		//getSearchresultsProductcomponentComponent().get(0).getSearchresultsPnameLink().waitForVisible();
		getSearchresultsProductcomponentComponent().get(0).getSearchresultsBrandLink()
				.waitForVisible();
		Validator.verifyThat(getSearchresultsProductcomponentComponent().size(),
				Matchers.greaterThanOrEqualTo(0));
		for (ProductComponent p : getSearchresultsProductcomponentComponent()) {
			//System.out.println("productname:"+p.getSearchresultsPnameLink().getText());
			System.out.println("ProductPrice:" + p.getSearchresultsPriceLink().getText());
			System.out.println("ProductBrand:" + p.getSearchresultsBrandLink().getText());
		}
	}
	public void selectProduct(int index) {
		ProductBeanInfo beaninfo = new ProductBeanInfo();
		beaninfo.setPbrand(getSearchresultsProductcomponentComponent().get(index).getSearchresultsBrandLink().getText());
		beaninfo.setPprice(getSearchresultsProductcomponentComponent().get(index).getSearchresultsPriceLink().getText());
		getSearchresultsProductcomponentComponent().get(index).getSearchresultsPriceLink().click();
		ConfigurationManager.getBundle().addProperty("product.properties", beaninfo);

	}

	
}
