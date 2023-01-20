//create a project using jdbc and verify using selenuum
package practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mysql.jdbc.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class VerifyApiPoject2 {

	public static void main(String[] args) throws InterruptedException, SQLException {

//		Connection con=null;
//		int result=0;
//		try {
//			Driver driver=new Driver();
//			DriverManager.registerDriver(driver);
//			con=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
//			Statement stat=con.createStatement();
//			String query="insert into project values ('TY_ZooView_045','Vicky','16/12/2022','Zoo_view','created',2);";
//			result=stat.executeUpdate(query);
//		}
//		catch(Exception e)
//		{
//			e.printStackTrace();
//		}
//		finally {
//	          con.close();
//		}
		String expected="TY_ZooView_045";
		WebDriver driver=WebDriverManager.chromedriver().create();
		driver.get("http://rmgtestingserver:8084/");
		Thread.sleep(5000);
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		Thread.sleep(3000);
		driver.findElement(By.linkText("Projects")).click();
		Thread.sleep(8000);
		List<WebElement> actProjectId = driver.findElements(By.xpath("//tr/td[1]"));
		boolean flag=false;
		for (WebElement actual : actProjectId) {
			if((actual.getText()).equalsIgnoreCase(expected))
			{
				flag=true;
				break;
			}
			
		}
		if (flag)
		{
			System.out.println("project created sucessfully");
		}
		else
			System.out.println("project not created");

		
	}

}
