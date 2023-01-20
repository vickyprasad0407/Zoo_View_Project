package practice_package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.zooview.generics.ExcelUtility;
import com.zooview.generics.IpathConstant;

public class DataProviderDemo2 {

	@DataProvider
	public Object[][] readData() throws EncryptedDocumentException, IOException
	{
		ExcelUtility ex=new ExcelUtility();
		Object[][] ob = ex.readMultipleSetOfData("Sheet1");
		return ob;
	}

	@Test(dataProvider = "readData")
	public void data(String locator,String description)
	{
		System.out.println(locator+"--------->"+description);
	}

	@Test(dataProvider = "readData")
	public void writeData(String loc,String desc) throws Throwable
	{
		FileInputStream fis=new FileInputStream("./src/test/resources/Testdata.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		for(int i=0;i<=13;i++)
		{
				wb.getSheet("Sheet2").createRow(i).createCell(0).setCellValue(loc);
		
				wb.getSheet("Sheet2").createRow(i).createCell(1).setCellValue(desc);
		}
		FileOutputStream fos=new FileOutputStream("./src/test/resources/Testdata.xlsx");
		wb.write(fos);
		fos.close();


	}

}
