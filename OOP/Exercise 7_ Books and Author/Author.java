import java.util.*;

public class Author extends Person {

    public ArrayList<Book> book = new ArrayList<>();

    public Author(String name) {
        super(name);
    }
}