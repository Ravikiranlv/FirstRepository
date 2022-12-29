package MEN_Excel_utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excelutility {
	public static String[][] ReadmultipleDataFromExcel(String excelpath, String sheetName)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(excelpath);
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet(sheetName);
		double rowcount =(double)sheet.getPhysicalNumberOfRows();
        double columnCount =(int) sheet.getRow(0).getPhysicalNumberOfCells();
		String[][] sarr = new String[ (int) rowcount][(int)columnCount];
		for (int i = 0; i < rowcount; i++) {
			for (int j = 0; j < columnCount; j++) {
				sarr[i][j] = sheet.getRow(i).getCell(j).toString();
			}
		}
		return sarr;
	}
}
