package generic;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Lib {

	public static String getProperty(String config_path, String key){

		String property="";
		Properties prop = new Properties();
		try{
			prop.load(new FileInputStream(config_path));
			property = prop.getProperty(key);
		}catch(Exception e){

		}
		return property;
	}


	public static String getCellValue(String excel_path, String sheet, int row, int column){
		String value = "";
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(excel_path));
			value = wb.getSheet(sheet).getRow(row).getCell(column).toString();
		} catch (Exception e) {

		}
		return value;
	}

	public static int getRowCount(String excel_path, String sheet){
		int rowCount = 0;
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(excel_path));
			rowCount = wb.getSheet(sheet).getLastRowNum();
		} catch (Exception e) {

		}
		return rowCount;
	}
	
	public static int getColumnCount(String excel_path, String sheet, int row){
		int columnCount = 0;
		try {
			Workbook wb = WorkbookFactory.create(new FileInputStream(excel_path));
			columnCount = wb.getSheet(sheet).getRow(row).getLastCellNum();
		} catch (Exception e) {

		}
		return columnCount;
	}





















}
