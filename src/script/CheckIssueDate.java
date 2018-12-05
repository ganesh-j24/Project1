package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.FWUtil;
import page.EnterTimeTrackPage;
import page.LicensePage;
import page.LoginPage;

public class CheckIssueDate extends BaseTest{
	@Test(priority=3)
	public void testCheckIssueDate() throws Exception{
		String un=FWUtil.getXLData(XL_PATH,"CheckIssueDate",1,0);
		String pw=FWUtil.getXLData(XL_PATH,"CheckIssueDate",1,1);
		String issueDate=FWUtil.getXLData(XL_PATH,"CheckIssueDate",1,2);
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
		//Verify Issue Date
		LicensePage c=new LicensePage(driver);
		c.verifyIssueDate(issueDate);
		//Click logout
		c.clickLogout();
	}
}
