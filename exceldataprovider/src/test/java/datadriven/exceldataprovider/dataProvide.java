package datadriven.exceldataprovider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProvide {
	DataFormatter formatter=new DataFormatter();
	@Test(dataProvider="drive test")
	public void testcaseData(String greeting,String name,String id) {
		
		System.out.println(greeting+name+id);
	}

	@DataProvider(name="drive test")
	public Object[][] getData() throws IOException {
		//Object[][] data= {{"hello","sam",2},{"bye","Luca",23},{"goodday","Jayden",76}};
		//return data;
		
		FileInputStream fis=new FileInputStream("//home//bala//Downloads//misc//newtest.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheetAt(0);
		int rowcount=sheet.getPhysicalNumberOfRows();
		XSSFRow row=sheet.getRow(0);
		int columncount=row.getLastCellNum();
		Object data[][]=new Object[rowcount-1][columncount];
		for(int i=0;i<rowcount-1;i++) {
			 	XSSFRow r=sheet.getRow(i+1);
			for(int j=0;j<columncount;j++) {
				XSSFCell cell=r.getCell(j);
				data[i][j]=formatter.formatCellValue(cell);
				
			}
		}
		
		
		return data;
		
}
}
