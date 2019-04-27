package scjp.com.java.miscellaneous.bookmanagementsystem;

import java.util.concurrent.atomic.AtomicLong;

import org.joda.time.DateTime;

import scjp.com.java.miscellaneous.bookmanagementsystem.Constants.Category;

public class Book implements Comparable<Book>
{
	private String bookName;
	private Author author;
	private Publisher publisher;
	private DateTime publishedYear;
	private Category category;
	private Double price;
	private AtomicLong noOfBooksSold = new AtomicLong();
	private AtomicLong noOfBooksInStock = new AtomicLong();

	public Book()
	{
	}

	public Book( String bookName, Author author, Publisher publisher, DateTime publishedYear, Category category, Double price )
	{
		this.bookName = bookName;
		this.author = author;
		this.publisher = publisher;
		this.publishedYear = publishedYear;
		this.category = category;
		this.price = price;
		
		this.author.addBooks( this );
		this.publisher.addBooks( this );
		this.category.addBooks( this );
	}

	public String getBookName()
	{
		return bookName;
	}

	public void setBookName( String bookName )
	{
		this.bookName = bookName;
	}

	public Author getAuthor()
	{
		return author;
	}

	public void setAuthor( Author author )
	{
		this.author = author;
		this.author.addBooks( this );
	}

	public Publisher getPublisher()
	{
		return publisher;
	}

	public void setPublisher( Publisher publisher )
	{
		this.publisher = publisher;
		this.publisher.addBooks( this );
	}

	public DateTime getPublishedYear()
	{
		return publishedYear;
	}

	public void setPublishedYear( DateTime publishedYear )
	{
		this.publishedYear = publishedYear;
	}

	public Category getCategory()
	{
		return category;
	}

	public void setCategory( Category category )
	{
		this.category = category;
	}

	public Double getPrice()
	{
		return price;
	}

	public void setPrice( Double price )
	{
		this.price = price;
	}

	public Long getNoOfBooksSold()
	{
		return noOfBooksSold.longValue();
	}

	public void bookSold()
	{
		this.noOfBooksSold.incrementAndGet();
	}
	
	public Long getNoOfBooksInStock()
	{
		return noOfBooksInStock.longValue();
	}
	
	public void addNoOfBooks(int value)
	{
		noOfBooksInStock.addAndGet( value );
	}

	@Override
	public int compareTo( Book o )
	{
		return this.bookName.compareTo( o.bookName );
	}
}