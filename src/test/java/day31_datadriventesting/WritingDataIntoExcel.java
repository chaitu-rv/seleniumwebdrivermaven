package day31_datadriventesting;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


//File--->Workbook-->Sheet--->Rows-->Cells

public class WritingDataIntoExcel {

	public static void main(String[] args) throws IOException {

		FileOutputStream file=new FileOutputStream(System.getProperty("user.dir")+"\\testdata\\testdata.xlsx");
		
		XSSFWorkbook workbook=new XSSFWorkbook();
		XSSFSheet sheet=workbook.createSheet("data");
		
	/*	for(int r=0;r<=3;r++)
		{
			XSSFRow currentrow=sheet.createRow(r);
			for(int c=0;c<=2;c++)
			{
				currentrow.createCell(c).setCellValue("welcome");
			}
		}*/
		
		Scanner sc=new Scanner(System.in);
		for(int r=0;r<=3;r++)
		{
			XSSFRow currentrow=sheet.createRow(r);
			for(int c=0;c<=2;c++)
			{
				System.out.println("Enter data for excel");
				String value =sc.next();
				currentrow.createCell(c).setCellValue(value);
			}
		}
	workbook.write(file);
	workbook.close();
	file.close();
	
	System.out.println("DOne!!!");
	
	
	
	
	
	
	
	
	
	}

}
