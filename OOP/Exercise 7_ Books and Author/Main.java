import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws Exception {

        ArrayList<Person> authors = new ArrayList<>();
        ArrayList<Book> book = new ArrayList<>();

        boolean selection = true;
        String menuItems = "y";

        while (selection) {
            System.out.println("-----------------------------------------------");
            System.out.println("A: Add Authors");
            System.out.println("B: Add Book and assign Authors");
            System.out.println("C: View Books and Authors");
            System.out.println("D: View Authors and Books");
            System.out.println("Q: Quit");
            System.out.print("Enter choice: ");
            menuItems = input.nextLine();
            System.out.println("-----------------------------------------------");

            switch (menuItems.toUpperCase()) {
                case "A":
                    addAuthors(authors);
                    break;
                case "B":
                    addBook(authors, book);
                    break;
                case "C":
                    bookAndAuthor(book);
                    break;
                case "D":
                    authorAndBook(authors, book);
                    break;
                case "Q":
                    selection = false;
                    break;

            }
        }

        input.close();
    }

    public static void addAuthors(ArrayList<Person> authors) {
        String authorName;

        System.out.print("Enter Author Name: ");
        authorName = input.nextLine();

        Author author = new Author(authorName);     // create an author object with authorName
        authors.add(author);                        // add the object to the array

        System.out.println("Added author: " + authorName);
    }

    public static void addBook(ArrayList<Person> authors, ArrayList<Book> book) {
        String bookTitle;
        String authorName;

        System.out.print("Enter Book Title: ");
        bookTitle = input.nextLine();
        Book newBook = new Book(bookTitle);         // create a book object

        System.out.println("***********************************************");
        System.out.println("Select from the list the Author of the book.");
        for (int i = 0; i < authors.size(); i++) {
             System.out.println("> " + authors.get(i));
        }
        System.out.println("***********************************************");

        while(true){
            System.out.print("Enter Author Name (X to terminate): ");
            authorName = input.nextLine();

            if (authorName.equalsIgnoreCase("X")){
                break;
            }
            else{
                Person a = new Author(authorName); // create a person object which extends to the author 

                boolean authorExist = false;
                for (int i = 0; i < authors.size(); i++){
                    if (authors.get(i).getName().equals(authorName)){
                        newBook.addAuthor((Author) a);
                        authorExist = true;
                        break;
                    }
                }

                if (!authorExist){
                    System.out.println("Author is not part of the list.");
                }
            }
        }
        book.add(newBook);                          // add all information to the book array
    }

    public static void bookAndAuthor(ArrayList<Book> book){
        System.out.println("BOOKS AND THEIR AUTHORS");
        
        System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
        for (Book b: book){
            System.out.println(b);
            System.out.println("AUTHOR/S: ");

            for (Author author : b.getAuthors()){
                System.out.println("> " + author.getName());
            }
            System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
        }
    }

    public static void authorAndBook(ArrayList<Person> authors, ArrayList<Book> book){
        System.out.println("AUTHORS AND THEIR BOOKS");

        System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
        for (Person a : authors){
            System.out.println("AUTHOR: " + a.getName());
            System.out.println("BOOKS: ");

            for (Book b : book){
                for (Author bAuthor : b.getAuthors()){
                    if (String.valueOf(bAuthor).equals(a.getName())){
                        System.out.println("> " + b.getTitle());
                    }
                }
            }
            System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
        }
    }
}