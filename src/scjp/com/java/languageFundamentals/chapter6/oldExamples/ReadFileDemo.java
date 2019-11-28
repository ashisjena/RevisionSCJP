package scjp.com.java.languageFundamentals.chapter6.oldExamples;

import java.io.*;

public class ReadFileDemo{
	public static void main (String[] args) throws IOException{
		ReverseFileReader rfr=new ReverseFileReader(new File(args[0]));
		System.out.println (rfr.readLine());
}
}