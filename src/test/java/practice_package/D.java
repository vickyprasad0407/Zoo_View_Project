package practice_package;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import com.zooview.generics.ExcelUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class D {

	public static void main(String[] args) throws IOException {

		if(("Visitor Name: Simon").contains("Simon"))
			System.out.println("yes");
		else
			System.out.println("no");
		ExcelUtility ex=new ExcelUtility();
		System.out.println("vicky".substring(1));
		System.out.println(ex.getExcelProperty(11, 1).toString().substring(0, 1).toUpperCase()+ex.getExcelProperty(11, 1).toString().substring(1));
      	
	}		

}
