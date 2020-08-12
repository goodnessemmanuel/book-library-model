package utils;

/**
 * The super class of teacher and student within the library.
 * borrow a book by using the borrow request method.
 */

public abstract class Person
{
    private String firstName;
    private String lastName;
    private String gender;
    private Borrow borrowRequest;

    public Person(String firstName, String lastName, String gender)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
    }

    public String getFirstName()
    {
        return firstName;
    }

    public void setFirstName(String firstName)
    {
        this.firstName = firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public void setLastName(String lastName)
    {
        this.lastName = lastName;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }

    public String getFullName()
    {
        return String.format("%s %s", firstName, lastName);
    }

    public Borrow borrow(Book book)
    {
        setBorrowRequest(book);
        return getBorrowRequest();
    }

    public void setBorrowRequest(Book bookToBorrow)
    {
        this.borrowRequest = new Borrow(bookToBorrow);
    }

    public Borrow getBorrowRequest()
    {
        return borrowRequest;
    }

    /**
     * @return grant privileges to
     * people base on their role
     */
    public abstract String role();

}
