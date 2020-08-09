package utils;

/**
 * This is a book, create an instance
 * of it and add it to the library
 */

public class Book extends BookCopy
{
    private int isbn;
    private String title;
    private String author;

    public Book(int isbn, String title, String author)
    {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
    }

    public int getIsbn()
    {
        return isbn;
    }

    public void setIsbn(int isbn)
    {
        this.isbn = isbn;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public String getAuthor()
    {
        return author;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public String borrow()
    {
        return null;
    }

    public void updateBookStatus()
    {

    }

    @Override
    public String toString()
    {
        return "utils.Book{" +
                "id=" + isbn +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
