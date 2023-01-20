package practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Validate {

	public static void main(String[] args) throws SQLException {

		Connection con=null;
		ResultSet result;
		String actCreated="vicky";
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			con=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
			Statement state = con.createStatement();
			String query="select * from project where created_by='vicky';";
			result=state.executeQuery(query);
			
			while(result.next())
			{
				System.out.println(result.getString(2));
				if(result.getString(2).equalsIgnoreCase(actCreated))
					System.out.println("project is created");
				else
					System.out.println("project is not created");
			}

		}
		catch(Exception e)
		{
		e.printStackTrace();	
		}
		finally {
			//step5: close the databases
			con.close();
			System.out.println("close the databases connection sucessfully");
		}
	}

}
