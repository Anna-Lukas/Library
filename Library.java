import org.w3c.dom.ls.LSOutput;

public class Library {

    public static void main(String[] args) {

    final String appName = "Biblioteka v0.2";

    Book book1 = new Book ();
    book1.title = "W pustyni i w puszczy";
    book1.writer = "Henryk Sienskiewicz";
    book1.releaseYear = 2011;
    book1.pagesAmount = 234;
    book1.publishingHouse = "GREG";
    book1.ISBN = "09878798767896";


        System.out.println (appName);
        System.out.println ("W Bibliotece aktualnie znajdują się książki: ");
        System.out.println (book1.title);
        System.out.println (book1.writer);
        System.out.println (book1.releaseYear);
        System.out.println (book1.pagesAmount);
        System.out.println (book1.publishingHouse);
        System.out.println (book1.ISBN);

    }
}
