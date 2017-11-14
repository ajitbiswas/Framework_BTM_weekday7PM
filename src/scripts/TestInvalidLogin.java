package scripts;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Lib;
import pompages.LoginPage;

public class TestInvalidLogin extends BaseTest{
	
	@Test
	public void testValidLogin(){
		
		LoginPage l = new LoginPage(driver);
		
		int rowCount = Lib.getRowCount(EXCEL_PATH, "InvalidLogin");
		
		for (int i = 1; i < rowCount; i++) {
			
			String un = Lib.getCellValue(EXCEL_PATH, "InvalidLogin", i, 0);
			String pwd = Lib.getCellValue(EXCEL_PATH, "InvalidLogin", i, 1);
			
			l.setUsername(un);
			l.setPassword(pwd);
			l.clickLogin();
			
		}
		
		
		
	}

}
