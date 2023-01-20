package com.zooview.generics;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This class is used to write Excel Specific method
 * @author Mr. Vicky
 *
 */
public class ExcelUtility {
	/**
	 * This method is used to read the Excel Data
	 * @param row
	 * @param cell
	 * @return
	 * @throws IOException
	 */
    public String getExcelProperty(int row,int cell) throws IOException
    {
    	FileInputStream fis=new FileInputStream(IpathConstant.epath);
    	Workbook wb=WorkbookFactory.create(fis);
    	String data = wb.getSheet(IpathConstant.sheetName).getRow(row).getCell(cell).toString();
    	return data;
    }
    /**
     * This method is used to write the excel data
     * @param row
     * @param cell
     * @param value
     * @throws EncryptedDocumentException
     * @throws IOException
     */
    public void setExcelProperty(int row,int cell,String value) throws EncryptedDocumentException, IOException
    {
    	FileInputStream fis=new FileInputStream(IpathConstant.epath);
    	Workbook wb=WorkbookFactory.create(fis);
    	wb.getSheet(IpathConstant.sheetName).createRow(1).createCell(2).setCellValue(value);
    	FileOutputStream fos=new FileOutputStream(IpathConstant.epath);
    	wb.write(fos);
    	fos.close();
    }
    /**
     * This method is used to get the no of rows in Excel
     * @return
     * @throws EncryptedDocumentException
     * @throws IOException
     */
    public int getLastRow() throws EncryptedDocumentException, IOException
    {
    	FileInputStream fis=new FileInputStream(IpathConstant.epath);
    	Workbook wb=WorkbookFactory.create(fis);
    	return wb.getSheet(IpathConstant.sheetName).getLastRowNum();
    }
    /**
     * This method is used to return the excel data in the form of map
     * @param keyCell
     * @param valueCell
     * @return
     * @throws EncryptedDocumentException
     * @throws IOException
     */
    public Map<String, String> getList(int keyCell,int valueCell) throws EncryptedDocumentException, IOException
    {
    	FileInputStream fis=new FileInputStream(IpathConstant.epath);
    	Workbook wb=WorkbookFactory.create(fis);
    	Sheet sheet = wb.getSheet(IpathConstant.sheetName);
    	int count = sheet.getLastRowNum();
    	Map<String, String> map=new LinkedHashMap<String, String>();
    	for (int i = 0; i <= count; i++) {
			String key=sheet.getRow(i).getCell(keyCell).toString();
			String value=sheet.getRow(i).getCell(valueCell).toString();
			map.put(key, value);
		}
    	return map;
    }
    public ArrayList getParticular(int valueCell,int initial,int end) throws EncryptedDocumentException, IOException
    {
    	ArrayList<String> al=new ArrayList<String>();
    	FileInputStream fis=new FileInputStream(IpathConstant.epath);
    	Workbook wb=WorkbookFactory.create(fis);
    	Sheet sheet = wb.getSheet(IpathConstant.sheetName);
    	for(int i=initial;i<=end ;i++)
    	{
		String value=sheet.getRow(i).getCell(valueCell).toString();
		al.add(value);
    	}
    	return al;
    }
    /**
     * reading multiple data without hard core
     * @param sheetName
     * @return
     * @throws EncryptedDocumentException
     * @throws IOException
     */
    public Object [][] readMultipleSetOfData(String sheetName) throws EncryptedDocumentException, IOException
    {
    	FileInputStream fis=new FileInputStream(IpathConstant.epath);
    	Workbook wb=WorkbookFactory.create(fis);
    	Sheet sh = wb.getSheet(sheetName);
    	int lastRow = sh.getLastRowNum();
    	short lastCell = sh.getRow(0).getLastCellNum();
    	
    	Object [][] ob=new Object[lastRow+1][lastCell];
    	for(int i=0;i<=lastRow;i++)
    	{
    		for(int j=0;j<lastCell;j++)
    		{
    			ob[i][j]=sh.getRow(i).getCell(j).toString();
    		}
    	}
    	return ob;
    }

}


