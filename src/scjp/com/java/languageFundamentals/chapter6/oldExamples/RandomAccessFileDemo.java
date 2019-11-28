package scjp.com.java.languageFundamentals.chapter6.oldExamples;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
//import java.util.Stack;
import java.util.StringTokenizer;

public class RandomAccessFileDemo{
	public static void main (String[] args) {
		ReverseFileReaderDemo rfrd=null;
		//Stack stack=null;
		try{
			rfrd=new ReverseFileReaderDemo(new File("F:/IIIII/Revision/JSE/FileIO/ABC.txt"));
			//stack=new Stack();
			String str[]=null;
			for(String text=rfrd.readLine();text!=null;text=rfrd.readLine()){
				str=rfrd.readWords(text);
				for(int i=str.length-1;i>=0;i--)
					System.out.print (str[i]);
				
				/*StringTokenizer tokens=new StringTokenizer(text," .,'-\"",true);
				while(tokens.hasMoreTokens())
					stack.push(tokens.nextToken());
				StringBuilder sb;
				while(!stack.isEmpty()){
					sb=new StringBuilder((String)stack.pop());
					System.out.print(sb.reverse().toString());	
				}*/
				System.out.println ();
			}
		}catch(IOException ie){
			ie.printStackTrace();
		}finally{
			try{
				rfrd.close();
			}catch(IOException ie){
				ie.printStackTrace();
			}
		}
	}
}

class ReverseFileReaderDemo{
	private Map<Integer,Long> lineToPosition=null;
	private RandomAccessFile file=null;
	private StringTokenizer tokens=null;
	private int line;
	
	public ReverseFileReaderDemo(File file) throws IOException{
		this.file=new RandomAccessFile(file,"r");
	}
	private void init() throws IOException{
		lineToPosition=new HashMap<Integer,Long>();
		lineToPosition.put(0,0L);
		line=0;
		while(true){
			String text=file.readLine();
			if(text==null)
				break;
			++line;
			lineToPosition.put(line,file.getFilePointer());
		}
		lineToPosition.remove(line);
		--line;
	}
	public String readLine() throws IOException{
		if(lineToPosition==null)
			init();
		Long index=lineToPosition.get(line);
		if(index==null)
			return null;
		else{
			file.seek(index);
			--line;
			return file.readLine();
		}
	}
	public String[] readWords(String text){
		if(text==null){
			return null;
		}else{
			tokens=new StringTokenizer(text," .,'-\"",true);
			String str[]=new String[tokens.countTokens()];
			for(int i=0;tokens.hasMoreTokens();i++)
				str[i]=new StringBuilder(tokens.nextToken()).reverse().toString();
			
			return str;			
		}
	}
	public void close() throws IOException{
		file.close();
	}
}