import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import utils.Book;
import utils.Borrow;

import static org.junit.jupiter.api.Assertions.*;

class LibrarianTest {

    @DisplayName("When a book is borrowed, total copy should drop by 1")
    @Test
    void give()
    {
        Librarian librarian = new Librarian("tony", "Gibson", "Male");
        Book bookToGive = new Book(1234, "Camelonia", "James", 4);

        int expected = bookToGive.getTotalCopy() - 1;
        int actual = librarian.give(new Borrow(bookToGive)).getTotalCopy();

        assertEquals(expected, actual, "Should reduce book total copy by 1");
    }
}