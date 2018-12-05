package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.FWUtil;
import page.EnterTimeTrackPage;
import page.LicensePage;
import page.LoginPage;

public class CheckProductEdition extends BaseTest {
	@Test(priority=4)
	public void testCheckProductEdition() throws Exception{
		String un=FWUtil.getXLData(XL_PATH,"CheckProductEdition",1,0);
		String pw=FWUtil.getXLData(XL_PATH,"CheckProductEdition",1,1);
		String productEdition=FWUtil.getXLData(XL_PATH,"CheckProductEdition",1,2);
		//Enter valid User Name
		LoginPage l=new LoginPage(driver);
		l.setUserName(un);
		//Enter valid password
		l.setPassword(pw);
		//Click Login
		l.clickLogin();
		Thread.sleep(2000);
		//Click Settings
		EnterTimeTrackPage e=new EnterTimeTrackPage(driver);
		e.clickSettings();
		//Click Licenses
		e.clickLicenses();
		//Verify Product Edition
		LicensePage c=new LicensePage(driver);
		c.verifyProductEdition(productEdition);
		//Click logout
		c.clickLogout();
	}
}
