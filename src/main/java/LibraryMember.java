import utils.Teacher;

/**
 * Create a library member with this class.
 * @param <T>  generic is use to determine if
 *           member is a student or a teacher
 */

public class LibraryMember<T>
{
    private T member;
    public LibraryMember(T member)
    {
        this.member = member;
    }

    public void borrow()
    {
        //get the book to borrow
        //create a borrow
        //present the book to the librarian
    }

    public T getMember()
    {
        return member;
    }
}
