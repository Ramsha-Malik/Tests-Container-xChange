package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Page object model for the page which appear after Team management tab is clicked on the MAIN page
public class TeamManagementPage {
	
		WebDriver wd;
		public TeamManagementPage(WebDriver wd1)
		{
			this.wd=wd1;
			PageFactory.initElements(wd, this);
		}
		@FindBy(partialLinkText="Adjusting settings & permissions")
		private WebElement subheading1;
		public WebElement get_sheading1()
		{
			return subheading1;
		}
		
		@FindBy(partialLinkText="Billing, payments & plans")
		private WebElement subheading2;
		public WebElement get_sheading2()
		{
			return subheading2;
		}
		
		@FindBy(partialLinkText="Authentication")
		private WebElement subheading3;
		public WebElement get_sheading3()
		{
			return subheading3;
		}
		@FindBy(partialLinkText="Services")
		private WebElement subheading4;
		public WebElement get_sheading4()
		{
			return subheading4;
		}
}
