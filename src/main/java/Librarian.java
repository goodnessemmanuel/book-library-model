import utils.Book;
import utils.Borrow;
import utils.Person;
import utils.Student;

import java.util.Comparator;

/**
 * Librarian class
 */

public class Librarian extends Person
{

    public Librarian(String firstName, String lastName, String gender)
    {
        super(firstName, lastName, gender);
    }

    public Book give(Borrow borrow)
    {
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

    public BorrowComparator<? extends Person> prioritize ()
    {
        return new BorrowComparator<>();
    }

    /**
     * Librarian private comparator
     * class to maintain queue order
     * @param <T> Comparator generic
     */

    private static class BorrowComparator<T> implements Comparator<Person>
    {
        @Override
        public int compare(Person left, Person right)
        {
            if(left.role().equals("student") && right.role().equals("teacher")
            && left.getBorrowRequest().equals(right.getBorrowRequest())) //student order the same book as teacher
            {
                return 1; //swap position so teacher should come first
            }
            if((left.role().equals("student") && right.role().equals("student")) ||
                    (right.role().equals("student") && left.role().equals("student")  &&
                    left.getBorrowRequest().equals(right.getBorrowRequest())))
            {
                Student student1 = (Student)left;
                Student student2 = (Student)right;
                if (checkSenior(student2.getsClass().getName()) && !checkSenior(student1.getsClass().getName()))
                {
                    return -1; //senior student order the same book with junior student, swap them
                }
            }

            return 0;
        }

        private boolean checkSenior(String name) //check student seniority
        {
            boolean seniorStatus = true;
            switch (name.toLowerCase())
            {
                case "jss1":
                case "jss2":
                case "jss3":
                    seniorStatus = false;
                    break;

                case "ss1":
                case "ss2":
                case "ss3":
                    seniorStatus = true;
                break;
            }
            return seniorStatus;
        }

    }
}
