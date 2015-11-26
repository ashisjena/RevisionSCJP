package scjp.com.java.miscellaneous.bookmanagementsystem;

import java.util.ArrayList;
import java.util.List;

public class Constants
{
	public enum NameType
	{
		AuthorName, BookName;
	}

	public enum Category
	{
		Scientific, Drama, Computer;

		private List<Book> books = new ArrayList<Book>();

		public List<Book> getAllBooksForThisCategory()
		{
			return this.books;
		}

		public void addBooks( Book book )
		{
			this.books.add( book );
		}
	}
}