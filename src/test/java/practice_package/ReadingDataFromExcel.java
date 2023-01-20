package practice_package;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadingDataFromExcel {

	public static void main(String[] args) {

		FileInputStream fis=null;
		try {
			fis=new FileInputStream("./src/test/resources/Testdata.xlsx");
			Workbook wb=WorkbookFactory.create(fis);
			Sheet sheet = wb.getSheet("Sheet1");
			Row row = sheet.getRow(1);
			Cell cell = row.getCell(0);
			String value = cell.toString();
			System.out.println(value);
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch (EncryptedDocumentException e) {
			e.printStackTrace();
		}
	}

}
