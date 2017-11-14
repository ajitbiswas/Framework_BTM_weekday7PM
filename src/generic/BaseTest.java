package generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements IAutoConstant{
	
	public WebDriver driver;
	
	static{
		System.setProperty(GECKO_KEY, GECKO_VALUE);
		System.setProperty(CHROME_KEY, CHROME_VALUE);
	}
	
	@BeforeMethod
	public void openApplication(){
		
		driver = new FirefoxDriver();
		String url = Lib.getProperty(CONFIG_PATH, "URL");
		driver.get(url);
		int timeout = Integer.parseInt(Lib.getProperty(CONFIG_PATH, "ITO"));
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void closeApplication(){
		
		driver.close();
	}

}
