import utils.*;
import utils.Class;

import java.io.*;
import java.util.*;

public class Main
{
    static Library library;
    static Librarian librarian;
    static String fileName;
    static Scanner sc;
    static boolean running = true;

    public static void main(String[] args)
    {
        library = new Library("Nelson Mandela");


        //create book object
        Book book1 =  new Book(3421, "Fundamentals of Physics", "P.N Okeke");
        book1.addCopies(0);
        Book book2 =  new Book(1234, "Chemistry", "Thomas J.", 2);
        Book book3 =  new Book(3461, "Dominion Attitude", "Paul Joan", 5);

        //add book to library
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        System.out.println(library.toString()); //view all library book

        //create a liberian to take care of library
        librarian = new Librarian("James", "Aristole", "male");

        //create teachers and student to use library
        Student student1 = new Student(1, "John", "Tennison", "male", new Class("Jss1"));
        Student student2 = new Student(2, "Kosh", "Stephanie", "female", new Class("SS2"));
        Teacher teacher1 = new Teacher(3, "Linda", "Gates", "female");
        Teacher teacher2 = new Teacher(2, "Andrew", "Gibson", "Male");

        //initiate all borrow request by teacher and/or student
        Borrow borrowStudent1 = new Borrow(student1, book1);
        Borrow borrowStudent2 = new Borrow(student2, book2);
        Borrow borrowTeacher1 = new Borrow(teacher1, book1);
        Borrow borrowTeacher2 = new Borrow(teacher2, book3);

        //borrowers queue up on first come first serve base
        Queue<Borrow> borrowRequestsQueue = new LinkedList<>();
        borrowRequestsQueue.offer(borrowStudent1);
        borrowRequestsQueue.offer(borrowStudent2);
        borrowRequestsQueue.offer(borrowTeacher1);
        borrowRequestsQueue.offer(borrowTeacher2);

        //set library borrow request queue
        library.setBorrowQueue(borrowRequestsQueue);


        //poll queue to grant borrow request;

        System.out.println("1st: "+ borrowRequestsQueue.poll());
        System.out.println("2nd: "+ borrowRequestsQueue.poll());
        System.out.println("3rd: "+ borrowRequestsQueue.poll());
        System.out.println("4th: "+ borrowRequestsQueue.poll());


    }

    private static void loadLibraryBooks()
    {
        System.out.println("Choose file to load ");
        fileName = sc.next();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try
        {
            fis = new FileInputStream(new File(fileName + ".ser")); //save with dot ser for serializable object
            ois = new ObjectInputStream(fis);
            library = (Library) ois.readObject();
            fis.close();
            ois.close();
        }
        catch (IOException | ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    //run libra
    private static void addBookToLib() {
        String  title, author;
        int isbn;
        System.out.println("\nEnter book title ");
        title = sc.next();
        System.out.println("\nEnter book author ");
        author = sc.next();
        System.out.println("\nEnter book isbn ");
        isbn = sc.nextInt();
        Book book = new Book(isbn, title, author);
        library.addBook(book);
    }

    private static void saveAndQuit()
    {
        System.out.println("Enter a file name ");
        running = false;
        fileName = sc.next();
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try
        {
            File file = new File(fileName + ".ser");
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(library); //takes only object that are serializable else an exception will be thrown
            fos.flush();
            oos.flush();
            fos.close();
            oos.close();

        }
        catch (IOException e)
        {
            System.out.println("Inside write catch exception block");
            e.printStackTrace();
        }
    }

    private static void grantLibraryUserBorrowRequest()
    {
        Scanner scanner = new Scanner(System.in);
        Queue<Borrow> borrowRequestsQueue = Library.getBorrowQueue(); //queue to borrow

        for (Borrow borrow: borrowRequestsQueue)
        {
            if (borrow.getBook().getTotalCopy() == 0)
            {
                System.out.println("Book taken");
            }
           // booksRequested.add(librarian.give(borrow));
        }
        //return booksRequested;
    }
}
