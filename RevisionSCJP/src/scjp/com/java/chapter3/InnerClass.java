package scjp.com.java.chapter3;

public class InnerClass
{

	public static void main( String[] args )
	{
		Abc abc = new InnerClass().new Abc();
		abc.method1();
	}

	class Abc
	{
		public int a = 5;

		public void method1()
		{
			int x = Abc.this.a;
			System.out.println(x);
		}
	}
}
