package practice_package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromProperty {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//step 1: get object representation of excel file
		FileInputStream fis=null;
		try {
			 fis=new FileInputStream("./src/test/resources/commondata.properties");
			 Properties p=new Properties();
				p.load(fis);
				String url=p.getProperty("url");
				String un=p.getProperty("username");
				String pwd=p.getProperty("pwd");
				System.out.println(url+"...."+un+"....."+pwd);
			 
		} catch (IOException e) {
			e.printStackTrace();
		}
        
     

	}

}
