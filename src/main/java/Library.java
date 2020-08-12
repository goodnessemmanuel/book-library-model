import utils.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Set up a library instance with this class.
 * use the add book method to add book/s to
 * the created instance.
 */

public class Library
{
    private String name;
    private static List<Book> books;

    public Library()
    {
        this("Library Name"); //default name
    }

    public Library(String name)
    {
        this.name = name;
        books = new ArrayList<>(10); //initial capacity
    }

    public void setName(String name)
    {
        this.name = name;
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
            books.add(book);
        }
    }

    /**
     * @param books add multiple book
     */
    public void addBooks(List<Book> books)
    {
        books.forEach(this::addBook);
    }

    public static List<Book> getBooks()
    {
        return books;
    }

    public int totalBookCopies()
    {
        return books.size();
    }

    /**
     * @return a formatted string of
     * all the book in the Library
     */
    @Override
    public String toString()
    {
        return books.stream().map(Book::toString).collect(Collectors.joining("\n"));
    }
}
