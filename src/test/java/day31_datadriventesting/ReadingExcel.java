package day31_datadriventesting;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


//File--->Workbook-->Sheet--->Rows-->Cells

public class ReadingExcel {

	public static void main(String[] args) throws IOException {
		//FileInputStream file=new FileInputStream("C:\\Users\\raaga\\OneDrive\\Desktop\\data.xlsx");

		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"\\testdata\\data.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1");
		
		int totalrows=sheet.getLastRowNum();
		int totalcols=sheet.getRow(1).getLastCellNum();
		
		System.out.println("Number of rows: "+totalrows); //5
		System.out.println("Number of columns: "+totalcols);//4

		for(int r=0;r<=totalrows;r++)
		{
			XSSFRow currentrow=sheet.getRow(r);
			for(int c=1;c<totalcols;c++)
			{
				String value = currentrow.getCell(c).toString();
				System.out.print(value+"      ");
			}
			System.out.println();
		}

		workbook.close();
		file.close();
	}

}
