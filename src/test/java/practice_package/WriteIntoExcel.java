package practice_package;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteIntoExcel {

	public static void main(String[] args) {

		FileInputStream fis=null;
		FileOutputStream fos=null;
		try {
			fis=new FileInputStream("./src/test/resources/Testdata.xlsx");
			Workbook wb=WorkbookFactory.create(fis);
			Sheet sheet = wb.getSheet("Sheet1");
			Row row = sheet.getRow(1);
			row.createCell(3).setCellValue("suman saurabh");
			//Cell cell = row.getCell(0);
			
		    //cell.setCellValue("suman");
			fos=new FileOutputStream("./src/test/resources/Testdata.xlsx");
			wb.write(fos);
	}
		catch(Exception e)
		{
		    e.printStackTrace();	
		}
		finally {
			try {
				fos.flush();
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		}
		}

}
