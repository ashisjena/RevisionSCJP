package scjp.com.java.poi;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.joda.time.format.DateTimeFormatter;

//import com.azure.sparkcommon.SparkDate;

public class PoiSampleDemo
{
	public static final String EMPTY_STRING = "";
	public static final String EXCEL_GENERAL_FIELD_FORMAT_CODE = "General";
	public static final int SYSTEM_DP = 6;
	//public static final DateTimeFormatter dateStringForStorageFormatter = SparkDate.dateStringForStorageFormatter;

	public static void main( String[] args ) throws InvalidFormatException, IOException
	{
		FileInputStream inputFile = new FileInputStream( "1Singtel_Carrier_Invoice_Jan_2012_1.xls" );
		Workbook workBook = WorkbookFactory.create( inputFile );
		FormulaEvaluator formulaEvaluator = workBook.getCreationHelper().createFormulaEvaluator();
		Sheet sheet = workBook.getSheet( "Summary" );
		Row sheetRow = sheet.getRow( 0 );
		Cell cell = sheetRow.getCell( 0, Row.CREATE_NULL_AS_BLANK );
		String string = readExcelCell( cell, formulaEvaluator );
		System.out.println( "Cell Value, " + string );
	}

	public static String readExcelCell( Sheet sheet, int column, int row, FormulaEvaluator evaluator )
	{
		Row sheetRow = sheet.getRow( row );
		if ( sheetRow == null )
			throw new RuntimeException( "No Row retrieved from the File with row number " + row + 1 );

		Cell sheetCell = sheetRow.getCell( column, Row.CREATE_NULL_AS_BLANK );
		if ( sheetCell == null )
			throw new RuntimeException( "No cell read from the File with row number " + ( row + 1 ) + " and column number " + ( column + 1 ) );

		String value = readExcelCell( sheetCell, evaluator );
		return ( value != null ) ? value : EMPTY_STRING;
	}

	public static String readExcelCell( Cell sheetCell, FormulaEvaluator evaluator )
	{
		switch( sheetCell.getCellType() )
		{
		case Cell.CELL_TYPE_STRING:
			return sheetCell.getStringCellValue();
		case Cell.CELL_TYPE_NUMERIC:
			if ( DateUtil.isCellDateFormatted( sheetCell ) )
			{
				return getDateTimeFormatter().print( sheetCell.getDateCellValue().getTime() );
			}
			else
			{
				String dataFormatString = sheetCell.getCellStyle().getDataFormatString();
				if ( dataFormatString.equals( EXCEL_GENERAL_FIELD_FORMAT_CODE ) || dataFormatString.equals( "0" ) )
				{
					return String.valueOf( ( int ) sheetCell.getNumericCellValue() );
				}
				else
				{
					double cellToDouble = Double.parseDouble( sheetCell.toString() );
					return new BigDecimal( cellToDouble ).setScale( SYSTEM_DP, RoundingMode.HALF_UP ).stripTrailingZeros().toPlainString();
				}
			}
		case Cell.CELL_TYPE_FORMULA:
			CellValue cellValue = evaluator.evaluate( sheetCell );
			switch( cellValue.getCellType() )
			{
			case Cell.CELL_TYPE_STRING:
				return sheetCell.getStringCellValue();
			case Cell.CELL_TYPE_NUMERIC:
				if ( DateUtil.isCellDateFormatted( sheetCell ) )
				{
					return getDateTimeFormatter().print( sheetCell.getDateCellValue().getTime() );
				}
				else
				{
					String dataFormatString = sheetCell.getCellStyle().getDataFormatString();
					if ( dataFormatString.equals( EXCEL_GENERAL_FIELD_FORMAT_CODE ) || dataFormatString.equals( "0" ) )
					{
						return String.valueOf( ( int ) sheetCell.getNumericCellValue() );
					}
					else
					{
						double cellToDouble = Double.parseDouble( sheetCell.toString() );
						return new BigDecimal( cellToDouble ).setScale( SYSTEM_DP, RoundingMode.HALF_UP ).stripTrailingZeros().toPlainString();
					}
				}
			case Cell.CELL_TYPE_BLANK:
				return EMPTY_STRING;
			default:
				return EMPTY_STRING;
			}
		}
		return EMPTY_STRING;
	}

	private static DateTimeFormatter getDateTimeFormatter()
	{
		// TODO Auto-generated method stub
		return null;
	}
}