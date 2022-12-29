package Home_page;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class READdataFROMexcel {
	public static String readFromExcel(String filePath, String sheetName, int rowNum, int cellNum)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(filePath);
		Workbook workbook = WorkbookFactory.create(fis);
		 org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		String cellValue = row.getCell(cellNum).toString();
		return cellValue;
	}

}
