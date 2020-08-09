package utils;

import java.io.Serializable;

/**
 * Welcome to BookCopy class. Create a copy of book by
 * specifying the book and the number of copies
 */

public class BookCopy implements Serializable
{
   private int numOfCopy;
   private Book  book;

   public BookCopy()
   {
       this(null); //constructor set to null if no book object is passed
   }

   public BookCopy(Book book)
   {
       this(book, 1); //set default copy to 1
   }

   public BookCopy(Book book, int numOfCopy)
   {
       this.book = book;
       this.numOfCopy = numOfCopy;
   }

    public int getNumOfCopy()
    {
        return numOfCopy;
    }

    public void setNumOfCopy(int numOfCopy)
    {
        this.numOfCopy = numOfCopy;
    }

    public Book getBook()
    {
        return book;
    }

    public void setBook(Book book)
    {
        this.book = book;
    }

    public String status()
    {
        if (numOfCopy == 0)
        {
            return "taken";
        }
        return "available";
    }

    @Override
    public String toString() {
        return "BookCopy{" +
                "book=" + book.toString() +
                ", copies=" + numOfCopy +
                '}';
    }
}
