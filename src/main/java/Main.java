import utils.*;
import utils.Class;

import java.util.*;

public class Main
{
    static Library library;

    public static void main(String[] args)
    {
        library = new Library("Nelson Mandela");

        //create book object
        Book book1 =  new Book(3421, "Fundamentals of Physics", "P.N Okeke");
        book1.addCopies(4);
        Book book2 =  new Book(1234, "Chemistry", "Thomas J.", 2);
        Book book3 =  new Book(3461, "Dominion Attitude", "Paul Joan", 5);

        //add book to library
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        System.out.println(library.toString()); //view all library book

        //create a liberian to take care of library
        Librarian librarian = new Librarian("James", "Aristole", "male");

        //create teachers and student to use library
        Student student1 = new Student(1, "John", "Tennison", "male", new Class("Jss1"));
        Student student2 = new Student(2, "Kosh", "Stephanie", "female", new Class("SS2"));
        Teacher teacher1 = new Teacher(3, "Linda", "Gates", "female");
        Teacher teacher2 = new Teacher(2, "Andrew", "Gibson", "Male");

        //initiate all borrow request by teacher and/or student
        Borrow student1RequestBook1 = student1.borrow(book1);
        Borrow studentRequestBook2 = student2.borrow(book1);
        Borrow teacher1RequestBook1 = teacher1.borrow(book1);

        System.out.println(student1RequestBook1.equals(teacher1RequestBook1));

        //map each teacher or student to their borrow request
        Map<Person, Borrow> borrowRequestMap = new HashMap<>();

        borrowRequestMap.put(teacher1, teacher1RequestBook1);
        borrowRequestMap.put(student1, student1RequestBook1);
        borrowRequestMap.put(student2, studentRequestBook2);

        //get the borrow order of priority from the librarian
        //BorrowComparator<? extends Person> comparator = new BorrowComparator<>();

        /*Queue<Person> borrowRequestsQueue = new PriorityQueue<>(2, librarian.prioritize());
        borrowRequestsQueue.offer(student1);
        borrowRequestsQueue.offer(student2);
        borrowRequestsQueue.offer(teacher1);*/

        Set<Person> people = borrowRequestMap.keySet();
        Queue<Person> borrowRequestsQueue = new PriorityQueue<>(3, librarian.prioritize());
        people.forEach(borrowRequestsQueue::offer);
//        borrowRequestsQueue.offer(borrowRequestMap.get(student1));
//        borrowRequestsQueue.offer(student2);
//        borrowRequestsQueue.offer(teacher1);

        //borrowRequestsQueue.forEach(b -> System.out::println);
        System.out.println("check: "+ borrowRequestsQueue.peek());
        System.out.println("1st: "+ borrowRequestsQueue.poll());
        System.out.println("2nd: "+ borrowRequestsQueue.poll());
        System.out.println("3rd: "+ borrowRequestsQueue.poll());
        //librarian.

        //adding multiple books to library
        //loadLibraryBooks();

        Person student = new Student(1, "", "", "", new Class("Jss1"));
        Person teacher = new Teacher(1, "", "", "Male");


    }

    private static void loadLibraryBooks()
    {
        //create a book
        Book book1 = new Book(3421, "Fundamentals of Physics", "P.N Okeke");
        //add more copies of the book
        //book1 = new BookCopy(book1, 5);

        //utils.Book  bookCopy = new BookCopy(book, 6);
        //BookCopy book1 = new BookCopy(new utils.Book(3421, "Fundamentals of Physics", "P.N Okeke"), 5);

        library.addBook(new Book(3421, "Fundamentals of Physics", "P.N Okeke"));
        library.addBook(new Book(56721, "Physical Chemistry", "THOMPSON"));
        library.addBook(new Book(92213, "Legacy Key", "John Keys"));
        library.addBook(new Book(34613, "Dominion Attitude", "Paul Joan"));
    }
}
