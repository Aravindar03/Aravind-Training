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

public class ExcelReadLogin {
	public String username;
	public String password;

	public void excelReadinput(int i) throws IOException {
		FileInputStream file = new FileInputStream(
				"C:\\Users\\Aravind A R\\eclipse-workspace\\ObsquraProject\\src\\main\\resources\\TestExcel1.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int totalrows = sheet.getLastRowNum();
		XSSFRow row = sheet.getRow(i);
		XSSFCell cell1 = row.getCell(0);
		XSSFCell cell2 = row.getCell(1);
		username = cell1.toString();
		password = cell2.toString();
	}

}
