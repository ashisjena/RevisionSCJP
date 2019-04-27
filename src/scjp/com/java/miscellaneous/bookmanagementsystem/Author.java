package scjp.com.java.miscellaneous.bookmanagementsystem;

import java.util.ArrayList;
import java.util.List;

public class Author implements Comparable<Author>
{
	private String authorName;
	private List<Book> books;

	public Author( String authorName )
	{
		this.authorName = authorName;
		books = new ArrayList<Book>();
	}

	public String getName()
	{
		return this.authorName;
	}

	public List<Book> getAllBooksWritten()
	{
		return this.books;
	}

	public void addBooks( Book book )
	{
		this.books.add( book );
	}

	@Override
	public int compareTo( Author o )
	{
		return this.authorName.compareTo( o.authorName );
	}
}