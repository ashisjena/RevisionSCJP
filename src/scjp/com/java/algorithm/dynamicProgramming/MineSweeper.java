package scjp.com.java.algorithm.dynamicProgramming;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class MineSweeper
{
	public final static int size = 5;
	public final static int noOfBombs = 6;
	public final static char bomb = '*';
	public final static char emptySpace = '-';
	public final static Random random = new Random();

	public static void main( String[] args )
	{
		if(noOfBombs >= (size * size))
			throw new RuntimeException( "Invalid bomb number : " + noOfBombs );
		
		char[][] matrix = new char[size][size];

		// Generating random coordinates
		Set<Coordinate> setOfCoordinates = new HashSet<Coordinate>();
		while ( setOfCoordinates.size() < noOfBombs )
			setOfCoordinates.add( new Coordinate( random.nextInt( size ), random.nextInt( size ) ) );

		// Setting Bombs in matrix
		for ( Coordinate coordinate : setOfCoordinates )
			matrix[coordinate.rowNumber][coordinate.columnNumber] = bomb;

		// Solving
		for ( int rowIndex = 0; rowIndex < size; rowIndex++ )
			for ( int columnIndex = 0; columnIndex < size; columnIndex++ )
				if ( matrix[rowIndex][columnIndex] == bomb )
					updateAdjecentCoordinates( matrix, getValidAdjecentCoordinates( rowIndex, columnIndex ) );

		// Printing the matrix
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

				matrix[rowNumber][columnNumber] = ( char ) ( ( ( int ) '0' ) + ( ++value ) ); // converting character to integer
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
	
	private static boolean isValidCoordinate(int rowIndex, int columnIndex, int max)
	{
	  if ( ( rowIndex < 0 || columnIndex < 0 || rowIndex >= max || columnIndex >= max ) )
          return false;
	  
	  return true;
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
	
	@Override
	public String toString()
	{
	 return (rowNumber + "\"" + columnNumber);
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