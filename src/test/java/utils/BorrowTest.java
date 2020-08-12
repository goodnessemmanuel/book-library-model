package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BorrowTest
{
    @Test
    @DisplayName("Should process correct date")
    void shouldDisplayCorrectDate()
    {
        String expected = "11/8/2020"; //date as at when I wrote this test
        Borrow borrow = new Borrow(new Book(1232, "James Smith", "Paul T."));
        String actual = borrow.getDateBorrowed();

        assertEquals(expected, actual, "Should display date book was borrowed");
    }
}
