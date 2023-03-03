package ExcelFIleReader;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;

public class DataDriven {

	public ArrayList<String> getData(String testcaseName) throws IOException {
		// fileInput stream arguments :- provide a location of excel file [so file
		// obgect can read the all data from excel file]

		ArrayList<String> array = new ArrayList<String>();

		FileInputStream file = new FileInputStream("D:\\SeleniumWebDriver\\excel.xlsx");
		XSSFWorkbook workBook = new XSSFWorkbook(file);
		/*
		 * access to the required sheet from numbers of sheet -- 1. get the numbers of
		 * sheet present in the excel file. 2. get the name of all the sheets and 3.
		 * compare with all names, if the name is equal to the required name then click
		 * 
		 */
		int sheetCount = workBook.getNumberOfSheets();
		System.out.println("Numbers of sheet : " + sheetCount);
		for (int i = 0; i < sheetCount; i++) {
			if (workBook.getSheetName(i).equalsIgnoreCase("required")) {
				XSSFSheet sheet = workBook.getSheetAt(i);

				// identify the required column (TestCases) by scanning the entire first row,
				Iterator<Row> rows = sheet.rowIterator(); // sheet is a collection of the rows
				Row firstRow = rows.next();
				Iterator<Cell> cell = firstRow.cellIterator(); // row is a collection of the cells
				System.out.println("===========");
				int k = 0;
				int coloumn = 0;
				while (cell.hasNext()) // this while loop get live only when there is next cell is present
				{
					Cell value = cell.next();
					if (value.getStringCellValue().equalsIgnoreCase("TestCases")) {
						coloumn = k;
					}
					k++;

				}
				System.out.println("requird column : " + coloumn);
				// once required row is identified then find the required row (once you get
				while (rows.hasNext()) {
					Row r = rows.next();

					if (r.getCell(coloumn).getStringCellValue().equalsIgnoreCase(testcaseName)) {
						Iterator<Cell> cellValue = r.cellIterator();
						while (cellValue.hasNext()) {
							Cell c = cellValue.next();
							if (c.getCellType() == CellType.STRING) {
								array.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							}
						}
					}
				}
			}
		} return array;
	} 
public static void main(String[] args) {
	
}
}
