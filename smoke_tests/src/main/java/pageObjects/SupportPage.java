package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Page object model for Support&FAQ MAIN page
public class SupportPage {
	
	WebDriver wd;
	public SupportPage(WebDriver wd1)
	{
		this.wd=wd1;
		PageFactory.initElements(wd, this);
	}
	@FindBy(id="query")
	private WebElement search_field;
	public WebElement get_sfield_path()
	{
		return search_field;
	}
	@FindBy(xpath="//ul[@class='blocks-list']/li")
	private List<WebElement> list_id;
	public List<WebElement> get_list()
	{
		return list_id;
	}
	@FindBy(xpath="//p[contains(.,'Set up a team plan for your business, institution, or professional organization')]")
	private WebElement getting_started;
	public WebElement get_tab1()
	{
		return getting_started;
	}
	@FindBy(xpath="//p[contains(.,'Manage your team settings, user roles, and payment methods')]")
	private WebElement team_management;
	public WebElement get_tab2()
	{
		return team_management;
	}


	

}
