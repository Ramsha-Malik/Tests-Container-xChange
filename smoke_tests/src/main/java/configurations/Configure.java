package configurations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Configure {
	//These will be the common variables so I have created them in one class, all classes comprising of TCS will be  inherited by this
	//the function are also common to all Tcs like loading file or setting browser properties so instead of creating them in every file I have placed them in parent class
	protected WebDriver driver;
	protected Properties object; 
	protected FileInputStream objfile;
	protected JavascriptExecutor js;
	protected WebDriverWait wait;
    
	//this function loads the config.props file
	public  Properties load_file()
	{
		object=new Properties();
		try 
		{
			objfile=new FileInputStream(System.getProperty("user.dir")+"\\config.properties");
			object.load(objfile);

		} 
		catch (FileNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		return object;

	}
	//this function sets the driver according to the one specified in the config.prop file
	public WebDriver setup_browser(String browser_name)
	{
		if(browser_name.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver",object.getProperty("driver_path"));
			driver=new ChromeDriver();
		}
		else
		{
			//if in future needs to be automated for Firefox/IE
		}
		return driver;
	}
}
