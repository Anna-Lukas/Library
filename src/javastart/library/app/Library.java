package src.javastart.library.app;
import src.javastart.library.model.Book;


class Library {

    public static void main(String[] args) {

    final String appName = "Biblioteka v0.7";

    Book [] books = new Book[1000];
    books[0]= new Book("W pustyni i w puszczy","Henryk Sienskiewicz",2011,  234,"GREG","09878798767896" );
        books[1]=new Book ("Rok Dobrych myśli","Beata Pawlikowska",2019, 365,"EDIPRESSE","88555543333455" );
        books[2]=new Book ("Mandale Kolorwanie  i Bazgranie","Odeta Redo",2015, 79,"OLESIEJUK");

        System.out.println (appName);
    System.out.println(books[0].getPublishingHouse());
    System.out.println ("W Bibliotece aktualnie znajdują się książki: ");
    books[0].InfoBookPrinter();
    books[1].InfoBookPrinter();
    books[2].InfoBookPrinter();
        System.out.println("W tablicy books znajduje się: "+ books.length+ "ksiązek.");
    }
}
