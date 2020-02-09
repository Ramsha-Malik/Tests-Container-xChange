package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Page object model for the page which appear after Getting Started tab is clicked on the MAIN page
public class GettingStartedPage {
	WebDriver wd;
	public GettingStartedPage(WebDriver wd1)
	{

		this.wd=wd1;
		PageFactory.initElements(wd, this);
	}
	@FindBy(partialLinkText="Create a new team")
	private WebElement subheading1;
	public WebElement get_sheading1()
	{
		return subheading1;
	}
	
	@FindBy(partialLinkText="First steps with Wire")
	private WebElement subheading2;
	public WebElement get_sheading2()
	{
		return subheading2;
	}
	
	@FindBy(partialLinkText="Group conversations")
	private WebElement subheading3;
	public WebElement get_sheading3()
	{
		return subheading3;
	}
	@FindBy(xpath="//a[contains(@href, 'https://support.wire.com/hc/en-us/categories/360000248538-Team-Management')]")
	private WebElement team_management;
	public WebElement get_TMtab()
	{
		return team_management;
	}
	


}
