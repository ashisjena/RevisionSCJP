package scjp.com.java.companies.wallmart;

/*
 *
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;

import scjp.com.java.MathUtil;

public class CowAndSheep
{
	private static Coordinate coordinate = null;

	public static void main( String args[] ) throws Exception
	{
		BufferedReader br = new BufferedReader( new InputStreamReader( System.in ) );
		String line1 = br.readLine();

		String[] line1Values = line1.split( "\\s" );

		int noOfRows = Integer.parseInt( line1Values[0] );
		int noOfColumns = Integer.parseInt( line1Values[1] );

		String[][][] grassField = new String[noOfRows][noOfColumns][2];

		for ( int i = 0; i < noOfRows; i++ )
		{
			String line = br.readLine();
			String[] row = line.split( "" );
			int k = 1;
			for ( String[] value : grassField[i] )
				value[0] = row[k++];
		}

		coordinate = new Coordinate( noOfRows, noOfColumns );
		int countOfGrassCells = 0;
		for ( int i = 0; i < noOfRows; i++ )
			for ( int j = 0; j < noOfColumns; j++ )
				if ( markAdjecentCoordinates( i, j, grassField ) )
					countOfGrassCells++;

		System.out.println( countOfGrassCells );

		if ( MathUtil.isEven( countOfGrassCells ) )
			System.out.println( getNoOfCombination( 2, countOfGrassCells - 2 ) );
		else
			System.out.println( getNoOfCombination( 1, countOfGrassCells - 1 ) );
	}

	private static boolean markAdjecentCoordinates( int rowIndex, int columnIndex, String[][][] grassField )
	{
		if ( grassField[rowIndex][columnIndex][0].equals( "Y" ) && grassField[rowIndex][columnIndex][1] == null )
		{
			grassField[rowIndex][columnIndex][1] = "Y";
			if ( coordinate.isValidCoordinate( rowIndex - 1, columnIndex ) )
				markAdjecentCoordinates( rowIndex - 1, columnIndex, grassField );

			if ( coordinate.isValidCoordinate( rowIndex, columnIndex - 1 ) )
				markAdjecentCoordinates( rowIndex, columnIndex - 1, grassField );

			if ( coordinate.isValidCoordinate( rowIndex, columnIndex + 1 ) )
				markAdjecentCoordinates( rowIndex, columnIndex + 1, grassField );

			if ( coordinate.isValidCoordinate( rowIndex + 1, columnIndex ) )
				markAdjecentCoordinates( rowIndex + 1, columnIndex, grassField );

			return true;
		}

		return false;
	}

	private static int getNoOfCombination( int noOfCows, int noOfSheeps )
	{
		int sum = 0;
		if ( noOfSheeps == 0 )
			return 1;

		// N total objects and M similar objects
		sum += ( MathUtil.findFactorial( noOfCows + noOfSheeps ) / ( MathUtil.findFactorial( noOfSheeps ) * MathUtil.findFactorial( noOfCows ) ) );
		sum += getNoOfCombination( noOfCows + 2, noOfSheeps - 2 );

		return sum;
	}
}

class Coordinate
{
	private int maxRowNumber;
	private int maxColumnNumber;

	Coordinate( int maxRowNumber, int maxColumnNumber )
	{
		this.maxRowNumber = maxRowNumber;
		this.maxColumnNumber = maxColumnNumber;
	}

	public boolean isValidCoordinate( int rowNumber, int columnNumber )
	{
		if ( rowNumber < 0 || columnNumber < 0 || rowNumber >= maxRowNumber || columnNumber >= maxColumnNumber )
			return false;
		return true;
	}
}