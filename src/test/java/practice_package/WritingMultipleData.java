package practice_package;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WritingMultipleData {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=null;
		FileOutputStream fos=null;
		try {
			fis=new FileInputStream("./src/test/resources/Testdata.xlsx");
			Workbook wb=WorkbookFactory.create(fis);
			String [][] st= {{"vicky","10"},{"suman","20"}};
			for(int i=0;i<2;i++)
			{
				for(int j=0;j<2;j++)
				{
			        wb.getSheet("Sheet1").createRow(i).createCell(j).setCellValue(st[i][j]);
				}
			}
			
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
