package Utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

	
	@DataProvider(name="LoginDP")
	public String[][] dataProvider() throws IOException
	{
		
		String test_dataPath=System.getProperty("user.dir")+"\\test_data\\Opencart_LoginData.xlsx";
		ExcelUtility xl=new ExcelUtility(test_dataPath);
		
		int total_rows=xl.getRowCount("Sheet1");
		int total_cols=xl.getCellCount("Sheet1", 1);
		
		String [][] loginData=new String[total_rows][total_cols];
		
		for(int i=1;i<=total_rows;i++)
		{
			for(int j=0;j<total_cols;j++)
			{
				loginData[i-1][j]=xl.getCellData("Sheet1", i, j);	
			}
			
		}
		return loginData;
		
		
	}
}
