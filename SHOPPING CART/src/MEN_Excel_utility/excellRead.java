package MEN_Excel_utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class excellRead {
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./testdata/Book1.xlsx");
		
		Workbook workbook = WorkbookFactory.create(fis);
		Sheet sheet = workbook.getSheet("Shoppingkart");
		int rowCount = sheet.getPhysicalNumberOfRows();
		int colCount = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println(rowCount);
		System.out.println(colCount);
		
		String[][] sarr=new String[rowCount][colCount];
		
		for(int i=0;i<rowCount;i++)
		{
			for(int j=0;j<colCount;j++)
			{
				sarr[i][j]=sheet.getRow(i).getCell(j).toString();
			}
		}
		for(String[] arr:sarr)
		{
			for(String value:arr)
			{
				System.out.print(value+", ");
			}
			System.out.println();
		}
	}

}

