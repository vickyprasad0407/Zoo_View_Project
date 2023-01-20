package practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class UpdateDataFromDatabase {

	public static void main(String[] args) throws SQLException {

		Connection con=null;
		int result=0;
		try {
			Driver driver=new Driver();
			//step 1: register the data bases
			DriverManager.registerDriver(driver);
			
			//step 2: get connection to the database
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet45", "root", "root");
			
			//step 3: Issue create statement
			Statement state = con.createStatement();
			String query="insert into studentInfo values('vicky','BTM','API',1.5);";
			
			//step 4: update query
			result=state.executeUpdate(query);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally {
			if (result==1)
			{
				System.out.println("data inserted successfully");
			}
			else
			{
				System.out.println("data not inserted successfully");
			}
			// step 5: closing the database
			con.close();
		}
		
	}

}
