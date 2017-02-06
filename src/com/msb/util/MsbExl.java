package com.msb.util;
import java.io.File;
import java.io.IOException;
import java.util.Hashtable; 
import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
 
public class MsbExl {
static Workbook wrkbook =null;
static Sheet wrksheet;
static Hashtable dict= new Hashtable();
//Create a Constructor
public MsbExl (String ExcelSheetPath) throws BiffException, IOException
{
  wrkbook = Workbook.getWorkbook(new File("F://SeleniumLoginWorkspace//MSB_Login.xls"));
  wrksheet = wrkbook.getSheet("Sheet1");
}
 //Returns the Number of Rows
public static int RowCount()
 {
	int totalNoOfRows = wrksheet.getRows();
    System.out.println("Number of Rows in Excel Sheet = " +"\t" + totalNoOfRows);
	return wrksheet.getRows();
 }
public static int ColCount()
{
   int totalNoOfCols = wrksheet.getColumns();
   System.out.println("Number of Columns in Excel Sheet =" + "\t" +totalNoOfCols);
   return wrksheet.getColumns();
} 

//Returns the Cell value by taking row and Column values as argument
 public static String ReadCell(int column,int row)
 {
  return wrksheet.getCell(column,row).getContents();
 }
 
//Create Column Dictionary to hold all the Column Names
 public static void ColumnDictionary()
 {
//Iterate through all the columns in the Excel sheet and store the value in Hashtable
  for(int col=0;col<wrksheet.getColumns();col++)
  {
   dict.put(ReadCell(col,0), col);
  }
 }
 public static int GetCell(String colName)
 {
  try {
   int value;
   value = ((Integer) dict.get(colName)).intValue();
   return value;
  } catch (NullPointerException e) {
   return (0);
  }
 }
}
