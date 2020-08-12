import utils.Book;
import utils.Borrow;
import utils.Person;
import utils.Student;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Librarian class
 */

public class Librarian extends Person
{

    private static Queue<Borrow> borrowQueue;

    public Librarian(String firstName, String lastName, String gender)
    {
        super(firstName, lastName, gender);
        borrowQueue = new LinkedList<>();
    }

    public Book give(Borrow borrow)
    {
        Queue<Borrow> borrowQueue = Library.getBorrowQueue();

        for (Borrow borrow1: borrowQueue)
        {

        }
        Book book = borrow.getBook();
        int currentCopy = book.getTotalCopy();
        book.setTotalCopy(currentCopy - 1);
        return book;
    }


    @Override
    public String role()
    {
        return "librarian";
    }

    public static BorrowComparator<? extends Person> firstComeFirstServe()
    {
        return new BorrowComparator<>();
    }

    /**
     * Librarian private comparator
     * class to maintain queue order
     * @param <T> Comparator generic
     */

    private static class BorrowComparator<T> implements Comparator<Borrow>
    {
        @Override
        public int compare(Borrow left, Borrow right)
        {
            /*if(left.equals(right))
            {
                Person p1 = left.getMember();
                Person p2 = right.getMember();
                if ( p2.role().equals("student") && p1.role().equals("teacher"))
                {
                    return -1;
                }
            }*/
            return 0;
        }
    }
}
