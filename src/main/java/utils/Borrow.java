package utils;
import java.util.Calendar;
import java.util.Objects;

/**
 * A student or a teacher can borrow book
 * from the library by calling this class
 */

public class Borrow
{
    private final Book book;
    private String dateBorrowed;

    public Borrow(Book book)
    {
        this.book = book;
        setDateBorrowed();
    }

    /**
     * compute the date book was borrowed
     */
    private void setDateBorrowed()
    {
        Calendar cal = Calendar.getInstance();
        dateBorrowed =
                String.format("%s/%s/%s", cal.get(Calendar.DAY_OF_MONTH),
                        cal.get(Calendar.MONTH) + 1, cal.get(Calendar.YEAR)); //month should read 1 to 12 not 0 to 11
    }

    public String getDateBorrowed()
    {
        return dateBorrowed;
    }

    public Book getBook()
    {
        return book;
    }

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (!(o instanceof Borrow)) return false;
        Borrow borrow = (Borrow) o;
        return Objects.equals(book, borrow.book) &&
                Objects.equals(dateBorrowed, borrow.dateBorrowed);
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(book, dateBorrowed);
    }

    @Override
    public String toString()
    {
        return "Borrow{" +
                "book=" + book.toString() +
                ", dateBorrowed='" + dateBorrowed + '\'' +
                '}';
    }
}
