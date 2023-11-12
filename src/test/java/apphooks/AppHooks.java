package apphooks;

import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.factory.DriverFactory;
import com.util.ConfigReader;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

/**
 * To launch browser
 * 
 */

public class AppHooks {
	
	private DriverFactory driverFactory;
	private WebDriver driver;
	private ConfigReader configReader;
	Properties prop;
	
	@Before(order =0)
	public void getProperty() {
		configReader = new ConfigReader();
		prop = configReader.readProperties();
		
	}
	
	@Before(order = 1)
	public void launchBrowser() {
		String browserName = prop.getProperty("Browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.init_driver(browserName);
		
	}
	
	@After(order =0)
	public void quitBrowser() {
	//	driver.quit();
	}
	
	@After(order =1)
	public void tearDown(Scenario scenario) {
		
		if(scenario.isFailed()) {
			scenario.getName().replaceAll(" ", "_");
			
		}
	}
}
