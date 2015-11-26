package scjp.com.java;

import java.io.IOException;

public class CleanAfterTest
{
	public static void main( String[] args ) throws IOException
	{
	  Integer i = new Integer(3);
	  Integer j = new Integer(3);
	  
    if (i == j)
      System.out.println("==");

    if (i == 3)
      System.out.println("Wrapper and primitive");
    
    i = j = 345435435;
    
    if(i == j)
      System.out.println("Equal working");
	  
	  /*try 
      { 
          return; 
      } 
      finally 
      {
          System.out.println( "Finally" ); 
      } */
	  
	  if( "Welcome".trim() == "Welcome".trim() )
	    System.out.println("Equal");
	    else
	    System.out.println("Not Equal");

	}
}