import utils.Book;

public abstract class Borrow
{
    private int id;
    private String dateBorrowed;
    private Book book;

    public Borrow(int id, String date, Book book)
    {
        this.id = id;
        this.dateBorrowed = date;
        this.book = book;
    }
}
