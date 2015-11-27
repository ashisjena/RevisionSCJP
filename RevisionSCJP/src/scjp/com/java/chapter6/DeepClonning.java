package scjp.com.java.chapter6;

import java.io.Serializable;
import java.io.*;

public class DeepClonning{
	public static void main (String[] args) throws IOException,ClassNotFoundException, CloneNotSupportedException{
		Myclass css=new Myclass("ram",10);
		css.address="Bangalore";
		
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		ObjectOutputStream oss=new ObjectOutputStream(bos);
		oss.writeObject(css);
		oss.flush();
		ByteArrayInputStream bis=new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream iss=new ObjectInputStream(bis);
		Myclass css2=(Myclass)iss.readObject();
		System.out.println (css2.name);
		css.name="Ravan";
		System.out.println (css2.name);
		System.out.println (css2.address);
		
		
		Myclass css3 = new Myclass("Ravana", 20);
		Myclass css4 = (Myclass) css3.clone();
		
		System.out.println(css4.your.z);
		css3.your.z = 30;
		System.out.println(css4.your.z); // Not clonning the agrregated class
		
}
}
class Myclass extends SuperClass implements Serializable, Cloneable{
	String name;
	Yourclass your;
	public Myclass(){}	;
	public Myclass(String name,int i){
		this.name=name;
		this.your=new Yourclass(i);
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException
	{
	  return super.clone();
	}
}
class Yourclass implements Serializable{
	public int z=0;
	public Yourclass(){}
	public Yourclass(int z){
		this.z=z;
	}
}
class SuperClass{
	String address="india";
}