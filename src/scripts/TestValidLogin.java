package scripts;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Lib;
import pompages.LoginPage;

public class TestValidLogin extends BaseTest{
	
	@Test
	public void testValidLogin(){
		
		LoginPage l = new LoginPage(driver);
		
		String un = Lib.getCellValue(EXCEL_PATH, "ValidLogin", 1, 0);
		String pwd = Lib.getCellValue(EXCEL_PATH, "ValidLogin", 1, 1);
		
		l.setUsername(un);
		l.setPassword(pwd);
		l.clickLogin();
		
	}
	
	
	
	

}
