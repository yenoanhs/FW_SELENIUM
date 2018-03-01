package testUnit;

import customLibs.ExcelUtils;

public class testUnitExcelFunc {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		String filepath="E:/oanh/FW_SELENIUM/src/test/resources/testData.xlsx";
		String sheetname="Sheet1";
		ExcelUtils oExcel = new ExcelUtils(filepath, sheetname);
		int numberRow =oExcel.getRowCount();
		System.out.println("Num of row =" + numberRow);
		for (int i=2; i<=numberRow; i++)
		{
			//can use func getColFromName(String) to find what colNumber of col username, password
			// col start with 0, row start with 1 (header)
			String user = oExcel.getCellData(i, 0);
			String pass = oExcel.getCellData(i, 1);
			System.out.println("user = "+user+", pass = "+pass);
		}

	}


}
