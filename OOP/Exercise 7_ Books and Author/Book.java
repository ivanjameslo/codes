import java.util.*;

public class Book {
    private String title;
    public ArrayList<Author> author = new ArrayList<>();
    protected int authorSize = author.size();

    public Book(String title) {
        this.title = title;
    }

    public void addAuthor(Author author) {
        this.author.add(author);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String toString() {
        return "TITLE: " + title;
    }

    // additional methods
    public List<Author> getAuthors(){
        return author;
    }
}