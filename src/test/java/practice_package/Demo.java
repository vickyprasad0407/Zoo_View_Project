package practice_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection con=null;
        ResultSet result;
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
			Statement stat=con.createStatement();
			String query="select * from studentinfo where sid=30;";
			result=stat.executeQuery(query);
			while (result.next())
			{
				System.out.println(result.getString(1)+"..."+result.getString(2)+"..."+result.getString(3)+"..."+result.getString(4)+"..."+result.getString(5));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
