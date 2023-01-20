package practice_package;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class TestNgDemo {
	
	@Test(priority = 0)
	public void login()
	{
		Reporter.log("login", true);
	}
	@Test(priority = 1)
	public void create()
	{
		Reporter.log("Create", true);
	}
	
	@Test(priority = 2)
	public void delete()
	{
		Reporter.log("delete", true);
	}

}
