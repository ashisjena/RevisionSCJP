package scjp.com.java.chapter6.oldExamples;

import java.io.*;
import java.util.StringTokenizer;

public class ReadFileDemo{
	public static void main (String[] args) throws IOException{
		ReverseFileReader rfr=new ReverseFileReader(new File(args[0]));
		System.out.println (rfr.readLine());
}
}