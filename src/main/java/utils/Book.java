package utils;

import java.io.Serializable;
import java.util.Objects;

/**
 * This is a book class, you can create
 * the object and add it to the library
 */

public class Book implements Serializable //serialize book object during storage for optimization
{
    private int isbn;
    private String title;
    private String author;
    private int totalCopy;

    public Book(int isbn, String title, String author)
    {
        this(isbn, title, author, 1); //default number of book copy is 1
    }

    public Book(int isbn, String title, String author, int totalCopy)
    {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.totalCopy = totalCopy;
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

    public void addCopies(int num)
    {
        totalCopy = num > 0 ? totalCopy + num : totalCopy; //handle negative number
    }

    public void setTotalCopy(int remainingCopy)
    {
        totalCopy = remainingCopy;
    }

    public int getTotalCopy()
    {
        return totalCopy;
    }

    public boolean isBookAvailable()
    {
        return totalCopy > 0;
    }

    @Override
    public boolean equals(Object bookObj)
    {
        if (this == bookObj)
        {
            return true;
        }

        if (bookObj == null || getClass() != bookObj.getClass())
        {
            return false;
        }

        Book book = (Book) bookObj;

        return  isbn == book.isbn &&
                title.equals(book.title) &&
                author.equals(book.author);

    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn, title, author, totalCopy);
    }

    @Override
    public String toString()
    {
        return "Book{" +
                "id=" + isbn +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                "}, Copies: " + totalCopy;
    }
}
