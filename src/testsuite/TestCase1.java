package testsuite;


import java.awt.AWTException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginOrangeHrmPage;

import pages.LogoutOrangeHrmPage;
import utility.BaseClass;

public class TestCase1 
{
	@DataProvider
	public Object[][] validLoginData()
	{
		return new Object[][] {{"Admin", "admin123"}};
	}
	
	@DataProvider
	public Object[][] invalidLoginData()
	{
		return new Object[][] {{"Admin", "admin1234"}};
	}
	
	@DataProvider
	public Object[][] searchAdminData()
	{
		return new Object[][] {{"prasad prasad", "Admin", "sasa asa ff", "Enabled"}};
	}
	
	@Test(dataProvider ="validLoginData", priority=-1, enabled=false)
	public static void testcase1(String username, String password) throws AWTException, InterruptedException
	{
		//DOMConfigurator.configure("log4j.xml");
		BaseClass.openBrowserApp();
		LoginOrangeHrmPage.loginOrangepage(username, password);
		BaseClass.closeBrowserApp();
	} 
	
	@Test(dataProvider ="validLoginData", priority=0, enabled=false)
	public static void logoutPage(String username, String password)
	{
		BaseClass.openBrowserApp();
		LoginOrangeHrmPage.loginOrangepage(username, password);
		LogoutOrangeHrmPage.logoutPage();
		BaseClass.closeBrowserApp();
	}
	
	}
