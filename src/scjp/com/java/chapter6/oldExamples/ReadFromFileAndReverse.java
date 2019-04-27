package scjp.com.java.chapter6.oldExamples;
import java.io.*;
import java.util.*;

public class ReadFromFileAndReverse{
	public static void main (String[] args) throws IOException{
		
		/*File f=new File(args[0]);
		BufferedReader br=new BufferedReader(new FileReader(f));
		System.out.println (br.readLine());*/
		
		FileReader logReader = null; 
        try {
        	logReader=new FileReader("ABC.txt");
            BufferedReader buffer = new BufferedReader(logReader);
            for (String line = buffer.readLine(); line != null; line = buffer.readLine()) {
            	StringTokenizer tokens = new StringTokenizer(line, " .,\"-",true);
            	/*String str[]=line.split("[ .]");
            	for(String st:str){
            		StringBuilder sb=new StringBuilder(st);
            		System.out.print (sb.reverse().toString()+" ");
            	}*/
            	while(tokens.hasMoreTokens()){
            		StringBuilder sb=new StringBuilder(tokens.nextToken());
            		System.out.print (sb.reverse().toString());
            	}
            	System.out.println ();
            }
        }catch(IOException e){
            	e.printStackTrace();
        }finally {
        		logReader.close();
        }

}
}