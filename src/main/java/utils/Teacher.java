package utils;

/**
 * All Teacher type object are referenced
 * using the blueprint of this Teacher class
 */

public class Teacher extends Person
{
    private int id;
    private Book bookBorrowed;

    public Teacher(int id, String firstName, String lastName, String gender)
    {
        super(firstName, lastName, gender);
        this.id = id;
    }

    public int getId()
    {
        return id;
    }

    @Override
    public String role()
    {
        return "teacher";
    }

    /** bookBorrowed field to be set when the request
     * to borrow a book is granted by the librarian
     * @param bookBorrowed to this teacher
     */
    public void setBookBorrowed(Book bookBorrowed)
    {
        this.bookBorrowed = bookBorrowed;
    }

    public Book getBookBorrowed()
    {
        return bookBorrowed;
    }

    @Override
    public String toString() {
        return bookBorrowed == null ?
                "Teacher{" +
                "id=" + id +
                ", name=" + getFullName() +
                ", gender=" + getGender() +
                '}':

                "Teacher{" +
                "id=" + id +
                ", name=" + getFullName() +
                ", gender=" + getGender() +
                ", bookBorrowed=" + bookBorrowed +
                '}';
    }
}
