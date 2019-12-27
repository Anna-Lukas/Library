import org.w3c.dom.ls.LSOutput;
class Library {

    public static void main(String[] args) {

    final String appName = "Biblioteka v0.3";

    Book book1 = new Book ("W pustyni i w puszczy","Henryk Sienskiewicz",2011,
                          234,"GREG","09878798767896" );
    Book book2 = new Book ("Rok Dobrych myśli","Beata Pawlikowska",2019,
                            365,"EDIPRESSE","88555543333455" );
    Book book3 = new Book ("Mandale Kolorwanie  i Bazgranie","Odeta Redo",2015,
                            79,"OLESIEJUK","97883274397722" );


    System.out.println (appName);
    System.out.println ("W Bibliotece aktualnie znajdują się książki: ");
    book1.InfoBookPrinter();
    book2.InfoBookPrinter();
    book3.InfoBookPrinter();




    }
}
