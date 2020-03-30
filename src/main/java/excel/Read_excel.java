package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Read_excel {
	
	int r,c;
	protected String[][] data ;
	public void get_data(String sheet_name,int row_num,int cell_num)
	{
		data =new String[row_num][cell_num];
		File f=new File("src\\test\\resources\\TESTDATA\\TASK.xlsx");
		try {
			FileInputStream fis=new FileInputStream(f);
			XSSFWorkbook wb=new XSSFWorkbook(fis);
			XSSFSheet sh1=wb.getSheet(sheet_name);
			for (r=1;r<=row_num;r++) {
		 	 XSSFRow row=sh1.getRow(r);
			for(c=0;c<cell_num;c++)
			{
				XSSFCell cell=row.getCell(c);
				String m=cell.getStringCellValue();
//				data_login[c]=m;
				data[r-1][c]=m;
			}}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
//		return data;
	

}
	
}
