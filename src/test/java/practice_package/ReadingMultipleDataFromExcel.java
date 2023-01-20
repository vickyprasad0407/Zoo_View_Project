package practice_package;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadingMultipleDataFromExcel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
     FileInputStream fis=null;
     try {
    	 fis=new FileInputStream("./src/test/resources/Testdata.xlsx");
    	  Sheet wb = WorkbookFactory.create(fis).getSheet("Sheet1");
    			 int count = wb.getLastRowNum();
    			 String [] st=new String[count+1];
    	 for (int i=0;i<=count;i++) {
    		 String data=wb.getRow(i).getCell(0).toString();
    		 st[i]=data;
    		//System.out.println(wb.getRow(i).getCell(0).toString());
		} 
    	 System.out.println(st[0]);
    	 for (int i = 0; i < st.length; i++) {
			System.out.println(st[i]);
		}
     }
     catch (IOException e) {
       e.printStackTrace();
     }
     catch (EncryptedDocumentException e) {
       e.printStackTrace();
     }
	}

}
