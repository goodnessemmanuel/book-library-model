import utils.Book;
import utils.BookCopy;

import java.util.ArrayList;
import java.util.List;

/**
 * The library class handles all library activities.
 * you can appoint a librarian to take care of the library,
 * and manage how books can be borrowed
 */

public class Library
{
    private String name;
    private Librarian librarian;
    public List<Book> bookCollection;

    public Library()
    {
        this("Library Name");
    }

    public Library(String name)
    {
        this.name = name;
        bookCollection = new ArrayList<>();
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void appointLibrarian(Librarian librarian)
    {
        this.librarian = librarian;
    }

    public String getName()
    {
        return name;
    }

    //add book to library
    public void addBook(Book book)
    {
        if (book != null)
        {
            bookCollection.add(book);
        }
    }

    /**
     * @param books add multiple book
     */
    public void addBooks(List<Book> books)
    {
        books.forEach(this::addBook);
    }

    public int totalBookCopies()
    {
        return bookCollection.size();
    }

}
