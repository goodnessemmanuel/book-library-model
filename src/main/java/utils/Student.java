package utils;

/**
 * All Student type object are referenced
 * using the blueprint of this Student class
 */

public class Student extends Person
{
    private int id;
    private Class sClass;
    private Book bookBorrowed;

    public Student(int id, String firstName, String lastName, String gender, Class sClass)
    {
        super(firstName, lastName, gender);
        this.id = id;
        this.sClass = sClass;
    }

    @Override
    public String role()
    {
        return "student";
    }

    public Class getsClass()
    {
        return sClass;
    }

    /** bookBorrowed field to be set when
     * request to borrow is granted by the librarian
     * @param bookBorrowed to this student
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

                "Student{" +
                "id=" + id +
                ", FullName=" + this.getFullName() +
                ", FullName=" + this.getGender() +
                ", sClass=" + sClass.toString() +
                '}' :

                "Student{" +
                "id=" + id +
                ", FullName=" + this.getFullName() +
                ", gender=" + this.getGender() +
                ", Class=" + sClass.toString() +
                ", bookBorrowed=" + bookBorrowed +
                '}';
    }
}
