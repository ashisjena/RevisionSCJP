package scjp.com.java.chapter6.oldExamples;

import java.io.*;

public class FileFilterInner{
	public static void main (String[] args) {
		File file=new File("D:/Revision/JSE");
		/*File[] files=file.listFiles(new FileFilter(){
											public boolean accept(File f){
												if(f.getAbsolutePath().endsWith(".java.bak") && f.isHidden())
													return true;
												else return false;
											}
										}
									);*/  //Annonymous inner class
		/*class MyFileFilter implements FileFilter{
			public boolean accept(File f){
				if(f.getAbsolutePath().endsWith(".java.bak") && f.isHidden())
					return true;
				else return false;
			}
		}
		File [] files=file.listFiles(new MyFileFilter());*/  //method local inner class
		
		File[] files=file.listFiles(new FileFilterInner().new MyFileFilter());
		System.out.println (files.length);
	}
	class MyFileFilter implements FileFilter{  //normal inner class
		public boolean accept(File f){
			if(f.getAbsolutePath().endsWith(".java.bak") && f.isHidden())
				return true;
			else return false;
		}
	}
}