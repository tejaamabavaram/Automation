package com.venkat_ajio.pages;

import org.hamcrest.Matchers;

import com.qmetry.qaf.automation.core.ConfigurationManager;
import com.qmetry.qaf.automation.ui.WebDriverBaseTestPage;
import com.qmetry.qaf.automation.ui.annotations.FindBy;
import com.qmetry.qaf.automation.ui.api.PageLocator;
import com.qmetry.qaf.automation.ui.api.WebDriverTestPage;
import com.qmetry.qaf.automation.ui.webdriver.QAFWebElement;
import com.qmetry.qaf.automation.util.Validator;
import com.venkat_ajio.bean.ProductBeanInfo;

public class ProductDetailsTestPage extends WebDriverBaseTestPage<WebDriverTestPage> {

	@FindBy(locator = "detailspage.brandname.txt")
	private QAFWebElement detailspageBrandnameTxt;
	@FindBy(locator = "detailspage.price.txt")
	private QAFWebElement detailspagePriceTxt;
	@FindBy(locator = "detailspage.pname.txt")
	private QAFWebElement detailspagePnameTxt;
	@FindBy(locator = "detailspage.pcolor.txt")
	private QAFWebElement detailspagePcolorTxt;
	@FindBy(locator = "detailspage.psize.txt")
	private QAFWebElement detailspagePsizeTxt;
	@FindBy(locator = "detailspage.addtobag.lnk")
	private QAFWebElement detailspageAddtobagLnk;
	@FindBy(locator = "detailspage.productdescription.txt")
	private QAFWebElement detailspageProductdescriptionTxt;

	@Override
	protected void openPage(PageLocator pageLocator, Object... args) {
	}

	public QAFWebElement getDetailspageBrandnameTxt() {
		return detailspageBrandnameTxt;
	}

	public QAFWebElement getDetailspagePriceTxt() {
		return detailspagePriceTxt;
	}

	public QAFWebElement getDetailspagePnameTxt() {
		return detailspagePnameTxt;
	}

	public QAFWebElement getDetailspagePcolorTxt() {
		return detailspagePcolorTxt;
	}

	public QAFWebElement getDetailspagePsizeTxt() {
		return detailspagePsizeTxt;
	}

	public QAFWebElement getDetailspageAddtobagLnk() {
		return detailspageAddtobagLnk;
	}

	public QAFWebElement getDetailspageProductdescriptionTxt() {
		return detailspageProductdescriptionTxt;
	}
	
	public void verifyProductDetailsPage()
	{
		/*System.out.println("Brandname:"+getDetailspageBrandnameTxt().getText());
		Validator.verifyThat(getDetailspageBrandnameTxt().isDisplayed(), Matchers.equalTo(true));*/
		ProductBeanInfo details = (ProductBeanInfo)ConfigurationManager.getBundle().getProperty("product.properties");
		Validator.verifyThat(getDetailspageBrandnameTxt().getText(), Matchers.containsString(details.getPbrand()));
		Validator.verifyThat(getDetailspagePriceTxt().getText(), Matchers.containsString(details.getPprice()));
		//Validator.verifyThat(getDetailspagePnameTxt().getText(), Matchers.containsString(details.getPname()));
	}
	public void selectSize()
	{
		/*QAFExtendedWebElement size1 = new QAFExtendedWebElement(String.format(ConfigurationManager.getBundle().getString("detailspage.psize.txt"), size));
		size1.sendKeys(size);*/
		getDetailspagePsizeTxt().waitForVisible();
		getDetailspagePsizeTxt().click();
		
	}
	public void addToCart() throws InterruptedException
	{
		getDetailspageAddtobagLnk().waitForVisible();
		getDetailspageAddtobagLnk().click();
		Thread.sleep(5000);
		getDetailspageAddtobagLnk().click();
	}
	public void getProductDescription()
	{
		System.out.println("Product Descrition:::"+getDetailspageProductdescriptionTxt().getText());
	}

}
