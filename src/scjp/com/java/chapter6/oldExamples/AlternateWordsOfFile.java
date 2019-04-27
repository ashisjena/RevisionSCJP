package scjp.com.java.chapter6.oldExamples;

import java.util.StringTokenizer;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;

public class AlternateWordsOfFile{
	public static void main (String[] args) throws IOException{
		FileReader fr=new FileReader("ABC.txt");
		BufferedReader br=new BufferedReader(fr);
		//String str=br.readLine();
		int lineNo=1;
		for(String str=br.readLine();str!=null;str=br.readLine(),lineNo++){
			StringTokenizer st=new StringTokenizer(str," ",false);
			for(int wordNo=1;st.hasMoreTokens();wordNo++){
				if((wordNo%2)!=0 && (lineNo%2)!=0)
					System.out.print (st.nextToken()+" ");
				else if((wordNo%2)==0 && (lineNo%2)==0)
					System.out.print (st.nextToken()+" ");
				else
					st.nextToken();
			}
			System.out.println ();
		}
}
}