package autoLessons;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.testng.annotations.DataProvider;

public class ExcelDataSupplier {

	// Excel File -> xls(H), xlsx(X)
	@DataProvider(name = "loginData")
	public String[][] getData() throws Exception {
		File excelFile = new File("./src/test/resources/DP.xls");
		System.out.println(excelFile.exists());
		FileInputStream fis = new FileInputStream(excelFile);
		HSSFWorkbook workbook = new HSSFWorkbook(fis);
		HSSFSheet sheet = workbook.getSheet("Sheet1");
		int noOfRows = sheet.getPhysicalNumberOfRows(); // 4 -> 1,2,3,4
		// System.out.println(sheet.getLastRowNum()); //3 - counts from 0,1,2,3 (Need to
		// not count header row)
		int noOfColumns = sheet.getRow(0).getLastCellNum();

		String[][] data = new String[noOfRows - 1][noOfColumns];

		for (int i = 0; i < noOfRows - 1; i++) {
			for (int j = 0; j < noOfColumns; j++) {
				DataFormatter df = new DataFormatter();
				data[i][j] = df.formatCellValue(sheet.getRow(i + 1).getCell(j));

			}

		}
		workbook.close();
		fis.close();
		return data;
		/*
		 * for (String[] dataArray : data) {
		 * System.out.println(Arrays.toString(dataArray)); }
		 */

	}

}
