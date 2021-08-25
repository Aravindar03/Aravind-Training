package excelRead;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReadSearch {
	public String searchname;
	public String searchemail;
	public String searchphone;

	public void excelReadsearch(int search) throws IOException {
		FileInputStream file = new FileInputStream(
				"C:\\Users\\Aravind A R\\eclipse-workspace\\ObsquraProject\\src\\main\\resources\\SearchData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int totalrows = sheet.getLastRowNum();
		XSSFRow row = sheet.getRow(search);
		XSSFCell cell1 = row.getCell(0);
		XSSFCell cell2 = row.getCell(1);
		// XSSFCell cell3 = row.getCell(2);
		searchname = cell1.toString();
		searchemail = cell2.toString();
		// searchphone=cell3.toString();
	}

}
