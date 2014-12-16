package scjp.com.java.miscellaneous.bookmanagementsystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Vector;

import org.joda.time.DateTime;

import scjp.com.java.miscellaneous.bookmanagementsystem.Constants.Category;
import scjp.com.java.miscellaneous.bookmanagementsystem.Constants.NameType;

final public class DataSystem
{
	public static final List EMPTY_LIST = new Vector( 0 );
	public static final Set EMPTY_SET = new HashSet( 0 );
	public static final String EMPTY_STRING = "";
	public static final Author DEMO_AUTHOR = new Author( EMPTY_STRING );
	public static final Book DEMO_BOOK = new Book();

	private DataSystem()
	{
		if ( Holder.INSTANCE != null )
			throw new RuntimeException( "Acess the object through getInstance()" );
	};

	private static class Holder
	{
		static final DataSystem INSTANCE = new DataSystem();
	}

	public static DataSystem getInstance()
	{
		return Holder.INSTANCE;
	}

	Map<Character, TreeMap<Book, Integer>> bookNameToBooksMap = new HashMap<Character, TreeMap<Book, Integer>>();
	Map<Character, TreeMap<Author, String>> authorNameToAuthorsMap = new HashMap<Character, TreeMap<Author, String>>();

	public List<Book> getMostSoldBooksByAuthor( Author author, int limit )
	{
		List<Book> books = author.getAllBooksWritten();
		Collections.sort( books, new Comparator<Book>()
		{
			@Override
			public int compare( Book o1, Book o2 )
			{
				return o2.getNoOfBooksSold().compareTo( o1.getNoOfBooksSold() );
			}
		} );

		return books.subList( 0, limit < books.size() ? limit : books.size() );
	}

	public List<Book> getMostSoldBooksByCategory( Category category, int limit )
	{
		List<Book> books = category.getAllBooksForThisCategory();
		Collections.sort( books, new Comparator<Book>()
		{
			@Override
			public int compare( Book o1, Book o2 )
			{
				return o2.getNoOfBooksSold().compareTo( o1.getNoOfBooksSold() );
			}
		} );

		return books.subList( 0, limit < books.size() ? limit : books.size() );
	}

	public List<Book> searchBookByBookName( String name )
	{
		if ( name == null || name.trim().equals( EMPTY_STRING ) )
			return EMPTY_LIST;

		TreeMap<Book, Integer> books = this.bookNameToBooksMap.get( name.trim().charAt( 0 ) );
		Book fromBook = new Book();
		fromBook.setBookName( name );
		Book toBook = new Book();
		toBook.setBookName( name.substring( 0, name.length() - 1 ) + name.charAt( name.length() - 1 ) );
		SortedMap<Book, Integer> subMap = books.subMap( fromBook, true, toBook, false );
		
		if ( subMap.size() == 0 )
			return EMPTY_LIST;
		
		return new ArrayList<Book>( subMap.keySet() );
	}

	public List<Book> searchBookByAuthorName( String name )
	{
		if ( name == null || name.trim().equals( EMPTY_STRING ) )
			return EMPTY_LIST;

		TreeMap<Author, String> authorsMap = this.authorNameToAuthorsMap.get( name.trim().charAt( 0 ) );
		Author fromAuthor = new Author( name );
		Author toAuthor = new Author( name.substring( 0, name.length() - 1 ) + name.charAt( name.length() - 1 ) );
		SortedMap<Author, String> subMap = authorsMap.subMap( fromAuthor, true, toAuthor, false );

		if ( subMap.size() == 0 )
			return EMPTY_LIST;

		List<Book> books = new ArrayList<Book>();
		for ( Author author : subMap.keySet() )
			books.addAll( author.getAllBooksWritten() );

		return books;
	}

	public List<Book> searchBook( String name, NameType nameType )
	{
		if ( nameType.equals( NameType.AuthorName ) )
			return searchBookByAuthorName( name );
		else if ( nameType.equals( NameType.BookName ) )
			return searchBookByBookName( name );
		else
			return EMPTY_LIST;
	}

	public boolean addBookToCatalog( String name, Author author, Publisher publisher, DateTime yearOfPublication, Category category, Double price, int noOfBooks )
	{
		if ( name == null || name.trim().equals( EMPTY_STRING ) )
			return false;

		// other checks

		List<Book> books = searchBookByBookName( name );
		if ( books == EMPTY_LIST )
			addToCatalog( name, author, publisher, yearOfPublication, category, price, noOfBooks );
		else if ( books.size() > 1 )
		{
			return false;
			// error
		}
		else
		{
			Book book = books.get( 0 );
			book.addNoOfBooks( noOfBooks );
		}

		return true;
	}

	private void addToCatalog( String name, Author author, Publisher publisher, DateTime yearOfPublication, Category category, Double price, int noOfBooks )
	{
		final Book book = new Book( name.trim(), author, publisher, yearOfPublication, category, price );
		TreeMap<Book, Integer> books = bookNameToBooksMap.get( name.trim().charAt( 0 ) );
		if ( books == null )
		{
			synchronized (bookNameToBooksMap)
			{
				if ( books == null )
				{
					books = new TreeMap<Book, Integer>();
					bookNameToBooksMap.put( name.trim().charAt( 0 ), books );
				}
			}
		}

		synchronized (books)
		{
			books.put( book, 0 );
		}
	}

	public Author getAuthor( String name )
	{
		if ( name == null || name.trim().equals( EMPTY_STRING ) )
			return DEMO_AUTHOR;

		final Author author = new Author( name.trim() );
		TreeMap<Author, String> authors = authorNameToAuthorsMap.get( name.trim().charAt( 0 ) );
		if ( authors == null )
		{
			synchronized (authorNameToAuthorsMap)
			{
				if ( authors == null )
				{
					authors = new TreeMap<Author, String>();
					authorNameToAuthorsMap.put( name.trim().charAt( 0 ), authors );
				}
			}
		}

		synchronized (authors)
		{
			authors.put( author, EMPTY_STRING );
		}

		return author;
	}
}