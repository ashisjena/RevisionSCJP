package scjp.com.java.dynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class MineSweeper
{
	public final static int size = 5;
	public final static int noOfBombs = 10;
	public final static char bomb = '*';
	public final static char emptySpace = '-';
	public final static Random random = new Random();

	public static void main( String[] args )
	{
		if(noOfBombs >= (size * size))
			throw new RuntimeException( "Invalid bomb number : " + noOfBombs );
		
		char[][] matrix = new char[size][size];

		Set<Coordinate> setOfCoordinates = new HashSet<Coordinate>();
		while ( setOfCoordinates.size() < noOfBombs )
			setOfCoordinates.add( new Coordinate( random.nextInt( size ), random.nextInt( size ) ) );

		for ( Coordinate coordinate : setOfCoordinates )
			matrix[coordinate.rowNumber][coordinate.columnNumber] = bomb;

		for ( int rowIndex = 0; rowIndex < size; rowIndex++ )
			for ( int columnIndex = 0; columnIndex < size; columnIndex++ )
				if ( matrix[rowIndex][columnIndex] == bomb )
					updateAdjecentCoordinates( matrix, getValidAdjecentCoordinates( rowIndex, columnIndex ) );

		for ( int rowIndex = 0; rowIndex < size; rowIndex++ )
		{
			for ( int columnIndex = 0; columnIndex < size; columnIndex++ )
			{
				char ch = matrix[rowIndex][columnIndex];
				System.out.print( ( ch != '\u0000' ? ch : emptySpace ) + "\t" );
			}
			System.out.println( "\n\n\n" );
		}
	}

	private static void updateAdjecentCoordinates( char[][] matrix, List<Coordinate> coordinatesList )
	{
		for ( Coordinate coordinate : coordinatesList )
		{
			int rowNumber = coordinate.rowNumber;
			int columnNumber = coordinate.columnNumber;
			char ch = matrix[rowNumber][columnNumber];
			if ( ch != bomb )
			{
				int value = 0;
				if ( Character.isDigit( ch ) )
					value = Character.getNumericValue( ch );

				matrix[rowNumber][columnNumber] = ( char ) ( ( ( int ) '0' ) + ( ++value ) );
			}
		}
	}

	private static List<Coordinate> getValidAdjecentCoordinates( int rowIndex, int columnIndex )
	{
		List<Coordinate> coordinates = new ArrayList<Coordinate>();
		Coordinate.addCoordinate( rowIndex - 1, columnIndex - 1, size, coordinates );
		Coordinate.addCoordinate( rowIndex - 1, columnIndex, size, coordinates );
		Coordinate.addCoordinate( rowIndex - 1, columnIndex + 1, size, coordinates );
		Coordinate.addCoordinate( rowIndex, columnIndex - 1, size, coordinates );
		Coordinate.addCoordinate( rowIndex, columnIndex + 1, size, coordinates );
		Coordinate.addCoordinate( rowIndex + 1, columnIndex - 1, size, coordinates );
		Coordinate.addCoordinate( rowIndex + 1, columnIndex, size, coordinates );
		Coordinate.addCoordinate( rowIndex + 1, columnIndex + 1, size, coordinates );

		return coordinates;
	}
}

class Coordinate
{
	public int rowNumber;
	public int columnNumber;

	Coordinate( int rowNumber, int columnNumber )
	{
		this.rowNumber = rowNumber;
		this.columnNumber = columnNumber;
	}

	public static boolean addCoordinate( int rowNumber, int columnNumber, int maxSize, List<Coordinate> coordinates )
	{
		if ( ( rowNumber < 0 || columnNumber < 0 || rowNumber >= maxSize || columnNumber >= maxSize ) )
		{
			return false;
		}
		else
		{
			coordinates.add( new Coordinate( rowNumber, columnNumber ) );
			return true;
		}
	}

	@Override
	public boolean equals( Object obj )
	{
		if ( obj instanceof Coordinate )
		{
			Coordinate coordinate = ( Coordinate ) obj;
			return this.rowNumber == coordinate.rowNumber && this.columnNumber == coordinate.columnNumber;
		}
		else
			return false;
	}

	@Override
	public int hashCode()
	{
		return this.rowNumber;
	}
}