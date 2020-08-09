import utils.Book;
import utils.Person;

import java.util.List;

/**
 * This class monitor library members privilege.
 * Create a Librarian object to supervise how books
 * are given to borrowers
 */

public class Librarian extends Person
{
    List<Book> books;
    public Librarian(String firstName, String lastName, String gender)
    {
        super(firstName, lastName, gender);
    }

    public void give(Book book, String role)
    {
        //return null;
    }

    public Book searchForBook()
    {
        return null;
    }

    @Override
    public String role()
    {
        return "librarian";
    }

}
