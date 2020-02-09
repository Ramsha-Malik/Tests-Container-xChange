package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Page object model for the page which is opened when some article is searched
public class SupportSearchPage {
	WebDriver wd;
	public SupportSearchPage(WebDriver wd1)
	{

		this.wd=wd1;
		PageFactory.initElements(wd, this);
	}
	@FindBy(xpath="//p[contains(.,'results for')]")
	private WebElement search_records;
	public WebElement get_srecords_path()
	{
		return search_records;
	}
}
