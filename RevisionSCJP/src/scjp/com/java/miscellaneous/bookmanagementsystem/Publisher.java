package scjp.com.java.miscellaneous.bookmanagementsystem;

import java.util.ArrayList;
import java.util.List;

public class Publisher
{
	private String publisherName;
	private List<Book> books;

	public Publisher( String publisherName )
	{
		this.publisherName = publisherName;
		books = new ArrayList<Book>();
	}
	
	public String getName()
	{
		return this.publisherName;
	}
	
	public List<Book> getAllBooksWritten()
	{
		return this.books;
	}
	
	public void addBooks(Book book)
	{
		this.books.add( book );
	}
}