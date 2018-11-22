package util;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestDataSheet {

	public static String[][] getData() throws IOException {

		XSSFWorkbook myBook=new XSSFWorkbook("./testData/createLead.xlsx");
		XSSFSheet sheet=myBook.getSheetAt(0);
		int rowCount=sheet.getLastRowNum();
		int cellCount=sheet.getRow(0).getLastCellNum();

		String[][] data=new String[rowCount][cellCount];

		for (int i = 1; i <=rowCount; i++) {
			XSSFRow row=sheet.getRow(i);
			for (int j = 0; j < cellCount; j++) {
				XSSFCell cell=row.getCell(j);
				String cellValue =cell.getStringCellValue();
				data[i-1][j]=cellValue;
			}

		}
		return data;






	}

}
