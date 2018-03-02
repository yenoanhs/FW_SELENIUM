package testUnit;

import org.testng.annotations.Test;

import customLibs.ExcelUtils;
import testbase.TestBase;

public class testUnitExcelFunc extends TestBase{

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("test unit");
	}

	@Test()
	public void testGetDataInExcel(){
		String filepath="E:/oanh/FW_SELENIUM/src/test/testData.xlsx";
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

	@Test()
	public void testStart(){
		String str="test";
		assert "message".equals(str);
	}

	@Test(dependsOnMethods ={"testStart"})
	public void test(){
		String str="test";
		assert "message".equals(str);
	}


}
