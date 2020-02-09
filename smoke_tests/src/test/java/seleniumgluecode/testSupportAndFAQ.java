package seleniumgluecode;


import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import configurations.Configure;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.GettingStartedPage;
import pageObjects.SupportPage;
import pageObjects.SupportSearchPage;
import pageObjects.TeamManagementPage;

// this class has basically all the step definitions.
// i have used before and after hooks and placed launching and closing browser function in it respectively as these have to be executed before and after every TC 
public class testSupportAndFAQ extends Configure{
	
	//since support&FAQ page is tested here so all its page object model objects should be created
    private SupportPage support_main;
    private SupportSearchPage search_main;
    private GettingStartedPage start_main;
    private TeamManagementPage team_main;

	
    @Before
    public void initialize()
    {
    	//calling parent class function to load file and setup browser
    	object=load_file();
    	driver=setup_browser(object.getProperty("browser"));
    	js=((JavascriptExecutor) driver);
		wait=new WebDriverWait(driver,(Integer.valueOf(object.getProperty("wait_time"))));
		support_main=new SupportPage(driver);
		search_main=new SupportSearchPage(driver);
		start_main=new GettingStartedPage(driver);
		team_main=new TeamManagementPage(driver);

    }
    @After
    public void exit()
    {

    	driver.close();
    }
    //first scenario:Basic level check whether page is loaded properly with two assertions on title and search field

    @When("^user navigates to Support & FAQ page$")
    public void openHomePage()
    {
    	driver.get(object.getProperty("URL")); // get to the URL
		driver.manage().window().maximize(); //maximize window
	}
    @Then("^title displays successfully$")
    public void verifyTitle()
    {
    	Assert.assertEquals(object.getProperty("title"),driver.getTitle());
    }
    @And("^search field is shown$")
    public void verifySearchField()
    {
    	Assert.assertTrue(support_main.get_sfield_path().isDisplayed());
    }
    //second scenario:Checks the page further by asserting that total tabs are 7 and their text and heading is correct
    @Then("^total all tabs should be displayed with correct text$")
    public void tabs_displayed()
    {
    	List<WebElement> allProduct = support_main.get_list();
    	Assert.assertEquals(Integer.parseInt(object.getProperty("main_page_tabs")), allProduct.size());
    	int temp=1; //for config properties data traversing
    	for( WebElement product : allProduct)
    	{
    		Assert.assertEquals(object.getProperty("tab_"+temp),product.getText());
    		temp++;
    		
    	}
    	
    }
    
    //third scenario:This scenario checks whether correct number of result is displayed on searching various articles.(For an example I have place two article in scenario outline
    @And("^user enters \"([^\"]*)\" and press enter$")
    public void enterSearchWord(String search_word)
    {
    	//wait until the search field appears and then type into it
    	wait.until(ExpectedConditions.visibilityOf(support_main.get_sfield_path()));
    	support_main.get_sfield_path().sendKeys(search_word+Keys.ENTER);
    	
    }
    @Then("^total \"([^\"]*)\" results for \"([^\"]*)\" should be shown$")
    public void correctArticleNumber(int number,String search_word)
    {
    	wait.until(ExpectedConditions.visibilityOf(search_main.get_srecords_path()));
    	Assert.assertEquals(number+" results for \""+search_word+"\"",search_main.get_srecords_path().getText());
    }
    
    //fourth scenario:This scenario checks whether navigation to getting started page is working and getting started page is loaded successfully by putting assertions on its three subheadings.
    @And("^user scrolls down$")
    public void scrollDown()
    {
    	js.executeScript("window.scrollBy(0,550)", "");
    }
    @And("^user clicks on Getting started button$")
    public void clickGettingStarted()
    {
    	wait.until(ExpectedConditions.elementToBeClickable(support_main.get_tab1()));
    	support_main.get_tab1().click();
    }
    @Then("^Getting Started title appears$")
    public void titleAppearsGS()
    {
    	Assert.assertEquals(object.getProperty("Getting_started_title"), driver.getTitle());
    }
    @And("^subheading Create a new team appears$")
    public void firstSubHeadingAppears()
    {
    	wait.until(ExpectedConditions.elementToBeClickable(start_main.get_sheading1()));
    	Assert.assertEquals(object.getProperty("Getting_started_subheading1"), start_main.get_sheading1().getText());
    }
    @Then("^subheading First steps with Wire appears$")
    public void secondSubHeadingAppears()
    {
    	wait.until(ExpectedConditions.elementToBeClickable(start_main.get_sheading2()));
    	Assert.assertEquals(object.getProperty("Getting_started_subheading2"), start_main.get_sheading2().getText());
   
    }
    @And("^subheading Group conversations appears$")
    public void thirdSubHeadingAppears()
    {
    	wait.until(ExpectedConditions.elementToBeClickable(start_main.get_sheading3()));
    	Assert.assertEquals(object.getProperty("Getting_started_subheading3"), start_main.get_sheading3().getText());
    }
    
    //fifth scenario: This scenario checks whether navigation to team management page is working and team management page is loaded successfully by putting assertions on its fourth subheadings.
    @And("^user clicks on Team Management button$")
    public void clickTeamManagement()
    {
    	wait.until(ExpectedConditions.elementToBeClickable(support_main.get_tab2()));
    	support_main.get_tab2().click();
    }
    @Then("^Team Management title appears$")
    public void titleAppearsTM()
    {
    	Assert.assertEquals(object.getProperty("Team_management_title"), driver.getTitle());
    }
    @And("^subheading Adjusting settings & permissions appears$")
    public void firstSubHeadingAppears_TM()
    {
    	wait.until(ExpectedConditions.elementToBeClickable(team_main.get_sheading1()));
    	Assert.assertEquals(object.getProperty("Team_management_subheaading1"), team_main.get_sheading1().getText());
    }
    @And("^subheading Billing, payments & plans appears$")
    public void secondSubHeadingAppears_TM()
    {
    	wait.until(ExpectedConditions.elementToBeClickable(team_main.get_sheading2()));
    	Assert.assertEquals(object.getProperty("Team_management_subheaading2"), team_main.get_sheading2().getText());
    }
    @Then("^subheading Authentication appears$")
    public void thirdSubHeadingAppears_TM()
    {
    	wait.until(ExpectedConditions.elementToBeClickable(team_main.get_sheading3()));
    	Assert.assertEquals(object.getProperty("Team_management_subheaading3"), team_main.get_sheading3().getText());
    }
    @And("^subheading Services appears$")
    public void fourthSubHeadingAppears_TM()
    {
    	wait.until(ExpectedConditions.elementToBeClickable(team_main.get_sheading4()));
    	Assert.assertEquals(object.getProperty("Team_management_subheaading4"), team_main.get_sheading4().getText());
    }
    //sixth scenario: This scenario checks that navigation from getting started to team management page is successful and team management page is loaded successfully by putting assertions on its four subheadings.
    @And("^user clicks on Team Management tab$")
    public void clickTMtab()
    {
    	wait.until(ExpectedConditions.elementToBeClickable(start_main.get_TMtab()));
    	start_main.get_TMtab().click();
    	
    }
    
   
 
}
