package generic;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest implements IAutoConstant{
	
	public WebDriver driver;
	
	Logger log = LogManager.getLogger(BaseTest.class.getName());
	
	static{
		System.setProperty(GECKO_KEY, GECKO_VALUE);
		System.setProperty(CHROME_KEY, CHROME_VALUE);
	}
	
	@BeforeMethod
	public void openApplication(){
		log.debug("launching the browser");
		driver = new FirefoxDriver();
		log.info("browser is lanuched");
		String url = Lib.getProperty(CONFIG_PATH, "URL");
		driver.get(url);
		log.error("this is an error");
		int timeout = Integer.parseInt(Lib.getProperty(CONFIG_PATH, "ITO"));
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}
	
	@AfterMethod
	public void closeApplication(){
		
		driver.close();
		log.fatal("this is closing application - fatal");
	}
	
	

}
