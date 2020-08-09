import org.junit.jupiter.api.*;
import utils.Book;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LibraryTest {
    private Library library;

    @BeforeEach
    void init()
    {
        library = new Library();
    }

    @DisplayName("Should add copy of book to the Library")
    @Test
    void shouldAddBookToLibrary()
    {
        int expected1 = library.totalBookCopies() + 1;
        Book book = new Book(1, "Fundamental Physics", "A.B Anyakowa");
        library.addBook(book);
        int actual1 = library.totalBookCopies();

        int expected2 = library.totalBookCopies();
        book = null;
        library.addBook(book);
        int actual2 = library.totalBookCopies();

        assertAll(
                () -> assertEquals(expected1, actual1, "Total book in collection should increase by 1"),
                () -> assertEquals(expected2, actual2, "Should not add null value to library books")
        );

    }

    @DisplayName("Filter out null values when adding multiple book together")
    @Test
    void shouldAddBooksToLibrary()
    {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "Fundamental Physics", "A.B Anyakowa"));
        books.add(null); //handle this, when adding to library book
        books.add(new Book(2, "New School Chemistry", "P.N Okeke"));

        int expected = library.totalBookCopies() + books.size() - 1;
        library.addBooks(books); //dont include null value/s in books list
        int actual = library.totalBookCopies();

        assertEquals(expected, actual, "Should add only book that are not null");

    }

}